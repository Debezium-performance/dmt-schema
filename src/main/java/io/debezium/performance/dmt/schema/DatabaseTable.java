package io.debezium.performance.dmt.schema;

import java.util.Objects;

public class DatabaseTable {
    private String name;
    private String primary;

    public DatabaseTable(String name, String primary) {
        this.name = name;
        this.primary = primary;
    }

    public DatabaseTable() {
        name = "UNDEFINED";
        primary = "UNDEFINED";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    @Override
    public String toString() {
        return "DatabaseTable{" +
                "name='" + name + '\'' +
                ", primary='" + primary + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DatabaseTable that = (DatabaseTable) o;
        return Objects.equals(name, that.name) && Objects.equals(primary, that.primary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, primary);
    }
}
