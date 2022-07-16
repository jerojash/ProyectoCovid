package tools;

import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Verificador {

    public Verificador() {
        
    }
  
    public boolean dataNB (JTextField entrada){
        boolean NV = true;
        
        if (entrada.getText().toString().equals("")){
            NV = false;
        }
        
        return NV;
    }  
        
    public boolean dataNBS (String entrada){
        boolean NV = true;
        
        if (entrada.equals("")){
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
                if (dato.equals((String)model.getValueAt(i,0)))
                    existe = true;
                i++;
            } 
        }
        return existe;
    }
    
    public boolean altoRiesgo(String dato){
        if (dato.equals("Si"))
            return true;
        else
            return false;
    }
    
    public String altoRiesgoI(String dato){
        if (dato.equals("t"))
            return "Si";
        else
            return "No";
    }
    
    public boolean noVacio (String validar){
        int x= validar.length();
        if (!validar.isEmpty()) {
            for (int i = 0; i < x; i++) {
                if ((' '!=(validar.charAt(i)))) {
                    return true;
                }
            }
        } 
           return false;      
    }
    
    public boolean validarCE(String Correo){
        Pattern pat = Pattern.compile ("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+.([a-zA-Z]{2,4})");
        Matcher mat = pat.matcher(Correo);
        if (!mat.matches())
            return false;
        else
            return true;
    } 
}
