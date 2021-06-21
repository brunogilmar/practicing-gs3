package br.com.abreutech.sgc.service.impl;

import br.com.abreutech.sgc.controller.filter.ClienteFilter;
import br.com.abreutech.sgc.exception.RegistroDuplicadoException;
import br.com.abreutech.sgc.exception.RegistroNaoExisteException;
import br.com.abreutech.sgc.modelo.Cliente;
import br.com.abreutech.sgc.repository.ClienteRepository;
import br.com.abreutech.sgc.repository.specification.ClienteSpecification;
import br.com.abreutech.sgc.service.ClienteService;
import br.com.abreutech.sgc.service.EmailService;
import br.com.abreutech.sgc.service.TelefoneService;
import br.com.abreutech.sgc.service.UsuarioLogadoService;
import br.com.abreutech.sgc.util.AppUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final static String MSG_REGISTRO_NAO_ENCONTRADO = "Cliente não encontrado";
    private final static String MSG_REGISTRO_DUPLICADO = "Operação não realizada, cliente já cadastrado.";

    private static final LocalDateTime HORA_ACAO = LocalDateTime.now();

    private final ClienteRepository repository;
    private final TelefoneService telefoneService;
    private final EmailService emailService;
    private final UsuarioLogadoService usuarioLogadoService;

    ClienteServiceImpl(
            ClienteRepository repository,
            TelefoneService telefoneService,
            EmailService emailService,
            UsuarioLogadoService usuarioLogadoService) {
        this.repository = repository;
        this.telefoneService = telefoneService;
        this.emailService = emailService;
        this.usuarioLogadoService = usuarioLogadoService;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public Cliente findById(Long id) {
        Optional<Cliente> optional = repository.findById(id);

        if( !optional.isPresent() ) {
            throw new RegistroNaoExisteException(MSG_REGISTRO_NAO_ENCONTRADO);
        }
        return optional.get();
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public Cliente save(Cliente cliente) {
        if (cliente.getId() != null) update(cliente);
        validaDuplicidadeSave(cliente);
        ajustarRegistro(cliente);
        ajustarRegistroSave(cliente);
        return repository.save(cliente);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public Cliente update(Cliente cliente) {
        if (cliente.getId() == null) save(cliente);
        Cliente entity = findById(cliente.getId());
        validaDuplicidadeUpdate(cliente);
        ajustarRegistro(cliente);
        ajustarRegistroUpdate(cliente);

        cliente.setCriadoEm(entity.getCriadoEm());
        cliente.setQuemCriou(entity.getQuemCriou());
        return repository.save(cliente);
    }

    @Override
    @Transactional
    public Page<Cliente> search(ClienteFilter filtro, Pageable paginacao) {
        Specification<Cliente> especificacao = Specification.where(
                ClienteSpecification.pesquisaDefault(filtro));
        return repository.findAll(especificacao, paginacao);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }


    //VALIDAÇÕES
    private void validaDuplicidadeSave(Cliente cliente) {
        boolean cadastroNovo = repository.countAllByCpfAndAtivo(
                cliente.getCpf(), cliente.getAtivo()) > 0;
        exceptionDuplicado(cadastroNovo);
    }

    private void validaDuplicidadeUpdate(Cliente cliente) {
        boolean cadastroExistente = repository.countAllByIdNotAndCpfAndAtivo(
                cliente.getId(), cliente.getCpf(), cliente.getAtivo()) > 0;
        exceptionDuplicado(cadastroExistente);
    }

    private void ajustarRegistro(Cliente cliente) {
        setClienteTelefone(cliente);
        setClienteEmail(cliente);
        validaTelefone(cliente);
        validaEmail(cliente);
        removeMascara(cliente);
    }

    private void ajustarRegistroSave(Cliente cliente) {
        cliente.setCriadoEm(HORA_ACAO);
        cliente.setQuemCriou(usuarioLogadoService.recuperaDadosUsuarioLogado());
    }

    private void ajustarRegistroUpdate(Cliente cliente) {
        cliente.setAlteradoEm(HORA_ACAO);
        cliente.setQuemAlterou(usuarioLogadoService.recuperaDadosUsuarioLogado());
    }

    private void exceptionDuplicado(boolean registroDuplicado) {
        if (registroDuplicado)
            throw new RegistroDuplicadoException(MSG_REGISTRO_DUPLICADO);
    }

    private void removeMascara(Cliente cliente) {
        cliente.setCpf(AppUtil.removeMascara(cliente.getCpf()));
        cliente.getTelefoneList().forEach(t -> {
            t.setTelefone(AppUtil.removeMascara(t.getTelefone()));
        });
        cliente.getEndereco().setCep(AppUtil.removeMascara(cliente.getEndereco().getCep()));
    }

    private void validaEmail(Cliente cliente) {
        emailService.validaSeExisteItem(cliente.getEmailList());
    }

    private void validaTelefone(Cliente cliente) {
        telefoneService.validaSeExisteItem(cliente.getTelefoneList());
    }

    private void setClienteEmail(Cliente cliente) {
        cliente.getEmailList().forEach(e -> {
            e.setCliente(cliente);
        });
    }

    private void setClienteTelefone(Cliente cliente) {
        cliente.getTelefoneList().forEach(e -> {
            e.setCliente(cliente);
        });
    }

}
