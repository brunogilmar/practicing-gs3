package br.com.abreutech.sgc.controller.mapper;

import br.com.abreutech.sgc.controller.form.ClienteForm;
import br.com.abreutech.sgc.modelo.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteFormMapper extends EntityMapper<ClienteForm, Cliente> {

}
