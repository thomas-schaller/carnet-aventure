package moteur.oracle.port;

import aventure.solo.model.Objectif;
import aventure.solo.model.Personnage;
import moteur.oracle.model.evenement.RandomEvent;

import java.util.List;

public interface RandomEventGenerator {

    RandomEvent generate(List<Objectif> objectifs, List<Personnage> personnage);
}
