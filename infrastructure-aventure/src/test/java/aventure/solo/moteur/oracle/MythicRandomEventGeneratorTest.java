package aventure.solo.moteur.oracle;

import static org.mockito.Mockito.*;

import aventure.solo.model.Groupe;
import aventure.solo.model.Intrigue;
import aventure.solo.model.PersonnageNonJoueur;
import aventure.solo.port.WordProvider;
import aventure.solo.moteur.oracle.model.evenement.RandomEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MythicRandomEventGeneratorTest {
    @Mock
    WordProvider wordProvider;
    @InjectMocks
    MythicRandomEventGenerator randomGenerator;

    @Test
    public void testGenerate(){
        //when(wordController.generate("description1")).thenReturn("reve");
        //when(wordController.generate("description2")).thenReturn("travail");
        when(wordProvider.genererMot("action1")).thenReturn("traquer");
        when(wordProvider.genererMot("action2")).thenReturn("detruire");
        Intrigue o = new Intrigue("trouver une mission");
        List<Intrigue> lo = new ArrayList<>();
        lo.add(o);
        PersonnageNonJoueur p = new PersonnageNonJoueur("Gandalf", "un magicien tout de gris vêtu");
        List<Groupe> lp = new ArrayList<>();
        lp.add(p);
        RandomEvent re =randomGenerator.generate(lo,lp);
        assertEquals("traquer", re.meaning().mot1());
        assertEquals("detruire", re.meaning().mot2());
        System.out.println(re);
    }

}