package aventure.solo.model;

import aventure.solo.value.ChaosFactor;

import java.util.ArrayList;
import java.util.List;

public class Aventure {
    private final String titre;
    private final List<Scene> scenes = new ArrayList<>();
    private final List<Objectif> objectifs = new ArrayList<>();
    private final List<Personnage> personnages = new ArrayList<>() ;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    String notes;

    public Aventure(String titre) {
        this.titre = titre;
    }

    public String getTitre() {
        return titre;
    }

    ChaosFactor chaosFactor = new ChaosFactor(5);

    public int getChaosFactor() {
        return chaosFactor.getValeur();
    }

    public Aventure augmenterChaos()
    {
        chaosFactor = chaosFactor.incrementer();
        return this;
    }

    public Aventure diminuerChaos()
    {
        chaosFactor = chaosFactor.decrementer();
        return this;
    }


    public List<Scene> getScenes() {
        return scenes;
    }

    public void addScene(Scene scene) {
        if (!this.scenes.isEmpty()) {
            scene.setNumeroScene(this.scenes.size() + 1);
        }
        this.scenes.add(scene);
    }

    public List<Personnage> getPersonnages() {
        return personnages;
    }

    public void addPersonnage(Personnage p) {
        this.personnages.add(p);
    }

    public List<Objectif> getObjectifs() {
        return this.objectifs;
    }

    public void addObjectif(Objectif o) {
        this.objectifs.add(o);
    }
}
