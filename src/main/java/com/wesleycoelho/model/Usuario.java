/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import java.util.Objects;

/**
 *
 * @author Wesley
 */
public class Usuario {
    private String usuario= "";
    private String senha = "";
    private String email = "";
    private boolean administrador = false;
    
    public Usuario(){};
    
    public Usuario(String usuario, String senha, boolean administrador, String email) {
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", senha=" + senha + ", email=" + email + ", administrador=" + administrador + '}';
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.usuario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.usuario, other.usuario);
    }

    
    
    
    
}

