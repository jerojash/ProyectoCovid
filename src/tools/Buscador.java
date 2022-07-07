
package tools;

import Clases.Pais;
import SQL.Extraer;
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
}
