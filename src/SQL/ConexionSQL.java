package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.JOptionPane;

public class ConexionSQL {
    Connection con = null;
<<<<<<< HEAD
    String url = "jdbc:postgresql://localhost:5432/ProyectoFinal";
=======
    String url = "jdbc:postgresql://localhost:5432/proyectoCovid1.1";
>>>>>>> 810f19ce1d545cbecb50dfd21f298b8bc972400c
    String user = "postgres";
    String pass = "admin";
    
    public Connection connected (){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,user,pass);
            //JOptionPane.showMessageDialog(null, "Conexion exitosa", "conexion",JOptionPane.INFORMATION_MESSAGE);
            return con;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Conexion fallida", "conexion",JOptionPane.INFORMATION_MESSAGE);
        }
        return con;
    }
    
    public void disconnect(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "Desconexion exitosa", "conexion",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Desconexion fallida", "conexion",JOptionPane.INFORMATION_MESSAGE);
        }
    }  
}
