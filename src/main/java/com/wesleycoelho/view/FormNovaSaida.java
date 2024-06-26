/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.wesleycoelho.view;


import com.wesleycoelho.controllers.jdbc.conn.EntradaVeiculoDB;
import com.wesleycoelho.controllers.jdbc.conn.EstadoDB;
import com.wesleycoelho.model.EntradaVeiculo;
import com.wesleycoelho.model.Usuario;
import javax.swing.JOptionPane;
import com.wesleycoelho.controllers.jdbc.conn.MunicipioDB;
import com.wesleycoelho.controllers.jdbc.conn.SaidaVeiculoDB;
import com.wesleycoelho.model.DaoException;
import com.wesleycoelho.model.Estado;
import com.wesleycoelho.model.Municipio;
import com.wesleycoelho.model.SaidaVeiculo;
import java.time.Instant;
import java.util.Date;
import java.util.List;



/**
 *
 * @author Wesley
 */
public class FormNovaSaida extends javax.swing.JInternalFrame {
    Usuario usuario = new Usuario();
    EntradaVeiculo entrada = null;
    /**
     * Creates new form FormNovaEntrada
     */
    public FormNovaSaida(Usuario user) {
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
        btnSalvarSaida = new javax.swing.JButton();
        btnImprimirEntrada = new javax.swing.JButton();
        btnExcluirEntrada = new javax.swing.JButton();
        btnLimparFormularioEntrada = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnPesquisarSaida = new javax.swing.JButton();
        txtPesquisarEntrada = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtModeloEntrada = new javax.swing.JTextField();
        txtMarcaEntrada = new javax.swing.JTextField();
        txtRenavamEntrada = new javax.swing.JTextField();
        txtChassiEntrada = new javax.swing.JTextField();
        txtPlacaEntrada = new javax.swing.JTextField();
        cbAnoEntrada = new javax.swing.JComboBox<>();
        cbCorEntrada = new javax.swing.JComboBox<>();
        cbCidadeEntrada = new javax.swing.JComboBox<>();
        DataChooserEntrada = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        cbUFEntrada = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtProprietarioEntrada = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTelefoneEntrada = new javax.swing.JFormattedTextField();
        txtWhatsappEntrada = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Nova Saída de veículo");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-car-16_1.png"))); // NOI18N
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
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

        btnSalvarSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-save-16.png"))); // NOI18N
        btnSalvarSaida.setToolTipText("Salvar");
        btnSalvarSaida.setFocusable(false);
        btnSalvarSaida.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalvarSaida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalvarSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarSaidaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSalvarSaida);

        btnImprimirEntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-print-16.png"))); // NOI18N
        btnImprimirEntrada.setToolTipText("Imprimir");
        btnImprimirEntrada.setEnabled(false);
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

        btnPesquisarSaida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-search-16.png"))); // NOI18N
        btnPesquisarSaida.setText("Placa");
        btnPesquisarSaida.setFocusable(false);
        btnPesquisarSaida.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPesquisarSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarSaidaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPesquisarSaida);

        txtPesquisarEntrada.setForeground(new java.awt.Color(153, 153, 153));
        txtPesquisarEntrada.setMaximumSize(new java.awt.Dimension(200, 20));
        txtPesquisarEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPesquisarEntradaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtPesquisarEntradaMouseReleased(evt);
            }
        });
        txtPesquisarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarEntradaActionPerformed(evt);
            }
        });
        txtPesquisarEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarEntradaKeyReleased(evt);
            }
        });
        jToolBar1.add(txtPesquisarEntrada);

        jPanel5.setBackground(new java.awt.Color(243, 245, 251));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Veículo"));

        jLabel4.setText("MARCA:");

        jLabel5.setText("MODELO:");

        jLabel6.setText("RENAVAM:");

        jLabel7.setText("CHASSI:");

        jLabel8.setText("PLACA:");

        jLabel9.setText("ANO:");

        jLabel10.setText("DATA:");

        jLabel11.setText("COR:");

        jLabel12.setText("CIDADE:");

        txtModeloEntrada.setEditable(false);

        txtMarcaEntrada.setEditable(false);

        txtRenavamEntrada.setEditable(false);

        txtChassiEntrada.setEditable(false);

        txtPlacaEntrada.setEditable(false);

        cbAnoEntrada.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbAnoEntradaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        cbCorEntrada.setEditable(true);
        cbCorEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VERDE", "AMARELO", "PRETO", "CINZA", "AZUL", "BRANCO", "CHUMBO", "PRATA", "VINHO", "BEGE", "VERMELHO", " " }));
        cbCorEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbCorEntradaKeyTyped(evt);
            }
        });

        cbCidadeEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ribeirao Preto" }));
        cbCidadeEntrada.setAutoscrolls(true);
        cbCidadeEntrada.setDoubleBuffered(true);
        cbCidadeEntrada.setMaximumSize(new java.awt.Dimension(200, 32767));
        cbCidadeEntrada.setPreferredSize(new java.awt.Dimension(200, 22));
        cbCidadeEntrada.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbCidadeEntradaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        DataChooserEntrada.setDateFormatString("dd'-'MM'-'yyyy");
        DataChooserEntrada.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                DataChooserEntradaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel16.setText("UF:");

        cbUFEntrada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "São Paulo" }));
        cbUFEntrada.setAutoscrolls(true);
        cbUFEntrada.setDoubleBuffered(true);
        cbUFEntrada.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                cbUFEntradaComponentAdded(evt);
            }
        });
        cbUFEntrada.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbUFEntradaItemStateChanged(evt);
            }
        });
        cbUFEntrada.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cbUFEntradaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlacaEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtChassiEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRenavamEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModeloEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMarcaEntrada))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbAnoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbCorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbCidadeEntrada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DataChooserEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbUFEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMarcaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtModeloEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtRenavamEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtChassiEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlacaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(cbAnoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(DataChooserEntrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbCidadeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(cbUFEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        jPanel6.setBackground(new java.awt.Color(243, 245, 251));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Contato"));

        jLabel13.setText("PROPRIETÁRIO:");

        txtProprietarioEntrada.setEditable(false);

        jLabel14.setText("TELEFONE:");

        jLabel15.setText("WHATSAPP:");

        txtTelefoneEntrada.setEditable(false);
        try {
            txtTelefoneEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        txtWhatsappEntrada.setEditable(false);
        try {
            txtWhatsappEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ##### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtWhatsappEntrada.setMaximumSize(new java.awt.Dimension(156, 2147483647));
        txtWhatsappEntrada.setMinimumSize(new java.awt.Dimension(156, 22));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTelefoneEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtWhatsappEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtProprietarioEntrada))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtProprietarioEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTelefoneEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtWhatsappEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarSaidaActionPerformed

        if( this.entrada != null){
            SaidaVeiculo saida = new SaidaVeiculo(
               new java.sql.Date(Date.from(Instant.now()).getTime())     ,
                    this.usuario.getUsuario(),
                    null,
                    entrada.getId(),
                    null
            );
            try{
                if (SaidaVeiculoDB.save(saida) == 0) throw new DaoException("Erro ao salvar saida!");
                 this.entrada = null;
                JOptionPane.showMessageDialog(rootPane, "Operação realizada com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
                limparCamposForm();
            }catch(DaoException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSalvarSaidaActionPerformed

    private void btnImprimirEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirEntradaActionPerformed

    private void btnExcluirEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirEntradaActionPerformed

    private void btnLimparFormularioEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFormularioEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparFormularioEntradaActionPerformed

    private void txtPesquisarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarEntradaActionPerformed
        // TODO add your handling code here:
        this.txtPesquisarEntrada.setText(this.txtPesquisarEntrada.getText().toUpperCase());
    }//GEN-LAST:event_txtPesquisarEntradaActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
        SaidaVeiculo.janelaNovaSaida = true;
       
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void cbAnoEntradaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbAnoEntradaAncestorAdded
        // TODO add your handling code here:
        for (int i = 1950; i < 2061; i++) {            
            this.cbAnoEntrada.addItem(String.valueOf(i));
        }
    }//GEN-LAST:event_cbAnoEntradaAncestorAdded

    private void txtPesquisarEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarEntradaMouseClicked
        //recuperando os dados do formulario  
        this.txtPesquisarEntrada.setText("");
    }//GEN-LAST:event_txtPesquisarEntradaMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
        SaidaVeiculo.janelaNovaSaida = false;
    }//GEN-LAST:event_formInternalFrameClosed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
        SaidaVeiculo.janelaNovaSaida = true;
    
    }//GEN-LAST:event_formAncestorAdded

    private void formAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorRemoved
        // TODO add your handling code here:
       SaidaVeiculo.janelaNovaSaida = false;
   
    }//GEN-LAST:event_formAncestorRemoved

    private void cbCidadeEntradaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbCidadeEntradaAncestorAdded
        // TODO add your handling code here:
        List<Municipio> municipios;
        
        municipios = MunicipioDB.selectAllByState("São Paulo");
        for(Municipio municipio: municipios){
            this.cbCidadeEntrada.addItem(municipio.getNome());
        }
     
    }//GEN-LAST:event_cbCidadeEntradaAncestorAdded

    private void cbUFEntradaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cbUFEntradaAncestorAdded
        // TODO add your handling code here:
        List<Estado> estados;
        
        estados = EstadoDB.selectAll();
        
      for(Estado estado: estados){
           this.cbUFEntrada.addItem(estado.getNome());
      }
    }//GEN-LAST:event_cbUFEntradaAncestorAdded

    private void cbCorEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCorEntradaKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbCorEntradaKeyTyped

    private void btnLimparFormularioEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparFormularioEntradaMouseClicked
       limparCamposForm();        
    }//GEN-LAST:event_btnLimparFormularioEntradaMouseClicked

    private void DataChooserEntradaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_DataChooserEntradaAncestorAdded
        // TODO add your handling code here:
        java.util.Date data = new java.util.Date();
        this.DataChooserEntrada.setDate(data);
                
   
    }//GEN-LAST:event_DataChooserEntradaAncestorAdded

    private void cbUFEntradaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbUFEntradaItemStateChanged
        // TODO add your handling code here:
        List<Municipio> municipios;        
        municipios = MunicipioDB.selectAllByState(cbUFEntrada.getSelectedItem().toString());
        this.cbCidadeEntrada.removeAllItems();
        for(Municipio municipio: municipios){
            this.cbCidadeEntrada.addItem(municipio.getNome());
        }
    }//GEN-LAST:event_cbUFEntradaItemStateChanged

    private void cbUFEntradaComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_cbUFEntradaComponentAdded
        // TODO add your handling code here:
        List<Municipio> municipios;        
        municipios = MunicipioDB.selectAllByState(cbUFEntrada.getSelectedItem().toString());
        this.cbCidadeEntrada.removeAllItems();
        for(Municipio municipio: municipios){
            this.cbCidadeEntrada.addItem(municipio.getNome());
        }
    }//GEN-LAST:event_cbUFEntradaComponentAdded

    private void btnPesquisarSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarSaidaActionPerformed
        // TODO add your handling code here:
        this.entrada = EntradaVeiculoDB.checaDisponibilidadeVeiculoPorPlaca(this.txtPesquisarEntrada.getText());
            if(this.entrada != null){                   
                    //preenche formulario saída veiculo
                    preencheResultadoConsulta();                   
                }else{                   
                    JOptionPane.showMessageDialog(this, "Veículo não encontrado ou não disponível");
                }
    }//GEN-LAST:event_btnPesquisarSaidaActionPerformed

    private void txtPesquisarEntradaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPesquisarEntradaMouseReleased
        // TODO add your handling code here:
  
    }//GEN-LAST:event_txtPesquisarEntradaMouseReleased

    private void txtPesquisarEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarEntradaKeyReleased
        // TODO add your handling code here:
        this.txtPesquisarEntrada.setText(this.txtPesquisarEntrada.getText().toUpperCase());
    }//GEN-LAST:event_txtPesquisarEntradaKeyReleased

    private void preencheResultadoConsulta(){
        
                this.txtMarcaEntrada.setText(entrada.getMarca());
                this.txtModeloEntrada.setText(entrada.getModelo());
                this.txtRenavamEntrada.setText(entrada.getRenavam());
                this.txtChassiEntrada.setText(entrada.getChassi());
                this.txtPlacaEntrada.setText(entrada.getPlaca());
                this.cbAnoEntrada.setSelectedItem(entrada.getAno());
                this.cbCorEntrada.setSelectedItem(entrada.getCor());
                this.DataChooserEntrada.setDate(entrada.getData_entrada());                  
                this.txtProprietarioEntrada.setText(entrada.getNome_proprietario());
                this.txtTelefoneEntrada.setText(entrada.getTelefone()); 
                this.txtWhatsappEntrada.setText(entrada.getWhatsapp());
                Municipio municipio;
                municipio = MunicipioDB.searchById(entrada.getId_municipio()); 
                Estado estado;
                estado = EstadoDB.searchById(municipio.getId_uf());                  
                this.cbUFEntrada.setSelectedItem(estado.getNome());
                this.cbCidadeEntrada.setSelectedItem(municipio.getNome());
    }
    
    
    private void limparCamposForm(){
        this.txtChassiEntrada.setText("");
        this.txtMarcaEntrada.setText("");
        this.txtModeloEntrada.setText("");
        this.txtPlacaEntrada.setText("");
        this.txtRenavamEntrada.setText("");
        this.txtProprietarioEntrada.setText("");
        this.txtTelefoneEntrada.setText("");
        this.txtWhatsappEntrada.setText("");
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DataChooserEntrada;
    private javax.swing.JButton btnExcluirEntrada;
    private javax.swing.JButton btnImprimirEntrada;
    private javax.swing.JButton btnLimparFormularioEntrada;
    private javax.swing.JButton btnPesquisarSaida;
    private javax.swing.JButton btnSalvarSaida;
    private javax.swing.JComboBox<String> cbAnoEntrada;
    private javax.swing.JComboBox<String> cbCidadeEntrada;
    private javax.swing.JComboBox<String> cbCorEntrada;
    private javax.swing.JComboBox<String> cbUFEntrada;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtChassiEntrada;
    private javax.swing.JTextField txtMarcaEntrada;
    private javax.swing.JTextField txtModeloEntrada;
    private javax.swing.JTextField txtPesquisarEntrada;
    private javax.swing.JTextField txtPlacaEntrada;
    private javax.swing.JTextField txtProprietarioEntrada;
    private javax.swing.JTextField txtRenavamEntrada;
    private javax.swing.JFormattedTextField txtTelefoneEntrada;
    private javax.swing.JFormattedTextField txtWhatsappEntrada;
    // End of variables declaration//GEN-END:variables
}
