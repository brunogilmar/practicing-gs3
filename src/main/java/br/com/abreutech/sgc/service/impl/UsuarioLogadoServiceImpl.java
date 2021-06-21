package br.com.abreutech.sgc.service.impl;

import br.com.abreutech.sgc.service.UsuarioLogadoService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLogadoServiceImpl implements UsuarioLogadoService {


    @Override
    public String recuperaDadosUsuarioLogado() {
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        }
        return null;
    }
}
