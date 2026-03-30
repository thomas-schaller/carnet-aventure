package aventure.solo.moteur.oracle.model.evenement;


import aventure.solo.moteur.oracle.model.value.FocusEvenement;

public record RandomEvent(FocusEvenement focus, SignificationEvenement meaning, CibleEvenement cible) {

    @Override
    public String toString() {
        return meaning +" : " + focus+ " " +cible.decrire() ;
    }
}
