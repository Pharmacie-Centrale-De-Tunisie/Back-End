package tn.validation.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.validation.Entity.Matricule;
import tn.validation.Servic.MaticuleService;

import java.util.List;

@RestController
@RequestMapping("/api/matricule")
@CrossOrigin(origins = "http://localhost:4200", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
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
    @PutMapping("/Update/{id}")
    public ResponseEntity<Matricule> update(@RequestBody Matricule m, @PathVariable Long id) {
        Matricule updated = matriculeService.update(m, id);
        return ResponseEntity.ok(updated);
    }
    @PutMapping("/affecterMatriculeToChauffeur/{matriculeId}/{chauffeurId}")
    public void affecterMatriculeToChauffeur(@PathVariable Long matriculeId, @PathVariable Long chauffeurId) {
        matriculeService.affecterMatriculeAChauffeur(matriculeId, chauffeurId);
    }

}
