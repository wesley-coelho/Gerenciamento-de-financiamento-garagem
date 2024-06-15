/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import com.wesleycoelho.controllers.jdbc.conn.ParcelamentoDB;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Wesley
 */
public class PrintingFichaVersoFinanciamento implements Printable{
    private final List<Parcelamento> parcelas;
    private final Financiamento financiamento;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public PrintingFichaVersoFinanciamento(Financiamento f){
        this.parcelas = ParcelamentoDB.buscaParcelasPorIdFinanciamento(f.getId()); 
        this.financiamento = f;
    }
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {      
        if (page > 0) {
             return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());        
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString("Valor da parcela: R$ " +financiamento.getValor_parcela(),30, 60);
        int offsetX = -100;
        int offsetY = 0;
        for( int i = 0; i < parcelas.size(); i++){
            if(i%12 == 0) {
               offsetX+=100; 
               offsetY = 0;
            }                          
            offsetY+=20;
            g.drawString((i+1)+" " +parcelas.get(i).getMes_ref().toLocalDate().format(dtf),30+offsetX, 60+offsetY);  
        }
        return PAGE_EXISTS;
    }
}

