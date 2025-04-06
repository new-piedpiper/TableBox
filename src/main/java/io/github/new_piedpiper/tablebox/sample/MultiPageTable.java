package io.github.new_piedpiper.tablebox.sample;

import io.github.new_piedpiper.tablebox.api.TableBox;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class MultiPageTable {

    public static void main(String... args) {
        PDDocument document = new PDDocument();
        try {
            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            TableBox boxTable = new TableBox.Builder().
                    setColumnNameFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD)).
                    setLineColor(Color.RED).
                    setFontSize(10f).
                    setTextPadding(15f).
                    setFontColor(Color.GRAY).
                    setLineThickness(1f).
                    setFont(font).
                    build();
            boxTable.setData(createData());
            boxTable.setDocument(document);
            Instant start = Instant.now();
            document = boxTable.createTable().getDocument();
            Instant stop = Instant.now();
            System.out.println("Time : " + Duration.between(start, stop).getNano());
            document.save(new File("C:\\Users\\anugr\\Documents\\Projects\\TableBox\\sampleout\\MultiPageTable.pdf"));
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                , List.of("1", "A cell with very very very very very very very very very very long text", "100(KG)", "100000000000000000000000000000000000000000000000000000000000000000")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "100")
                , List.of("1", "Apple", "100(KG)", "9"));
    }

}
