package aventure.solo.model;

import aventure.solo.value.ChaosFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Aventure {
    private UUID id;
    private final String titre;
    private final List<Scene> scenes = new ArrayList<>();
    private final List<Intrigue> intrigues = new ArrayList<>();
    private final List<Groupe> groupes = new ArrayList<>() ;
    String notes;
    private ChaosFactor chaosFactor;
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public Aventure(String titre,int valeurChaos) {

        this.titre = titre;
        chaosFactor = new ChaosFactor(valeurChaos);
    }

    public String getTitre() {
        return titre;
    }



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

    public void ajouterScene(Scene scene) {
        if (!this.scenes.isEmpty()) {
            scene.setNumeroScene(this.scenes.size() + 1);
        }
        this.scenes.add(scene);
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void ajouterGroupe(Groupe groupe) {
        AtomicInteger nbSame= new AtomicInteger();
        this.getGroupes().forEach(groupeExistant -> {if(groupeExistant.equals(groupe)){ nbSame.getAndIncrement();}});
        if (nbSame.get() <3)
        {
            this.getGroupes().add(groupe);
        }
    }

    public List<Intrigue> getObjectifs() {
        return this.intrigues;
    }

    public void ajouterObjectif(Intrigue o) {
        this.intrigues.add(o);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
