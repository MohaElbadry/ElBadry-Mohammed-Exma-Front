package enset.ilyasgrid.exambackend.dtos;

import enset.ilyasgrid.exambackend.entities.TypeRemboursement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RemboursementDTO {
    private Long id;
    private Date date;
    private BigDecimal montant;
    private TypeRemboursement type;
    private Long creditId;
    private String clientNom;
}