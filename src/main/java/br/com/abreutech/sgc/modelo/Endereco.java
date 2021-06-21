package br.com.abreutech.sgc.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_endereco",
			sequenceName = "sq_tb_endereco_cd_seq_endereco",
			allocationSize = 1
	)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_endereco")
	@Column(name = "cd_seq_endereco")
	private Long id;

	@NotEmpty
	@Size(min = 8, max = 8)
	@Column(name = "nu_cep")
	private String cep;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "ds_logradouro")
	private String logradouro;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "ds_bairro")
	private String bairro;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "ds_cidade")
	private String localidade;

	@NotEmpty
	@Size(max = 100)
	@Column(name = "sg_uf")
	private String uf;

	@Size(max = 100)
	@Column(name = "ds_complemento")
	private String complemento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
