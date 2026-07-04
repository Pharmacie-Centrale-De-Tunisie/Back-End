package tn.validation.Entity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @JoinColumn(name = "id_chauffeur")
    private chauffeur chauffeur;
}
