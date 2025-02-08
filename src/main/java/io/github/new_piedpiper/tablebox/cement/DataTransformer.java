package io.github.new_piedpiper.tablebox.cement;

import io.github.new_piedpiper.tablebox.bricks.Cell;
import io.github.new_piedpiper.tablebox.bricks.Row;
import io.github.new_piedpiper.tablebox.bricks.Table;

import java.util.List;

public class DataTransformer {

    public static Table convertToTableStructure(List<List<String>> listOfLists){
        Table table = new Table();
            System.out.println(listOfLists);
                table.setNoOfColumns(listOfLists.getFirst().size());
                for(List<String> records : listOfLists){
                    Row row = new Row();
                    for(String value : records){
                        Cell cell = new Cell();
                        cell.setValue(value);
                        row.getCells().add(cell);
                    }
                    table.getRecords().add(row);
                }
        return table;
    }

}
