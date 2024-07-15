/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Wesley
 */
public class Financiamento {
    //properties
    Integer     id;
    ObjectId      idMongo;
    Integer     ficha;
    Date        data_registro;
    String      nome_cliente;
    String      placa;
    Double      valor_parcela;
    Integer     num_parcelas;
    Integer     dia_vencimento;
    Integer     id_cliente;
    ObjectId     id_clienteMongo;
    ObjectId     id_entradaMongo;
    String      observacao;
    Cliente     cliente;
    EntradaVeiculo veiculo;
    public static boolean janelaNovoFinanciamento = false;
    public static boolean janelaEditarFinanciamento = false;
    public static boolean janelaListaTodosFinanciamento = false;
    public static boolean janelaPesquisaFinanciamento = false;
    
    //constructor
    public Financiamento(){}
    
    public Financiamento(Date data_registro, Integer ficha, Double valor_parcela,  Integer num_parcelas, Integer dia_vencimento, Integer id_cliente, String oberservacao) {
        this.data_registro = data_registro;
        this.ficha = ficha;
        this.valor_parcela = valor_parcela;        
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.id_cliente = id_cliente;
        this.observacao = oberservacao;
    }
    public Financiamento(Date data_registro, Integer ficha, Double valor_parcela,  Integer num_parcelas, Integer dia_vencimento, String oberservacao, ObjectId idClienteMongo, ObjectId id_entradaMongo) {
        this.data_registro = data_registro;
        this.ficha = ficha;
        this.valor_parcela = valor_parcela;        
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;        
        this.observacao = oberservacao;
        this.id_clienteMongo = idClienteMongo;
        this.id_entradaMongo = id_entradaMongo;
    }
    //constructor
    public Financiamento(ObjectId idMongo, Date data_registro, Integer ficha, Double valor_parcela, Integer num_parcelas, Integer dia_vencimento, ObjectId id_clienteMongo, String oberservacao) {
        this.idMongo = idMongo;
        this.data_registro = data_registro;
        this.ficha = ficha;
        this.valor_parcela = valor_parcela;
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.id_clienteMongo = id_clienteMongo;
        this.observacao = oberservacao;
    }
    
    public Financiamento(Integer id, Date data_registro, Integer ficha, Double valor_parcela, Integer num_parcelas, Integer dia_vencimento, Integer id_cliente, String oberservacao) {
        this.id = id;
        this.data_registro = data_registro;
        this.ficha = ficha;
        this.valor_parcela = valor_parcela;
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.id_cliente = id_cliente;
        this.observacao = oberservacao;
    }
    
    public Financiamento(Integer id, Date data_registro, Integer ficha, Double valor_parcela, Integer num_parcelas, Integer dia_vencimento, Integer id_cliente, String oberservacao, Cliente cliente, EntradaVeiculo veiculo) {
        this.id = id;
        this.data_registro = data_registro;
        this.ficha = ficha;
        this.valor_parcela = valor_parcela;
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.id_cliente = id_cliente;
        this.observacao = oberservacao;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }
    public Financiamento(Integer id, Integer ficha,Date data_registro, String nome_cliente, String placa, Double valor_parcela, Integer num_parcelas,  Integer dia_vencimento, String oberservacao) {
        this.id = id;
        this.ficha = ficha;
        this.data_registro = data_registro;
        this.nome_cliente = nome_cliente;
        this.placa = placa;
        this.valor_parcela = valor_parcela;        
        this.num_parcelas = num_parcelas;
        this.dia_vencimento = dia_vencimento;
        this.observacao = oberservacao;
    }

    //getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ObjectId getIdMongo() {
        return idMongo;
    }

    public void setIdMongo(ObjectId idMongo) {
        this.idMongo = idMongo;
    }
   

    public ObjectId getId_clienteMongo() {
        return id_clienteMongo;
    }

    public void setId_clienteMongo(ObjectId id_clienteMongo) {
        this.id_clienteMongo = id_clienteMongo;
    }
    
    
    public Date getData_registro() {
        return data_registro;
    }

    public Integer getFicha() {
        return ficha;
    }

    public void setFicha(Integer ficha) {
        this.ficha = ficha;
    }   
    

    public void setData_registro(Date data_registro) {
        this.data_registro = data_registro;
    }

    public Double getValor_parcela() {
        return valor_parcela;
    }

    public void setValor_parcela(Double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }
    
    public Integer getNum_parcelas() {
        return num_parcelas;
    }

    public void setNum_parcelas(Integer num_parcelas) {
        this.num_parcelas = num_parcelas;
    }

    public Integer getDia_vencimento() {
        return dia_vencimento;
    }

    public void setDia_vencimento(Integer dia_vencimento) {
        this.dia_vencimento = dia_vencimento;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    
    

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EntradaVeiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(EntradaVeiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ObjectId getId_entradaMongo() {
        return id_entradaMongo;
    }

    public void setId_entradaMongo(ObjectId id_entradaMongo) {
        this.id_entradaMongo = id_entradaMongo;
    }
    
    

    public Document toDocument(){
        Map<String, Object> map = new HashMap<>();
        if( idMongo != null ) map.put("_id", idMongo);
        map.put("ficha", ficha);
        map.put("id_cliente", id_clienteMongo);
        map.put("id_entrada", id_entradaMongo);
        map.put("data_registro", data_registro);
        map.put("valor_parcela", valor_parcela);
        map.put("num_parcelas", num_parcelas);
        map.put("dia_vencimento", dia_vencimento);
        map.put("observacao", observacao);
        
        return new Document(map);
    }
    
    public void convertToJavaObj(Document doc){
        idMongo = doc.getObjectId("_id");
        ficha = doc.getInteger("ficha");
        id_clienteMongo = doc.getObjectId("id_cliente");
        id_entradaMongo = doc.getObjectId("id_entrada");
        data_registro = new java.sql.Date(doc.getDate("data_registro").getTime());
        valor_parcela = doc.getDouble("valor_parcela");
        num_parcelas = doc.getInteger("num_parcelas");
        dia_vencimento = doc.getInteger("dia_vencimento");
        observacao = doc.getString("observacao");
        
    }
    
    @Override
    public String toString() {
        return "Financiamento{" + "id=" + id + ", ficha=" + ficha + ", data_registro=" + data_registro + ", nome_cliente=" + nome_cliente + ", placa=" + placa + ", valor_parcela=" + valor_parcela + ", num_parcelas=" + num_parcelas + ", dia_vencimento=" + dia_vencimento + ", id_cliente=" + id_cliente + ", oberservacao=" + observacao + ", cliente=" + cliente + ", veiculo=" + veiculo + '}';
    }
    
    
    
}

