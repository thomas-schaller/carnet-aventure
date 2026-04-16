package aventure.solo.controller;

import aventure.solo.application.AjoutSceneUseCase;
import aventure.solo.dto.SceneDTO;
import aventure.solo.mapper.SceneMapper;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class SceneController {

    AjoutSceneUseCase useCase;
    SceneMapper mapper;
    public SceneController(AjoutSceneUseCase useCase, SceneMapper mapper)
    {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping("/{id}/scene")
    public void ajouterScene(@PathVariable("id") UUID id, @RequestBody SceneDTO scene)
    {

        useCase.execute(id,mapper.toDomain(scene));
    }
}
