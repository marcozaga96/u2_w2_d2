package marcozagaria.u2_w2_d2.repositories;

import marcozagaria.u2_w2_d2.entities.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoreRepository extends JpaRepository<Autore, Integer> {
    
}
