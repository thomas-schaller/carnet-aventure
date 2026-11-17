package aventure.solo.mapper;

import aventure.solo.dto.PersonnageDTO;
import aventure.solo.model.Groupe;
import aventure.solo.model.PersonnageNonJoueur;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PersonnageMapper {

    PersonnageNonJoueur toDomain(PersonnageDTO dto);

    @Mapping(target = "name", source = "nom")
    PersonnageDTO toDTO(PersonnageNonJoueur pnj);

    default PersonnageDTO toDTO(Groupe groupe) {
        if (groupe instanceof PersonnageNonJoueur pnj) {
            return toDTO(pnj);
        }
        return null;
    }

    @AfterMapping
    default void enrichDomain(PersonnageDTO dto, @MappingTarget PersonnageNonJoueur pnj) {
        if (dto.getHistorique() != null && !dto.getHistorique().isBlank()) {
            for (String h : dto.getHistorique().split("\n")) {
                if (!h.isBlank()) {
                    pnj.ajouterHistorique(h);
                }
            }
        }
    }
}
