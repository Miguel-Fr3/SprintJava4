package Mapped.api.services;

import Mapped.api.models.entities.MeioPagamento;
import Mapped.api.models.repositories.MeioPagamentoRepository;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class MeioPagamentoService {
    private final MeioPagamentoRepository meioPagamentoRepository;

    public MeioPagamentoService() {
        this.meioPagamentoRepository = new MeioPagamentoRepository();
    }


}