package mapped.api.models.repositories;

import mapped.api.infrastructure.database.DatabaseFactory;
import mapped.api.models.entities.CategoriaVeiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoriaVeiculoRepository {

    public List<CategoriaVeiculo> findAll() throws SQLException {
        List<CategoriaVeiculo> categoriasVeiculo = new ArrayList<>();
        String sql = "SELECT * FROM TB_PS_CATEGORIA_VEICULO";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                categoriasVeiculo.add(mapResultSetToCategoriaVeiculo(results));
            }
        }
        return categoriasVeiculo;
    }

    public void add(CategoriaVeiculo categoriaVeiculo) throws SQLException {
        String sql = "INSERT INTO TB_PS_CATEGORIA_VEICULO (dsCategoriaVeiculo) VALUES (?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCategoriaVeiculoParameters(statement, categoriaVeiculo);
            statement.executeUpdate();
        }
    }

    public Optional<CategoriaVeiculo> find(int id) throws SQLException {
        String sql = "SELECT * FROM TB_PS_CATEGORIA_VEICULO WHERE cdCtVeiculo = ?";
        CategoriaVeiculo categoriaVeiculo = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    categoriaVeiculo = mapResultSetToCategoriaVeiculo(rs);
                }
            }
        }
        return Optional.ofNullable(categoriaVeiculo);
    }

    public void update(int id, CategoriaVeiculo categoriaVeiculo) {
        String sql = "UPDATE TB_PS_CATEGORIA_VEICULO SET dsCategoriaVeiculo=? WHERE cdCtVeiculo=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCategoriaVeiculoParameters(statement, categoriaVeiculo);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_CATEGORIA_VEICULO WHERE cdCtVeiculo = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private CategoriaVeiculo mapResultSetToCategoriaVeiculo(ResultSet resultSet) throws SQLException {
        return new CategoriaVeiculo(
                resultSet.getInt("cdCtVeiculo"),
                resultSet.getString("dsCategoriaVeiculo")
        );
    }

    private void setCategoriaVeiculoParameters(PreparedStatement preparedStatement, CategoriaVeiculo categoriaVeiculo) throws SQLException {
        preparedStatement.setString(1, categoriaVeiculo.getDsCategoriaVeiculo());
    }
}
