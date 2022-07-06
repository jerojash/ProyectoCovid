package Clases;

public class Estado {

    private Integer codestado;
    private String nombestado;

    public Estado(Integer codestado, String nombestado) {
        this.codestado = codestado;
        this.nombestado = nombestado;
    }

    public Integer getCodestado() {
        return codestado;
    }

    public void setCodestado(Integer codestado) {
        this.codestado = codestado;
    }

    public String getNombestado() {
        return nombestado;
    }

    public void setNombestado(String nombestado) {
        this.nombestado = nombestado;
    }
}
