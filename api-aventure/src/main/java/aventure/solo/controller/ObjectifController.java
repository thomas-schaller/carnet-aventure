package aventure.solo.controller;

import aventure.solo.application.AjoutObjectifUseCase;
import aventure.solo.dto.ObjectifDTO;

import aventure.solo.mapper.ObjectifMapper;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class ObjectifController {
    private final ObjectifMapper mapper;
    AjoutObjectifUseCase useCase;

    public ObjectifController(AjoutObjectifUseCase useCase,ObjectifMapper mapper) {
        this.useCase = useCase;
        this.mapper =mapper;
    }

    @PostMapping("/{id}/objectif")
    public void ajouterObjectif(@PathVariable("id") UUID id,@RequestBody ObjectifDTO objectif)
    {
        useCase.execute(id,mapper.toDomain(objectif));
    }
}
