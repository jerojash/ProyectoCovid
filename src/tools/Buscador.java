
package tools;

import Clases.CentroSalud;
import Clases.Medicamento;
import Clases.Pais;
import Clases.Tratamiento;
import Clases.Vacuna;
import SQL.ConexionSQL;
import SQL.Extraer;
import com.sun.scenario.effect.impl.sw.java.JSWPhongLighting_DISTANTPeer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.text.Text;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
    
    public String nombPais(String nombEstado){
        Statement st;
        String nombPais = "";
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select p.nombpais\n" +
                                                                    "from pais p\n" +
                                                                    "join estado_provincia e\n" +
                                                                    "on p.cod_pais = e.codpais\n" +
                                                                    "where nombestado like '"+nombEstado+"'");
            
            while (rs.next())  nombPais = rs.getString(1);
            
            con.disconnect();
            return nombPais;
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
            con.disconnect();
            return codigos;
        } catch (Exception e) {
            System.out.println("codEnfermedad murio");
        }
        con.disconnect();
        return null;
    }
    
    public ArrayList<String> CodSintoma(String descripsintoma){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from sintoma_efecto where descripsintoma='"+descripsintoma+"'");
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

    public ArrayList<String> CodPac(){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from paciente");
            while(rs.next()){
                codigos.add(rs.getString(1));
            }
            con.disconnect();
            return codigos;
        } catch (Exception e) {
            System.out.println("CodPac murio");
        }  
        return null;
    }
    
    public ArrayList<String> denom_oms(){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from virus_variante");
            while(rs.next()){
                codigos.add(rs.getString(1));
            }
            con.disconnect();
            return codigos;
        } catch (Exception e) {
            System.out.println("denom_oms murio");
        }  
        return null;
    }
//-----------------------------------------Manejo de tablas-------------------------------------------
    public void limpiarTabla(JTable tabla){
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        for (int i = model.getRowCount()-1; i>=0;i--)
            model.removeRow(i);
    }
   
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
    
    public void tableAllCentrosSalud(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from centro_salud");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),veri.TipoCentro(rs.getString(1))});
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
    

    public void tableVarSint(JTable tabla, String denom_oms){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
           // ResultSet rs = st.executeQuery("select e.nombenfermedad from persona pe,padece pa,enfermedad e   where pe.doc_identidad=pa.docidentidad and pa.codenfermedad=e.codenfermedad and pe.doc_identidad='"+cedula+"'");
            ResultSet rs = st.executeQuery("select s.descripsintoma from virus_variante va,tiene ti,sintoma_efecto s where va.denom_oms=ti.denom_oms and ti.codsintoma=s.codsintoma and va.denom_oms='"+denom_oms+"'");
           
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay variantes con la denominacion ingresada");
        }
    }       
                
    public void tablePerEnfeEliIte(String cedula, JTable tabla){
        Buscador busc = new Buscador();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        ArrayList<String> codEnf = busc.CodEnfermedad(model.getValueAt(tabla.getSelectedRow(), 0).toString());
        for (int i = 0; i<codEnf.size();i++){
            this.tablePerEnfeEli(cedula, codEnf.get(i));
        }
    }
    
    public void tablePerEnfeEli(String cedula, String codEnfe){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            String sql = "delete from padece where docidentidad='"+cedula+"' and codenfermedad='"+codEnfe+"'";
            st.execute(sql);
        } catch (Exception e) {
        }
    }
    
    public void tablePSCenEli(String cedula, JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        try {
            st = con.connected().createStatement();
            String sql = "delete from asignado where docidentidad_ps='"+cedula+"' and codcentro='"+model.getValueAt(tabla.getSelectedRow(), 0).toString()+"' and fechaasignado = '"+model.getValueAt(tabla.getSelectedRow(), 1).toString()+"'";
            st.execute(sql);
        }catch (Exception e) {
            
        }
    }
    
    public void tablePersonasEli(String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar persona en vacunda
            st = con.connected().createStatement();
            st.executeQuery("delete from vacunada where docidentidad='"+cedula+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar persona en contagio
            st = con.connected().createStatement();
            st.executeQuery("delete from contagio where docidentidad='"+cedula+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar persona en padece
            st = con.connected().createStatement();
            st.executeQuery("delete from padece where docidentidad='"+cedula+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar persona en reside
            st = con.connected().createStatement();
            st.executeQuery("delete from reside where docidentidad='"+cedula+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar personas
            st = con.connected().createStatement();
            st.executeQuery("delete from persona where doc_identidad='"+cedula+"'");    
            st.close();
        } catch (Exception e) {
        }
    }
    
    public void eliminarCentro(String codcentro){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar persona en asignado
            st = con.connected().createStatement();
            st.executeQuery("DELETE FROM asignado WHERE codcentro = '"+codcentro+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar persona en vacunada
            st = con.connected().createStatement();
            st.executeQuery("DELETE FROM vacunada WHERE codcentro_vac = '"+codcentro+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar persona en vacunacion
            st = con.connected().createStatement();
            st.executeQuery("DELETE FROM vacunacion WHERE codcentro_vac = '"+codcentro+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar persona en hospitalizado
            st = con.connected().createStatement();
            st.executeQuery("DELETE FROM hospitalizado WHERE codcentro_hos = '"+codcentro+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar hospitalizacion
            st = con.connected().createStatement();
            st.executeQuery("DELETE FROM hospitalizacion WHERE codcentro_hos = '"+codcentro+"'");    
            st.close();
        } catch (Exception e) {
        }
         try {//borrar persona en centro_salud
            st = con.connected().createStatement();
            st.executeQuery("DELETE FROM centro_salud where codcentro = '"+codcentro+"'");
            st.close();
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Ocurrio un ERROR","Aviso",INFORMATION_MESSAGE);
  
        }
    }
    
    public void tableAllvariantes(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri;
        veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from virus_variante");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la conexion a la base de datos");
        }
    }
    
    public void tableVariantes(JTable tabla, String denom_oms){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from virus_variante where denom_oms='"+denom_oms+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay variantes con la denominacion ingresada");
        }
    }
    
    public void tableVarianteEli(String denom_oms){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from tiene where denom_oms='"+denom_oms+"'");
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from eficaz where denom_oms='"+denom_oms+"'");
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from contagio where denom_oms='"+denom_oms+"'");
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from virus_variante where denom_oms='"+denom_oms+"'");    
        } catch (Exception e) {
        }
    }
    
    public void tableVarSintEli(String denom_oms, String codSint){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            String sql = "delete from tiene where denom_oms='"+denom_oms+"' and codsintoma='"+codSint+"'";
            st.execute(sql);
        } catch (Exception e) {
        }
    }
    
    public void tableVarSintEliIte(String denom_oms, JTable tabla){
        Buscador busc = new Buscador();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        ArrayList<String> codSint = busc.CodSintoma(model.getValueAt(tabla.getSelectedRow(), 0).toString());
        for (int i = 0; i<codSint.size();i++){
            this.tableVarSintEli(denom_oms, codSint.get(i));
        }
    }
    
    //yerlin
    public void tablePersonalSalud(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            Verificador validar = new Verificador();
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from personal_salud where docidentidad_ps='"+cedula+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),validar.validarTipoPersonal(rs.getString(3),rs.getString(4))});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personal de salud con la cedula ingresada");
        }
    }
    public void tableAllPersonalSalud(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from personal_salud");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),veri.validarTipoPersonal(rs.getString(3),rs.getString(4))});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la coneccion a la base de datos");
        }
    }
    
    public void tableCentroPersonal(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select c.nombcentro, a.fechaasignado from asignado a, centro_salud c where a.codcentro = c.codcentro and a.docidentidad_ps ='"+cedula+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personal de salud con la cedula ingresada");
        }
    }
    
    public void tableCodCentroPersonal(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select c.codcentro, a.fechaasignado from asignado a, centro_salud c where a.codcentro = c.codcentro and a.docidentidad_ps ='"+cedula+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personal de salud con la cedula ingresada");
        }
    }
    
    public ArrayList<String> codPersonalVacunador(){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacunada");
            while(rs.next()){
                codigos.add(rs.getString(4));
            }
            con.disconnect();
            return codigos;
        } catch (Exception e) {
        }  
        return null;
    }
    
    public ArrayList<String> codPersonalEncargado(){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from centro_salud");
            while(rs.next()){
                codigos.add(rs.getString(4));
            }
            con.disconnect();
            return codigos;
        } catch (Exception e) {
        }  
        return null;
    }
    public void tablePersonalEli(String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar personal en asignado
            st = con.connected().createStatement();
            st.executeQuery("delete from asignado where docidentidad_ps='"+cedula+"'");
        } catch (Exception e) {
        }
        try {//borrar personal salud
            st = con.connected().createStatement();
            st.executeQuery("delete from personal_salud where docidentidad_ps='"+cedula+"'");    
        } catch (Exception e) {
        }
    }
    public void tableMedicoEli(String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar medico
            st = con.connected().createStatement();
            st.executeQuery("delete from medico where docidentidad_med='"+cedula+"'");
        } catch (Exception e) {
        }
    }
    
    public String codCentro (String nombcentro){
        String cod = "";
        Extraer dataSQL = new Extraer();
        ArrayList<CentroSalud> listCentro = dataSQL.CentroSalud();
        int i = 0;
        while((cod.equals(""))&&(i<listCentro.size())){
            if (nombcentro.equals(listCentro.get(i).getNombreCentro()))
                cod = listCentro.get(i).getCodCentro().toString();
            i++;
        }     
        return cod;
    }
    
    public String codVacuna (String nombvacuna){
        String cod = "";
        Extraer dataSQL = new Extraer();
        ArrayList<Vacuna> listVacuna = dataSQL.Vacuna();
        int i = 0;
        while((cod.equals(""))&&(i<listVacuna.size())){
            if (nombvacuna.equals(listVacuna.get(i).getNombvacuna()))
                cod = listVacuna.get(i).getIdvacuna().toString();
            i++;
        }     
        return cod;
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
    //nuevo nuevo
    public void tableAllPersonaVacunada(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacunada");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la coneccion a la base de datos");
        }
    }  
    
    public void tablePersonaVacunada(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacunada where docidentidad='"+cedula+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay persona vacunada con esa cédula");
        }
    }  
    
    public ArrayList<String> arrayDosis(String cedula, String vacuna){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        ArrayList<String> cadena = new ArrayList<String>();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacunada where docidentidad='"+cedula+"' and idvacuna = '"+vacuna+"'");
            while(rs.next()){
                cadena.add(rs.getString(6));
            }
            return cadena;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay persona vacunada con esa cédula");
            return cadena;
        }
    }   
    
    public void tablePersonaVacunadaEli(String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar persona vacunada
            st = con.connected().createStatement();
            st.executeQuery("delete from vacunada where docidentidad='"+cedula+"'");
        } catch (Exception e) {
        }
    }
    public void tableAllvacunas(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri;
        veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacuna");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la conexion a la base de datos");
        }
    }
    
    public void tableAllMedicamentos(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri;
        veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from medicamento");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la conexion a la base de datos");
        }
    }
    
     public void tableVacunas(JTable tabla, String idvacuna){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacuna where idvacuna='"+idvacuna+"'");
            
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay vacunas con el id ingresado");
        }
    }
    
    public void tableVacunaEli(String idvacuna){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from presenta where idvacuna='"+idvacuna+"'");
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from eficaz where idvacuna='"+idvacuna+"'");
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from vacunada where idvacuna='"+idvacuna+"'");
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from vacuna where idvacuna='"+idvacuna+"'");    
        } catch (Exception e) {
        }
    }
    
    public void tableMedicamentoEli(String codmedicamento){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from consiste where codmedicamento='"+codmedicamento+"'");
        } catch (Exception e) {
            
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from medicamento where codmedicamento='"+codmedicamento+"'");
        } catch (Exception e) {
            
        }
    }
    
    public void tableVacSintEli(String idvacuna, String codSint){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            String sql = "delete from presenta where idvacuna='"+idvacuna+"' and codsintoma='"+codSint+"'";
           System.out.println("delete from presenta where idvacuna='"+idvacuna+"' and codsintoma='"+codSint+"'");
            st.execute(sql);
        } catch (Exception e) {
        }
    }
    
    public void tableVacEfecEliIte(String idvacuna, JTable tabla){
        Buscador busc = new Buscador();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        ArrayList<String> codSint = busc.CodSintoma(model.getValueAt(tabla.getSelectedRow(), 0).toString());
        for (int i = 0; i<codSint.size();i++){
            this.tableVacSintEli(idvacuna, codSint.get(i));
        }
    }
    
    public void tableVacEfic(JTable tabla, String idvacuna){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
           // ResultSet rs = st.executeQuery("select e.nombenfermedad from persona pe,padece pa,enfermedad e   where pe.doc_identidad=pa.docidentidad and pa.codenfermedad=e.codenfermedad and pe.doc_identidad='"+cedula+"'");
           // ResultSet rs = st.executeQuery("select s.descripsintoma from virus_variante va,tiene ti,sintoma_efecto s where va.denom_oms=ti.denom_oms and ti.codsintoma=s.codsintoma and va.denom_oms='"+denom_oms+"'");
            ResultSet rs = st.executeQuery("select e.denom_oms, e.porceficacia from vacuna va,eficaz e,virus_variante vv where va.idvacuna=e.idvacuna and e.denom_oms=vv.denom_oms and va.idvacuna='"+idvacuna+"'");
           System.out.println("select e.denom_oms, e.porceficacia from vacuna va,eficaz e,virus_variante vv where va.idvacuna=e.idvacuna and e.denom_oms=vv.denom_oms and va.idvacuna='"+idvacuna+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay variantes con la denominacion ingresada");
        }
        
    }
    
    public void tableVacEfec(JTable tabla, String idvacuna){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();

            ResultSet rs = st.executeQuery("select s.descripsintoma from vacuna va,presenta pr,sintoma_efecto s where va.idvacuna=pr.idvacuna and pr.codsintoma=s.codsintoma and va.idvacuna='"+idvacuna+"'");

            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay variantes con la denominacion ingresada");
        }
    }
    
    public void tableVacEfiEliIte(String idvacuna, JTable tabla){
        Buscador busc = new Buscador();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
       // ArrayList<String> codSint = busc.CodSintoma(model.getValueAt(tabla.getSelectedRow(), 0).toString());
        //for (int i = 0; i<codSint.size();i++){
            this.tableVacEfiEli(idvacuna, model.getValueAt(tabla.getSelectedRow(), 0).toString());
        //}
    }
    
    public void tableVacEfiEli(String idvacuna, String denom_oms){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            String sql = "delete from eficaz where idvacuna='"+idvacuna+"' and denom_oms='"+denom_oms+"'";
            st.execute(sql);
        } catch (Exception e) {
        }
    }
    
    public String codMedicamento (String nombmedicamento){
        String cod = "";
        Extraer dataSQL = new Extraer();
        ArrayList<Medicamento> listMedicamento = dataSQL.Medicamento();
        int i = 0;
        while((cod.equals(""))&&(i<listMedicamento.size())){
            if (nombmedicamento.equals(listMedicamento.get(i).getnombremedicamento()))
                cod = listMedicamento.get(i).getcod_medicamento().toString();
            i++;
        }     
        return cod;
    }
    
    public String codTratamiento(String nombtratamiento){
        String cod = "";
        Extraer dataSQL = new Extraer();
        ArrayList<Tratamiento> listTratamiento = dataSQL.Tratamiento();
        int i = 0;
        while((cod.equals(""))&&(i<listTratamiento.size())){
           if (nombtratamiento.equals(listTratamiento.get(i).getnombretratamiento()))
                cod = listTratamiento.get(i).getcod_tratamiento().toString();
            i++;
        }     
        return cod;
    }
    
    public void tableTratamientos(JTable tabla, String codtratamiento){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from tratamiento where codtrat='"+codtratamiento+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay tratamientos con el codigo ingresado");
        }
    }
    
    public void tableAlltratamientos(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        Verificador veri = new Verificador();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from tratamiento");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la coneccion a la base de datos");
        }
    }
    public void tableTratMedic(JTable tabla, String codtratamiento){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select medic.nombremedicamento, co.dosis, co.cantdias,co.frecuencia from tratamiento tr,consiste co,medicamento medic where tr.codtrat=co.codtrat and co.codmedicamento=medic.codmedicamento and tr.codtrat='"+codtratamiento+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
    }
    
    public void tableTratamientoEli(String codtrat){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar tratameinto de consiste
            st = con.connected().createStatement();
            st.executeQuery("delete from consiste where codtrat='"+codtrat+"'");
            st.close();
        } catch (Exception e) {
        }
        try {//borrar tratamiento
            st = con.connected().createStatement();
            st.executeQuery("delete from tratamiento where codtrat='"+codtrat+"'");
            st.close();
        } catch (Exception e) {
        }
    }
    
    public void tableTratMedicEliIte(String codtrat, JTable tabla){
        Buscador busc = new Buscador();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        ArrayList<String> codMed = busc.CodMedicamento(model.getValueAt(tabla.getSelectedRow(), 0).toString());
        for (int i = 0; i<codMed.size();i++){
            this.tableTratMedicEli(codtrat, codMed.get(i));
        }
    }
    
        public ArrayList<String> CodMedicamento(String nombremedicamento){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st; System.out.println(nombremedicamento);
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from medicamento where nombremedicamento='"+nombremedicamento+"'");
            while(rs.next()){
                codigos.add(rs.getString(1));
            }
            con.disconnect();
            return codigos;
        } catch (Exception e) {
            System.out.println("codMedicamento murio");
        }
        con.disconnect();
        return null;
    }
    public void tableTratMedicEli(String codtrat, String codmedicamento){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            String sql = "delete from consiste where codtrat='"+codtrat+"' and codmedicamento='"+codmedicamento+"'";
            st.execute(sql);
        } catch (Exception e) {
        }
    }
    //newwwww
    public void tableAllPersonaContagiada(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            String tipo = "";
            ResultSet rs = st.executeQuery("select * from contagio");
            while(rs.next()){
                if(rs.getString(5).equals("t"))
                    tipo = "Hospitalizado"; 
                else
                    tipo = "En casa"; 
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)+" días",tipo});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la coneccion a la base de datos");
        }
    }  
    
    public void tableTratamientoPersonaC(JTable tabla, String cedula, String fecha){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select r.codtrat, t.descriptratamiento, r.estado_tratamiento from tratamiento t, requiere r where r.codtrat = t.codtrat and r.docidentidad_pac = '"+cedula+"' and fecha = '"+fecha+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
    }
    
    public void tableHospitalPersonaC(String cedula, JTable tabla, String fecha){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select h.codcentro_hos, c.nombcentro from centro_salud as c, hospitalizado as h where  h.codcentro_hos = c.codcentro and h.docidentidad_pac = '"+cedula+"' and h.fechahospitalizado = '"+fecha+"'");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
    }
    
    public ArrayList<String> DescripTrataPac(String codigo){
        ArrayList<String> codigos = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select descriptratamiento from tratamiento where codtrat='"+codigo+"'");
            while(rs.next()){
                codigos.add(rs.getString(1));
            }
            con.disconnect();
            return codigos;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error con la coneccion a la base de datos");
        }
        con.disconnect();
        return null;
    }
    
    public void EliminarPacienteContagio(String cedula, String fecha){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from requiere where docidentidad_pac='"+cedula+"' and fecha='"+fecha+"'");
            st.close();
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from hospitalizado where docidentidad_pac='"+cedula+"' and fechahospitalizado='"+fecha+"'");
            st.close();
        } catch (Exception e) {
        }
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from contagio where docidentidad='"+cedula+"' and fechacontagio='"+fecha+"'");
            st.close();
        } catch (Exception e) {
        }
    }
    
    public void EliminarPaciente(String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {//borrar persona vacunada
            st = con.connected().createStatement();
            st.executeQuery("delete from paciente where docidentidad_pac = '"+cedula+"' and not exists (select docidentidad from contagio where docidentidad = '"+cedula+"')");
        } catch (Exception e) {
        }
    }
    
    public void tablePersonaContagiadaxCedula(JTable tabla, String cedula){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            String tipo = "";
            ResultSet rs = st.executeQuery("select * from contagio where docidentidad='"+cedula+"'");
            while(rs.next()){
                if(rs.getString(5).equals("t"))
                    tipo = "Hospitalizado"; 
                else
                    tipo = "En casa"; 
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)+" días",tipo});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
    }
    
    public String personaCodHospital(String cedula, String fecha){
        ArrayList<String> nuevo = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select c.nombcentro from centro_salud as c, hospitalizado as h where  h.codcentro_hos = c.codcentro and h.docidentidad_pac = '"+cedula+"' and h.fechahospitalizado = '"+fecha+"'");
            while(rs.next()){
                nuevo.add(rs.getString(1));
            }  
            return nuevo.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
        }
        return "";
    }
    
    public String tipoPersonaFecha(String cedula, String fecha){
        ArrayList<String> nuevo = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select casahospitalizado from contagio where  docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'");
            while(rs.next()){
                nuevo.add(rs.getString(1));
            }  
            con.disconnect();
            return nuevo.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
            return "";
        }
    }
    
    public void EliminarHospitales(String cedula, String fecha){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from hospitalizado where docidentidad_pac='"+cedula+"' and fechahospitalizado='"+fecha+"'");
            st.close();
        } catch (Exception e) {
        }
    }
    
    public void trataPacEli(String cedula, String fecha, String cod){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            st.executeQuery("delete from requiere where docidentidad_pac='"+cedula+"' and fecha='"+fecha+"' and codtrat='"+cod+"'");
            st.close();
            con.disconnect();
        } catch (Exception e) {
        }
    }
    
    public String variantePacCedula(String cedula, String fecha){
        ArrayList<String> nuevo = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select denom_oms from contagio where  docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'");
            while(rs.next()){
                nuevo.add(rs.getString(1));
            }  
            con.disconnect();
            return nuevo.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
            return "";
        }
    }
    
    public String tiempoPacCedula(String cedula, String fecha){
        ArrayList<String> nuevo = new ArrayList<String>();
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select tiemporeposo from contagio where  docidentidad = '"+cedula+"' and fechacontagio = '"+fecha+"'");
            while(rs.next()){
                nuevo.add(rs.getString(1));
            }  
            con.disconnect();
            return nuevo.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay personas con la cedula ingresada");
            return "";
        }
    }
  }
 
