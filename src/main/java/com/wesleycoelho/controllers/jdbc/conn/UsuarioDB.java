/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

import com.wesleycoelho.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wesley
 */
public class UsuarioDB {
    
    public static void save(Usuario usuario){
         String sql = "INSERT INTO usuario (usuario,senha,administrador, email) VALUES('"+usuario.getUsuario()+"', '"+usuario.getSenha()+"', "+usuario.isAdministrador()+", '"+usuario.getEmail()+"')";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement stmt = conn.createStatement();
           stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public static void delete(String usuario){
         String sql = "DELETE FROM usuario WHERE usuario='"+usuario+"';";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    
    public static void updateUsuario(String userOld, String userNew){
        String sql = "UPDATE usuario SET usuario= '"+userNew+"' WHERE usuario= '"+userOld+"'";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement stmt = conn.createStatement();
          stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateSenha(String usuario, String senha){
        String sql = "UPDATE usuario SET senha= '"+senha+"' WHERE usuario= '"+usuario+"';";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateEmail(String usuario, String senha, String email){
        String sql = "UPDATE usuario SET email= '"+email+"' WHERE usuario= '"+usuario+"' && senha= '"+senha+"';";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void updateAdministrador(String usuario,  boolean isAdm){
        String sql = "UPDATE usuario SET administrador= "+isAdm+" WHERE usuario= '"+usuario+"';";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<Usuario> selectAll(){
        String sql = "SELECT * FROM usuario";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Usuario> usuarioList;
            usuarioList = new ArrayList();
            while(resultSet.next()){
                usuarioList.add(new Usuario(
                        resultSet.getString("usuario"), 
                        resultSet.getString("senha"), 
                        resultSet.getBoolean("administrador"),
                        resultSet.getString("email")));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return usuarioList;
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static List<Usuario> searchByUser(String user){
        String sql = "SELECT * FROM usuario WHERE usuario LIKE '%"+user+"%' ";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Usuario> usuarioList;
            usuarioList = new ArrayList();
            while(resultSet.next()){
                usuarioList.add(new Usuario(
                        resultSet.getString("usuario"), 
                        resultSet.getString("senha"), 
                        resultSet.getBoolean("administrador"),
                        resultSet.getString("email")));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return usuarioList;
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public static List<Usuario> searchByEmail(String email){
        String sql = "SELECT * FROM usuario WHERE email LIKE '"+email+"' ";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Usuario> usuarioList;
            usuarioList = new ArrayList();
            while(resultSet.next()){
                usuarioList.add(new Usuario(
                        resultSet.getString("usuario"), 
                        resultSet.getString("senha"), 
                        resultSet.getBoolean("administrador"),
                        resultSet.getString("email")));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return usuarioList;
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public static boolean autenticaUsuario(String usuario, String senha){
        String sql = "SELECT * FROM usuario WHERE usuario = '"+usuario+"' AND senha = '"+senha+"';";
        Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Usuario> usuarioList;
            usuarioList = new ArrayList();
            while(resultSet.next()){
                usuarioList.add(new Usuario(
                        resultSet.getString("usuario"), 
                        resultSet.getString("senha"), 
                        resultSet.getBoolean("administrador"),
                        resultSet.getString("email")));
            }
            if(usuarioList.isEmpty()){
                ConnectionFactory.close(conn, stmt, resultSet);
                 return false;
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return true;
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;     
    }
    
    
    public static List<Usuario> localizaUsuario(String usuario, String senha){
        String sql = "SELECT * FROM usuario WHERE usuario = '"+usuario+"' AND senha = '"+senha+"';";
        Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Usuario> usuarioList;
            usuarioList = new ArrayList();
            while(resultSet.next()){
                usuarioList.add(new Usuario(
                        resultSet.getString("usuario"), 
                        resultSet.getString("senha"), 
                        resultSet.getBoolean("administrador"),
                        resultSet.getString("email")));
            }
            if(usuarioList.isEmpty()){
                ConnectionFactory.close(conn, stmt, resultSet);
                 return null;
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return usuarioList;
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
    }
}

