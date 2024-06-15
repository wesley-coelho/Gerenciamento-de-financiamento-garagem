/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import java.sql.Date;

/**
 *
 * @author Wesley
 */
public class SaidaVeiculo {
    
    Integer     id;
    Date        data_saida;
    String       usuario;
    Integer     id_cliente;
    Integer     id_entrada;
    Integer     id_financiamento;
    public static boolean janelaNovaSaida = false;
    public static boolean janelaListarSaidas = false;
    public static boolean janelaPesquisarSaida = false;
    EntradaVeiculo entrada;

    public SaidaVeiculo(Date data_saida, String usuario, Integer id_cliente, Integer id_entrada, Integer id_financiamento) {
        this.data_saida = data_saida;
        this.usuario = usuario;
        this.id_cliente = id_cliente;
        this.id_entrada = id_entrada;
        this.id_financiamento = id_financiamento;
    }
    
    public SaidaVeiculo(Integer id, Date data_saida, String usuario, Integer id_cliente, Integer id_entrada, Integer id_financiamento) {
        this.id = id;
        this.data_saida = data_saida;
        this.usuario = usuario;
        this.id_cliente = id_cliente;
        this.id_entrada = id_entrada;
        this.id_financiamento = id_financiamento;
    }
    
    public SaidaVeiculo(Date data_saida, EntradaVeiculo entrada) {
        this.data_saida = data_saida;
        this.entrada = entrada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_entrada() {
        return id_entrada;
    }

    public void setId_entrada(Integer id_entrada) {
        this.id_entrada = id_entrada;
    }

    public Integer getId_financiamento() {
        return id_financiamento;
    }

    public void setId_financiamento(Integer id_financiamento) {
        this.id_financiamento = id_financiamento;
    }

    public EntradaVeiculo getEntrada() {
        return entrada;
    }

    public void setEntrada(EntradaVeiculo entrada) {
        this.entrada = entrada;
    }
    
    
}

