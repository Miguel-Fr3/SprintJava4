package mapped.api.models.repositories;


import mapped.api.infrastructure.database.DatabaseFactory;
import mapped.api.models.entities.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class LoginRepository {

    public List<Login> findAll() throws SQLException {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT * FROM TB_PS_LOGIN";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                logins.add(new Login(
                        results.getInt("CDLOGIN"),
                        results.getLong("NRCPF"),
                        results.getString("DSSENHA")));
            }
        }
        return logins;
    }

    public void add(Login login) {
        String sql = "INSERT INTO TB_PS_LOGIN (CDLOGIN, NRCPF, DSSENHA) VALUES (seq_tb_ps_login.NEXTVAL, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, login.getCPF());
            statement.setString(2, login.getSenha());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Erro: Violação de chave única. Certifique-se de que a sequência 'seq_tb_ps_login' está configurada corretamente.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar login", e);
        }
    }


    public Optional<Login> find(int id) throws SQLException {
        String sql = "SELECT * FROM TB_PS_LOGIN WHERE CDLOGIN = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int cdLogin = rs.getInt("CDLOGIN");
                    int nrCpf = rs.getInt("NRCPF");
                    String dsSenha = rs.getString("DSSENHA");

                    Login login = new Login(cdLogin, nrCpf, dsSenha);
                    return Optional.of(login);
                }
            }
        }
        return Optional.empty();
    }

    public Login login(long CPF) throws SQLException {
        String sql = "SELECT * FROM TB_PS_LOGIN WHERE NRCPF = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            try {
                statement.setLong(1, CPF);


            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("CPF inválido", e);
            }

            try (ResultSet rs = statement.executeQuery()) {
                Login login = new Login();

                if (rs.next()) {
                            login.setId(rs.getInt("CDLOGIN"));
                            login.setCPF(rs.getLong("NRCPF"));
                            login.setSenha(rs.getString("DSSENHA"));
                }

                return login;
            }
        }

    }

    public void update(Login login) {
        String sql = "UPDATE TB_PS_LOGIN SET NRCPF = ?, DSSENHA = ? WHERE CDLOGIN = ?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, login.getCPF());
            statement.setString(2, login.getSenha());
            statement.setInt(3, login.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM TB_PS_LOGIN WHERE CDLOGIN = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
