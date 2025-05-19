package enset.ilyasgrid.exambackend.repositories;

import enset.ilyasgrid.exambackend.entities.Remboursement;
import enset.ilyasgrid.exambackend.entities.TypeRemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement, Long> {
    // Find repayments by credit id
    List<Remboursement> findByCreditId(Long creditId);
    
    // Find repayments by type
    List<Remboursement> findByType(TypeRemboursement type);
    
    // Find repayments between date range
    List<Remboursement> findByDateAfterAndDateBefore(Date dateStart, Date dateEnd);
}
