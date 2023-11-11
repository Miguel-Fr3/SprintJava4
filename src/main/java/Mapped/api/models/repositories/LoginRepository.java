package Mapped.api.models.repositories;


import Mapped.api.infrastructure.database.DatabaseFactory;
import Mapped.api.models.entities.Login;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginRepository {

    public List<Login> findAll() throws SQLException{
        var logins = new ArrayList<Login>();
        var sql = "SELECT * FROM TB_PS_LOGIN";

        try(var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            var results = statement.executeQuery()
        ){
            while(results.next()){
                logins.add(new Login(
                        results.getInt("CDLOGIN"),
                        results.getString("NRCPF"),
                        results.getString("DSSENHA")));

            }
        }
        return logins;
    }

    public void add(Login login) throws SQLException
    {
        var sql = "INSERT INTO TB_PS_LOGIN (CDLOGIN,NRCPF, DSSENHA" +
                " VALUES (?,?,?)";

        try
        {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, login.getId());
            statement.setString(2, login.getCPF());
            statement.setString(3, login.getSenha());
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
        }
    }

    public Optional<Login> find(int id) throws SQLException{
        var sql = "SELECT * FROM TB_PS_LOGIN WHERE id = ?";


        try{
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            try{
                ResultSet rs = statement.executeQuery();
                if(rs.next()) {
                    var login = new Login(
                            rs.getInt("CDLOGIN"),
                            rs.getString("NRCPF"),
                            rs.getString("DSSENHA"));;
                    return Optional.ofNullable(login);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return Optional.empty();
    }
    public Login login(String CPF) throws SQLException{
        var sql = "SELECT * FROM TB_PS_LOGIN WHERE NRCPF = ?";


        try{
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, CPF);
            try{
                ResultSet rs = statement.executeQuery();
                if(rs.next()) {
                    var login = new Login(
                            rs.getInt("CDLOGIN"),
                            rs.getString("NRCPF"),
                            rs.getString("DSSENHA"));;
                    return login;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        catch (SQLException e)
        {
            throw new SQLException(e);
        }
        return null;
    }

    public void update(Login login ) {
        var sql = "UPDATE TB_PS_LOGIN SET NRCPF = ?, DSSENHA = ? WHERE CDLOGIN = ?";
        try{
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, login.getCPF());
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
