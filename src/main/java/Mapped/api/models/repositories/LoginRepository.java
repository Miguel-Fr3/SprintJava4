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
        var sql = "SELECT * FROM #Placeholder#";

        try(var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            var results = statement.executeQuery()
        ){
            while(results.next()){
                logins.add(new Login(
                        results.getInt("id"),
                        results.getString("CPF"),
                        results.getString("Senha")));

            }
        }
        return logins;
    }

    public void add(Login login) throws SQLException
    {
        var sql = "INSERT INTO #PlaceHolder# (id,CPF, Senha" +
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
        var sql = "SELECT * FROM #Placeholder# WHERE id = ?";


        try{
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            try{
                ResultSet rs = statement.executeQuery();
                if(rs.next()) {
                    var login = new Login(
                            rs.getInt("id"),
                            rs.getString("CPF"),
                            rs.getString("Senha"));;
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

    public void update(Login login ) {
        var sql = "UPDATE #Placeholder# SET CPF = ?, Senha = ? WHERE ID = ?";
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
        String sql = "DELETE FROM #Placeholder# WHERE id = ?";

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
