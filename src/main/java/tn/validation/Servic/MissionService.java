package tn.validation.Servic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.validation.Entity.Mission;
import tn.validation.Repository.MissionRepo;


@Service
public class MissionService implements Servic<Mission> {
    @Autowired
    private MissionRepo missionRepo;
    @Override
    public Mission add(Mission entity) {
        return missionRepo.save(entity);
    }

    @Override
    public Mission retrieve(Long id) {
        return missionRepo.findById(id).orElse(null);
    }

    @Override
    public java.util.List retrieveAll() {
        return missionRepo.findAll();
    }

    @Override
    public void remove(Long id) {
        missionRepo.deleteById(id);

    }

}
