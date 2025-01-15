package com.soujanyautils.tablebox.cement;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class TextContext {

    private Float startingPtX;
    private Float startingPtY;
    private PDPageContentStream contentStream;
    private Float maxCellLength;
    private PDFont font;
    private Float endPtX;
    private Float endPtY;
    private Float tableEndY;
    private PDDocument document;
    private Queue<PageOverFlowState> pageOverFlows = new LinkedList<>();

    public PDDocument getDocument() {
        return document;
    }

    public void setDocument(PDDocument document) {
        this.document = document;
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

    private Float textHeight;

    public Float getTextPadding() {
        return textPadding;
    }

    public void setTextPadding(Float textPadding) {
        this.textPadding = textPadding;
    }

    private Float textPadding;

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
