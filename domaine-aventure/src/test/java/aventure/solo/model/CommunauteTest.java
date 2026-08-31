package aventure.solo.model;

import aventure.solo.value.TailleCommunaute;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommunauteTest {

    static String nomCommunaute = "Communaute";
    TailleCommunaute taille= TailleCommunaute.VILLAGE;
    Communaute communaute ;
    @BeforeEach
    public void initCommunaute(){
        communaute = new Communaute(nomCommunaute, taille);
    }

    @Test
    void testInitCommunaute() {
        assertEquals(nomCommunaute,communaute.getNom());
        assertEquals(taille,communaute.getTaille());
        assertNull(communaute.getDirigeant());
        assertNull(communaute.getCalamiteActuelle());
        assertNull(communaute.getEstCelebrePour());
        assertNull(communaute.getLieuxInteret());
        assertNull(communaute.getTraitsDistinctifs());
    }

@Test
    void testAjoutDirigeant()
{
    PersonnageNonJoueur dirigeant = new PersonnageNonJoueur("Isaac Newton", "grand et brun");
    communaute.setDirigeant(dirigeant);
    assertEquals(dirigeant,communaute.getDirigeant());
}

@Test
    void testCalamite()
{
    String calamite ="des bandits attaquent souvent la communauté.";
    communaute.setCalamiteActuelle(calamite);
    assertEquals(calamite,communaute.getCalamiteActuelle());
}

@Test
    void testLieuInteret()
{
    String lieuInteret = "un autel de la chance";
    communaute.setLieuxInteret(lieuInteret);
    assertEquals(lieuInteret,communaute.getLieuxInteret());
}

    @Test
    void testCelebre()
    {
        String celebre = "la meilleur bière de la région";
        communaute.setEstCelebrePour(celebre);
        assertEquals(celebre,communaute.getEstCelebrePour());
    }

    @Test
    void testTraitsDistinctifs()
    {
        String trait = "la ville a été construite à partir d'antiques murailles d'un matériau inconnu.";
        communaute.setTraitsDistinctifs(trait);
        assertEquals(trait,communaute.getTraitsDistinctifs());
    }
}