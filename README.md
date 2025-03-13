
# Swagatham!
# TableBox
================

A Java package for creating tables in PDFs using Apache PDFBox.

## Introduction
---------------

TableBox is a simple and efficient library for generating tables in PDF documents. It provides a flexible API for customizing table properties and adding data to the table. Still in its infancy, so feel free to reach out or raise an issue if you find any!

## Usage
-----

### Creating a TableBox Instance

To use TableBox, create an instance of the TableBox API by specifying the properties of the table, such as line width, font, font color, and line color.
```java
TableBox tableBoxIns = TableBox.Builder()
        .setLineWidth(1.0f)
        .setFont(PDType1Font.HELVETICA)
        .setFontColor(Color.BLACK)
        .setLineColor(Color.BLACK)
        .build();
```
### Setting the Document and Data

Once the TableBox instance is created, set the PDF document and the data to be added to the table.
```java
tableBoxIns.setDocument(PDDocument document);
tableBoxIns.setData(List<List<String>> data);
```
The data should be a list of lists of strings, where each inner list represents a row in the table. For example:
```java
List<List<String>> data = Arrays.asList(
        Arrays.asList("Sl no", "product", "quantity"),
        Arrays.asList("1", "Apple", "23")
);
```
### Creating the Table

Finally, call the `createTable()` method to generate the table in the PDF document.
```java
tableBoxIns.createTable();
```
## Example Use Case
--------------------

Here's an example of how to use TableBox to create a simple table in a PDF document:
```java
PDDocument document = new PDDocument();
TableBox tableBoxIns = TableBox.Builder()
        .setLineWidth(1.0f)
        .setFont(PDType1Font.HELVETICA)
        .setFontColor(Color.BLACK)
        .setLineColor(Color.BLACK)
        .build();

List<List<String>> data = Arrays.asList(
        Arrays.asList("Sl no", "product", "quantity"),
        Arrays.asList("1", "Apple", "23")
);

tableBoxIns.setDocument(document);
tableBoxIns.setData(data);
DocumentTableState docState = tableBoxIns.createTable();
```
This will generate a PDF document with a simple table containing the specified data.
