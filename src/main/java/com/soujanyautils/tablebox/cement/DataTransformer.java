package com.soujanyautils.tablebox.cement;

import com.soujanyautils.tablebox.bricks.Cell;
import com.soujanyautils.tablebox.bricks.Row;
import com.soujanyautils.tablebox.bricks.Table;

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
