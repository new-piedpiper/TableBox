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
        contentStream.newLineAtOffset(textContext.getStartingPtX() + textContext.getMaxCellLength()*.10f, textContext.getStartingPtY() - textContext.getMaxCellLength()*.10f);
        Float fontSize = textContext.getFontSize();
        String[] chars = textContext.getCelltext().split("");
        float ascent = font.getFontDescriptor().getAscent() / 1000 * fontSize;
        float descent = font.getFontDescriptor().getDescent() / 1000 * fontSize;
        float textHeight = ascent - descent;
        textContext.setEndPtY(textContext.getStartingPtY() - textHeight);
        System.out.println("Text height : "+textHeight);
        float currentLength = 0f;
        for(String token : chars){
            currentLength = currentLength + font.getStringWidth(token)*fontSize/1000f;
            if(currentLength >= (textContext.getMaxCellLength() - textContext.getMaxCellLength()*.20f)){
                contentStream.newLine();
                currentLength = 0f;
                textContext.setEndPtY(textContext.getEndPtY()-textHeight);
            }
            System.out.println("Start x: "+ textContext.getStartingPtX() + "Start y: "+ textContext.getStartingPtY());
            contentStream.showText(token);
        }
        textContext.setEndPtY(textContext.getEndPtY() - textContext.getMaxCellLength()*.10f);
        contentStream.endText();
    }

}
