
package Clases;

public class Variante {
    
    private String denom_oms;
    private String linaje;
    private String fecha_origen;
    private String clasificacion;
    private Integer codpais;

    public Variante(String denom_oms, String linaje, String fecha_origen, String clasificacion, Integer codpais) {
        this.denom_oms = denom_oms;
        this.linaje = linaje;
        this.fecha_origen = fecha_origen;
        this.clasificacion = clasificacion;
        this.codpais = codpais;
    }

    public String getDenom_oms() {
        return denom_oms;
    }

    public void setDenom_oms(String denom_oms) {
        this.denom_oms = denom_oms;
    }

    public String getLinaje() {
        return linaje;
    }

    public void setLinaje(String linaje) {
        this.linaje = linaje;
    }

    public String getFecha_origen() {
        return fecha_origen;
    }

    public void setFecha_origen(String fecha_origen) {
        this.fecha_origen = fecha_origen;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Integer getCodpais() {
        return codpais;
    }

    public void setCodpais(Integer codpais) {
        this.codpais = codpais;
    }
    
    
}
