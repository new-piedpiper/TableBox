package com.soujanyautils.tablebox.mason;

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
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.IOException;

public class TableRenderer {

    public PDDocument drawTable(PDDocument document, PDPage page, Table table){
        try(PDPageContentStream contentStream = new PDPageContentStream(document, page)){
            LayoutContext layoutContext = new LayoutContext();
            TextContext textContext = new TextContext();
            PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            textContext.setFont(font);
            layoutContext.setLineWidth(table.getTableDimensions().getWidth());
            textContext.setContentStream(contentStream);
            contentStream.setLineWidth(2);
            contentStream.setStrokingColor(Color.BLACK);
            textContext.setFontSize(9f);
            contentStream.setLeading(17f);
            layoutContext.setContentStream(contentStream);
            layoutContext.setLineWidth(2);
            layoutContext.setxStart(table.getTableDimensions().getLowerLeftX());
            layoutContext.setyStart(table.getTableDimensions().getUpperRightY());
            int columnSize = table.getNoOfColumns();
            layoutContext.setColumnWidth(table.getTableDimensions().getWidth()/table.getNoOfColumns());
            textContext.setMaxCellLength(table.getTableDimensions().getWidth()/table.getNoOfColumns());
            System.out.println((layoutContext.getColumnWidth() - 20));
            for(Row row : table.getRecords()){
                layoutContext.setxStop(layoutContext.getxStart() + table.getTableDimensions().getWidth());
                layoutContext.setyStop(layoutContext.getyStart());
                LayoutEngine.drawLine(layoutContext);
                textContext.setStartingPtX(layoutContext.getxStart());
                textContext.setStartingPtY(layoutContext.getyStart());
                for(Cell cell : row.getCells()){
                    textContext.setCelltext(cell.getValue());
                    TextEngine.drawText(textContext);
                    textContext.setStartingPtX(textContext.getStartingPtX() + textContext.getMaxCellLength());
                }
                drawPillers(layoutContext, table);
            }
            contentStream.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return document;
    }


    private void drawPillers(LayoutContext layoutContext, Table table) throws IOException {
        float xCord = layoutContext.getxStart();
        while(xCord<= table.getTableDimensions().getUpperRightX()){
            layoutContext.setxStart(xCord);
            layoutContext.setxStop(xCord);
            layoutContext.setyStop(layoutContext.getyStart() - 15f);
            LayoutEngine.drawLine(layoutContext);
            xCord = xCord + layoutContext.getColumnWidth();
        }
        layoutContext.setxStart(layoutContext.getxStart() - layoutContext.getLineWidth());
        layoutContext.setyStart(layoutContext.getyStop());
    }


}
