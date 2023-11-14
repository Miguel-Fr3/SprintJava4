package mapped.api.services;

import mapped.api.models.entities.FormaPagamento;
import mapped.api.models.repositories.FormaPagamentoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FormaPagamentoService {
    private final FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamentoService() {
        this.formaPagamentoRepository = new FormaPagamentoRepository();
    }

    public List<FormaPagamento> findAll() throws SQLException {
        return formaPagamentoRepository.findAll();
    }

    public void add(FormaPagamento formaPagamento) throws SQLException {
        formaPagamentoRepository.add(formaPagamento);
    }

    public Optional<FormaPagamento> find(int id) throws SQLException {
        return formaPagamentoRepository.find(id);
    }

    public FormaPagamento update(int id, FormaPagamento formaPagamento) throws SQLException {
        return formaPagamentoRepository.update(id, formaPagamento);
    }

    public void delete(int id) throws SQLException {
        formaPagamentoRepository.delete(id);
    }


}
