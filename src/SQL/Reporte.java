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
                  ResultSet rs = st.executeQuery("select v.nombvacuna,max(e.porceficacia) eficacia,e.denom_oms \n" +
                                                                        "    from eficaz e, vacuna v\n" +
                                                                        "    where e.denom_oms like '"+variante+"' and e.idvacuna = v.idvacuna\n" +
                                                                        "    group by e.denom_oms,v.nombvacuna\n" +
                                                                        "order by eficacia desc\n" +
                                                                        "limit 1");
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
    
    public int Reporte_1_1(String estado){
            Statement st;
            int cantidad = 0;
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                  ResultSet rs = st.executeQuery("select e.nombestado, count(r.docidentidad) contagiados\n" +
                                                                        "from reside r\n" +
                                                                        "join (\n" +
                                                                        "    select docidentidad \n" +
                                                                        "    from contagio\n" +
                                                                        "    group by docidentidad\n" +
                                                                        "    having count(docidentidad)>1 )c\n" +
                                                                        "on c.docidentidad = r.docidentidad\n" +
                                                                        "join estado_provincia e\n" +
                                                                        "on e.codestado = r.codestado\n" +
                                                                        "where e.nombestado like '"+estado+"'\n" +
                                                                        "group by e.nombestado");
                while (rs.next()) {
                       cantidad=Integer.parseInt(rs.getString(2));
                       
                }
                st.close();
                con.disconnect();
                return cantidad;
            } catch (Exception e) {
            return cantidad;
        }
    }
    
    public ArrayList<String> Reporte_1_2(String estado){
            Statement st;
            ArrayList<String> datos = new ArrayList<String>();
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
                 ResultSet rs = st.executeQuery("select distinct(p.doc_identidad), CONCAT (p.nombper,' ', p.apellidoper) nombre, c.casahospitalizado hospitalizado\n" +
                                                                        "from persona p\n" +
                                                                        "join contagio c\n" +
                                                                        "on p.doc_identidad = c.docidentidad\n" +
                                                                        "join reside r\n" +
                                                                        "on r.docidentidad = p.doc_identidad\n" +
                                                                        "join estado_provincia e\n" +
                                                                        "on e.codestado = r.codestado\n" +
                                                                        "join (\n" +
                                                                        "    select docidentidad \n" +
                                                                        "    from contagio\n" +
                                                                        "    group by docidentidad\n" +
                                                                        "    having count(docidentidad)>1 )d\n" +
                                                                        "on d.docidentidad = r.docidentidad\n" +
                                                                        "where e.nombestado like '"+estado+"' order by nombre desc");
                while (rs.next()) {
                       datos.add(rs.getString(1));
                       datos.add(rs.getString(2));
                       datos.add(rs.getString(3));
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
                  ResultSet rs = st.executeQuery("select c.nombcentro, cvh.codcentro_hos, cvh.codcentro_vac, count(h.docidentidad_pac), count(distinct(v.docidentidad))\n" +
                                                                        "from centro_salud c\n" +
                                                                        "left join hospitalizado h\n" +
                                                                        "on h.codcentro_hos = c.codcentro\n" +
                                                                        "left join vacunada v\n" +
                                                                        "on v.codcentro_vac = c.codcentro\n" +
                                                                        "join (select c.nombcentro, h.codcentro_hos, v.codcentro_vac\n"+
                                                                        "from centro_salud c\n"+
                                                                        "left join vacunacion v\n"+
                                                        		"on v.codcentro_vac = c.codcentro\n"+
                                                                        "left join hospitalizacion h\n"+
                                                                        "on h.codcentro_hos = c.codcentro\n"+
                                                                        "group by c.nombcentro,h.codcentro_hos, v.codcentro_vac) cvh\n"+
                                                                        "on cvh.nombcentro = c.nombcentro\n"+
                                                                        "group by c.nombcentro,cvh.codcentro_hos, cvh.codcentro_vac");
                
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
     public ResultSet reporte_6(){
            Statement st;
            ConexionSQL con = new ConexionSQL();
            try {
                st = con.connected().createStatement();
    
                System.out.println("En generar el reporte");
                String sql="select vv.denom_oms, vv.linaje, count(distinct(co.docidentidad)) as  contpercont\n" +
                                                                        "from virus_variante vv, contagio co\n" +
                                                                        "where vv.denom_oms=co.denom_oms\n" +
                                                                        "group by vv.denom_oms\n"+
                                                                        "order by contpercont desc limit 3";
                
                ResultSet rs = st.executeQuery(sql);
                System.out.println("Se genero el resultset");
                con.disconnect();
                return rs;
            } catch (Exception e) {
            return null;
            }
    }
}


