package tn.validation.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import tn.validation.Entity.User;
import tn.validation.Servic.user;

@RestController
@RequestMapping("/api/user")
public class ControllerUser {
    private final user userService;
    public ControllerUser(user userService) {
        this.userService = userService;
    }
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.retrieve(id);
    }
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.retrieveAll();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.remove(id);
    }

}
