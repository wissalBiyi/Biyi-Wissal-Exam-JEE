package ma.biyi.assurance_management.repositories;

import ma.biyi.assurance_management.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository
        extends JpaRepository<Contrat, Long> {

}