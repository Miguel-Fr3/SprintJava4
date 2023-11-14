package Mapped.api.models.repositories;

import Mapped.api.infrastructure.database.DatabaseFactory;
import Mapped.api.models.entities.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginRepository {

    public List<Login> findAll() throws SQLException {
        var logins = new ArrayList<Login>();
        var sql = "SELECT * FROM TB_PS_LOGIN";

        try (var conn = DatabaseFactory.getConnection();
             var statement = conn.prepareStatement(sql);
             var results = statement.executeQuery()) {
            while (results.next()) {
                logins.add(new Login(
                        results.getInt("CDLOGIN"),
                        results.getInt("NRCPF"),
                        results.getString("DSSENHA")));
            }
        }
        return logins;
    }

    public void add(Login login) throws SQLException {
        var sql = "INSERT INTO TB_PS_LOGIN (CDLOGIN, NRCPF, DSSENHA) VALUES (?, ?, ?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, login.getId());
            statement.setInt(2, login.getCPF());
            statement.setString(3, login.getSenha());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Optional<Login> find(int id) throws SQLException {
        var sql = "SELECT * FROM TB_PS_LOGIN WHERE CDLOGIN = ?";

        try (var conn = DatabaseFactory.getConnection();
             var statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int cdLogin = rs.getInt("CDLOGIN");
                    int nrCpf = rs.getInt("NRCPF");
                    String dsSenha = rs.getString("DSSENHA");

                    var login = new Login(cdLogin, nrCpf, dsSenha);
                    return Optional.ofNullable(login);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.empty();
    }

    public Login login(String CPF) throws SQLException {
        var sql = "SELECT * FROM TB_PS_LOGIN WHERE NRCPF = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);

            try {
                int cpf = Integer.parseInt(CPF);
                statement.setInt(1, cpf);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("CPF inválido", e);
            }

            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    var login = new Login(
                            rs.getInt("CDLOGIN"),
                            rs.getInt("NRCPF"),
                            rs.getString("DSSENHA"));
                    return login;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return null;
    }

    public void update(Login login) {
        var sql = "UPDATE TB_PS_LOGIN SET NRCPF = ?, DSSENHA = ? WHERE CDLOGIN = ?";
        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, login.getCPF());
            statement.setString(2, login.getSenha());
            statement.setInt(3, login.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_LOGIN WHERE CDLOGIN = ?";

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
