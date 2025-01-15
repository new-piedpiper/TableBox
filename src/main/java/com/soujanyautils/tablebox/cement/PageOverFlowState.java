package com.soujanyautils.tablebox.cement;

public class PageOverFlowState {

    private float currentX;
    private float cellValueIndex;
    private String cellValue;

    public float getCurrentX() {
        return currentX;
    }

    public void setCurrentX(float currentX) {
        this.currentX = currentX;
    }

    public float getCellValueIndex() {
        return cellValueIndex;
    }

    public void setCellValueIndex(float cellValueIndex) {
        this.cellValueIndex = cellValueIndex;
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }
}
