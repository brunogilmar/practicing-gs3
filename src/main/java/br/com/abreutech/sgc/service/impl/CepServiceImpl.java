package br.com.abreutech.sgc.service.impl;

import br.com.abreutech.sgc.controller.dto.EnderecoDto;
import br.com.abreutech.sgc.exception.RegistroNaoExisteException;
import br.com.abreutech.sgc.service.CepService;
import br.com.abreutech.sgc.util.AppUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class CepServiceImpl implements CepService {

    private final static String MSG_REGISTRO_NAO_ENCONTRADO = "CEP não encontrado.";

    @Value("${api.viacep.url}")
    private String url;


    @Override
    public EnderecoDto findByCep(String nuCep) {

        UriComponentsBuilder builder = getUriBuilder(AppUtil.removeMascara(nuCep));

        RestTemplate restTemplate = new RestTemplate();
        Optional<EnderecoDto> optional = Optional.ofNullable(
                restTemplate.getForObject(builder.toUriString(), EnderecoDto.class));

        if(!optional.isPresent()) {
            throw new RegistroNaoExisteException(MSG_REGISTRO_NAO_ENCONTRADO);
        }

        return optional.get();
    }

    private UriComponentsBuilder getUriBuilder(String nuCep) {
        return UriComponentsBuilder.fromUriString(url).path("/ws/").path(nuCep).path("/json");
    }

}