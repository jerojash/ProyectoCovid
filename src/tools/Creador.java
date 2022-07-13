package tools;

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
}
