package Mapped.api.services;

import Mapped.api.models.entities.TipoVeiculo;
import Mapped.api.models.repositories.TipoVeiculoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TipoVeiculoService {
    private final TipoVeiculoRepository tipoVeiculoRepository;

    public TipoVeiculoService() {
        this.tipoVeiculoRepository = new TipoVeiculoRepository();
    }

    public List<TipoVeiculo> findAll() throws SQLException {
        return tipoVeiculoRepository.findAll();
    }

    public void add(TipoVeiculo tipoVeiculo) throws SQLException {
        tipoVeiculoRepository.add(tipoVeiculo);
    }

    public Optional<TipoVeiculo> find(int id) throws SQLException {
        return tipoVeiculoRepository.find(id);
    }

    public void update(int id, TipoVeiculo tipoVeiculo) throws SQLException {
        tipoVeiculoRepository.update(id, tipoVeiculo);
    }

    public void delete(int id) throws SQLException {
        tipoVeiculoRepository.delete(id);
    }
}
