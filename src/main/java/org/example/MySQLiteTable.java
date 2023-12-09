package org.example;

import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class MySQLiteTable extends MySQLiteCursor implements ITable {
    String tableName;
    IConnection connection;

    public MySQLiteTable(ResultSet rs, IConnection connection) {
        super(rs);
        this.connection = connection;
    }

    @Override
    public void removeRecord(Integer row) {
        try {
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM " + tableName + " WHERE id = " + row;
            stmt.executeUpdate(query);
            System.out.println("Record with id " + row + " has been removed.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertRecord(ArrayList<String> values) {
        String valuesString = StringUtils.join(values, ",");
        String query = "INSERT INTO " + tableName + " VALUES ( " + valuesString + " )";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Record inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting record: " + e.getMessage());
        }
    }

    @Override
    public void updateRecord(Integer row, String column, String newValue) {
        try {
            Statement stmt = connection.createStatement();
            String query = "UPDATE " + tableName + " SET " + column + " = '" + newValue + "' WHERE id = " + row;
            stmt.executeUpdate(query);
            System.out.println("Record with id " + row + " has been updated.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ICursor getAllRecords() {
        String query = "SELECT * FROM " + tableName;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            return new MySQLiteCursor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MySQLiteCursor(null);
    }
}

