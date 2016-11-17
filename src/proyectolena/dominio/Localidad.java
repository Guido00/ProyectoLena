package proyectolena.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Localidad")
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String codigoP;
    
    public Localidad(){}

    public Localidad(String nombre, String cp) {
        this.nombre = nombre;
        this.codigoP = cp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String CodigoP) {
        this.codigoP = CodigoP;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
