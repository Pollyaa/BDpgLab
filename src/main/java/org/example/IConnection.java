package org.example;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IConnection {
    void connect();
    void getTables();
    void getTable(String tableName);
    void getTableInfo(String tableName);
    public ResultSet execute(String query) throws SQLException;

    ICursor getAllTables();

    ICursor getRecordsFromTable(String tableName);

    Statement createStatement();
    ResultSet executeQuery(String query);
    void executeUpdate(String query);
}


