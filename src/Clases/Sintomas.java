/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author aleja
 */
public class Sintomas {
    private Integer codsintoma;
    private String descripsintoma;
    
    public Sintomas(Integer codsintoma, String descripsintoma) {
        this.codsintoma = codsintoma;
        this.descripsintoma = descripsintoma;
    }

    public Sintomas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getcodsintoma() {
        return codsintoma;
    }

    public void setCodSintoma(Integer codsintoma) {
        this.codsintoma = codsintoma;
    }

    public String getdescripsintoma() {
        return descripsintoma;
    }

    public void setdescripsintoma(String nombenfermedad) {
        this.descripsintoma = nombenfermedad;
    }
}
