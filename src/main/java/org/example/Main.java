package org.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        System.out.println("==== Welcome to MyRDBMS ====");

        // TODO: get the connection params from the user input

        IConnection connection = MyPostgreConnection.openConnection(
                "jdbc:postgresql://localhost:5432/dance_studio_",
                "postgres",
                "1234");

        // TODO: implement MySQLiteConnection in the same way

        // TODO [OPTIONAL] - implement MyCSVConnection

        System.out.println("==== THE END ====");
    }
}
