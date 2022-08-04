package SQL;

import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tools.Buscador;

public class Guardar {
    
    public void guardadoReside(String doc, String estado, JDateChooser fechaReside,String pais){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Date date = fechaReside.getDate();
            long da = date.getTime();
            java.sql.Date fecha = new java.sql.Date(da);
            Buscador select = new Buscador();
            String value = "'"+doc+"','"+select.codEstado(select.codPais(pais), estado)+"','"+fecha.toString()+"'";
            String sql = "insert into reside (docidentidad,codestado,fechareside) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    
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
    
    public Boolean guardarCentroSalud(String tipo, JTextField nombre, JTextField direccion, String estado, String medicoEncargado, JDateChooser fechaEncargo){
        Boolean verificado=true;
        try {
            
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Date date = fechaEncargo.getDate();
            ResultSet rs = st.executeQuery("select codestado from estado_provincia where nombestado like '"+estado+"'");
            rs.next();
            long da = date.getTime();
            java.sql.Date fecha = new java.sql.Date(da);
            fechaEncargo.setDateFormatString("yyyy-mm-dd");
//            String fecha =((JTextField)fechaEncargo.getDateEditor().getUiComponent()).getText();
            String value = "'"+nombre.getText().toString()+"','"+direccion.getText().toString()+"','"+medicoEncargado+"','"+fecha.toString()+"','"+String.valueOf(rs.getInt(1))+"'";
            String sql = "insert into centro_salud(nombcentro, direccion, docidentidad_encargado, fechaencargado, codestado) VALUES ("+value+");";
            st.execute(sql);
            rs = st.executeQuery("select codcentro from centro_salud order by codcentro desc limit 1");
            rs.next();
            value = "'"+rs.getString(1)+"'";
            if (tipo.equals("Vacunacion")){
                     sql = "INSERT INTO public.vacunacion(codcentro_vac) VALUES ("+value+");"; 
        }else sql = "INSERT INTO public.hospitalizacion(codcentro_hos) VALUES ("+value+");";
            st.execute(sql);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        } catch (Exception e) {
            verificado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        
        return verificado;
    }
    
    public Boolean modificarCentroSalud(String tipo, String cod, JTextField nombre, JTextField direccion, String estado, String medicoEncargado, JDateChooser fechaEncargo){
        Boolean verificado=true;
        try {
            
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Date date = fechaEncargo.getDate();
            ResultSet rs = st.executeQuery("select codestado from estado_provincia where nombestado like '"+estado+"'");
            rs.next();
            long da = date.getTime();
            java.sql.Date fecha = new java.sql.Date(da);
            fechaEncargo.setDateFormatString("yyyy-mm-dd");
            String value = "nombcentro= '"+nombre.getText().toString()+"', direccion = '"+direccion.getText().toString()+"', docidentidad_encargado=  '" + medicoEncargado+"', fechaencargado  = '" +  fecha.toString() + "' ,  codestado  = '" + String.valueOf(rs.getInt(1))+"'";
            String sql = "UPDATE centro_salud SET "+value+" where codcentro = '"+cod+"';";
            st.execute(sql);
            
            if (tipo.equals("Vacunacion")){
                    sql = "DELETE FROM hospitalizado WHERE codcentro_hos = '"+cod+"'";
                    st.execute(sql);
                    sql = "DELETE FROM hospitalizacion WHERE codcentro_hos = '"+cod+"'";
                    st.execute(sql);
                    sql = "INSERT INTO public.vacunacion(codcentro_vac) VALUES ("+cod+");";
            }else {
                    sql = "DELETE FROM vacunada WHERE codcentro_vac = '"+cod+"'";
                    st.execute(sql);
                    sql = "DELETE FROM vacunacion WHERE codcentro_vac = '"+cod+"'";
                    st.execute(sql);
                    sql = "INSERT INTO public.hospitalizacion(codcentro_hos) VALUES ("+cod+");";
                }
            st.execute(sql);
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        } catch (Exception e) {
            verificado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        
        return verificado;
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
    
    public void iteGuardarSintVar(JTable tabla, String denom_oms){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i<tabla.getRowCount();i++){
            this.guardarSintVar(modelo.getValueAt(i, 0).toString(), denom_oms);
        }
    }
    
    public void guardarSintVar(String descripsintoma, String denom_oms){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            ArrayList<String> codSint = busc.CodSintoma(descripsintoma);
            for (int i = 0; i<codSint.size();i++){
                String value = "'"+denom_oms+"','"+codSint.get(i)+"'";
                String sql = "insert into tiene (denom_oms,codsintoma) values("+value+")";
                st.execute(sql);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    
    public Boolean guardarSintoma(String descripsintoma){
        Boolean verificar = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+descripsintoma+"'";
            String sql = "insert into sintoma_efecto(descripsintoma) values("+value+")";
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
                    break;
                case 8:
                    sql = "update persona set direccion_p = '"+datoModi+"' where doc_identidad = '"+cedula+"'";
                    break;
            }
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }           
    }
    
    public boolean guardadoVariante(JTextField denom_oms,JTextField linaje,JDateChooser fechaorigen,String clasificacion,String codpais){            
        boolean guardado = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Date date = fechaorigen.getDate();
            long da = date.getTime();
            java.sql.Date fecha = new java.sql.Date(da);
            Buscador select = new Buscador();
            String value = "'"+denom_oms.getText().toString()+"','"+linaje.getText().toString()+"','"+fecha.toString()+"','"+clasificacion+"','"+select.codPais(codpais)+"'"; //+"','"+direccion.getText().toString()+"','"+codpais.getText().toString()+"','"+altoRiesgo+"','"+ocupacion+"'";
            String sql = "insert into virus_variante(denom_oms,linaje,fechaorigen,clasificacion,codpais) values("+value+")";
            System.out.println(sql);
            st.execute(sql);
            /*Buscador select = new Buscador();
            date = fechaReside.getDate();
            da = date.getTime();
            fecha = new java.sql.Date(da);
            value = "'"+doc+"','"+select.codEstado(select.codPais(pais), estado)+"','"+fecha.toString()+"'";
            sql = "insert into reside (docidentidad,codestado,fechareside) values("+value+")";
            st.execute(sql);*/
            st.close();
            con.close();
        } catch (Exception e) {
            guardado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return guardado;
    }
    
    public void ModiVar(String denom_oms,String datoModi, int caso){ 
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String sql="";
            switch (caso){
                case 1:
                    sql = "update virus_variante set linaje = '"+datoModi+"' where denom_oms = '"+denom_oms+"'";
                    System.out.println("update persona set nombper = '"+datoModi+"' where denom_oms = '"+denom_oms+"'");
                break;
                case 2:
                    sql = "update virus_variante set fechaorigen = '"+datoModi+"' where denom_oms = '"+denom_oms+"'";
                break;
                case 3:
                    sql = "update virus_variante set clasificacion = '"+datoModi+"' where denom_oms = '"+denom_oms+"'";                  
            }
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }           
    }
    
    //yerlin
    public boolean vacunacion(String persona, String vacuna, String centro, String personal, JDateChooser fecha, String dosis){
        boolean validar = true;
        try {
            Date date = fecha.getDate();
            long da = date.getTime();
            java.sql.Date fechaV = new java.sql.Date(da);
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+persona+"','"+vacuna+"','"+centro+"','"+personal+"','"+fechaV+"','"+dosis+"'";
            String sql = "insert into vacunada(docidentidad,idvacuna,codcentro_vac,docidentidad_ps,fechavacuna,dosis) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
            return validar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
            return false;
        }
    }
    
    //nuevo nuevo
    public void ModiPersonal(String cedula,String datoModi){ 
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String sql="";
            sql = "update personal_salud set correo = '"+datoModi+"' where docidentidad_ps = '"+cedula+"'";
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        } 
    }
    
    public void modiOcupacionPersonal(String cedula, String anterior, String nuevo){
        if(!anterior.equals(nuevo)){
            try {
                ConexionSQL conexion= new ConexionSQL();
                Connection con = conexion.connected();
                java.sql.Statement st = con.createStatement();
                if(anterior.equals("Medico")){
                    Buscador bus = new Buscador();
                    bus.tableMedicoEli(cedula);
                }
                String esMedico = "F";
                String esAsistente = "F";
                String esEnfermero = "F";
                if (nuevo.equals("Medico")){
                    esMedico = "T";
                } else if (nuevo.equals("Enfermero")){
                    esEnfermero = "T";
                } else if (nuevo.equals("Asistente Medico")){
                    esAsistente = "T";
                }
                String sql = "";
                sql = "update personal_salud set es_asis_medico = '"+esAsistente+"', es_enfermero = '"+esEnfermero+"' where docidentidad_ps = '"+cedula+"'";
                st.executeUpdate(sql);
                if(esMedico.equals("T")){
                    String value = "'"+cedula+"'";
                    sql = "insert into medico(docidentidad_med) values("+value+")";
                    st.execute(sql);
                }
                st.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
            } 
            
        }
    }
    public boolean guardadoVacuna(JTextField lote, JTextField nombvacuna, JTextField cantdosis, JTextField laboratorio,  String tipo, String codpais){            
        boolean guardado = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Buscador select = new Buscador();
            String value = "'"+lote.getText().toString()+"','"+nombvacuna.getText().toString()+"','"+cantdosis.getText().toString()+"','"+laboratorio.getText().toString()+"','"+tipo+"','"+select.codPais(codpais)+"'"; //+"','"+direccion.getText().toString()+"','"+codpais.getText().toString()+"','"+altoRiesgo+"','"+ocupacion+"'";
            String sql = "insert into vacuna(lote,nombvacuna,cantdosis,laboratorio,tipo, codpais) values("+value+")";
            System.out.println(sql);
            st.execute(sql);
            /*Buscador select = new Buscador();
            date = fechaReside.getDate();
            da = date.getTime();
            fecha = new java.sql.Date(da);
            value = "'"+doc+"','"+select.codEstado(select.codPais(pais), estado)+"','"+fecha.toString()+"'";
            sql = "insert into reside (docidentidad,codestado,fechareside) values("+value+")";
            st.execute(sql);*/
            st.close();
            con.close();
        } catch (Exception e) {
            guardado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return guardado;
    }
    
    public boolean guardadoMedicamento(JTextField nombre, JTextField concentracion, JTextField compuesto){            
        boolean guardado = false;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();
            Buscador select = new Buscador();
            String value = "'"+nombre.getText().toString()+"','"+concentracion.getText().toString()+"', '"+compuesto.getText().toString()+"' "; 
            String sql = "INSERT INTO public.medicamento(nombremedicamento, compuesto, concentracion) values("+value+")";
            System.out.println(sql);
            st.execute(sql);
            st.close();
            con.close();
            guardado = true;
        } catch (Exception e) {
            guardado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return guardado;
    }
    
    
    public ArrayList<String> CodVacunas(String NombreVacuna){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st; System.out.println(NombreVacuna);
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacuna where nombvacuna='"+NombreVacuna+"'");
            while(rs.next()){
                codigos.add(rs.getString(1));
            }
            con.disconnect();
            return codigos;
        } catch (Exception e) {
            System.out.println("codSintoma murio");
        }
        con.disconnect();
        return null;
    }
    public void guardarSintVac(String descripsintoma, String nombvacuna){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            System.out.println(descripsintoma);
            ArrayList<String> codSint = busc.CodSintoma(descripsintoma);
            ArrayList<String> codvacuna = busc.CodVacunas(nombvacuna);
            for (int i = 0; i<codSint.size();i++){
                String value = "'"+codvacuna.get(i)+"','"+codSint.get(i)+"'";
                String sql = "insert into presenta (idvacuna,codsintoma) values("+value+")";
                System.out.println(sql);
                st.execute(sql);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    
    public void iteGuardarSintVac(JTable tabla, String nombrevacuna){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
         System.out.println(nombrevacuna);
        for (int i = 0; i<tabla.getRowCount();i++){
            this.guardarSintVac(modelo.getValueAt(i, 0).toString(), nombrevacuna);
        }
    }
      public void iteGuardarEficacia(JTable tabla, String nombrevacuna){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i<tabla.getRowCount();i++){
            this.guardarEficacia1(modelo.getValueAt(i, 0).toString(),modelo.getValueAt(i, 1).toString(), nombrevacuna );
        }
    }  
      
    public void guardarEficacia(String denom_oms, String porceficacia, String codVacuna){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            System.out.println(codVacuna);
            String value = "'"+codVacuna+"','"+denom_oms+"','"+porceficacia+"'";
            String sql = "insert into eficaz (idvacuna, denom_oms, porceficacia) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
        public void guardarEficacia1(String denom_oms, String porceficacia, String nombvacuna){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            ArrayList<String> codVacuna = busc.CodVacunas(nombvacuna);
           System.out.println(codVacuna.size());
            for (int i = 0; i<codVacuna.size();i++){
                String value = "'"+codVacuna.get(i)+"','"+denom_oms+"','"+porceficacia+"'";
               //  String value = "'"+idvacuna+"','"+denom_oms+"','"+porceficacia+"'";
                String sql = "insert into eficaz (idvacuna, denom_oms, porceficacia) values("+value+")";
                System.out.println(sql);
                st.execute(sql);
           }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }  
    public void ModiVac(String idvacuna,String datoModi, int caso){ 
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String sql="";
            switch (caso){
                case 1:
                    sql = "update vacuna set lote = '"+datoModi+"' where idvacuna = '"+idvacuna+"'";
                break;
                case 2:
                    sql = "update vacuna set nombvacuna = '"+datoModi+"' where idvacuna = '"+idvacuna+"'";
                break;
                case 3:
                    sql = "update vacuna set cantdosis = '"+datoModi+"' where idvacuna = '"+idvacuna+"'";
                break; 
                case 4:
                    sql = "update vacuna set laboratorio = '"+datoModi+"' where idvacuna = '"+idvacuna+"'";
                break;
                case 5:
                    sql = "update vacuna set tipo = '"+datoModi+"' where idvacuna = '"+idvacuna+"'";   
               // break;    
               // case 6:
                //sql = "update eficaz set porceficacia = '"+datoModi+"' where idvacuna = '"+idvacuna+"'";   
            }
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }           
    }   
    public boolean guardadoTratamiento(JTextArea descriptratamiento){            
        boolean guardado = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();  
            java.sql.Statement st = con.createStatement();

            Buscador select = new Buscador();
            String value = "'"+descriptratamiento.getText().toString()+"'";
            String sql = "insert into tratamiento(descriptratamiento) values("+value+")";
            System.out.println(sql);
            st.execute(sql);

            st.close();
            con.close();
        } catch (Exception e) {
            guardado = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return guardado;
    }
    
    public void iteGuardarTratMed(JTable tabla, JTextArea descriptratamiento ){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Buscador busc = new Buscador(); 
        String codTrat;
        codTrat = busc.codTratamiento(descriptratamiento.getText().toString());
        for (int i = 0; i<tabla.getRowCount();i++){
            this.guardarTratMed(codTrat, modelo.getValueAt(i, 0).toString(),modelo.getValueAt(i, 1).toString(), modelo.getValueAt(i, 2).toString(), modelo.getValueAt(i, 3).toString());
        }
    
    }
        
    public void guardarTratMed(String codtrat, String nombmedicamento, String dosis, String cantdosis, String frecuencia){
        try { 
            System.out.println("En guardar Trat Med");
            System.out.println(nombmedicamento);
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            String codMed = busc.codMedicamento(nombmedicamento);
            String value = "'"+codtrat+"','"+codMed+"','"+dosis+"','"+cantdosis+"','"+frecuencia+"'";
            String sql = "insert into consiste (codtrat,codmedicamento, dosis, cantdias, frecuencia) values("+value+")";
            System.out.println(sql);
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
   public void ModiTrat(String codtrat,String datoModi){ 
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String sql="";
            sql = "update tratamiento set descriptratamiento = '"+datoModi+"' where codtrat = '"+codtrat+"'";
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }           
    } 
        public void iteModificarTratMed(JTable tabla, String codTrat ){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Buscador busc = new Buscador(); 
        for (int i = 0; i<tabla.getRowCount();i++){
            this.guardarTratMed(codTrat, modelo.getValueAt(i, 0).toString(),modelo.getValueAt(i, 1).toString(), modelo.getValueAt(i, 2).toString(), modelo.getValueAt(i, 3).toString());
        }
    
    }
     public void ModificarTratMed(String codtrat, String nombmedicamento, String dosis, String cantdosis, String frecuencia){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            String codMed = busc.codMedicamento(nombmedicamento);
            String value = "'"+codtrat+"','"+codMed+"','"+dosis+"','"+cantdosis+"','"+frecuencia+"'";
            String sql = "insert into consiste (codtrat,codmedicamento, dosis, cantdias, frecuencia) values("+value+")";
            System.out.println(sql);
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    public void ModiTratMedic(String codtrat, String descripmedicamento, String dosis, String cantdias, String frecuencia){
         try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            String codmedicamento = busc.codMedicamento(descripmedicamento);
            String sql=""; 
            sql = "update consiste set dosis = '"+dosis+"',cantdias = '"+cantdias+"', frecuencia = '"+frecuencia+"' where codtrat = '"+codtrat+"' and codmedicamento = '"+codmedicamento+"'";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }           
    }
    
    public void guardarSintVac1(String descripsintoma, String codvacuna){
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            Buscador busc = new Buscador();
            System.out.println(descripsintoma);
            ArrayList<String> codSint = busc.CodSintoma(descripsintoma);
            for (int i = 0; i<codSint.size();i++){
                String value = "'"+codvacuna+"','"+codSint.get(i)+"'";
                String sql = "insert into presenta (idvacuna,codsintoma) values("+value+")";
                System.out.println(sql);
                st.execute(sql);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
    }
    
    //newwww
    public boolean contagio(String denom_oms, String docidentidad, JDateChooser fechacontagio, String tiemporeposo, String casahospitalizado){
        boolean validar = true;
        try {
            Date date = fechacontagio.getDate();
            long da = date.getTime();
            java.sql.Date fechaV = new java.sql.Date(da);
            String ch = "F";
            if (!casahospitalizado.equals("Casa"))
                ch = "T";
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+denom_oms+"','"+docidentidad+"','"+fechaV+"','"+tiemporeposo+"','"+ch+"'";
            String sql = "insert into contagio(denom_oms, docidentidad, fechacontagio, tiemporeposo, casahospitalizado) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
            return validar;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
            return false;
        }
    }
    
    public Boolean guardarPaciente(String cedula){
        Boolean verificar = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+cedula+"'";
            String sql = "insert into paciente(docidentidad_pac) select ('"+cedula+"') where not exists (select '"+cedula+"' from paciente where docidentidad_pac = '"+cedula+"')";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return verificar;
    }
    
    public void iteGuardarTrataPac(JTable tabla, String cedula, String fecha, String estado){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i<tabla.getRowCount();i++){
            this.requiere(cedula, modelo.getValueAt(i, 0).toString(), fecha, estado);
        }
    }
    
    public Boolean requiere(String cedula, String codigoT, String fecha, String estado){
        Boolean verificar = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+cedula+"','"+codigoT+"','"+fecha+"','"+estado+"'";
            String sql = "insert into requiere(docidentidad_pac, codtrat, fecha, estado_tratamiento) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return verificar;
    }
    
    public Boolean hospitalizado(String cedula, String codCentro, String fecha){
        Boolean verificar = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String value = "'"+cedula+"','"+codCentro+"','"+fecha+"'";
            String sql = "insert into hospitalizado(docidentidad_pac, codcentro_hos, fechahospitalizado) values("+value+")";
            st.execute(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            verificar = false;
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        }
        return verificar;
    }
    
    public Boolean ModiPacienteC(String cedula,String fecha, String datoModi, int caso){ 
        Boolean veri = true;
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String sql="";
            switch (caso){
                case 1:
                    sql = "insert into paciente(docidentidad_pac) select ('"+datoModi+"') where not exists (select '"+datoModi+"' from paciente where docidentidad_pac = '"+datoModi+"')";
                    st.executeUpdate(sql);
                    sql = "update requiere set docidentidad_pac = '"+datoModi+"' where docidentidad_pac = '"+cedula+"' and fecha = '"+fecha+"'";
                    st.executeUpdate(sql);
                    sql = "update hospitalizado set docidentidad_pac = '"+datoModi+"' where docidentidad_pac = '"+cedula+"' and fechahospitalizado = '"+fecha+"'";
                    st.executeUpdate(sql);
                    sql = "update contagio set docidentidad = '"+datoModi+"' where docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'";
                    st.executeUpdate(sql);
                break;
                case 2:
                    sql = "update contagio set denom_oms = '"+datoModi+"' where docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'";
                    st.executeUpdate(sql);
                break;
                case 3:
                    sql = "update contagio set tiemporeposo = '"+datoModi+"' where docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'";
                    st.executeUpdate(sql);
                break;
                case 4:
                    sql = "update requiere set fecha = '"+datoModi+"' where docidentidad_pac = '"+cedula+"' and fecha = '"+fecha+"'";
                    st.executeUpdate(sql);
                    sql = "update hospitalizado set fechahospitalizado = '"+datoModi+"' where docidentidad_pac = '"+cedula+"' and fechahospitalizado = '"+fecha+"'";
                    st.executeUpdate(sql);
                    sql = "update contagio set fechacontagio = '"+datoModi+"' where docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'";
                    st.executeUpdate(sql);
                break;
                case 5:
                    sql = "update hospitalizado set codcentro_hos = '"+datoModi+"' where docidentidad_pac = '"+cedula+"' and fechahospitalizado = '"+fecha+"'";
                    st.executeUpdate(sql);
                break;
                case 6:
                    sql = "update contagio set casahospitalizado = '"+datoModi+"' where docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'";
                    st.executeUpdate(sql);
                break;
            }
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
             return false;
        }     
        return veri;
    }
    
    public void cambiarEstado(String cedula, String fecha, String codtrat, String datoModi){ 
        try {
            ConexionSQL conexion= new ConexionSQL();
            Connection con = conexion.connected();
            java.sql.Statement st = con.createStatement();
            String sql="";
            sql = "update requiere set estado_tratamiento = '"+datoModi+"' where docidentidad_pac = '"+cedula+"' and fecha = '"+fecha+"' and codtrat = '"+codtrat+"'";;
            st.executeUpdate(sql);
            st.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un inconveniente con el manejo del servidor");
        } 
    }
}
