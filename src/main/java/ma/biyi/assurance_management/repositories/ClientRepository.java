package ma.biyi.assurance_management.repositories;

import ma.biyi.assurance_management.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository
        extends JpaRepository<Client, Long> {

}