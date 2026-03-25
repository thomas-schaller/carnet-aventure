package aventure.solo.port;

import aventure.solo.model.Aventure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AventureRepository {

    Optional<Aventure> findById(UUID id);
    UUID save(Aventure aventure);
    List<Aventure> list();
}
