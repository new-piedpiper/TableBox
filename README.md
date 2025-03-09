Swagatham!

Tablebox is a java package for creating tables in pdfs written using the Apache PDF box. 
Usage : 
Create an instance of the TableBox api by specifying the properties of the tables like line width, font, font color, line color. 
This instance can then be used with any document, by setting the Document and the data which is to added to the table.

TableBox tableBoxIns = tableBox.Builder().setLineWidth()....build();
tableBoxIns.setDocument(PDDocument);
tableBoxIns.setData(ListofListofStrings); //({{"Sl no", "product", "quantity"},{"1", "Apple", "23"}})
tableBoxIns.createTable();
