/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

/**
 *
 * @author Wesley
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class ConnectionFactory {
    //Java.sql --> Connection, Statement, ResultSet
    //DriverManager

    public static Connection getConexao() {
        try {
            //Class.forName("com.postgresql.jdbc.Driver")
             Properties props = loadProperties();
             String url = props.getProperty("dburl");
            return DriverManager.getConnection(url,props);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }

        return null;

    }
    
    private static Properties loadProperties(){
       // try (FileInputStream fs = new FileInputStream("C:\\Program Files\\JavaApplicationGaragem\\properties\\db.properties")){
        try (FileInputStream fs = new FileInputStream(".\\properties\\db.properties")){ 
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
    
    public static void close(Connection conexao){
        try {
            if(conexao != null)
                conexao.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    public static void close(Connection conexao, Statement stmt){
        close(conexao);
        try {
            if(stmt != null)
                stmt.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    public static void close(Connection conexao, PreparedStatement ps){
        close(conexao);
        try {
            if(ps != null)
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
    public static void close(Connection conexao, PreparedStatement ps, ResultSet rs){
        close(conexao, ps);
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    public static void close(Connection conexao, Statement stmt, ResultSet rs){
        close(conexao, stmt);       
        try {
            if(rs != null)
                rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
    
    

}
