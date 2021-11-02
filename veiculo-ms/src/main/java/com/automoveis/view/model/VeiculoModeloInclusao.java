package com.automoveis.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class VeiculoModeloInclusao {
    private String id;
    private String marca;
    @NotBlank(message = "A marca deve possuir caracteres não brancos.")
    @NotEmpty(message = "A marca do automóvel deve ser preenchida.")
    private String modelo;
    @NotBlank(message = "O modelo do automóvel deve possuir caracteres não brancos.")
    @NotEmpty(message = "O modelo do automóvel deve ser preenchido.")
    private double numPassageiros;

    //#region Getters and Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getNumPassageiros() {
        return numPassageiros;
    }
    public void setNumPassageiros(double numPassageiros) {
        this.numPassageiros = numPassageiros;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    private double valor;
    //#endregion

}
