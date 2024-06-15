/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

import com.wesleycoelho.model.EntradaVeiculo;
import com.wesleycoelho.model.Inadimplente;
import com.wesleycoelho.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wesley
 */
public class RelatorioDB {
    
    public static void save(EntradaVeiculo entrada){
         String sql = "INSERT INTO entrada_veiculo (nome_proprietario,data_entrada,marca, modelo, cor, placa, renavam, chassi, id_municipio, usuario,ano_veiculo, telefone, whatsapp) VALUES('"+entrada.getNome_proprietario()+"', '"+entrada.getData_entrada()+"','"+entrada.getMarca()+"', '"+entrada.getModelo()+"','"+entrada.getCor()+"','"+entrada.getPlaca()+"','"+entrada.getRenavam()+"','"+entrada.getChassi()+"',"+entrada.getId_municipio()+",'"+entrada.getUsuario()+"','"+entrada.getAno()+"','"+entrada.getTelefone()+"','"+entrada.getWhatsapp()+"')";
         Connection conn = ConnectionFactory.getConexao();           
         
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        } 
        
    }
    
     public static void Editar(EntradaVeiculo entrada){
         String sql = "UPDATE entrada_veiculo SET nome_proprietario = '"+entrada.getNome_proprietario()+"' ,data_entrada = '"+entrada.getData_entrada()+"',marca =  '"+entrada.getMarca()+"', modelo = '"+entrada.getModelo()+"', cor = '"+entrada.getCor()+"', placa = '"+entrada.getPlaca()+"', renavam = '"+entrada.getRenavam()+"', chassi = '"+entrada.getChassi()+"', id_municipio = "+entrada.getId_municipio()+" , usuario = '"+entrada.getUsuario()+"',ano_veiculo = '"+entrada.getAno()+"', telefone = '"+entrada.getTelefone()+"', whatsapp = '"+entrada.getWhatsapp()+"' WHERE id = '"+entrada.getId()+"'";
         Connection conn = ConnectionFactory.getConexao();
         
        try {
            Statement stmt = conn.createStatement();
            System.out.println(stmt.executeUpdate(sql));
            ConnectionFactory.close(conn, stmt);
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }        
    }
     
     
     public static List<Inadimplente> buscaInadimplentes(){
        String sql = """
                     select f.nficha, cliente.nome, cliente.telefone, cliente.whatsapp from financiamento as f
                     inner join parcelamento as p 
                     on f.id = p.id_financiamento
                     inner join cliente on cliente.id = f.id_cliente
                     where p.mes_ref < CUrrent_Date And p.valor_pagamento is null
                     group by f.nficha, cliente.nome, cliente.telefone, cliente.whatsapp
                     order by cliente.nome;""";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Inadimplente> inadinplenteList = new ArrayList<>();            
            while(rs.next()){                
                inadinplenteList.add(new Inadimplente(
                        rs.getInt("nficha"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("whatsapp")
                        
                ));
            }            
            ConnectionFactory.close(conn, stmt, rs);
            return inadinplenteList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static EntradaVeiculo procuraVeiculoDisponivelPorPlaca(String placa){
        String sql = "SELECT * FROM entrada_veiculo AS entrada LEFT OUTER JOIN saida_veiculo AS saida ON entrada.id = saida.id_entrada WHERE saida.id_entrada IS NULL AND entrada.placa = '"+placa+"'";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            EntradaVeiculo entradaVeiculo = null; 
            if(resultSet.next()){
             
            entradaVeiculo = new EntradaVeiculo(                
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                       resultSet.getDate("data_entrada"),
                       resultSet.getString("marca"),
                       resultSet.getString("modelo"),
                       resultSet.getString("cor"), 
                       resultSet.getString("placa"),
                       resultSet.getString("renavam"),  
                       resultSet.getString("chassi"),
                       resultSet.getInt("id_municipio"),
                       resultSet.getString("usuario"),                      
                       resultSet.getString("ano_veiculo"),
                       resultSet.getString("telefone"),
                       resultSet.getString("whatsapp")
            );
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculo;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
      public static EntradaVeiculo checaDisponibilidadeVeiculoPorPlaca(String placa){
        String sql = "SELECT * FROM entrada_veiculo AS entrada LEFT OUTER JOIN saida_veiculo AS saida ON entrada.id = saida.id_entrada WHERE saida.id_entrada IS NULL AND entrada.placa = '"+placa+"'";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            EntradaVeiculo entradaVeiculo = null; 
            if(resultSet.next()){
             
            entradaVeiculo = new EntradaVeiculo(                
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                       resultSet.getDate("data_entrada"),
                       resultSet.getString("marca"),
                       resultSet.getString("modelo"),
                       resultSet.getString("cor"), 
                       resultSet.getString("placa"),
                       resultSet.getString("renavam"),  
                       resultSet.getString("chassi"),
                       resultSet.getInt("id_municipio"),
                       resultSet.getString("usuario"),                      
                       resultSet.getString("ano_veiculo"),
                       resultSet.getString("telefone"),
                       resultSet.getString("whatsapp")
            );
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculo;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     public static List<EntradaVeiculo> selectAll(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                     
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static List<EntradaVeiculo> selectAllDataOrganized(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id ORDER BY entrada_veiculo.data_entrada";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
     public static List<EntradaVeiculo> selectAllNameOrganized(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id ORDER BY entrada_veiculo.nome_proprietario";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static List<EntradaVeiculo> selectAllYearOrganized(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id ORDER BY entrada_veiculo.ano_veiculo";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static List<EntradaVeiculo> selectAllPlacaOrganized(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id ORDER BY entrada_veiculo.placa";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     
     public static List<EntradaVeiculo> selectAllMarcaOrganized(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id ORDER BY entrada_veiculo.marca";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static List<EntradaVeiculo> selectAllModeloOrganized(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id ORDER BY entrada_veiculo.modelo";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static List<EntradaVeiculo> selectAllCidadeOrganized(){
        String sql = "SELECT entrada_veiculo.id, entrada_veiculo.nome_proprietario, entrada_veiculo.data_entrada, entrada_veiculo.marca, entrada_veiculo.modelo, entrada_veiculo.cor, entrada_veiculo.placa, entrada_veiculo.renavam, entrada_veiculo.chassi, entrada_veiculo.ano_veiculo, entrada_veiculo.telefone, entrada_veiculo.whatsapp, municipio.cidade FROM entrada_veiculo INNER JOIN municipio ON entrada_veiculo.id_municipio = municipio.id ORDER BY municipio.cidade";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getString("cidade"),                        
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
     }
     
     public static List<EntradaVeiculo> selectByDate(String data){
         String sql = "SELECT * FROM entrada_veiculo WHERE data_entrada = '"+data+"'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
             
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                        resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
            return entradaVeiculoList;
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     public static List<EntradaVeiculo> selectByNomeProprietario(String nome){
         String sql = "SELECT * FROM entrada_veiculo WHERE nome_proprietario LIKE '%"+nome+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     public static List<EntradaVeiculo> selectByMarca(String marca){
         String sql = "SELECT * FROM entrada_veiculo WHERE marca LIKE '%"+marca+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     public static List<EntradaVeiculo> selectByModelo(String modelo){
         String sql = "SELECT * FROM entrada_veiculo WHERE modelo LIKE '%"+modelo+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     public static List<EntradaVeiculo> selectByCor(String cor){
         String sql = "SELECT * FROM entrada_veiculo WHERE cor LIKE '%"+cor+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     public static List<EntradaVeiculo> selectByAno(String ano){
         String sql = "SELECT * FROM entrada_veiculo WHERE ano_veiculo LIKE '%"+ano+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     
     public static List<EntradaVeiculo> selectByChassi(String chassi){
         String sql = "SELECT * FROM entrada_veiculo WHERE chassi LIKE '%"+chassi+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     public static List<EntradaVeiculo> selectByRenavam(String renavam){
         String sql = "SELECT * FROM entrada_veiculo WHERE renavam LIKE '%"+renavam+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     public static List<EntradaVeiculo> selectByPlaca(String placa){
         String sql = "SELECT * FROM entrada_veiculo WHERE placa LIKE '%"+placa+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
        
     public static List<EntradaVeiculo> selectByTelefone(String telefone){
         String sql = "SELECT * FROM entrada_veiculo WHERE telefone LIKE '%"+telefone+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
     
     
          public static List<EntradaVeiculo> selectByWhatsapp(String whatsapp){
         String sql = "SELECT * FROM entrada_veiculo WHERE whatsapp LIKE '%"+whatsapp+"%'";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<EntradaVeiculo> entradaVeiculoList;
            entradaVeiculoList = new ArrayList();
            while(resultSet.next()){
                entradaVeiculoList.add(new EntradaVeiculo(
                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return entradaVeiculoList;
         }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }
          
          
       public static EntradaVeiculo buscaEntradaPorId(int id){
         String sql = "SELECT * FROM entrada_veiculo WHERE id = "+id+";";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            EntradaVeiculo entrada = null;
            
            while(resultSet.next()){
                entrada = new EntradaVeiculo(                        
                       resultSet.getInt("id"),
                       resultSet.getString("nome_proprietario"),
                        resultSet.getDate("data_entrada"),
                        resultSet.getString("marca"),
                        resultSet.getString("modelo"),
                        resultSet.getString("cor"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getString("chassi"),
                        resultSet.getInt("id_municipio"), 
                        resultSet.getString("usuario"),
                        resultSet.getString("ano_veiculo"),
                        resultSet.getString("telefone"),
                        resultSet.getString("whatsapp")
                );
            }
            ConnectionFactory.close(conn, stmt, resultSet);            
            return entrada;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         
         return null;
     }    
          
          
}

