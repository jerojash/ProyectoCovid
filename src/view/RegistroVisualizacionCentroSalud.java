/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import SQL.Extraer;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import tools.Buscador;
import tools.Creador;
import tools.Verificador;

/**
 *
 * @author manuel
 */
public class RegistroVisualizacionCentroSalud extends javax.swing.JFrame {

    Buscador bus = new Buscador();
    Creador crea = new Creador();
    DefaultTableModel model;
    Verificador veri = new Verificador();
    Extraer dataSQL = new Extraer();

    public RegistroVisualizacionCentroSalud() {
        initComponents();
        crea.Interfaz(this, 1008, 400);
        crea.addTableHeaderCentroSalud(model, jTable_Centros);
        bus.tableAllCentrosSalud(jTable_Centros);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        boton_Volver_Sintomas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label_Sintomas = new javax.swing.JLabel();
        boton_ModificarPersona = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Centros = new javax.swing.JTable();
        boton_BusPersona = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boton_EliminarPersona = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        field_Numero_Doc1 = new javax.swing.JTextField();
        boton_AggPersona = new javax.swing.JButton();
        title_RegistroSintomas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 211, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_Volver_Sintomas.setBackground(new java.awt.Color(235, 235, 235));
        boton_Volver_Sintomas.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_Volver_Sintomas.setText("Volver");
        boton_Volver_Sintomas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_Volver_Sintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Volver_SintomasActionPerformed(evt);
            }
        });
        jPanel1.add(boton_Volver_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 340, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Sintomas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Sintomas.setText("Centro de salud registrado:");
        jPanel2.add(label_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        boton_ModificarPersona.setBackground(new java.awt.Color(235, 235, 235));
        boton_ModificarPersona.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_ModificarPersona.setText("Modificar");
        boton_ModificarPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_ModificarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ModificarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(boton_ModificarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 90, 27));

        jTable_Centros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Centro de salud", "Dirreción", "Encargado", "Fecha encargado", "Estado", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Centros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CentrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Centros);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 920, 140));

        boton_BusPersona.setBackground(new java.awt.Color(235, 235, 235));
        boton_BusPersona.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_BusPersona.setText("Buscar");
        boton_BusPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_BusPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_BusPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(boton_BusPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 90, 27));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 130, 100));

        boton_EliminarPersona.setBackground(new java.awt.Color(235, 235, 235));
        boton_EliminarPersona.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_EliminarPersona.setText("Eliminar");
        boton_EliminarPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_EliminarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_EliminarPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(boton_EliminarPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 90, 27));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 130, 100));

        field_Numero_Doc1.setBackground(new java.awt.Color(235, 235, 235));
        field_Numero_Doc1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                field_Numero_Doc1ComponentAdded(evt);
            }
        });
        field_Numero_Doc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_Numero_Doc1ActionPerformed(evt);
            }
        });
        jPanel2.add(field_Numero_Doc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 300, -1));

        boton_AggPersona.setBackground(new java.awt.Color(235, 235, 235));
        boton_AggPersona.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_AggPersona.setText("Agregar");
        boton_AggPersona.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_AggPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AggPersonaActionPerformed(evt);
            }
        });
        jPanel2.add(boton_AggPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 90, 27));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 57, 940, 270));

        title_RegistroSintomas.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroSintomas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroSintomas.setText("Centro de salud");
        jPanel1.add(title_RegistroSintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 890, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 993, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_SintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_SintomasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_Volver_SintomasActionPerformed

    private void boton_ModificarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ModificarPersonaActionPerformed

    }//GEN-LAST:event_boton_ModificarPersonaActionPerformed

    private void jTable_CentrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CentrosMouseClicked

    }//GEN-LAST:event_jTable_CentrosMouseClicked

    private void boton_BusPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_BusPersonaActionPerformed

    }//GEN-LAST:event_boton_BusPersonaActionPerformed

    private void boton_EliminarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_EliminarPersonaActionPerformed

    }//GEN-LAST:event_boton_EliminarPersonaActionPerformed

    private void field_Numero_Doc1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_field_Numero_Doc1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_field_Numero_Doc1ComponentAdded

    private void field_Numero_Doc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_Numero_Doc1ActionPerformed

    }//GEN-LAST:event_field_Numero_Doc1ActionPerformed

    private void boton_AggPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AggPersonaActionPerformed

    }//GEN-LAST:event_boton_AggPersonaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroVisualizacionCentroSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVisualizacionCentroSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVisualizacionCentroSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVisualizacionCentroSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVisualizacionCentroSalud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_AggPersona;
    private javax.swing.JButton boton_BusPersona;
    private javax.swing.JButton boton_EliminarPersona;
    private javax.swing.JButton boton_ModificarPersona;
    private javax.swing.JButton boton_Volver_Sintomas;
    private javax.swing.JTextField field_Numero_Doc1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Centros;
    private javax.swing.JLabel label_Sintomas;
    private javax.swing.JLabel title_RegistroSintomas;
    // End of variables declaration//GEN-END:variables
}
