/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.wesleycoelho.controllers.jdbc.conn.MunicipioDB;
import com.wesleycoelho.controllers.jdbc.conn.ParcelamentoDB;
import com.wesleycoelho.controllers.jdbc.conn.SaidaVeiculoDB;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.List;
import mongoDB.CrudMongoDB;
import org.bson.Document;

/**
 *
 * @author Wesley
 */
public class PrintingFichaFrenteFinanciamento implements Printable{
    private List<Document> parcelas;
    private Document cliente = new Document();
    private Document entrada = new Document();
    private final Financiamento financiamento;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public PrintingFichaFrenteFinanciamento(Financiamento f){
        
        cliente = CrudMongoDB.search("cliente", Filters.eq("_id", f.getId_clienteMongo()));
        entrada = CrudMongoDB.search("entrada_veiculo", Filters.eq("_id", f.getId_entradaMongo())); 
        parcelas = CrudMongoDB.searchAll("parcelamento", Filters.eq("_id_financiamento", f.getIdMongo()), "mes_ref");
        this.financiamento = f;
    }
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        // We have only one page, and 'page'
        // is zero-based
        if (page > 0) {
             return NO_SUCH_PAGE;
        }

        // User (0,0) is typically outside the
        // imageable area, so we must translate
        // by the X and Y values in the PageFormat
        // to avoid clipping.
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        g.setFont(new Font("Arial", Font.BOLD, 10));
     
        

        // IMPRIMINDO DADOS DA FRETE DA FICHA
        g.drawString("Dados do cliente: " ,30, 60);
        
        g.drawString("Nome: " +cliente.getString("nome"),30, 90);
        g.drawString("CPF: "+cliente.getString("cpf") ,350, 90);
        g.drawString("Endereço: " +cliente.getString("endereco"), 30, 110);
        g.drawString("Nº: "+cliente.getInteger("numero") ,350, 110);
        g.drawString("Bairro: " + cliente.getString("bairro"), 30, 130);
        g.drawString("CEP: " + cliente.getString("cep"), 350, 130);
        g.drawString("Cidade: " + CrudMongoDB.search("cidades",Filters.eq("id",cliente.getInteger("id_municipio") )).getString("name"), 30, 150);
        g.drawString("Telefone: " + cliente.getString("telefone"), 30, 170);
        g.drawString("Whatsapp: " + cliente.getString("whatsapp"), 350, 170);        
        g.drawString("Dados do financiamento: " ,30, 205);
        g.drawString("Marca: "+entrada.getString("marca") ,30, 225);
        g.drawString("Modelo: "+entrada.getString("modelo"),30, 245);
        g.drawString("Ano: " +entrada.getString("ano_veiculo"),350, 245);
        g.drawString("Cor: "+entrada.getString("cor") ,30, 265);
        g.drawString("Qtd. parcelas: "+financiamento.getNum_parcelas() ,350, 265);
        g.drawString("Valor: " +financiamento.getValor_parcela(),30, 285);
        if(!parcelas.isEmpty()  ){
         g.drawString("1ª parcela: " + sdf.format(parcelas.getFirst().getDate("mes_ref")),30, 305);   
        }else{
           g.drawString("1ª parcela: --",30, 305);  
        }
        
        if(!parcelas.isEmpty()){
            g.drawString("Última parcela: "+ sdf.format(parcelas.getLast().getDate("mes_ref")),350, 305);
        }else{
            g.drawString("Última parcela: --",350, 305);
        }           
       
        g.drawString("Observação: "+financiamento.getObservacao() ,30, 325);
        
       
         

        // tell the caller that this page is part
        // of the printed document
        return PAGE_EXISTS;
    }
}

