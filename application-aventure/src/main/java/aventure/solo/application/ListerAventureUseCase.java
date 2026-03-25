package aventure.solo.application;

import aventure.solo.model.Aventure;
import aventure.solo.port.AventureRepository;

import java.util.List;

public class ListerAventureUseCase {

    AventureRepository aventureRepository;

    public ListerAventureUseCase(AventureRepository aventureRepository) {
        this.aventureRepository = aventureRepository;
    }

    public List<Aventure> execute(){
        return aventureRepository.list();
    }
}
