package tools;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Creador {
    public void addTableHeaderEnfer(DefaultTableModel model,JTable Enfermedades) {
        model = (DefaultTableModel) Enfermedades.getModel();
        Object[] newIdentifiers = new Object[]{"Enfermedades"};
        model.setColumnIdentifiers(newIdentifiers);
        Enfermedades.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Enfermedades.getColumnCount(); x++) {
            Enfermedades.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void Interfaz( JFrame nueva, int ancho, int largo){
        nueva.setResizable(false); 
        nueva.setVisible(true);
        nueva.setSize(ancho,largo);     
        nueva.setLocationRelativeTo(null); 
    }
    public void InterfazIguales(JFrame actual, JFrame nueva, int ancho, int largo){
        actual.setVisible(false);
        nueva.setResizable(false); 
        nueva.setVisible(true);
        nueva.setSize(ancho,largo);     
        nueva.setLocationRelativeTo(null); 
    }
    
    public void InterfazDiferentes(JFrame actual, JFrame nueva, int ancho, int largo){
        nueva.setResizable(false); 
        nueva.setSize(ancho, largo);   
        nueva.setVisible(true);   
        nueva.setLocationRelativeTo(null);
        actual.dispose();
    }
}
