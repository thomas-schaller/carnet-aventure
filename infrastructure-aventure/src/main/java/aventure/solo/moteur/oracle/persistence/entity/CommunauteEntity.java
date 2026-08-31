package aventure.solo.moteur.oracle.persistence.entity;

import aventure.solo.value.TailleCommunaute;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "communaute")
public class CommunauteEntity {
    @Id
    @GeneratedValue
    private UUID id;
    String nom;
    private TailleCommunaute taille;
    @OneToOne
    private PersonnageEntity dirigeant;

    @OneToMany
    private List<PersonnageEntity> individusNotables = new ArrayList<>();
    private String calamiteActuelle;
    private String traitsDistinctifs;
    private String estCelebrePour;
    private String lieuxInteret;
    @ManyToOne
    @JoinColumn(name = "aventure_id")
    private AventureEntity aventure;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TailleCommunaute getTaille() {
        return taille;
    }

    public void setTaille(TailleCommunaute taille) {
        this.taille = taille;
    }

    public PersonnageEntity getDirigeant() {
        return dirigeant;
    }

    public void setDirigeant(PersonnageEntity dirigeant) {
        this.dirigeant = dirigeant;
    }

    public List<PersonnageEntity> getIndividusNotables() {
        return individusNotables;
    }

    public void setIndividusNotables(List<PersonnageEntity> individusNotables) {
        this.individusNotables = individusNotables;
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

    public AventureEntity getAventure() {
        return aventure;
    }

    public void setAventure(AventureEntity aventure) {
        this.aventure = aventure;
    }
}
