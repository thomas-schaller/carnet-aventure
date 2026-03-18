package aventure.solo.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    private final String nomPersonnage = "Bital Velyn";
    private final String descriptionPersonnage ="un barde très connu à la côte des épées.";
    Personnage personnage ;
    /**
     * A la creation, un personnage a un nom, une description et un historique vide
     */
    @Test
    public void testInitPersonnage()
    {
        assertEquals(nomPersonnage,personnage.getName());
        assertEquals(descriptionPersonnage,personnage.getDescription());
        assertEquals("",personnage.getHistorique());
    }

    /**
     * La description d'un personnage peut changer
     */

    @Test
    public void testModifierDescription(){
        String nouvelleDescription = personnage.getDescription()+"Il est jeune et beau.";
        personnage.setDescription(nouvelleDescription);
        assertEquals(nouvelleDescription,personnage.getDescription());
    }

    /** l'historique du personnage peut changer
     *
     */
    @Test
    public void testModifierHistorique() {
        String historique1= "Il cherche un compagnon pour voyager jusqu'à la ville de Baldur.";
        String historique2= "Son luth a été volé par Silas.";
        personnage.ajouterHistorique(historique1);
        personnage.ajouterHistorique(historique2);
        assertEquals(historique1+"\n"+historique2,personnage.getHistorique());
    }

    @BeforeEach
    public void initPersonnage(){
        personnage = new Personnage(nomPersonnage, descriptionPersonnage);
    }
}