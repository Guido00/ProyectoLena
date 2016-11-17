package proyectolena.dominio;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "Stock")

public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private int cantidad;
    @ManyToOne
    private Articulo articulo;
    @ManyToMany(targetEntity = Talle.class)
    private Set<Talle> talle;
    @ManyToOne
    private Color color;

    public Stock() {

    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo newVal) {
        articulo = newVal;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newVal) {
        color = newVal;
    }

    public Set<Talle> getTalle() {
        return talle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setTalle(Set<Talle> newVal) {
        talle = newVal;
    }

}
