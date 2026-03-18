package aventure.solo.model;

import aventure.solo.value.StatutObjectif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectifTest {
    Objectif o;
    private final String description = "trouver de l'argent.";
    @BeforeEach
    public void initObjectif()
    {
        o = new Objectif(description);
    }

    /**
     * un objectif possède une description et est actif lors de sa création
     */
    @Test
    public void testInitObjectif()
    {
        assertEquals(description, o.getDescription());
        assertEquals(StatutObjectif.ACTIVE, o.getStatut());
    }

    /**
     * un objectif peut échouer
     */
    @Test
    public void testEchouerObjectif(){
        o.echouer();
        assertEquals(StatutObjectif.FAILED,o.getStatut());
    }

    @Test
    public void testTerminerObjectif(){
        o.terminer();
        assertEquals(StatutObjectif.RESOLVED,o.getStatut());
    }
}