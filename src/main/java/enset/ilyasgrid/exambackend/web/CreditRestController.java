package enset.ilyasgrid.exambackend.web;

import enset.ilyasgrid.exambackend.dtos.*;
import enset.ilyasgrid.exambackend.entities.StatutCredit;
import enset.ilyasgrid.exambackend.services.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/credits")
@AllArgsConstructor
@CrossOrigin("*")
public class CreditRestController {
    private CreditService creditService;

    @GetMapping
    public List<CreditDTO> getAllCredits() {
        return creditService.getAllCredits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditDTO> getCredit(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(creditService.getCredit(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredit(@PathVariable Long id) {
        try {
            creditService.deleteCredit(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/client/{clientId}")
    public List<CreditDTO> getCreditsByClient(@PathVariable Long clientId) {
        return creditService.getCreditsByClient(clientId);
    }

    @GetMapping("/statut/{statut}")
    public List<CreditDTO> getCreditsByStatut(@PathVariable StatutCredit statut) {
        return creditService.getCreditsByStatut(statut);
    }

    // Endpoints spécifiques pour les crédits immobiliers
    @GetMapping("/immobilier")
    public List<CreditImmobilierDTO> getAllCreditsImmobilier() {
        return creditService.getAllCreditsImmobilier();
    }

    @PostMapping("/immobilier")
    public ResponseEntity<CreditImmobilierDTO> saveCreditImmobilier(@RequestBody CreditImmobilierDTO creditDTO) {
        return new ResponseEntity<>(creditService.saveCreditImmobilier(creditDTO), HttpStatus.CREATED);
    }

    @PutMapping("/immobilier/{id}")
    public ResponseEntity<CreditImmobilierDTO> updateCreditImmobilier(@PathVariable Long id, @RequestBody CreditImmobilierDTO creditDTO) {
        creditDTO.setId(id);
        try {
            return ResponseEntity.ok(creditService.updateCreditImmobilier(creditDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoints spécifiques pour les crédits personnels
    @GetMapping("/personnel")
    public List<CreditPersonnelDTO> getAllCreditsPersonnel() {
        return creditService.getAllCreditsPersonnel();
    }

    @PostMapping("/personnel")
    public ResponseEntity<CreditPersonnelDTO> saveCreditPersonnel(@RequestBody CreditPersonnelDTO creditDTO) {
        return new ResponseEntity<>(creditService.saveCreditPersonnel(creditDTO), HttpStatus.CREATED);
    }

    @PutMapping("/personnel/{id}")
    public ResponseEntity<CreditPersonnelDTO> updateCreditPersonnel(@PathVariable Long id, @RequestBody CreditPersonnelDTO creditDTO) {
        creditDTO.setId(id);
        try {
            return ResponseEntity.ok(creditService.updateCreditPersonnel(creditDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoints spécifiques pour les crédits professionnels
    @GetMapping("/professionnel")
    public List<CreditProfessionnelDTO> getAllCreditsProfessionnel() {
        return creditService.getAllCreditsProfessionnel();
    }

    @PostMapping("/professionnel")
    public ResponseEntity<CreditProfessionnelDTO> saveCreditProfessionnel(@RequestBody CreditProfessionnelDTO creditDTO) {
        return new ResponseEntity<>(creditService.saveCreditProfessionnel(creditDTO), HttpStatus.CREATED);
    }

    @PutMapping("/professionnel/{id}")
    public ResponseEntity<CreditProfessionnelDTO> updateCreditProfessionnel(@PathVariable Long id, @RequestBody CreditProfessionnelDTO creditDTO) {
        creditDTO.setId(id);
        try {
            return ResponseEntity.ok(creditService.updateCreditProfessionnel(creditDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}