/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.CursoEntity;
import com.desktop.DesktopApp.Entity.ProfesorEntity;
import com.desktop.DesktopApp.Entity.Roles;
import com.desktop.DesktopApp.Entity.UsuarioEntity;
import com.desktop.DesktopApp.Repository.*;
import com.desktop.DesktopApp.Swing.EstudianteTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

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
        cargarComboBox();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        totalAlumnosLabel.setText("0");
        fechaLabel.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        this.setVisible(true);
    }

    private void cargarComboBox() {
        if (usuario.getRol().equals(Roles.Profesor)) {
            ProfesorEntity profesor = (ProfesorEntity) usuario;
            profesor.getMaterias().forEach(materiaEntity -> jComboBox1.addItem(materiaEntity.getCurso().getAño()));
        } else {
            jComboBox1.addItem("Todos");
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
        jLabel3 = new javax.swing.JLabel();
        totalAlumnosLabel = new javax.swing.JLabel();
        pdfButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(13, 14, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Listado de alumnos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Curso:");

        jComboBox1.setForeground(new java.awt.Color(102, 102, 102));
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
        buscarAlumnosButton.setForeground(new java.awt.Color(102, 102, 102));
        buscarAlumnosButton.setLabel("Buscar");
        buscarAlumnosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAlumnosButtonActionPerformed(evt);
            }
        });

        jTable2.setBackground(new java.awt.Color(27, 28, 49));
        jTable2.setForeground(new java.awt.Color(255, 255, 255));
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

        modificarButton.setForeground(new java.awt.Color(51, 51, 51));
        modificarButton.setText("Modificar");
        modificarButton.setBorder(null);
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total de alumnos: ");

        totalAlumnosLabel.setForeground(new java.awt.Color(204, 204, 204));
        totalAlumnosLabel.setText("jLabel4");

        pdfButton.setForeground(new java.awt.Color(51, 51, 51));
        pdfButton.setText("Descargar PDF");
        pdfButton.setBorder(null);
        pdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfButtonActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha:");

        fechaLabel.setForeground(new java.awt.Color(204, 204, 204));
        fechaLabel.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarAlumnosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalAlumnosLabel)
                .addGap(85, 85, 85)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pdfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1))
                    .addComponent(modificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscarAlumnosButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(totalAlumnosLabel)
                            .addComponent(jLabel4)
                            .addComponent(fechaLabel))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pdfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
        AtomicInteger cantAlumnos = new AtomicInteger();
        if (jComboBox1.getSelectedItem().equals("Todos")) {
            estudianteRepository.findAll().stream()
                    .sorted(Comparator.comparing(UsuarioEntity::getNombre))
                    .forEach(estudianteEntity -> {
                        estudianteTableModel.addRow(new Object[]{estudianteEntity.getUsername(),
                                estudianteEntity.getNombre(),
                                estudianteEntity.getEmail(),
                                estudianteEntity.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        });
                        cantAlumnos.getAndIncrement();
                    });
        } else {
            estudianteRepository.findAll().stream()
                    .filter(estudianteEntity -> {
                        CursoEntity curso = estudianteEntity.getCurso();
                        return curso != null && curso.getAño().equals(jComboBox1.getSelectedItem());
                    })
                    .sorted(Comparator.comparing(UsuarioEntity::getNombre))
                    .forEach(estudianteEntity -> {
                        estudianteTableModel.addRow(new Object[]{estudianteEntity.getUsername(),
                                estudianteEntity.getNombre(),
                                estudianteEntity.getEmail(),
                                estudianteEntity.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        });
                        cantAlumnos.getAndIncrement();
                    });
        }
        totalAlumnosLabel.setText(cantAlumnos.toString());
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

    private void pdfButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfButtonActionPerformed
        try{
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            PDImageXObject logo = PDImageXObject.createFromFile("src/main/resources/images/logo 100px.png", documento);
            float logoWidth = 60; // Ancho del logo en puntos
            float logoHeight = 60; // Altura del logo en puntos
            contenido.drawImage(logo, 10, pagina.getMediaBox().getHeight() - logoHeight - 10, logoWidth, logoHeight);

            contenido.beginText();
            contenido.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 16);
            String titulo = "Listado de alumnos";
            float anchoTitulo = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD).getStringWidth(titulo) / 1000 * 18; // Ancho del título en puntos
            float xTitulo = (pagina.getMediaBox().getWidth() - anchoTitulo) / 2; // Centrar en el eje X
            float yTitulo = pagina.getMediaBox().getHeight() - 100; // Posición fija en el eje Y
            contenido.newLineAtOffset(xTitulo, yTitulo);
            contenido.showText(titulo);

            contenido.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);
            contenido.newLineAtOffset(-40, -40);
            contenido.showText("Curso: " + jComboBox1.getSelectedItem());
            contenido.newLineAtOffset(0, -20);
            contenido.showText("Cantidad de alumnos: " + totalAlumnosLabel.getText());
            contenido.newLineAtOffset(0, -20);
            contenido.showText("Fecha:  " + fechaLabel.getText());
            contenido.endText();

            DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
            int numFilas = modelo.getRowCount();
            int numColumnas = modelo.getColumnCount();

            float margin = 5; // Margen izquierdo
            float yStart = pagina.getMediaBox().getHeight() - 200; // Posición inicial en el eje Y
            float tableWidth = pagina.getMediaBox().getWidth() - 2 * margin;
            float yPosition = yStart;
            float rowHeight = 20f;
            float[] tableWidths = new float[numColumnas];

            // Calcular el ancho máximo necesario para cada celda en función del contenido
            for (int i = 0; i < numColumnas; i++) {
                tableWidths[i] = tableWidth / (float) numColumnas;

                for (int j = 0; j < numFilas; j++) {
                    String cellData = modelo.getValueAt(j, i).toString();
                    float cellWidth = new PDType1Font(Standard14Fonts.FontName.HELVETICA).getStringWidth(cellData) / 1000 * 10;
                    if (cellWidth > tableWidths[i]) {
                        tableWidths[i] = cellWidth;
                    }
                }
            }

            // Dibuja los encabezados de columna y ajusta el ancho máximo de las celdas
            float currentX = margin;
            float currentY = yStart;
            for (int i = 0; i < numColumnas; i++) {
                contenido.addRect(currentX, currentY - rowHeight, tableWidths[i], rowHeight);
                contenido.stroke();
                contenido.beginText();
                contenido.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);
                contenido.newLineAtOffset(currentX + 2, currentY - 15);
                String columnName = modelo.getColumnName(i);
                if (columnName.equals("Fecha de nacimiento")) {
                    contenido.showText("Nac");
                } else {
                    contenido.showText(columnName);
                }
                contenido.endText();
                currentX += tableWidths[i];
            }

            // Dibuja las celdas de la tabla y ajusta el ancho de las celdas según su contenido
            for (int i = 0; i < numFilas; i++) {
                currentX = margin;
                currentY -= rowHeight;
                for (int j = 0; j < numColumnas; j++) {
                    contenido.addRect(currentX, currentY - rowHeight, tableWidths[j], rowHeight);
                    contenido.stroke();
                    contenido.beginText();
                    contenido.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8);
                    contenido.newLineAtOffset(currentX + 2, currentY - 15);
                    String cellData = modelo.getValueAt(i, j).toString();

                    // Divide el contenido de la celda en varias líneas si es demasiado largo
                    String[] lines = cellData.split("\n");
                    float lineHeight = 12; // Altura de línea estimada
                    float currentYText = currentY - 15;

                    for (String line : lines) {
                        contenido.showText(line);
                        currentYText -= lineHeight;
                        contenido.newLineAtOffset(currentX, currentYText);
                    }

                    contenido.endText();
                    currentX += tableWidths[j];
                }
            }

            contenido.close();

            // Ajusta el ancho de las celdas
            for (int i = 0; i < numColumnas; i++) {
                tableWidths[i] += 5; // Un pequeño espacio entre celdas
            }

            String nombreArchivo = "ListadoAlumnos-" + jComboBox1.getSelectedItem() + "-" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".pdf";
            FileSystemView fileSystemView = FileSystemView.getFileSystemView();

            // Obtenemos el directorio de descargas del usuario
            File downloadsDir = fileSystemView.getDefaultDirectory();

            // Comprobamos si existe la carpeta de descargas
            if (downloadsDir != null && downloadsDir.exists()) {
                // Ruta completa del archivo a guardar en la carpeta de descargas
                String directorioDestino = downloadsDir.getAbsolutePath() + File.separator + nombreArchivo;
                documento.save(directorioDestino);
                JOptionPane.showMessageDialog(null, "PDF descargado en su carpeta Documentos");
            } else {
                System.out.println("No se encontró la carpeta de documentos del usuario");
            }
        }catch(Exception err){
            System.out.println(" " + err);
        }
    }//GEN-LAST:event_pdfButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button buscarAlumnosButton;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modificarButton;
    private javax.swing.JButton pdfButton;
    private javax.swing.JLabel totalAlumnosLabel;
    // End of variables declaration//GEN-END:variables
}
