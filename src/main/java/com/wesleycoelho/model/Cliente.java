/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

/**
 *
 * @author Wesley
 */
public class Cliente {
    
    Integer     id;
    String      nome;
    String      cpf;
    String      rg;
    String      Cep;
    String      endereco;
    Integer     numero;
    String      bairro;
    String      complemento;
    Integer     id_municipio;
    String      usuario;
    String      whatsapp;
    String      telefone;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String rg, String Cep, String endereco, Integer numero, String bairro, Integer id_municipio, String usuario, String whatsapp, String telefone, String complemento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.Cep = Cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.id_municipio = id_municipio;
        this.usuario = usuario;
        this.whatsapp = whatsapp;
        this.telefone = telefone;
        this.complemento = complemento;
    }
    
    public Cliente(Integer id, String nome, String cpf, String rg, String Cep, String endereco, Integer numero, String bairro, Integer id_municipio, String usuario, String whatsapp, String telefone, String complemento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.Cep = Cep;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.id_municipio = id_municipio;
        this.usuario = usuario;
        this.whatsapp = whatsapp;
        this.telefone = telefone;
        this.complemento = complemento;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String Cep) {
        this.Cep = Cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    
    
}

