package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        System.out.println("==== Welcome to MyRDBMS ====");

        // TODO: get the connection params from the user input
        //  1. Choose the Datasource - PostgreSQL / SQLite
        //  2. Enter needed connection params (url, user, pass)

        IConnection connection = MyPostgreConnection.openConnection(
                "jdbc:postgresql://localhost:5432/dance_studio_",
                "postgres",
                "1234");

        IConnection connSQlite = MySQLiteConnection.openConnection("jdbc:sqlite:test.db");

        // TODO [OPTIONAL] - implement MyCSVConnection

        System.out.println("==== THE END ====");
    }
}
