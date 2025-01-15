package com.soujanyautils.tablebox.cement;

import com.soujanyautils.tablebox.bricks.Table;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.awt.*;
import java.io.IOException;

public class LayoutEngine {

    public static void drawLine(LayoutContext layoutContext) throws IOException {
        PDPageContentStream contentStream = layoutContext.getContentStream();
        System.out.println(contentStream);
        contentStream.moveTo(layoutContext.getxStart(), layoutContext.getyStart());
        contentStream.lineTo(layoutContext.getxStop(), layoutContext.getyStop());
        contentStream.stroke();
    }

    public static void drawVerticalGridLines(LayoutContext layoutContext, Table table) throws IOException {
        float xCord = layoutContext.getxStart();
        while (xCord <= table.getTableDimensions().getUpperRightX()) {
            layoutContext.setxStart(xCord);
            layoutContext.setxStop(xCord);
            drawLine(layoutContext);
            xCord = xCord + layoutContext.getColumnWidth();
        }
        layoutContext.setxStart(layoutContext.getxStart() - layoutContext.getTableWidth());
        layoutContext.setyStart(layoutContext.getyStop());
    }

}
