package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLiteConnection implements IConnection {
    private Connection sqliteConn = null;
    private String url;

    private MySQLiteConnection(String url) {
        this.url = url;
    }

    public static IConnection createConnection(String url) {
        return new MySQLiteConnection(url);
    }

    @Override
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            sqliteConn = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite database successfully");
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
