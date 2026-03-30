package aventure.solo.mapper;

import aventure.solo.dto.SceneDTO;
import aventure.solo.model.Scene;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SceneMapper {

    SceneDTO toDTO(Scene scene);
    Scene toDomain(SceneDTO dto);
}
