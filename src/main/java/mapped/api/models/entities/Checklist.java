package mapped.api.models.entities;

import mapped.api.infrastructure.database.DatabaseFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Checklist {

	private Integer cdChecklis;
    private Date dtCadastroChecklist;
    private String dsChecklist;

    public Checklist() {
    }

    public Checklist(Integer cdChecklis, Date dtCadastroChecklist, String dsChecklist) {
        this.cdChecklis = cdChecklis;
        this.dtCadastroChecklist = dtCadastroChecklist;
        this.dsChecklist = dsChecklist;
    }

    public Integer getCdChecklis() {
        return cdChecklis;
    }

    public void setCdChecklis(Integer cdChecklis) {
        this.cdChecklis = cdChecklis;
    }

    public Date getDtCadastroChecklist() {
        return dtCadastroChecklist;
    }

    public void setDtCadastroChecklist(Date dtCadastroChecklist) {
        this.dtCadastroChecklist = dtCadastroChecklist;
    }

    public String getDsChecklist() {
        return dsChecklist;
    }

    public void setDsChecklist(String dsChecklist) {
        this.dsChecklist = dsChecklist;
    }

    public static class TipoVeiculoRepository {

        public List<TipoVeiculo> findAll() throws SQLException {
            List<TipoVeiculo> tiposVeiculo = new ArrayList<>();
            String sql = "SELECT * FROM TB_PS_TIPO_VEICULO";

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    tiposVeiculo.add(mapResultSetToTipoVeiculo(results));
                }
            }
            return tiposVeiculo;
        }

        public void add(TipoVeiculo tipoVeiculo) throws SQLException {
            String sql = "INSERT INTO TB_PS_TIPO_VEICULO (dsTipoVeiculo, fgAtivo) VALUES (?, ?)";

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                setTipoVeiculoParameters(statement, tipoVeiculo);
                statement.executeUpdate();
            }
        }

        public Optional<TipoVeiculo> find(int id) throws SQLException {
            String sql = "SELECT * FROM TB_PS_TIPO_VEICULO WHERE cdTpVeic = ?";
            TipoVeiculo tipoVeiculo = null;

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, id);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        tipoVeiculo = mapResultSetToTipoVeiculo(rs);
                    }
                }
            }
            return Optional.ofNullable(tipoVeiculo);
        }

        public void update(int id, TipoVeiculo tipoVeiculo) {
            String sql = "UPDATE TB_PS_TIPO_VEICULO SET dsTipoVeiculo=?, fgAtivo=? WHERE cdTpVeic=?";
            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                setTipoVeiculoParameters(statement, tipoVeiculo);
                statement.setInt(3, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void delete(int id) {
            String sql = "DELETE FROM TB_PS_TIPO_VEICULO WHERE cdTpVeic = ?";

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private TipoVeiculo mapResultSetToTipoVeiculo(ResultSet resultSet) throws SQLException {
            return new TipoVeiculo(
                    resultSet.getInt("cdTpVeic"),
                    resultSet.getString("dsTipoVeiculo"),
                    resultSet.getInt("fgAtivo")
            );
        }

        private void setTipoVeiculoParameters(PreparedStatement preparedStatement, TipoVeiculo tipoVeiculo) throws SQLException {
            preparedStatement.setString(1, tipoVeiculo.getDsTipoVeiculo());
            preparedStatement.setInt(2, tipoVeiculo.getFgAtivo());
        }
    }
}
