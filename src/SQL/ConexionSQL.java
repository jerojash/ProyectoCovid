package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSQL {
    Connection con = null;
    String url = "jdbc:postgresql://localhost:5432/Proyecto";
    String user = "postgres";
    String pass = "1234";
    
    public void connected (){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,user,pass);
            JOptionPane.showMessageDialog(null, "Conexion exitosa", "conexion",JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Conexion fallida", "conexion",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void disconnect(){
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "Desconexion exitosa", "conexion",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Desconexion fallida", "conexion",JOptionPane.INFORMATION_MESSAGE);
        }
    }  
}
