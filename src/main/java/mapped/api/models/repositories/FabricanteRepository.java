package mapped.api.models.repositories;

import mapped.api.infrastructure.database.DatabaseFactory;
import mapped.api.models.entities.Fabricante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FabricanteRepository {

    public List<Fabricante> findAll() throws SQLException {
        List<Fabricante> fabricantes = new ArrayList<>();
        String sql = "SELECT * FROM TB_PS_FABRICANTE";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                fabricantes.add(mapResultSetToFabricante(results));
            }
        }
        return fabricantes;
    }

    public void add(Fabricante fabricante) throws SQLException {
        String sql = "INSERT INTO TB_PS_FABRICANTE (nmFabricante, dsDescricao, fgAtivo) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setFabricanteParameters(statement, fabricante);
            statement.executeUpdate();
        }
    }

    public Optional<Fabricante> find(int id) throws SQLException {
        String sql = "SELECT * FROM TB_PS_FABRICANTE WHERE cdFabricante = ?";
        Fabricante fabricante = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    fabricante = mapResultSetToFabricante(rs);
                }
            }
        }
        return Optional.ofNullable(fabricante);
    }

    public void update(int id, Fabricante fabricante) {
        String sql = "UPDATE TB_PS_FABRICANTE SET nmFabricante=?, dsDescricao=?, fgAtivo=? WHERE cdFabricante=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setFabricanteParameters(statement, fabricante);
            statement.setInt(4, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_FABRICANTE WHERE cdFabricante = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Fabricante mapResultSetToFabricante(ResultSet resultSet) throws SQLException {
        return new Fabricante(
                resultSet.getInt("cdFabricante"),
                resultSet.getString("nmFabricante"),
                resultSet.getString("dsDescricao"),
                resultSet.getDouble("fgAtivo")
        );
    }

    private void setFabricanteParameters(PreparedStatement preparedStatement, Fabricante fabricante) throws SQLException {
        preparedStatement.setString(1, fabricante.getNmFabricante());
        preparedStatement.setString(2, fabricante.getDsDescricao());
        preparedStatement.setDouble(3, fabricante.getFgAtivo());
    }
}
