/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

import com.wesleycoelho.model.Estado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class EstadoDB {
    
    public static List<Estado> selectAll(){
        String sql = "SELECT  * FROM uf order by nome";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Estado> estadoList;
            estadoList = new ArrayList();
            while(resultSet.next()){
                estadoList.add(new Estado(
                        resultSet.getInt("id"), 
                        resultSet.getString("nome"), 
                        resultSet.getString("sigla")));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return estadoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    public static List<Estado> searchByName(String name){
        String sql = "SELECT * FROM uf WHERE nome LIKE '%"+name+"%' ";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Estado> estadoList;
            estadoList = new ArrayList();
            while(resultSet.next()){
                estadoList.add(new Estado(
                        resultSet.getInt("id"), 
                        resultSet.getString("nome"), 
                        resultSet.getString("sigla")));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return estadoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    public static Estado searchById(int id){
        String sql = "SELECT * FROM uf WHERE id = "+id;
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
                Statement stmt = conn.createStatement();
                ResultSet resultSet = stmt.executeQuery(sql);
                resultSet.next();
                Estado estado;
                    estado = new Estado(
                              resultSet.getInt("id"), 
                                resultSet.getString("nome"), 
                                resultSet.getString("sigla")

                    );     

                ConnectionFactory.close(conn, stmt, resultSet);
                return estado;
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
            }
        return null;
    }
    
    public static int searchIdStateByName(String name){
        String sql = "SELECT * FROM uf WHERE nome LIKE '"+name+"'";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            int id_estado;
            resultSet.next();
            id_estado = resultSet.getInt("id"); 
            ConnectionFactory.close(conn, stmt, resultSet);
            return id_estado;
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return 0;
    }
    
}

