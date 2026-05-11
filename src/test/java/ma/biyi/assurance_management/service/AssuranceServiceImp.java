package ma.biyi.assurance_management.service;

import jakarta.transaction.Transactional;
import ma.biyi.assurance_management.dtos.ClientDTO;
import ma.biyi.assurance_management.entities.Client;
import ma.biyi.assurance_management.mappers.AssuranceMapper;
import ma.biyi.assurance_management.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AssuranceServiceImpl implements AssuranceService {
    private ClientRepository clientRepository;
    private AssuranceMapper mapper;

    public AssuranceServiceImpl(ClientRepository clientRepository, AssuranceMapper mapper) {
        this.clientRepository = clientRepository;
        this.mapper = mapper;
    }

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return mapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(client -> mapper.fromClient(client))
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return mapper.fromClient(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}