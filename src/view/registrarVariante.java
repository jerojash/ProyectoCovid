/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Ricardo Fanghella
 */
public class registrarVariante extends javax.swing.JFrame {

    /**
     * Creates new form registrarMedicamento
     */
    public registrarVariante() {
        initComponents();
        this.setSize(542, 478);
        this.setResizable(false);
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
        jPanel1 = new javax.swing.JPanel();
        boton_Volver_Variante = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_Clasificacion = new javax.swing.JLabel();
        label_Denominacion = new javax.swing.JLabel();
        field_Nombre_Persona = new java.awt.TextField();
        label_Linaje = new javax.swing.JLabel();
        label_PaisOrigen = new javax.swing.JLabel();
        field_Linaje = new java.awt.TextField();
        label_Fecha_Origen = new javax.swing.JLabel();
        label_Sintomas = new javax.swing.JLabel();
        desplegable_calendar = new com.toedter.calendar.JDateChooser();
        desplegable_Sintomas = new javax.swing.JComboBox<>();
        desplegable_PaisOrigen = new javax.swing.JComboBox<>();
        desplegable_Clasificacion = new javax.swing.JComboBox<>();
        boton_VerSintomas = new javax.swing.JButton();
        title_RegistroVariante = new javax.swing.JLabel();
        boton_Siguiente_Variante = new javax.swing.JButton();

        jButton2.setBackground(new java.awt.Color(235, 235, 235));
        jButton2.setFont(new java.awt.Font("David Libre", 0, 11)); // NOI18N
        jButton2.setText("Volver");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(159, 211, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_Volver_Variante.setBackground(new java.awt.Color(235, 235, 235));
        boton_Volver_Variante.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_Volver_Variante.setText("Volver");
        boton_Volver_Variante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_Volver_Variante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Volver_VarianteActionPerformed(evt);
            }
        });
        jPanel1.add(boton_Volver_Variante, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 154, 110));

        label_Clasificacion.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Clasificacion.setText("Clasificación: ");
        jPanel2.add(label_Clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        label_Denominacion.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Denominacion.setText("Denominación OMS:");
        jPanel2.add(label_Denominacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        field_Nombre_Persona.setBackground(new java.awt.Color(235, 235, 235));
        field_Nombre_Persona.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanel2.add(field_Nombre_Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 180, -1));

        label_Linaje.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Linaje.setText("Linaje:");
        jPanel2.add(label_Linaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        label_PaisOrigen.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_PaisOrigen.setText("País de origen:");
        jPanel2.add(label_PaisOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        field_Linaje.setBackground(new java.awt.Color(235, 235, 235));
        field_Linaje.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanel2.add(field_Linaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 180, -1));

        label_Fecha_Origen.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Fecha_Origen.setText("Fecha de origen: ");
        jPanel2.add(label_Fecha_Origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        label_Sintomas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Sintomas.setText("Síntomas:");
        jPanel2.add(label_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        desplegable_calendar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanel2.add(desplegable_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, 20));

        desplegable_Sintomas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_Sintomas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        desplegable_Sintomas.setPreferredSize(new java.awt.Dimension(56, 24));
        jPanel2.add(desplegable_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 180, -1));

        desplegable_PaisOrigen.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_PaisOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E" }));
        desplegable_PaisOrigen.setPreferredSize(new java.awt.Dimension(56, 24));
        jPanel2.add(desplegable_PaisOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, -1));

        desplegable_Clasificacion.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_Clasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VOC", "VOI", "VUM" }));
        desplegable_Clasificacion.setPreferredSize(new java.awt.Dimension(56, 24));
        desplegable_Clasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegable_ClasificacionActionPerformed(evt);
            }
        });
        jPanel2.add(desplegable_Clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 180, -1));

        boton_VerSintomas.setBackground(new java.awt.Color(235, 235, 235));
        boton_VerSintomas.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_VerSintomas.setText("Ver síntomas");
        boton_VerSintomas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_VerSintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_VerSintomasActionPerformed(evt);
            }
        });
        jPanel2.add(boton_VerSintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 90, 27));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 57, 470, 330));

        title_RegistroVariante.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroVariante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroVariante.setText("Registro de Variante de Covid");
        jPanel1.add(title_RegistroVariante, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 470, 40));

        boton_Siguiente_Variante.setBackground(new java.awt.Color(235, 235, 235));
        boton_Siguiente_Variante.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_Siguiente_Variante.setText("Siguiente");
        boton_Siguiente_Variante.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_Siguiente_Variante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Siguiente_VarianteActionPerformed(evt);
            }
        });
        jPanel1.add(boton_Siguiente_Variante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 80, 27));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_VarianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_VarianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_Volver_VarianteActionPerformed

    private void boton_VerSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_VerSintomasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_VerSintomasActionPerformed

    private void desplegable_ClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_ClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegable_ClasificacionActionPerformed

    private void boton_Siguiente_VarianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Siguiente_VarianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_Siguiente_VarianteActionPerformed

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
            java.util.logging.Logger.getLogger(registrarVariante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrarVariante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrarVariante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrarVariante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new registrarVariante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Siguiente_Variante;
    private javax.swing.JButton boton_VerSintomas;
    private javax.swing.JButton boton_Volver_Variante;
    private javax.swing.JComboBox<String> desplegable_Clasificacion;
    private javax.swing.JComboBox<String> desplegable_PaisOrigen;
    private javax.swing.JComboBox<String> desplegable_Sintomas;
    private com.toedter.calendar.JDateChooser desplegable_calendar;
    private java.awt.TextField field_Linaje;
    private java.awt.TextField field_Nombre_Persona;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_Clasificacion;
    private javax.swing.JLabel label_Denominacion;
    private javax.swing.JLabel label_Fecha_Origen;
    private javax.swing.JLabel label_Linaje;
    private javax.swing.JLabel label_PaisOrigen;
    private javax.swing.JLabel label_Sintomas;
    private javax.swing.JLabel title_RegistroVariante;
    // End of variables declaration//GEN-END:variables
}