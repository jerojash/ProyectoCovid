/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author yerlin
 */
public class CentroSalud {
    private Integer codCentro;
    private String nombreCentro;
    private String direccion;
    private String CI;
    private String fechaEncargo;
    private Integer CodEstado;
    
    public CentroSalud (Integer codCentro, String nombreCentro, String direccion, String CI, String fechaEncargo, Integer codEstado){
        this.codCentro = codCentro;
        this.nombreCentro = nombreCentro;
        this.direccion = direccion;
        this.CI = CI;
        this.fechaEncargo = fechaEncargo;
        this.CodEstado = CodEstado;
    }

    public Integer getCodCentro() {
        return codCentro;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCI() {
        return CI;
    }

    public String getFechaEncargo() {
        return fechaEncargo;
    }

    public Integer getCodEstado() {
        return CodEstado;
    }
    
    public void setCodCentro(Integer codCentro) {
        this.codCentro = codCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public void setFechaEncargo(String fechaEncargo) {
        this.fechaEncargo = fechaEncargo;
    }

    public void setCodEstado(Integer CodEstado) {
        this.CodEstado = CodEstado;
    }
    
}
