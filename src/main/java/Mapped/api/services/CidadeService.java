package mapped.api.services;

import mapped.api.models.entities.Cidade;
import mapped.api.models.repositories.CidadeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;



public class CidadeService {
    private final CidadeRepository cidadeRepository;


    public CidadeService() {
        this.cidadeRepository = new CidadeRepository();
    }

    public List<Cidade> findAll() throws SQLException {
        return cidadeRepository.findAll();
    }

    public void add(Cidade cidade) throws SQLException {
        cidadeRepository.add(cidade);
    }

    public Optional<Cidade> find(int id) throws SQLException {
        return cidadeRepository.find(id);
    }

    public void update(int id, Cidade cidade) throws SQLException {
        cidadeRepository.update(id, cidade);
    }

    public void delete(int id) throws SQLException {
        cidadeRepository.delete(id);
    }
}
