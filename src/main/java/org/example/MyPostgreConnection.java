package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


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
    public ResultSet execute(String query) throws SQLException {
        try {
            Statement stmt = pgConn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new SQLException("Error executing query: " + e.getMessage());
        }
    }

    @Override
    public ICursor getAllTables() {
        try {
            if (pgConn != null) {
                Statement stmt = pgConn.createStatement();
                String query = "SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'";
                ResultSet rs = stmt.executeQuery(query);
                return new MyPostgreCursor(rs);
            }
        } catch (SQLException e) {
            // Обробка помилки, але ви не викидаєте її з методу
            System.out.println(e.getMessage());
        }
        return new MyPostgreCursor(null);
    }

    @Override
    public ICursor getRecordsFromTable(String tableName) {
        if (pgConn != null) {
            String query = "SELECT * FROM " + tableName;
            try {
                return MyPostgreCursor.createScrollableCursor(pgConn, query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Statement createStatement() {
        try {
            return pgConn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = pgConn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void executeUpdate(String query) {
        try {
            Statement stmt = pgConn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}

