package aventure.solo.controller;

import aventure.solo.application.AjoutObjectifUseCase;
import aventure.solo.model.Objectif;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class ObjectifController {

    AjoutObjectifUseCase useCase;

    public ObjectifController(AjoutObjectifUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/{id}/objectif")
    public void ajouterObjectif(@PathVariable("id") UUID id,@RequestBody Objectif objectif)
    {
        useCase.execute(id,objectif);
    }
}
