package aventure.solo.model;

import java.util.ArrayList;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Personnage that = (Personnage) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
