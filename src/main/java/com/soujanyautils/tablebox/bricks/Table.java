package com.soujanyautils.tablebox.bricks;

import java.util.List;

public class Table {

    private float cellWidth;

    private List<Row> records;

    public float getCellWidth() {
        return cellWidth;
    }

    public void setCellWidth(float cellWidth) {
        this.cellWidth = cellWidth;
    }

    public List<Row> getRecords() {
        return records;
    }

    public void setRecords(List<Row> records) {
        this.records = records;
    }
}
