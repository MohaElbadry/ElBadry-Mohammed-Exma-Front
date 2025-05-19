package enset.ilyasgrid.exambackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Credit {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDemande;
    
    @Enumerated(EnumType.STRING)
    private StatutCredit statut;
    
    private BigDecimal montant;
    private Integer duree;
    private Double taux;
    
    @ManyToOne
    private Client client;
    
    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}