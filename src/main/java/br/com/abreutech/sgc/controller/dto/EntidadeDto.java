package br.com.abreutech.sgc.controller.dto;

import java.time.LocalDateTime;

public class EntidadeDto {

    private Integer id;
    private Boolean ativo;
    private String quemCriou;
    private String quemAlterou;
    private LocalDateTime criadoEm;
    private LocalDateTime AlteradoEm;

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
        return AlteradoEm;
    }

    public void setAlteradoEm(LocalDateTime alteradoEm) {
        AlteradoEm = alteradoEm;
    }
}
