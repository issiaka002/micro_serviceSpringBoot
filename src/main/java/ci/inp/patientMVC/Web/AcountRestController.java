package ci.inp.patientMVC.Web;


import ci.inp.patientMVC.Dto.BankAccountRequestDTO;
import ci.inp.patientMVC.Dto.BankAccountResponseDTO;
import ci.inp.patientMVC.Entities.BankAccount;
import ci.inp.patientMVC.Repositories.BankAccountRepository;
import ci.inp.patientMVC.Service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController @AllArgsConstructor
@RequestMapping("/banque")
public class AcountRestController {

    private BankAccountRepository bankAccountRepository;
    private BankAccountService bankAccountService;

    @GetMapping(path = "/bankAccounts")
    public List<BankAccount> bankAccountList(){
        return bankAccountRepository.findAll();
    }

    @GetMapping(path = "/bankAccounts/{id}")
    public BankAccount bankaccount(@PathVariable String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account %s not found", id)));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO accountRequestDTO){
        return bankAccountService.addBankAccount(accountRequestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        if(bankAccount.getBalance()!=null) account.setBalance(bankAccount.getBalance());
        if(bankAccount.getType()!=null)account.setType(bankAccount.getType());
        if(bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if(bankAccount.getCreatedDate()!=null)account.setCreatedDate(new Date());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccount/{id}")
    public String deleteAccount(@PathVariable String id){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        bankAccountRepository.deleteById(id);
        return "Deleted Account";
    }

}
