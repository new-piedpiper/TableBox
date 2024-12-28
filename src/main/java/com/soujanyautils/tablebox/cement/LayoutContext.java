package com.soujanyautils.tablebox.cement;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

public class LayoutContext {

    private float xStart;
    private float yStart;
    private float xStop;
    private float yStop;
    private PDPageContentStream contentStream;
    private float lineWidth;
    private float columnWidth;

    public float getColumnWidth() {
        return columnWidth;
    }

    public void setColumnWidth(float columnWidth) {
        this.columnWidth = columnWidth;
    }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
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
