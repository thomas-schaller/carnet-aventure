package moteur.oracle;

import static org.mockito.Mockito.*;

import aventure.solo.model.Objectif;
import aventure.solo.model.Personnage;
import fr.schaller.wordgenerator.application.usecase.GenerateWordUseCase;
import fr.schaller.wordgenerator.domain.service.WordGeneratorService;
import fr.schaller.wordgenerator.infrastructure.filesystem.FileSystemWordRepository;
import fr.schaller.wordgenerator.infrastructure.spring.controller.WordController;
import moteur.oracle.model.evenement.RandomEvent;
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
    WordController wordController;
    @InjectMocks
    MythicRandomEventGenerator randomGenerator;

    @Test
    public void testGenerate(){
        //when(wordController.generate("description1")).thenReturn("reve");
        //when(wordController.generate("description2")).thenReturn("travail");
        when(wordController.generate("action1")).thenReturn("traquer");
        when(wordController.generate("action2")).thenReturn("detruire");
        Objectif o = new Objectif("trouver une mission");
        List<Objectif> lo = new ArrayList<>();
        lo.add(o);
        Personnage p = new Personnage("Gandalf", "un magicien tout de gris vêtu");
        List<Personnage> lp = new ArrayList<>();
        lp.add(p);
        RandomEvent re =randomGenerator.generate(lo,lp);
        assertEquals("traquer", re.meaning().mot1());
        assertEquals("detruire", re.meaning().mot2());
        System.out.println(re);
    }

}