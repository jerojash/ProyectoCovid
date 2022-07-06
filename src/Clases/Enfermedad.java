package Clases;

public class Enfermedad {
    private Integer codenfermedad;
    private String nombenfermedad;

    public Enfermedad(Integer codenfermedad, String nombenfermedad) {
        this.codenfermedad = codenfermedad;
        this.nombenfermedad = nombenfermedad;
    }

    public Enfermedad() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getCodenfermedad() {
        return codenfermedad;
    }

    public void setCodenfermedad(Integer codenfermedad) {
        this.codenfermedad = codenfermedad;
    }

    public String getNombenfermedad() {
        return nombenfermedad;
    }

    public void setNombenfermedad(String nombenfermedad) {
        this.nombenfermedad = nombenfermedad;
    }
    
    
}
