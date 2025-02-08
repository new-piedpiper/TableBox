package io.github.new_piedpiper.tablebox.bricks;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.util.ArrayList;
import java.util.List;

public class Table {

    PDRectangle tableDimensions;

    public PDRectangle getTableDimensions() {
        return tableDimensions;
    }

    public void setTableDimensions(PDRectangle tableDimensions) {
        this.tableDimensions = tableDimensions;
    }

    private float cellWidth;

    private List<Row> records = new ArrayList<>();

    private Integer noOfColumns;

    public Integer getNoOfColumns() {
        return noOfColumns;
    }

    public void setNoOfColumns(Integer noOfColumns) {
        this.noOfColumns = noOfColumns;
    }

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
