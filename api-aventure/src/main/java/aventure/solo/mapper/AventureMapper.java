package aventure.solo.mapper;

import aventure.solo.dto.AventureDTO;
import aventure.solo.model.Aventure;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper(
        componentModel = "spring",
        uses = {SceneMapper.class, ObjectifMapper.class, PersonnageMapper.class}
)

public interface AventureMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "titre", source = "titre")
    @Mapping(target = "notes", source = "notes")
    @Mapping(target = "scenes", source = "scenes")
    @Mapping(target = "objectifs", source = "objectifs")
    @Mapping(target = "personnages", source = "personnages")
    AventureDTO toDTO(Aventure aventure);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "scenes", ignore = true)
    @Mapping(target = "objectifs", ignore = true)
    @Mapping(target = "personnages", ignore = true)
    Aventure toDomain(AventureDTO dto);

    // ===== UUID mapping =====

    default String map(UUID id) {
        return id != null ? id.toString() : null;
    }

    default UUID map(String id) {
        return id != null ? UUID.fromString(id) : null;
    }

    // ===== enrichissement DOMAIN =====

    @AfterMapping
    default void enrichDomain(AventureDTO dto, @MappingTarget Aventure aventure) {

        aventure.setNotes(dto.getNotes());

        if (dto.getScenes() != null) {
            dto.getScenes().forEach(s -> {
                // TODO mapper SceneDTO → Scene
                // aventure.ajouterScene(...)
            });
        }

        if (dto.getObjectifs() != null) {
            dto.getObjectifs().forEach(o -> {
                // aventure.ajouterObjectif(...)
            });
        }

        if (dto.getPersonnages() != null) {
            dto.getPersonnages().forEach(p -> {
                // aventure.ajouterPersonnage(...)
            });
        }
    }
}
