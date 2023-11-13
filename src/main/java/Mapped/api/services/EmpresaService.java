package Mapped.api.services;

import Mapped.api.models.entities.Empresa;
import Mapped.api.models.repositories.EmpresaRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;



public class EmpresaService {    


    private final EmpresaRepository empresaRepository;

    public EmpresaService() {
        this.empresaRepository = new EmpresaRepository();
    }

    public List<Empresa> findAll() throws SQLException {
        return empresaRepository.findAll();
    }

    public void add(Empresa empresa) throws SQLException {
        empresaRepository.add(empresa);
    }

    public Optional<Empresa> find(int id) throws SQLException {
        return empresaRepository.find(id);
    }

    public void update(int id, Empresa empresa) throws SQLException {
        empresaRepository.update(id, empresa);
    }

    public void delete(int id) throws SQLException {
        empresaRepository.delete(id);
    }
}
