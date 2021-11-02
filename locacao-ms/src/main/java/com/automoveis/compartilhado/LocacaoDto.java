package com.automoveis.compartilhado;

import java.util.List;

import com.automoveis.locacaoms.model.Locacao;

public class LocacaoDto {

    private String id;
    private String idCliente;
    private String idVeiculo;
    private String numDiasLocacao;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public String getIdVeiculo() {
        return idVeiculo;
    }
    public void setIdVeiculo(String idVeiculo) {
        this.idVeiculo = idVeiculo;
    }
    public String getNumDiasLocacao() {
        return numDiasLocacao;
    }
    public void setNumDiasLocacao(String numDiasLocacao) {
        this.numDiasLocacao = numDiasLocacao;
    }
    public void setIdCliente(List<Locacao> obter) {
    }
 
    
}