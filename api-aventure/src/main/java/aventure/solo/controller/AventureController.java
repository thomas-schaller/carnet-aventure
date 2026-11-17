package aventure.solo.controller;

import aventure.solo.application.CreerAventureUseCase;
import aventure.solo.application.ListerAventureUseCase;
import aventure.solo.application.SupprimerAventureUseCase;
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
    SupprimerAventureUseCase supprimerUseCase;
    private final AventureMapper mapper;

    public AventureController(ListerAventureUseCase listerUseCase, CreerAventureUseCase creerUseCase,SupprimerAventureUseCase supprimerUseCase, AventureMapper mapper) {
        this.listerUseCase = listerUseCase;
        this.creerUseCase = creerUseCase;
        this.supprimerUseCase = supprimerUseCase;
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

    @DeleteMapping("/{id}")
    public boolean supprimerAventure(@PathVariable("id") UUID aventureId){
        log.warning("suppression de l aventure "+aventureId);
        return  supprimerUseCase.execute(aventureId);
    }
}
