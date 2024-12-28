package com.soujanyautils.tablebox.cement;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import java.io.IOException;

public class LayoutEngine {

    public static void drawLine(LayoutContext layoutContext) throws IOException {
        PDPageContentStream contentStream = layoutContext.getContentStream();
        contentStream.moveTo(layoutContext.getxStart(), layoutContext.getyStart());
        contentStream.lineTo(layoutContext.getxStop(), layoutContext.getyStop());
        System.out.println("Start x: "+ layoutContext.getxStart() + "Start y: "+ layoutContext.getyStart());
        System.out.println("End x, y : " + layoutContext.getxStop() +" "+ layoutContext.getyStop());
        contentStream.stroke();
    }

}
