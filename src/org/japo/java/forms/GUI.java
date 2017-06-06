/*
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.forms;

import java.awt.Image;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Properties;
import javax.swing.ImageIcon;
import org.japo.java.components.BackgroundPanel;
import org.japo.java.lib.UtilesApp;
import org.japo.java.lib.UtilesSwing;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class GUI extends javax.swing.JFrame {

    // Propiedades APP
    private Properties prpApp;

    // Constructor
    public GUI() {
        // Inicializar GUI - PREVIA
        beforeInit();

        // Construcción - GUI
        initComponents();

        // Inicializar GUI - POSTERIOR
        afterInit();
    }

    // Inicializar GUI - PREVIA
    private void beforeInit() {
        // Restaurar Estado Previo
        restaurarEstado();

        // Establecer Panel Contenedor
        URL urlPNL = ClassLoader.getSystemResource("img/background.jpg");
        Image imgPNL = new ImageIcon(urlPNL).getImage();        
        setContentPane(new BackgroundPanel(imgPNL));
        
        // Otras inicializaciones
    }

    // Inicializar GUI - POSTERIOR
    private void afterInit() {
        // Icono Ventana - Recurso
        URL urlICN = ClassLoader.getSystemResource("img/favicon.png");
        setIconImage(new ImageIcon(urlICN).getImage());

        // Otras inicializaciones
    }

    // Persistencia > Estado Actual
    private void restaurarEstado() {
        // Carga Propiedades App
        prpApp = UtilesApp.cargarPropiedades();

        // Establece Lnf
        UtilesSwing.establecerLnF(prpApp.getProperty("lnf",
            UtilesSwing.WINDOWS));

        // Activa Singleton
        if (!UtilesApp.activarInstancia(
            prpApp.getProperty("puerto_bloqueo",
            UtilesApp.PUERTO_BLOQUEO))) {
            UtilesSwing.terminarPrograma(this);
        }

        // Otras propiedades
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Here comes the Title");
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTerminar.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        lblTerminar.setText("TERMINAR");
        lblTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblTerminarActionPerformed(evt);
            }
        });
        getContentPane().add(lblTerminar, new java.awt.GridBagConstraints());

        setSize(new java.awt.Dimension(306, 228));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        procesarCerrarVentana(evt);
    }//GEN-LAST:event_formWindowClosing

    private void lblTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblTerminarActionPerformed
        UtilesSwing.terminarPrograma(this);
    }//GEN-LAST:event_lblTerminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton lblTerminar;
    // End of variables declaration//GEN-END:variables
    //
    // Evento de Ventana - Cerrando
    public void procesarCerrarVentana(WindowEvent e) {
        // Memorizar Estado Actual
        memorizarEstado();
    }

    // Estado Actual > Persistencia
    private void memorizarEstado() {
        // Memoriza Estado Actual

        // Guardar Estado Actual
//        UtilesApp.guardarPropiedades(prpApp);
    }
}