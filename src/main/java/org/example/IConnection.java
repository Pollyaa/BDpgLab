package org.example;
import java.sql.Connection;

public interface IConnection {
    void connect();
    void getTables();
    void getTable(String tableName);
    void getTableInfo(String tableName);
    void execute(String query);
}


