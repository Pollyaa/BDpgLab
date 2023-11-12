package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
public class PostgreSQLJDBC {

    Connection connection = null;

    final String url;
    final String user;
    final String pass;

    public PostgreSQLJDBC(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }
    public void openConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            System.out.println("Opened database successfully");
        } catch (Exception e) {
            System.out.println("Error: " + e.getClass().getName()+": " + e.getMessage());
        }
    }
}
