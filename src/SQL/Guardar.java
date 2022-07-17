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
    
    public boolean guardadoPersona(String doc,JTextField nombre,JTextField apellido,JDateChooser fechaNac,String sexo,JTextField direccion,JTextField numero,boolean altoRiesgo,String ocupacion,String estado,String pais,JDateChooser fechaReside){            
        boolean guardado = true;
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
            guardado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return guardado;
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
                st.execute(sql);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    
    public Boolean guardadoPersonalSalud(String correo, String doc,JTextField nombre,JTextField apellido,JDateChooser fechaNac,String sexo,JTextField direccion,JTextField numero,Boolean altoRiesgo,String ocupacion,String estado,String pais,JDateChooser fechaReside){            
        Boolean verificado = true;
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
           
            da = date.getTime();
            String esMedico = "F";
            String esAsistente = "F";
            String esEnfermero = "F";
            if (ocupacion.equals("Medico")){
                esMedico = "T";
            } else if (ocupacion.equals("Enfermero")){
                esEnfermero = "T";
            } else if (ocupacion.equals("Asistente Medico")){
                esAsistente = "T";
            }
            fecha = new java.sql.Date(da);
            value = "'"+doc+"','"+correo+"','"+esAsistente+"','"+esEnfermero+"'";
            sql = "insert into personal_salud(docidentidad_ps, correo, es_asis_medico, es_enfermero) values("+value+")";
            st.execute(sql);
            if(esMedico.equals("T")){
                value = "'"+doc+"'";
                sql = "insert into medico(docidentidad_med) values("+value+")";
                st.execute(sql);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            verificado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return verificado;
    } 
    
    public void iteGuardarCentroAsignado(JTable tabla, String cedula){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i<tabla.getRowCount();i++){
            this.guardarCentroAsignado(modelo.getValueAt(i, 0).toString(),modelo.getValueAt(i, 1).toString(), cedula);
        }
    }
    
    public void guardarCentroAsignado(String centro, String fecha, String cedula){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+cedula+"','"+centro+"','"+fecha+"'";
            String sql = "insert into asignado(docidentidad_ps, codcentro, fechaasignado) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    
    public Boolean guardarEnfermedad(String nomEnfer){
        Boolean verificar = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+nomEnfer+"'";
            String sql = "insert into enfermedad(nombenfermedad) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return verificar;
    }
    
    public void ModiPerso(String cedula,String datoModi, int caso){ 
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String sql="";
            switch (caso){
                case 1:
                    sql = "update persona set nombper = '"+datoModi+"' where doc_identidad = '"+cedula+"'";
                    System.out.println("update persona set nombper = '"+datoModi+"' where doc_identidad = '"+cedula+"'");
                break;
                case 2:
                    sql = "update persona set apellidoper = '"+datoModi+"' where doc_identidad = '"+cedula+"'";
                break;
                case 3:
                    sql = "update persona set fecha_nac = '"+datoModi+"' where doc_identidad = '"+cedula+"'";
                break;
                case 4:
                    sql = "update persona set sexo = '"+datoModi+"' where doc_identidad = '"+cedula+"'";
                break;
                case 5:
                    sql = "update persona set n_contaco = '"+datoModi+"' where doc_identidad = '"+cedula+"'";
                break;
                case 6:
                    sql = "update persona set alto_riesgo = '"+datoModi+"' where doc_identidad = '"+cedula+"'";
                break;
                case 7:
                    sql = "update persona set ocupacion = '"+datoModi+"' where doc_identidad = '"+cedula+"'";                    
            }
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }           
    }
}
