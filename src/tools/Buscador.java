
package tools;

import Clases.Estado;
import Clases.Pais;
import SQL.ConexionSQL;
import SQL.Extraer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Buscador {
    public String codPais (String nombpais){
        String cod = "";
        Extraer dataSQL = new Extraer();
        ArrayList<Pais> listPais = dataSQL.Pais();
        int i = 0;
        while((cod.equals(""))&&(i<listPais.size())){
            if (nombpais.equals(listPais.get(i).getNombpais()))
                cod = listPais.get(i).getCod_pais().toString();
            i++;
        }     
        return cod;
    }
    
    public String codEstado(String codPais, String nombEs){
        Statement st;
        String codEstado = "";
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from estado_provincia where codpais='"+codPais+"'");
            while (rs.next()) {
                if (rs.getString(2).equals(nombEs))
                    codEstado = rs.getString(1);
            }
            con.disconnect();
            return codEstado;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<String> CodEnfermedad(String EnfNom){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from enfermedad where nombenfermedad='"+EnfNom+"'");
            while(rs.next()){
                codigos.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("codEnfermedad murio");
        }
        con.disconnect();
        return codigos;
    }
    
    public void limpiarTabla(JTable tabla){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (int i = model.getRowCount()-1; i>=0;i--)
            model.removeRow(i);
    }
//-----------------------------------------Manejo de tablas-------------------------------------------
    public void tableAllpersonas(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from persona");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),veri.altoRiesgoI(rs.getString(8).toString()),rs.getString(9)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la coneccion a la base de datos");
        }
    }
    
    public void tablePersonas(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from persona where doc_identidad='"+cedula+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
    }
    
    public void tablePerRes(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select e.nombestado, r.fechareside from persona p,reside r,estado_provincia e where p.doc_identidad=r.docidentidad and r.codestado=e.codestado and doc_identidad='"+cedula+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
    }
    
    public void tablePerEnf(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select e.nombenfermedad from persona pe,padece pa,enfermedad e where pe.doc_identidad=pa.docidentidad and pa.codenfermedad=e.codenfermedad and pe.doc_identidad='"+cedula+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
    }
    
    public void tablePersonasEli(String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar personal de salud en asignado
            st = con.connected().createStatement();
            st.executeQuery("delete from asignado where docidentidad_ps='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar personal de salud en vacunada
            st = con.connected().createStatement();
            st.executeQuery("delete from vacunada where docidentidad_ps='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar paciente en vacunada
            st = con.connected().createStatement();
            st.executeQuery("delete from vacunada where docidentidad='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar paciente en hospitalizado
            st = con.connected().createStatement();
            st.executeQuery("delete from hospitalizado where docidentidad_pac='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar paciente en requiere
            st = con.connected().createStatement();
            st.executeQuery("delete from requiere where docidentidad_pac='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar personas en personal de salud
            st = con.connected().createStatement();
            st.executeQuery("delete from personal_salud where docidentidad_ps='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar personas en paciente
            st = con.connected().createStatement();
            st.executeQuery("delete from paciente where docidentidad_pac='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar persona en padece
            st = con.connected().createStatement();
            st.executeQuery("delete from padece where docidentidad='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar persona en reside
            st = con.connected().createStatement();
            st.executeQuery("delete from reside where docidentidad='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar personas
            st = con.connected().createStatement();
            st.executeQuery("delete from persona where doc_identidad='"+cedula+"'");    
        } catch (Exception e) {
        }
    }
}
