package Mapped.api.models.repositories;

import Mapped.api.infrastructure.database.DatabaseFactory;
import Mapped.api.models.entities.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class EmpresaRepository {

    

    public List<Empresa> findAll() throws SQLException {
        List<Empresa> empresas = new ArrayList<>();
        String sql = "SELECT * FROM TB_PS_EMPRESA";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                empresas.add(mapResultSetToEmpresa(results));
            }
        }
        return empresas;
    }

    public void add(Empresa empresa) throws SQLException {
        String sql = "INSERT INTO TB_PS_EMPRESA (nmEmpresa, nrNumero, nmRua, dsComplemento, nmBairro, nmCidade, sgEstado, nrCep, nrDddContato, dsEmailContato, nrCnpj, dsRazaoSocial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setEmpresaParameters(statement, empresa);
            statement.executeUpdate();
        }
    }

    public Optional<Empresa> find(int id) throws SQLException {
        String sql = "SELECT * FROM TB_PS_EMPRESA WHERE cdEmpresa = ?";
        Empresa empresa = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    empresa = mapResultSetToEmpresa(rs);
                }
            }
        }
        return Optional.ofNullable(empresa);
    }

    public void update(int id, Empresa empresa) {
        String sql = "UPDATE TB_PS_EMPRESA SET nmEmpresa=?, nrNumero=?, nmRua=?, dsComplemento=?, nmBairro=?, nmCidade=?, sgEstado=?, nrCep=?, nrDddContato=?, dsEmailContato=?, nrCnpj=?, dsRazaoSocial=? WHERE cdEmpresa=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setEmpresaParameters(statement, empresa);
            statement.setInt(13, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_EMPRESA WHERE cdEmpresa = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Empresa mapResultSetToEmpresa(ResultSet resultSet) throws SQLException {
        return new Empresa(
                resultSet.getInt("cdEmpresa"),
                resultSet.getString("nmEmpresa"),
                resultSet.getLong("nrNumero"),
                resultSet.getString("nmRua"),
                resultSet.getString("dsComplemento"),
                resultSet.getString("nmBairro"),
                resultSet.getString("nmCidade"),
                resultSet.getString("sgEstado"),
                resultSet.getLong("nrCep"),
                resultSet.getLong("nrDddContato"),
                resultSet.getString("dsEmailContato"),
                resultSet.getLong("nrCnpj"),
                resultSet.getString("dsRazaoSocial")
        );
    }

    private void setEmpresaParameters(PreparedStatement preparedStatement, Empresa empresa) throws SQLException {
        preparedStatement.setString(1, empresa.getNmEmpresa());
        preparedStatement.setLong(2, empresa.getNrNumero());
        preparedStatement.setString(3, empresa.getNmRua());
        preparedStatement.setString(4, empresa.getDsComplemento());
        preparedStatement.setString(5, empresa.getNmBairro());
        preparedStatement.setString(6, empresa.getNmCidade());
        preparedStatement.setString(7, empresa.getSgEstado());
        preparedStatement.setLong(8, empresa.getNrCep());
        preparedStatement.setLong(9, empresa.getNrDddContato());
        preparedStatement.setString(10, empresa.getDsEmailContato());
        preparedStatement.setLong(11, empresa.getNrCnpj());
        preparedStatement.setString(12, empresa.getDsRazaoSocial());
    }
}
