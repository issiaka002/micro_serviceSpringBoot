package ci.inp.patientMVC.Dto;

import ci.inp.patientMVC.Enums.AcountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdDate;
    private Double balance;
    private AcountType type;
    private String currency;
}
