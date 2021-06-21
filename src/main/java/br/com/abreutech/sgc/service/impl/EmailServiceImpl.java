package br.com.abreutech.sgc.service.impl;

import br.com.abreutech.sgc.exception.RegistroNaoExisteException;
import br.com.abreutech.sgc.modelo.Email;
import br.com.abreutech.sgc.service.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    private final static String MSG_LISTA_SEM_ITEM = "Pelo menos um e-mail deve ser cadastrado";


    @Override
    public void validaSeExisteItem(List<Email> emailList) {

        if(emailList.size() <= 0)
            throw new RegistroNaoExisteException(MSG_LISTA_SEM_ITEM);

    }

}
