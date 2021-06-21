package br.com.abreutech.sgc.controller.form;

import br.com.abreutech.sgc.modelo.TipoTelefone;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TelefoneForm extends EntidadeForm {

    @NotEmpty
    private TipoTelefone tipo;

    @Size(min = 10, max = 11)
    @NotEmpty
    private String telefone;

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
