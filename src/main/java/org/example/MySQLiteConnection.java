package org.example;
import java.sql.Connection;
import org.example.IConnection;

public class MySQLiteConnection implements IConnection {
    private Connection slConn = null;
    public MySQLiteConnection (Connection slConnection) {
        slConn = slConnection;
    }
}
