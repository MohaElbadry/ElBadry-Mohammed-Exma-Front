package enset.ilyasgrid.exambackend.services;

import enset.ilyasgrid.exambackend.dtos.ClientDTO;
import java.util.List;

public interface ClientService {
    ClientDTO saveClient(ClientDTO clientDTO);
    ClientDTO getClient(Long id);
    List<ClientDTO> getAllClients();
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long id);
    List<ClientDTO> searchClients(String keyword);
}