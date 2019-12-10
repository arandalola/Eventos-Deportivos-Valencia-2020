package geekshubs.eventosdeportivos.repositories;

import geekshubs.eventosdeportivos.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository <Evento, Long> {

}
