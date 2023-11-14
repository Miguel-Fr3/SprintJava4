package mapped.api.services;

import mapped.api.models.entities.MeioPagamento;
import mapped.api.models.repositories.MeioPagamentoRepository;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class MeioPagamentoService {
    private final MeioPagamentoRepository meioPagamentoRepository;

    public MeioPagamentoService() {
        this.meioPagamentoRepository = new MeioPagamentoRepository();
    }


}