package proyectolena.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Color")

public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nombre;

    public Color() {

    }

    public Color(String color) {
        this.nombre = color;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
