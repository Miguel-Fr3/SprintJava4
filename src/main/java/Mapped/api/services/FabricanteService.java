package mapped.api.services;

import mapped.api.models.entities.Fabricante;
import mapped.api.models.repositories.FabricanteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FabricanteService {
    private final FabricanteRepository fabricanteRepository;

    public FabricanteService() {
        this.fabricanteRepository = new FabricanteRepository();
    }

    public List<Fabricante> findAll() throws SQLException {
        return fabricanteRepository.findAll();
    }

    public void add(Fabricante fabricante) throws SQLException {
        fabricanteRepository.add(fabricante);
    }

    public Optional<Fabricante> find(int id) throws SQLException {
        return fabricanteRepository.find(id);
    }

    public void update(int id, Fabricante fabricante) throws SQLException {
        fabricanteRepository.update(id, fabricante);
    }

    public void delete(int id) throws SQLException {
        fabricanteRepository.delete(id);
    }
}
