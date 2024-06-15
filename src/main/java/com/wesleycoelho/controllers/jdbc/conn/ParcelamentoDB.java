/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

import com.wesleycoelho.model.Parcelamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class ParcelamentoDB {
    
     public static int save(Parcelamento parcela){
         String sql = "INSERT INTO parcelamento (data_pagamento, valor_pagamento, id_financiamento, mes_ref, ispago) VALUES("+parcela.getData_pagamento()+", "+parcela.getValor_pagamento()+", "+parcela.getId_financiamento()+", '"+parcela.getMes_ref()+"', "+parcela.getIsPago()+");";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            final ResultSet rs = ps.getGeneratedKeys();
             int lastId = 0;
            if(rs.next()){
                lastId = rs.getInt("id");
            }
            ConnectionFactory.close(conn, ps, rs);

                    return lastId;
                    } catch (SQLException ex) {
                    
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         return 0;
        } 
    
    }
     
      public static List<Parcelamento> buscaParcelasPorIdFinanciamento(int id){
        String sql = "SELECT * FROM parcelamento WHERE id_financiamento = "+id+"  ORDER BY mes_ref;";
        Connection conn = ConnectionFactory.getConexao();
         
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Parcelamento> parcelas = new ArrayList<>();
            while( rs.next() ){
                parcelas.add(new Parcelamento(
                       rs.getInt("id"),
                        rs.getDate("data_pagamento"),
                        rs.getDouble("valor_pagamento"),
                        rs.getInt("id_financiamento"),
                        rs.getDate("mes_ref"),
                        rs.getBoolean("ispago")
                ));
            }
            ConnectionFactory.close(conn, st, rs);
            return parcelas;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
      
      
      public static int Pagamento(Parcelamento parcela){
           String sql;
          
          if( parcela.getData_pagamento() != null  )
                sql = "UPDATE parcelamento SET valor_pagamento =  "+parcela.getValor_pagamento()+", data_pagamento = '"+parcela.getData_pagamento()+"', ispago = "+parcela.getIsPago()+" WHERE id = "+parcela.getId()+";";
          else
                sql = "UPDATE parcelamento SET valor_pagamento =  "+parcela.getValor_pagamento()+", data_pagamento = "+null+", ispago = "+parcela.getIsPago()+" WHERE id = "+parcela.getId()+";";
          Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement st = conn.createStatement();
            return st.executeUpdate(sql);
        } catch (SQLException ex) {                    
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         return 0;
        } 
    
    }
      
      public static LocalDate getFirstParcela(int id_financiamento){
         String sql = "select Min(mes_ref) from parcelamento where id_financiamento = "+id_financiamento+";";
         LocalDate parcela = null;
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while( rs.next() ){                
                parcela = rs.getDate("min").toLocalDate();
            }
            
            return parcela;
        } catch (SQLException ex) {                    
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         return null;
        } 
    
    }
      
      public static LocalDate getLastParcela(int id_financiamento){
         String sql = "select Max(mes_ref) from parcelamento where id_financiamento = "+id_financiamento+";";
         LocalDate parcela = null;
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while( rs.next() ){                
                parcela = rs.getDate("max").toLocalDate();
            }
            
            return parcela;
        } catch (SQLException ex) {                    
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         return null;
        } 
    
    }
    
}

