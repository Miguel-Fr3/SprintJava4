package mapped.api.services;

import mapped.api.models.entities.Parceiro;
import mapped.api.models.repositories.ParceiroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ParceiroService {
    private final ParceiroRepository parceiroRepository;

    public ParceiroService() {
        this.parceiroRepository = new ParceiroRepository();
    }


    public List<Parceiro> findAll() throws SQLException {
        return parceiroRepository.findAll();
    }

    public void add(Parceiro parceiro) throws SQLException {
        parceiroRepository.add(parceiro);

        
    }

    public Optional<Parceiro> find(int id) throws SQLException {
        return parceiroRepository.find(id);
    }

    public void update(int id, Parceiro parceiro) throws SQLException {
        parceiroRepository.update(id, parceiro);
    }

    public void delete(int id) throws SQLException {
        parceiroRepository.delete(id);
    }
}
