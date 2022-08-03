package SQL;

import Clases.CentroSalud;
import Clases.Enfermedad;
import Clases.Sintomas;
import Clases.Estado;
import Clases.Pais;
import Clases.Vacuna;
import Clases.Medicamento;
import Clases.Tratamiento;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import Clases.Variante;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Extraer {
    public ArrayList<Enfermedad> Enfermedad() {
        Statement st;
        ArrayList<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from enfermedad");
            while (rs.next()) {
                enfermedades.add(new Enfermedad(rs.getInt(1), rs.getString(2)));
            }
            st.close();
            con.disconnect();
            return enfermedades;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }

    public ArrayList<String> nombEnfermedad(ArrayList<Enfermedad> listEnfermedades) {
        ArrayList<String> nombEnfermedades = new ArrayList<String>();

        for (int i = 0; i < listEnfermedades.size(); i++) {
            nombEnfermedades.add(listEnfermedades.get(i).getNombenfermedad());
        }
        return nombEnfermedades;
    }
    
    public ArrayList<Pais> Pais() {
        Statement st;
        ArrayList<Pais> Paises = new ArrayList<Pais>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from pais");
            while (rs.next()) {
                Paises.add(new Pais(rs.getInt(1), rs.getString(2)));
            }
            st.close();
            con.disconnect();
            return Paises;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }

    public ArrayList<String> nombPais(ArrayList<Pais> listPaises) {
        ArrayList<String> nombPaises = new ArrayList<String>();

        for (int i = 0; i < listPaises.size(); i++) {
            nombPaises.add(listPaises.get(i).getNombpais());
        }
        return nombPaises;
    }
    
    public ArrayList<String> medicoEncargado() {
        Statement st;
        ArrayList<String> medico = new ArrayList<String>();
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from medico");
            while (rs.next()) {
                medico.add(rs.getString(1));
            }
            st.close();
            con.disconnect();
            return medico;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<Estado> Estado(String codPais) {
        Statement st;
        ArrayList<Estado> Estados = new ArrayList<Estado>();
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from estado_provincia where codpais='"+codPais+"'");
            while (rs.next()) {
                Estados.add(new Estado(rs.getInt(1), rs.getString(2)));
            }
            st.close();
            con.disconnect();
            return Estados;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }

    public ArrayList<String> nombEstado(ArrayList<Estado> listEstados) {
        ArrayList<String> nombEstado = new ArrayList<String>();
        for (int i = 0; i < listEstados.size(); i++) {
            nombEstado.add(listEstados.get(i).getNombestado());
        }
        return nombEstado;
    }
    
    public ArrayList<CentroSalud> CentroSalud() {
        Statement st;
        ArrayList<CentroSalud> Centro = new ArrayList<CentroSalud>();
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from centro_salud");
            while (rs.next()) {
                Centro.add(new CentroSalud(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toString(), rs.getInt(6)));
            }
            st.close();
            con.disconnect();
            return Centro;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<String> codCentro(ArrayList<CentroSalud> listCentro) {
        ArrayList<String> codCentro = new ArrayList<String>();
        for (int i = 0; i < listCentro.size(); i++) {
            codCentro.add(listCentro.get(i).getCodCentro().toString());
        }
        return codCentro;
    }
    
    public ArrayList<String> codVariante(ArrayList<CentroSalud> listCentro) {
        ArrayList<String> codCentro = new ArrayList<String>();
        for (int i = 0; i < listCentro.size(); i++) {
            codCentro.add(listCentro.get(i).getCodCentro().toString());
        }
        return codCentro;
    }
    
    public ArrayList<Variante> variante(){
        Statement st;
        ArrayList<Variante> Variante = new ArrayList<Variante>();
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from virus_variante");
            while (rs.next()) {
                Variante.add(new Variante(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5)));
            }
            st.close();
            con.disconnect();
            return Variante;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    

    public ArrayList<Sintomas> Sintomas() {
        Statement st;
        ArrayList<Sintomas> sintomas = new ArrayList<Sintomas>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from sintoma_efecto");
            while (rs.next()) {
               sintomas.add(new Sintomas(rs.getInt(1), rs.getString(2)));
            }
            st.close();
            con.disconnect();
            return sintomas;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<String> descripsintoma(ArrayList<Sintomas> listSintomas) {
        ArrayList<String> descripsintoma = new ArrayList<String>();

        for (int i = 0; i < listSintomas.size(); i++) {
            descripsintoma.add(listSintomas.get(i).getdescripsintoma());
        }
        return descripsintoma;
    }
    

    public ArrayList<String> denom_oms(ArrayList<Variante> listVirus) {
        ArrayList<String> nombreVariante = new ArrayList<String>();
        for (int i = 0; i < listVirus.size(); i++) {
            nombreVariante.add(listVirus.get(i).getDenom_oms().toString());
        }
        return nombreVariante;
    }

    
    public void Reporte2(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from reporte_2");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay data suficiente para mostrar el reporte");
        }
    }

    public void Reporte3(JTable tabla){
        Statement st;
        ConexionSQL con = new ConexionSQL();
        try {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from reporte_3");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1),rs.getString(2)});
            }          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay data suficiente para mostrar el reporte");
        }
    }
    
    //yerlin
    public ArrayList<Vacuna> Vacuna() {
        Statement st;
        ArrayList<Vacuna> Vacunas = new ArrayList<Vacuna>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from vacuna");
            while (rs.next()) {
                Vacunas.add(new Vacuna(rs.getInt(1), rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getString(5), rs.getString(6),rs.getInt(7)));
            }
            st.close();
            con.disconnect();
            return Vacunas;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<String> nombVacuna(ArrayList<Vacuna> listVacunas) {
        ArrayList<String> nombVacunas = new ArrayList<String>();
        for (int i = 0; i < listVacunas.size(); i++) {
            nombVacunas.add(listVacunas.get(i).getNombvacuna());
        }
        return nombVacunas;
    }
    
    public ArrayList<String> nombCentro(ArrayList<CentroSalud> listCentros) {
        ArrayList<String> nombCentros = new ArrayList<String>();
        for (int i = 0; i < listCentros.size(); i++) {
            nombCentros.add(listCentros.get(i).getNombreCentro());
        }
        return nombCentros;
    }
    
    public ArrayList<String> codPersonalSalud() {
        Statement st;
        ArrayList<String> personal = new ArrayList<String>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from personal_salud");
            while (rs.next()) {
                personal.add(rs.getString(1));
            }
            st.close();
            con.disconnect();
            return personal;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<String> PersonalSalud(String codCentro) {
        Statement st;
        ArrayList<String> personal = new ArrayList<String>();
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select distinct docidentidad_ps from asignado where codcentro ='"+codCentro+"'");
            while (rs.next()) {                   
                personal.add(rs.getString(1));
            }
            st.close();
            con.disconnect();
            return personal;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    public ArrayList<CentroSalud> CentroSaludVac() {
        Statement st;
        ArrayList<CentroSalud> Centro = new ArrayList<CentroSalud>();
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select c.* from centro_salud c, vacunacion v where c.codcentro = v.codcentro_vac");
            while (rs.next()) {
                Centro.add(new CentroSalud(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toString(), rs.getInt(6)));
            }
            st.close();
            con.disconnect();
            return Centro;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    public ArrayList<Medicamento> Medicamento() {
        Statement st;
        ArrayList<Medicamento> Medicamentos = new ArrayList<Medicamento>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from medicamento");
            while (rs.next()) {
                Medicamentos.add(new Medicamento(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getDouble(4)));
            }
            st.close();
            con.disconnect();
            return Medicamentos;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<String> nombMedicamento(ArrayList<Medicamento> listMedicamentos) {
        ArrayList<String> nombMedicamentos = new ArrayList<String>();

        for (int i = 0; i < listMedicamentos.size(); i++) {
            nombMedicamentos.add(listMedicamentos.get(i).getnombremedicamento());
        }
        return nombMedicamentos;
    }

    public ArrayList<Tratamiento> Tratamiento() {
        Statement st;
        ArrayList<Tratamiento> Tratamientos = new ArrayList<Tratamiento>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from tratamiento");
            while (rs.next()) {
                Tratamientos.add(new Tratamiento(rs.getInt(1), rs.getString(2)));
            }
            st.close();
            con.disconnect();
            return Tratamientos;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    //newwwww
    public ArrayList<String> codigoTratamientos(ArrayList<Tratamiento> listTratamiento) {
        ArrayList<String> codTratamiento = new ArrayList<String>();

        for (int i = 0; i < listTratamiento.size(); i++) {
            codTratamiento.add(listTratamiento.get(i).getcod_tratamiento().toString());
        }
        return codTratamiento;
    }
    
    public ArrayList<Tratamiento> TratamientoPaciente() {
        Statement st;
        ArrayList<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
        ConexionSQL con = new ConexionSQL();

        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select * from tratamiento");
            while (rs.next()) {
                tratamientos.add(new Tratamiento(rs.getInt(1), rs.getString(2)));
            }
            st.close();
            con.disconnect();
            return tratamientos;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
    
    public ArrayList<CentroSalud> CentroSaludHos() {
        Statement st;
        ArrayList<CentroSalud> Centro = new ArrayList<CentroSalud>();
        ConexionSQL con = new ConexionSQL();
        try {
            st = con.connected().createStatement();
            ResultSet rs = st.executeQuery("select c.* from centro_salud c, hospitalizacion v where c.codcentro = v.codcentro_hos");
            while (rs.next()) {
                Centro.add(new CentroSalud(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getDate(5).toString(), rs.getInt(6)));
            }
            st.close();
            con.disconnect();
            return Centro;
        } catch (Exception e) {
            con.disconnect();
            return null;
        }
    }
}


   
