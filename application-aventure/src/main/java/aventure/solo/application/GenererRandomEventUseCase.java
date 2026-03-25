package aventure.solo.application;

import aventure.solo.model.Aventure;
import aventure.solo.port.AventureRepository;
import moteur.oracle.model.evenement.RandomEvent;
import moteur.oracle.port.RandomEventGenerator;

import java.util.UUID;

/**
 *  Cas d'usage : générer un événement
 */
public class GenererRandomEventUseCase {

    private final AventureRepository aventureRepository;
    private final RandomEventGenerator eventGenerator;

    public GenererRandomEventUseCase(
           AventureRepository aventureRepository,
            RandomEventGenerator eventGenerator
    ) {
        this.aventureRepository = aventureRepository;
        this.eventGenerator = eventGenerator;
    }

    public RandomEvent execute(UUID aventureId) {
        Aventure aventure = aventureRepository.findById(aventureId)
                .orElseThrow(() -> new RuntimeException("Aventure non trouvée"));
        return eventGenerator.generate(
                aventure.getObjectifs(),
                aventure.getPersonnages()
        );
    }
}
