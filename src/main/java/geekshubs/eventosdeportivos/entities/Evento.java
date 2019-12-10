package geekshubs.eventosdeportivos.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="eventos")
public class Evento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String descripcion;
    private int aforo;

    @Temporal (TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fecha;

    @JsonManagedReference
    @JsonProperty("usuarios")
    @OneToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "evento")
    private List<Usuario> usuarios;

    public Evento() {
        usuarios=new ArrayList<Usuario>();
    }

    public Evento(String nombre, String descripcion, int aforo, Date fecha, List<Usuario> usuarios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aforo = aforo;
        this.fecha = fecha;
        this.usuarios = usuarios;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
