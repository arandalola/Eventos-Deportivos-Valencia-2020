package geekshubs.eventosdeportivos.entities;

public class UsuarioEvento {
    Long idUsuario;
    Long idEvento;

    public UsuarioEvento(Long idUsuario, Long idEvento) {
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
    }

    public UsuarioEvento(){}

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }
}
