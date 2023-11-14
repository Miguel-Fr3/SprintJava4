package mapped.api.models.repositories;

import mapped.api.infrastructure.database.DatabaseFactory;
import mapped.api.models.entities.MeioPagamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MeioPagamentoRepository {

    public List<MeioPagamento> findAll() throws SQLException {
        var meiosPagamento = new ArrayList<MeioPagamento>();
        var sql = "SELECT * FROM TB_PS_MEIO_PAGAMENTO";

        try (var conn = DatabaseFactory.getConnection();
             var statement = conn.prepareStatement(sql);
             var results = statement.executeQuery()) {
            while (results.next()) {
                meiosPagamento.add(new MeioPagamento(
                        results.getInt("CDMEIOPGTO"),
                        results.getString("DSMEIOPAGAMENTO"),
                        results.getBoolean("FGATIVO")));
            }
        }
        return meiosPagamento;
    }

    public void add(MeioPagamento meioPagamento) throws SQLException {
        var sql = "INSERT INTO TB_PS_MEIO_PAGAMENTO (CDMEIOPGTO, DSMEIOPAGAMENTO, FGATIVO) VALUES (?, ?, ?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, meioPagamento.getCdMeioPgto());
            statement.setString(2, meioPagamento.getDsMeioPagamento());
            statement.setBoolean(3, meioPagamento.isFgAtivo());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Optional<MeioPagamento> find(int id) throws SQLException {
        var sql = "SELECT * FROM TB_PS_MEIO_PAGAMENTO WHERE CDMEIOPGTO = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    var meioPagamento = new MeioPagamento(
                            rs.getInt("CDMEIOPGTO"),
                            rs.getString("DSMEIOPAGAMENTO"),
                            rs.getBoolean("FGATIVO"));
                    return Optional.ofNullable(meioPagamento);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.empty();
    }
    public void update(MeioPagamento meioPagamento) {
        var sql = "UPDATE TB_PS_MEIO_PAGAMENTO SET DSMEIOPAGAMENTO = ?, FGATIVO = ? WHERE CDMEIOPGTO = ?";
        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, meioPagamento.getDsMeioPagamento());
            statement.setBoolean(2, meioPagamento.isFgAtivo());
            statement.setInt(3, meioPagamento.getCdMeioPgto());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_MEIO_PAGAMENTO WHERE CDMEIOPGTO = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





