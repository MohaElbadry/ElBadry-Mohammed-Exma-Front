package enset.ilyasgrid.exambackend.web;

import enset.ilyasgrid.exambackend.dtos.RemboursementDTO;
import enset.ilyasgrid.exambackend.entities.TypeRemboursement;
import enset.ilyasgrid.exambackend.services.RemboursementService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/remboursements")
@AllArgsConstructor
@CrossOrigin("*")
public class RemboursementRestController {
    private RemboursementService remboursementService;

    @GetMapping
    public List<RemboursementDTO> getAllRemboursements() {
        return remboursementService.getAllRemboursements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemboursementDTO> getRemboursement(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(remboursementService.getRemboursement(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RemboursementDTO> saveRemboursement(@RequestBody RemboursementDTO remboursementDTO) {
        return new ResponseEntity<>(remboursementService.saveRemboursement(remboursementDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemboursementDTO> updateRemboursement(@PathVariable Long id, @RequestBody RemboursementDTO remboursementDTO) {
        remboursementDTO.setId(id);
        try {
            return ResponseEntity.ok(remboursementService.updateRemboursement(remboursementDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRemboursement(@PathVariable Long id) {
        try {
            remboursementService.deleteRemboursement(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/credit/{creditId}")
    public List<RemboursementDTO> getRemboursementsByCredit(@PathVariable Long creditId) {
        return remboursementService.getRemboursementsByCredit(creditId);
    }

    @GetMapping("/type/{type}")
    public List<RemboursementDTO> getRemboursementsByType(@PathVariable TypeRemboursement type) {
        return remboursementService.getRemboursementsByType(type);
    }

    @GetMapping("/date-range")
    public List<RemboursementDTO> getRemboursementsByDateRange(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin) {
        return remboursementService.getRemboursementsByDateRange(dateDebut, dateFin);
    }
}