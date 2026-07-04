package tn.validation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.validation.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
