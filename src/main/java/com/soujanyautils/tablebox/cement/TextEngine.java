package com.soujanyautils.tablebox.cement;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.io.IOException;

public class TextEngine {

    public static void drawText(TextContext textContext) throws IOException {
        PDFont font = textContext.getFont();
        PDPageContentStream contentStream = textContext.getContentStream();
        contentStream.setFont(font, textContext.getFontSize());
        contentStream.beginText();
        contentStream.newLineAtOffset(textContext.getStartingPtX() + textContext.getTextPadding(), textContext.getStartingPtY() - textContext.getTextPadding());
        Float fontSize = textContext.getFontSize();
        String[] chars = textContext.getCelltext().split("");
        textContext.setEndPtY(textContext.getStartingPtY() - textContext.getTextHeight());
        float currentLength = 0f;
        for (String token : chars) {
            currentLength = currentLength + font.getStringWidth(token) * fontSize / 1000f;
            if (currentLength >= (textContext.getMaxCellLength() - textContext.getTextPadding() * 2f)) {
                contentStream.newLine();
                currentLength = 0f;
                textContext.setEndPtY(textContext.getEndPtY() - textContext.getTextHeight());
            }
            contentStream.showText(token);
        }
        textContext.setEndPtY(textContext.getEndPtY() - textContext.getTextPadding());
        contentStream.endText();
    }

}
