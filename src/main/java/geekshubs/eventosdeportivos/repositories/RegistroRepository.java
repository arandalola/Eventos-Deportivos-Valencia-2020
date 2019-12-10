package geekshubs.eventosdeportivos.repositories;

import geekshubs.eventosdeportivos.entities.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long> {

}
