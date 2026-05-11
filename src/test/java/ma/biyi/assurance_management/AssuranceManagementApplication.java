package ma.biyi.assurance_management;

import ma.biyi.assurance_management.entities.Client;
import ma.biyi.assurance_management.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // Correction de l'import
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@SpringBootApplication
@EntityScan(basePackages = "ma.biyi.assurance_management.entities")
@EnableJpaRepositories(basePackages = "ma.biyi.assurance_management.repositories")
public class AssuranceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository) {
		return args -> {
			// On nettoie la table avant pour éviter les doublons si tu relances
			clientRepository.deleteAll();

			// Création des 3 clients demandés
			Stream.of("Wissal", "Rayan", "Younes").forEach(nom -> {
				Client client = new Client();
				client.setNom(nom);
				client.setEmail(nom.toLowerCase() + "@gmail.com");
				clientRepository.save(client);
			});

			// Vérification dans la console
			System.out.println("------------------------------------");
			clientRepository.findAll().forEach(c -> {
				System.out.println("Client ajouté en base MySQL : " + c.getNom());
			});
			System.out.println("------------------------------------");
		};
	}
}