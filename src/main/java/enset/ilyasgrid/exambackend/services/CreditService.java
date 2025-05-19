package enset.ilyasgrid.exambackend.services;

import enset.ilyasgrid.exambackend.dtos.*;
import enset.ilyasgrid.exambackend.entities.StatutCredit;
import java.util.List;

public interface CreditService {
    // Méthodes génériques pour tous les crédits
    CreditDTO getCredit(Long id);
    List<CreditDTO> getAllCredits();
    void deleteCredit(Long id);
    List<CreditDTO> getCreditsByClient(Long clientId);
    List<CreditDTO> getCreditsByStatut(StatutCredit statut);
    
    // Méthodes spécifiques pour chaque type de crédit
    CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO);
    CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO);
    CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO);
    
    CreditImmobilierDTO updateCreditImmobilier(CreditImmobilierDTO creditDTO);
    CreditPersonnelDTO updateCreditPersonnel(CreditPersonnelDTO creditDTO);
    CreditProfessionnelDTO updateCreditProfessionnel(CreditProfessionnelDTO creditDTO);
    
    List<CreditImmobilierDTO> getAllCreditsImmobilier();
    List<CreditPersonnelDTO> getAllCreditsPersonnel();
    List<CreditProfessionnelDTO> getAllCreditsProfessionnel();
}