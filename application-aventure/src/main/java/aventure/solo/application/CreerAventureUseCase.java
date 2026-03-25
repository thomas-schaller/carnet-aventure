package aventure.solo.application;

import aventure.solo.model.Aventure;
import aventure.solo.port.AventureRepository;

import java.util.UUID;

public class CreerAventureUseCase {

    private final AventureRepository aventureRepository;

    public CreerAventureUseCase(AventureRepository aventureRepository) {
        this.aventureRepository = aventureRepository;
    }

    public UUID execute(Aventure aventure)
    {
        return aventureRepository.save(aventure);
    }
}
