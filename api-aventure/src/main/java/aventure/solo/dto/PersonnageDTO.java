package aventure.solo.dto;

import lombok.Data;


@Data
public class PersonnageDTO {

    private String name;

    // La description physique et mental du personnage
    private String description;

    //l'historique du personnage dans l'aventure
    private String historique;

}
