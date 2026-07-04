package tn.validation.Entity;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class User implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idUser; // Clé primaire
    private String nomUser;
    private String emailUser;
    private String passwordUser;
}
