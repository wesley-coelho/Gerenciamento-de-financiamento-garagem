/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Wesley
 */
public class Parcelamento {
    Integer id;
    ObjectId idMongo;
    LocalDate data_pagamento;
    Double valor_pagamento;
    ObjectId id_financiamento;
    Integer id_financiamentoPostgres;
    LocalDate mes_ref;
    Boolean ispago;
    Boolean isCanceled;
    public static boolean janelaPagamento = false;
    

    public Parcelamento(ObjectId idMongo, LocalDate data_pagamento, Double valor_pagamento, ObjectId id_financiamento, LocalDate mes_ref) {
        this.idMongo = idMongo;
        this.data_pagamento =data_pagamento;
        this.valor_pagamento = valor_pagamento;
        this.id_financiamento = id_financiamento;
        this.mes_ref = mes_ref;
    }

    public Parcelamento(LocalDate data_pagamento, Double valor_pagamento, ObjectId id_financiamento, LocalDate mes_ref, Boolean ispago, Boolean isCanceled) {
        this.data_pagamento = data_pagamento;
        this.valor_pagamento = valor_pagamento;
        this.id_financiamento = id_financiamento;
        this.mes_ref = mes_ref;
        this.ispago = ispago;
        this.isCanceled = isCanceled;
    }

    public Parcelamento(ObjectId idMongo, LocalDate data_pagamento, Double valor_pagamento, ObjectId id_financiamento, LocalDate mes_ref, Boolean ispago, Boolean isCanceled) {
        this.idMongo = idMongo;
        this.data_pagamento = data_pagamento;
        this.valor_pagamento = valor_pagamento;
        this.id_financiamento = id_financiamento;
        this.mes_ref = mes_ref;
        this.ispago = ispago;
        this.isCanceled = isCanceled;
    }
    
    public Parcelamento(Integer id, LocalDate data_pagamento, Double valor_pagamento, Integer id_financiamentoPostgres, LocalDate mes_ref, Boolean ispago, Boolean isCanceled) {
        this.id = id;
        this.data_pagamento = data_pagamento;
        this.valor_pagamento = valor_pagamento;
        this.id_financiamentoPostgres = id_financiamentoPostgres;
        this.mes_ref = mes_ref;
        this.ispago = ispago;
        this.isCanceled = isCanceled;
    }
    
    

    public Parcelamento() {
    }

    public Integer getId() {
        return id;
    }
   

    public void setId(Integer id) {
        this.id = id;
    }

    public ObjectId getIdMongo() {
        return idMongo;
    }

    public void setIdMongo(ObjectId idMongo) {
        this.idMongo = idMongo;
    }

    public Boolean getIspago() {
        return ispago;
    }

    public void setIspago(Boolean ispago) {
        this.ispago = ispago;
    }
    
    

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        if( data_pagamento != null ){
            this.data_pagamento = data_pagamento;
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

    public ObjectId getId_financiamento() {
        return id_financiamento;
    }

    public void setId_financiamento(ObjectId id_financiamento) {
        this.id_financiamento = id_financiamento;
    }

    public LocalDate getMes_ref() {
        return mes_ref;
    }

    public void setMes_ref(LocalDate mes_ref) {
        this.mes_ref = mes_ref;
    }

    public Boolean getIsPago() {
        return ispago;
    }

    public void setIsPago(Boolean ispago) {
        this.ispago = ispago;
    }

    public Boolean getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Boolean isCanceled) {
        this.isCanceled = isCanceled;
    }

    public Integer getId_financiamentoPostgres() {
        return id_financiamentoPostgres;
    }

    public void setId_financiamentoPostgres(Integer id_financiamentoPostgres) {
        this.id_financiamentoPostgres = id_financiamentoPostgres;
    }
    
    

   public Document toDocument(){
       Map<String, Object> map = new HashMap<>();
       if( idMongo != null ) map.put("_id", idMongo);
       map.put("data_pagamento", data_pagamento);
       map.put("valor_pagamento", valor_pagamento);
       map.put("id_financiamento", id_financiamentoPostgres);
       map.put("_id_financiamento", id_financiamento);
       map.put("mes_ref", mes_ref);
       map.put("ispago", ispago);
       map.put("iscanceled", isCanceled);       
       return new Document(map);
   }
   
   public void convertToJavaObj(Document doc){
       if( doc != null ){
           idMongo = doc.getObjectId("_id");
           data_pagamento = doc.getDate("data_pagamento") != null ? LocalDate.ofInstant(doc.getDate("data_pagamento").toInstant(), TimeZone.getTimeZone("GMT").toZoneId()) : null;
           valor_pagamento = doc.getDouble("valor_pagamento");
           id_financiamento = doc.getObjectId("_id_financiamento");
           mes_ref = doc.getDate("mes_ref") != null ? LocalDate.ofInstant(doc.getDate("mes_ref").toInstant(),TimeZone.getTimeZone("GMT").toZoneId())  : null;
           ispago = doc.getBoolean("ispago");
           isCanceled  = doc.getBoolean("iscanceled");
       }
       
   }

    @Override
    public String toString() {
        return "Parcelamento{" + "idMongo=" + idMongo + ", data_pagamento=" + data_pagamento + ", valor_pagamento=" + valor_pagamento + ", id_financiamento=" + id_financiamento + ", mes_ref=" + mes_ref + ", ispago=" + ispago + ", isCanceled=" + isCanceled + '}';
    }
    
   
   
}

