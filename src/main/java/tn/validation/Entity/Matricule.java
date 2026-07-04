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

public class Matricule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMatricule; // Clé primaire
    private String matricule;
    private String CodeSerie;
    private boolean etat;
    @OneToOne(mappedBy = "matricule")
    private chauffeur chauffeurDesMatricules;
}
