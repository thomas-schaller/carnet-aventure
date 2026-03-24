package moteur.oracle.model.evenement;

import aventure.solo.model.Personnage;

public class CiblePersonnage implements CibleEvenement {
    private final Personnage personnage;

    public CiblePersonnage(Personnage personnageCible) {
        this.personnage = personnageCible;
    }

    @Override
    public String decrire() {
        return "sur "+personnage.getName();
    }
}
