package aventure.solo.moteur.oracle.port;

import aventure.solo.model.Objectif;
import aventure.solo.model.Personnage;
import aventure.solo.moteur.oracle.model.evenement.RandomEvent;

import java.util.List;

public interface RandomEventGenerator {

    RandomEvent generate(List<Objectif> objectifs, List<Personnage> personnage);
}
