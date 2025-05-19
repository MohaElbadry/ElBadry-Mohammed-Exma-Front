package enset.ilyasgrid.exambackend.dtos;

import enset.ilyasgrid.exambackend.entities.StatutCredit;
import enset.ilyasgrid.exambackend.entities.TypeBien;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}