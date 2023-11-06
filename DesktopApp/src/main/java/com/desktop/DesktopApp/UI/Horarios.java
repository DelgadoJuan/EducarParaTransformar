/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.*;
import com.desktop.DesktopApp.Repository.UsuarioRepository;
import com.desktop.DesktopApp.Swing.HorarioTableModel;

/**
 *
 * @author Juan
 */
public class Horarios extends javax.swing.JFrame {
    private UsuarioEntity usuario;
    private HorarioTableModel horarioTableModel = new HorarioTableModel();

    /**
     * Creates new form Horarios
     */
    public Horarios(Long usuarioId, UsuarioRepository usuarioRepository) {
        initComponents();
        this.usuario = usuarioRepository.findById(usuarioId).orElseThrow();
        cargarTabla();
        this.setVisible(true);
    }

    private void cargarTabla (){
        if (usuario.getRol().equals(Roles.Profesor)) {
            ProfesorEntity profesor = (ProfesorEntity) usuario;
            if (!profesor.getMaterias().isEmpty()) {
                for (MateriaEntity materia : profesor.getMaterias()) {
                    String horarios = "";
                    for (HorarioEntity horario : materia.getHorarios()) {
                        horarios += horario.getDia() + " " + horario.getInicio() + "-" + horario.getFin();
                        if (materia.getHorarios().indexOf(horario) < materia.getHorarios().size() - 1) {
                            horarios += ", ";
                        }
                    }
                    horarioTableModel.addRow(new Object[]{materia.getNombre(), horarios});
                }
                jTable1.setModel(horarioTableModel);
            }
        } else if (usuario.getRol().equals(Roles.Titular)) {
            TitularEntity titular = (TitularEntity) usuario;
            if (!titular.getHijo().getCurso().getMaterias().isEmpty()) {
                for (MateriaEntity materia : titular.getHijo().getCurso().getMaterias()) {
                    String horarios = "";
                    for (HorarioEntity horario : materia.getHorarios()) {
                        horarios += horario.getDia() + " " + horario.getInicio() + "-" + horario.getFin();
                        if (materia.getHorarios().indexOf(horario) < materia.getHorarios().size() - 1) {
                            horarios += ", ";
                        }
                    }
                    horarioTableModel.addRow(new Object[]{materia.getNombre(), horarios});
                }
                jTable1.setModel(horarioTableModel);
            }
        } else {
            EstudianteEntity estudiante = (EstudianteEntity) usuario;
            if (!estudiante.getCurso().getMaterias().isEmpty()) {
                for (MateriaEntity materia : estudiante.getCurso().getMaterias()) {
                    String horarios = "";
                    for (HorarioEntity horario : materia.getHorarios()) {
                        horarios += horario.getDia() + " " + horario.getInicio() + "-" + horario.getFin();
                        if (materia.getHorarios().indexOf(horario) < materia.getHorarios().size() - 1) {
                            horarios += ", ";
                        }
                    }
                    horarioTableModel.addRow(new Object[]{materia.getNombre(), horarios});
                }
                jTable1.setModel(horarioTableModel);
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(78, 170, 233));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Horarios");

        jTable1.setModel(horarioTableModel);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}