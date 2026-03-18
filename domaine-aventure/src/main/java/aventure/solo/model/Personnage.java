package aventure.solo.model;

import java.util.ArrayList;

public class Personnage {

    // le nom du Personnage
    private final String name;

    // La description physique et mental du personnage
    private String description;

    //l'historique du personnage dans l'aventure
    private final ArrayList<String> historique = new ArrayList<>();
    public Personnage(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
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

    public void ajouterHistorique(String event) {
        this.historique.add(event);
    }
}
