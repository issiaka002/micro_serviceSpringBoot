package ci.inp.patientMVC.Service;

import ci.inp.patientMVC.Dto.BankAccountRequestDTO;
import ci.inp.patientMVC.Dto.BankAccountResponseDTO;
import ci.inp.patientMVC.Entities.BankAccount;
import ci.inp.patientMVC.Mapper.MapperBankAccount;
import ci.inp.patientMVC.Repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service @Transactional @AllArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;
    private MapperBankAccount mapper;

    @Override
    public BankAccountResponseDTO addBankAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        //..
        BankAccount account = mapper.bankAccountDtoToEntity(bankAccountRequestDTO);

        //..
        BankAccount savedAccount= bankAccountRepository.save(account);

        //..
        BankAccountResponseDTO bankAccountResponseDTO=mapper.bankAccountEntityToDto(savedAccount);
        return bankAccountResponseDTO;
    }
}
