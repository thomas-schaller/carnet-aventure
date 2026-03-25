package aventure.solo.application;

import aventure.solo.model.Aventure;
import aventure.solo.model.Scene;import aventure.solo.port.AventureRepository;import java.util.UUID;

public class AjoutSceneUseCase {
    private final AventureRepository aventureRepository;

    public AjoutSceneUseCase(AventureRepository aventure) {
    this.aventureRepository = aventure;
}

    public void execute(UUID aventureId,Scene scene)
    {
        Aventure aventure = aventureRepository.findById(aventureId)
                .orElseThrow(() -> new RuntimeException("Aventure non trouvée"));
        aventure.ajouterScene(scene);
    }
}
