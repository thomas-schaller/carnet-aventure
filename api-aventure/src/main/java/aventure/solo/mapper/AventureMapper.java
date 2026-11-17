package aventure.solo.mapper;

import aventure.solo.dto.AventureDTO;
import aventure.solo.dto.ObjectifDTO;
import aventure.solo.dto.PersonnageDTO;
import aventure.solo.dto.SceneDTO;
import aventure.solo.model.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
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
    @Mapping(target = "personnages", source = "groupes")
    AventureDTO toDTO(Aventure aventure);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "scenes", ignore = true)
    @Mapping(target = "objectifs", ignore = true)
    @Mapping(target = "groupes", ignore = true)
    @Mapping(target = "valeurChaos", constant = "5")
    Aventure toDomain(AventureDTO dto);

    // Mappings unitaires vers le domaine (utilisés dans enrichDomain et délégués aux mappers injectés)
    Scene toDomain(SceneDTO dto);

    Intrigue toDomain(ObjectifDTO dto);

    PersonnageNonJoueur toDomain(PersonnageDTO dto);

    @AfterMapping
    default void filterPersonnages(@MappingTarget AventureDTO dto) {
        if (dto.getPersonnages() != null) {
            dto.setPersonnages(dto.getPersonnages().stream().filter(java.util.Objects::nonNull).toList());
        }
    }

    // ===== UUID mapping =====

    default String map(UUID id) {
        return id != null ? id.toString() : null;
    }

    default UUID map(String id) {
        return (id != null && !id.isBlank()) ? UUID.fromString(id) : null;
    }

    // ===== enrichissement DOMAIN =====

    @AfterMapping
    default void enrichDomain(AventureDTO dto, @MappingTarget Aventure aventure) {
        if (dto.getId() != null && !dto.getId().isBlank()) {
            aventure.setId(map(dto.getId()));
        }

        aventure.setNotes(dto.getNotes());

        if (dto.getScenes() != null) {
            dto.getScenes().forEach(s -> {
                if (s != null) {
                    aventure.ajouterScene(toDomain(s));
                }
            });
        }

        if (dto.getObjectifs() != null) {
            dto.getObjectifs().forEach(o -> {
                if (o != null) {
                    aventure.ajouterObjectif(toDomain(o));
                }
            });
        }

        if (dto.getPersonnages() != null) {
            dto.getPersonnages().forEach(p -> {
                if (p != null) {
                    aventure.ajouterGroupe(toDomain(p));
                }
            });
        }
    }
}

