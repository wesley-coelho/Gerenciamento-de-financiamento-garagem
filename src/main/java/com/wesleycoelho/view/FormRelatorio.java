/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.wesleycoelho.view;
import com.wesleycoelho.controllers.jdbc.conn.RelatorioDB;
import com.wesleycoelho.model.Usuario;
import com.wesleycoelho.model.Inadimplente;
import com.wesleycoelho.model.InadimplenteTableModel;
import com.wesleycoelho.model.PrintingRelInadimplente;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
/**
 *
 * @author Wesley
 */
public class FormRelatorio extends javax.swing.JInternalFrame {
    Usuario usuario = new Usuario();
    private List<Inadimplente> inadimplentes;
    /**
     * Creates new form FormNovaEntrada
     */
    public FormRelatorio(Usuario user) {
        this.usuario = user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnSalvarEntrada = new javax.swing.JButton();
        btnImprimirEntrada = new javax.swing.JButton();
        btnExcluirEntrada = new javax.swing.JButton();
        btnLimparFormularioEntrada = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnFiltrarEntrada = new javax.swing.JButton();
        cbFiltroRelatorio = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbRelatorio = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("RELATÓRIOS");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-car-16_1.png"))); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                formAncestorRemoved(evt);
            }
        });
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jToolBar1.setEnabled(false);
        jToolBar1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSalvarEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-save-16.png"))); // NOI18N
        btnSalvarEntrada.setToolTipText("Salvar");
        btnSalvarEntrada.setEnabled(false);
        btnSalvarEntrada.setFocusable(false);
        btnSalvarEntrada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvarEntrada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEntradaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvarEntrada);

        btnImprimirEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-print-16.png"))); // NOI18N
        btnImprimirEntrada.setToolTipText("Imprimir");
        btnImprimirEntrada.setFocusable(false);
        btnImprimirEntrada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImprimirEntrada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImprimirEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirEntradaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnImprimirEntrada);

        btnExcluirEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-trash-16.png"))); // NOI18N
        btnExcluirEntrada.setToolTipText("Excluir");
        btnExcluirEntrada.setEnabled(false);
        btnExcluirEntrada.setFocusable(false);
        btnExcluirEntrada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExcluirEntrada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExcluirEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirEntradaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnExcluirEntrada);

        btnLimparFormularioEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-broom-16.png"))); // NOI18N
        btnLimparFormularioEntrada.setToolTipText("Limpar Formulário");
        btnLimparFormularioEntrada.setEnabled(false);
        btnLimparFormularioEntrada.setFocusable(false);
        btnLimparFormularioEntrada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimparFormularioEntrada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimparFormularioEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimparFormularioEntradaMouseClicked(evt);
            }
        });
        btnLimparFormularioEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparFormularioEntradaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnLimparFormularioEntrada);
        jToolBar1.add(jSeparator1);

        btnFiltrarEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-filter-16.png"))); // NOI18N
        btnFiltrarEntrada.setFocusable(false);
        btnFiltrarEntrada.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFiltrarEntrada.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnFiltrarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarEntradaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnFiltrarEntrada);

        cbFiltroRelatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inadimplentes" }));
        cbFiltroRelatorio.setMaximumSize(new java.awt.Dimension(150, 20));
        jToolBar1.add(cbFiltroRelatorio);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        tbRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ficha", "CLIENTE", "TELEFONE", "WHATSAPP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRelatorio.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tbRelatorio.setCellSelectionEnabled(true);
        tbRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbRelatorio.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        tbRelatorio.setDoubleBuffered(true);
        tbRelatorio.setInheritsPopupMenu(true);
        tbRelatorio.setOpaque(false);
        tbRelatorio.setShowGrid(true);
        tbRelatorio.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbRelatorioAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tbRelatorio);
        if (tbRelatorio.getColumnModel().getColumnCount() > 0) {
            tbRelatorio.getColumnModel().getColumn(0).setMinWidth(100);
            tbRelatorio.getColumnModel().getColumn(0).setPreferredWidth(200);
            tbRelatorio.getColumnModel().getColumn(1).setMinWidth(200);
            tbRelatorio.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbRelatorio.getColumnModel().getColumn(2).setMinWidth(200);
            tbRelatorio.getColumnModel().getColumn(2).setPreferredWidth(200);
            tbRelatorio.getColumnModel().getColumn(3).setMinWidth(200);
            tbRelatorio.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEntradaActionPerformed
         
    }//GEN-LAST:event_btnSalvarEntradaActionPerformed

    private void btnImprimirEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirEntradaActionPerformed
        try{
            if(this.inadimplentes == null) throw new NullPointerException("Nenhum registro para imprimir");
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(new PrintingRelInadimplente(this.inadimplentes ));
            boolean doPrint = job.printDialog();
                if (doPrint) job.print();            
        }catch (PrinterException | NullPointerException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage() );
            }
    }//GEN-LAST:event_btnImprimirEntradaActionPerformed

    private void btnExcluirEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirEntradaActionPerformed

    private void btnLimparFormularioEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFormularioEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparFormularioEntradaActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
     Inadimplente.janelaRelatorio = true;
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
    
    }//GEN-LAST:event_formInternalFrameClosed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        Inadimplente.janelaRelatorio = true;
    
    }//GEN-LAST:event_formAncestorAdded

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        // TODO add your handling code here:
        Inadimplente.janelaRelatorio = false;
   
    }//GEN-LAST:event_formAncestorRemoved

    private void btnLimparFormularioEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparFormularioEntradaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnLimparFormularioEntradaMouseClicked

    private void btnFiltrarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarEntradaActionPerformed
         if( "Inadimplentes".equals(this.cbFiltroRelatorio.getSelectedItem().toString()) ) {
             this.inadimplentes = RelatorioDB.buscaInadimplentes();
             if(this.inadimplentes != null ){
                 TableModel tbModel = new InadimplenteTableModel(this.inadimplentes);
                 this.tbRelatorio.setModel(tbModel);
                 
                 //gera arquivo csv
                 String[][] dadosInadimpentes = new String[this.inadimplentes.size()][3];
                 
                 
                 //String path = "C:\\Program Files\\JavaApplicationGaragem\\inadimplentes.csv";
                 String path = "C:\\Users\\Wesley\\Desktop\\inadimplentes.csv";
                 try( BufferedWriter bw = new BufferedWriter(new FileWriter(path) )){
                     bw.write("Nome;Telefone1;Telefone2");
                     bw.newLine();
                     for(int i = 0; i < this.inadimplentes.size(); i++){                    
                         for(int j = 0; j < 3; j++){
                             
                             if(this.tbRelatorio.getModel().getValueAt(i, j+1) != null){
                                 dadosInadimpentes[i][j] = this.tbRelatorio.getModel().getValueAt(i, j+1).toString();
                                 bw.write(dadosInadimpentes[i][j]);
                             } 
                             bw.write(";");                             
                         }
                         bw.newLine();
                     }
                 } catch (IOException ex) {
                     Logger.getLogger(FormRelatorio.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }    
         }  
    }//GEN-LAST:event_btnFiltrarEntradaActionPerformed

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_formComponentAdded

    private void tbRelatorioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbRelatorioAncestorAdded
        // TODO add your handling code here:

    }//GEN-LAST:event_tbRelatorioAncestorAdded


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluirEntrada;
    private javax.swing.JButton btnFiltrarEntrada;
    private javax.swing.JButton btnImprimirEntrada;
    private javax.swing.JButton btnLimparFormularioEntrada;
    private javax.swing.JButton btnSalvarEntrada;
    private javax.swing.JComboBox<String> cbFiltroRelatorio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbRelatorio;
    // End of variables declaration//GEN-END:variables
}