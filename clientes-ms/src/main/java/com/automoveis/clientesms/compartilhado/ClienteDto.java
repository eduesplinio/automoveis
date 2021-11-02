package com.automoveis.clientesms.compartilhado;

import java.util.List;

public class ClienteDto {

   private String id;
   private String nome;
   private double cpf;
   private double cnh;
   private double dataNascimento;
   private List<Locacao> Locacao;

   public List<Locacao> getLocacao() {
       return Locacao;
   }

   public void setLocacao(List<Locacao> Locacao) {
       this.Locacao = Locacao;
   }
   
//#region Get and Setters
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
public double getCpf() {
    return cpf;
}
public void setCpf(double cpf) {
    this.cpf = cpf;
}
public double getCnh() {
    return cnh;
}
public void setCnh(double cnh) {
    this.cnh = cnh;
}
public double getDataNascimento() {
    return dataNascimento;
}
public void setDataNascimento(double dataNascimento) {
    this.dataNascimento = dataNascimento;
}
//#endregion

}
