package tools;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Creador {
    public void addTableHeaderEnfer(DefaultTableModel model,JTable Table) {
        model = (DefaultTableModel) Table.getModel();
        Object[] newIdentifiers = new Object[]{"Enfermedades"};
        model.setColumnIdentifiers(newIdentifiers);
        Table.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Table.getColumnCount(); x++) {
            Table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void addTableHeaderCentro(DefaultTableModel model,JTable Centros) {
        model = (DefaultTableModel) Centros.getModel();
        Object[] newIdentifiers = new Object[]{"Centros de Salud", "Fecha de asignación"};
        model.setColumnIdentifiers(newIdentifiers);
        Centros.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Centros.getColumnCount(); x++) {
            Centros.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void addTableHeaderCentroSalud(DefaultTableModel model,JTable Centros) {
        model = (DefaultTableModel) Centros.getModel();
        Object[] newIdentifiers = new Object[]{"Codigo","Centro de salud","Dirección","Encargado","Fecha encargado","Estado","Tipo"};
        model.setColumnIdentifiers(newIdentifiers);
        Centros.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Centros.getColumnCount(); x++) {
            Centros.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void addTableHeaderRep2(DefaultTableModel model,JTable Centros) {
        model = (DefaultTableModel) Centros.getModel();
        Object[] newIdentifiers = new Object[]{"Vacuna", "Porcentaje contagios pos vacuna"};
        model.setColumnIdentifiers(newIdentifiers);
        Centros.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Centros.getColumnCount(); x++) {
            Centros.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void addTableHeaderRep3(DefaultTableModel model,JTable Centros) {
        model = (DefaultTableModel) Centros.getModel();
        Object[] newIdentifiers = new Object[]{"Centro de vacunacion", "Porcentaje contagios pos vacuna"};
        model.setColumnIdentifiers(newIdentifiers);
        Centros.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Centros.getColumnCount(); x++) {
            Centros.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void addTableHeaderPer(DefaultTableModel model,JTable Table){
        model = (DefaultTableModel) Table.getModel();
        Object[] newIdentifiers = new Object[]{"Documento","Nombre","Apellido","F.Nac","Sexo","Direccion","Teléfono","Alto riesgo","Ocupacion"};
        model.setColumnIdentifiers(newIdentifiers);
        Table.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Table.getColumnCount(); x++) {
            Table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void addTableHeaderPerRes(DefaultTableModel model,JTable Table){
        model = (DefaultTableModel) Table.getModel();
        Object[] newIdentifiers = new Object[]{"Estado","Fecha reside"};
        model.setColumnIdentifiers(newIdentifiers);
        Table.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Table.getColumnCount(); x++) {
            Table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    public void addTableHeaderVarSint(DefaultTableModel model,JTable Table){
        model = (DefaultTableModel) Table.getModel();
        Object[] newIdentifiers = new Object[]{"Síntomas"};
        model.setColumnIdentifiers(newIdentifiers);
        Table.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Table.getColumnCount(); x++) {
            Table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
        }
    }
    
    
    public void addTableHeaderVar(DefaultTableModel model,JTable Table){
        model = (DefaultTableModel) Table.getModel();
        Object[] newIdentifiers = new Object[]{"Denominación","Linaje","F.Org","Clasificación","País"};
        model.setColumnIdentifiers(newIdentifiers);
        Table.setFillsViewportHeight(true);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int x = 0; x < Table.getColumnCount(); x++) {
            Table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);            
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
