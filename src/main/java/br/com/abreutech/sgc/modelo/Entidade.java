package br.com.abreutech.sgc.modelo;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
public class Entidade {

    @NotNull
    @Column(name = "st_ativo")
    protected Boolean ativo;

    @NotNull
    @Column(name = "usuario_create")
    protected String quemCriou;

    @Column(name = "usuario_update")
    protected String quemAlterou;

    @NotNull
    @Column(name = "dh_inclusao")
    protected LocalDateTime criadoEm;

    @Column(name = "dh_alteracao")
    protected LocalDateTime alteradoEm;

    @Column(name = "dh_exclusao")
    protected LocalDateTime excluidoEm;

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

    public LocalDateTime getExcluidoEm() {
        return excluidoEm;
    }

    public void setExcluidoEm(LocalDateTime excluidoEm) {
        this.excluidoEm = excluidoEm;
    }
}
