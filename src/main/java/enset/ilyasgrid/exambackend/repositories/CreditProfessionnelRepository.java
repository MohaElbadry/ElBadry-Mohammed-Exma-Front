package enset.ilyasgrid.exambackend.repositories;

import enset.ilyasgrid.exambackend.entities.CreditProfessionnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditProfessionnelRepository extends JpaRepository<CreditProfessionnel, Long> {
    // Find credits by company name
    List<CreditProfessionnel> findByRaisonSocialeContainingIgnoreCase(String raisonSociale);
}