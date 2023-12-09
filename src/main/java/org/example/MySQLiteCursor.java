package org.example;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLiteCursor implements ICursor {
    private ResultSet resultSet;

    public MySQLiteCursor(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public Integer getRecordCount() {
        int count = 0;
        try {
            resultSet.last();
            count = resultSet.getRow();
            resultSet.beforeFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Integer getColumnsCount() {
        try {
            return resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public String getColumnName(Integer index) {
        try {
            return resultSet.getMetaData().getColumnName(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean first() {
        try {
            return resultSet.first();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean last() {
        try {
            return resultSet.last();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public int getRow() {
        try {
            return resultSet.getRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean next() {
        try {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean previous() {
        try {
            return resultSet.previous();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getValue(String column) {
        try {
            return resultSet.getString(column);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void removeRecord(Integer row) {
    }
}




