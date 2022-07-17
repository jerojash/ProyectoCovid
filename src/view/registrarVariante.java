/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import tools.Buscador;
import Clases.Estado;
import SQL.Extraer;
import SQL.Guardar;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.table.DefaultTableModel;
import tools.Creador;
import tools.Verificador;
/**
 *
 * @author Ricardo Fanghella
 */
public class registrarVariante extends javax.swing.JFrame {
    Extraer dataSQL = new Extraer();
    DefaultTableModel model;
    Creador crea = new Creador();
    
    public registrarVariante() {
        initComponents();
        desplegable_PaisOrigen.removeAllItems();
        ArrayList<String> listas = dataSQL.nombPais(dataSQL.Pais());
        for (int i=0;i<listas.size();i++)
        desplegable_PaisOrigen.addItem(listas.get(i));
        
        desplegable_Sintoma.removeAllItems();
        listas= dataSQL.descripsintoma(dataSQL.Sintomas());
        for (int i=0;i<listas.size();i++)
        desplegable_Sintoma.addItem(listas.get(i));
        
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
        regisSintoma = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        boton_Volver_Variante1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        label_Denominacion1 = new javax.swing.JLabel();
        desplegable_Sintoma = new javax.swing.JComboBox<>();
        boton_VerSintomas1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSint = new javax.swing.JTable();
        boton_VerSintomas2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boton_AggSintNueva = new javax.swing.JButton();
        title_RegistroVariante1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        boton_Volver_Variante = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label_Clasificacion = new javax.swing.JLabel();
        label_Denominacion = new javax.swing.JLabel();
        label_Linaje = new javax.swing.JLabel();
        label_PaisOrigen = new javax.swing.JLabel();
        label_Fecha_Origen = new javax.swing.JLabel();
        label_Sintomas = new javax.swing.JLabel();
        desplegable_calendar = new com.toedter.calendar.JDateChooser();
        desplegable_PaisOrigen = new javax.swing.JComboBox<>();
        desplegable_Clasificacion = new javax.swing.JComboBox<>();
        boton_VerSintomas = new javax.swing.JButton();
        field_Denominacion = new javax.swing.JTextField();
        field_Linaje = new javax.swing.JTextField();
        title_RegistroVariante = new javax.swing.JLabel();
        boton_Siguiente_Variante = new javax.swing.JButton();

        jButton2.setBackground(new java.awt.Color(235, 235, 235));
        jButton2.setFont(new java.awt.Font("David Libre", 0, 11)); // NOI18N
        jButton2.setText("Volver");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(159, 211, 241));
        jPanel3.setPreferredSize(new java.awt.Dimension(470, 364));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boton_Volver_Variante1.setBackground(new java.awt.Color(235, 235, 235));
        boton_Volver_Variante1.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_Volver_Variante1.setText("Volver");
        boton_Volver_Variante1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_Volver_Variante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_Volver_Variante1ActionPerformed(evt);
            }
        });
        jPanel3.add(boton_Volver_Variante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 80, 27));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Denominacion1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Denominacion1.setText("Síntomas");
        jPanel4.add(label_Denominacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        desplegable_Sintoma.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_Sintoma.setPreferredSize(new java.awt.Dimension(56, 24));
        desplegable_Sintoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegable_SintomaActionPerformed(evt);
            }
        });
        jPanel4.add(desplegable_Sintoma, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 240, -1));

        boton_VerSintomas1.setBackground(new java.awt.Color(235, 235, 235));
        boton_VerSintomas1.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_VerSintomas1.setText("Eliminar");
        boton_VerSintomas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_VerSintomas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_VerSintomas1ActionPerformed(evt);
            }
        });
        jPanel4.add(boton_VerSintomas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 90, 27));

        TableSint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Síntomas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableSint);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 270, 110));

        boton_VerSintomas2.setBackground(new java.awt.Color(235, 235, 235));
        boton_VerSintomas2.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_VerSintomas2.setText("Agregar");
        boton_VerSintomas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_VerSintomas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_VerSintomas2ActionPerformed(evt);
            }
        });
        jPanel4.add(boton_VerSintomas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 27));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 100, 110));

        boton_AggSintNueva.setBackground(new java.awt.Color(235, 235, 235));
        boton_AggSintNueva.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        boton_AggSintNueva.setText("Agregar nueva");
        boton_AggSintNueva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_AggSintNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_AggSintNuevaActionPerformed(evt);
            }
        });
        jPanel4.add(boton_AggSintNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 100, 27));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 57, 410, 250));

        title_RegistroVariante1.setFont(new java.awt.Font("Forte", 0, 24)); // NOI18N
        title_RegistroVariante1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_RegistroVariante1.setText("Registro de síntomas");
        jPanel3.add(title_RegistroVariante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 470, 40));

        regisSintoma.getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_START);

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
        jPanel1.add(boton_Volver_Variante, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 80, 27));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flo 1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 154, 110));

        label_Clasificacion.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Clasificacion.setText("Clasificación: ");
        jPanel2.add(label_Clasificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        label_Denominacion.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Denominacion.setText("Denominación OMS:");
        jPanel2.add(label_Denominacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        label_Linaje.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Linaje.setText("Linaje:");
        jPanel2.add(label_Linaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        label_PaisOrigen.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_PaisOrigen.setText("País de origen:");
        jPanel2.add(label_PaisOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        label_Fecha_Origen.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Fecha_Origen.setText("Fecha de origen: ");
        jPanel2.add(label_Fecha_Origen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        label_Sintomas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        label_Sintomas.setText("Síntomas:");
        jPanel2.add(label_Sintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        desplegable_calendar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanel2.add(desplegable_calendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, 20));

        desplegable_PaisOrigen.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        desplegable_PaisOrigen.setPreferredSize(new java.awt.Dimension(56, 24));
        desplegable_PaisOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desplegable_PaisOrigenActionPerformed(evt);
            }
        });
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
        boton_VerSintomas.setText("Agregar sintomas");
        boton_VerSintomas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        boton_VerSintomas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_VerSintomasActionPerformed(evt);
            }
        });
        jPanel2.add(boton_VerSintomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 130, 27));

        field_Denominacion.setBackground(new java.awt.Color(235, 235, 235));
        field_Denominacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_DenominacionActionPerformed(evt);
            }
        });
        jPanel2.add(field_Denominacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 190, -1));

        field_Linaje.setBackground(new java.awt.Color(235, 235, 235));
        field_Linaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_LinajeActionPerformed(evt);
            }
        });
        jPanel2.add(field_Linaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 190, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 57, 470, -1));

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
        jPanel1.add(boton_Siguiente_Variante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 80, 27));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_Volver_VarianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_VarianteActionPerformed
        // TODO add your handling code here:
        RegistroVisualizacionVariante RVV = new RegistroVisualizacionVariante();
        crea.InterfazDiferentes(this, RVV, 1008, 550);
    }//GEN-LAST:event_boton_Volver_VarianteActionPerformed

    private void boton_VerSintomasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_VerSintomasActionPerformed
        // TODO add your handling code here:
        crea.InterfazIguales(this, regisSintoma, 467, 385);
    }//GEN-LAST:event_boton_VerSintomasActionPerformed

    private void desplegable_ClasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_ClasificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegable_ClasificacionActionPerformed

    private void boton_Siguiente_VarianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Siguiente_VarianteActionPerformed
        // TODO add your handling code here:
        Verificador veri = new Verificador();
        if((veri.dataNB(field_Denominacion))&&(veri.dataNB(field_Linaje))){
            if((veri.noVacio(field_Denominacion.getText().toString()))&&(veri.noVacio(field_Linaje.getText().toString()))){
                //if((field_NTelefono.getText().toString().matches("-?\\d+"))&&(field_Numero_Doc1.getText().toString().matches("-?\\d+"))){
                    Guardar insertSQL = new Guardar();
                    if (insertSQL.guardadoVariante(field_Denominacion,field_Linaje, desplegable_calendar, desplegable_Clasificacion.getSelectedItem().toString(),desplegable_PaisOrigen.getSelectedItem().toString()))
                        insertSQL.iteGuardarSintVar(TableSint, field_Denominacion.getText().toString());
                //}else
                    //JOptionPane.showMessageDialog(null,"La informacion en los campos numericos no es valida","Error",ERROR_MESSAGE);    
            }else{
                JOptionPane.showMessageDialog(null, "No se admiten casillas con unicamente espacios en blanco","Error",ERROR_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(null, "Se encuentran casillas sin rellenar","Error",ERROR_MESSAGE);
        
    }//GEN-LAST:event_boton_Siguiente_VarianteActionPerformed

    private void field_DenominacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_DenominacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_DenominacionActionPerformed

    private void field_LinajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_LinajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_LinajeActionPerformed

    private void desplegable_PaisOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_PaisOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegable_PaisOrigenActionPerformed

    private void desplegable_SintomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desplegable_SintomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desplegable_SintomaActionPerformed

    private void boton_AggSintNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_AggSintNuevaActionPerformed
        // TODO add your handling code here:
        String nuevoSintoma = JOptionPane.showInputDialog("Ingrese síntoma");
        if(nuevoSintoma != null){
            Verificador veri = new Verificador();
            if (veri.dataNBS(nuevoSintoma)){
                Guardar insertSQL = new Guardar();
                if(insertSQL.guardarSintoma(nuevoSintoma)){
                    ArrayList<String> listas = dataSQL.descripsintoma(dataSQL.Sintomas());
                    desplegable_Sintoma.removeAllItems();
                    for (int i = 0; i < listas.size(); i++) {
                        desplegable_Sintoma.addItem(listas.get(i));
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "La información ingresada es incorrecta", "Error", ERROR_MESSAGE);
            }
            
        }
        
    }//GEN-LAST:event_boton_AggSintNuevaActionPerformed

    private void boton_VerSintomas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_VerSintomas2ActionPerformed
        // TODO add your handling code here:
        Verificador veri = new Verificador();
        model = (DefaultTableModel) TableSint.getModel();
        String dato;
        dato = desplegable_Sintoma.getSelectedItem().toString();
        if(!veri.existenciaTable(model, dato)){
            model.addRow(new Object[]{dato});
        }
    }//GEN-LAST:event_boton_VerSintomas2ActionPerformed

    private void boton_VerSintomas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_VerSintomas1ActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) TableSint.getModel();
        System.out.println(TableSint.getSelectedRow());
        if (TableSint.getSelectedRow() != -1)
            model.removeRow(TableSint.getSelectedRow());
        else
            JOptionPane.showMessageDialog(null, "No ha seleccionado una enfermedad a eliminar","Warning",WARNING_MESSAGE);
    }//GEN-LAST:event_boton_VerSintomas1ActionPerformed

    private void boton_Volver_Variante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_Volver_Variante1ActionPerformed
        // TODO add your handling code here:
        crea.InterfazIguales(regisSintoma, this, 594, 580); 
    }//GEN-LAST:event_boton_Volver_Variante1ActionPerformed

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
    private javax.swing.JTable TableSint;
    private javax.swing.JButton boton_AggSintNueva;
    private javax.swing.JButton boton_Siguiente_Variante;
    private javax.swing.JButton boton_VerSintomas;
    private javax.swing.JButton boton_VerSintomas1;
    private javax.swing.JButton boton_VerSintomas2;
    private javax.swing.JButton boton_Volver_Variante;
    private javax.swing.JButton boton_Volver_Variante1;
    private javax.swing.JComboBox<String> desplegable_Clasificacion;
    private javax.swing.JComboBox<String> desplegable_PaisOrigen;
    private javax.swing.JComboBox<String> desplegable_Sintoma;
    private com.toedter.calendar.JDateChooser desplegable_calendar;
    private javax.swing.JTextField field_Denominacion;
    private javax.swing.JTextField field_Linaje;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Clasificacion;
    private javax.swing.JLabel label_Denominacion;
    private javax.swing.JLabel label_Denominacion1;
    private javax.swing.JLabel label_Fecha_Origen;
    private javax.swing.JLabel label_Linaje;
    private javax.swing.JLabel label_PaisOrigen;
    private javax.swing.JLabel label_Sintomas;
    private javax.swing.JFrame regisSintoma;
    private javax.swing.JLabel title_RegistroVariante;
    private javax.swing.JLabel title_RegistroVariante1;
    // End of variables declaration//GEN-END:variables
}
