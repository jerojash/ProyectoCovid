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
                  ResultSet rs = st.executeQuery("select denom_oms, max(porceficacia) \n" +
                                                                        "    from eficaz\n" +
                                                                        "    where denom_oms like '"+variante+"'\n" +
                                                                        "    group by denom_oms");
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
}


