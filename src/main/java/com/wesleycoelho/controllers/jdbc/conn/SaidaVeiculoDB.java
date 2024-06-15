/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

import com.wesleycoelho.model.EntradaVeiculo;
import com.wesleycoelho.model.SaidaVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class SaidaVeiculoDB {
    public static int save(SaidaVeiculo saida){
         String sql = "INSERT INTO saida_veiculo (data_saida, usuario, id_cliente, id_entrada, id_financiamento) VALUES('"+saida.getData_saida()+"', '"+saida.getUsuario()+"', "+saida.getId_cliente()+", "+saida.getId_entrada()+", "+saida.getId_financiamento()+")";
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
    
    public static SaidaVeiculo buscaSaidaPorIdEntrada(int id){
        String sql = "SELECT * FROM saida_veiculo WHERE id_entrada = "+id+";";
        Connection conn = ConnectionFactory.getConexao();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            SaidaVeiculo saida = null;
            while(rs.next() ){
                saida = new SaidaVeiculo(
                        rs.getInt("id"),
                        rs.getDate("data_saida"),
                        rs.getString("usuario"),
                       rs.getInt("id_cliente"),
                        rs.getInt("id_entrada"),
                       rs.getInt("id_financiamento")
                );
            }
            ConnectionFactory.close(conn, st, rs);
            return saida;
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    public static SaidaVeiculo buscaSaidaPorIdFinanciamento(int id){
        String sql = "SELECT * FROM saida_veiculo WHERE id_financiamento = "+id+";";
        Connection conn = ConnectionFactory.getConexao();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            SaidaVeiculo saida = null;
            while(rs.next() ){
                saida = new SaidaVeiculo(
                        rs.getInt("id"),
                        rs.getDate("data_saida"),
                        rs.getString("usuario"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_entrada"),
                        rs.getInt("id_financiamento")
                );
            }
            ConnectionFactory.close(conn, st, rs);
            return saida;
        }catch(SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    public static int buscaIdEntradaPorIdCliente(int id_cliente){
        String sql = "SELECT id_entrada FROM saida_veiculo WHERE id_cliente = "+id_cliente+";";
        Connection conn = ConnectionFactory.getConexao();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int id_entrada = 0;
            while(rs.next() ){
                id_entrada = rs.getInt("id_entrada");                
            }
            ConnectionFactory.close(conn, st, rs);
            return id_entrada;
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return 0;
    }
    
    public static List<SaidaVeiculo> selectAll(){
        String sql = "SELECT "
                + "entrada_veiculo.id, "
                + "entrada_veiculo.nome_proprietario, "
                + "saida_veiculo.data_saida, "
                + "entrada_veiculo.data_entrada, "
                + "entrada_veiculo.marca, "
                + "entrada_veiculo.modelo, "
                + "entrada_veiculo.cor, "
                + "entrada_veiculo.placa, "
                + "entrada_veiculo.renavam, "
                + "entrada_veiculo.chassi, "
                + "entrada_veiculo.ano_veiculo, "
                + "entrada_veiculo.telefone, "
                + "entrada_veiculo.whatsapp "
                /*+ "municipio.cidade*/+ "FROM entrada_veiculo "
               // + "INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id "
                + "LEFT OUTER JOIN saida_veiculo "
                + "ON entrada_veiculo.id = saida_veiculo.id_entrada "
                + "WHERE saida_veiculo.id IS NOT NULL "
                + "ORDER BY saida_veiculo.data_saida";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<SaidaVeiculo> saidaVeiculoList;
            saidaVeiculoList = new ArrayList();
            while(resultSet.next()){
                saidaVeiculoList.add(new SaidaVeiculo(
                        resultSet.getDate("data_saida"),  
                        new EntradaVeiculo( 
                        resultSet.getString("nome_proprietario"), 
                            resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),                                               
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                        )
                        
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return saidaVeiculoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }   
    public static List<SaidaVeiculo> selectByPlaca(String placa){
         String sql = "SELECT "
                + "entrada_veiculo.*, "                
                + "saida_veiculo.data_saida, "                
                + "municipio.cidade FROM entrada_veiculo "
                + "INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id "
                + "LEFT OUTER JOIN saida_veiculo "
                + "ON entrada_veiculo.id = saida_veiculo.id_entrada "
                + "WHERE entrada_veiculo.placa = '" +placa+ "' "; 
          
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<SaidaVeiculo> saidaVeiculoList;
            saidaVeiculoList = new ArrayList();
            while(resultSet.next()){
                saidaVeiculoList.add(new SaidaVeiculo(resultSet.getDate("data_saida"),
                        new EntradaVeiculo(              
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                        )));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return saidaVeiculoList;
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
    
    
}

