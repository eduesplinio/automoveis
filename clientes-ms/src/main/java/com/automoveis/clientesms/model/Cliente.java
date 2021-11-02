package com.automoveis.clientesms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Cliente {
    @Id
   private String id;
   private String nome;
   private String cpf;
   private String cnh;
   private String dataNascimento;

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
