package br.com.abreutech.sgc.controller.dto;

import br.com.abreutech.sgc.modelo.TipoTelefone;

public class TelefoneDto {

	private Long id;
	private TipoTelefone tipo;
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
