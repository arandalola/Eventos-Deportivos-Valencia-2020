package geekshubs.eventosdeportivos.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "registros")
public class Registro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Usuario usuario;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Evento evento;

    @PrePersist
    private void prePersist() {
        evento.getUsuarios().add(usuario);
        usuario.setEvento(evento);
    }

    @PreRemove
    private void preRemove() {
        evento.getUsuarios().remove(usuario);
        usuario.setEvento(null);
    }

    public Registro(Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
    }

    public Registro(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
