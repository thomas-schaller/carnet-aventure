package aventure.solo.application;

import aventure.solo.model.Aventure;
import aventure.solo.model.Personnage;
import aventure.solo.port.AventureRepository;

import java.util.UUID;

public class AjoutPersonnageUseCase {
     private final AventureRepository aventureRepository;

    public AjoutPersonnageUseCase(AventureRepository aventureRepository) {
        this.aventureRepository = aventureRepository;
    }

    public void execute(UUID aventureId, Personnage personnage)
    {
        Aventure aventure = aventureRepository.findById(aventureId)
                .orElseThrow(() -> new RuntimeException("Aventure non trouvée"));
        aventure.addPersonnage(personnage);
    }

}
