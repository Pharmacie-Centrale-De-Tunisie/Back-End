package tn.validation.Entity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("chauffeurDesMatricules")
    private Matricule matricule;


    public String getNomChauffeur() {
        return nomChauffeur;
    }

    public void setNomChauffeur(String nomChauffeur) {
        this.nomChauffeur = nomChauffeur;
    }
    public String getPrenomChauffeur() {
        return prenomChauffeur;
    }
    public void setPrenomChauffeur(String prenomChauffeur) {
        this.prenomChauffeur = prenomChauffeur;
    }
    public String getCin() {
        return Cin;
    }
    public void setCin(String cin) {
        Cin = cin;
    }
    public String getNumeroTelephone() {
        return NumeroTelephone;
    }
    public void setNumeroTelephone(String numeroTelephone) {
        NumeroTelephone = numeroTelephone;
    }
    public boolean getEtatChauffeur() {
        return EtatChauffeur;
    }

    public void setEtatChauffeur(boolean etatChauffeur) {
        EtatChauffeur = etatChauffeur;
    }

    public Long getIdChauffeur() {
        return idChauffeur;
    }

    public void setMatricule(Matricule matricule) {
        this.matricule = matricule;
    }
}
