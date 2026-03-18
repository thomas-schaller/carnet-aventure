package aventure.solo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SceneTest {

    private final static String titre = "l'arrivé au village";
    private final static String description = "Silas arrive au village et toute le monde l'observe suspicieusement";
    private Scene s;
    /**
     * A sa creation, une scene :
     * - a un titre
     * - une description
     * - elle est active.
     * - elle a comme numéro de scene 1
     */
    @Test
    public void initScene() {
        String titre = "l'arrivé au village";
        String description = "Silas arrive au village et toute le monde l'observe suspicieusement";
        Assertions.assertEquals(titre, s.getTitre());
        Assertions.assertEquals(description, s.getDescription());

        Assertions.assertEquals(1, s.getNumeroScene());
    }


    @Test
    public void testSetNumeroScene() {
        s.setNumeroScene(2);
        assertEquals(2,s.getNumeroScene());
    }

    @BeforeEach
    public void initTest()
    {
        s = new Scene(titre, description);
    }

}