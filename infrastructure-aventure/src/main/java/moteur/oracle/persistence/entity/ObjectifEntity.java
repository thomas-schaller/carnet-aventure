package moteur.oracle.persistence.entity;

import aventure.solo.value.StatutObjectif;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "objectif")
public class ObjectifEntity {

    @Id
    private UUID id;

    private String description;

    @Enumerated(EnumType.STRING)
    private StatutObjectif statut;

    @ManyToOne
    @JoinColumn(name = "aventure_id")
    private AventureEntity aventure;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutObjectif getStatut() {
        return statut;
    }

    public void setStatut(StatutObjectif statut) {
        this.statut = statut;
    }

    public AventureEntity getAventure() {
        return aventure;
    }

    public void setAventure(AventureEntity aventure) {
        this.aventure = aventure;
    }
}
