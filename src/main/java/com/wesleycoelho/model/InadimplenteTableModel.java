/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wesleycoelho.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Wesley
 */
public class InadimplenteTableModel extends AbstractTableModel implements TableModel{
    
    //local variables
    private final String[] header = {"Nº da ficha", "Nome","Telefone","Whatsapp"};
    private  List<Inadimplente> inadimplentesList = new ArrayList<>();
    
        
    
   public  InadimplenteTableModel(List<Inadimplente> lista){
        inadimplentesList = lista;
    }
    
    @Override
    public int getRowCount() {
        return inadimplentesList.size();
    }

    @Override
    public int getColumnCount() {
       return header.length;
    }
    
    @Override
    public String getColumnName(int column){        
        return header[column];        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {      
        Inadimplente reg = inadimplentesList.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> reg.getNficha();
                case 1 -> reg.getNome();
                    case 2 -> reg.getTelefone();
                        case 3 -> reg.getWhatsapp();
                            default -> "erro";
        };    
    }
    
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){  
       
        fireTableDataChanged();
   
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }
}

