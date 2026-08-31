package aventure.solo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un personnage que peut rencontrer un joueur
 */
public class PersonnageNonJoueur extends Groupe{


    // La description physique et mental du personnage
    private String description;

    //l'historique du personnage dans l'aventure
    private final List<String> historique = new ArrayList<>();
    public PersonnageNonJoueur(String name, String description) {
        super(name);
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String nouvelleDescription) {
        this.description=nouvelleDescription;
    }

    public String getHistorique() {
        return String.join("\n", historique);
    }

    public List<String> getAllHistorique() {
        return historique;
    }
    public void ajouterHistorique(String event) {
        this.historique.add(event);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
