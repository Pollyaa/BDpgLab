package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyPostgreConnection implements IConnection {
    private Connection pgConn = null;
    private String url;
    private String user;
    private String pass;

    private MyPostgreConnection(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }

    public static IConnection createConnection(String url, String user, String pass) {
        return new MyPostgreConnection(url, user, pass);
    }

    @Override
    public void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            pgConn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to PostgreSQL database successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getName() + ": " + e.getMessage());
        }
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


