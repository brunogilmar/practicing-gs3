package br.com.abreutech.sgc.service.impl;

import br.com.abreutech.sgc.modelo.TipoTelefone;
import br.com.abreutech.sgc.repository.TipoTelefoneRepository;
import br.com.abreutech.sgc.service.TipoTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoTelefoneServiceImpl implements TipoTelefoneService {

    @Autowired
    private TipoTelefoneRepository repository;

    @Override
    public List<TipoTelefone> findAll() {
        return repository.findAll();
    }
}
