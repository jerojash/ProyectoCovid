/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Text;
import javafx.scene.text.Text;

/**
 *
 * @author aleja
 */
public class Tratamiento {
    private Integer cod_tratamiento;
    private String nombretratamiento;    

    public Tratamiento(Integer cod_tratamiento, String nombretratamiento) {
        this.cod_tratamiento = cod_tratamiento;
        this.nombretratamiento = nombretratamiento;
    }
    
    public Integer getcod_tratamiento() {
        return cod_tratamiento;
    }

    public void setcod_tratamiento(Integer cod_tratamiento) {
        this.cod_tratamiento = cod_tratamiento;
    }

    public String getnombretratamiento() {
        return nombretratamiento;
    }

    public void setnombretratamiento(String nombretratamiento) {
        this.nombretratamiento = nombretratamiento;
    }
}