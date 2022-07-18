
package view;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.Creador;


public class VisualizacionReportes extends javax.swing.JFrame {
    Creador crea = new Creador();

    public VisualizacionReportes() {
        initComponents();
        crea.Interfaz(this, 730, 350);
        buttom_reporte1.setEnabled(false);
        buttom_reporte4.setEnabled(false);
        buttom_reporte5.setEnabled(false);
        buttom_reporte6.setEnabled(false);
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
        buttom_reporte1 = new javax.swing.JButton();
        buttom_reporte2 = new javax.swing.JButton();
        buttom_reporte3 = new javax.swing.JButton();
        buttom_reporte4 = new javax.swing.JButton();
        buttom_reporte5 = new javax.swing.JButton();
        buttom_reporte6 = new javax.swing.JButton();
        buttom_reporte7 = new javax.swing.JButton();
        buttom_reporte8 = new javax.swing.JButton();

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
        jPanel1.add(boton_Volver_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 130, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 120, 100));

        buttom_reporte1.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte1.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte1.setText("Reporte 1");
        buttom_reporte1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte1ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 100, 40));

        buttom_reporte2.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte2.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte2.setText("Reporte 2");
        buttom_reporte2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte2ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 100, 40));

        buttom_reporte3.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte3.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte3.setText("Reporte 3");
        buttom_reporte3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte3ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 100, 40));

        buttom_reporte4.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte4.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte4.setText("Reporte 4");
        buttom_reporte4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte4ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 100, 40));

        buttom_reporte5.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte5.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte5.setText("Reporte 5");
        buttom_reporte5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte5ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 100, 40));

        buttom_reporte6.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte6.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte6.setText("Reporte 6");
        buttom_reporte6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte6ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 40));

        buttom_reporte7.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte7.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte7.setText("Reporte 7");
        buttom_reporte7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte7ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 100, 40));

        buttom_reporte8.setBackground(new java.awt.Color(235, 235, 235));
        buttom_reporte8.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        buttom_reporte8.setText("Reporte 8");
        buttom_reporte8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        buttom_reporte8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttom_reporte8ActionPerformed(evt);
            }
        });
        jPanel2.add(buttom_reporte8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 100, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 640, 230));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_SintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_SintomasActionPerformed
        SistemaOMS Sis = new SistemaOMS();
        crea.InterfazDiferentes(this, Sis, 697, 391);
    }//GEN-LAST:event_boton_Volver_SintomasActionPerformed

    private void buttom_reporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttom_reporte1ActionPerformed

    private void buttom_reporte2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte2ActionPerformed
        Reporte2 rep = new Reporte2();
        crea.InterfazDiferentes(this, rep, 890, 310);
    }//GEN-LAST:event_buttom_reporte2ActionPerformed

    private void buttom_reporte3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte3ActionPerformed
        Reporte3 rep = new Reporte3();
        crea.InterfazDiferentes(this, rep, 890, 360);
    }//GEN-LAST:event_buttom_reporte3ActionPerformed

    private void buttom_reporte4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttom_reporte4ActionPerformed

    private void buttom_reporte5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttom_reporte5ActionPerformed

    private void buttom_reporte6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttom_reporte6ActionPerformed

    private void buttom_reporte7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte7ActionPerformed
        Reporte7 rep;
        try {
            rep = new Reporte7();
            crea.InterfazDiferentes(this, rep, 650, 405);
        } catch (SQLException ex) {
        }
    }//GEN-LAST:event_buttom_reporte7ActionPerformed

    private void buttom_reporte8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttom_reporte8ActionPerformed
        Reporte8 rep = new Reporte8();
        crea.InterfazDiferentes(this, rep, 560, 560);
    }//GEN-LAST:event_buttom_reporte8ActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizacionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizacionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizacionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizacionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizacionReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Volver_Sintomas;
    private javax.swing.JButton buttom_reporte1;
    private javax.swing.JButton buttom_reporte2;
    private javax.swing.JButton buttom_reporte3;
    private javax.swing.JButton buttom_reporte4;
    private javax.swing.JButton buttom_reporte5;
    private javax.swing.JButton buttom_reporte6;
    private javax.swing.JButton buttom_reporte7;
    private javax.swing.JButton buttom_reporte8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
