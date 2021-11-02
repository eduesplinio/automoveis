package com.automoveis.locacaoms.view.model;

import java.util.List;

import com.automoveis.compartilhado.Cliente;

public class ClienteModeloResponseDetalhes {
    private String id;
    private String nome;
    private String cpf;
    private String cnh;
    private String dataNascimento;
    private List<Cliente> cliente;
 
 public List<Cliente> getlocacao() {
        return cliente;
        
//#region Get and Setters
    }
public void setlocacao(List<Cliente> cliente) {
    this.cliente = cliente;
}
 public String getId() {
     return id;
 }
 public void setId(String id) {
     this.id = id;
 }
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
 public String getCnh() {
     return cnh;
 }
 public void setCnh(String cnh) {
     this.cnh = cnh;
 }
 public String getDataNascimento() {
     return dataNascimento;
 }
 public void setDataNascimento(String dataNascimento) {
     this.dataNascimento = dataNascimento;
 }
 //#endregion
 
 }
