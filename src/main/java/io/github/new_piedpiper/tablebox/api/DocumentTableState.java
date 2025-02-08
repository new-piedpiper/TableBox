package io.github.new_piedpiper.tablebox.api;

import org.apache.pdfbox.pdmodel.PDDocument;

public class DocumentTableState {

    private PDDocument document;
    private float currentPosX;
    private float currentPosY;
    private int currentPage;

    public PDDocument getDocument() {
        return document;
    }

    public void setDocument(PDDocument document) {
        this.document = document;
    }

    public float getCurrentPosX() {
        return currentPosX;
    }

    public void setCurrentPosX(float currentPosX) {
        this.currentPosX = currentPosX;
    }

    public float getCurrentPosY() {
        return currentPosY;
    }

    public void setCurrentPosY(float currentPosY) {
        this.currentPosY = currentPosY;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
