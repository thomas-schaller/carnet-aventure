package aventure.solo.model;

import aventure.solo.value.TailleCommunaute;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AventureTest {

    private final String titre = "L'épopée de Silas";
    private Aventure a ;
    @BeforeEach
    void initAventure()
    {
        int defaultChaosValue = 5;
        a = new Aventure(titre, defaultChaosValue);
    }

    /**
    * A sa création une aventure doit avoir :
     * - un titre
     * - un facteur de chaos à 5
     * - aucune scene
     * - aucun personnage
     * - aucune communaute
     * - aucun objectif
    */
    @Test
    void testInitAventure()
    {
               Assertions.assertEquals(titre, a.getTitre());
        Assertions.assertEquals(5, a.getChaosFactor());
        Assertions.assertTrue(a.getScenes().isEmpty());
        Assertions.assertTrue(a.getGroupes().isEmpty());
        Assertions.assertTrue(a.getObjectifs().isEmpty());
    }

    // On doit pouvoir diminuer le facteur de chaos de 1.
    @Test
    void testDiminuerFacteurChaos() {
        a.diminuerChaos();
        Assertions.assertEquals(4, a.getChaosFactor());
    }

    //  Il n'est pas possible d'avoir un facteur en dessous de 1;
    @Test
    void testMinValueFacteurChaos()
    {
        a.diminuerChaos().diminuerChaos().diminuerChaos().diminuerChaos().diminuerChaos().diminuerChaos();
        Assertions.assertEquals(1, a.getChaosFactor());
    }

    /** On doit pouvoir augmenter le facteur de chaos de 1.
     *
     */
    @Test
    void testAugmenterFacteurChaos() {
        a.augmenterChaos();
        Assertions.assertEquals(6, a.getChaosFactor());
    }

    /**  Il n'est pas possible d'avoir un facteur de chaos au dessus de 9;
     *
     */
    @Test
    void testMaxValueFacteurChaos()
    {
        a.augmenterChaos().augmenterChaos().augmenterChaos().augmenterChaos().augmenterChaos().augmenterChaos().augmenterChaos();
        Assertions.assertEquals(9, a.getChaosFactor());
    }

    /**une note descriptive peut être ajoutée à une aventure
     *
     */
    @Test
    void testNotesAventure()
    {

        String notes = "le début des aventures du personnage Silas";
        a.setNotes(notes);
        Assertions.assertEquals(notes,a.getNotes());

    }

    /**
     * une scene peut être ajoutée à une aventure
     * La première scene a comme numéro 1
     * La deuxième scene a comme numéro 2
      */
    @Test
    void testAjoutScene()
    {
        String titreScene= "titre de scene";
        String descriptionScene = "description de la scene";
        a.ajouterScene(new Scene( titreScene,descriptionScene));
        Assertions.assertEquals(1,a.getScenes().size());
        Assertions.assertEquals(titreScene, a.getScenes().getFirst().getTitre());
        Assertions.assertEquals(descriptionScene, a.getScenes().getFirst().getDescription());
        Assertions.assertEquals(1, a.getScenes().getFirst().getNumeroScene());
        a.ajouterScene(new Scene( titreScene,descriptionScene));
        Assertions.assertEquals(2, a.getScenes().getLast().getNumeroScene());
    }

    /**
     * On peut ajouter un personnage
     */
    @Test
    void testAjoutPersonnage()
    {
        String nomPersonnage ="Nellie Taly";
        String descriptionPersonnage = "une femme agée et laide.";
        String historique = " Elle cherche à se venger du barde Bital Velyn et elle est satisfaite d'avoir récuperer le luth de ce dernier comme vengeance.";
        PersonnageNonJoueur p = new PersonnageNonJoueur(nomPersonnage,descriptionPersonnage);
        p.ajouterHistorique(historique);
        a.ajouterGroupe(p);
        Assertions.assertEquals(1, a.getGroupes().size());
    }

    /**
     * On peut ajouter le même personnage trois fois au maximum
     */
    @Test
    void testAjoutPersonnage3x()
    {
        String nomPersonnage ="Nellie Taly";
        String descriptionPersonnage = "une femme agée et laide.";
        String historique = " Elle cherche à se venger du barde Bital Velyn et elle est satisfaite d'avoir récuperer le luth de ce dernier comme vengeance.";
        PersonnageNonJoueur p = new PersonnageNonJoueur(nomPersonnage,descriptionPersonnage);
        p.ajouterHistorique(historique);
        a.ajouterGroupe(p);
        a.ajouterGroupe(p);
        a.ajouterGroupe(p);
        a.ajouterGroupe(p);
        Assertions.assertEquals(3, a.getGroupes().size());
        Assertions.assertEquals(p.getNom(), a.getGroupes().getLast().getNom());
    }

    /**
     * On peut ajouter une communaute
     */
    @Test
    void testAjoutCommunaute()
    {
        String nomCommunaute ="Phandalin";
        TailleCommunaute taille = TailleCommunaute.BOURGADE;
        Communaute communaute = new Communaute(nomCommunaute,taille);
        a.ajouterGroupe(communaute);
        Assertions.assertEquals(1, a.getGroupes().size());
    }

    @Test
    void testAjoutIntrigue()
    {
        Intrigue o = new Intrigue("trouver de l'argent");
        a.ajouterObjectif(o);
        Assertions.assertEquals(1, a.getObjectifs().size());
    }
}