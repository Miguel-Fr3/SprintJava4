package Mapped.api.models.repositories;

import Mapped.api.infrastructure.database.DatabaseFactory;
import Mapped.api.models.entities.Logradouro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogradouroRepository {

    public List<Logradouro> findAll() throws SQLException {
        var entities = new ArrayList<Logradouro>();
        var sql = "SELECT * FROM TB_LOGRADOURO";

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

    public void add(Logradouro logradouro) throws SQLException {
        var sql = "INSERT INTO TB_LOGRADOURO (NM_LOGRADOURO, NR_CEP, CD_LOGRADOURO) VALUES (?, ?, ?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            setValuesForAdd(statement, logradouro);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Optional<Logradouro> find(int id) throws SQLException {
        var sql = "SELECT * FROM TB_LOGRADOURO WHERE CD_LOGRADOURO = ?";

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

    public void update(Logradouro logradouro) throws SQLException {
        var sql = "UPDATE TB_LOGRADOURO SET NM_LOGRADOURO = ?, NR_CEP = ? WHERE CD_LOGRADOURO = ?";
        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            setValuesForAdd(statement, logradouro);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM TB_LOGRADOURO WHERE CD_LOGRADOURO = ?";
        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    private Logradouro mapRow(ResultSet rs) throws SQLException {
        return new Logradouro(
                rs.getInt("CD_LOGRADOURO"),
                rs.getString("NM_LOGRADOURO"),
                rs.getDouble("NR_CEP")
        );
    }

    private void setValuesForAdd(PreparedStatement preparedStatement, Logradouro logradouro) throws SQLException {
        preparedStatement.setString(1, logradouro.getNmLogradouro());
        preparedStatement.setDouble(2, logradouro.getNrCep());
        preparedStatement.setInt(3, logradouro.getCdLogradouro());
    }
}
