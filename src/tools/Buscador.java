
package tools;

import Clases.Estado;
import Clases.Pais;
import SQL.ConexionSQL;
import SQL.Extraer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
}
