package com.soujanyautils.tablebox.api;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class TestClass {

    public static void main(String... args) {
        Instant start = Instant.now();
        PDDocument document = new PDDocument();
        try {
            PDFont font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            BoxTable boxTable = new BoxTable.Builder().setData(createData()).setDocument(document).setLineColor(Color.BLACK).setFontSize(10f).setTextPadding(15f).setLineThickness(1f).setFont(font).build();
            document = boxTable.createTable();
            document.save(new File("C:/Users/anugr/Documents/Projects/TableBox/file.pdf"));
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Instant stop = Instant.now();
        System.out.println("Time : " + Duration.between(start, stop).getNano());
    }

    private static List<List<String>> createData() {
        return List.of(List.of("Sl no", "Item", "Price per unit", "Remaining stock"), List.of("1", "Apple", "100(KG)", "100"), List.of("2", "Orange", "60(KG)", "79")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "9"));
    }

}
