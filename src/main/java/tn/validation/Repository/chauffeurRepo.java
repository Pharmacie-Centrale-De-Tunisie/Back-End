package tn.validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.validation.Entity.chauffeur;

import java.util.List;

public interface chauffeurRepo extends JpaRepository<chauffeur, Long> {
    @Query("SELECT c FROM chauffeur c WHERE c.EtatChauffeur = false")
    List<chauffeur> findAvailableChauffeur();
}
