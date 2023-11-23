package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyPostgreConnection implements IConnection {
    private Connection pgConn = null;

    private MyPostgreConnection(Connection pgConnection) {
        pgConn = pgConnection;
    }

    public static IConnection createConnection(String url, String user, String pass) {
        Connection pgConn = null;
        try {
            Class.forName("org.postgresql.Driver");
            pgConn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to PostgreSQL database successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getName() + ": " + e.getMessage());
        }
        return new MyPostgreConnection(pgConn);
    }

    @Override
    public void connect() {
    }
    @Override
    public void getTables() {
    }
    @Override
    public void getTable(String tableName) {
    }
    @Override
    public void getTableInfo(String tableName) {
    }
    @Override
    public void execute(String query) {
    }
}


