/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Wesley
 */
public class Municipio {
 
    private Integer id;
    private String cidade;
    private Integer id_uf;
    
    public Municipio(){}

    public Municipio(Integer id, String cidade, Integer id_uf) {
        this.id = id;
        this.cidade = cidade;
        this.id_uf = id_uf;
    }
  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    
    public String getNome() {
        return this.cidade;
    }

    public void setNome(String nome) {
        this.cidade = nome;
    }

    public Integer getId_uf() {
        return id_uf;
    }

    public void setId_uf(Integer id_uf) {
        this.id_uf = id_uf;
    }
    
    public void convertToJavaObj(Document doc){
        if( doc != null ){
           id = doc.getInteger("id");
        cidade = doc.getString("name");
        id_uf = doc.getInteger("state_id");  
        }
       
    }
    
}

