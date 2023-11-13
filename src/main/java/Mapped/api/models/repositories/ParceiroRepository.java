package Mapped.api.models.repositories;

import Mapped.api.infrastructure.database.DatabaseFactory;
import Mapped.api.models.entities.Parceiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParceiroRepository {

    public List<Parceiro> findAll() throws SQLException {
        List<Parceiro> parceiros = new ArrayList<>();

        String sql = "SELECT * FROM TB_PS_PARC";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                parceiros.add(mapResultSetToParceiro(results));
            }
        }
        return parceiros;
    }

    public void add(Parceiro parceiro) throws SQLException {

        String sql = "INSERT INTO TB_PS_PARC (nmParceiro, nrCep, nmRua, nmCidade, nmEstado, dsComplemento, nrCpf, dsNumeroEndereco, fgAtivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setParceiroParameters(statement, parceiro);
            statement.executeUpdate();
        }
    }

    public Optional<Parceiro> find(int id) throws SQLException {

        String sql = "SELECT * FROM TB_PS_PARC WHERE cdParceiro = ?";
        Parceiro parceiro = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    parceiro = mapResultSetToParceiro(rs);
                }
            }
        }
        return Optional.ofNullable(parceiro);
    }

    public void update(int id, Parceiro parceiro) {

        String sql = "UPDATE TB_PS_PARC SET nmParceiro=?, nrCep=?, nmRua=?, nmCidade=?, nmEstado=?, dsComplemento=?, nrCpf=?, dsNumeroEndereco=?, fgAtivo=? WHERE cdParceiro=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setParceiroParameters(statement, parceiro);
            statement.setInt(10, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        
        String sql = "DELETE FROM TB_PS_PARC WHERE cdParceiro = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Parceiro mapResultSetToParceiro(ResultSet resultSet) throws SQLException {
        return new Parceiro(
                resultSet.getInt("cdParceiro"),
                resultSet.getString("nmParceiro"),
                resultSet.getDouble("nrCep"),
                resultSet.getString("nmRua"),
                resultSet.getString("nmCidade"),
                resultSet.getString("nmEstado"),
                resultSet.getString("dsComplemento"),
                resultSet.getDouble("nrCpf"),
                resultSet.getDouble("dsNumeroEndereco"),
                resultSet.getDouble("fgAtivo")
        );
    }

    private void setParceiroParameters(PreparedStatement preparedStatement, Parceiro parceiro) throws SQLException {
        preparedStatement.setString(1, parceiro.getNmParceiro());
        preparedStatement.setDouble(2, parceiro.getNrCep());
        preparedStatement.setString(3, parceiro.getNmRua());
        preparedStatement.setString(4, parceiro.getNmCidade());
        preparedStatement.setString(5, parceiro.getNmEstado());
        preparedStatement.setString(6, parceiro.getDsComplemento());
        preparedStatement.setDouble(7, parceiro.getNrCpf());
        preparedStatement.setDouble(8, parceiro.getDsNumeroEndereco());
        preparedStatement.setDouble(9, parceiro.getFgAtivo());
    }
}
