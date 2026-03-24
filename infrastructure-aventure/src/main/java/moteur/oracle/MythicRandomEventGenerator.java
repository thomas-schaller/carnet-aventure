package moteur.oracle;

import aventure.solo.model.Objectif;
import aventure.solo.model.Personnage;
import aventure.solo.value.StatutObjectif;
import fr.schaller.wordgenerator.infrastructure.spring.controller.WordController;
import moteur.oracle.model.evenement.*;
import moteur.oracle.model.value.FocusEvenement;
import moteur.oracle.port.RandomEventGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MythicRandomEventGenerator implements RandomEventGenerator {
    private final Random random = new Random();

    WordController wordController;
    public MythicRandomEventGenerator(@Autowired WordController wordController) {
        this.wordController=wordController;
    }

    @Override
    public RandomEvent generate(List<Objectif> objectifs, List<Personnage> personnages) {

        FocusEvenement focus = genererFocus(objectifs, personnages);
        SignificationEvenement signification = genererSignification(focus);
        CibleEvenement cible = genererCibleEvenement( focus, objectifs, personnages);


        return new RandomEvent(focus, signification,cible);
    }

    private CibleEvenement genererCibleEvenement(FocusEvenement focus, List<Objectif> objectifs, List<Personnage> personnages) {
        return switch (focus) {
            case NPC_ACTION,
                 NPC_NEGATIVE,
                 NPC_POSITIVE,
                 REMOTE_EVENT -> new CiblePersonnage(aleatoirePersonnage(personnages));
            case MOVE_AWAY_FROM_THREAD,
                 MOVE_TOWARD_THREAD,
                 CLOSE_THREAD -> new CibleObjectif(aleatoireObjectif(objectifs));
            default -> new CibleVide();
        };
    }

    private SignificationEvenement genererSignification(FocusEvenement focus) {
        String word1,word2;
        if (focus.equals(FocusEvenement.INTRODUCE_NEW_NPC)) {
            word1 = wordController.generate("description1");
            word2 = wordController.generate("description2");
        }
        else {
            word1 = wordController.generate("action1");
            word2 = wordController.generate("action2");
        }
        return new SignificationEvenement(word1,word2);
    }

    private FocusEvenement genererFocus(List<Objectif> objectifs, List<Personnage> personnages) {
        int roll = d100();

        if (roll <= 5) return FocusEvenement.REMOTE_EVENT;
        if (roll <= 10) return FocusEvenement.AMBIGUOUS_EVENT;
        if (roll <= 20) return FocusEvenement.INTRODUCE_NEW_NPC;
        if (roll <= 40) return FocusEvenement.NPC_ACTION;
        if (roll <= 45) return FocusEvenement.NPC_NEGATIVE;
        if (roll <= 50) return FocusEvenement.NPC_POSITIVE;
        if (roll <= 55) return FocusEvenement.MOVE_TOWARD_THREAD;
        if (roll <= 65) return FocusEvenement.MOVE_AWAY_FROM_THREAD;
        if (roll <= 70) return FocusEvenement.CLOSE_THREAD;
        if (roll <= 80) return FocusEvenement.PC_NEGATIVE;
        if (roll <= 85) return FocusEvenement.PC_POSITIVE;

        return FocusEvenement.CURRENT_CONTEXT;
    }

    private int d100() {
        return random.nextInt(100) + 1;
    }

    private Personnage aleatoirePersonnage(List<Personnage> personnages){
        return personnages.get(random.nextInt(personnages.size()));
    }

    private Objectif aleatoireObjectif(List<Objectif> objectifs){
        return objectifs.stream().filter( o-> o.getStatut() == StatutObjectif.ACTIVE).toList().get(random.nextInt(objectifs.size()));
    }
}
