package com.automoveis.clientesms.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClienteModeloRequest {
    @NotBlank(message = "O nome deve possuir caracteres não brancos.")
    @NotEmpty(message = "O nome deve ser preenchido")
    @Size(min = 5, message = "O nome deve ter, no mínimo, 5 caracteres.")
    private String nome;

    // @NotBlank(message = "O cpf deve possuir caracteres não brancos.")
    // @NotEmpty(message = "O cpf deve ser preenchido.")
    private String cpf;

    //#region Getters and Setters
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
    //#endregion
}
