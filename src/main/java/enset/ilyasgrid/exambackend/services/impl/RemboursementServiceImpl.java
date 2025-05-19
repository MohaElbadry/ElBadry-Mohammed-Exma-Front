package enset.ilyasgrid.exambackend.services.impl;

import enset.ilyasgrid.exambackend.dtos.RemboursementDTO;
import enset.ilyasgrid.exambackend.entities.Credit;
import enset.ilyasgrid.exambackend.entities.Remboursement;
import enset.ilyasgrid.exambackend.entities.TypeRemboursement;
import enset.ilyasgrid.exambackend.mappers.CreditMapper;
import enset.ilyasgrid.exambackend.repositories.CreditRepository;
import enset.ilyasgrid.exambackend.repositories.RemboursementRepository;
import enset.ilyasgrid.exambackend.services.RemboursementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class RemboursementServiceImpl implements RemboursementService {
    private RemboursementRepository remboursementRepository;
    private CreditRepository creditRepository;
    private CreditMapper creditMapper;

    @Override
    public RemboursementDTO saveRemboursement(RemboursementDTO remboursementDTO) {
        Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                .orElseThrow(() -> new RuntimeException("Crédit non trouvé"));
        
        Remboursement remboursement = new Remboursement();
        remboursement.setCredit(credit);
        remboursement.setDate(remboursementDTO.getDate());
        remboursement.setMontant(remboursementDTO.getMontant());
        remboursement.setType(remboursementDTO.getType());
        
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return creditMapper.fromRemboursement(savedRemboursement);
    }

    @Override
    public RemboursementDTO getRemboursement(Long id) {
        Remboursement remboursement = remboursementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Remboursement non trouvé"));
        return creditMapper.fromRemboursement(remboursement);
    }

    @Override
    public List<RemboursementDTO> getAllRemboursements() {
        List<Remboursement> remboursements = remboursementRepository.findAll();
        return remboursements.stream()
                .map(creditMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public RemboursementDTO updateRemboursement(RemboursementDTO remboursementDTO) {
        Remboursement remboursement = remboursementRepository.findById(remboursementDTO.getId())
                .orElseThrow(() -> new RuntimeException("Remboursement non trouvé"));
        
        Credit credit = creditRepository.findById(remboursementDTO.getCreditId())
                .orElseThrow(() -> new RuntimeException("Crédit non trouvé"));
        
        remboursement.setCredit(credit);
        remboursement.setDate(remboursementDTO.getDate());
        remboursement.setMontant(remboursementDTO.getMontant());
        remboursement.setType(remboursementDTO.getType());
        
        Remboursement updatedRemboursement = remboursementRepository.save(remboursement);
        return creditMapper.fromRemboursement(updatedRemboursement);
    }

    @Override
    public void deleteRemboursement(Long id) {
        remboursementRepository.deleteById(id);
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByCredit(Long creditId) {
        List<Remboursement> remboursements = remboursementRepository.findByCreditId(creditId);
        return remboursements.stream()
                .map(creditMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByType(TypeRemboursement type) {
        List<Remboursement> remboursements = remboursementRepository.findByType(type);
        return remboursements.stream()
                .map(creditMapper::fromRemboursement)
                .collect(Collectors.toList());
    }

    @Override
    public List<RemboursementDTO> getRemboursementsByDateRange(Date dateDebut, Date dateFin) {
        List<Remboursement> remboursements = remboursementRepository.findByDateAfterAndDateBefore(dateDebut, dateFin);
        return remboursements.stream()
                .map(creditMapper::fromRemboursement)
                .collect(Collectors.toList());
    }
}