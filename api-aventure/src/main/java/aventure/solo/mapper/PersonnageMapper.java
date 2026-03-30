package aventure.solo.mapper;

import aventure.solo.dto.PersonnageDTO;
import aventure.solo.model.Personnage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonnageMapper {

    PersonnageDTO toDTO(Personnage personnage);
    Personnage toDomain(PersonnageDTO dto);
}
