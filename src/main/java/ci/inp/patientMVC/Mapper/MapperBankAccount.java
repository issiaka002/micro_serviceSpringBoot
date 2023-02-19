package ci.inp.patientMVC.Mapper;

import ci.inp.patientMVC.Dto.BankAccountRequestDTO;
import ci.inp.patientMVC.Dto.BankAccountResponseDTO;
import ci.inp.patientMVC.Entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class MapperBankAccount {


    public BankAccount bankAccountDtoToEntity(BankAccountRequestDTO bankAccountRequestDTO){
        //..
        BankAccount account = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdDate(new Date())
                .type(bankAccountRequestDTO.getType())
                .currency(bankAccountRequestDTO.getCurrency())
                .balance(bankAccountRequestDTO.getBalance())
                .build();
        return account;
    }


    public BankAccountResponseDTO bankAccountEntityToDto(BankAccount bankAccount){
        //..
        BankAccountResponseDTO bankAccountResponseDTO =new  BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
