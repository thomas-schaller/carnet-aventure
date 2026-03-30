package aventure.solo.moteur.oracle.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "personnage")
public class PersonnageEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @Column(length = 2000)
    private String description;

    @ElementCollection
    @CollectionTable(name = "personnage_historique")
    private List<String> historique = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "aventure_id")
    private AventureEntity aventure;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getHistorique() {
        return historique;
    }

    public void setHistorique(List<String> historique) {
        this.historique = historique;
    }

    public AventureEntity getAventure() {
        return aventure;
    }

    public void setAventure(AventureEntity aventure) {
        this.aventure = aventure;
    }
}