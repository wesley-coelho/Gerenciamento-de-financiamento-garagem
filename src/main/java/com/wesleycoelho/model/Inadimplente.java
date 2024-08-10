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
public class Inadimplente implements Comparable<Inadimplente>{   
  private ObjectId id;
  private Integer nficha;
  private String nome; 
  private String telefone; 
  private String whatsapp;
  
  
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

    @Override
    public String toString() {
        return "Inadimplente{" + "nficha=" + nficha + ", nome=" + nome + ", telefone=" + telefone + ", whatsapp=" + whatsapp + '}';
    }    
    
    
    @Override
    public int compareTo(Inadimplente o) {
        return this.getNficha().compareTo(o.getNficha());
    }
    
}

