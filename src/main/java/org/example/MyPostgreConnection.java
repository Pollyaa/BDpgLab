package org.example;
import java.sql.Connection;
import org.example.IConnection;

public class MyPostgreConnection implements IConnection {
    private Connection pgConn = null;
    public MyPostgreConnection (Connection pgConnection) {
        pgConn = pgConnection;
    }
}
