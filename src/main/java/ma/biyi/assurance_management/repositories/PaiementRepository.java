package ma.biyi.assurance_management.repositories;

import ma.biyi.assurance_management.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository
        extends JpaRepository<Paiement, Long> {

}
