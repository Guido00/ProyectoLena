package proyectolena.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TipoArticulo")

public class TipoArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nombre;

    public TipoArticulo() {
    }

    public TipoArticulo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
