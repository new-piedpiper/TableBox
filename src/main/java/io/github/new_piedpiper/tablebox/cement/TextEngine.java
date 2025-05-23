package io.github.new_piedpiper.tablebox.cement;

import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontLike;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.IOException;

public class TextEngine {

    public static void drawText(TextContext textContext) throws IOException {
        PDFont columnNameFont = textContext.getColumnNameFont();
        PDFont font = columnNameFont != null ? columnNameFont : textContext.getFont();
        PDPageContentStream contentStream = textContext.getContentStream();
        contentStream.setFont(font, textContext.getFontSize());
        contentStream.beginText();
        contentStream.setNonStrokingColor(textContext.getFontColor());
        contentStream.newLineAtOffset(textContext.getStartingPtX() + textContext.getTextPadding(), textContext.getStartingPtY() - textContext.getTextPadding());
        Float fontSize = textContext.getFontSize();
        String[] chars = textContext.getCurrText().split("");
        textContext.setEndPtY(textContext.getStartingPtY() - textContext.getTextHeight());
        float currentLength = 0f;
        for (int i = 0; i<chars.length; i++) {
            currentLength = currentLength + font.getStringWidth(chars[i]) * fontSize / 1000f;
            if (currentLength >= (textContext.getMaxCellLength() - textContext.getTextPadding() * 2f)) {
                contentStream.newLine();
                currentLength = 0f;
                textContext.setEndPtY(textContext.getEndPtY() - textContext.getTextHeight());
                if(textContext.getEndPtY() <= textContext.getTableEndY()){
                    PageOverFlowState overFlowState = new PageOverFlowState();
                    overFlowState.setCurrentX(textContext.getStartingPtX());
                    overFlowState.setCellValue(textContext.getCurrText().substring(i));
                    textContext.getPageOverFlows().add(overFlowState);
                    break;
                }
            }
            contentStream.showText(chars[i]);
        }
        textContext.setEndPtY(textContext.getEndPtY() - textContext.getTextPadding());
        contentStream.endText();
    }

}
