package com.soujanyautils.tablebox.cement;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

public class TextContext {

    private Float startingPtX;
    private Float startingPtY;
    private PDPageContentStream contentStream;
    private Float maxCellLength;
    private PDFont font;
    private Float endPtX;
    private Float endPtY;

    public Float getEndPtX() {
        return endPtX;
    }

    public void setEndPtX(Float endPtX) {
        this.endPtX = endPtX;
    }

    public Float getEndPtY() {
        return endPtY;
    }

    public void setEndPtY(Float endPtY) {
        this.endPtY = endPtY;
    }

    public Float getStartingPtY() {
        return startingPtY;
    }

    public void setStartingPtY(Float startingPtY) {
        this.startingPtY = startingPtY;
    }

    public Float getStartingPtX() {
        return startingPtX;
    }

    public void setStartingPtX(Float startingPtX) {
        this.startingPtX = startingPtX;
    }

    public PDFont getFont() {
        return font;
    }

    public void setFont(PDFont font) {
        this.font = font;
    }

    public Float getFontSize() {
        return fontSize;
    }

    public void setFontSize(Float fontSize) {
        this.fontSize = fontSize;
    }

    private Float fontSize;

    public Float getMaxCellLength() {
        return maxCellLength;
    }

    public void setMaxCellLength(Float maxCellLength) {
        this.maxCellLength = maxCellLength;
    }

    public String getCelltext() {
        return celltext;
    }

    public void setCelltext(String celltext) {
        this.celltext = celltext;
    }

    private String celltext;

    public PDPageContentStream getContentStream() {
        return contentStream;
    }

    public void setContentStream(PDPageContentStream contentStream) {
        this.contentStream = contentStream;
    }

}
