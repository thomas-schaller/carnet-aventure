package aventure.solo.moteur.oracle.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "aventure")
public class AventureEntity {


    @Id
    @GeneratedValue
    private UUID id;

    private String titre;

    private int chaosFactor;

    @Column(length = 5000)
    private String notes;

    @OneToMany(mappedBy = "aventure", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SceneEntity> scenes = new ArrayList<>();

    @OneToMany(mappedBy = "aventure", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ObjectifEntity> objectifs = new ArrayList<>();

    @OneToMany(mappedBy = "aventure", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonnageEntity> personnages = new ArrayList<>();

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

    public int getChaosFactor() {
        return chaosFactor;
    }

    public void setChaosFactor(int chaosFactor) {
        this.chaosFactor = chaosFactor;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<SceneEntity> getScenes() {
        return scenes;
    }

    public void setScenes(List<SceneEntity> scenes) {
        this.scenes = scenes;
    }

    public List<ObjectifEntity> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(List<ObjectifEntity> objectifs) {
        this.objectifs = objectifs;
    }

    public List<PersonnageEntity> getPersonnages() {
        return personnages;
    }

    public void setPersonnages(List<PersonnageEntity> personnages) {
        this.personnages = personnages;
    }
}
