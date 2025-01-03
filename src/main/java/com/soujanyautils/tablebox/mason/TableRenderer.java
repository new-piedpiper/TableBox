package com.soujanyautils.tablebox.mason;

import com.soujanyautils.tablebox.api.BoxTable;
import com.soujanyautils.tablebox.bricks.Cell;
import com.soujanyautils.tablebox.bricks.Row;
import com.soujanyautils.tablebox.bricks.Table;
import com.soujanyautils.tablebox.cement.LayoutContext;
import com.soujanyautils.tablebox.cement.LayoutEngine;
import com.soujanyautils.tablebox.cement.TextContext;
import com.soujanyautils.tablebox.cement.TextEngine;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class TableRenderer {

    public static PDDocument drawTable(BoxTable boxTable){
        PDPage page = new PDPage();
        System.out.println(page.getBBox());
        boxTable.getDocument().addPage(page);
        try(PDPageContentStream contentStream = new PDPageContentStream(boxTable.getDocument(),page)){
            LayoutContext layoutContext = boxTable.getLayoutContext();
            TextContext textContext = boxTable.getTextContext();
            PDRectangle boundingBox = page.getBBox();
            Table table = boxTable.getTable();
            layoutContext.setContentStream(contentStream);
            settableDimensions(table, boundingBox);
            layoutContext.setTableWidth(table.getTableDimensions().getWidth());
            textContext.setContentStream(contentStream);
            contentStream.setLineWidth(layoutContext.getLineWidth());
            contentStream.setStrokingColor(layoutContext.getLineColor());
            contentStream.setLeading(textContext.getFontSize()*1f);
            layoutContext.setxStart(table.getTableDimensions().getLowerLeftX());
            layoutContext.setyStart(table.getTableDimensions().getUpperRightY());
            layoutContext.setColumnWidth(table.getTableDimensions().getWidth()/table.getNoOfColumns());
            textContext.setMaxCellLength(table.getTableDimensions().getWidth()/table.getNoOfColumns());
            for(Row row : table.getRecords()){
                layoutContext.setxStop(layoutContext.getxStart() + table.getTableDimensions().getWidth());
                layoutContext.setyStop(layoutContext.getyStart());
                LayoutEngine.drawLine(layoutContext);
                textContext.setStartingPtX(layoutContext.getxStart());
                textContext.setStartingPtY(layoutContext.getyStart());
                for(Cell cell : row.getCells()){
                    textContext.setCelltext(cell.getValue());
                    TextEngine.drawText(textContext);
                    textContext.setStartingPtX(textContext.getStartingPtX() + layoutContext.getColumnWidth());
                    layoutContext.setyStop(textContext.getEndPtY()< layoutContext.getyStop()? textContext.getEndPtY() : layoutContext.getyStop());
                }
                LayoutEngine.drawVerticalGridLines(layoutContext, table);
            }
            layoutContext.setxStop(layoutContext.getxStart() + table.getTableDimensions().getWidth());
            layoutContext.setyStop(layoutContext.getyStart());
            LayoutEngine.drawLine(layoutContext);
            contentStream.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return boxTable.getDocument();
    }

    private static void settableDimensions(Table table, PDRectangle pageDimensions) {
        Float heightPadding = pageDimensions.getHeight() * 0.10f;
        Float widthPadding = pageDimensions.getWidth() * 0.15f;
        PDRectangle tableDimensions = new PDRectangle();
        tableDimensions.setUpperRightX(pageDimensions.getUpperRightX() - widthPadding);
        tableDimensions.setUpperRightY(pageDimensions.getUpperRightY() - heightPadding);
        tableDimensions.setLowerLeftY(pageDimensions.getLowerLeftY() - heightPadding);
        tableDimensions.setLowerLeftX(pageDimensions.getLowerLeftX() + widthPadding);
        table.setTableDimensions(tableDimensions);
    }
}
