package mapped.api.services;

import mapped.api.models.entities.MotoristaParceiro;
import mapped.api.models.repositories.MotoristaParceiroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MotoristaParceiroService {
    private final MotoristaParceiroRepository motoristaParceiroRepository;

    public MotoristaParceiroService() {
        this.motoristaParceiroRepository = new MotoristaParceiroRepository();
    }



    public List<MotoristaParceiro> findAll() throws SQLException {
          return motoristaParceiroRepository.findAll();
      }

    public void add(MotoristaParceiro motoristaParceiro) throws SQLException {
        motoristaParceiroRepository.add(motoristaParceiro);
    }

    public Optional<MotoristaParceiro> find(int id) throws SQLException {
        return motoristaParceiroRepository.find(id);
 }

    public void update(int id, MotoristaParceiro motoristaParceiro) throws SQLException {
        motoristaParceiroRepository.update(id, motoristaParceiro);
    }

    public void delete(int id) throws SQLException {
        motoristaParceiroRepository.delete(id);
    }
}
