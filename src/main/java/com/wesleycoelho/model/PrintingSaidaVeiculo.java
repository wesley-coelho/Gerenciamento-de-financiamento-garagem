/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import com.wesleycoelho.controllers.jdbc.conn.MunicipioDB;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;

/**
 *
 * @author Wesley
 */
public class PrintingSaidaVeiculo implements Printable{
    private EntradaVeiculo veiculo;
    
    public PrintingSaidaVeiculo(EntradaVeiculo veiculo){
        this.veiculo = veiculo;
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

        // Now we perform our rendering
        g.drawString("FICHA DE SAIDA DE VEÍCULO: " ,30, 50);
        g.drawString("N.: " ,30, 65);
        g.drawString("Entrada: " + veiculo.marca + " " +veiculo.modelo+ " " +veiculo.ano+ " " +veiculo.cor, 30, 90);
        g.drawString("Placa: " + veiculo.placa, 30, 110);
        g.drawString("Renavam: " + veiculo.renavam, 30, 130);
        g.drawString("Chassi: " + veiculo.chassi, 30, 150);
        g.drawString("Nome: " + veiculo.nome_proprietario, 30, 170);
        g.drawString("Telefone: " + veiculo.telefone, 30, 190);
        g.drawString("Whatsapp: " + veiculo.whatsapp, 30, 210);
        g.drawString("Data: " + veiculo.data_entrada, 30, 230);
        if(veiculo.getId_municipio()!= null)
        g.drawString("Cidade: " + MunicipioDB.buscaCidadePorId(veiculo.getId_municipio()).getNome(), 30, 250);
        else
        g.drawString("Cidade: " + veiculo.getCidade(), 30, 250);   

        // tell the caller that this page is part
        // of the printed document
        return PAGE_EXISTS;
    }
}

