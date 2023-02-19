package ci.inp.patientMVC.Dto;

import ci.inp.patientMVC.Enums.AcountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountRequestDTO {

    private Double balance;
    private AcountType type;
    private String currency;
}
