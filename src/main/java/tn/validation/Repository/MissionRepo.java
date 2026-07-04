package tn.validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.validation.Entity.Mission;

public interface MissionRepo extends JpaRepository<Mission, Long> {
}
