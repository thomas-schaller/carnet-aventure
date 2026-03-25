package moteur.oracle.persistence.repository;

import aventure.solo.model.Aventure;
import aventure.solo.port.AventureRepository;
import moteur.oracle.persistence.entity.AventureEntity;
import moteur.oracle.persistence.mapper.AventureMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JpaAventureRepository implements AventureRepository {

    private final SpringDataAventureRepository repo;

    public JpaAventureRepository(SpringDataAventureRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Aventure> findById(UUID id) {
        return repo.findById(id)
                .map(AventureMapper::toDomain);
    }

    @Override
    public UUID save(Aventure aventure) {
        AventureEntity aventureEntity = repo.save(AventureMapper.toEntity(aventure));
        return  aventureEntity.getId();
    }

    @Override
    public List<Aventure> list() {
        List<Aventure> result = new ArrayList<>();
        repo.findAll().forEach(aventureEntity -> result.add(AventureMapper.toDomain(aventureEntity)));
        return result;
    }
}