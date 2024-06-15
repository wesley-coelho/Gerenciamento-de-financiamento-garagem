/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

import com.wesleycoelho.model.Municipio;
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
public class MunicipioDB {
        public static List<Municipio> selectAll(){
        String sql = "SELECT DISTINCT * FROM municipio order by nome";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Municipio> municipioList;
            municipioList = new ArrayList();
            while(resultSet.next()){
                municipioList.add(new Municipio(
                        resultSet.getInt("id"), 
                        resultSet.getString("cidade"), 
                        resultSet.getInt("id_uf")));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return municipioList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );;
        }
        return null;
    }
    
    public static List<Municipio> searchByName(String name){
        String sql = "SELECT * FROM municipio WHERE nome LIKE '%"+name+"%' ";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Municipio> municipioList;
            municipioList = new ArrayList();
            while(resultSet.next()){
                municipioList.add(new Municipio(
                        resultSet.getInt("id"), 
                        resultSet.getString("cidade"), 
                        resultSet.getInt("id_uf")));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
           
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    public static Municipio searchById(int id){
        String sql = "SELECT * FROM municipio WHERE id = "+id;
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.next();
            Municipio municipio;
            municipio = new Municipio(
                        resultSet.getInt("id"), 
                        resultSet.getString("cidade"), 
                        resultSet.getInt("id_uf")
            );            
            ConnectionFactory.close(conn, stmt, resultSet);
            return municipio;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    
    public static List<Municipio> selectAllByState(String state){
        int id_uf=0;
        String sql = "SELECT id FROM uf WHERE nome LIKE '%"+state+"%' ";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);           

                while(rs.next()){                
                         id_uf = rs.getInt("id");
                }
                ConnectionFactory.close(conn, stmt, rs);
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
            }
        String sql2 = "SELECT * FROM municipio WHERE id_uf = "+id_uf;
        Connection conn2 = ConnectionFactory.getConexao();
        
        try {            
                Statement stmt2 = conn2.createStatement();
                ResultSet rs2 = stmt2.executeQuery(sql2);           
                List<Municipio> municipioList = new ArrayList();
                while(rs2.next()){
                         municipioList.add(
                                 new Municipio(
                                                rs2.getInt("id"),
                                                rs2.getString("cidade"),               
                                                rs2.getInt("id_uf")
                                               )
                            );
                }
                ConnectionFactory.close(conn2, stmt2, rs2);
                return municipioList;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
            }
        return null;
    }
    
    
    public static int searchIdByCidade(String cidade, int id_uf){
        String sql = "SELECT * FROM municipio WHERE id_uf = "+id_uf+" AND cidade = '"+cidade+"'";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.next();
            int id_municipio;
            id_municipio = resultSet.getInt("id");            
            ConnectionFactory.close(conn, stmt, resultSet);
            return id_municipio;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return 0;
    }
    
    public static Municipio buscaCidadePorId(int id){
        String sql = "SELECT * FROM municipio WHERE id = "+id+";";
        Connection conn = ConnectionFactory.getConexao();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Municipio municipio = null;
            while(rs.next() ){
                municipio = new Municipio(
                        rs.getInt("id"), 
                        rs.getString("cidade"), 
                        rs.getInt("id_uf")
                );
            }
            ConnectionFactory.close(conn,st,rs);
            return municipio;
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
}

