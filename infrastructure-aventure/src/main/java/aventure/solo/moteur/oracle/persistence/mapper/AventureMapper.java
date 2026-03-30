package aventure.solo.moteur.oracle.persistence.mapper;

import aventure.solo.model.Aventure;
import aventure.solo.model.Objectif;
import aventure.solo.model.Personnage;
import aventure.solo.model.Scene;
import aventure.solo.moteur.oracle.persistence.entity.AventureEntity;
import aventure.solo.moteur.oracle.persistence.entity.ObjectifEntity;
import aventure.solo.moteur.oracle.persistence.entity.PersonnageEntity;
import aventure.solo.moteur.oracle.persistence.entity.SceneEntity;

public class AventureMapper {
    public static AventureEntity toEntity(Aventure aventure) {

        AventureEntity entity = new AventureEntity();
        entity.setId(aventure.getId());
        entity.setTitre(aventure.getTitre());
        entity.setChaosFactor(aventure.getChaosFactor());
        entity.setNotes(aventure.getNotes());

        entity.setScenes(
                aventure.getScenes().stream()
                        .map(scene -> toEntity(scene, entity))
                        .toList()
        );

        entity.setObjectifs(
                aventure.getObjectifs().stream()
                        .map(o -> toEntity(o, entity))
                        .toList()
        );

        entity.setPersonnages(
                aventure.getPersonnages().stream()
                        .map(p -> toEntity(p, entity))
                        .toList()
        );

        return entity;
    }

    public static ObjectifEntity toEntity(Objectif objectif, AventureEntity aventureEntity) {

        ObjectifEntity entity = new ObjectifEntity();
        entity.setDescription(objectif.getDescription());
        entity.setStatut(objectif.getStatut());
        entity.setAventure(aventureEntity);
        return entity;
    }

    public static PersonnageEntity toEntity(Personnage personnage, AventureEntity aventureEntity) {

        PersonnageEntity entity = new PersonnageEntity();
        entity.setName(personnage.getName());
        entity.setDescription(personnage.getDescription());
        entity.setHistorique(personnage.getAllHistorique());
        entity.setAventure(aventureEntity);
        return entity;
    }

    public static SceneEntity toEntity(Scene scene, AventureEntity aventureEntity) {
        SceneEntity entity = new SceneEntity();
        entity.setAventure(aventureEntity);
        entity.setTitre(scene.getTitre());
        entity.setDescription(scene.getDescription());
        entity.setNumero(scene.getNumeroScene());
        return entity;
    }

    public static Aventure toDomain(AventureEntity entity) {

        Aventure aventure = new Aventure( entity.getTitre());
        aventure.setId(entity.getId());
        aventure.setNotes(entity.getNotes());

        entity.getScenes().forEach(s ->
                aventure.ajouterScene(toDomain(s))
        );

        entity.getObjectifs().forEach(o ->
                aventure.ajouterObjectif(toDomain(o))
        );

        entity.getPersonnages().forEach(p ->
                aventure.ajouterPersonnage(toDomain(p))
        );

        return aventure;
    }

    public static Objectif toDomain(ObjectifEntity entity) {
        Objectif objectif = new Objectif(entity.getDescription());
        objectif.setStatut(entity.getStatut());
        return objectif;
    }

    public static Scene toDomain(SceneEntity entity) {
        Scene scene = new Scene(entity.getTitre(),entity.getDescription());
        scene.setNumeroScene(entity.getNumero());
        return scene;
    }

    public static Personnage toDomain(PersonnageEntity entity){
        Personnage personnage = new Personnage(entity.getName(), entity.getDescription());
        entity.getHistorique().forEach(personnage::ajouterHistorique);
        return personnage;
    }

}
