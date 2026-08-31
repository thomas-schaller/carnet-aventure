package aventure.solo.moteur.oracle.model.evenement;

import aventure.solo.model.Intrigue;

public class CibleIntrigue implements CibleEvenement {
    private final Intrigue intrigue;

    public CibleIntrigue(Intrigue intrigue) {
        this.intrigue = intrigue;
    }

    @Override
    public String decrire() {
        return "sur "+ intrigue.getDescription();
    }
}
