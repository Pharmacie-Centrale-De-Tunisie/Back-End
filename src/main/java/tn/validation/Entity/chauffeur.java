package tn.validation.Entity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class chauffeur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idChauffeur; // Clé primaire
    private String nomChauffeur;
    private String prenomChauffeur;
    private String Cin;
    private String NumeroTelephone;
    private boolean EtatChauffeur;
    @OneToMany(mappedBy = "chauffeur")
    @JsonIgnore
    private List<Mission> missions;
    @OneToOne
    private Matricule matricule;

    public boolean getEtatChauffeur() {
        return EtatChauffeur;
    }

    public void setEtatChauffeur(boolean etatChauffeur) {
        EtatChauffeur = etatChauffeur;
    }
}
