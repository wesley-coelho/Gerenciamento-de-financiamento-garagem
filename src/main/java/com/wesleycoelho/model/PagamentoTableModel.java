/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import com.wesleycoelho.controllers.jdbc.conn.ParcelamentoDB;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Wesley
 */
public class PagamentoTableModel extends AbstractTableModel implements TableModel{
    List<Parcelamento> parcelas;
    String[] columns = {"Parcela", "Vencimento", "Parcela R$", "Pagamento R$", "Pago" ,"Data", "Cancelado?"};
    Financiamento financiamento;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    
    public PagamentoTableModel(List<Parcelamento> parcelas, Financiamento financiamento){
        this.parcelas = parcelas;
        this.financiamento = financiamento;
    }
    
    @Override
    public int getRowCount() {
        return parcelas.size();
    }

    @Override
    public int getColumnCount() {
       return columns.length;
    }
    
    @Override
    public String getColumnName(int column){
        return switch (column){
            case 0 -> columns[0];
            case 1 -> columns[1];
            case 2 -> columns[2];
            case 3 -> columns[3];
            case 4 -> columns[4];
            case 5 -> columns[5];
            case 6 -> columns[6];    
            default -> "erro";
        };
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Parcelamento valueRow = parcelas.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> rowIndex + 1;
            case 1 -> valueRow.mes_ref.toLocalDate().format(dtf);
            case 2 -> financiamento.getValor_parcela();
            case 3 -> valueRow.getValor_pagamento() == 0.0?null:valueRow.getValor_pagamento();
            case 4 -> valueRow.getIsPago();
            case 5 -> valueRow.getData_pagamento() != null?valueRow.getData_pagamento().toLocalDate().format(dtf):valueRow.getData_pagamento();
            case 6 -> valueRow.getIsCanceled();
            default -> "Erro";
        };
        
        
        
//        Parcelamento valueRow = parcelas.get(rowIndex);
//        return switch (columnIndex) {
//            case 0 -> rowIndex + 1;
//            case 1 -> valueRow.mes_ref.toLocalDate().format(dtf);
//            case 2 -> financiamento.getValor_parcela();
//            case 3 -> valueRow.valor_pagamento == 0.0?"":valueRow.valor_pagamento;
//            case 4 -> valueRow.getSituacaodaparcela();
//            case 5 -> valueRow.data_pagamento;
//            default -> "Erro";
//        };
        
    }

    @Override
    public Class<?> getColumnClass(int col) {
       return switch(col){
            case 0 -> Integer.class;
            case 1 -> String.class;
            case 2 -> Double.class;
            case 3 -> Double.class;
            case 4 -> Boolean.class;
            case 5 -> String.class;
            case 6 -> Boolean.class;
            default -> null;
        };
    }
    
    
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){  
        switch(columnIndex){
            case 3 -> {      
                          parcelas.get(rowIndex).setValor_pagamento(Double.parseDouble(aValue.toString()));
                          ParcelamentoDB.Pagamento(parcelas.get(rowIndex));
                          fireTableDataChanged();   
                      }
            case 4 -> {
                        parcelas.get(rowIndex).setIsPago((Boolean)aValue);
                        if( (Boolean)aValue) {
                            parcelas.get(rowIndex).setData_pagamento(LocalDate.now().format(dtf));
                        }else{
                             parcelas.get(rowIndex).setData_pagamento(null);
                        }
                        ParcelamentoDB.Pagamento(parcelas.get(rowIndex));
                        fireTableDataChanged();
                      }
            case 6 -> {
                        parcelas.get(rowIndex).setIsCanceled((Boolean)aValue);                        
                        ParcelamentoDB.Pagamento(parcelas.get(rowIndex));
                        fireTableDataChanged();
                      }
        }
        
    }

   
       
    
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == 3 || columnIndex == 4 || columnIndex == 6;
    }
    
    
   
}

