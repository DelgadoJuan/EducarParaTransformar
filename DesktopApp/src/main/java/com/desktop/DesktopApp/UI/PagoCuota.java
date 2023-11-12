/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.desktop.DesktopApp.UI;

import com.desktop.DesktopApp.Entity.*;
import com.desktop.DesktopApp.Repository.PagoRepository;
import org.apache.fontbox.FontBoxFont;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 *
 * @author Juan
 */
public class PagoCuota extends javax.swing.JFrame {

    private static TitularEntity titular;
    private PagoRepository pagoRepository;

    /**
     * Creates new form PagoCuota
     */
    public PagoCuota(UsuarioEntity usuario, String mes, String monto, PagoRepository pagoRepository) {
        initComponents();
        this.titular = (TitularEntity) usuario;
        this.pagoRepository = pagoRepository;
        this.montoLabel.setText(monto);
        this.mesLabel.setText(mes);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        tipoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tipoComboBox.getSelectedItem().equals("Efectivo")) {
                    nombreField.setEnabled(false);
                    codigoField.setEnabled(false);
                    numeroField.setEnabled(false);
                    vencimientoAñoField.setEnabled(false);
                    vencimientoMesField.setEnabled(false);
                } else {
                    nombreField.setEnabled(true);
                    codigoField.setEnabled(true);
                    numeroField.setEnabled(true);
                    vencimientoAñoField.setEnabled(true);
                    vencimientoMesField.setEnabled(true);
                }
            }
        });
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pagoButton = new javax.swing.JButton();
        codigoField = new javax.swing.JTextField();
        vencimientoMesField = new javax.swing.JTextField();
        vencimientoAñoField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        numeroField = new javax.swing.JTextField();
        mesLabel = new javax.swing.JLabel();
        montoLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tipoComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("  ");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(27, 28, 49));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Mes:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Monto:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Número de tarjeta");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Nombre del titular");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Código de seguridad");

        pagoButton.setBackground(new java.awt.Color(49, 49, 84));
        pagoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pagoButton.setForeground(new java.awt.Color(255, 255, 255));
        pagoButton.setText("Pagar");
        pagoButton.setBorder(null);
        pagoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pagoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoButtonActionPerformed(evt);
            }
        });

        codigoField.setBackground(new java.awt.Color(27, 28, 49));
        codigoField.setForeground(new java.awt.Color(255, 255, 255));
        codigoField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        codigoField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoFieldActionPerformed(evt);
            }
        });

        vencimientoMesField.setBackground(new java.awt.Color(27, 28, 49));
        vencimientoMesField.setForeground(new java.awt.Color(255, 255, 255));
        vencimientoMesField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        vencimientoAñoField.setBackground(new java.awt.Color(27, 28, 49));
        vencimientoAñoField.setForeground(new java.awt.Color(255, 255, 255));
        vencimientoAñoField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Año");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Mes");

        nombreField.setBackground(new java.awt.Color(27, 28, 49));
        nombreField.setForeground(new java.awt.Color(255, 255, 255));
        nombreField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        numeroField.setBackground(new java.awt.Color(27, 28, 49));
        numeroField.setForeground(new java.awt.Color(255, 255, 255));
        numeroField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        mesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mesLabel.setForeground(new java.awt.Color(255, 255, 255));
        mesLabel.setText("jLabel8");

        montoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        montoLabel.setForeground(new java.awt.Color(255, 255, 255));
        montoLabel.setText("jLabel7");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(62, 62, 123));
        jLabel9.setText("Administrar Pago");

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Complete con los detalles para realizar el pago");

        tipoComboBox.setBackground(new java.awt.Color(27, 28, 49));
        tipoComboBox.setForeground(new java.awt.Color(255, 255, 255));
        tipoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Credito", "Debito", "Efectivo" }));
        tipoComboBox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Tipo de pago");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)
                        .addComponent(jLabel3)
                        .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                        .addComponent(numeroField)
                        .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mesLabel)
                                        .addComponent(montoLabel)))
                                .addComponent(jLabel6)
                                .addComponent(vencimientoMesField, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pagoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(tipoComboBox, 0, 286, Short.MAX_VALUE)))
                                .addComponent(jLabel8)
                                .addComponent(vencimientoAñoField, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoComboBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vencimientoAñoField)
                    .addComponent(vencimientoMesField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(montoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(mesLabel)))
                    .addComponent(pagoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
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

    private void codigoFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoFieldActionPerformed

    private void pagoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoButtonActionPerformed
        boolean valido = true;

        if (!tipoComboBox.getSelectedItem().toString().equals("Efectivo")) {
            if (numeroField.getText().length() != 16) {
                JOptionPane.showMessageDialog(null, "Número de tarjeta no válido");
                valido = false;
            }
            if (vencimientoMesField.getText().isBlank() || vencimientoAñoField.getText().isBlank() ||
            Integer.parseInt(vencimientoMesField.getText()) < 1 ||
                    Integer.parseInt(vencimientoMesField.getText()) > 12 || Integer.parseInt(vencimientoAñoField.getText()) < 24) {
                JOptionPane.showMessageDialog(null, "Fecha de vencimiento no válida");
                valido = false;
            }
            if (codigoField.getText().length() != 3 ||
                    !codigoField.getText().matches("\\d*") || codigoField.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Código de seguridad no válido");
                valido = false;
            }
        }

        if (valido) {
            pagoRepository.save(new PagoEntity(titular, Double.parseDouble(montoLabel.getText()),
                    Mes.valueOf(mesLabel.getText()), TipoPago.valueOf(tipoComboBox.getSelectedItem().toString())));
            //comprobante

            try{
                PDDocument documento = new PDDocument();
                PDPage pagina = new  PDPage(PDRectangle.A6);
                documento.addPage(pagina);
                PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

                PDImageXObject logo = PDImageXObject.createFromFile("src/main/resources/images/logo 100px.png", documento);
                float logoWidth = 60; // Ancho del logo en puntos
                float logoHeight = 60; // Altura del logo en puntos
                contenido.drawImage(logo, 10, pagina.getMediaBox().getHeight() - logoHeight - 10, logoWidth, logoHeight);

                contenido.beginText();
                contenido.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 16);
                String titulo = "Comprobante de pago";
                float anchoTitulo = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD).getStringWidth(titulo) / 1000 * 18; // Ancho del título en puntos
                float xTitulo = (pagina.getMediaBox().getWidth() - anchoTitulo) / 2; // Centrar en el eje X
                float yTitulo = pagina.getMediaBox().getHeight() - 100; // Posición fija en el eje Y
                contenido.newLineAtOffset(xTitulo, yTitulo);
                contenido.showText(titulo);

                contenido.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 10);
                contenido.newLineAtOffset(-40, -40);
                contenido.showText("Numero de comprobante: " + pagoRepository.findAll().size());
                contenido.newLineAtOffset(0, -20);
                contenido.showText("Datos del colegio: Educar Para Transformar");
                contenido.newLineAtOffset(0, -20);
                contenido.showText("Mes pagado:  " + mesLabel.getText());
                contenido.newLineAtOffset(0, -20);
                contenido.showText("Tipo de pago: " + tipoComboBox.getSelectedItem());
                contenido.newLineAtOffset(0, -20);
                contenido.showText("Monto: " + montoLabel.getText());
                contenido.newLineAtOffset(0, -20);
                contenido.showText("Fecha:  " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                contenido.newLineAtOffset(0, -20);
                contenido.showText("Alumno: " + titular.getHijo().getNombre());
                contenido.endText();
                contenido.close();


                String nombreArchivo = "ComprobantePago-" + mesLabel.getText() + LocalDate.now().getYear() + ".pdf";
                FileSystemView fileSystemView = FileSystemView.getFileSystemView();

                // Obtenemos el directorio de descargas del usuario
                File downloadsDir = fileSystemView.getDefaultDirectory();

                // Comprobamos si existe la carpeta de descargas
                if (downloadsDir != null && downloadsDir.exists()) {
                    // Ruta completa del archivo a guardar en la carpeta de descargas
                    String directorioDestino = downloadsDir.getAbsolutePath() + File.separator + nombreArchivo;
                    documento.save(directorioDestino);
                    JOptionPane.showMessageDialog(null, "Comprobante descargado correctamente en su carpeta Documentos");
                } else {
                    System.out.println("No se encontró la carpeta de documentos del usuario");
                }
                //documento.save(directorioDestino);
                //JOptionPane.showMessageDialog(null, "Comprobante descargado correctamente");
                this.dispose();
            }catch(Exception err){
                System.out.println(" " + err);
            }
        }
    }//GEN-LAST:event_pagoButtonActionPerformed


    private void sendMail(PDDocument pdfDocument) {
        String FromEmail = "ncerezo855@gmail.com";
        String FromEmailPassword = "Mn311012";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FromEmail, FromEmailPassword);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(this.titular.getEmail()));
            message.setSubject("Comprobante de cuota");

            // Crear el cuerpo del mensaje
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Adjunto comprobante de pago de cuota:");

            // Crear un objeto Multipart para adjuntar el archivo
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Adjuntar el archivo PDF desde el PDDocument
            messageBodyPart = new MimeBodyPart();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            pdfDocument.save(byteArrayOutputStream);
            byte[] pdfBytes = byteArrayOutputStream.toByteArray();

            ByteArrayDataSource source = new ByteArrayDataSource(pdfBytes, "application/pdf");
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("ComprobantePago.pdf");
            multipart.addBodyPart(messageBodyPart);

            // Agregar el Multipart al mensaje
            message.setContent(multipart);
            Transport.send(message);

            // Cerrar el PDDocument después de enviar el correo
            pdfDocument.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel mesLabel;
    private javax.swing.JLabel montoLabel;
    private javax.swing.JTextField nombreField;
    private javax.swing.JTextField numeroField;
    private javax.swing.JButton pagoButton;
    private javax.swing.JComboBox<String> tipoComboBox;
    private javax.swing.JTextField vencimientoAñoField;
    private javax.swing.JTextField vencimientoMesField;
    // End of variables declaration//GEN-END:variables
}
