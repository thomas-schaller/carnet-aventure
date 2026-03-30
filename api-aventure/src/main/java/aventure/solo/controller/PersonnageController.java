package aventure.solo.controller;

import aventure.solo.application.AjoutPersonnageUseCase;
import aventure.solo.model.Personnage;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class PersonnageController {
    AjoutPersonnageUseCase usecase;

    public PersonnageController(AjoutPersonnageUseCase usecase) {
        this.usecase = usecase;
    }

    @PostMapping("/{id}/personnage")
    public void ajouterPersonnage(@PathVariable("id") UUID id, @RequestBody Personnage personnage)
    {
        usecase.execute(id,personnage);
    }

}
