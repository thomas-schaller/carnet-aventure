package aventure.solo.moteur.oracle.persistence.mapper;

import aventure.solo.model.*;
import aventure.solo.moteur.oracle.persistence.entity.*;

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
                aventure.getGroupes().stream()
                        .filter(PersonnageNonJoueur.class::isInstance)
                        .map(PersonnageNonJoueur.class::cast)
                        .map( p -> toEntity(p, entity))
                        .toList()
        );

        entity.setCommunautes(
                aventure.getGroupes().stream()
                        .filter(Communaute.class::isInstance)
                        .map(Communaute.class::cast)
                        .map(c -> toEntity(c,entity))
                        .toList()
        );
        return entity;
    }

    public static ObjectifEntity toEntity(Intrigue intrigue, AventureEntity aventureEntity) {

        ObjectifEntity entity = new ObjectifEntity();
        entity.setDescription(intrigue.getDescription());
        entity.setStatut(intrigue.getStatut());
        entity.setAventure(aventureEntity);
        return entity;
    }

    public static PersonnageEntity toEntity(PersonnageNonJoueur personnageNonJoueur, AventureEntity aventureEntity) {

        PersonnageEntity entity = new PersonnageEntity();
        entity.setName(personnageNonJoueur.getNom());
        entity.setDescription(personnageNonJoueur.getDescription());
        entity.setHistorique(personnageNonJoueur.getAllHistorique());
        entity.setAventure(aventureEntity);
        return entity;
    }

    public static CommunauteEntity toEntity(Communaute communaute, AventureEntity aventureEntity) {

        CommunauteEntity entity = new CommunauteEntity();
        entity.setNom(communaute.getNom());
        entity.setTaille(communaute.getTaille());
        entity.setCalamiteActuelle(communaute.getCalamiteActuelle());
        entity.setEstCelebrePour(communaute.getEstCelebrePour());
        entity.setLieuxInteret(communaute.getLieuxInteret());
        entity.setTraitsDistinctifs(communaute.getTraitsDistinctifs());
        entity.setDirigeant(toEntity(communaute.getDirigeant(),null));
        entity.setIndividusNotables(
                communaute.getIndividusNotables().stream()
                        .map( p -> toEntity(p,null)).toList()
        );
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

        Aventure aventure = new Aventure( entity.getTitre(), entity.getChaosFactor());
        aventure.setId(entity.getId());
        aventure.setNotes(entity.getNotes());

        entity.getScenes().forEach(s ->
                aventure.ajouterScene(toDomain(s))
        );

        entity.getObjectifs().forEach(o ->
                aventure.ajouterObjectif(toDomain(o))
        );

        entity.getPersonnages().forEach(p ->
                aventure.ajouterGroupe(toDomain(p))
        );

        return aventure;
    }

    public static Intrigue toDomain(ObjectifEntity entity) {
        Intrigue intrigue = new Intrigue(entity.getDescription());
        intrigue.setStatut(entity.getStatut());
        return intrigue;
    }

    public static Scene toDomain(SceneEntity entity) {
        Scene scene = new Scene(entity.getTitre(),entity.getDescription());
        scene.setNumeroScene(entity.getNumero());
        return scene;
    }

    public static PersonnageNonJoueur toDomain(PersonnageEntity entity){
        PersonnageNonJoueur personnageNonJoueur = new PersonnageNonJoueur(entity.getName(), entity.getDescription());
        entity.getHistorique().forEach(personnageNonJoueur::ajouterHistorique);
        return personnageNonJoueur;
    }
    public static Communaute toDomain(CommunauteEntity entity){
        Communaute communaute = new Communaute(entity.getNom(),entity.getTaille());
        communaute.setTraitsDistinctifs(entity.getTraitsDistinctifs());
        communaute.setLieuxInteret(entity.getLieuxInteret());
        communaute.setEstCelebrePour(entity.getEstCelebrePour());
        communaute.setDirigeant(toDomain(entity.getDirigeant()));
        entity.getIndividusNotables().forEach(i -> communaute.ajouterIndividuNotable(toDomain(i)));
        communaute.setCalamiteActuelle(entity.getCalamiteActuelle());
        return communaute;
    }

}
