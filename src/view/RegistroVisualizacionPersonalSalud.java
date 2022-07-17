/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import tools.Creador;
/**
 *
 * @author Ricardo Fanghella
 */
public class RegistroVisualizacionPersonalSalud extends javax.swing.JFrame {
    Creador creaInterfaz = new Creador();
    /**
     * Creates new form registrarMedicamento
     */
    public RegistroVisualizacionPersonalSalud() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        field_TiempoReposo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        boton_Volver_Personal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label_Sintomas = new javax.swing.JLabel();
        desplegable_Nacionalidad = new javax.swing.JComboBox<String>();
        boton_VerCentros = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_PersonalSalud = new javax.swing.JTable();
        boton_AggPersonal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boton_BuscarPersonal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textField_NDocumento = new javax.swing.JTextField();
        boton_ModificarPersonal = new javax.swing.JButton();
        boton_EliminarPersonal = new javax.swing.JButton();
        title_RegistroSintomas = new javax.swing.JLabel();

        jButton2.setBackground(new java.awt.Color(235, 235, 235));
        jButton2.setFont(new java.awt.Font("David Libre", 0, 11)); // NOI18N
        jButton2.setText("Volver");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        field_TiempoReposo.setBackground(new java.awt.Color(235, 235, 235));
        field_TiempoReposo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_TiempoReposoActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 211, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_Volver_Personal.setBackground(new java.awt.Color(235, 235, 235));
        boton_Volver_Personal.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_Volver_Personal.setText("Volver");
        boton_Volver_Personal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_Volver_Personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Volver_PersonalActionPerformed(evt);
            }
        });
        jPanel1.add(boton_Volver_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Sintomas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Sintomas.setText("Personal registrado: ");
        jPanel2.add(label_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, -1));

        desplegable_Nacionalidad.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_Nacionalidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "V", "E" }));
        desplegable_Nacionalidad.setPreferredSize(new java.awt.Dimension(56, 24));
        desplegable_Nacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegable_NacionalidadActionPerformed(evt);
            }
        });
        jPanel2.add(desplegable_Nacionalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 50, -1));

        boton_VerCentros.setBackground(new java.awt.Color(235, 235, 235));
        boton_VerCentros.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_VerCentros.setText("Ver centros");
        boton_VerCentros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_VerCentros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_VerCentrosActionPerformed(evt);
            }
        });
        jPanel2.add(boton_VerCentros, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 90, 27));

        jTable_PersonalSalud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Documento ", "Correo", "Ocupación"
            }
        ));
        jScrollPane1.setViewportView(jTable_PersonalSalud);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 530, 140));

        boton_AggPersonal.setBackground(new java.awt.Color(235, 235, 235));
        boton_AggPersonal.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_AggPersonal.setText("Agregar");
        boton_AggPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_AggPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AggPersonalActionPerformed(evt);
            }
        });
        jPanel2.add(boton_AggPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 90, 27));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 130, 100));

        boton_BuscarPersonal.setBackground(new java.awt.Color(235, 235, 235));
        boton_BuscarPersonal.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_BuscarPersonal.setText("Buscar");
        boton_BuscarPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_BuscarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_BuscarPersonalActionPerformed(evt);
            }
        });
        jPanel2.add(boton_BuscarPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 60, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 130, 100));

        textField_NDocumento.setBackground(new java.awt.Color(235, 235, 235));
        textField_NDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_NDocumentoActionPerformed(evt);
            }
        });
        jPanel2.add(textField_NDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 180, -1));

        boton_ModificarPersonal.setBackground(new java.awt.Color(235, 235, 235));
        boton_ModificarPersonal.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_ModificarPersonal.setText("Modificar");
        boton_ModificarPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_ModificarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ModificarPersonalActionPerformed(evt);
            }
        });
        jPanel2.add(boton_ModificarPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 90, 27));

        boton_EliminarPersonal.setBackground(new java.awt.Color(235, 235, 235));
        boton_EliminarPersonal.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_EliminarPersonal.setText("Eliminar");
        boton_EliminarPersonal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_EliminarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_EliminarPersonalActionPerformed(evt);
            }
        });
        jPanel2.add(boton_EliminarPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 90, 27));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 57, 760, 250));

        title_RegistroSintomas.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroSintomas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroSintomas.setText("Personal de salud");
        jPanel1.add(title_RegistroSintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 760, 40));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_PersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_PersonalActionPerformed
        Proceso1 pro = new Proceso1();
        creaInterfaz.InterfazDiferentes(this, pro, 697, 391);
    }//GEN-LAST:event_boton_Volver_PersonalActionPerformed

    private void boton_VerCentrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_VerCentrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_VerCentrosActionPerformed

    private void boton_AggPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AggPersonalActionPerformed
        registrarPersonal_Salud personal = new registrarPersonal_Salud();
        creaInterfaz.InterfazDiferentes(this, personal, 594, 650);
    }//GEN-LAST:event_boton_AggPersonalActionPerformed

    private void boton_BuscarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_BuscarPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_BuscarPersonalActionPerformed

    private void desplegable_NacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_NacionalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegable_NacionalidadActionPerformed

    private void field_TiempoReposoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_TiempoReposoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_TiempoReposoActionPerformed

    private void textField_NDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_NDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_NDocumentoActionPerformed

    private void boton_ModificarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ModificarPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_ModificarPersonalActionPerformed

    private void boton_EliminarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_EliminarPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_EliminarPersonalActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroVisualizacionPersonalSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroVisualizacionPersonalSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroVisualizacionPersonalSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroVisualizacionPersonalSalud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroVisualizacionPersonalSalud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_AggPersonal;
    private javax.swing.JButton boton_BuscarPersonal;
    private javax.swing.JButton boton_EliminarPersonal;
    private javax.swing.JButton boton_ModificarPersonal;
    private javax.swing.JButton boton_VerCentros;
    private javax.swing.JButton boton_Volver_Personal;
    private javax.swing.JComboBox<String> desplegable_Nacionalidad;
    private javax.swing.JTextField field_TiempoReposo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_PersonalSalud;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label_Sintomas;
    private javax.swing.JTextField textField_NDocumento;
    private javax.swing.JLabel title_RegistroSintomas;
    // End of variables declaration//GEN-END:variables
}
