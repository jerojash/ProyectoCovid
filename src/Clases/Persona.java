package Clases;

import java.math.BigInteger;

public class Persona {
    
    private String CI;
    private String nombre;
    private String apellido;
    private String fecha_nac;
    private String genero;
    private String direccion;
    private BigInteger tlf;
    private boolean altoRiesgo;
    private String ocupacion;
    
    public Persona(String CI, String nombre, String apellido, String fecha_nac, String genero, String direccion, BigInteger tlf, boolean altoRiesgo, String ocupacion) {
        this.CI = CI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.genero = genero;
        this.direccion = direccion;
        this.tlf = tlf;
        this.altoRiesgo = altoRiesgo;
        this.ocupacion = ocupacion;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public BigInteger getTlf() {
        return tlf;
    }

    public void setTlf(BigInteger tlf) {
        this.tlf = tlf;
    }

    public boolean isAltoRiesgo() {
        return altoRiesgo;
    }

    public void setAltoRiesgo(boolean altoRiesgo) {
        this.altoRiesgo = altoRiesgo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }   
}
