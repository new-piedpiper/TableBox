package com.soujanyautils.api;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.util.Matrix;

import java.io.File;
import java.io.IOException;

public class BoxTable {

    //https://javadoc.io/doc/org.apache.pdfbox/pdfbox/latest/index.html
    public static void main(String[] args){
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            contentStream.setFont(font, 14);
            contentStream.showText("Hello, World!");
            contentStream.endText();
            contentStream.close();
            document.save(new File("C:/Users/anugr/Documents/Projects/TableBox/file.pdf"));
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
