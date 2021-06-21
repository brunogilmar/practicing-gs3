package br.com.abreutech.sgc.controller.form;

import java.time.LocalDateTime;

public class EntidadeForm {

    protected Integer id;
    protected Boolean ativo = true;
    protected String quemCriou;
    protected String quemAlterou;
    protected LocalDateTime criadoEm;
    protected LocalDateTime alteradoEm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getQuemCriou() {
        return quemCriou;
    }

    public void setQuemCriou(String quemCriou) {
        this.quemCriou = quemCriou;
    }

    public String getQuemAlterou() {
        return quemAlterou;
    }

    public void setQuemAlterou(String quemAlterou) {
        this.quemAlterou = quemAlterou;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(LocalDateTime alteradoEm) {
        this.alteradoEm = alteradoEm;
    }

}
