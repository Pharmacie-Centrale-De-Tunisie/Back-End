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
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Matricule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMatricule; // Clé primaire
    private String matricule;
    private String CodeSerie;
    private boolean etat;
    @OneToOne(mappedBy = "matricule")
    @JsonIgnoreProperties("matricule")
    private chauffeur chauffeurDesMatricules;

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getCodeSerie() {
        return CodeSerie;
    }
    public void setCodeSerie(String CodeSerie) {
        this.CodeSerie = CodeSerie;
    }
    public boolean getetat() {
        return etat;
    }
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public chauffeur getChauffeurDesMatricules() {
        return chauffeurDesMatricules;
    }

    public void setChauffeurDesMatricules(chauffeur chauffeurDesMatricules) {
        this.chauffeurDesMatricules = chauffeurDesMatricules;
    }
}
