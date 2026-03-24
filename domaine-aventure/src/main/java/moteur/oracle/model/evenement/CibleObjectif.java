package moteur.oracle.model.evenement;

import aventure.solo.model.Objectif;

public class CibleObjectif implements CibleEvenement {
    private final Objectif objectif;

    public CibleObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    @Override
    public String decrire() {
        return "sur "+ objectif.getDescription();
    }
}
