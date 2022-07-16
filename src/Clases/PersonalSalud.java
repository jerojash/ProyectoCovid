/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.math.BigInteger;
/**
 *
 * @author yerlin
 */
public class PersonalSalud extends Persona{
    private String correo;
    
    public PersonalSalud (String CI, String nombre, String apellido, String fecha_nac, String genero, String direccion, BigInteger tlf, boolean altoRiesgo, String ocupacion,String correo){
        super(CI,nombre,apellido,fecha_nac,genero,direccion,tlf,altoRiesgo,ocupacion);
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
