package aventure.solo.dto;

import lombok.Data;

import java.util.List;

@Data
public class AventureDTO {
    String id;
    String titre;
    String notes;
    List<PersonnageDTO> personnages;
    List<ObjectifDTO> objectifs;
    List<SceneDTO> scenes;
}
