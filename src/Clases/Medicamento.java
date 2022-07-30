/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Real;
import java.math.BigInteger;

/**
 *
 * @author aleja
 */
public class Medicamento {
    private Integer cod_medicamento;
    private String nombremedicamento;
    private String compuesto;
    private Double concentracion; 
    
    public Medicamento(Integer cod_medicamento, String nombremedicamento, String compuesto, Double concentracion) {
        this.cod_medicamento = cod_medicamento;
        this.nombremedicamento = nombremedicamento;
        this.compuesto = compuesto;
        this.concentracion = concentracion;

    }

    public Integer getcod_medicamento() {
        return cod_medicamento;
    }

    public void setcod_medicamento(Integer cod_medicamento) {
        this.cod_medicamento = cod_medicamento;
    }

    public String getnombremedicamento() {
        return nombremedicamento;
    }

    public void setnombremedicamento(String nombremedicamento) {
        this.nombremedicamento = nombremedicamento;
    }

    public String getcompuesto() {
        return compuesto;
    }

    public void setcompuesto(String compuesto) {
        this.compuesto = compuesto;
    }

    public Double getconcentracion() {
        return concentracion;
    }

    public void setconcentracion(Double concentracion) {
        this.concentracion = concentracion;
    }

}
