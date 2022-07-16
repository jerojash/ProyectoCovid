package SQL;

import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tools.Buscador;

public class Guardar {
    
    public void guardadoPersona(String doc,JTextField nombre,JTextField apellido,JDateChooser fechaNac,String sexo,JTextField direccion,JTextField numero,boolean altoRiesgo,String ocupacion,String estado,String pais,JDateChooser fechaReside){            
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Date date = fechaNac.getDate();
            long da = date.getTime();
            java.sql.Date fecha = new java.sql.Date(da);
            String value = "'"+doc+"','"+nombre.getText().toString()+"','"+apellido.getText().toString()+"','"+fecha.toString()+"','"+sexo+"','"+direccion.getText().toString()+"','"+numero.getText().toString()+"','"+altoRiesgo+"','"+ocupacion+"'";
            String sql = "insert into persona(doc_identidad,nombper,apellidoper,fecha_nac,sexo,direccion_p,n_contacto,alto_riesgo,ocupacion) values("+value+")";
            st.execute(sql);
            Buscador select = new Buscador();
            date = fechaReside.getDate();
            da = date.getTime();
            fecha = new java.sql.Date(da);
            value = "'"+doc+"','"+select.codEstado(select.codPais(pais), estado)+"','"+fecha.toString()+"'";
            sql = "insert into reside (docidentidad,codestado,fechareside) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    
    public void iteGuardarEnfePer(JTable tabla, String cedula){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i<tabla.getRowCount();i++){
            this.guardarEnfePer(modelo.getValueAt(i, 0).toString(), cedula);
        }
    }
    
    public void guardarEnfePer(String nomEnfe, String cedula){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            ArrayList<String> codEnf = busc.CodEnfermedad(nomEnfe);
            for (int i = 0; i<codEnf.size();i++){
                String value = "'"+cedula+"','"+codEnf.get(i)+"'";
                String sql = "insert into padece (docidentidad,codenfermedad) values("+value+")";
                System.out.println(sql);
                st.execute(sql);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
}
