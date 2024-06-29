/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import static java.awt.print.PageFormat.LANDSCAPE;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import javax.swing.JTable;

/**
 *
 * @author Wesley
 */
public class PrintingTodosFinanciamentos implements Printable{
    private JTable tbFinanciamento;

    public PrintingTodosFinanciamentos(JTable tbFinanciamento) {
        this.tbFinanciamento = tbFinanciamento;
    }
    
   
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        // We have only one page, and 'page'
        // is zero-based
        if (page > tbFinanciamento.getRowCount() / 24  ) {
           return NO_SUCH_PAGE;
       }
    
       
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        pf.setOrientation(LANDSCAPE);
        
        g.setFont(new Font("Arial", Font.PLAIN, 6));

        // Now we perform our rendering
        g.drawString("TODOS OS FINANCIAMENTOS: " ,30, 50);
        //header
        g.draw3DRect(30, 60, 30, 20, false); 
        g.draw3DRect(60, 60, 50, 20, false); 
        g.draw3DRect(110, 60, 250, 20, false); 
        g.draw3DRect(360, 60, 50, 20, false);
        g.draw3DRect(410, 60, 50, 20, false);
        g.draw3DRect(460, 60, 50, 20, false);
        g.draw3DRect(510, 60, 50, 20, false);
        g.draw3DRect(560, 60, 240, 20, false);
 
        g.drawString("Ficha",35, 75); 
        g.drawString("Data",65, 75);
        g.drawString("Cliente",115, 75);
        g.drawString("Placa",365, 75);        
        g.drawString("Parcela R$",415, 75);        
        g.drawString("Parcelas",465, 75);
        g.drawString("Dia venc.",515, 75);
        g.drawString("Obs",565, 75);
        
        
        
        
   
       
        //desenhando tabela
        int j = 0;
        for(int i = page*24; i < tbFinanciamento.getRowCount();i++){
            if( j > 23) {
                j = 0;
                break;               
            }   
            g.draw3DRect(30, 80+20*j, 30, 20, false); 
            g.draw3DRect(60, 80+20*j, 50, 20, false); 
            g.draw3DRect(110, 80+20*j, 250, 20, false); 
            g.draw3DRect(360, 80+20*j, 50, 20, false);

            g.draw3DRect(410, 80+20*j, 50, 20, false); 
            g.draw3DRect(460, 80+20*j, 50, 20, false); 
            g.draw3DRect(510, 80+20*j, 50, 20, false); 
            g.draw3DRect(560, 80+20*j, 240, 20, false); 
   
            g.drawString(tbFinanciamento.getModel().getValueAt(i, 1)== null?"":tbFinanciamento.getModel().getValueAt(i, 1).toString(), 35, 95+20*j);         
            g.drawString(tbFinanciamento.getModel().getValueAt(i, 2) == null?"":tbFinanciamento.getModel().getValueAt(i, 2).toString(), 65, 95+20*j);
            g.drawString(tbFinanciamento.getModel().getValueAt(i, 3) == null?"":tbFinanciamento.getModel().getValueAt(i, 3).toString(), 115, 95+20*j);
            g.drawString(tbFinanciamento.getModel().getValueAt(i, 4) == null?"":tbFinanciamento.getModel().getValueAt(i, 4).toString(), 365, 95+20*j);


             g.drawString(tbFinanciamento.getModel().getValueAt(i, 5) == null?"":tbFinanciamento.getModel().getValueAt(i, 5).toString(), 415, 95+20*j);
             g.drawString(tbFinanciamento.getModel().getValueAt(i, 6) == null?"":tbFinanciamento.getModel().getValueAt(i, 6).toString(), 465, 95+20*j);
             g.setFont(new Font("Arial", Font.PLAIN, 6));
             g.drawString(tbFinanciamento.getModel().getValueAt(i, 7) == null?"":tbFinanciamento.getModel().getValueAt(i, 7).toString(), 515, 95+20*j);
             g.setFont(new Font("Arial", Font.PLAIN, 5));
             g.drawString(tbFinanciamento.getModel().getValueAt(i, 8) == null? "": tbFinanciamento.getModel().getValueAt(i, 8).toString(), 565, 95+20*j);
             j++;
        } 
        return PAGE_EXISTS;
    }
}

