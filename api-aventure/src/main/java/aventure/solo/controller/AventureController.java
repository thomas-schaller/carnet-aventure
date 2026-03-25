package aventure.solo.controller;

import aventure.solo.application.CreerAventureUseCase;
import aventure.solo.application.ListerAventureUseCase;
import aventure.solo.model.Aventure;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aventure")
public class AventureController {
    ListerAventureUseCase listerUseCase;
    CreerAventureUseCase creerUseCase;

    public AventureController(ListerAventureUseCase listerUseCase, CreerAventureUseCase creerUseCase) {
        this.listerUseCase = listerUseCase;
        this.creerUseCase = creerUseCase;
    }

    @PostMapping("/creer")
    public void creerAventure(@RequestBody Aventure aventure){
        creerUseCase.execute(aventure);
    }

    @GetMapping("/all")
    public List<Aventure> listerAventure(){
        return listerUseCase.execute();
    }
}
