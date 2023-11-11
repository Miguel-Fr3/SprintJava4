package Mapped.api.services;

import Mapped.api.models.entities.Logradouro;
import Mapped.api.models.repositories.LogradouroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LogradouroService {
    private final LogradouroRepository logradouroRepository;

    public LogradouroService() {
        this.logradouroRepository = new LogradouroRepository();
    }

    public void add(Logradouro logradouro) throws SQLException {
        this.logradouroRepository.add(logradouro);
    }

    public List<Logradouro> findAll() throws SQLException {
        return this.logradouroRepository.findAll();
    }

    public Optional<Logradouro> find(int id) throws SQLException {
        return this.logradouroRepository.find(id);
    }

    public void update(Logradouro logradouro) throws SQLException {
        this.logradouroRepository.update(logradouro);
    }

    public void delete(int id) throws SQLException {
        this.logradouroRepository.delete(id);
    }
}
