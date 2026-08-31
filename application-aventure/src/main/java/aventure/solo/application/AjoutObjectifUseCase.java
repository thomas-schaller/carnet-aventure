package aventure.solo.application;

import aventure.solo.model.Aventure;
import aventure.solo.model.Intrigue;
import aventure.solo.port.AventureRepository;

import java.util.UUID;

public class AjoutObjectifUseCase {
     private final AventureRepository aventureRepository;

    public AjoutObjectifUseCase(AventureRepository aventureRepository) {
        this.aventureRepository = aventureRepository;
    }

    public void execute(UUID aventureId, Intrigue intrigue)
    {
        Aventure aventure = aventureRepository.findById(aventureId)
                .orElseThrow(() -> new RuntimeException("Aventure non trouvée"));
        aventure.ajouterObjectif(intrigue);
    }

}
