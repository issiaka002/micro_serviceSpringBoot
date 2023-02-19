package ci.inp.patientMVC.Service;


import ci.inp.patientMVC.Dto.BankAccountRequestDTO;
import ci.inp.patientMVC.Dto.BankAccountResponseDTO;


public interface BankAccountService {
    //..
    BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountRequestDTO);
}
