package br.com.abreutech.sgc.service;


import br.com.abreutech.sgc.controller.dto.EnderecoDto;

public interface CepService {

    EnderecoDto findByCep(String cep);

}
