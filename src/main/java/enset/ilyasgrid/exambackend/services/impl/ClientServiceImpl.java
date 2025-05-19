package enset.ilyasgrid.exambackend.services.impl;

import enset.ilyasgrid.exambackend.dtos.ClientDTO;
import enset.ilyasgrid.exambackend.entities.Client;
import enset.ilyasgrid.exambackend.mappers.CreditMapper;
import enset.ilyasgrid.exambackend.repositories.ClientRepository;
import enset.ilyasgrid.exambackend.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private CreditMapper creditMapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = creditMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return creditMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        return creditMapper.fromClient(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(creditMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = creditMapper.fromClientDTO(clientDTO);
        Client updatedClient = clientRepository.save(client);
        return creditMapper.fromClient(updatedClient);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<ClientDTO> searchClients(String keyword) {
        List<Client> clients = clientRepository.findByNomContainingIgnoreCase(keyword);
        return clients.stream()
                .map(creditMapper::fromClient)
                .collect(Collectors.toList());
    }
}