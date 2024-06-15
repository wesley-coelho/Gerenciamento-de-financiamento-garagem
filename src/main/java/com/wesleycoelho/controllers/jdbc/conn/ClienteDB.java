/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

/**
 *
 * @author Wesley
 */

import com.wesleycoelho.model.Cliente;
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
public class ClienteDB {
    public static int save(Cliente cliente){
         String sql = "INSERT INTO cliente (nome,cpf,rg,cep, endereco, numero, bairro, id_municipio, usuario, whatsapp, telefone, complemento) VALUES('"+cliente.getNome()+"', '"+cliente.getCpf()+"', '"+cliente.getRg()+"', '"+cliente.getCep()+"', '"+cliente.getEndereco()+"', "+cliente.getNumero()+", '"+cliente.getBairro()+"', "+cliente.getId_municipio()+", '"+cliente.getUsuario()+"', '"+cliente.getWhatsapp()+"', '"+cliente.getTelefone()+"', '"+cliente.getComplemento()+"')";
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
    
    public static Cliente buscaClientePorId(int id){
        String sql = "SELECT * FROM cliente WHERE id = "+id+";";
        Connection conn = ConnectionFactory.getConexao();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Cliente cliente = null;
            while( rs.next() ){
                cliente = new Cliente(
                       rs.getInt("id"),
                       rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        rs.getString("cep"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        rs.getInt("id_municipio"),
                        rs.getString("usuario"),
                        rs.getString("whatsapp"),
                        rs.getString("telefone"),
                        rs.getString("complemento")
                );
            }
            ConnectionFactory.close(conn, st, rs);
            return cliente;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    
    public static List<Cliente> buscaClientePorNome(String nome){
        String sql = "SELECT * FROM cliente WHERE nome LIKE '%"+nome+"%';";
        Connection conn = ConnectionFactory.getConexao();
        
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Cliente> clientes = new ArrayList<>();
            while( rs.next() ){
                clientes.add(new Cliente(
                       rs.getInt("id"),
                       rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        rs.getString("cep"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        rs.getInt("id_municipio"),
                        rs.getString("usuario"),
                        rs.getString("whatsapp"),
                        rs.getString("telefone"),
                        rs.getString("complemento")
                ));
            }
            ConnectionFactory.close(conn, st, rs);
            return clientes;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
    
    
}

