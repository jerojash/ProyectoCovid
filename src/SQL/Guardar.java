package SQL;

import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JTextField;
import tools.Buscador;

public class Guardar {
    ConexionSQL conexion= new ConexionSQL();
    public void guardadoPersona(String doc,TextField nombre,TextField apellido,JDateChooser fechaNac,String sexo,TextField direccion,TextField numero,String altoRiesgo,TextField ocupacion,String estado,String pais,JDateChooser fechaReside){            
        try { 
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Date date = fechaNac.getDate();
            long da = date.getTime();
            java.sql.Date fecha = new java.sql.Date(da);
            System.out.println("1");
            String value = "'"+doc+"','"+nombre.getText().toString()+"','"+apellido.getText().toString()+"','"+fecha.toString()+"','"+sexo+"','"+direccion.getText().toString()+"','"+numero.getText().toString()+"','"+altoRiesgo+"','"+ocupacion.getText().toString()+"'";
            String sql = "insert into persona(doc_identidad,nombper,apellidoper,fecha_nac,sexo,direccion_p,n_contacto,alto_riesgo,ocupacion) values("+value+")";
            System.out.println(sql);
            st.execute(sql);
            Buscador select = new Buscador();
            date = fechaReside.getDate();
            da = date.getTime();
            fecha = new java.sql.Date(da);
            System.out.println("2");
            value = "'"+doc+"','"+select.codEstado(select.codPais(pais), estado)+"','"+fecha.toString()+"'";
            sql = "insert into reside (docidentidad,codestado,fechareside) values("+value+")";
            System.out.println(sql);
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("murio");
        }
    }   
}
