package mapped.api.models.repositories;

import mapped.api.infrastructure.database.DatabaseFactory;
import mapped.api.models.entities.MotoristaParceiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MotoristaParceiroRepository {

    private PreparedStatement preparedStatement;
    private MotoristaParceiro motoristaParceiro;

    public List<MotoristaParceiro> findAll() throws SQLException {

        List<MotoristaParceiro> motoristasParceiros = new ArrayList<>();
        String sql = "SELECT * FROM TB_PS_MOTPAR";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {

                motoristasParceiros.add(mapResultSetToMotoristaParceiro(results));
     }
        }
        return motoristasParceiros;
    }

    public void add(MotoristaParceiro motoristaParceiro) throws SQLException {
        String sql = "INSERT INTO TB_PS_MOTPAR (nmMotorista, nrCep, nmRua, nmCidade, nmEstado, dsComplemento, nrCpf, dsNumeroEndereco, fgAtivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setMotoristaParceiroParameters(statement, motoristaParceiro);
            statement.executeUpdate();
        }
    }

    public Optional<MotoristaParceiro> find(int id) throws SQLException {
        String sql = "SELECT * FROM TB_PS_MOTPAR WHERE cdMotorista = ?";
        MotoristaParceiro motoristaParceiro = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    motoristaParceiro = mapResultSetToMotoristaParceiro(rs);
                }
            }
        }
        return Optional.ofNullable(motoristaParceiro);
    }

    public void update(int id, MotoristaParceiro motoristaParceiro) {
        String sql = "UPDATE TB_PS_MOTPAR SET nmMotorista=?, nrCep=?, nmRua=?, nmCidade=?, nmEstado=?, dsComplemento=?, nrCpf=?, dsNumeroEndereco=?, fgAtivo=? WHERE cdMotorista=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setMotoristaParceiroParameters(statement, motoristaParceiro);
            statement.setInt(10, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_MOTPAR WHERE cdMotorista = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private MotoristaParceiro mapResultSetToMotoristaParceiro(ResultSet resultSet) throws SQLException {
        return new MotoristaParceiro(
                resultSet.getInt("cdMotorista"),
                resultSet.getString("nmMotorista"),
                resultSet.getInt("nrCep"),
                resultSet.getString("nmRua"),
                resultSet.getString("nmCidade"),
                resultSet.getString("nmEstado"),
                resultSet.getString("dsComplemento"),
                resultSet.getInt("nrCpf"),
                resultSet.getInt("dsNumeroEndereco"),
                resultSet.getInt("fgAtivo")
        );
    }

    private void setMotoristaParceiroParameters(PreparedStatement preparedStatement, MotoristaParceiro motoristaParceiro) throws SQLException {
        this.preparedStatement = preparedStatement;
        this.motoristaParceiro = motoristaParceiro;
        preparedStatement.setString(1, motoristaParceiro.getNmMotorista());
        preparedStatement.setInt(2, motoristaParceiro.getNrCep());
        preparedStatement.setString(3, motoristaParceiro.getNmRua());
        preparedStatement.setString(4, motoristaParceiro.getNmCidade());
        preparedStatement.setString(5, motoristaParceiro.getNmEstado());
        preparedStatement.setString(6, motoristaParceiro.getDsComplemento());
        preparedStatement.setInt(7, motoristaParceiro.getNrCpf());
        preparedStatement.setInt(8, motoristaParceiro.getDsNumeroEndereco());
        preparedStatement.setInt(9, motoristaParceiro.getFgAtivo());
    }
}
