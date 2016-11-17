package proyectolena.dominio;

import java.util.Set;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "Articulo")

public class Articulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String numArticulo;
    private BigDecimal precio;
    @ManyToOne
    private Marca marca;
    @ManyToMany(targetEntity = Talle.class)
    private Set<Talle> talles;
    @ManyToOne
    private Temporada temporada;
    @ManyToOne
    private DefArticulo defArticulo;

    public Articulo() {

    }

    public String getNumArticulo() {
        return numArticulo;
    }

    public void setNumArticulo(String art) {
        numArticulo = art;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal pre) {
        precio = pre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca newVal) {
        marca = newVal;
    }

    public Set<Talle> getTalles() {
        return talles;
    }

    public void setTalles(Set<Talle> newVal) {
        talles = newVal;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada newVal) {
        temporada = newVal;
    }

    public DefArticulo getDefArticulo() {
        return defArticulo;
    }

    public void setDefArticulo(DefArticulo newVal) {
        defArticulo = newVal;
    }

}
