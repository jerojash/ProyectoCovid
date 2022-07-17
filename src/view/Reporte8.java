/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import tools.Buscador;
import SQL.Extraer;
import SQL.Reporte;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo Fanghella
 */
public class Reporte8 extends javax.swing.JFrame {
    Extraer dataSQL = new Extraer();
    public Reporte8() {
        initComponents();
        ArrayList<String> listas = dataSQL.denom_oms(dataSQL.variante());
        for (int i=0;i<listas.size();i++)
        desplegable_Variantes.addItem(listas.get(i));
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
        label_Sintomas = new javax.swing.JLabel();
        desplegable_Variantes = new javax.swing.JComboBox<>();
        boton_Buscar = new javax.swing.JButton();
        nivel_eficaz = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_sintomas = new javax.swing.JTable();
        vacuna_eficaz = new javax.swing.JLabel();

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
        jPanel1.add(boton_Volver_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Sintomas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Sintomas.setText("Variante:");
        jPanel2.add(label_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        desplegable_Variantes.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_Variantes.setPreferredSize(new java.awt.Dimension(56, 24));
        desplegable_Variantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegable_VariantesActionPerformed(evt);
            }
        });
        jPanel2.add(desplegable_Variantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 240, -1));

        boton_Buscar.setBackground(new java.awt.Color(235, 235, 235));
        boton_Buscar.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_Buscar.setText("Seleccionar");
        boton_Buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_BuscarActionPerformed(evt);
            }
        });
        jPanel2.add(boton_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 90, 27));

        nivel_eficaz.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        nivel_eficaz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nivel_eficaz.setText("Nivel de eficacia: ");
        jPanel2.add(nivel_eficaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 360, 40));

        tabla_sintomas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sintomas "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_sintomas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_sintomasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_sintomas);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 440, 260));

        vacuna_eficaz.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        vacuna_eficaz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vacuna_eficaz.setText("Vacuna más eficaz: ");
        jPanel2.add(vacuna_eficaz, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 360, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 480, 520));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_SintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_SintomasActionPerformed

    }//GEN-LAST:event_boton_Volver_SintomasActionPerformed

    private void boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_BuscarActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Sintomas");
        tabla_sintomas.setModel(model);
        Reporte r = new Reporte();
        String [] data = new String[2];
        data = r.Reporte_8_1(desplegable_Variantes.getSelectedItem().toString());
        if (data!=null){
            vacuna_eficaz.setText("Vacuna más eficaz: " + data[0]);
            nivel_eficaz.setText("Nivel de eficacia: "+ data[1]+"%");
        }else {
            vacuna_eficaz.setText("Vacuna más eficaz: ");
            nivel_eficaz.setText("Nivel de eficacia: ");
        }
        ArrayList<String> data2 = new ArrayList<String>();
        data2 = r.Reporte_8_2(desplegable_Variantes.getSelectedItem().toString());
        String [] info = new String[1];
        for (int i = 0; i < data2.size(); i++){
            info[0] = data2.get(i).toString();
            model.addRow(info);
                    //addRow(data2.get(i));
        }
        
    }//GEN-LAST:event_boton_BuscarActionPerformed

    private void tabla_sintomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_sintomasMouseClicked
        
    }//GEN-LAST:event_tabla_sintomasMouseClicked

    private void desplegable_VariantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_VariantesActionPerformed
        // TODO add your handling code here:
        ArrayList<String> listas = dataSQL.denom_oms(dataSQL.variante());
        for (int i=0;i<listas.size();i++);
    }//GEN-LAST:event_desplegable_VariantesActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte8().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Buscar;
    private javax.swing.JButton boton_Volver_Sintomas;
    private javax.swing.JComboBox<String> desplegable_Variantes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Sintomas;
    private javax.swing.JLabel nivel_eficaz;
    private javax.swing.JTable tabla_sintomas;
    private javax.swing.JLabel vacuna_eficaz;
    // End of variables declaration//GEN-END:variables
}
