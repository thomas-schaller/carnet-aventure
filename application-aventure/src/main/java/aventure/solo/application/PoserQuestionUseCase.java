package aventure.solo.application;

import aventure.solo.model.Aventure;
import aventure.solo.port.AventureRepository;
import moteur.oracle.model.FateAnswer;
import moteur.oracle.model.FateQuestion;
import moteur.oracle.port.FateOracle;

import java.util.UUID;

public class PoserQuestionUseCase {
    private final AventureRepository aventureRepository;
    private final FateOracle oracle;

    public PoserQuestionUseCase(AventureRepository aventureRepository, FateOracle oracle) {
    this.aventureRepository = aventureRepository;
    this.oracle = oracle;
}

    public FateAnswer execute(UUID aventureId, FateQuestion question) {
    Aventure aventure = aventureRepository.findById(aventureId)
            .orElseThrow(() -> new RuntimeException("Aventure non trouvée"));
       return  oracle.ask(question, aventure.getChaosFactor());
    }
}
