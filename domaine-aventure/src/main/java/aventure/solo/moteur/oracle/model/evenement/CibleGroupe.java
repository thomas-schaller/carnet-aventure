package aventure.solo.moteur.oracle.model.evenement;

import aventure.solo.model.Groupe;

public class CibleGroupe implements CibleEvenement {
    private final Groupe groupe;

    public CibleGroupe(Groupe groupeCible) {
        this.groupe = groupeCible;
    }

    @Override
    public String decrire() {
        return "sur "+ groupe.getNom();
    }
}
