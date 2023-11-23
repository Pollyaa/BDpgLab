package org.example;

public interface IConnection {
    void connect();
    void getTables();
    void getTable(String tableName);
    void getTableInfo(String tableName);
    void execute(String query);
}

