package ci.inp.patientMVC;

import ci.inp.patientMVC.Entities.BankAccount;
import ci.inp.patientMVC.Enums.AcountType;
import ci.inp.patientMVC.Repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class PatientMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMvcApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			//..Ajout de bankAccount en utilisant le pattern builder
			for (int i=0;i<20;i++){
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.balance(Math.random()*10000000)
						.createdDate( new Date())
						.type(Math.random()>0.5? AcountType.CURRENT_ACCOUNT:AcountType.SAVING_ACCOUNT)
						.currency("Fcfa")
						.build();
				bankAccountRepository.save(bankAccount);
			}
			System.out.println("*****************");
			bankAccountRepository.findAll().forEach(account->{
				System.out.println(account.getBalance());
			});
		};

	}
}
