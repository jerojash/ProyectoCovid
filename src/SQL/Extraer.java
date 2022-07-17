package SQL;

import Clases.CentroSalud;
import Clases.Enfermedad;
import Clases.Estado;
import Clases.Pais;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
}
