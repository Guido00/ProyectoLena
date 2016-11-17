package proyectolena.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "DefArticulo")

public class DefArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nombre;
    @ManyToOne
    private TipoArticulo tipoArticulo;

    public DefArticulo() {

    }

    public DefArticulo(String def, TipoArticulo ta) {
        this.nombre = def;
        this.tipoArticulo = ta;
    }

    @Override
    public String toString() {
        return nombre + tipoArticulo;
    }

    public TipoArticulo getTipoArticulo() {
        return tipoArticulo;
    }

    public void setTipoArticulo(TipoArticulo newVal) {
        tipoArticulo = newVal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

}
