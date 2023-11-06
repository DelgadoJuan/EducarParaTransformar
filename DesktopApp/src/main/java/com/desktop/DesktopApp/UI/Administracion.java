/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Repository.CursoRepository;
import com.desktop.DesktopApp.Repository.HorarioRepository;
import com.desktop.DesktopApp.Repository.MateriaRepository;
import com.desktop.DesktopApp.Repository.ProfesorRepository;

import javax.swing.*;

/**
 *
 * @author Juan
 */
public class Administracion extends javax.swing.JFrame {
    private MateriaRepository materiaRepository;
    private CursoRepository cursoRepository;
    private HorarioRepository horarioRepository;
    private ProfesorRepository profesorRepository;

    /**
     * Creates new form Administracion
     */
    public Administracion(CursoRepository cursoRepository, MateriaRepository materiaRepository,
                          HorarioRepository horarioRepository, ProfesorRepository profesorRepository) {
        this.cursoRepository = cursoRepository;
        this.horarioRepository = horarioRepository;
        this.materiaRepository = materiaRepository;
        this.profesorRepository = profesorRepository;
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cursoButton = new javax.swing.JButton();
        materiaButton = new javax.swing.JButton();
        horarioButton = new javax.swing.JButton();
        asignarProfesorButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        cursoButton.setText("Crear curso");
        cursoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cursoButtonActionPerformed(evt);
            }
        });

        materiaButton.setText("Crear materia");
        materiaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiaButtonActionPerformed(evt);
            }
        });

        horarioButton.setText("Crear horario");
        horarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarioButtonActionPerformed(evt);
            }
        });

        asignarProfesorButton.setText("Asignar profesor");
        asignarProfesorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asignarProfesorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(asignarProfesorButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cursoButton)
                        .addGap(30, 30, 30)
                        .addComponent(materiaButton)
                        .addGap(18, 18, 18)
                        .addComponent(horarioButton)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cursoButton)
                    .addComponent(materiaButton)
                    .addComponent(horarioButton))
                .addGap(46, 46, 46)
                .addComponent(asignarProfesorButton)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cursoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cursoButtonActionPerformed
        CrearCurso crearCurso = new CrearCurso(cursoRepository);
    }//GEN-LAST:event_cursoButtonActionPerformed

    private void materiaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaButtonActionPerformed
        CrearMateria crearMateria = new CrearMateria(materiaRepository, cursoRepository);
    }//GEN-LAST:event_materiaButtonActionPerformed

    private void horarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarioButtonActionPerformed
        CrearHorario crearHorario = new CrearHorario(materiaRepository, horarioRepository);
    }//GEN-LAST:event_horarioButtonActionPerformed

    private void asignarProfesorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asignarProfesorButtonActionPerformed
        AsignarProfesor asignarProfesor = new AsignarProfesor(profesorRepository, materiaRepository);
    }//GEN-LAST:event_asignarProfesorButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton asignarProfesorButton;
    private javax.swing.JButton cursoButton;
    private javax.swing.JButton horarioButton;
    private javax.swing.JButton materiaButton;
    // End of variables declaration//GEN-END:variables
}