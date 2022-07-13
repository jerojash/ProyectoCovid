package tools;

import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Verificador {

    public Verificador() {
        
    }
  
    public boolean dataNB (TextField entrada){
        boolean NV = true;
        
        if (entrada.getText().toString().equals("")){
            NV = false;
        }
        
        return NV;
    }
    
    public boolean fechaV (JDateChooser fecha){
        boolean FV = true;
        Date fechaS = fecha.getDate();
        Date fechaA = new Date(System.currentTimeMillis());
        
        if (fechaS.after(fechaA))
            FV = false;
        
        return FV;
    }
    
    public boolean existenciaTable (DefaultTableModel model, String dato){
        boolean existe = false;
        int filas = model.getRowCount();
        int i = 0;
        if (filas != 0){
            while((!existe)&&(i<filas)){
                System.out.println(model.getValueAt(i,0));
                if (dato.equals((String)model.getValueAt(i,0)))
                    existe = true;
                i++;
            } 
        }
        return existe;
    }
}
