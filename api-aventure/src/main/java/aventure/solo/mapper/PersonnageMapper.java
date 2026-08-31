package aventure.solo.mapper;

import aventure.solo.dto.PersonnageDTO;
import aventure.solo.model.PersonnageNonJoueur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonnageMapper {

    PersonnageNonJoueur toDomain(PersonnageDTO dto);
}
