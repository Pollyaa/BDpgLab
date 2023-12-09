package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("==== Welcome to MyRDBMS ====");

        IConnection connection = MyPostgreConnection.createConnection(
                "jdbc:postgresql://localhost:5432/dance_studio_",
                "postgres",
                "1234");
        connection.connect();

        IConnection connSQLite = MySQLiteConnection.createConnection("jdbc:sqlite:DataBase.db");
        connSQLite.connect();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a datasource:");
        System.out.println("1. PostgreSQL");
        System.out.println("2. SQLite");

        int choice = scanner.nextInt();

        ITable table = null;
        ICursor tableCursor = null;

        switch (choice) {
            case 1:
                System.out.println("Enter PostgreSQL connection parameters:");
                System.out.print("URL: ");
                String pgUrl = scanner.next();
                System.out.print("User: ");
                String pgUser = scanner.next();
                System.out.print("Password: ");
                String pgPassword = scanner.next();

                connection = MyPostgreConnection.createConnection(pgUrl, pgUser, pgPassword);
                connection.connect();


                tableCursor = connection.getRecordsFromTable("student");
                tableCursor.printCursor(tableCursor);


                table = (MyPostgreTable) tableCursor;
                break;

            case 2:
                System.out.println("Enter SQLite connection parameters:");
                System.out.print("URL: ");
                String sqliteUrl = scanner.next();

                connection = MySQLiteConnection.createConnection(sqliteUrl);
                connection.connect();

                ITable sqliteTable = (ITable) connection.getRecordsFromTable("Person");
                ICursor sqliteTableCursor = sqliteTable.getAllRecords();
                sqliteTableCursor.printCursor(sqliteTableCursor);

                ArrayList<String> otherValues = new ArrayList<>();
                otherValues.add("'value1'");
                otherValues.add("'value2'");
                sqliteTable.insertRecord(otherValues);

                sqliteTableCursor = sqliteTable.getAllRecords();
                sqliteTableCursor.printCursor(sqliteTableCursor);
                break;
        }

        if (connection != null) {
            System.out.println("Connected to the database.");
        }

        if (table != null) {

            ArrayList<String> values = new ArrayList<>();
            values.add("'test2'");
            table.insertRecord(values);

            tableCursor = table.getAllRecords();
            tableCursor.printCursor(tableCursor);
        }
        System.out.println("==== THE END ====");
    }
}

