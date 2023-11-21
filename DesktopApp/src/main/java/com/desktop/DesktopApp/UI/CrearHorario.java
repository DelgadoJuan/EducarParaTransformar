/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.Dia;
import com.desktop.DesktopApp.Entity.HorarioEntity;
import com.desktop.DesktopApp.Entity.MateriaEntity;
import com.desktop.DesktopApp.Repository.HorarioRepository;
import com.desktop.DesktopApp.Repository.MateriaRepository;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

/**
 *
 * @author Juan
 */
public class CrearHorario extends javax.swing.JFrame {

    private MateriaRepository materiaRepository;
    private HorarioRepository horarioRepository;

    /**
     * Creates new form CrearHorario
     */
    public CrearHorario(MateriaRepository materiaRepository, HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
        this.materiaRepository = materiaRepository;
        initComponents();
        cargarMaterias();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void cargarMaterias() {
        for (MateriaEntity materia : materiaRepository.findAll()) {
            materiaCombo.addItem(materia.getNombre());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        aceptarButton = new javax.swing.JButton();
        finField = new javax.swing.JTextField();
        inicioField = new javax.swing.JTextField();
        diaCombo = new javax.swing.JComboBox<>();
        materiaCombo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 28, 49));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(62, 62, 123));
        jLabel1.setText("Materia");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Materia");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Dia");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Hora de inicio");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Hora de fin");

        aceptarButton.setBackground(new java.awt.Color(49, 49, 84));
        aceptarButton.setForeground(new java.awt.Color(255, 255, 255));
        aceptarButton.setText("Aceptar");
        aceptarButton.setBorder(null);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        finField.setBackground(new java.awt.Color(27, 28, 49));
        finField.setForeground(new java.awt.Color(255, 255, 255));
        finField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        inicioField.setBackground(new java.awt.Color(27, 28, 49));
        inicioField.setForeground(new java.awt.Color(255, 255, 255));
        inicioField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        diaCombo.setBackground(new java.awt.Color(27, 28, 49));
        diaCombo.setForeground(new java.awt.Color(255, 255, 255));
        diaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" }));
        diaCombo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        materiaCombo.setBackground(new java.awt.Color(27, 28, 49));
        materiaCombo.setForeground(new java.awt.Color(255, 255, 255));
        materiaCombo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Detalle los horarios de la materia que desee modificar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addContainerGap(381, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(aceptarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(materiaCombo, 0, 244, Short.MAX_VALUE)
                                    .addComponent(inicioField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(diaCombo, 0, 225, Short.MAX_VALUE)
                                    .addComponent(finField))))
                        .addGap(149, 149, 149))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(105, 105, 105)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(finField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if (inicioField.getText().isBlank() || finField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null,"Rellene todos los campos");
        } else {
            try {
                LocalTime inicio = LocalTime.parse(inicioField.getText(), DateTimeFormatter.ofPattern("HH:mm"));
                LocalTime fin = LocalTime.parse(finField.getText(), DateTimeFormatter.ofPattern("HH:mm"));
                MateriaEntity materia = materiaRepository.findByNombre(materiaCombo.getSelectedItem().toString());
                HorarioEntity horario = new HorarioEntity(materia,
                        Dia.valueOf(diaCombo.getSelectedItem().toString()), inicio, fin);
                horarioRepository.save(horario);
                materia.getHorarios().add(horario);
                materiaRepository.save(materia);
                JOptionPane.showMessageDialog(null, "Operación realizada");
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Fecha no válida");
            }
        }//GEN-LAST:event_aceptarButtonActionPerformed
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JComboBox<String> diaCombo;
    private javax.swing.JTextField finField;
    private javax.swing.JTextField inicioField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> materiaCombo;
    // End of variables declaration//GEN-END:variables
}
