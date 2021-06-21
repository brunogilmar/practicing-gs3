package br.com.abreutech.sgc.service;


import br.com.abreutech.sgc.modelo.Email;

import java.util.List;

public interface EmailService {

    void validaSeExisteItem(List<Email> emailList);

}
