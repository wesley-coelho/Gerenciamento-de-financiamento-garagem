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
import java.util.List;

/**
 *
 * @author Wesley
 */
public class PrintingRelInadimplente implements Printable{
    private List<Inadimplente> inadimplente;

    public PrintingRelInadimplente(List<Inadimplente> inadimplente) {
        this.inadimplente = inadimplente;
    }
    
   
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        // We have only one page, and 'page'
        // is zero-based
        if (page >= inadimplente.size() / 24) {
             return NO_SUCH_PAGE;
        }

       
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        pf.setOrientation(LANDSCAPE);
        g.setFont(new Font("Arial", Font.PLAIN, 8));
        // Now we perform our rendering
        g.drawString("RELATORIO DE INADIMPLENTES: " ,30, 50);
        //header
        g.draw3DRect(50, 60, 50, 20, false); 
        g.draw3DRect(100, 60, 400, 20, false); 
        g.draw3DRect(500, 60, 120, 20, false); 
        g.draw3DRect(620, 60, 120, 20, false);
        g.drawString("Ficha",55, 75); 
        g.drawString("Nome",105, 75);
        g.drawString("Telefone",505, 75);
        g.drawString("Whatsapp",625, 75);
        
        int j =0;
        //desenhando tabela
        for(int i = page*36; i < inadimplente.size();i++){
           if( j > 24 ) {
               j = 0;
               break;
           }
           g.draw3DRect(50, 80+20*j, 50, 20, false); 
           g.draw3DRect(100, 80+20*j, 400, 20, false); 
           g.draw3DRect(500, 80+20*j, 120, 20, false); 
           g.draw3DRect(620, 80+20*j, 120, 20, false); 
           
           g.drawString(inadimplente.get(i).getNficha() == null?"":inadimplente.get(i).getNficha().toString(), 55, 95+20*j);
           g.drawString(inadimplente.get(i).getNome() == null?"":inadimplente.get(i).getNome(), 105, 95+20*j);
           g.drawString(inadimplente.get(i).getTelefone() == null?"":inadimplente.get(i).getTelefone(), 505, 95+20*j);
           g.drawString(inadimplente.get(i).getWhatsapp() == null?"":inadimplente.get(i).getWhatsapp(), 625, 95+20*j);
           j+=1;
        }
  
        
           

      
        return PAGE_EXISTS;
    }
}

