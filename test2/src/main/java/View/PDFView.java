package main.java.View;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import main.java.Abiturient;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;

public class PDFView implements IReportView {

    private static BaseFont bf = null;

    static {
        try {
            bf = BaseFont.createFont("C:\\Windows\\Fonts\\times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (Exception e) {

        }
    }

    public static final Font standardFont = new Font(bf, 14, 0, BaseColor.BLACK);
    public static final Font standardBoldFont = new Font(bf, 14, Font.BOLD, new BaseColor(115, 205, 105));
    public static final Font header1Font = new Font(bf, 20, Font.BOLDITALIC, new BaseColor(98, 98, 255));
    public static final Font header2Font = new Font(bf, 18, Font.BOLD, new BaseColor(98, 98, 255));
    public static final Font titleFont = new Font(bf, 26, Font.BOLDITALIC, BaseColor.ORANGE);
    public static final Font titleSmallFont = new Font(bf, 18, Font.ITALIC, new BaseColor(155, 115, 255));
    public static final Font titleHeaderFont = new Font(bf, 16, Font.BOLD, BaseColor.PINK);
    public static final Font titleFooterFont = new Font(bf, 12, 0, BaseColor.LIGHT_GRAY);
    public static final Font pageNumberFont = new Font(bf, 14, 0, BaseColor.PINK);

    private Paragraph getStandardParagraph(float leftIndent) {
        Paragraph p = new Paragraph(15);
        p.setAlignment(Element.ALIGN_JUSTIFIED);
        p.setIndentationLeft(leftIndent);
        p.setFont(standardFont);
        p.setSpacingAfter(3);
        return p;
    }

    private Paragraph getStandardParagraphBold(float leftIndent) {
        Paragraph p = getStandardParagraph(leftIndent);
        p.setFont(standardBoldFont);
        return p;
    }

    private Paragraph createStandardParagraph(String boldText, String text, float leftIndent) {
        Paragraph p = getStandardParagraphBold(leftIndent);
        p.setFont(standardBoldFont);
        p.add(boldText + ": ");
        p.setFont(standardFont);
        p.add(text);
        return p;
    }

    private Paragraph createBoldParagraph(String text, float leftIndent) {
        Paragraph p = getStandardParagraphBold(leftIndent);
        p.add(text);
        return p;
    }

    private Paragraph createBoldColoredParagraph(String text, float leftIndent, BaseColor color) {
        Paragraph p = getStandardParagraphBold(leftIndent);
        p.getFont().setColor(color);
        p.add(text);
        return p;
    }

    private Paragraph createHeader1Paragraph(String text) {
        Paragraph p = new Paragraph();
        p.setFont(header1Font);
        p.setIndentationLeft(30);
        p.setSpacingAfter(14);
        p.add(text);
        return p;
    }

    private Paragraph createHeader2Paragraph(String text) {
        Paragraph p = new Paragraph();
        p.setFont(header2Font);
        p.setIndentationLeft(20);
        p.setSpacingAfter(10);
        p.add(text);
        return p;
    }

    private Document getTypicalDocument(File file, String title) throws Exception {
        Rectangle pageSize = new Rectangle(PageSize.A4);
        pageSize.setBackgroundColor(new BaseColor(255, 238, 238));
        Document document = new Document(pageSize);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        //TableHeader event = new TableHeader();
        //writer.setPageEvent((PdfPageEvent) event);
        //TODO: разобраться с несовместимостью

        document.open();
        addMetaData(document, title);
        addTitlePage(document, title);
        return document;
    }

    private Paragraph getParagraphOfAlignmentAndFont(String text, Font font, int alignment) {
        Paragraph newP = new Paragraph(text, font);
        newP.setAlignment(alignment);
        return newP;
    }

    private void addEmptyLine(Document document, int number) throws DocumentException {
        for (int i = 0; i < number; i++) {
            document.add(new Paragraph(" "));
        }
    }

    private void addMetaData(Document document, String title) {
        document.addTitle("Отчёт: " + title);
        document.addSubject("Отчёт, сгенерированный проектом XOR");
        document.addKeywords("Отчёт, XOR");
        document.addAuthor("Проект XOR");
        document.addCreator("Автогенератор отчётов XOR");
    }

    private boolean addImageFromInternet(Document document, String url) {
        boolean result = true;
        try {
            Image logo = Image.getInstance(url);
            logo.setAlignment(Image.ALIGN_LEFT);
            logo.setSpacingAfter(15);
            logo.scaleToFit(530, 530);
            document.add(logo);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    private void addLink(Paragraph paragraph, String link, String text) {
        Phrase phrase = new Phrase();
        Chunk chunk = new Chunk(text);
        chunk.setAnchor(link);
        phrase.add(chunk);
        paragraph.add(phrase);
    }

    private void addTitlePage(Document document, String title) throws DocumentException {
        document.add(getParagraphOfAlignmentAndFont("(c) Проект XOR", titleHeaderFont, Element.ALIGN_CENTER));
        addEmptyLine(document, 2);
        document.add(getParagraphOfAlignmentAndFont("ОТЧЁТ", titleFont, Element.ALIGN_CENTER));
        document.add(getParagraphOfAlignmentAndFont(title, titleFont, Element.ALIGN_CENTER));
        addEmptyLine(document, 1);

        try {
            Image logo = Image.getInstance("src/resources/rainbow.jpg");
            logo.setAlignment(Image.ALIGN_CENTER);
            logo.setSpacingAfter(10);
            logo.setSpacingBefore(10);
            logo.scaleToFit(200, 150);
            document.add(logo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        addEmptyLine(document, 3);
        document.add(getParagraphOfAlignmentAndFont("Отчёт был автоматически сгенерирован системой XOR после пользовательского запроса",
                titleSmallFont, Element.ALIGN_CENTER));
        addEmptyLine(document, 2);

        try {
            Paragraph paragraph = new Paragraph();
            Phrase phrase = new Phrase();
            Image logo = Image.getInstance("src/resources/followus.png");
            logo.setAlignment(Image.ALIGN_CENTER);
            logo.setSpacingAfter(10);
            logo.setSpacingBefore(10);
            logo.scaleToFit(250, 100);
            //logo.setRotation((float) Math.random());
            Chunk chunk = new Chunk(logo, 0, 0, true);
            chunk.setAnchor("http://localhost:4200");
            phrase.add(chunk);
            paragraph.add(phrase);
            document.add(paragraph);
        } catch (Exception e) {
            Phrase phrase = new Phrase();
            phrase.add("Welcome to ");
            Chunk chunk = new Chunk("our app");
            chunk.setAnchor("http://localhost:4200");
            phrase.add(chunk);
            phrase.add(" in WEB!");
        }

        addEmptyLine(document, 5);
        document.add(getParagraphOfAlignmentAndFont("Отчёт сгенерирован " + LocalDateTime.now().toString(),
                titleFooterFont, Element.ALIGN_CENTER));

        document.newPage();
    }

    private void addAbiturientData(Document document, Abiturient abiturient, float leftIndent) throws DocumentException {
        document.add(createBoldColoredParagraph("Абитуриентишко №" + abiturient.getIdSpeciality(), 0,BaseColor.BLACK));
        document.add(createStandardParagraph("Фамилия:      ", abiturient.getFirstName(), leftIndent));
        document.add(createStandardParagraph("Имя:          ", abiturient.getLastName(), leftIndent));
        document.add(createStandardParagraph("Отчество:     ", abiturient.getSecondName(), leftIndent));
        document.add(createStandardParagraph("Адрес:        ", abiturient.getAddress(), leftIndent));
        document.add(createStandardParagraph("Паспорт:      ", abiturient.getPassport(), leftIndent));
        document.add(createStandardParagraph("Специальность:", abiturient.getSpeciality().getName(), leftIndent));
    }

    public String encryptPDF(String oldFile) throws Exception {
        try {
            File tempFile = File.createTempFile("report", ".pdf");
            PdfReader reader = new PdfReader(oldFile);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(tempFile));
            stamper.setEncryption(null, "XOR_created_XOR_deasallowed".getBytes(),
                    ~(PdfWriter.ALLOW_COPY) | PdfWriter.ALLOW_PRINTING | PdfWriter.ALLOW_SCREENREADERS,
                    PdfWriter.ENCRYPTION_AES_256 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
            stamper.close();
            return tempFile.getAbsolutePath();
        } finally {
            File prevFile = new File(oldFile);
            if (prevFile.exists()) {
                prevFile.delete();
            }
        }
    }

    public String generateFileReportByAbiturients(List<Abiturient> abiturients) throws Exception {
        File tempFile = File.createTempFile("report", ".pdf");
        Document document = getTypicalDocument(tempFile, "Отчёт по всем абитуриентам");

        document.add(createHeader1Paragraph("Абитуриенты"));
        for (Abiturient abiturient : abiturients) {
            addAbiturientData(document, abiturient, 0);
            addEmptyLine(document, 1);
        }
        if (abiturients.isEmpty()) {
            document.add(createBoldParagraph("Список абитуриентов пуст", 0));
        }

        document.close();
        return tempFile.getAbsolutePath();
    }


    @Override
    public byte[] generateReportByAbiturients(List<Abiturient> crimes) {
        return new byte[0];
    }
}