/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;
import Clases.Variante;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo Fanghella
 */
public class Reporte {
        
    public String [] Reporte_8_1(String variante){
            Statement st;
            String [] datos = new String[2];
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                  ResultSet rs = st.executeQuery("select v.nombvacuna,max(e.porceficacia),e.denom_oms \n" +
                                                                        "    from eficaz e, vacuna v\n" +
                                                                        "    where e.denom_oms like '"+variante+"' and e.idvacuna = v.idvacuna\n" +
                                                                        "    group by e.denom_oms,v.nombvacuna");
                while (rs.next()) {
                       datos[0]=rs.getString(1);
                       datos[1]=String.valueOf(rs.getString(2));
                }
                st.close();
                con.disconnect();
                return datos;
            } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<String> Reporte_8_2(String variante){
            Statement st;
            ArrayList<String> datos = new ArrayList<String>();
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                  ResultSet rs = st.executeQuery("  select s.descripsintoma\n" +
                                                                        "    from tiene t\n" +
                                                                        "    join sintoma_efecto s\n" +
                                                                        "    on t.codsintoma = s.codsintoma" +
                                                                        "    where t.denom_oms like '"+variante+"'");
                while (rs.next()) {
                       datos.add(rs.getString(1));
                }
                st.close();
                con.disconnect();
                return datos;
            } catch (Exception e) {
            return null;
            }
     }
    
    public ResultSet reporte_7(){
             Statement st;
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                  ResultSet rs = st.executeQuery("select c.nombcentro, h.codcentro_hos, v.codcentro_vac, count(h.docidentidad_pac), count(distinct(v.docidentidad))\n" +
                                                                        "from centro_salud c\n" +
                                                                        "left join hospitalizado h\n" +
                                                                        "on h.codcentro_hos = c.codcentro\n" +
                                                                        "left join vacunada v\n" +
                                                                        "on v.codcentro_vac = c.codcentro\n" +
                                                                        "group by c.nombcentro,h.codcentro_hos, v.codcentro_vac");
                
                con.disconnect();
                return rs;
            } catch (Exception e) {
            return null;
            }
    }
    
    public ResultSet crudCentroSalud(){
         Statement st;
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                  ResultSet rs = st.executeQuery("select c.codcentro, c.nombcentro, c.direccion, c.docidentidad_encargado,\n" +
                                                                        "c.fechaencargado, e.nombestado\n" +
                                                                        "from centro_salud c\n" +
                                                                        "join  (Select nombcentro, Max(fechaencargado) fecha\n" +
                                                                        "      from centro_salud\n" +
                                                                        "      group by nombcentro) t\n" +
                                                                        "on t.nombcentro = c.nombcentro and t.fecha = c.fechaencargado\n" +
                                                                        "join estado_provincia e\n" +
                                                                        "on e.codestado = c.codestado");
                
                con.disconnect();
                return rs;
            } catch (Exception e) {
            return null;
            }
    }
    
    public ArrayList<String> centrosVacunacion(){
            Statement st;
            ArrayList<String> datos = new ArrayList<String>();
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                  ResultSet rs = st.executeQuery("select c.nombcentro\n" +
                                                                        "from centro_salud c\n" +
                                                                        "join vacunacion h\n" +
                                                                        "on h.codcentro_vac = c.codcentro");
                while (rs.next()) {
                       datos.add(rs.getString(1));
                }
                st.close();
                con.disconnect();
                return datos;
            } catch (Exception e) {
            return null;
            }
     }
    
    public ArrayList<String> centrosHospitalizacion(){
            Statement st;
            ArrayList<String> datos = new ArrayList<String>();
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                  ResultSet rs = st.executeQuery("select c.nombcentro\n" +
                                                                        "from centro_salud c\n" +
                                                                        "join hospitalizacion h\n" +
                                                                        "on h.codcentro_hos = c.codcentro");
                while (rs.next()) {
                       datos.add(rs.getString(1));
                }
                st.close();
                con.disconnect();
                return datos;
            } catch (Exception e) {
            return null;
            }
     }
    
}


