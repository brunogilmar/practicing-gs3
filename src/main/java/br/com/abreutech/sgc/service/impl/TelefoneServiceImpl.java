package br.com.abreutech.sgc.service.impl;

import br.com.abreutech.sgc.exception.RegistroNaoExisteException;
import br.com.abreutech.sgc.modelo.Telefone;
import br.com.abreutech.sgc.service.TelefoneService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    private final static String MSG_LISTA_SEM_ITEM = "Pelo menos um telefone deve ser cadastrado";


    @Override
    public void validaSeExisteItem(List<Telefone> telefoneList) {
        if(telefoneList.size() <= 0)
            throw new RegistroNaoExisteException(MSG_LISTA_SEM_ITEM);

    }

}
