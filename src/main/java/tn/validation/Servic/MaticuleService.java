package tn.validation.Servic;
import org.springframework.stereotype.Service;
import tn.validation.Entity.Matricule;
import org.springframework.beans.factory.annotation.Autowired;
import tn.validation.Repository.MatriculeRepo;
import tn.validation.Entity.chauffeur;
import java.util.List;

@Service
public class MaticuleService implements Servic<Matricule> {
    @Autowired
    private MatriculeRepo matriculeRepo;
    @Autowired
    private tn.validation.Repository.chauffeurRepo chauffeurRepo;

    @Override
    public Matricule add(Matricule entity) {
        return matriculeRepo.save(entity);
    }

    @Override
    public Matricule retrieve(Long id) {
        return matriculeRepo.findById(id).orElse(null);
    }

    @Override
    public List<Matricule> retrieveAll() {
        return matriculeRepo.findAll();
    }

    @Override
    public void remove(Long id) {
        matriculeRepo.deleteById(id);

    }

    public List<Matricule> GetDispo() {
        return matriculeRepo.findAvailableMatricule();
   }
    public Matricule update(Matricule m, Long id) {
        Matricule existing = matriculeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricule non trouvé avec l'id : " + id));

        existing.setMatricule(m.getMatricule());
        existing.setCodeSerie(m.getCodeSerie());
        existing.setEtat(m.getetat());
        existing.setChauffeurDesMatricules(m.getChauffeurDesMatricules());

        return matriculeRepo.save(existing);
    }

    public void affecterMatriculeAChauffeur(Long matriculeId, Long chauffeurId) {
        Matricule matricule = matriculeRepo.findById(matriculeId)
                .orElseThrow(() -> new RuntimeException("Matricule introuvable"));

        chauffeur chauffeurEntity = chauffeurRepo.findById(chauffeurId)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable"));

        if (matricule.getetat()) {
            // etat == true => déjà affecté
            throw new RuntimeException("Le matricule est déjà affecté à un chauffeur.");
        }

        chauffeurEntity.setMatricule(matricule);
        matricule.setChauffeurDesMatricules(chauffeurEntity);
        matricule.setEtat(true); // passe à "Utilisé"

        chauffeurRepo.save(chauffeurEntity);
        matriculeRepo.save(matricule); // ⚠️ indispensable, sinon l'état n'est pas persisté
    }
}


