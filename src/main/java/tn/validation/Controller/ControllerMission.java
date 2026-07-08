package tn.validation.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.validation.Servic.MissionService;
import tn.validation.Entity.Mission;
import java.util.List;


@RestController
@RequestMapping("/api/mission")
@CrossOrigin(origins = "http://localhost:4200", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
public class ControllerMission {
    private final MissionService MissionService;


    public ControllerMission(MissionService MissionService) {
        this.MissionService = MissionService;
    }

    @GetMapping("/all")
    public List retrieveAll() {
        return MissionService.retrieveAll();
    }
    @PostMapping("/add")
    public Mission add(@RequestBody Mission entity) {
        return MissionService.add(entity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        MissionService.remove(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

}
