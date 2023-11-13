package org.example;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyPostgreConnection implements IConnection {
    private Connection pgConn = null;
    private MyPostgreConnection (Connection pgConnection) {
        pgConn = pgConnection;
    }
    public static IConnection openConnection(String url, String user, String pass)  {

        Connection pgConn = null;
        try {
            Class.forName("org.postgresql.Driver");
            pgConn = DriverManager.getConnection(url, user, pass);

            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getName()+": " + e.getMessage());
        }

        return new MyPostgreConnection(pgConn);
    }
}


