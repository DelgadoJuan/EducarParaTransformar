/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.PagoEntity;
import com.desktop.DesktopApp.Entity.TipoPago;
import com.desktop.DesktopApp.Repository.PagoRepository;
import com.desktop.DesktopApp.Swing.InformeTableModel;
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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Juan
 */
public class Informes extends javax.swing.JFrame {
    private InformeTableModel informeTableModel = new InformeTableModel();
    private PagoRepository pagoRepository;

    /**
     * Creates new form Informes
     */
    public Informes(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
        initComponents();
        fechaLabel.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        cantidadLabel.setText("0");
        jTable1.setModel(informeTableModel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void cargarTabla() {
        informeTableModel.setRowCount(0);
        AtomicInteger cantPagos = new AtomicInteger();
        List<PagoEntity> pagos = pagoRepository.findByTipoPago(TipoPago.valueOf(tipoComboBox.getSelectedItem().toString()));
        if(pagos.isEmpty()){
            JOptionPane.showMessageDialog(null,"No existen pagos registrados");
        }
        else {
            for (PagoEntity pago : pagos) {
                if (pago.getFechaPago().isAfter(LocalDateTime.ofInstant(jDateChooser1.getDate().toInstant(), ZoneId.systemDefault()))
                        && pago.getFechaPago().isBefore(LocalDateTime.ofInstant(jDateChooser2.getDate().toInstant(), ZoneId.systemDefault()))) {
                    cantPagos.getAndIncrement();
                    informeTableModel.addRow(new Object[]{pago.getTitular().getUsername(), pago.getTitular().getNombre(), pago.getMes().toString(),
                            pago.getFechaPago().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), pago.getMonto()});
                }
            }
            cantidadLabel.setText(cantPagos.toString());
            jTable1.setModel(informeTableModel);
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

        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        tipoComboBox = new javax.swing.JComboBox<>();
        buscarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cantidadLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        pdfButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(13, 14, 35));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Inicio");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fin");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de pago");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Informes de pago");

        jDateChooser1.setBackground(new java.awt.Color(78, 170, 233));
        jDateChooser1.setForeground(new java.awt.Color(102, 102, 102));

        jDateChooser2.setBackground(new java.awt.Color(78, 170, 233));
        jDateChooser2.setForeground(new java.awt.Color(102, 102, 102));

        tipoComboBox.setForeground(new java.awt.Color(102, 102, 102));
        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credito", "Debito", "Efectivo" }));
        tipoComboBox.setBorder(null);

        buscarButton.setForeground(new java.awt.Color(51, 51, 51));
        buscarButton.setText("Buscar");
        buscarButton.setBorder(null);
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
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

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cantidad de pagos:");

        cantidadLabel.setBackground(new java.awt.Color(255, 255, 255));
        cantidadLabel.setForeground(new java.awt.Color(204, 204, 204));
        cantidadLabel.setText("jLabel6");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha:");

        fechaLabel.setBackground(new java.awt.Color(255, 255, 255));
        fechaLabel.setForeground(new java.awt.Color(204, 204, 204));
        fechaLabel.setText("jLabel7");

        pdfButton.setForeground(new java.awt.Color(51, 51, 51));
        pdfButton.setText("Descargar PDF");
        pdfButton.setBorder(null);
        pdfButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tipoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cantidadLabel)
                .addGap(64, 64, 64)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fechaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pdfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(tipoComboBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cantidadLabel)
                    .addComponent(jLabel6)
                    .addComponent(fechaLabel)
                    .addComponent(pdfButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
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

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        cargarTabla();
    }//GEN-LAST:event_buscarButtonActionPerformed

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
            String titulo = "Informe de pagos";
            float anchoTitulo = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD).getStringWidth(titulo) / 1000 * 18; // Ancho del título en puntos
            float xTitulo = (pagina.getMediaBox().getWidth() - anchoTitulo) / 2; // Centrar en el eje X
            float yTitulo = pagina.getMediaBox().getHeight() - 100; // Posición fija en el eje Y
            contenido.newLineAtOffset(xTitulo, yTitulo);
            contenido.showText(titulo);

            contenido.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);
            contenido.newLineAtOffset(-40, -40);
            contenido.showText("Tipo de pago: " + tipoComboBox.getSelectedItem());
            contenido.newLineAtOffset(0, -20);
            contenido.showText("Cantidad de pagos: " + cantidadLabel.getText());
            contenido.newLineAtOffset(0, -20);
            contenido.showText("Fecha actual:  " + fechaLabel.getText());
            contenido.endText();

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
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
                if (columnName.equals("Fecha de pago")) {
                    contenido.showText("F. Pago");
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

            String nombreArchivo = "InformePagos-" + tipoComboBox.getSelectedItem() + "-" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + ".pdf";
            String nombreCarpetaPDF = "Descargas EPT";
            String rutaCarpetaPDF = "C:" + File.separator + nombreCarpetaPDF;

            File carpetaPDF = new File(rutaCarpetaPDF);
            if (!carpetaPDF.exists()) {
                carpetaPDF.mkdir(); // Crea la carpeta si no existe
            }

            String directorioDestino = rutaCarpetaPDF + File.separator + nombreArchivo;
            documento.save(directorioDestino);
            JOptionPane.showMessageDialog(null, "Comprobante descargado en Disco C:");
            this.dispose();
        }catch(Exception err){
            JOptionPane.showMessageDialog(null, "No se pudo descargar el PDF");
        }
    }//GEN-LAST:event_pdfButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JLabel cantidadLabel;
    private javax.swing.JLabel fechaLabel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton pdfButton;
    private javax.swing.JComboBox<String> tipoComboBox;
    // End of variables declaration//GEN-END:variables
}
