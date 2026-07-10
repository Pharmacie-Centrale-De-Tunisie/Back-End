package tn.validation.Controller;

import org.springframework.web.bind.annotation.*;
import tn.validation.Entity.chauffeur;
import tn.validation.Servic.chauffeurService;

import java.util.List;

@RestController
@RequestMapping("/api/chauffeur")
@CrossOrigin(origins = "http://localhost:4200", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE
})
public class ChauffeurController {

    private final chauffeurService chauffeurService;

    public ChauffeurController(chauffeurService chauffeurService) {
        this.chauffeurService = chauffeurService;
    }

    @PostMapping("/add")
    public chauffeur addChauffeur(@RequestBody chauffeur chauffeur) {
        return chauffeurService.add(chauffeur);
    }

    @GetMapping("/{id}")
    public chauffeur getChauffeur(@PathVariable Long id) {
        return chauffeurService.retrieve(id);
    }

    @GetMapping("/all")
    public List<chauffeur> getAllChauffeurs() {
        return chauffeurService.retrieveAll();
    }

    @DeleteMapping("/{id}")
    public void deleteChauffeur(@PathVariable Long id) {
        chauffeurService.remove(id);
    }


    @GetMapping("/available")
    public List<chauffeur> getAvailableChauffeurs() {
        return chauffeurService.GetDispo();

    }


    @PutMapping("/affecterMission/{missionId}/{chauffeurId}")
    public void affecterMissionAChauffeur(@PathVariable Long missionId, @PathVariable Long chauffeurId) {
        chauffeurService.affecterMissionAChauffeur(missionId, chauffeurId);
    }


    @GetMapping("/update/{id}")
    public chauffeur updateChauffeur(@RequestBody chauffeur c, @PathVariable Long id)
    {
        return chauffeurService.update(c, id);
    }


    @GetMapping("/check/{cin}")
    public boolean checkCinExists(@PathVariable String cin) {
        return chauffeurService.checkCinExists(cin);
    }



}