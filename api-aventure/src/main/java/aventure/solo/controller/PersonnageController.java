package aventure.solo.controller;

import aventure.solo.application.AjoutPersonnageUseCase;
import aventure.solo.dto.PersonnageDTO;
import aventure.solo.mapper.PersonnageMapper;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/aventure")
public class PersonnageController {
    AjoutPersonnageUseCase usecase;
    PersonnageMapper mapper;

    public PersonnageController(AjoutPersonnageUseCase usecase,PersonnageMapper mapper)
    {
        this.usecase = usecase;
        this.mapper=mapper;
    }

    @PostMapping("/{id}/personnage")
    public void ajouterPersonnage(@PathVariable("id") UUID id, @RequestBody PersonnageDTO personnage)
    {
        usecase.execute(id,mapper.toDomain(personnage));
    }

}
