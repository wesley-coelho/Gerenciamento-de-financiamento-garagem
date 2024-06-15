/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import com.wesleycoelho.controllers.jdbc.conn.ClienteDB;
import com.wesleycoelho.controllers.jdbc.conn.EntradaVeiculoDB;
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
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Wesley
 */
public class PrintingFichaFrenteFinanciamento implements Printable{
    private final EntradaVeiculo veiculo;
    private final Cliente cliente;
    private final Financiamento financiamento;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public PrintingFichaFrenteFinanciamento(Financiamento f){
        SaidaVeiculo saida = SaidaVeiculoDB.buscaSaidaPorIdFinanciamento(f.getId());
        this.veiculo = EntradaVeiculoDB.buscaEntradaPorId(saida.id_entrada);
        this.cliente = ClienteDB.buscaClientePorId(f.getId_cliente());
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
        
        g.drawString("Nome: " +cliente.getNome(),30, 90);
        g.drawString("CPF: "+cliente.getCpf() ,350, 90);
        g.drawString("Endereço: " +cliente.getEndereco(), 30, 110);
        g.drawString("Nº: "+cliente.getNumero() ,350, 110);
        g.drawString("Bairro: " + cliente.getBairro(), 30, 130);
        g.drawString("CEP: " + cliente.getCep(), 350, 130);
        g.drawString("Cidade: " + MunicipioDB.buscaCidadePorId(cliente.getId_municipio()).getNome(), 30, 150);
        g.drawString("Telefone: " + cliente.getTelefone(), 30, 170);
        g.drawString("Whatsapp: " + cliente.getWhatsapp(), 350, 170);
        
        g.drawString("Dados do financiamento: " ,30, 205);
        g.drawString("Marca: "+veiculo.getMarca() ,30, 225);
        g.drawString("Modelo: "+veiculo.getModelo(),30, 245);
        g.drawString("Ano: " +veiculo.getAno(),350, 245);
        g.drawString("Cor: "+veiculo.getAno() ,30, 265);
        g.drawString("Qtd. parcelas: "+financiamento.getNum_parcelas() ,350, 265);
        g.drawString("Valor: " +financiamento.getValor_parcela(),30, 285);
        g.drawString("1ª parcela: " +ParcelamentoDB.getFirstParcela(financiamento.getId()).format(dtf),30, 305);
        g.drawString("Última parcela: "+ParcelamentoDB.getLastParcela(financiamento.getId()).format(dtf),350, 305);
        g.drawString("Observação: "+financiamento.getOberservacao() ,30, 325);
        
       
         

        // tell the caller that this page is part
        // of the printed document
        return PAGE_EXISTS;
    }
}

