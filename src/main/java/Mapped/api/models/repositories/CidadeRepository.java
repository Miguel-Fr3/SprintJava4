package Mapped.api.models.repositories;

import Mapped.api.infrastructure.database.DatabaseFactory;
import Mapped.api.models.entities.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class CidadeRepository {



    public List<Cidade> findAll() throws SQLException {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * FROM TB_PS_CIDADE";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                cidades.add(mapResultSetToCidade(results));
            }
        }
        return cidades;
    }

    public void add(Cidade cidade) throws SQLException {
        String sql = "INSERT INTO TB_PS_CIDADE (nmCidade) VALUES (?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCidadeParameters(statement, cidade);
            statement.executeUpdate();
        }
    }

    public Optional<Cidade> find(int id) throws SQLException {
        String sql = "SELECT * FROM TB_PS_CIDADE WHERE cdCidade = ?";
        Cidade cidade = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    cidade = mapResultSetToCidade(rs);
                }
            }
        }
        return Optional.ofNullable(cidade);
    }

    public void update(int id, Cidade cidade) {
        String sql = "UPDATE TB_PS_CIDADE SET nmCidade=? WHERE cdCidade=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCidadeParameters(statement, cidade);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_CIDADE WHERE cdCidade = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Cidade mapResultSetToCidade(ResultSet resultSet) throws SQLException {
        return new Cidade(
                resultSet.getInt("cdCidade"),
                resultSet.getString("nmCidade")
        );
    }

    private void setCidadeParameters(PreparedStatement preparedStatement, Cidade cidade) throws SQLException {
        preparedStatement.setString(1, cidade.getNmCidade());
    }
}
