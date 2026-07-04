package tn.validation.Controller;

import org.springframework.web.bind.annotation.*;
import tn.validation.Servic.MissionService;
import tn.validation.Entity.Mission;
import java.util.List;


@RestController
@RequestMapping("/api/mission")
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
    public void remove(@PathVariable Long id) {
        MissionService.remove(id);
    }

}
