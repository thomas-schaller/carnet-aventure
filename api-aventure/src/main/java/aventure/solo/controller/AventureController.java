package aventure.solo.controller;

import aventure.solo.application.CreerAventureUseCase;
import aventure.solo.application.ListerAventureUseCase;
import aventure.solo.dto.AventureDTO;
import aventure.solo.mapper.AventureMapper;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aventure")
@Log
public class AventureController {
    ListerAventureUseCase listerUseCase;
    CreerAventureUseCase creerUseCase;
    private final AventureMapper mapper;

    public AventureController(ListerAventureUseCase listerUseCase, CreerAventureUseCase creerUseCase,AventureMapper mapper) {
        this.listerUseCase = listerUseCase;
        this.creerUseCase = creerUseCase;
        this.mapper=mapper;
    }

    @PostMapping("/creer")
    public UUID creerAventure(@RequestBody AventureDTO aventure){
        return creerUseCase.execute(mapper.toDomain(aventure));
    }

    @GetMapping("/all")
    public List<AventureDTO> listerAventure(){
        List<AventureDTO> result = new ArrayList<>();
        listerUseCase.execute().forEach(a -> result.add(mapper.toDTO(a)));
        return result;
    }
}
