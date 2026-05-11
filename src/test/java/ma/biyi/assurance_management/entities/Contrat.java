package ma.biyi.assurance_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.biyi.assurance_management.enums.StatutContrat;

import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CONTRAT", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Contrat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateSouscription;
    @Enumerated(EnumType.STRING)
    private StatutContrat statut;
    private Date dateValidation;
    private double montantCotisation;
    private int dureeContrat;
    private double tauxCouverture;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "contrat")
    private Collection<Paiement> paiements;
}
