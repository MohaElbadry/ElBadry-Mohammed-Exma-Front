package enset.ilyasgrid.exambackend.services.impl;

import enset.ilyasgrid.exambackend.dtos.*;
import enset.ilyasgrid.exambackend.entities.*;
import enset.ilyasgrid.exambackend.mappers.CreditMapper;
import enset.ilyasgrid.exambackend.repositories.*;
import enset.ilyasgrid.exambackend.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {
    private CreditRepository creditRepository;
    private CreditImmobilierRepository creditImmobilierRepository;
    private CreditPersonnelRepository creditPersonnelRepository;
    private CreditProfessionnelRepository creditProfessionnelRepository;
    private ClientRepository clientRepository;
    private CreditMapper creditMapper;

    @Override
    public CreditDTO getCredit(Long id) {
        Credit credit = creditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crédit non trouvé"));
        return creditMapper.fromCredit(credit);
    }

    @Override
    public List<CreditDTO> getAllCredits() {
        List<Credit> credits = creditRepository.findAll();
        return credits.stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteCredit(Long id) {
        creditRepository.deleteById(id);
    }

    @Override
    public List<CreditDTO> getCreditsByClient(Long clientId) {
        List<Credit> credits = creditRepository.findByClientId(clientId);
        return credits.stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditDTO> getCreditsByStatut(StatutCredit statut) {
        List<Credit> credits = creditRepository.findByStatut(statut);
        return credits.stream()
                .map(creditMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(CreditImmobilierDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        
        CreditImmobilier creditImmobilier = new CreditImmobilier();
        creditImmobilier.setClient(client);
        creditImmobilier.setDateDemande(creditDTO.getDateDemande());
        creditImmobilier.setMontant(creditDTO.getMontant());
        creditImmobilier.setDuree(creditDTO.getDuree());
        creditImmobilier.setTaux(creditDTO.getTaux());
        creditImmobilier.setStatut(creditDTO.getStatut());
        creditImmobilier.setTypeBien(creditDTO.getTypeBien());
        
        CreditImmobilier savedCredit = creditImmobilierRepository.save(creditImmobilier);
        return creditMapper.fromCreditImmobilier(savedCredit);
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(CreditPersonnelDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setClient(client);
        creditPersonnel.setDateDemande(creditDTO.getDateDemande());
        creditPersonnel.setMontant(creditDTO.getMontant());
        creditPersonnel.setDuree(creditDTO.getDuree());
        creditPersonnel.setTaux(creditDTO.getTaux());
        creditPersonnel.setStatut(creditDTO.getStatut());
        creditPersonnel.setMotif(creditDTO.getMotif());
        
        CreditPersonnel savedCredit = creditPersonnelRepository.save(creditPersonnel);
        return creditMapper.fromCreditPersonnel(savedCredit);
    }

    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(CreditProfessionnelDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
        
        CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
        creditProfessionnel.setClient(client);
        creditProfessionnel.setDateDemande(creditDTO.getDateDemande());
        creditProfessionnel.setMontant(creditDTO.getMontant());
        creditProfessionnel.setDuree(creditDTO.getDuree());
        creditProfessionnel.setTaux(creditDTO.getTaux());
        creditProfessionnel.setStatut(creditDTO.getStatut());
        creditProfessionnel.setMotif(creditDTO.getMotif());
        creditProfessionnel.setRaisonSociale(creditDTO.getRaisonSociale());
        
        CreditProfessionnel savedCredit = creditProfessionnelRepository.save(creditProfessionnel);
        return creditMapper.fromCreditProfessionnel(savedCredit);
    }

    @Override
    public CreditImmobilierDTO updateCreditImmobilier(CreditImmobilierDTO creditDTO) {
        CreditImmobilier creditImmobilier = creditImmobilierRepository.findById(creditDTO.getId())
                .orElseThrow(() -> new RuntimeException("Crédit immobilier non trouvé"));
        
        creditImmobilier.setDateDemande(creditDTO.getDateDemande());
        creditImmobilier.setMontant(creditDTO.getMontant());
        creditImmobilier.setDuree(creditDTO.getDuree());
        creditImmobilier.setTaux(creditDTO.getTaux());
        creditImmobilier.setStatut(creditDTO.getStatut());
        creditImmobilier.setTypeBien(creditDTO.getTypeBien());
        
        CreditImmobilier updatedCredit = creditImmobilierRepository.save(creditImmobilier);
        return creditMapper.fromCreditImmobilier(updatedCredit);
    }

    @Override
    public CreditPersonnelDTO updateCreditPersonnel(CreditPersonnelDTO creditDTO) {
        CreditPersonnel creditPersonnel = creditPersonnelRepository.findById(creditDTO.getId())
                .orElseThrow(() -> new RuntimeException("Crédit personnel non trouvé"));
        
        creditPersonnel.setDateDemande(creditDTO.getDateDemande());
        creditPersonnel.setMontant(creditDTO.getMontant());
        creditPersonnel.setDuree(creditDTO.getDuree());
        creditPersonnel.setTaux(creditDTO.getTaux());
        creditPersonnel.setStatut(creditDTO.getStatut());
        creditPersonnel.setMotif(creditDTO.getMotif());
        
        CreditPersonnel updatedCredit = creditPersonnelRepository.save(creditPersonnel);
        return creditMapper.fromCreditPersonnel(updatedCredit);
    }

    @Override
    public CreditProfessionnelDTO updateCreditProfessionnel(CreditProfessionnelDTO creditDTO) {
        CreditProfessionnel creditProfessionnel = creditProfessionnelRepository.findById(creditDTO.getId())
                .orElseThrow(() -> new RuntimeException("Crédit professionnel non trouvé"));
        
        creditProfessionnel.setDateDemande(creditDTO.getDateDemande());
        creditProfessionnel.setMontant(creditDTO.getMontant());
        creditProfessionnel.setDuree(creditDTO.getDuree());
        creditProfessionnel.setTaux(creditDTO.getTaux());
        creditProfessionnel.setStatut(creditDTO.getStatut());
        creditProfessionnel.setMotif(creditDTO.getMotif());
        creditProfessionnel.setRaisonSociale(creditDTO.getRaisonSociale());
        
        CreditProfessionnel updatedCredit = creditProfessionnelRepository.save(creditProfessionnel);
        return creditMapper.fromCreditProfessionnel(updatedCredit);
    }

    @Override
    public List<CreditImmobilierDTO> getAllCreditsImmobilier() {
        List<CreditImmobilier> credits = creditImmobilierRepository.findAll();
        return credits.stream()
                .map(creditMapper::fromCreditImmobilier)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditPersonnelDTO> getAllCreditsPersonnel() {
        List<CreditPersonnel> credits = creditPersonnelRepository.findAll();
        return credits.stream()
                .map(creditMapper::fromCreditPersonnel)
                .collect(Collectors.toList());
    }

    @Override
    public List<CreditProfessionnelDTO> getAllCreditsProfessionnel() {
        List<CreditProfessionnel> credits = creditProfessionnelRepository.findAll();
        return credits.stream()
                .map(creditMapper::fromCreditProfessionnel)
                .collect(Collectors.toList());
    }
}