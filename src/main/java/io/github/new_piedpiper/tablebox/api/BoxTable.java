package io.github.new_piedpiper.tablebox.api;

import io.github.new_piedpiper.tablebox.bricks.Table;
import io.github.new_piedpiper.tablebox.cement.DataTransformer;
import io.github.new_piedpiper.tablebox.cement.LayoutContext;
import io.github.new_piedpiper.tablebox.cement.TextContext;
import io.github.new_piedpiper.tablebox.mason.TableRenderer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;

import java.awt.Color;
import java.util.List;

/**
Main api for creating Pdf.
 */
public class BoxTable {

    private LayoutContext layoutContext;
    private PDDocument document;
    private TextContext textContext;
    private Float lineThickness = 2f;
    private Color lineColor = Color.BLACK;
    private Table table;

    public Table getTable() {
        return table;
    }

    public TextContext getTextContext() {
        return textContext;
    }

    public PDDocument getDocument() {
        return document;
    }

    public LayoutContext getLayoutContext() {
        return layoutContext;
    }

    private BoxTable(Builder builder){
        LayoutContext layoutContext = new LayoutContext();
        layoutContext.setLineColor(builder.lineColor == null? lineColor : builder.lineColor);
        layoutContext.setLineWidth(builder.lineThickness == null? lineThickness : builder.lineThickness);
        this.layoutContext = layoutContext;
        TextContext textContext = new TextContext();
        textContext.setFontSize(builder.fontSize);
        textContext.setFont(builder.font);
        textContext.setTextPadding(builder.textPadding);
        float textHeight = builder.font.getFontDescriptor().getAscent() / 1000 * builder.fontSize - builder.font.getFontDescriptor().getDescent() / 1000 * builder.fontSize;
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

        /**
        Add the document to which the table is to be added.
         */
        public Builder setDocument(PDDocument document){
            this.document = document;
            return this;
        }

        /**
        Add the data in a list of string list format
         */
        public Builder setData(List<List<String>> data){
            this.data = data;
            return this;
        }

        /**
        Add the font to be used
         */
        public Builder setFont(PDFont font){
            this.font = font;
            return this;
        }

        /**
        Set the line thickness of the table gridlines.
         */
        public Builder setLineThickness(Float lineThickness){
            this.lineThickness = lineThickness;
            return this;
        }

        /**
        Set the color of the table gridlines
         */
        public Builder setLineColor(Color lineColor){
            this.lineColor = lineColor;
            return this;
        }

        /**
        Set the font size for the table contents
         */
        public Builder setFontSize(Float fontSize){
            this.fontSize = fontSize;
            return this;
        }

        /**
         * Set the horizontal and vertical padding.
         */
        public Builder setTextPadding(Float textPadding){
            this.textPadding = textPadding;
            return this;
        }
    }

    /**
     *Method for creating the table.
     */
    public DocumentTableState createTable(){
        return  TableRenderer.drawTable(this);
    }

}
