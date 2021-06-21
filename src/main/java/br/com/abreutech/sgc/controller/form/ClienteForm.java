package br.com.abreutech.sgc.controller.form;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

public class ClienteForm extends EntidadeForm {

    @Size(min = 3, max = 100)
    @NotEmpty
    private String nome;

    @CPF
    @NotEmpty
    private String cpf;

    private EnderecoForm endereco;

    private List<TelefoneForm> telefoneList;

    private List<EmailForm> emailList;

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

    public EnderecoForm getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoForm endereco) {
        this.endereco = endereco;
    }

    public List<TelefoneForm> getTelefoneList() {
        return telefoneList;
    }

    public void setTelefoneList(List<TelefoneForm> telefoneList) {
        this.telefoneList = telefoneList;
    }

    public List<EmailForm> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<EmailForm> emailList) {
        this.emailList = emailList;
    }

}
