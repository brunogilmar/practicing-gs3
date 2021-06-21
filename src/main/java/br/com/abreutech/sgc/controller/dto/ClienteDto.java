package br.com.abreutech.sgc.controller.dto;

import java.util.List;

public class ClienteDto extends EntidadeDto {

	private String nome;
	private String cpf;
	private EnderecoDto endereco;
	private List<TelefoneDto> telefoneList;
	private List<EmailDto> emailList;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EnderecoDto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDto endereco) {
		this.endereco = endereco;
	}

	public List<TelefoneDto> getTelefoneList() {
		return telefoneList;
	}

	public void setTelefoneList(List<TelefoneDto> telefoneList) {
		this.telefoneList = telefoneList;
	}

	public List<EmailDto> getEmailList() {
		return emailList;
	}

	public void setEmailList(List<EmailDto> emailList) {
		this.emailList = emailList;
	}
}
