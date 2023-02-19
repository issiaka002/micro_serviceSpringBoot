package ci.inp.patientMVC.Repositories;

import ci.inp.patientMVC.Entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
