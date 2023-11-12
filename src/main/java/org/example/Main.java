package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        System.out.println("==== Welcome to MyRDBMS ====");

        PostgreSQLJDBC connection = new PostgreSQLJDBC(
                "jdbc:postgresql://localhost:5432/dance_studio_",
                "postgres",
                "1234");

        connection.openConnection();

        System.out.println("==== THE END ====");
    }
}
