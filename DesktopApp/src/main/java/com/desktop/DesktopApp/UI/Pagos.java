/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.Mes;
import com.desktop.DesktopApp.Entity.PagoEntity;
import com.desktop.DesktopApp.Entity.UsuarioEntity;
import com.desktop.DesktopApp.Repository.PagoRepository;
import com.desktop.DesktopApp.Repository.UsuarioRepository;
import com.desktop.DesktopApp.Swing.PagoTableModel;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Juan
 */
public class Pagos extends javax.swing.JFrame {

    private UsuarioEntity usuario;
    private PagoRepository pagoRepository;
    private UsuarioRepository usuarioRepository;
    private PagoTableModel pagoTableModel = new PagoTableModel();

    /** Creates new form Pagos */
    public Pagos(Long usuarioId, PagoRepository pagoRepository, UsuarioRepository usuarioRepository) {
        initComponents();
        this.usuarioRepository = usuarioRepository;
        this.usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        this.pagoRepository = pagoRepository;
        cargarTabla();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void cargarTabla() {
        pagoTableModel.setRowCount(0);
        /*List<Mes> mesesPagados = new ArrayList<>();
        List<PagoEntity> pagos = pagoRepository.findAll();
        List<Mes> mesesNoPagados = new ArrayList<>();
        for (PagoEntity pago : pagos) {
            mesesPagados.add(pago.getMes());
        }

        for (Mes mes : Mes.values()) {
            if (!mesesPagados.contains(mes)) {
                mesesNoPagados.add(mes);
            }
        }

        for (Mes mes : mesesNoPagados) {
            double monto = 10000;
            LocalDateTime now = LocalDateTime.now();
            if (now.getMonth().getValue() - 1 == mes.ordinal() && now.getDayOfMonth() > 15) {
                monto = monto + (monto * 0.1);
            } else if(now.getMonth().getValue() - 1 > mes.ordinal()){
                monto = monto + (monto * 0.2);
            }*/
        List<Mes> mesesPagados = pagoRepository.findAll().stream()
                .map(PagoEntity::getMes)
                .collect(Collectors.toList());

        double monto;
        for (Mes mes : Mes.values()) {
            if (!mesesPagados.contains(mes)) {
                monto = 10000;
                LocalDateTime now = LocalDateTime.now();
                if (now.getMonthValue() == mes.ordinal() + 3 && now.getDayOfMonth() > 15) {
                    monto += monto * 0.1;
                } else if (now.getMonthValue() > mes.ordinal() + 3) {
                    monto += monto * 0.2;
                }
                pagoTableModel.addRow(new Object[] {mes.name(), monto});
            }
        }
        jTable1.setModel(pagoTableModel);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pagarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(13, 14, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cuotas a pagar");

        pagarButton.setForeground(new java.awt.Color(51, 51, 51));
        pagarButton.setText("Pagar");
        pagarButton.setBorder(null);
        pagarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarButtonActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(27, 28, 49));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pagarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(pagarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarButtonActionPerformed
        PagoCuota pagoCuota = new PagoCuota(usuario, (String) jTable1.getValueAt(jTable1.getSelectedRow(), 0),
                jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString(), pagoRepository);
    }//GEN-LAST:event_pagarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pagarButton;
    // End of variables declaration//GEN-END:variables

}
