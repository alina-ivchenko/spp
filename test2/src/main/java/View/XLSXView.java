package main.java.View;

import main.java.Abiturient;
import main.java.ProjectFunctions;
import main.java.Speciality;
import main.java.View.ExtraClasses.TableBorder;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.ByteArrayOutputStream;
import java.util.List;


public class XLSXView implements IReportView {

    private Font fontUsual = null;
    private Font fontBold = null;
    private Font fontLink = null;
    private Font fontBoldColored = null;
    private XSSFCellStyle styleHeader = null;
    private XSSFCellStyle styleUsual = null;
    private XSSFCellStyle styleLink = null;
    private XSSFCellStyle styleArea = null;
    private XSSFCreationHelper createHelper = null;

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Override
    public byte[] generateReportByAbiturients(List<Abiturient> abiturients) {
        try {
            XSSFWorkbook workbook = getWorkbook();
            String title = "Отчёт по всем абитуриентам";
            XSSFSheet sheet = getSheet(workbook, title);

            TableBorder borders = new TableBorder();
            borders = addAbiturientsToSheet(sheet, borders.getRow(), abiturients, title, borders.getColumn());
            setParamsToFit(workbook, sheet, borders.getColumn());


            byteArrayOutputStream.flush();
            workbook.write(byteArrayOutputStream);
        } catch (Exception e) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte[] generateReportBySpecialities(List<Speciality> specialities) {
        try {
            XSSFWorkbook workbook = getWorkbook();
            String title = "Отчёт по всем специальностям";
            XSSFSheet sheet = getSheet(workbook, title);

            TableBorder borders = new TableBorder();
            borders = addSpecialitiesToSheet(sheet, borders.getRow(), specialities, title, borders.getColumn());
            setParamsToFit(workbook, sheet, borders.getColumn());


            byteArrayOutputStream.flush();
            workbook.write(byteArrayOutputStream);
        } catch (Exception e) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private void initStyles(XSSFWorkbook workbook) {
        createHelper = workbook.getCreationHelper();

        fontUsual = workbook.createFont();
        fontUsual.setFontName("Times New Roman");

        fontLink = workbook.createFont();
        fontLink.setFontName("Times New Roman");
        fontLink.setUnderline(Font.U_SINGLE);
        fontLink.setColor(IndexedColors.BLUE.getIndex());

        fontBold = workbook.createFont();
        fontBold.setFontName("Times New Roman");
        fontBold.setColor(IndexedColors.ORANGE.getIndex());
        fontBold.setBold(true);

        fontBoldColored = workbook.createFont();
        fontBoldColored.setFontName("Times New Roman");
        fontBoldColored.setBold(true);
        fontBoldColored.setColor(IndexedColors.MAROON.getIndex());

        styleHeader = workbook.createCellStyle();
        styleHeader.setWrapText(true);
        styleHeader.setAlignment(HorizontalAlignment.CENTER);
        styleHeader.setVerticalAlignment(VerticalAlignment.CENTER);
        styleHeader.setBorderBottom(BorderStyle.MEDIUM);
        styleHeader.setBorderTop(BorderStyle.MEDIUM);
        styleHeader.setBorderLeft(BorderStyle.MEDIUM);
        styleHeader.setBorderRight(BorderStyle.MEDIUM);
        styleHeader.setFont(fontBold);

        styleArea = workbook.createCellStyle();
        styleArea.setWrapText(true);
        styleArea.setAlignment(HorizontalAlignment.CENTER);
        styleArea.setVerticalAlignment(VerticalAlignment.CENTER);
        styleArea.setBorderBottom(BorderStyle.MEDIUM);
        styleArea.setBorderTop(BorderStyle.MEDIUM);
        styleArea.setBorderLeft(BorderStyle.MEDIUM);
        styleArea.setBorderRight(BorderStyle.MEDIUM);
        styleArea.setFont(fontBoldColored);

        styleUsual = workbook.createCellStyle();
        styleUsual.setWrapText(true);
        styleUsual.setAlignment(HorizontalAlignment.LEFT);
        styleUsual.setVerticalAlignment(VerticalAlignment.TOP);
        styleUsual.setBorderBottom(BorderStyle.THIN);
        styleUsual.setBorderTop(BorderStyle.THIN);
        styleUsual.setBorderLeft(BorderStyle.THIN);
        styleUsual.setBorderRight(BorderStyle.THIN);
        styleUsual.setFont(fontUsual);

        styleLink = workbook.createCellStyle();
        styleLink.setWrapText(true);
        styleLink.setAlignment(HorizontalAlignment.LEFT);
        styleLink.setVerticalAlignment(VerticalAlignment.TOP);
        styleLink.setBorderBottom(BorderStyle.THIN);
        styleLink.setBorderTop(BorderStyle.THIN);
        styleLink.setBorderLeft(BorderStyle.THIN);
        styleLink.setBorderRight(BorderStyle.THIN);
        styleLink.setFont(fontLink);
    }

    private XSSFWorkbook getWorkbook() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        initStyles(workbook);
        return workbook;
    }

    private XSSFSheet getSheet(XSSFWorkbook workbook, String name) {
        XSSFSheet sheet = workbook.createSheet(name);
        sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);
        sheet.getPrintSetup().setOrientation(PrintOrientation.LANDSCAPE);
        return sheet;
    }

    private void createCell(XSSFRow row, int colNum, String value, XSSFCellStyle style) {
        XSSFCell cell = row.createCell(colNum);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    private void createCellHyperlinked(XSSFRow row, int colNum, String value, String linkURL) {
        XSSFCell cell = row.createCell(colNum);
        cell.setCellValue(value);
        Hyperlink link = createHelper.createHyperlink(HyperlinkType.URL);
        link.setAddress(linkURL);
        cell.setHyperlink(link);
        cell.setCellStyle(styleLink);
    }

    private void setParamsToFit(XSSFWorkbook workbook, XSSFSheet sheet, int columnCount) {
        sheet.setAutobreaks(true);
        PrintSetup ps = sheet.getPrintSetup();
        /*for(int i = 0; i < columnCount; i++) {
            sheet.autoSizeColumn(i);
        }
        sheet.setFitToPage(true);
        ps.setFitWidth((short)1);
        ps.setFitHeight((short)0);*/
        for (int i = 0; i < columnCount; i++) {
            sheet.setColumnWidth(i, 33200 / columnCount);
        }
    }

    private int addSpecialityHeaders(XSSFRow row, int colNum) {
        createCell(row, colNum++, "Название", styleHeader);
        createCell(row, colNum++, "Факультет", styleHeader);
        createCell(row, colNum++, "Предмет 1", styleHeader);
        createCell(row, colNum++, "Предмет 2", styleHeader);
        createCell(row, colNum++, "Предмет 3", styleHeader);
        createCell(row, colNum++, "Кол-во абитуриентов", styleHeader);
        return colNum;
    }

    private int addSpecialityContents(XSSFRow row, int colNum, Speciality speciality) {
        createCell(row, colNum++, speciality.getName(), styleUsual);
        createCell(row, colNum++, speciality.getFaculty().getName(), styleUsual);
        createCell(row, colNum++, speciality.getSubject1().getName(), styleUsual);
        createCell(row, colNum++, speciality.getSubject2().getName(), styleUsual);
        createCell(row, colNum++, speciality.getSubject3().getName(), styleUsual);
        createCell(row, colNum++, ProjectFunctions.escapeNullException(speciality.getAmountOfAbiturients(), null), styleUsual);
        return colNum;
    }

    private int addAbiturientsHeaders(XSSFRow row, int colNum) {
        createCell(row, colNum++, "Фамилия", styleHeader);
        createCell(row, colNum++, "Имя", styleHeader);
        createCell(row, colNum++, "Отчество", styleHeader);
        createCell(row, colNum++, "Адрес", styleHeader);
        createCell(row, colNum++, "Паспорт", styleHeader);
        createCell(row, colNum++, "Специальность", styleHeader);
        return colNum;
    }


    private int addAbiturientContents(XSSFRow row, int colNum, Abiturient abiturient) {
        createCell(row, colNum++, abiturient.getFirstName(), styleUsual);
        createCell(row, colNum++, abiturient.getLastName(), styleUsual);
        createCell(row, colNum++, abiturient.getSecondName(), styleUsual);
        createCell(row, colNum++, abiturient.getAddress(), styleUsual);
        createCell(row, colNum++, abiturient.getPassport(), styleUsual);
        createCell(row, colNum++, abiturient.getSpeciality().getName(), styleUsual);
        return colNum;
    }

    private void createMergedCell(XSSFSheet sheet, int headerRow, int resultColumns, String value) {
        XSSFRow row = sheet.createRow(headerRow);
        for (int i = 0; i < resultColumns; i++) {
            if (i == 0) {
                createCell(row, 0, value, styleArea);
            } else {
                row.createCell(i).setCellStyle(styleArea);
            }
        }
        sheet.addMergedRegion(new CellRangeAddress(headerRow, headerRow, 0, resultColumns - 1));
    }


    private TableBorder addAbiturientsToSheet(XSSFSheet sheet, int rowNum, List<Abiturient> abiturients, String title, int columnsCount) {
        int colNum = 0;
        int headerRow = rowNum++;

        XSSFRow row = sheet.createRow(rowNum++);
        int resultColumns = addAbiturientsHeaders(row, colNum);
        for (Abiturient abiturient : abiturients) {
            row = sheet.createRow(rowNum++);
            colNum = 0;
            addAbiturientContents(row, colNum, abiturient);
        }
        createMergedCell(sheet, headerRow, resultColumns, title);
        return new TableBorder(rowNum, columnsCount < resultColumns ? resultColumns : columnsCount);
    }

    private TableBorder addSpecialitiesToSheet(XSSFSheet sheet, int rowNum, List<Speciality> specialities, String title, int columnsCount) {
        int colNum = 0;
        int headerRow = rowNum++;

        XSSFRow row = sheet.createRow(rowNum++);
        int resultColumns = addSpecialityHeaders(row, colNum);
        for (Speciality speciality : specialities) {
            row = sheet.createRow(rowNum++);
            colNum = 0;
            addSpecialityContents(row, colNum, speciality);
        }
        createMergedCell(sheet, headerRow, resultColumns, title);
        return new TableBorder(rowNum, columnsCount < resultColumns ? resultColumns : columnsCount);
    }

}
