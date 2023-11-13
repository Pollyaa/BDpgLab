package org.example;

import java.sql.Connection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("==== Welcome to MyRDBMS ====");

        IConnection connection = MyPostgreConnection.openConnection(
                "jdbc:postgresql://localhost:5432/dance_studio_",
                "postgres",
                "1234");

        IConnection connSQlite = MySQLiteConnection.openConnection("jdbc:sqlite:DataBase.db");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a datasource:");
        System.out.println("1. PostgreSQL");
        System.out.println("2. SQLite");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter PostgreSQL connection parameters:");
                System.out.print("URL: ");
                String pgUrl = scanner.next();
                System.out.print("User: ");
                String pgUser = scanner.next();
                System.out.print("Password: ");
                String pgPassword = scanner.next();

                connection = MyPostgreConnection.openConnection(pgUrl, pgUser, pgPassword);
                break;

            case 2:
                System.out.println("Enter SQLite connection parameters:");
                System.out.print("URL: ");
                String sqliteUrl = scanner.next();

                connection = MySQLiteConnection.openConnection(sqliteUrl);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }

        if (connection != null) {
            System.out.println("Connected to the database.");
        }

        System.out.println("==== THE END ====");
    }
}
