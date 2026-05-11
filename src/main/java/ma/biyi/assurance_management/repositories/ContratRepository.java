package ma.biyi.assurance_management.repositories;

import ma.biyi.assurance_management.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {

    List<Contrat> findByClientId(Long clientId);

}