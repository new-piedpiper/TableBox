package io.github.new_piedpiper.tablebox.api;

import org.apache.pdfbox.pdmodel.PDDocument;

/**
 * Model class for getting the cursor position of the document and the current page index after creating the table
 * @author anugrahv
 */
public class DocumentTableState {

    private PDDocument document;
    private float currentPosX;
    private float currentPosY;
    private int currentPage;

    /**
     * Fetch the document in which the table is created
     * @return Document
     */
    public PDDocument getDocument() {
        return document;
    }

    public void setDocument(PDDocument document) {
        this.document = document;
    }

    /**
     * Fetches the x coordinate of the last page.
     * @return xCoordinate
     */
    public float getCurrentPosX() {
        return currentPosX;
    }

    public void setCurrentPosX(float currentPosX) {
        this.currentPosX = currentPosX;
    }

    /**
     * Fetches the y coordinate of the last page.
     * @return yCoordinate
     */
    public float getCurrentPosY() {
        return currentPosY;
    }

    public void setCurrentPosY(float currentPosY) {
        this.currentPosY = currentPosY;
    }

    /**
     * Fetches the current page in which write cursor is present after creating the table.
     * @return pageIndex(Index starts from 0)
     */
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
