package com.automoveis.veiculosms.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Veiculo {
    @Id
    private String id;
    private String marca;
    private String modelo;
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