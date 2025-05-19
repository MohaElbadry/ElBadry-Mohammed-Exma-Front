package enset.ilyasgrid.exambackend.repositories;

import enset.ilyasgrid.exambackend.entities.CreditPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel, Long> {
    // Find credits by motif containing the given string
    List<CreditPersonnel> findByMotifContaining(String motif);
}