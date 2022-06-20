/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocovid;
import javax.swing.JFrame;
import view.registrarVariante;
/**
 *
 * @author Ricardo Fanghella
 */
public class ProyectoCovid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        registrarVariante ventana = new registrarVariante();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    
}
