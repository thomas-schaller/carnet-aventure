package aventure.solo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageNonJoueurTest {

    private final String nomPersonnage = "Bital Velyn";
    private final String descriptionPersonnage ="un barde très connu à la côte des épées.";
    String historique1= "Il cherche un compagnon pour voyager jusqu'à la ville de Baldur.";
    PersonnageNonJoueur personnageNonJoueur;
    /**
     * A la creation, un personnage a un nom, une description et un historique vide
     */
    @Test
    public void testInitPersonnage()
    {
        assertEquals(nomPersonnage, personnageNonJoueur.getNom());
        assertEquals(descriptionPersonnage, personnageNonJoueur.getDescription());
        assertEquals("", personnageNonJoueur.getHistorique());
    }

    /**
     * La description d'un personnage peut changer
     */

    @Test
    public void testModifierDescription(){
        String nouvelleDescription = personnageNonJoueur.getDescription()+"Il est jeune et beau.";
        personnageNonJoueur.setDescription(nouvelleDescription);
        assertEquals(nouvelleDescription, personnageNonJoueur.getDescription());
    }

    /** l'historique du personnage peut s'étoffer
     *
     */
    @Test
    public void testAjoutHistorique() {

        String historique2= "Son luth a été volé par Silas.";
        personnageNonJoueur.ajouterHistorique(historique2);
        assertEquals(historique1+"\n"+historique2, personnageNonJoueur.getHistorique());
    }

    @BeforeEach
    public void initPersonnage(){
        personnageNonJoueur = new PersonnageNonJoueur(nomPersonnage, descriptionPersonnage);
        personnageNonJoueur.ajouterHistorique(historique1);
    }
}