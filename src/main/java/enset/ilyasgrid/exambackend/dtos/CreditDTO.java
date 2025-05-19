package enset.ilyasgrid.exambackend.dtos;

import enset.ilyasgrid.exambackend.entities.StatutCredit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditDTO {
    private Long id;
    private Date dateDemande;
    private StatutCredit statut;
    private BigDecimal montant;
    private Integer duree;
    private Double taux;
    private Long clientId;
    private String clientNom;
}