/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.ProfesorEntity;
import com.desktop.DesktopApp.Entity.Roles;
import com.desktop.DesktopApp.Entity.UsuarioEntity;
import com.desktop.DesktopApp.Repository.*;
import com.desktop.DesktopApp.Swing.EstudianteTableModel;

import javax.swing.*;

/**
 *
 * @author Juan
 */
public class ListadoAlumnos extends javax.swing.JFrame {

    private EstudianteRepository estudianteRepository;
    private CursoRepository cursoRepository;
    private UsuarioEntity usuario;
    private TitularRepository titularRepository;
    private MateriaRepository materiaRepository;
    private UsuarioRepository usuarioRepository;
    private EstudianteTableModel estudianteTableModel = new EstudianteTableModel();


    /**
     * Creates new form ListadoAlumnos
     */
    public ListadoAlumnos(Long usuarioId, EstudianteRepository estudianteRepository,
                          CursoRepository cursoRepository, TitularRepository titularRepository,
                          MateriaRepository materiaRepository, UsuarioRepository usuarioRepository) {
        this.estudianteRepository = estudianteRepository;
        this.titularRepository = titularRepository;
        this.usuarioRepository = usuarioRepository;
        this.usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        this.cursoRepository = cursoRepository;
        this.materiaRepository = materiaRepository;
        initComponents();
        if (usuario.getRol().equals(Roles.Profesor)) {
            modificarButton.setText("Cargar nota");
        }
        this.jComboBox1.addItem("Todos");
        cargarComboBox();
        this.setVisible(true);
    }

    private void cargarComboBox() {
        if (usuario.getRol().equals(Roles.Profesor)) {
            ProfesorEntity profesor = (ProfesorEntity) usuario;
            profesor.getMaterias().forEach(materiaEntity -> jComboBox1.addItem(materiaEntity.getCurso().getAño()));
            JOptionPane.showMessageDialog(null, profesor.getMaterias().size());
        } else {
            cursoRepository.findAll().forEach(curso -> jComboBox1.addItem(curso.getAño()));
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
        jComboBox1 = new javax.swing.JComboBox<>();
        buscarAlumnosButton = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        modificarButton = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(78, 170, 233));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de alumnos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Curso:");

        jComboBox1.setToolTipText("");
        jComboBox1.setName(""); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buscarAlumnosButton.setBackground(new java.awt.Color(255, 255, 255));
        buscarAlumnosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarAlumnosButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buscarAlumnosButton.setLabel("Buscar");
        buscarAlumnosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAlumnosButtonActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Email", "Fecha de nacimiento"
            }
        ));
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable2.setFillsViewportHeight(true);
        jTable2.setFocusable(false);
        jTable2.setShowGrid(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable2);

        modificarButton.setText("Modificar");
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modificarButton)
                .addGap(151, 151, 151)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarAlumnosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(buscarAlumnosButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(modificarButton))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void buscarAlumnosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAlumnosButtonActionPerformed
        estudianteTableModel.setRowCount(0);
        if (jComboBox1.getSelectedItem().toString().equals("Todos")) {
            estudianteRepository.findAll().stream().forEach(estudianteEntity -> estudianteTableModel.addRow(new Object[]{estudianteEntity.getUsername(), estudianteEntity.getNombre(),
                    estudianteEntity.getEmail(), estudianteEntity.getFechaNacimiento()}));
        } else {
            estudianteRepository.findAll().stream().
                    filter(estudianteEntity -> estudianteEntity.getCurso().getAño().equals(jComboBox1.getSelectedItem())).
                    forEach(estudianteEntity -> estudianteTableModel.addRow(new Object[]{estudianteEntity.getUsername(), estudianteEntity.getNombre(),
                            estudianteEntity.getEmail(), estudianteEntity.getFechaNacimiento()}));
        }
        jTable2.setModel(estudianteTableModel);
    }//GEN-LAST:event_buscarAlumnosButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        if (usuario.getRol().equals(Roles.Profesor)) {
            CargarCalificacion calificacion = new CargarCalificacion(estudianteRepository.
                    findByUsername((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0)),
                    usuario, estudianteRepository, materiaRepository);
        } else {
            ModificarEstudiante modificarEstudiante = new ModificarEstudiante(estudianteRepository.findByUsername((String) jTable2.getValueAt(jTable2.getSelectedRow(), 0))
                    , estudianteRepository, cursoRepository, titularRepository);
        }
    }//GEN-LAST:event_modificarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buscarAlumnosButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modificarButton;
    // End of variables declaration//GEN-END:variables
}
