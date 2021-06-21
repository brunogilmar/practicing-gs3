package br.com.abreutech.sgc.service;


import br.com.abreutech.sgc.controller.filter.ClienteFilter;
import br.com.abreutech.sgc.modelo.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteService {

    Cliente findById(Long id);

    Cliente save(Cliente cliente);

    Cliente update(Cliente cliente);

    Page<Cliente> search(ClienteFilter filtro, Pageable paginacao);

    void delete(Long id);

}
