package ma.biyi.assurance_management.web;

import ma.biyi.assurance_management.dtos.ClientDTO;
import ma.biyi.assurance_management.services.AssuranceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*") // Indispensable pour la connexion avec Angular
public class ClientRestController {
    private final AssuranceService assuranceService;

    public ClientRestController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @GetMapping
    public List<ClientDTO> allClients() {
        return assuranceService.listClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return assuranceService.getClient(id);
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return assuranceService.saveClient(clientDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        assuranceService.deleteClient(id);
    }
}