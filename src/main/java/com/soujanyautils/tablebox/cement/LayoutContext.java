package com.soujanyautils.tablebox.cement;

import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;

public class LayoutContext {

    private float xStart;
    private float yStart;
    private float xStop;
    private float yStop;
    private PDPageContentStream contentStream;
    private float tableWidth;
    private float columnWidth;
    private float xLineStart;
    private float yLineStart;
    private float xLineStop;
    private float yLineStop;
    private float lineWidth;
    private Color lineColor;

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public float getxLineStart() {
        return xLineStart;
    }

    public void setxLineStart(float xLineStart) {
        this.xLineStart = xLineStart;
    }

    public float getyLineStart() {
        return yLineStart;
    }

    public void setyLineStart(float yLineStart) {
        this.yLineStart = yLineStart;
    }

    public float getxLineStop() {
        return xLineStop;
    }

    public void setxLineStop(float xLineStop) {
        this.xLineStop = xLineStop;
    }

    public float getyLineStop() {
        return yLineStop;
    }

    public void setyLineStop(float yLineStop) {
        this.yLineStop = yLineStop;
    }

    public float getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(float columnWidth) {
        this.columnWidth = columnWidth;
    }

    public float getTableWidth() {
        return tableWidth;
    }

    public void setTableWidth(float tableWidth) {
        this.tableWidth = tableWidth;
    }

    public PDPageContentStream  getContentStream() {
        return contentStream;
    }

    public void setContentStream(PDPageContentStream  contentStream) {
        this.contentStream = contentStream;
    }

    public float getyStop() {
        return yStop;
    }

    public void setyStop(float yStop) {
        this.yStop = yStop;
    }

    public float getxStop() {
        return xStop;
    }

    public void setxStop(float xStop) {
        this.xStop = xStop;
    }

    public float getyStart() {
        return yStart;
    }

    public void setyStart(float yStart) {
        this.yStart = yStart;
    }

    public float getxStart() {
        return xStart;
    }

    public void setxStart(float xStart) {
        this.xStart = xStart;
    }

}
