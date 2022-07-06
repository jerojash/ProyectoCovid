package Clases;

public class Pais {

    private Integer cod_pais;
    private String nombpais;

    public Pais(Integer cod_pais, String nombpais) {
        this.cod_pais = cod_pais;
        this.nombpais = nombpais;
    }

    public Integer getCod_pais() {
        return cod_pais;
    }

    public void setCod_pais(Integer cod_pais) {
        this.cod_pais = cod_pais;
    }

    public String getNombpais() {
        return nombpais;
    }

    public void setNombpais(String nombpais) {
        this.nombpais = nombpais;
    }
}
