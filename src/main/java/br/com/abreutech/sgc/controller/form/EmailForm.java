package br.com.abreutech.sgc.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class EmailForm extends EntidadeForm {

    @Size(max = 100)
    @NotEmpty
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
