package mapped.api.models.repositories;

import mapped.api.infrastructure.database.DatabaseFactory;
import mapped.api.models.entities.Canal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




public class CanalRepository {

    public List<Canal> findAll() throws SQLException {
        List<Canal> canais = new ArrayList<>();
        String sql = "SELECT * FROM TB_PS_CANAL";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                canais.add(mapResultSetToCanal(results));
            }
        }
        return canais;
    }

    public void add(Canal canal) throws SQLException {
        String sql = "INSERT INTO TB_PS_CANAL (nmCanal, dsDescricao) VALUES (?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCanalParameters(statement, canal);
            statement.executeUpdate();
        }
    }

    public Optional<Canal> find(int id) throws SQLException {
        String sql = "SELECT * FROM TB_PS_CANAL WHERE cdCanal = ?";
        Canal canal = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    canal = mapResultSetToCanal(rs);
                }
            }
        }
        return Optional.ofNullable(canal);
    }

    public void update(int id, Canal canal) {
        String sql = "UPDATE TB_PS_CANAL SET nmCanal=?, dsDescricao=? WHERE cdCanal=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCanalParameters(statement, canal);
            statement.setInt(3, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_CANAL WHERE cdCanal = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Canal mapResultSetToCanal(ResultSet resultSet) throws SQLException {
        return new Canal(
                resultSet.getInt("cdCanal"),
                resultSet.getString("nmCanal"),
                resultSet.getString("dsDescricao")
        );
    }

    private void setCanalParameters(PreparedStatement preparedStatement, Canal canal) throws SQLException {
        preparedStatement.setString(1, canal.getNmCanal());
        preparedStatement.setString(2, canal.getDsDescricao());
    }
}
