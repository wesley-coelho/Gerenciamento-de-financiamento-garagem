/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Wesley
 */
public class Parcelamento {
    Integer id;
    Date data_pagamento;
    Double valor_pagamento;
    Integer id_financiamento;
    Date mes_ref;
    Boolean ispago;
    public static boolean janelaPagamento = false;
    

    public Parcelamento(Integer id, Date data_pagamento, Double valor_pagamento, Integer id_financiamento, Date mes_ref) {
        this.id = id;
        this.data_pagamento =data_pagamento;
        this.valor_pagamento = valor_pagamento;
        this.id_financiamento = id_financiamento;
        this.mes_ref = mes_ref;
    }

    public Parcelamento(Date data_pagamento, Double valor_pagamento, Integer id_financiamento, Date mes_ref, Boolean ispago) {
        this.data_pagamento = data_pagamento;
        this.valor_pagamento = valor_pagamento;
        this.id_financiamento = id_financiamento;
        this.mes_ref = mes_ref;
        this.ispago = ispago;
    }

    public Parcelamento(Integer id, Date data_pagamento, Double valor_pagamento, Integer id_financiamento, Date mes_ref, Boolean ispago) {
        this.id = id;
        this.data_pagamento = data_pagamento;
        this.valor_pagamento = valor_pagamento;
        this.id_financiamento = id_financiamento;
        this.mes_ref = mes_ref;
        this.ispago = ispago;
    }
    
    

    public Parcelamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        if( data_pagamento != null ){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(data_pagamento, dtf);
            this.data_pagamento = java.sql.Date.valueOf(data);
        }else{
            this.data_pagamento = null;
        }
           
    }

    public Double getValor_pagamento() {
        return valor_pagamento;
    }

    public void setValor_pagamento(Double valor_pagamento) {
        this.valor_pagamento = valor_pagamento;
    }

    public Integer getId_financiamento() {
        return id_financiamento;
    }

    public void setId_financiamento(Integer id_financiamento) {
        this.id_financiamento = id_financiamento;
    }

    public Date getMes_ref() {
        return mes_ref;
    }

    public void setMes_ref(Date mes_ref) {
        this.mes_ref = mes_ref;
    }

    public Boolean getIsPago() {
        return ispago;
    }

    public void setIsPago(Boolean ispago) {
        this.ispago = ispago;
    }

   
    
    
    
}

