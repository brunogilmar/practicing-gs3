package br.com.abreutech.sgc.controller.mapper;

import br.com.abreutech.sgc.controller.dto.ClienteDto;
import br.com.abreutech.sgc.modelo.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<ClienteDto, Cliente> {

}
