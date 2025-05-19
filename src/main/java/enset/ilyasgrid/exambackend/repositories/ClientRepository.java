package enset.ilyasgrid.exambackend.repositories;

import enset.ilyasgrid.exambackend.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Find client by email
    Client findByEmail(String email);

    // Find clients by name containing the given string (case insensitive)
    java.util.List<Client> findByNomContainingIgnoreCase(String nom);
}