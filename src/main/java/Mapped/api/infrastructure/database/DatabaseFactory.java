package Mapped.api.infrastructure.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFactory {
    private static final String URL = "dbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    //"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USERNAME = "rm99997"; //RM
    private static final String PASSWORD = "081104"; //SENHA

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME,PASSWORD);
    }
}
