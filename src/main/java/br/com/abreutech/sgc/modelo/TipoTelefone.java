package br.com.abreutech.sgc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "td_tipo_telefone")
public class TipoTelefone {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cd_tipo_telefone")
	private Long id;

	@Column(name = "ds_tipo_telefone")
	private String descricao;

	@Column(name = "st_ativo")
	private Boolean ativo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
