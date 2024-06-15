/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

/**
 *
 * @author Wesley
 */
import java.sql.Date;

/**
 *
 * @author Wesley
 */
public class EntradaVeiculo {
    
    Integer id;
    String nome_proprietario = "";
    Date data_entrada = null;
    String marca = "";
    String modelo = "";
    String cor = "";
    String placa = "";
    String renavam = "";
    String chassi = "";
    Integer id_municipio;
    String telefone= "";
    String whatsapp = "";
    String ano = "" ;
    public static boolean janelaNovaEntrada = false;
    public static boolean janelaEditarEntrada = false; 
    public static boolean janelaListarEntrada = false;
    public static boolean janelaPesquisarEntrada = false;
    
    String usuario = "";
    String cidade = "";
    
     public EntradaVeiculo() {
    }
     
     public EntradaVeiculo(
             Integer    id, 
             String     nome_proprietario, 
             Date       data_entrada, 
             String     marca, 
             String     modelo, 
             String     cor, 
             String     placa,
             String     renavam,
             String     chassi,
             Integer    id_municipio,
             String     usuario,
             String     ano,
             String     telefone,
             String     whatsapp
     
     ){
       this.id = id;
       this.nome_proprietario = nome_proprietario;
       this.data_entrada = data_entrada;
       this.marca = marca;
       this.modelo = modelo;
       this.cor = cor;
       this.placa = placa;
       this.renavam = renavam;
       this.chassi = chassi;
       this.id_municipio = id_municipio;
       this.usuario = usuario;
       this.ano = ano;
       this.telefone = telefone;
       this.whatsapp = whatsapp;
     }
     public EntradaVeiculo(
           
             String     nome_proprietario, 
             Date       data_entrada, 
             String     marca, 
             String     modelo, 
             String     cor, 
             String     placa,
             String      renavam,
             String     chassi,
             String     cidade,             
             String     ano,
             String     telefone,
             String     whatsapp
     
     ){
       this.nome_proprietario = nome_proprietario;
       this.data_entrada = data_entrada;
       this.marca = marca;
       this.modelo = modelo;
       this.cor = cor;
       this.placa = placa;
       this.renavam = renavam;
       this.chassi = chassi;
       this.cidade = cidade;     
       this.ano = ano;
       this.telefone = telefone;
       this.whatsapp = whatsapp;
     }
     
     public EntradaVeiculo(
           
             String     nome_proprietario, 
             Date       data_entrada, 
             String     marca, 
             String     modelo, 
             String     cor, 
             String     placa,
             String      renavam,
             String     chassi,           
             String     ano,
             String     telefone,
             String     whatsapp
     
     ){
       this.nome_proprietario = nome_proprietario;
       this.data_entrada = data_entrada;
       this.marca = marca;
       this.modelo = modelo;
       this.cor = cor;
       this.placa = placa;
       this.renavam = renavam;
       this.chassi = chassi;
       this.ano = ano;
       this.telefone = telefone;
       this.whatsapp = whatsapp;
     }
     
     
     public EntradaVeiculo(
           
             String     nome_proprietario, 
             Date       data_entrada, 
             String     marca, 
             String     modelo, 
             String     cor, 
             String     placa,
             String      renavam,
             String     chassi,
             Integer     id_municipio,             
             String     ano,
             String     telefone,
             String     whatsapp
     
     ){
       this.nome_proprietario = nome_proprietario;
       this.data_entrada = data_entrada;
       this.marca = marca;
       this.modelo = modelo;
       this.cor = cor;
       this.placa = placa;
       this.renavam = renavam;
       this.chassi = chassi;
       this.id_municipio = id_municipio;     
       this.ano = ano;
       this.telefone = telefone;
       this.whatsapp = whatsapp;
     }
     

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_proprietario() {
        return nome_proprietario;
    }

    public void setNome_proprietario(String nome_proprietario) {
        this.nome_proprietario = nome_proprietario;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    
}
