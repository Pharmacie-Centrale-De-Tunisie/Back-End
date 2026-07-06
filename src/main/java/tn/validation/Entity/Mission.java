package tn.validation.Entity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Mission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMission; // Clé primaire
    private String nomMission;
    private String descriptionMission;
    private String dateDebutMission;
    private String dateFinMission;
    private boolean EtatMission;
    private String destination;
    private String Plan;
    private String product;
    private String type;
    @ManyToOne
    @JoinColumn(name = "Chauffeur") // nom de la colonne FK en base
    @JsonIgnoreProperties("missions") // évite la boucle infinie JSON
    private chauffeur chauffeur;
    public chauffeur getChauffeur() {
        return this.chauffeur;
    }
    public void setChauffeur(chauffeur chauffeur) {
        this.chauffeur = chauffeur;
    }
}

