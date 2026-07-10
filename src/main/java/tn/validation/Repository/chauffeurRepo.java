package tn.validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.validation.Entity.chauffeur;

import java.util.List;

public interface chauffeurRepo extends JpaRepository<chauffeur, Long> {
    @Query("SELECT c FROM chauffeur c WHERE c.EtatChauffeur = false")
    List<chauffeur> findAvailableChauffeur();
    chauffeur findByIdChauffeur(Long idChauffeur);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM chauffeur c WHERE c.Cin = :cin")
    boolean existsByCin(@Param("cin") String cin);
}
