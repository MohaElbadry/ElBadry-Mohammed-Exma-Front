package enset.ilyasgrid.exambackend.repositories;

import enset.ilyasgrid.exambackend.entities.CreditImmobilier;
import enset.ilyasgrid.exambackend.entities.TypeBien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
    // Find credits by property type
    List<CreditImmobilier> findByTypeBien(TypeBien typeBien);
}