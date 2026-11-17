package aventure.solo.mapper;

import aventure.solo.dto.AventureDTO;
import aventure.solo.dto.ObjectifDTO;
import aventure.solo.dto.PersonnageDTO;
import aventure.solo.dto.SceneDTO;
import aventure.solo.model.Aventure;
import aventure.solo.model.Intrigue;
import aventure.solo.model.PersonnageNonJoueur;
import aventure.solo.model.Scene;
import aventure.solo.value.StatutIntrigue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AventureMapperTest {

    private AventureMapper aventureMapper;

    @BeforeEach
    void setUp() throws Exception {
        AventureMapperImpl mapperImpl = new AventureMapperImpl();
        SceneMapper sceneMapper = new SceneMapperImpl();
        ObjectifMapper objectifMapper = new ObjectifMapperImpl();
        PersonnageMapper personnageMapper = new PersonnageMapperImpl();

        setField(mapperImpl, "sceneMapper", sceneMapper);
        setField(mapperImpl, "objectifMapper", objectifMapper);
        setField(mapperImpl, "personnageMapper", personnageMapper);

        this.aventureMapper = mapperImpl;
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Test
    void testToDomain_withScenesObjectifsAndPersonnages() {
        AventureDTO dto = new AventureDTO();
        dto.setId(UUID.randomUUID().toString());
        dto.setTitre("La quête du Graal");
        dto.setNotes("Notes de test");

        SceneDTO sceneDTO = new SceneDTO();
        sceneDTO.setTitre("Scène 1");
        sceneDTO.setDescription("Description de la scène 1");
        sceneDTO.setNumeroScene(1);
        dto.setScenes(List.of(sceneDTO));

        ObjectifDTO objectifDTO = new ObjectifDTO();
        objectifDTO.setDescription("Trouver le Graal");
        objectifDTO.setStatut("ACTIVE");
        dto.setObjectifs(List.of(objectifDTO));

        PersonnageDTO personnageDTO = new PersonnageDTO();
        personnageDTO.setName("Arthur");
        personnageDTO.setDescription("Roi de Bretagne");
        personnageDTO.setHistorique("Couronné à Camelot");
        dto.setPersonnages(List.of(personnageDTO));

        Aventure aventure = aventureMapper.toDomain(dto);

        assertNotNull(aventure);
        assertEquals("La quête du Graal", aventure.getTitre());
        assertEquals("Notes de test", aventure.getNotes());
        assertEquals(UUID.fromString(dto.getId()), aventure.getId());

        // Vérification des scènes
        assertEquals(1, aventure.getScenes().size());
        Scene scene = aventure.getScenes().getFirst();
        assertEquals("Scène 1", scene.getTitre());
        assertEquals("Description de la scène 1", scene.getDescription());
        assertEquals(1, scene.getNumeroScene());

        // Vérification des objectifs
        assertEquals(1, aventure.getObjectifs().size());
        Intrigue intrigue = aventure.getObjectifs().getFirst();
        assertEquals("Trouver le Graal", intrigue.getDescription());
        assertEquals(StatutIntrigue.ACTIVE, intrigue.getStatut());

        // Vérification des personnages
        assertEquals(1, aventure.getGroupes().size());
        assertInstanceOf(PersonnageNonJoueur.class, aventure.getGroupes().getFirst());
        PersonnageNonJoueur pnj = (PersonnageNonJoueur) aventure.getGroupes().getFirst();
        assertEquals("Arthur", pnj.getNom());
        assertEquals("Roi de Bretagne", pnj.getDescription());
        assertEquals("Couronné à Camelot", pnj.getHistorique());
    }

    @Test
    void testToDTO_withScenesObjectifsAndPersonnages() {
        Aventure aventure = new Aventure("L'épopée de Silas", 5);
        UUID id = UUID.randomUUID();
        aventure.setId(id);
        aventure.setNotes("Notes épiques");

        Scene scene = new Scene("Réveil", "Silas se réveille sans souvenirs");
        scene.setNumeroScene(1);
        aventure.ajouterScene(scene);

        Intrigue intrigue = new Intrigue("Retrouver la mémoire");
        intrigue.setStatut(StatutIntrigue.ACTIVE);
        aventure.ajouterObjectif(intrigue);

        PersonnageNonJoueur pnj = new PersonnageNonJoueur("Silas", "Guerrier amnésique");
        pnj.ajouterHistorique("Rencontre avec l'aubergiste");
        aventure.ajouterGroupe(pnj);

        AventureDTO dto = aventureMapper.toDTO(aventure);

        assertNotNull(dto);
        assertEquals(id.toString(), dto.getId());
        assertEquals("L'épopée de Silas", dto.getTitre());
        assertEquals("Notes épiques", dto.getNotes());

        // Vérification des scènes
        assertNotNull(dto.getScenes());
        assertEquals(1, dto.getScenes().size());
        SceneDTO sceneDTO = dto.getScenes().getFirst();
        assertEquals("Réveil", sceneDTO.getTitre());
        assertEquals("Silas se réveille sans souvenirs", sceneDTO.getDescription());
        assertEquals(1, sceneDTO.getNumeroScene());

        // Vérification des objectifs
        assertNotNull(dto.getObjectifs());
        assertEquals(1, dto.getObjectifs().size());
        ObjectifDTO objectifDTO = dto.getObjectifs().getFirst();
        assertEquals("Retrouver la mémoire", objectifDTO.getDescription());
        assertEquals("ACTIVE", objectifDTO.getStatut());

        // Vérification des personnages
        assertNotNull(dto.getPersonnages());
        assertEquals(1, dto.getPersonnages().size());
        PersonnageDTO personnageDTO = dto.getPersonnages().getFirst();
        assertEquals("Silas", personnageDTO.getName());
        assertEquals("Guerrier amnésique", personnageDTO.getDescription());
        assertEquals("Rencontre avec l'aubergiste", personnageDTO.getHistorique());
    }
}
