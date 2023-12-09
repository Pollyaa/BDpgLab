package org.example;

import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class MyPostgreTable extends MyPostgreCursor implements ITable {
    String tableName;
    IConnection connection;

    public MyPostgreTable(ResultSet rs) {
        super(rs);
    }

    @Override
    public void removeRecord(Integer row) {
        try {
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM " + tableName + " WHERE id = " + row;
            int deletedRows = stmt.executeUpdate(query);

            if (deletedRows > 0) {
                System.out.println("Record with id " + row + " has been removed.");
            } else {
                System.out.println("Record with id " + row + " not found.");
            }

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
            int updatedRows = stmt.executeUpdate(query);

            if (updatedRows > 0) {
                System.out.println("Record with id " + row + " has been updated.");
            } else {
                System.out.println("Record with id " + row + " not found.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ICursor getAllRecords() {
        return this.getRecords();
    }
}

