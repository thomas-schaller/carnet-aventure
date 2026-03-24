package aventure.solo.model;

import aventure.solo.value.StatutObjectif;

/**
 * Un objectif est la quête, la tache et la mission que le joueur personnage souhaite poursuivre,
 * Un objectif possède une description et un état.
 */
public class Objectif {
    String description;
    StatutObjectif statut = StatutObjectif.ACTIVE;

    public Objectif(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public StatutObjectif getStatut() {
        return this.statut;
    }

    public void echouer() {
        statut = StatutObjectif.FAILED;
    }

    public void terminer() {
        statut = StatutObjectif.RESOLVED;
    }
}
