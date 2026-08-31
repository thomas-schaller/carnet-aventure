package aventure.solo.model;

import aventure.solo.value.StatutIntrigue;

/**
 * Un objectif est la quête, la tache et la mission que le joueur personnage souhaite poursuivre,
 * Un objectif possède une description et un état.
 */
public class Intrigue {
    String description;
    StatutIntrigue statut = StatutIntrigue.ACTIVE;

    public Intrigue(String description) {
        this.description = description;
    }

    public void setStatut(StatutIntrigue statut){
        this.statut=statut;
    }
    public String getDescription() {
        return description;
    }

    public StatutIntrigue getStatut() {
        return this.statut;
    }

    public void echouer() {
        statut = StatutIntrigue.FAILED;
    }

    public void terminer() {
        statut = StatutIntrigue.RESOLVED;
    }
}
