package tn.validation.Controller;

import org.springframework.web.bind.annotation.*;
import tn.validation.Entity.Matricule;
import tn.validation.Servic.MaticuleService;

import java.util.List;

@RestController
@RequestMapping("/api/matricule")
public class ControllerMatricule {
    private final MaticuleService matriculeService;
    public ControllerMatricule(MaticuleService matriculeService) {
        this.matriculeService = matriculeService;
    }
    @PostMapping("/add")
    public Matricule addMatricule(@RequestBody Matricule matricule) {
        return matriculeService.add(matricule);
    }
    @GetMapping("/all")
    public List<Matricule> getAllMatricules() {
        return matriculeService.retrieveAll();
    }
    @GetMapping("/{id}")
    public Matricule getMatricule(@PathVariable Long id) {
        return matriculeService.retrieve(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteMatricule(@PathVariable Long id) {
        matriculeService.remove(id);
    }

        @GetMapping("/available")
        public List<Matricule> getAvailableMatricules() {
            return matriculeService.GetDispo();
        }

}
