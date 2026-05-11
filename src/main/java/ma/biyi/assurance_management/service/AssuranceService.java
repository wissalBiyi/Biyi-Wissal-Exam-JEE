package ma.biyi.assurance_management.service;

import ma.biyi.assurance_management.dtos.ClientDTO;
import java.util.List;

public interface AssuranceService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();
    ClientDTO getClient(Long id);
    void deleteClient(Long id);
    // Tu peux ajouter : void souscrireContrat(Long clientId, Contrat contrat);
}