package com.automoveis.veiculosms.compartilhado;

public class Locacao {
    private String id;
    private String idVeiculo;
    private String idCliente;
    private String numDiasLocacao;

    //#region Getters and setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public String getNumDiasLocacao() {
        return numDiasLocacao;
    }
    public void setNumDiasLocacao(String numDiasLocacao) {
        this.numDiasLocacao = numDiasLocacao;
    }
    //#endregion
    
}
