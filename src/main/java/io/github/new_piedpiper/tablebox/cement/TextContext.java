package io.github.new_piedpiper.tablebox.cement;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class TextContext {

    private Float startingPtX;
    private Float startingPtY;
    private PDPageContentStream contentStream;
    private Float maxCellLength;
    private PDFont font;
    private Float endPtY;
    private Float tableEndY;
    private Float textHeight;
    private Queue<PageOverFlowState> pageOverFlows = new LinkedList<>();
    private String currText;
    private Float fontSize;
    private Float textPadding;
    private PDFont columnNameFont;
    private Color fontColor;

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public PDFont getColumnNameFont() {
        return columnNameFont;
    }

    public void setColumnNameFont(PDFont columnNameFont) {
        this.columnNameFont = columnNameFont;
    }

    public Float getTableEndY() {
        return tableEndY;
    }

    public void setTableEndY(Float tableEndY) {
        this.tableEndY = tableEndY;
    }

    public Float getTextHeight() {
        return textHeight;
    }

    public void setTextHeight(Float textHeight) {
        this.textHeight = textHeight;
    }

    public Float getTextPadding() {
        return textPadding;
    }

    public void setTextPadding(Float textPadding) {
        this.textPadding = textPadding;
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

    public Float getMaxCellLength() {
        return maxCellLength;
    }

    public void setMaxCellLength(Float maxCellLength) {
        this.maxCellLength = maxCellLength;
    }

    public String getCurrText() {
        return currText;
    }

    public void setCurrText(String currText) {
        this.currText = currText;
    }

    public PDPageContentStream getContentStream() {
        return contentStream;
    }

    public Queue<PageOverFlowState> getPageOverFlows() {
        return pageOverFlows;
    }

    public void setPageOverFlows(Queue<PageOverFlowState> pageOverFlows) {
        this.pageOverFlows = pageOverFlows;
    }

    public void setContentStream(PDPageContentStream contentStream) {
        this.contentStream = contentStream;
    }

}
