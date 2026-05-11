package ma.biyi.assurance_management.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // OBLIGATOIRE
@DiscriminatorColumn(name = "TYPE", length = 10)      // OBLIGATOIRE
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Contrat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateSouscription;
    private String statut; // Utilise String pour aller plus vite que les Enum
    private double montantCotisation;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "contrat")
    private Collection<Paiement> paiements;
}