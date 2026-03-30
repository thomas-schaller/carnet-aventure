package aventure.solo.controller;

import aventure.solo.application.AjoutSceneUseCase;
import aventure.solo.model.Scene;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class SceneController {

    AjoutSceneUseCase useCase;

    public SceneController(AjoutSceneUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/{id}/scene")
    public void ajouterScene(@PathVariable("id") UUID id, @RequestBody Scene scene)
    {
        useCase.execute(id,scene);
    }
}
