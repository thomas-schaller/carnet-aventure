package aventure.solo.model;

import aventure.solo.value.TailleCommunaute;

import java.util.ArrayList;
import java.util.List;

public class Communaute extends Groupe{
        private final TailleCommunaute taille;
    private PersonnageNonJoueur dirigeant;
    private final List<PersonnageNonJoueur> individusNotables = new ArrayList<>();
    private String calamiteActuelle;
    private String traitsDistinctifs;
    private String estCelebrePour;
    private String lieuxInteret;



    public TailleCommunaute getTaille() {
        return taille;
    }

    public Communaute(String nom, TailleCommunaute taille) {
       super(nom);
        this.taille = taille;
    }

    public PersonnageNonJoueur getDirigeant() {
        return dirigeant;
    }

    public void setDirigeant(PersonnageNonJoueur dirigeant) {
        this.dirigeant = dirigeant;
    }

    public List<PersonnageNonJoueur> getIndividusNotables() {
        return individusNotables;
    }

    public void ajouterIndividuNotable(PersonnageNonJoueur individuNotable) {
        this.individusNotables.add(individuNotable);
    }

    public String getCalamiteActuelle() {
        return calamiteActuelle;
    }

    public void setCalamiteActuelle(String calamiteActuelle) {
        this.calamiteActuelle = calamiteActuelle;
    }

    public String getTraitsDistinctifs() {
        return traitsDistinctifs;
    }

    public void setTraitsDistinctifs(String traitsDistinctifs) {
        this.traitsDistinctifs = traitsDistinctifs;
    }

    public String getEstCelebrePour() {
        return estCelebrePour;
    }

    public void setEstCelebrePour(String estCelebrePour) {
        this.estCelebrePour = estCelebrePour;
    }

    public String getLieuxInteret() {
        return lieuxInteret;
    }

    public void setLieuxInteret(String lieuxInteret) {
        this.lieuxInteret = lieuxInteret;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

}
