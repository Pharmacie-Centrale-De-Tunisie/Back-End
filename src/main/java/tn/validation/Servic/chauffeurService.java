package tn.validation.Servic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.validation.Entity.chauffeur;
import tn.validation.Repository.chauffeurRepo;
import tn.validation.Repository.MissionRepo;

import tn.validation.Entity.Mission;

import java.util.List;

@Service
public class chauffeurService implements Servic<chauffeur> {
    @Autowired
    private chauffeurRepo chauffeurRepo;
    @Autowired
    private  MissionRepo missionRepo;
    @Override
    public chauffeur add(chauffeur entity) {
        return chauffeurRepo.save(entity);
    }

    @Override
    public chauffeur retrieve(Long id) {
        return chauffeurRepo.findById(id).orElse(null);
    }

    @Override
    public java.util.List retrieveAll() {
        return chauffeurRepo.findAll();
    }

    @Override
    public void remove(Long id) {
        chauffeurRepo.deleteById(id);
    }
    public List<chauffeur> GetDispo() {
        return chauffeurRepo.findAvailableChauffeur();
    }
    public Mission affecterMissionAChauffeur(Long missionId, Long chauffeurId) {
        Mission mission = missionRepo.findById(missionId)
                .orElseThrow(() -> new RuntimeException("Mission introuvable"));

        chauffeur chauffeur = chauffeurRepo.findById(chauffeurId)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable"));

        mission.setChauffeur(chauffeur);
        chauffeur.setEtatChauffeur(true);
        return missionRepo.save(mission);
    }
    public chauffeur update(chauffeur c, Long id) {
        chauffeur existing = chauffeurRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur non trouvé avec l'id : " + id));

        existing.setNomChauffeur(c.getNomChauffeur());
        existing.setPrenomChauffeur(c.getPrenomChauffeur());
        existing.setCin(c.getCin());
        existing.setNumeroTelephone(c.getNumeroTelephone());

        return chauffeurRepo.save(existing);
    }
    public boolean checkCinExists(String cin) {
        return chauffeurRepo.existsByCin(cin);
    }
}
