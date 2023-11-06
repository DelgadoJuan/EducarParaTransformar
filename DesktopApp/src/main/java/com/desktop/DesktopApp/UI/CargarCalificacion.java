/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.*;
import com.desktop.DesktopApp.Repository.EstudianteRepository;
import com.desktop.DesktopApp.Repository.MateriaRepository;

import javax.swing.*;

/**
 *
 * @author Juan
 */
public class CargarCalificacion extends javax.swing.JFrame {

    private MateriaRepository materiaRepository;
    private EstudianteEntity estudiante;
    private EstudianteRepository estudianteRepository;
    private ProfesorEntity profesor;

    /**
     * Creates new form CargarCalificacion
     */
    public CargarCalificacion(EstudianteEntity estudiante, UsuarioEntity profesor, EstudianteRepository estudianteRepository, MateriaRepository materiaRepository) {
        this.estudiante = estudiante;
        this.estudianteRepository = estudianteRepository;
        this.materiaRepository = materiaRepository;
        this.profesor = (ProfesorEntity) profesor;
        initComponents();
        this.jLabel7.setText(estudiante.getNombre());
        this.jLabel8.setText(estudiante.getUsername());
        cargarMaterias();
        this.setVisible(true);
    }

    private void cargarMaterias() {
        for (MateriaEntity materia: profesor.getMaterias()) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        materiaCombo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        descripcionField = new javax.swing.JTextField();
        notaSpinner = new javax.swing.JSpinner();
        aceptarButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Calificacion");

        jLabel2.setText("Estudiante");

        jLabel3.setText("DNI");

        jLabel4.setText("Materia");

        jLabel5.setText("Descripcion");

        jLabel6.setText("Nota");

        notaSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(aceptarButton)
                                .addGap(44, 44, 44))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(notaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(materiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(materiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(descripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(notaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(aceptarButton)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        if (descripcionField.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "La descripcion no puede estar vacía");
        } else {
            estudiante.getCalificaciones().add(new CalificacionEntity((int) notaSpinner.getValue(), descripcionField.getText(),
                    estudiante, materiaRepository.findByNombre(materiaCombo.getSelectedItem().toString())));
            estudianteRepository.save(estudiante);
            JOptionPane.showMessageDialog(null, "Operación realizada");
            this.dispose();
        }
    }//GEN-LAST:event_aceptarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JTextField descripcionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> materiaCombo;
    private javax.swing.JSpinner notaSpinner;
    // End of variables declaration//GEN-END:variables
}