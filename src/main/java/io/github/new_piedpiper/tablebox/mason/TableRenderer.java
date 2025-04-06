package io.github.new_piedpiper.tablebox.mason;

import io.github.new_piedpiper.tablebox.api.TableBox;
import io.github.new_piedpiper.tablebox.api.DocumentTableState;
import io.github.new_piedpiper.tablebox.bricks.Cell;
import io.github.new_piedpiper.tablebox.bricks.Row;
import io.github.new_piedpiper.tablebox.bricks.Table;
import io.github.new_piedpiper.tablebox.cement.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

import java.io.IOException;

public class TableRenderer {

    public static DocumentTableState drawTable(TableBox boxTable) {
        PDPage page = null;
        if(boxTable.getYstart() != null){
            page = boxTable.getDocument().getPage(boxTable.getDocument().getNumberOfPages()-1);
        }else {
            page = new PDPage();
            boxTable.getDocument().addPage(page);
        }
        LayoutContext layoutContext = boxTable.getLayoutContext();
        TextContext textContext = boxTable.getTextContext();
        try {
            PDPageContentStream contentStream = new PDPageContentStream(boxTable.getDocument(), page);
            PDRectangle boundingBox = page.getBBox();
            Table table = boxTable.getTable();
            layoutContext.setContentStream(contentStream);
            PDRectangle startTableFrom = null;
            if(boxTable.getYstart() != null){
                startTableFrom = new PDRectangle();
                startTableFrom.setUpperRightY(boxTable.getYstart());
            }
            setTableDimensions(table, boundingBox, startTableFrom);
            textContext.setTableEndY(table.getTableDimensions().getLowerLeftY());
            layoutContext.setTableWidth(table.getTableDimensions().getWidth());
            textContext.setContentStream(contentStream);
            contentStream.setLineWidth(layoutContext.getLineWidth());
            contentStream.setStrokingColor(layoutContext.getLineColor());
            contentStream.setLeading(textContext.getFontSize() * 1f);
            layoutContext.setxStart(table.getTableDimensions().getLowerLeftX());
            layoutContext.setyStart(table.getTableDimensions().getUpperRightY());
            layoutContext.setColumnWidth(table.getTableDimensions().getWidth() / table.getNoOfColumns());
            textContext.setMaxCellLength(table.getTableDimensions().getWidth() / table.getNoOfColumns());
            for (Row row : table.getRecords()) {
                layoutContext.setxStop(layoutContext.getxStart() + table.getTableDimensions().getWidth());
                layoutContext.setyStop(layoutContext.getyStart());
                LayoutEngine.drawLine(layoutContext);
                textContext.setStartingPtX(layoutContext.getxStart());
                textContext.setStartingPtY(layoutContext.getyStart());
                for (Cell cell : row.getCells()) {
                    textContext.setCurrText(cell.getValue());
                    TextEngine.drawText(textContext);
                    textContext.setStartingPtX(textContext.getStartingPtX() + layoutContext.getColumnWidth());
                    layoutContext.setyStop(textContext.getEndPtY() < layoutContext.getyStop() ? textContext.getEndPtY() : layoutContext.getyStop());
                }
                textContext.setColumnNameFont(null);
                LayoutEngine.drawVerticalGridLines(layoutContext, table);
                if (layoutContext.getyStop() <= textContext.getTableEndY() || !textContext.getPageOverFlows().isEmpty()) {
                    contentStream.close();
                    contentStream = flowToNewPage(layoutContext, textContext, boxTable.getDocument(), table);
                    if (!textContext.getPageOverFlows().isEmpty()) {
                        for (PageOverFlowState overFlowState = textContext.getPageOverFlows().poll(); overFlowState != null; overFlowState = textContext.getPageOverFlows().poll()) {
                            textContext.setCurrText(overFlowState.getCellValue());
                            textContext.setStartingPtX(overFlowState.getCurrentX());
                            TextEngine.drawText(textContext);
                            layoutContext.setyStop(textContext.getEndPtY() < layoutContext.getyStop() ? textContext.getEndPtY() : layoutContext.getyStop());
                        }
                        LayoutEngine.drawVerticalGridLines(layoutContext, table);
                    }
                }
            }
            layoutContext.setxStop(layoutContext.getxStart() + table.getTableDimensions().getWidth());
            layoutContext.setyStop(layoutContext.getyStart());
            LayoutEngine.drawLine(layoutContext);
            contentStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        DocumentTableState docTableState = new DocumentTableState();
        docTableState.setCurrentPosX(layoutContext.getxStop());
        docTableState.setCurrentPosY(layoutContext.getyStop());
        docTableState.setDocument(boxTable.getDocument());
        return docTableState;
    }

    private static void setTableDimensions(Table table, PDRectangle pageDimensions, PDRectangle startRect) {
        Float heightPadding = pageDimensions.getHeight() * 0.10f;
        Float widthPadding = pageDimensions.getWidth() * 0.15f;
        PDRectangle tableDimensions = new PDRectangle();
        tableDimensions.setUpperRightX(pageDimensions.getUpperRightX() - widthPadding);
        if(startRect != null) {
            tableDimensions.setUpperRightY(startRect.getUpperRightY());
        }else {
            tableDimensions.setUpperRightY(pageDimensions.getUpperRightY() - heightPadding);
        }
        tableDimensions.setLowerLeftY(pageDimensions.getLowerLeftY() + heightPadding);
        tableDimensions.setLowerLeftX(pageDimensions.getLowerLeftX() + widthPadding);
        table.setTableDimensions(tableDimensions);
    }

    public static PDPageContentStream flowToNewPage(LayoutContext layoutContext, TextContext textContext, PDDocument document, Table table) throws IOException {
        PDPage page = new PDPage(document.getPage(document.getNumberOfPages()-1).getBBox());
        document.addPage(page);
        setTableDimensions(table, page.getBBox(), null);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
            layoutContext.setContentStream(contentStream);
            contentStream.setLineWidth(layoutContext.getLineWidth());
            contentStream.setStrokingColor(layoutContext.getLineColor());
            contentStream.setLeading(textContext.getFontSize()*1f);
            layoutContext.setxStart(table.getTableDimensions().getLowerLeftX());
            layoutContext.setyStart(table.getTableDimensions().getUpperRightY());
            layoutContext.setyStop(layoutContext.getyStart());
            textContext.setContentStream(contentStream);
            textContext.setStartingPtX(layoutContext.getxStart());
            textContext.setStartingPtY(layoutContext.getyStart());
            return contentStream;
    }
}
