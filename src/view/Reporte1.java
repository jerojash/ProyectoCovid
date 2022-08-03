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
import tools.Creador;

/**
 *
 * @author Ricardo Fanghella
 */
public class Reporte1 extends javax.swing.JFrame {
    Extraer dataSQL = new Extraer();
    public Reporte1() {
        initComponents();
        ArrayList<String> listas = dataSQL.nombPais(dataSQL.Pais());
        for (int i=0;i<listas.size();i++)
        desplegable_pais.addItem(listas.get(i));
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
        desplegable_estado = new javax.swing.JComboBox<>();
        boton_Buscar = new javax.swing.JButton();
        nivel_eficaz = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_sintomas = new javax.swing.JTable();
        title_RegistroSintomas1 = new javax.swing.JLabel();
        title_RegistroSintomas2 = new javax.swing.JLabel();
        label_Sintomas1 = new javax.swing.JLabel();
        desplegable_pais = new javax.swing.JComboBox<>();

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
        jPanel1.add(boton_Volver_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Sintomas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Sintomas.setText("Estado");
        jPanel2.add(label_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        desplegable_estado.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_estado.setPreferredSize(new java.awt.Dimension(56, 24));
        desplegable_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegable_estadoActionPerformed(evt);
            }
        });
        jPanel2.add(desplegable_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 240, -1));

        boton_Buscar.setBackground(new java.awt.Color(235, 235, 235));
        boton_Buscar.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_Buscar.setText("Seleccionar");
        boton_Buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_BuscarActionPerformed(evt);
            }
        });
        jPanel2.add(boton_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 90, 27));

        nivel_eficaz.setFont(new java.awt.Font("Serif", 0, 20)); // NOI18N
        nivel_eficaz.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nivel_eficaz.setText("Cantidad de contagiados:");
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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 440, 190));

        title_RegistroSintomas1.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroSintomas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroSintomas1.setText("más de dos veces, por estado.");
        title_RegistroSintomas1.setAutoscrolls(true);
        title_RegistroSintomas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(title_RegistroSintomas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 430, 40));

        title_RegistroSintomas2.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroSintomas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroSintomas2.setText("Cantidad de pacientes contagiados");
        title_RegistroSintomas2.setAutoscrolls(true);
        title_RegistroSintomas2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(title_RegistroSintomas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 430, 40));

        label_Sintomas1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Sintomas1.setText("Pais");
        jPanel2.add(label_Sintomas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        desplegable_pais.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_pais.setPreferredSize(new java.awt.Dimension(56, 24));
        desplegable_pais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegable_paisActionPerformed(evt);
            }
        });
        jPanel2.add(desplegable_pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 240, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 480, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_SintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_SintomasActionPerformed
        VisualizacionReportes rep = new VisualizacionReportes();
        Creador crea = new Creador();
        crea.InterfazDiferentes(this, rep, 730, 350);
    }//GEN-LAST:event_boton_Volver_SintomasActionPerformed

    private void boton_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_BuscarActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Hospitalizado");
        tabla_sintomas.setModel(model);
        Reporte r = new Reporte();
        int data = 0;
        data = r.Reporte_1_1(desplegable_estado.getSelectedItem().toString());
        nivel_eficaz.setText("Cantidad de contagiados: "+String.valueOf(data));
 
        ArrayList<String> data2 = new ArrayList<String>();
        data2 = r.Reporte_1_2(desplegable_estado.getSelectedItem().toString());
        String [] info = new String[3];
        for (int i = 0; i < data2.size(); i=i+3){
            info[0] = data2.get(i).toString();
            info[1] = data2.get(i+1).toString();
            if (data2.get(i+2).toString().equals("t")) info[2] = "Hospitalizado";
            else info[2] = "En casa";
            model.addRow(info);
        }
        
    }//GEN-LAST:event_boton_BuscarActionPerformed

    private void tabla_sintomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_sintomasMouseClicked
        
    }//GEN-LAST:event_tabla_sintomasMouseClicked

    private void desplegable_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_estadoActionPerformed
        // TODO add your handling code here:
        ArrayList<String> listas = dataSQL.denom_oms(dataSQL.variante());
        for (int i=0;i<listas.size();i++);
    }//GEN-LAST:event_desplegable_estadoActionPerformed

    private void desplegable_paisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_paisActionPerformed
        desplegable_estado.removeAllItems();
        String codpais = desplegable_pais.getSelectedItem().toString();
        Buscador busc = new Buscador();
        ArrayList<String> listas = dataSQL.nombEstado(dataSQL.Estado(busc.codPais(codpais)));
        for (int i=0;i<listas.size();i++)
        desplegable_estado.addItem(listas.get(i));
    }//GEN-LAST:event_desplegable_paisActionPerformed

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
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reporte1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reporte1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Buscar;
    private javax.swing.JButton boton_Volver_Sintomas;
    private javax.swing.JComboBox<String> desplegable_estado;
    private javax.swing.JComboBox<String> desplegable_pais;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Sintomas;
    private javax.swing.JLabel label_Sintomas1;
    private javax.swing.JLabel nivel_eficaz;
    private javax.swing.JTable tabla_sintomas;
    private javax.swing.JLabel title_RegistroSintomas1;
    private javax.swing.JLabel title_RegistroSintomas2;
    // End of variables declaration//GEN-END:variables
}