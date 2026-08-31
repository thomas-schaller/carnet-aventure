package aventure.solo.moteur.oracle.port;

import aventure.solo.model.Groupe;
import aventure.solo.model.Intrigue;
import aventure.solo.moteur.oracle.model.evenement.RandomEvent;

import java.util.List;

public interface RandomEventGenerator {

    RandomEvent generate(List<Intrigue> intrigues, List<Groupe> groupes);
}
