package aventure.solo.model;

import aventure.solo.value.StatutIntrigue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntrigueTest {
    Intrigue o;
    private final String description = "trouver de l'argent.";
    @BeforeEach
    public void initObjectif()
    {
        o = new Intrigue(description);
    }

    /**
     * une intrigue possède une description et est actif lors de sa création
     */
    @Test
    public void testInitObjectif()
    {
        assertEquals(description, o.getDescription());
        assertEquals(StatutIntrigue.ACTIVE, o.getStatut());
    }

    /**
     * une intrigue peut échouer
     */
    @Test
    public void testEchouerObjectif(){
        o.echouer();
        assertEquals(StatutIntrigue.FAILED,o.getStatut());
    }

    /**
     * une intrigue peut être résolue
     */
    @Test
    public void testTerminerObjectif(){
        o.terminer();
        assertEquals(StatutIntrigue.RESOLVED,o.getStatut());
    }
}