package aventure.solo.mapper;

import aventure.solo.dto.ObjectifDTO;
import aventure.solo.model.Objectif;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectifMapper {

    ObjectifDTO toDTO(Objectif objectif);
    Objectif toDomain(ObjectifDTO dto);
}
