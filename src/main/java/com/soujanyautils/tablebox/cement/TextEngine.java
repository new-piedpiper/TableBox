package com.soujanyautils.tablebox.cement;

import org.apache.fontbox.util.BoundingBox;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.graphics.state.PDGraphicsState;
import org.apache.pdfbox.util.Matrix;

import java.io.IOException;

public class TextEngine {

    public static void drawText(TextContext textContext) throws IOException {
        PDFont font = textContext.getFont();
        PDPageContentStream contentStream = textContext.getContentStream();
        contentStream.setFont(font, textContext.getFontSize());
        contentStream.beginText();
        contentStream.newLineAtOffset(textContext.getStartingPtX() + 15, textContext.getStartingPtY() - 15);
        Float fontSize = textContext.getFontSize();
        String[] chars = textContext.getCelltext().split("");
        float currentLength = 0f;
        for(String token : chars){
            currentLength = currentLength + font.getStringWidth(token)*fontSize/1000f;
            if(currentLength >= (textContext.getMaxCellLength() - textContext.getMaxCellLength()*.20f)){
                contentStream.newLine();
                currentLength = 0f;
            }
            System.out.println("Start x: "+ textContext.getStartingPtX() + "Start y: "+ textContext.getStartingPtY());
            contentStream.showText(token);
        }
        contentStream.endText();
    }

}
