package io.debezium.performance.dmt.schema;

import java.util.List;
import java.util.Objects;

public class DatabaseEntry {

    private List<DatabaseColumnEntry> columnEntries;
    private final DatabaseTable databaseTableMetadata;

    public DatabaseEntry(List<DatabaseColumnEntry> columnEntries, DatabaseTable databaseTableMetadata) {
        this.columnEntries = columnEntries;
        this.databaseTableMetadata = databaseTableMetadata;
    }

    public DatabaseEntry() {
        databaseTableMetadata = new DatabaseTable();
    }

    public List<DatabaseColumnEntry> getColumnEntries() {
        return columnEntries;
    }

    public void setColumnEntries(List<DatabaseColumnEntry> columnEntries) {
        this.columnEntries = columnEntries;
    }

    public void addColumnEntry(DatabaseColumnEntry columnEntry) {
        columnEntries.add(columnEntry);
    }

    public DatabaseTable getDatabaseTableMetadata() {
        return databaseTableMetadata;
    }


    /**
     * @return DatabaseColumnEntry which is the primary in this DatabaseEntry
     */
    public DatabaseColumnEntry getPrimaryColumnEntry() {
        String primaryColumnName = databaseTableMetadata.getPrimary();
        for (DatabaseColumnEntry columnEntry : columnEntries) {
            if (columnEntry.columnName().equals(primaryColumnName)) {
                return columnEntry;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DatabaseEntity{" +
                "columnEntries=" + columnEntries +
                ", databaseTable=" + databaseTableMetadata +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DatabaseEntry that = (DatabaseEntry) o;
        return columnEntries.equals(that.columnEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnEntries);
    }
}
