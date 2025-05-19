package enset.ilyasgrid.exambackend.repositories;

import enset.ilyasgrid.exambackend.entities.Credit;
import enset.ilyasgrid.exambackend.entities.StatutCredit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {
    // Find credits by client id
    List<Credit> findByClientId(Long clientId);
    
    // Find credits by status
    List<Credit> findByStatut(StatutCredit statut);
    
    // Find credits with amount greater than the given value
    List<Credit> findByMontantGreaterThan(BigDecimal montant);
    
    // Find credits between date range
    List<Credit> findByDateDemandeAfterAndDateDemandeBefore(Date dateStart, Date dateEnd);
}
