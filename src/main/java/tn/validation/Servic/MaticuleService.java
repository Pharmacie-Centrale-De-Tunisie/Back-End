package tn.validation.Servic;
import org.springframework.stereotype.Service;
import tn.validation.Entity.Matricule;
import org.springframework.beans.factory.annotation.Autowired;
import tn.validation.Repository.MatriculeRepo;

import java.util.List;

@Service
public class MaticuleService implements Servic<Matricule> {
    @Autowired
    private MatriculeRepo matriculeRepo;
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
}
