package proyectolena.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Temporada")

public class Temporada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nombre;

    public Temporada() {
    }

    public Temporada(String temp) {
        this.nombre = temp;
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
