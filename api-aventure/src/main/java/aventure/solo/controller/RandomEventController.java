package aventure.solo.controller;

import aventure.solo.application.GenererRandomEventUseCase;
import aventure.solo.moteur.oracle.model.evenement.RandomEvent;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class RandomEventController {

    private final GenererRandomEventUseCase useCase;

    public RandomEventController(GenererRandomEventUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/{id}/random-event")
    public RandomEvent generate(@PathVariable("id") UUID id) {

        return useCase.execute(id);
    }
}
