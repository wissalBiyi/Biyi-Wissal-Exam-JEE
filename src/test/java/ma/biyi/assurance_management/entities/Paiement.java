package ma.biyi.assurance_management.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.biyi.assurance_management.enums.TypePaiement;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datePaiement;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypePaiement type;

    @ManyToOne
    private Contrat contrat;
}
