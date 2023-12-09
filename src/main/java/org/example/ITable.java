package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ITable extends ICursor {
    public void removeRecord(Integer row);
    public void insertRecord(ArrayList<String> values);
    public void updateRecord(Integer row, String column, String newValue);
    ICursor getAllRecords();
}





