package ci.inp.patientMVC.Entities;

import ci.inp.patientMVC.Enums.AcountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    private Double balance;
    @Enumerated(EnumType.ORDINAL)
    private AcountType type;
    private String currency;
}
