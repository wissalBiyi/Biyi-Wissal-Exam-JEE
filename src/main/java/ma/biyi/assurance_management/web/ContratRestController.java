package ma.biyi.assurance_management.web;

import ma.biyi.assurance_management.entities.Contrat;
import ma.biyi.assurance_management.repositories.ContratRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contrats")
@CrossOrigin("*")
public class ContratRestController {
    private final ContratRepository contratRepository;

    public ContratRestController(ContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @GetMapping
    public List<Contrat> allContrats() {
        return contratRepository.findAll();
    }

    // Fonctionnalité importante : Lister les contrats par Client
    @GetMapping("/client/{clientId}")
    public List<Contrat> getContratsByClient(@PathVariable Long clientId) {
        return contratRepository.findByClientId(clientId);
    }
}