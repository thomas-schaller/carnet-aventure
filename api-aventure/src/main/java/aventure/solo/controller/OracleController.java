package aventure.solo.controller;

import aventure.solo.application.PoserQuestionUseCase;
import aventure.solo.moteur.oracle.model.FateAnswer;
import aventure.solo.moteur.oracle.model.FateQuestion;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class OracleController {
    private final PoserQuestionUseCase usecase;

    public OracleController(PoserQuestionUseCase usecase) {
        this.usecase = usecase;
    }
    @PostMapping("/{id}/oracle")
    public FateAnswer poserQuestion(@PathVariable("id") UUID id, @RequestBody FateQuestion question)
    {
        return usecase.execute(id,question);
    }
}

