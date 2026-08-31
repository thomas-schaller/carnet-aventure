package aventure.solo.model;

import java.util.Objects;

public class Groupe {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Groupe groupe = (Groupe) o;
        return Objects.equals(getNom(), groupe.getNom());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNom());
    }

    private final String nom;

    public Groupe(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }


}
