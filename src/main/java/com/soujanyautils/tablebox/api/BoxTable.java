package com.soujanyautils.tablebox.api;

import com.soujanyautils.tablebox.bricks.Cell;
import com.soujanyautils.tablebox.bricks.Row;
import com.soujanyautils.tablebox.bricks.Table;
import com.soujanyautils.tablebox.cement.DataTransformer;
import com.soujanyautils.tablebox.cement.LayoutContext;
import com.soujanyautils.tablebox.cement.TextContext;
import com.soujanyautils.tablebox.mason.TableRenderer;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.form.PDFormXObject;
import org.apache.pdfbox.util.Matrix;
import org.w3c.dom.Document;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class BoxTable {

    private LayoutContext layoutContext;
    private PDDocument document;
    private TextContext textContext;
    private PDFont font;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public TextContext getTextContext() {
        return textContext;
    }

    public void setTextContext(TextContext textContext) {
        this.textContext = textContext;
    }

    public PDDocument getDocument() {
        return document;
    }

    public void setDocument(PDDocument document) {
        this.document = document;
    }

    public LayoutContext getLayoutContext() {
        return layoutContext;
    }

    public void setLayoutContext(LayoutContext layoutContext) {
        this.layoutContext = layoutContext;
    }

    private Float fontSize;
    private Float lineThickness = 2f;
    private Color lineColor = Color.BLACK;
    private List<List<String>> data;
    private Table table;

    private BoxTable(Builder builder){
        LayoutContext layoutContext = new LayoutContext();
        layoutContext.setLineColor(builder.lineColor);
        layoutContext.setLineWidth(builder.lineThickness);
        this.layoutContext = layoutContext;
        TextContext textContext = new TextContext();
        textContext.setFontSize(builder.fontSize);
        textContext.setFont(builder.font);
        textContext.setTextPadding(builder.textPadding);
        float ascent = builder.font.getFontDescriptor().getAscent() / 1000 * builder.fontSize;
        float descent = builder.font.getFontDescriptor().getDescent() / 1000 * builder.fontSize;
        float textHeight = ascent - descent;
        textContext.setTextHeight(textHeight);
        this.textContext = textContext;
        this.document = builder.document;
        this.table = DataTransformer.convertToTableStructure(builder.data);
    }

    public static class Builder{

        private PDDocument document;
        private PDFont font;
        private List<List<String>> data;
        private Float lineThickness;
        private Color lineColor;
        private Float fontSize;
        private Float textPadding;

        public BoxTable build(){
            return new BoxTable(this);
        }

        public Builder setDocument(PDDocument document){
            this.document = document;
            return this;
        }

        public Builder setData(List<List<String>> data){
            this.data = data;
            return this;
        }

        public Builder setFont(PDFont font){
            this.font = font;
            return this;
        }

        public Builder setLineThickness(Float lineThickness){
            this.lineThickness = lineThickness;
            return this;
        }

        public Builder setLineColor(Color lineColor){
            this.lineColor = lineColor;
            return this;
        }

        public Builder setFontSize(Float fontSize){
            this.fontSize = fontSize;
            return this;
        }

        public Builder setTextPadding(Float textPadding){
            this.textPadding = textPadding;
            return this;
        }
    }

    public PDDocument createTable(){
        return  TableRenderer.drawTable(this);
    }

    //https://javadoc.io/doc/org.apache.pdfbox/pdfbox/latest/index.html
    public static void main(String[] args){
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        try {
//            PDPageContentStream contentStream = new PDPageContentStream(document, page);
//            contentStream.beginText();
//            contentStream.newLineAtOffset(0, 690);
//            PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
//            PDRectangle re = new PDRectangle();
//            Float widthStart = page.getBBox().getWidth() * 12/100;
//            Float widthStop = page.getBBox().getWidth() - widthStart;
//            Float heightStart = page.getBBox().getHeight()*12/100;
//            Float heightStop = page.getBBox().getHeight() - heightStart;
//            re.setLowerLeftX(widthStart);
//            re.setLowerLeftY(heightStop);
//            re.setUpperRightX(widthStop);
//            re.setUpperRightY(heightStart);
//            Integer fontSize = 12;
//            contentStream.setFont(font, fontSize);
////            String v = "The sun was setting over the rolling hills, casting a warm orange glow over the landscape. The air was filled with the sweet scent of blooming wildflowers, and the sound of birds singing their evening songs. A gentle breeze rustled the leaves of the trees, causing the branches to sway softly in the wind. As the stars began to twinkle in the night sky, a sense of peace and tranquility settled over the scene. The world seemed to be at rest, and all was right with the world. The moon, now a silver crescent in the sky, cast a gentle light over the landscape, illuminating the path ahead. The night air was filled with the promise of new beginnings, and the world seemed full of endless possibilities.";
////            Float currentLineLength = 0f;
////            String[] literals = v.split(" ");
////            for(String literal : literals){
////                System.out.println(literal);
////                currentLineLength = font.getStringWidth( literal + " " )*fontSize/1000f + currentLineLength;
////                if(currentLineLength >= page.getBBox().getWidth()){
////                    currentLineLength = 0f;
////                    contentStream.newLineAtOffset(0, -13);
////                }
////                contentStream.showText(literal+" ");
////            }
//            contentStream.newLineAtOffset(widthStart +10, -10);
//            contentStream.showText("Hello, this is the second line");
//            float tableWidth = re.getWidth()/3;
//            float cellHeight = re.getHeight();
//            PDRectangle cell1 = new PDRectangle();
//            cell1.setUpperRightY(heightStart);
//            cell1.setUpperRightX(widthStop- 2*tableWidth);
//            cell1.setLowerLeftX(widthStart);
//            cell1.setLowerLeftY(re.getLowerLeftY());
//            PDRectangle cell2 = new PDRectangle();
//            cell2.setLowerLeftY(cell1.getLowerLeftY());
//            cell2.setLowerLeftX(cell1.getLowerLeftX());
//            cell2.setUpperRightY(heightStart);
//            cell2.setUpperRightX(widthStop - tableWidth);
//            contentStream.endText();
//            contentStream.setLineWidth(2);
//            contentStream.setStrokingColor(Color.BLACK);
//            contentStream.moveTo(0,10);
//            PDRectangle r = page.getBBox();
//            System.out.println("Page Height : " +r.getHeight() + " Page Width : " +r.getWidth());
//            contentStream.lineTo(612, 10);
//            System.out.println(re.toString());
//            contentStream.addRect(re.getLowerLeftX(), re.getLowerLeftY(), re.getWidth(), re.getHeight());
//            contentStream.stroke();
//            contentStream.addRect(cell1.getLowerLeftX(), cell1.getLowerLeftY(), cell1.getWidth(), cell1.getHeight());
//            System.out.println(cell1.toString());
//            contentStream.stroke();
//            contentStream.addRect(cell2.getLowerLeftX(), cell2.getLowerLeftY(), cell2.getWidth(), cell2.getHeight());
//            contentStream.stroke();
//            contentStream.setLeading(125f);
//            contentStream.setLineCapStyle(0);
//            contentStream.close();
            TableRenderer tableRenderer = new TableRenderer();
            Instant start = Instant.now();
            document.save(new File("C:/Users/anugr/Documents/Projects/TableBox/file.pdf"));
            Instant stop = Instant.now();
            System.out.println("Time : " + Duration.between(start, stop).getNano());
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Table createSampleData(){
        Table table = new Table();
        int i = 0;
        for(int j = 0; j<13; j++) {
            Row row = new Row();
            for (i = 0; i < 3; i++) {
                Cell cell = new Cell();
                cell.setValue("This is " + i +" " +j+ " Length tester checking how many it can hold");
                if(i == 2 && j == 6){
                    cell.setValue("This is " + i +" " +j+ " Length tester checking how many it can hold. A little bit bigger row aint it?");
                }
                row.getCells().add(cell);
            }
            table.getRecords().add(row);
        }
        table.setNoOfColumns(3);
        PDRectangle tableDimentions = new PDRectangle(20, 15, 500, 600);
        table.setTableDimensions(tableDimentions);
        return table;
    }




}
