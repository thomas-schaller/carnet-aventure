package aventure.solo.controller;

import aventure.solo.application.PoserQuestionUseCase;
import moteur.oracle.model.FateAnswer;
import moteur.oracle.model.FateQuestion;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class OracleController {
    private PoserQuestionUseCase usecase;

    public OracleController(PoserQuestionUseCase usecase) {
        this.usecase = usecase;
    }
    @PostMapping("/{id}/oracle")
    public FateAnswer poserQuestion(@PathVariable UUID id, @RequestBody FateQuestion question)
    {
        return usecase.execute(id,question);
    }
}

