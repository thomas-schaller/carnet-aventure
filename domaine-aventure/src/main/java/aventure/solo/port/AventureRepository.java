package aventure.solo.port;

import aventure.solo.model.Aventure;

import java.util.Optional;
import java.util.UUID;

public interface AventureRepository {

    Optional<Aventure> findById(UUID id);
    void save(Aventure aventure);
}
