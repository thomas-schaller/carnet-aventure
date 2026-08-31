package aventure.solo.mapper;

import aventure.solo.dto.ObjectifDTO;
import aventure.solo.model.Intrigue;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ObjectifMapper {

    ObjectifDTO toDTO(Intrigue intrigue);
    Intrigue toDomain(ObjectifDTO dto);
}
