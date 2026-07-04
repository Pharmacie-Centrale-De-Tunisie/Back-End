package tn.validation.Servic;
import org.springframework.stereotype.Service;
import tn.validation.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import tn.validation.Repository.UserRepo;
@Service
public class user implements Servic<User> {
    @Autowired
    private UserRepo userRepo;

@Override
    public User add(User entity) {
        return userRepo.save(entity);
    }

    @Override
    public User retrieve(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public java.util.List retrieveAll() {
        return userRepo.findAll();
    }

    @Override
    public void remove(Long id) {
        userRepo.deleteById(id);

    }
}
