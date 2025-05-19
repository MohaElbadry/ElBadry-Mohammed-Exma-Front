package enset.ilyasgrid.exambackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditPersonnelDTO extends CreditDTO {
    private String motif;
}