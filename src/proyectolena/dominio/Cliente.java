package proyectolena.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    @ManyToOne
    private Localidad localidad;

    public Cliente(String nombre, String apellido, String telefono, Localidad localidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApeliido() {
        return apellido;
    }

    public void setApeliido(String apeliido) {
        this.apellido = apeliido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
