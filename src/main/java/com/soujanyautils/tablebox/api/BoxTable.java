package com.soujanyautils.tablebox.api;

import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.util.Matrix;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BoxTable {

    //https://javadoc.io/doc/org.apache.pdfbox/pdfbox/latest/index.html
    public static void main(String[] args){
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.beginText();
            contentStream.newLineAtOffset(0, 690);
            PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            PDRectangle re = new PDRectangle();
            Float widthStart = page.getBBox().getWidth() * 12/100;
            Float widthStop = page.getBBox().getWidth() - widthStart;
            Float heightStart = page.getBBox().getHeight()*12/100;
            Float heightStop = page.getBBox().getHeight() - heightStart;
            re.setLowerLeftX(widthStart);
            re.setLowerLeftY(heightStop);
            re.setUpperRightX(widthStop);
            re.setUpperRightY(heightStart);
            Integer fontSize = 12;
            contentStream.setFont(font, fontSize);
//            String v = "The sun was setting over the rolling hills, casting a warm orange glow over the landscape. The air was filled with the sweet scent of blooming wildflowers, and the sound of birds singing their evening songs. A gentle breeze rustled the leaves of the trees, causing the branches to sway softly in the wind. As the stars began to twinkle in the night sky, a sense of peace and tranquility settled over the scene. The world seemed to be at rest, and all was right with the world. The moon, now a silver crescent in the sky, cast a gentle light over the landscape, illuminating the path ahead. The night air was filled with the promise of new beginnings, and the world seemed full of endless possibilities.";
//            Float currentLineLength = 0f;
//            String[] literals = v.split(" ");
//            for(String literal : literals){
//                System.out.println(literal);
//                currentLineLength = font.getStringWidth( literal + " " )*fontSize/1000f + currentLineLength;
//                if(currentLineLength >= page.getBBox().getWidth()){
//                    currentLineLength = 0f;
//                    contentStream.newLineAtOffset(0, -13);
//                }
//                contentStream.showText(literal+" ");
//            }
            contentStream.newLineAtOffset(widthStart +10, -10);
            contentStream.showText("Hello, this is the second line");
            float tableWidth = re.getWidth()/3;
            float cellHeight = re.getHeight();
            PDRectangle cell1 = new PDRectangle();
            cell1.setUpperRightY(heightStart);
            cell1.setUpperRightX(widthStop- 2*tableWidth);
            cell1.setLowerLeftX(widthStart);
            cell1.setLowerLeftY(re.getLowerLeftY());
            PDRectangle cell2 = new PDRectangle();
            cell2.setLowerLeftY(cell1.getLowerLeftY());
            cell2.setLowerLeftX(cell1.getLowerLeftX());
            cell2.setUpperRightY(heightStart);
            cell2.setUpperRightX(widthStop - tableWidth);
            contentStream.endText();
            contentStream.setLineWidth(2);
            contentStream.setStrokingColor(Color.BLACK);
            contentStream.moveTo(0,10);
            PDRectangle r = page.getBBox();
            System.out.println("Page Height : " +r.getHeight() + " Page Width : " +r.getWidth());
            contentStream.lineTo(612, 10);
            System.out.println(re.toString());
            contentStream.addRect(re.getLowerLeftX(), re.getLowerLeftY(), re.getWidth(), re.getHeight());
            contentStream.stroke();
            contentStream.addRect(cell1.getLowerLeftX(), cell1.getLowerLeftY(), cell1.getWidth(), cell1.getHeight());
            System.out.println(cell1.toString());
            contentStream.stroke();
            contentStream.addRect(cell2.getLowerLeftX(), cell2.getLowerLeftY(), cell2.getWidth(), cell2.getHeight());
            contentStream.stroke();
            contentStream.setLineCapStyle(0);
            contentStream.close();
            document.save(new File("C:/Users/anugr/Documents/Projects/TableBox/file.pdf"));
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
