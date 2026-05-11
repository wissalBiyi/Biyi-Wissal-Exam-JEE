package ma.biyi.assurance_management.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.biyi.assurance_management.enums.TypeLogement;

@Entity
@DiscriminatorValue("HAB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratHabitation extends Contrat {
    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;
    private String adresse;

    public void setSuperficie(double v) {
    }
}
