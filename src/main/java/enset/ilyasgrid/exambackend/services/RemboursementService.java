package enset.ilyasgrid.exambackend.services;

import enset.ilyasgrid.exambackend.dtos.RemboursementDTO;
import enset.ilyasgrid.exambackend.entities.TypeRemboursement;
import java.util.Date;
import java.util.List;

public interface RemboursementService {
    RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO);
    RemboursementDTO getRemboursement(Long id);
    List<RemboursementDTO> getAllRemboursements();
    RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO);
    void deleteRemboursement(Long id);
    List<RemboursementDTO> getRemboursementsByCredit(Long creditId);
    List<RemboursementDTO> getRemboursementsByType(TypeRemboursement type);
    List<RemboursementDTO> getRemboursementsByDateRange(Date dateDebut, Date dateFin);
}