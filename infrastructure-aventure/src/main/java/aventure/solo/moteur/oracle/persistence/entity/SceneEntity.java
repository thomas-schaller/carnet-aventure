package aventure.solo.moteur.oracle.persistence.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "scene")
public class SceneEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String titre;

    @Column(length = 2000)
    private String description;

    private int numero;

    @ManyToOne
    @JoinColumn(name = "aventure_id")
    private AventureEntity aventure;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public AventureEntity getAventure() {
        return aventure;
    }

    public void setAventure(AventureEntity aventure) {
        this.aventure = aventure;
    }
}