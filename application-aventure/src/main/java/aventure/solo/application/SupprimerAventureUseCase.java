package aventure.solo.application;

import aventure.solo.port.AventureRepository;

import java.util.UUID;

public class SupprimerAventureUseCase {

    private final AventureRepository aventureRepository;

    public SupprimerAventureUseCase(AventureRepository aventureRepository) {
        this.aventureRepository = aventureRepository;
    }

    /**
     * delete the aventure corresponding to the given idadventure
     * @param idAventure the aventure id to delete
     * @return true is the adventure has been deleted else false
     */
    public boolean execute(UUID idAventure)
    {
        return aventureRepository.delete(idAventure);
    }
}
