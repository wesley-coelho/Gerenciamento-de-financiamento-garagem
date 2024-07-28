/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Wesley
 */
public class SaidaVeiculo {
    
    Integer     id;
    ObjectId    idMongo;
    Date        data_saida;
    String       usuario;
    ObjectId     id_clienteMongo;
    ObjectId     id_entradaMongo;
    ObjectId     id_financiamentoMongo;
    Integer     id_cliente;
    Integer     id_entrada;
    Integer     id_financiamento;
    public static boolean janelaNovaSaida = false;
    public static boolean janelaListarSaidas = false;
    public static boolean janelaPesquisarSaida = false;
    EntradaVeiculo entrada;
    
    public SaidaVeiculo(){}

    public SaidaVeiculo(Date data_saida, String usuario, Integer id_cliente, Integer id_entrada, Integer id_financiamento) {
        this.data_saida = data_saida;
        this.usuario = usuario;
        this.id_cliente = id_cliente;
        this.id_entrada = id_entrada;
        this.id_financiamento = id_financiamento;
    }
    
    public SaidaVeiculo(Date data_saida, String usuario, ObjectId id_clienteMongo, ObjectId id_entradaMongo, ObjectId id_financiamentoMongo) {
        this.data_saida = data_saida;
        this.usuario = usuario;
        this.id_clienteMongo = id_clienteMongo;
        this.id_entradaMongo = id_entradaMongo;
        this.id_financiamentoMongo = id_financiamentoMongo;
    }
   
    
    public SaidaVeiculo(Integer id, Date data_saida, String usuario, Integer id_cliente, Integer id_entrada, Integer id_financiamento) {
        this.id = id;
        this.data_saida = data_saida;
        this.usuario = usuario;
        this.id_cliente = id_cliente;
        this.id_entrada = id_entrada;
        this.id_financiamento = id_financiamento;
    }
    public SaidaVeiculo(Integer id, Date data_saida, String usuario, ObjectId id_clienteMongo, ObjectId id_entradaMongo, ObjectId id_financiamentoMongo) {
        this.id = id;
        this.data_saida = data_saida;
        this.usuario = usuario;
        this.id_clienteMongo = id_clienteMongo;
        this.id_entradaMongo = id_entradaMongo;
        this.id_financiamentoMongo = id_financiamentoMongo;
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

    public ObjectId getId_clienteMongo() {
        return id_clienteMongo;
    }

    public void setId_clienteMongo(ObjectId id_clienteMongo) {
        this.id_clienteMongo = id_clienteMongo;
    }

    public ObjectId getId_entradaMongo() {
        return id_entradaMongo;
    }

    public void setId_entradaMongo(ObjectId id_entradaMongo) {
        this.id_entradaMongo = id_entradaMongo;
    }

    public ObjectId getId_financiamentoMongo() {
        return id_financiamentoMongo;
    }

    public void setId_financiamentoMongo(ObjectId id_financiamentoMongo) {
        this.id_financiamentoMongo = id_financiamentoMongo;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_entrada() {
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
    
    public Document toDocument(){
        Map<String, Object> map = new HashMap<>();
        if( idMongo != null )map.put("_id", idMongo);
        map.put("data_saida", data_saida);
        map.put("usuario", usuario);
        map.put("_id_cliente", id_clienteMongo);
        map.put("_id_entrada", id_entradaMongo);
        map.put("_id_financiamento", id_financiamentoMongo);
        
        return new Document(map);
    }
    
    public void convertToJavaObj(Document doc){
       if(doc!= null){
        idMongo = doc.getObjectId("_id");
        data_saida = doc.getDate("data_saida") == null ? null : doc.getDate("data_saida");
        usuario = doc.getString("usuario");
        id_clienteMongo = doc.getObjectId("_id_cliente");
        id_entradaMongo = doc.getObjectId("_id_entrada");
        id_financiamentoMongo = doc.getObjectId("_id_financiamento");
      
       }        
    }
    
    
}

