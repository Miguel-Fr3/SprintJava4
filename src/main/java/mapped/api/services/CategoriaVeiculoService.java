package mapped.api.services;

import mapped.api.models.entities.CategoriaVeiculo;
import mapped.api.models.repositories.CategoriaVeiculoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaVeiculoService {
    private final CategoriaVeiculoRepository categoriaVeiculoRepository;

    public CategoriaVeiculoService() {
        this.categoriaVeiculoRepository = new CategoriaVeiculoRepository();
    }

    public List<CategoriaVeiculo> findAll() throws SQLException {
        return categoriaVeiculoRepository.findAll();
    }

    public void add(CategoriaVeiculo categoriaVeiculo) throws SQLException {
        categoriaVeiculoRepository.add(categoriaVeiculo);
    }

    public Optional<CategoriaVeiculo> find(int id) throws SQLException {
        return categoriaVeiculoRepository.find(id);
    }

    public void update(int id, CategoriaVeiculo categoriaVeiculo) throws SQLException {
        categoriaVeiculoRepository.update(id, categoriaVeiculo);
    }

    public void delete(int id) throws SQLException {
        categoriaVeiculoRepository.delete(id);
    }
}
