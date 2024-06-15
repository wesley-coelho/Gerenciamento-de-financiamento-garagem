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
public class Financiamento {
    //properties
    Integer     id;
    Integer     ficha;
    Date        data_registro;
    String      nome_cliente;
    String      placa;
    Double      valor_parcela;
    Double      valor_pago_entrada;
    Double      valor_veiculo;
    Integer     num_parcelas;
    Integer     dia_vencimento;
    Integer     id_cliente;
    String      oberservacao;
    public static boolean janelaNovoFinanciamento = false;
    public static boolean janelaEditarFinanciamento = false;
    public static boolean janelaListaTodosFinanciamento = false;
    public static boolean janelaPesquisaFinanciamento = false;
    
    //constructor
    public Financiamento(Date data_registro, Integer ficha, Double valor_parcela, Double valor_pago_entrada, Double valor_veiculo, Integer num_parcelas, Integer dia_vencimento, Integer id_cliente, String oberservacao) {
        this.data_registro = data_registro;
        this.ficha = ficha;
        this.valor_parcela = valor_parcela;
        this.valor_pago_entrada = valor_pago_entrada;
        this.valor_veiculo = valor_veiculo;
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.id_cliente = id_cliente;
        this.oberservacao = oberservacao;
    }
    //constructor
    public Financiamento(Integer id, Date data_registro, Integer ficha, Double valor_parcela, Double valor_pago_entrada, Double valor_veiculo, Integer num_parcelas, Integer dia_vencimento, Integer id_cliente, String oberservacao) {
        this.id = id;
        this.data_registro = data_registro;
        this.ficha = ficha;
        this.valor_parcela = valor_parcela;
        this.valor_pago_entrada = valor_pago_entrada;
        this.valor_veiculo = valor_veiculo;
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.id_cliente = id_cliente;
        this.oberservacao = oberservacao;
    }
    public Financiamento(Integer id, Integer ficha,Date data_registro, String nome_cliente, String placa, Double valor_veiculo,  Double valor_pago_entrada, Double valor_parcela, Integer num_parcelas,  Integer dia_vencimento, String oberservacao) {
        this.id = id;
        this.ficha = ficha;
        this.data_registro = data_registro;
        this.nome_cliente = nome_cliente;
        this.placa = placa;
        this.valor_veiculo = valor_veiculo;
        this.valor_pago_entrada = valor_pago_entrada;
        this.valor_parcela = valor_parcela;        
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.oberservacao = oberservacao;
    }

    //getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_registro() {
        return data_registro;
    }

    public Integer getFicha() {
        return ficha;
    }

    public void setFicha(Integer ficha) {
        this.ficha = ficha;
    }   
    

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }

    public Double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(Double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    public Double getValor_pago_entrada() {
        return valor_pago_entrada;
    }

    public void setValor_pago_entrada(Double valor_pago_entrada) {
        this.valor_pago_entrada = valor_pago_entrada;
    }

    public Double getValor_veiculo() {
        return valor_veiculo;
    }

    public void setValor_veiculo(Double valor_veiculo) {
        this.valor_veiculo = valor_veiculo;
    }

    public Integer getNum_parcelas() {
        return num_parcelas;
    }

    public void setNum_parcelas(Integer num_parcelas) {
        this.num_parcelas = num_parcelas;
    }

    public Integer getDia_vencimento() {
        return dia_vencimento;
    }

    public void setDia_vencimento(Integer dia_vencimento) {
        this.dia_vencimento = dia_vencimento;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getOberservacao() {
        return oberservacao;
    }

    public void setOberservacao(String oberservacao) {
        this.oberservacao = oberservacao;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
    
}

