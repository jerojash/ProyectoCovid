/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocovid;
import SQL.ConexionSQL;
import java.util.Scanner;
import javax.swing.JFrame;
import view.registrarPersonaContagiada;
import view.registrarVacuna;
import view.registrarPersonaVacunada;
import view.registrarTratamiento;
import view.registrarTratamientoPaciente;
import SQL.Reporte;

/**
 *
 * @author Ricardo Fanghella
 */
public class ProyectoCovid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        registrarPersonaContagiada ventana = new registrarPersonaContagiada();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        registrarVacuna ventana1 = new registrarVacuna();
        ventana1.setVisible(true);
        ventana1.setLocationRelativeTo(null);
        registrarPersonaVacunada ventana2 = new registrarPersonaVacunada();
        ventana2.setVisible(true);
        ventana2.setLocationRelativeTo(null);
        registrarTratamiento ventana4 = new registrarTratamiento();
        ventana4.setVisible(true);
        ventana4.setLocationRelativeTo(null);
        registrarTratamientoPaciente ventana5 = new registrarTratamientoPaciente();
        ventana5.setVisible(true);
        ventana5.setLocationRelativeTo(null);
    }
    
}
