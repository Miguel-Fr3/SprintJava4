package Mapped.api.models.repositories;

import Mapped.api.infrastructure.database.DatabaseFactory;
import Mapped.api.models.entities.FormaPagamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FormaPagamentoRepository {

    public List<FormaPagamento> findAll() throws SQLException {
        var entities = new ArrayList<FormaPagamento>();
        var sql = "SELECT * FROM TB_FORMA_PAGAMENTO";

        try (
                var conn = DatabaseFactory.getConnection();
                var statement = conn.prepareStatement(sql);
                var results = statement.executeQuery()
        ) {
            while (results.next()) {
                entities.add(mapRow(results));
            }
        }
        return entities;
    }

    public void add(FormaPagamento formaPagamento) throws SQLException {
        var sql = "INSERT INTO TB_FORMA_PAGAMENTO (DS_FORMA_PAGAMENTO, FG_ATIVO, CD_FORMA_PGTO) VALUES (?, ?, ?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            setValuesForAdd(statement, formaPagamento);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Optional<FormaPagamento> find(int id) throws SQLException {
        var sql = "SELECT * FROM TB_FORMA_PAGAMENTO WHERE CD_FORMA_PGTO = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    return Optional.ofNullable(mapRow(rs));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.empty();
    }

    private FormaPagamento mapRow(ResultSet rs) throws SQLException {
        return new FormaPagamento(
                rs.getInt("CD_FORMA_PGTO"),
                rs.getString("DS_FORMA_PAGAMENTO"),
                rs.getBoolean("FG_ATIVO")
                );
    }

    private void setValuesForAdd(PreparedStatement preparedStatement, FormaPagamento formaPagamento) throws SQLException {
        preparedStatement.setString(1, formaPagamento.getDsFormaPagamento());
        preparedStatement.setBoolean(2, formaPagamento.isFgAtivo());
        preparedStatement.setInt(3, formaPagamento.getCdFormaPgto());
    }
    public FormaPagamento update(int id, FormaPagamento formaPagamento) throws SQLException {
        var sql = "UPDATE TB_FORMA_PAGAMENTO SET DS_FORMA_PAGAMENTO = ?, FG_ATIVO = ? WHERE CD_FORMA_PGTO = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            setValuesForUpdate(statement, formaPagamento);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return formaPagamento;
    }

    public void delete(int id) throws SQLException {
        var sql = "DELETE FROM TB_FORMA_PAGAMENTO WHERE CD_FORMA_PGTO = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    private void setValuesForUpdate(PreparedStatement preparedStatement, FormaPagamento formaPagamento) throws SQLException {
        preparedStatement.setString(1, formaPagamento.getDsFormaPagamento());
        preparedStatement.setBoolean(2, formaPagamento.isFgAtivo());
        preparedStatement.setInt(3, formaPagamento.getCdFormaPgto());
    }



}