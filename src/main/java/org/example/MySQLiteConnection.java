package org.example;

import java.sql.*;

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
    public Statement createStatement() {
        try {
            if (sqliteConn != null) {
                return sqliteConn.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
    public ResultSet execute(String query) throws SQLException {
        Statement statement = sqliteConn.createStatement();
        return statement.executeQuery(query);
    }
    @Override
    public ICursor getAllTables() {
        try {
            if (sqliteConn != null) {
                Statement stmt = sqliteConn.createStatement();
                String query = "SELECT name FROM sqlite_master WHERE type='table'";
                ResultSet rs = stmt.executeQuery(query);
                return new MySQLiteCursor(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MySQLiteCursor(null);
    }
    @Override
    public void executeUpdate(String query) {
        try {
            Statement stmt = sqliteConn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
    @Override
    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = sqliteConn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public ICursor getRecordsFromTable(String tableName) {
        try {
            if (sqliteConn != null) {
                Statement stmt = sqliteConn.createStatement();
                String query = "SELECT * FROM " + tableName;
                ResultSet rs = stmt.executeQuery(query);
                return new MySQLiteCursor(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


