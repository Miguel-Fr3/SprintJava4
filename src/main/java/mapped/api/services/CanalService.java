package mapped.api.services;

import mapped.api.models.entities.Canal;
import mapped.api.models.repositories.CanalRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;




public class CanalService {
    private final CanalRepository canalRepository;

    public CanalService() {
        this.canalRepository = new CanalRepository();
    }

    public List<Canal> findAll() throws SQLException {
        return canalRepository.findAll();
    }

    public void add(Canal canal) throws SQLException {
        canalRepository.add(canal);
    }

    public Optional<Canal> find(int id) throws SQLException {
        return canalRepository.find(id);
    }

    public void update(int id, Canal canal) throws SQLException {
        canalRepository.update(id, canal);
    }

    public void delete(int id) throws SQLException {
        canalRepository.delete(id);
    }
}
