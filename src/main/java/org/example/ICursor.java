package org.example;

public interface ICursor {
    Integer getRecordCount();
    Integer getColumnsCount();
    String getColumnName(Integer index);
    boolean first();
    boolean last();
    int getRow();
    boolean next();
    boolean previous();
    String getValue(Integer column);
    String getValue(String column);
}

