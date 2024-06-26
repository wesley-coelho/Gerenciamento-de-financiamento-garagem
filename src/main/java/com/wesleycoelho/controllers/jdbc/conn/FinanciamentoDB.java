/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.controllers.jdbc.conn;

import com.wesleycoelho.model.Cliente;
import com.wesleycoelho.model.EntradaVeiculo;
import com.wesleycoelho.model.Financiamento;
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
public class FinanciamentoDB {
    
     public static int save(Financiamento financiamento){
         String sql = "INSERT INTO financiamento (data_do_registro,valor_parcela, num_parcelas, observacao, id_cliente, dia_vencimento, nFicha) VALUES('"+financiamento.getData_registro()+"', "+financiamento.getValor_parcela()+","+financiamento.getNum_parcelas()+",'"+financiamento.getOberservacao()+"',"+financiamento.getId_cliente()+","+financiamento.getDia_vencimento()+", "+financiamento.getFicha()+");";
         Connection conn = ConnectionFactory.getConexao();           
         
        try {
                PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.executeUpdate();
                final ResultSet rs = ps.getGeneratedKeys();
                int id_financ= 0;
                if(rs.next()){
                    id_financ = rs.getInt("id");
                }

                ConnectionFactory.close(conn, ps, rs);                 
                return id_financ;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
            return 0;
        }
    }
    
     public static Financiamento buscaFinanciamentoPorIdSaida(int id){
        String sql = "SELECT * FROM financiamento WHERE id = "+id+";";
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            Financiamento financiamento = null; 
            while(resultSet.next()){           
                financiamento = new Financiamento(                
                           resultSet.getInt("id"),
                           resultSet.getDate("data_do_registro"),
                           resultSet.getInt("nficha"),
                           resultSet.getDouble("valor_parcela"), 
                           resultSet.getInt("num_parcelas"), 
                           resultSet.getInt("dia_vencimento"),
                           resultSet.getInt("id_cliente"),
                           resultSet.getString("observacao")
                );
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return financiamento;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static Financiamento buscaFinanciamentoPorNFicha(int nficha){
        String sql = """
                        select financiamento.* , entrada_veiculo.*, cliente.*,
                        cliente.telefone as telefone_cliente, cliente.whatsapp as whatsapp_cliente,
                        cliente.id_municipio as id_cidade from saida_veiculo
                        inner join financiamento on saida_veiculo.id_financiamento = financiamento.id
                        inner join entrada_veiculo on saida_veiculo.id_entrada = entrada_veiculo.id
                        inner join cliente on saida_veiculo.id_cliente = cliente.id
                        where nficha = """ +nficha;
                      
         Connection conn = ConnectionFactory.getConexao();
         
        try {            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            Financiamento financiamento = null; 
            EntradaVeiculo veiculo;
            Cliente    cliente;
            if(resultSet.next()){ 
                veiculo = new EntradaVeiculo(
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

                );  
                
                cliente = new Cliente(
                            resultSet.getString("nome"),
                            resultSet.getString("cpf"),
                            resultSet.getString("rg"),
                            resultSet.getString("cep"),
                            resultSet.getString("endereco"),
                            resultSet.getInt("numero"),
                            resultSet.getString("bairro"),
                            resultSet.getInt("id_cidade"),
                            resultSet.getString("usuario"),
                            resultSet.getString("whatsapp_cliente"),
                            resultSet.getString("telefone_cliente"),
                            resultSet.getString("complemento")
                );
                financiamento = new Financiamento(                
                           resultSet.getInt("id"),
                           resultSet.getDate("data_do_registro"),
                           resultSet.getInt("nficha"),
                           resultSet.getDouble("valor_parcela"),                           
                           resultSet.getInt("num_parcelas"), 
                           resultSet.getInt("dia_vencimento"),
                           resultSet.getInt("id_cliente"),
                           resultSet.getString("observacao"),
                           cliente,
                           veiculo
                );
                
                
            }
            ConnectionFactory.close(conn, stmt, resultSet);
            return financiamento;
                    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
        }
        return null;
    }
     
     public static List<Financiamento> selectAll(){
         String sql = """
                        select f.id, f.nficha, f.data_do_registro,
                        cl.nome, ent.placa, 
                        f.valor_parcela, f.num_parcelas, f.dia_vencimento, f.observacao
                        from financiamento As f 
                        inner join cliente As cl on f.id_cliente = cl.id
                        inner join saida_veiculo on saida_veiculo.id_financiamento = f.id
                        inner join entrada_veiculo As ent on saida_veiculo.id_entrada = ent.id;
                    """;
         Connection conn = ConnectionFactory.getConexao();
         
         try{
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             List<Financiamento> listaFinanciamento = new ArrayList<>();
             while( rs.next() ){
                 listaFinanciamento.add(new Financiamento(
                         rs.getInt("id"),
                         rs.getInt("nficha"),
                         rs.getDate("data_do_registro"),
                         rs.getString("nome"),
                         rs.getString("placa"),                          
                           rs.getDouble("valor_parcela"),
                         rs.getInt("num_parcelas"),
                         rs.getInt("dia_vencimento"),                   
                         rs.getString("observacao")
                    )
                 );
             }
             ConnectionFactory.close(conn, st, rs);
             return listaFinanciamento;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }
         return null;
     }
     
     public static List<Financiamento> buscaPorData(String data){
         String sql = "SELECT * FROM financiamento WHERE data_do_registro = '"+data+"';";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Financiamento> financiamentoList;
            financiamentoList = new ArrayList();
            while(resultSet.next()){             
                financiamentoList.add(new Financiamento(
                        
                        resultSet.getInt("id"),
                       resultSet.getDate("data_do_registro"),
                        resultSet.getInt("nFicha"),                        
                        resultSet.getDouble("valor_parcela"),                        
                        resultSet.getInt("num_parcelas"),
                        resultSet.getInt("dia_vencimento"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("observacao")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return financiamentoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }         
         return null;
     } 
     
     public static List<Financiamento> buscaPorObs(String obs){
         String sql = "SELECT * FROM financiamento WHERE observacao = '"+obs+"';";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Financiamento> financiamentoList;
            financiamentoList = new ArrayList();
            while(resultSet.next()){             
                financiamentoList.add(new Financiamento(
                        
                        resultSet.getInt("id"),
                       resultSet.getDate("data_do_registro"),
                        resultSet.getInt("nFicha"),                        
                        resultSet.getDouble("valor_parcela"),                        
                        resultSet.getInt("num_parcelas"),
                        resultSet.getInt("dia_vencimento"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("observacao")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return financiamentoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }         
         return null;
     } 
     
    public static Financiamento buscaPorId(int id){
         String sql = "SELECT * FROM financiamento WHERE id = "+id+";";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            Financiamento f= null;
  
            while(resultSet.next()){             
                f = new Financiamento(
                        
                        resultSet.getInt("id"),
                       resultSet.getDate("data_do_registro"), 
                        resultSet.getInt("nFicha"),       
                        resultSet.getDouble("valor_parcela"),                        
                        resultSet.getInt("num_parcelas"),
                        resultSet.getInt("dia_vencimento"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("observacao")
                );
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return f;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }         
         return null;
     }
    
    
   
      public static List<Financiamento> buscaPorNome(String nome){
         String sql = """
                      select f.id, 
                      f.data_do_registro,                       
                      f.num_parcelas, 
                      f.observacao,
                      f.id_cliente, 
                      f.dia_vencimento, 
                      f.valor_parcela,
                      f.nFicha
                      from financiamento as f
                      inner join cliente AS cl 
                      on cl.id = f.id_cliente
                      And cl.nome like '%"""+nome+"%';";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Financiamento> financiamentoList;
            financiamentoList = new ArrayList();
            while(resultSet.next()){             
                financiamentoList.add(new Financiamento(
                        
                        resultSet.getInt("id"),
                       resultSet.getDate("data_do_registro"), 
                        resultSet.getInt("nFicha"),
                        resultSet.getDouble("valor_parcela"),
                        resultSet.getInt("num_parcelas"),
                        resultSet.getInt("dia_vencimento"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("observacao")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return financiamentoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }         
         return null;
     }
      
      public static List<Financiamento> buscaPorDiaVencimento(int dia){
         String sql = "SELECT * FROM financiamento WHERE dia_vencimento = "+dia+";";
         Connection conn = ConnectionFactory.getConexao();
         
         try{
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
            List<Financiamento> financiamentoList;
            financiamentoList = new ArrayList();
            while(resultSet.next()){             
                financiamentoList.add(new Financiamento(
                        
                        resultSet.getInt("id"),
                       resultSet.getDate("data_do_registro"),
                            resultSet.getInt("nFicha"),                        
                        resultSet.getDouble("valor_parcela"),                        
                        resultSet.getInt("num_parcelas"),
                        resultSet.getInt("dia_vencimento"),
                        resultSet.getInt("id_cliente"),
                        resultSet.getString("observacao")
                ));
            }
             ConnectionFactory.close(conn, stmt, resultSet);
             return financiamentoList;
         }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
         }         
         return null;
     }
      
      public static int buscaNficha(int id){
          String sql = "SELECT nFicha FROM financiamento WHERE id_cliente = "+id+";";
          Connection conn = ConnectionFactory.getConexao();
          
          try{
              Statement st = conn.createStatement();
              ResultSet rs = st.executeQuery(sql);
              int nFicha = 0;
              while(rs.next()){
                  nFicha = rs.getInt("nFicha");
              }
              ConnectionFactory.close(conn, st, rs);
              return nFicha;
          }catch(SQLException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE );
          }
          
          return 0;
      }
      
      public static void update(Financiamento f, Cliente c){
          
           String sql_1 = "UPDATE financiamento SET "
                   + "dia_vencimento = "+f.getDia_vencimento()+", "
                   + "nficha = "+f.getFicha()+","
                   + "observacao = '"+f.getOberservacao()+"',"
                   + "valor_parcela = "+f.getValor_parcela()+" WHERE id = "+f.getId()+";";
           
           String sql_2 = "UPDATE cliente SET "
                   + "nome = '"+c.getNome()+"', "
                   + "cpf = '"+c.getCpf()+"',"
                   + "rg = '"+c.getRg()+"',"
                   + "cep = '"+c.getCep()+"',"
                   + "endereco = '"+c.getEndereco()+"',"
                   + "numero = "+c.getNumero()+","
                   + "bairro = '"+c.getBairro()+"',"
                   + "id_municipio = "+c.getId_municipio()+","
                   + "whatsapp = '"+c.getWhatsapp()+"',"
                   + "telefone = '"+c.getTelefone()+"',"
                   + "complemento = '"+c.getComplemento()+"' WHERE id = "+f.getId_cliente()+";";
           
           Connection conn = ConnectionFactory.getConexao();
           
           try{
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql_1);
                stmt.executeUpdate(sql_2);
                ConnectionFactory.close(conn, stmt);
                JOptionPane.showMessageDialog(null, "Registro atualizado!","Update", JOptionPane.INFORMATION_MESSAGE);
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(null, ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
           }
           
          
      }
}

