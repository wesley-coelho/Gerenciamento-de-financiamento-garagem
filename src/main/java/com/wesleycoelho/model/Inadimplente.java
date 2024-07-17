/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import java.util.Date;
import mongoDB.CrudMongoDB;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Wesley
 */
public class Inadimplente {   
  private ObjectId id;
  private Integer nficha;
  private String nome; 
  private String telefone; 
  private String whatsapp;
  private Boolean ispago;
  private Boolean iscanceled;
  private Double valor_pagamento;
  private Date  data_pagamento;
  private ObjectId id_financiamento;
  private Date mes_ref;
  
  public static boolean janelaRelatorio = false;
  
  public Inadimplente(){}

    public Inadimplente(Integer nficha, String nome, String telefone, String whatsapp) {
        this.nficha = nficha;
        this.nome = nome;
        this.telefone = telefone;
        this.whatsapp = whatsapp;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    public Integer getNficha() {
        return nficha;
    }

    public void setNficha(Integer nficha) {
        this.nficha = nficha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void convertToJavaObj(Document doc){
        if(doc != null){
            id = doc.getObjectId("_id");
            ispago = doc.getBoolean("ispago");
            iscanceled = doc.getBoolean("iscanceled");
            valor_pagamento = doc.getDouble("valor_pagamento");
            data_pagamento = doc.getDate("data_pagamento");
            id_financiamento = doc.getObjectId("id_financiamento");
            mes_ref = doc.getDate("mes_ref");
            Document financiamento = CrudMongoDB.searchByFieldValue("financiamento", "_id", id_financiamento);
            nficha = financiamento.getInteger("ficha");
            Document cliente = CrudMongoDB.searchByFieldValue("cliente","_id", financiamento.getObjectId("id_cliente"));
            nome = cliente.getString("nome");
            telefone = cliente.getString("telefone");
            whatsapp = cliente.getString("whatsapp");
            
        }
    }
    
}

