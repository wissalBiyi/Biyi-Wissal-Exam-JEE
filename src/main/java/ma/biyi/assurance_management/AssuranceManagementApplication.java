package ma.biyi.assurance_management;

import ma.biyi.assurance_management.entities.Client;
import ma.biyi.assurance_management.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AssuranceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository) {
		return args -> {
			// Insertion des données correspondant à ta capture d'écran
			Client c1 = new Client();
			c1.setNom("AMIN");
			c1.setEmail("AMIN@gmail.com");
			clientRepository.save(c1);

			Client c2 = new Client();
			c2.setNom("Sara Alaoui");
			c2.setEmail("sara@gmail.com");
			clientRepository.save(c2);

			System.out.println("Données initialisées avec succès !");
		};
	}
}