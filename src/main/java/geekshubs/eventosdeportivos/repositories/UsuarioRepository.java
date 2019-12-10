package geekshubs.eventosdeportivos.repositories;

import geekshubs.eventosdeportivos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
