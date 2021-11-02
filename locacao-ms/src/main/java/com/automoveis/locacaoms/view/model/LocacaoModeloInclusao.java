package com.automoveis.locacaoms.view.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.automoveis.compartilhado.Cliente;
import com.automoveis.compartilhado.Veiculo;

public class LocacaoModeloInclusao {

    private String id;
    private String idVeiculo;
    private String idCliente;
    @NotBlank(message = "O número de dias deve possuir caracteres não brancos.")
    @NotEmpty(message = "O número de dias da locação deve ser preenchido.")
    private String numDiasLocacao;
    
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
   


}