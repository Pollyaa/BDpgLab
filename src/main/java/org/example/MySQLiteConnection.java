package org.example;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLiteConnection implements IConnection {
    private Connection pgConn = null;
    private MySQLiteConnection (Connection pgConnection) {
        pgConn = pgConnection;
    }

    public static IConnection openConnection(String url)  {

        Connection sqliteConn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            sqliteConn = DriverManager.getConnection(url);

            System.out.println("Opened database successfully");
        } catch ( Exception e ) {
            System.out.println("Error: " + e.getClass().getName()+": " + e.getMessage());
        }

        return new MySQLiteConnection(sqliteConn);
    }
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
