package tools;

import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.util.Date;

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
}
