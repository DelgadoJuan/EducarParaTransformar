/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.CursoEntity;
import com.desktop.DesktopApp.Entity.EstudianteEntity;
import com.desktop.DesktopApp.Entity.TitularEntity;
import com.desktop.DesktopApp.Repository.CursoRepository;
import com.desktop.DesktopApp.Repository.EstudianteRepository;
import com.desktop.DesktopApp.Repository.TitularRepository;

import javax.swing.*;
import java.util.List;

/**
 *
 * @author Juan
 */
public class ModificarEstudiante extends javax.swing.JFrame {
    private EstudianteEntity estudiante;
    private EstudianteRepository estudianteRepository;
    private CursoRepository cursoRepository;
    private TitularRepository titularRepository;

    /**
     * Creates new form ModificarEstudiante
     */
    public ModificarEstudiante(EstudianteEntity estudiante, EstudianteRepository estudianteRepository,
                               CursoRepository cursoRepository, TitularRepository titularRepository) {
        this.estudiante = estudiante;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
        this.titularRepository = titularRepository;
        initComponents();
        this.nombreAlumnoLabel.setText(estudiante.getNombre());
        this.dniLabel.setText(estudiante.getUsername());
        cargar();
        this.setVisible(true);
    }

    private void cargar() {
        List<CursoEntity> cursos = cursoRepository.findAll();
        List<TitularEntity> titulares = titularRepository.findAll();

        for (CursoEntity curso : cursos) {
            comboCurso.addItem(curso.getAño());
        }
        for (TitularEntity titular: titulares) {
            comboTitular.addItem(titular.getUsername());
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
        comboCurso = new javax.swing.JComboBox<>();
        comboTitular = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreAlumnoLabel = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        aceptarButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Asignar curso");

        jLabel2.setText("Asignar titular");

        jLabel3.setText("Alumno:");

        jLabel4.setText("DNI:");

        nombreAlumnoLabel.setText("jLabel5");

        dniLabel.setText("jLabel6");

        aceptarButton.setText("Aceptar");
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboTitular, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreAlumnoLabel)
                            .addComponent(dniLabel)
                            .addComponent(aceptarButton))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreAlumnoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dniLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(comboCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(comboTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(aceptarButton)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        this.estudiante.setCurso(cursoRepository.findByAño(comboCurso.getSelectedItem().toString()));
        TitularEntity titular = titularRepository.findByUsername(comboTitular.getSelectedItem().toString());
        this.estudiante.setTitular(titular);
        titular.setHijo(estudiante);
        titularRepository.save(titular);
        estudianteRepository.save(estudiante);
        JOptionPane.showMessageDialog(null, "Modificación realizada");
        this.dispose();
    }//GEN-LAST:event_aceptarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JComboBox<String> comboCurso;
    private javax.swing.JComboBox<String> comboTitular;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel nombreAlumnoLabel;
    // End of variables declaration//GEN-END:variables
}