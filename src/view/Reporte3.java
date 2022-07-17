/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import SQL.Extraer;
import javax.swing.table.DefaultTableModel;
import tools.Creador;

/**
 *
 * @author manuel
 */
public class Reporte3 extends javax.swing.JFrame {
    Creador crea = new Creador();
    DefaultTableModel model;
    Extraer viewSQL = new Extraer();
    
    public Reporte3() {
        initComponents();
        crea.Interfaz(this, 867, 350);
        crea.addTableHeaderRep3(model,jTable_reporte);
        viewSQL.Reporte3(jTable_reporte);
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
        boton_Volver_Sintomas = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_reporte = new javax.swing.JTable();
        title_RegistroSintomas = new javax.swing.JLabel();
        title_RegistroSintomas1 = new javax.swing.JLabel();

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
        jPanel1.add(boton_Volver_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 130, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 130, 100));

        jTable_reporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Centro de vacunacion", "Porcentaje contagios pos vacuna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable_reporte);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 390, 130));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 800, 180));

        title_RegistroSintomas.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroSintomas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroSintomas.setText("contagiados con el virus luego de ser vacunados");
        title_RegistroSintomas.setAutoscrolls(true);
        title_RegistroSintomas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(title_RegistroSintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 800, 40));

        title_RegistroSintomas1.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroSintomas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroSintomas1.setText("Porcentaje de personas vacunadas por centro de vacunacion que han estado  ");
        title_RegistroSintomas1.setAutoscrolls(true);
        title_RegistroSintomas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(title_RegistroSintomas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 800, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 867, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 867, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_SintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_SintomasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_Volver_SintomasActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Volver_Sintomas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_reporte;
    private javax.swing.JLabel title_RegistroSintomas;
    private javax.swing.JLabel title_RegistroSintomas1;
    // End of variables declaration//GEN-END:variables
}
