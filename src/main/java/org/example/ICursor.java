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
    default void printCursor(ICursor cursor) {
        Integer cols = cursor.getColumnsCount();
        Integer rows = cursor.getRecordCount();

        while (cursor.next()) {
            String lastName = cursor.getValue(1);
            System.out.println(lastName + "\n");
        }
    }
}

