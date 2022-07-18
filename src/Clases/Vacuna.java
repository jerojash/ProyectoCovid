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
public class Vacuna {
    private Integer idvacuna;
    private Integer lote;
    private String nombvacuna;
    private Integer cantdosis;
    private String laboratorio;
    private String tipo_vacuna;
    private Integer codpais;

    public Vacuna(Integer idvacuna, Integer lote, String nombvacuna, Integer cantdosis, String laboratorio, String tipo_vacuna, Integer codpais) {
        this.idvacuna = idvacuna;
        this.lote = lote;
        this.nombvacuna = nombvacuna;
        this.cantdosis = cantdosis;
        this.laboratorio = laboratorio;
        this.tipo_vacuna = tipo_vacuna;
        this.codpais = codpais;
    }

    public Integer getIdvacuna() {
        return idvacuna;
    }

    public Integer getLote() {
        return lote;
    }

    public String getNombvacuna() {
        return nombvacuna;
    }

    public Integer getCantdosis() {
        return cantdosis;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public String getTipo_vacuna() {
        return tipo_vacuna;
    }

    public Integer getCodpais() {
        return codpais;
    }

    public void setIdvacuna(Integer idvacuna) {
        this.idvacuna = idvacuna;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public void setNombvacuna(String nombvacuna) {
        this.nombvacuna = nombvacuna;
    }

    public void setCantdosis(Integer cantdosis) {
        this.cantdosis = cantdosis;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setTipo_vacuna(String tipo_vacuna) {
        this.tipo_vacuna = tipo_vacuna;
    }

    public void setCodpais(Integer codpais) {
        this.codpais = codpais;
    }
    
         
    
}
