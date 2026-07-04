package tn.validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.validation.Entity.Matricule;

import java.util.List;

public interface MatriculeRepo extends JpaRepository<Matricule, Long> {
    @Query("SELECT m FROM Matricule m WHERE m.etat = false")
    List<Matricule> findAvailableMatricule();
}
