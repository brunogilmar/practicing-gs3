package br.com.abreutech.sgc.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EnderecoForm {

    private Long id;

    @Size(min = 8, max = 8)
    @NotEmpty
    private String cep;

    @Size(max = 100)
    @NotEmpty
    private String logradouro;

    @Size(max = 100)
    @NotEmpty
    private String bairro;

    @Size(max = 100)
    @NotEmpty
    private String localidade;

    @Size(min = 2, max = 2)
    @NotEmpty
    private String uf;

    @Size(max = 100)
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
