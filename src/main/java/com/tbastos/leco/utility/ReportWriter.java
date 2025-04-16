/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.utility;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.JTextComponent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/**
 *
 * @author Tibério
 */
public class ReportWriter {
    
    private String reportName;
    private File reportDir;
        
    public ReportWriter(File dir, String name) {
        
        this.reportName = name;
        this.reportDir = dir;
    }
    
    public ReportWriter() {
        
    }
    
    public void reportWriterTxt(String[] reportCategoryTitle, String[] reportCategoryText, ArrayList<String> reportCategoryConclusion) throws IOException {
                 
        FileWriter writerTxt = new FileWriter(new File(reportDir, reportName + ".txt"));

        writerTxt.write("COMENTÁRIOS:\n");

        for (int i = 0; i < reportCategoryTitle.length; i++) {
            
            writerTxt.write(String.valueOf(i+1) + ". " + reportCategoryTitle[i] + ": ");
            writerTxt.write(reportCategoryText[i] + "\n");
        }
        
        writerTxt.write("CONCLUSÃO:\n");
        Iterator<String> iteratorCategoryConclusion = reportCategoryConclusion.iterator();
        
        while(iteratorCategoryConclusion.hasNext()) {
        
            writerTxt.write("- " + iteratorCategoryConclusion.next() + "\n");
        }
        
        writerTxt.close();
    }
    
    public void reportWriterPdf(String[] reportCategoryTitle, String[] reportCategoryText, ArrayList<String> reportCategoryConclusion) throws DocumentException, IOException {
             
        Document document = new Document();
        BaseFont base = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
        Font categoryFont = new Font(base, 10f, Font.BOLD);
        Font titleFont = new Font(base, 12f, Font.BOLD);
        Font categoryTextFont = new Font(base, 10f, Font.NORMAL);

        File pdfFile = new File(reportDir, reportName + ".pdf");
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile));

        document.setMargins(2 * 28.35f, 2 * 28.35f, 2 * 28.35f, 2 * 28.35f);
        document.open(); 
        Chunk chunckCommentary = new Chunk("COMENTÁRIOS:", titleFont);
        Phrase phraseCommentary = new Phrase(chunckCommentary);
        Paragraph paragraphCommentary = new Paragraph(phraseCommentary);
        paragraphCommentary.setSpacingAfter(1);
        document.add(paragraphCommentary);

        for (int i = 0; i < reportCategoryTitle.length; i++){

            Chunk chunkIndex = new Chunk(String.valueOf(i+1) + ". ", categoryTextFont);
            Chunk chunkCategoryTitle = new Chunk(reportCategoryTitle[i] + ": ", categoryFont);
            Chunk chunkCategoryText = new Chunk(reportCategoryText[i], categoryTextFont);
            Phrase phraseCategory = new Phrase();
            Paragraph paragraphCategory = new Paragraph();
            paragraphCategory.setAlignment(com.itextpdf.text.Element.ALIGN_JUSTIFIED);
            phraseCategory.add(chunkIndex);
            phraseCategory.add(chunkCategoryTitle);
            phraseCategory.add(chunkCategoryText);
            paragraphCategory.add(phraseCategory);
            document.add(paragraphCategory);
        }

        Chunk chunckConclusion = new Chunk("\nCONCLUSÃO:", titleFont);
        Phrase phraseConclusion = new Phrase(chunckConclusion);
        Paragraph paragraphConclusion = new Paragraph(phraseConclusion);
        paragraphConclusion.setSpacingAfter(1);
        document.add(paragraphConclusion);
        
        Iterator<String> iteratorCategoryConclusion = reportCategoryConclusion.iterator();
         
        while(iteratorCategoryConclusion.hasNext()) {
        
            Paragraph paragraphCategoryConclusion = new Paragraph();
            paragraphCategoryConclusion.setSpacingAfter(1);
            Chunk chunkCategoryConclusion = new Chunk("- " + iteratorCategoryConclusion.next(), categoryTextFont);
            Phrase phraseCategoryConclusion = new Phrase();
            phraseCategoryConclusion.add(chunkCategoryConclusion);
            paragraphCategoryConclusion.add(phraseCategoryConclusion);
            document.add(paragraphCategoryConclusion);
        }
        
        document.close();   
        
             try (PDDocument documentPDF = PDDocument.load(pdfFile)) {
                PrinterJob job = PrinterJob.getPrinterJob();
                job.setPageable(new PDFPageable(documentPDF));

                if (job.printDialog()) {
                    job.print();
                }
            } catch (PrinterException ex) {
            Logger.getLogger(ReportWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void reportWriterDocx(String[] reportCategoryTitle, String[] reportCategoryText, ArrayList<String> reportCategoryConclusion) throws FileNotFoundException, IOException {

        XWPFDocument xwpfdocument = new XWPFDocument();  
        FileOutputStream ostream = new FileOutputStream(new File(reportDir, reportName + ".docx")); 
        
        CTSectPr sectPr = xwpfdocument.getDocument().getBody().getSectPr();
        if(sectPr == null) {
            sectPr = xwpfdocument.getDocument().getBody().addNewSectPr();
        }
        CTPageMar pageMar = sectPr.getPgMar();
        if(pageMar == null) {
            
            pageMar = sectPr.addNewPgMar();
        }
        pageMar.setBottom(BigInteger.valueOf(1136));
        pageMar.setTop(BigInteger.valueOf(1136));
        pageMar.setRight(BigInteger.valueOf(1136));
        pageMar.setLeft(BigInteger.valueOf(1136));

        XWPFParagraph paragraphCommentary = xwpfdocument.createParagraph();
        paragraphCommentary.setSpacingBetween(1.39d);
        paragraphCommentary.setSpacingAfter(30);
        XWPFRun lineCommentary = paragraphCommentary.createRun();
        lineCommentary.setBold(true);
        lineCommentary.setFontFamily("Arial");
        lineCommentary.setFontSize(12);
        lineCommentary.setText("COMENTÁRIOS:"); 
        
        for(int i = 0; i < reportCategoryTitle.length; i++) {

            String categoryTitle = reportCategoryTitle[i];
            String categoryText = reportCategoryText[i];

            XWPFParagraph paragraphCategory = xwpfdocument.createParagraph();
            paragraphCategory.setSpacingBetween(1.39d);
            paragraphCategory.setSpacingAfter(30);
            paragraphCategory.setAlignment(ParagraphAlignment.BOTH);
            
            XWPFRun lineIndex = paragraphCategory.createRun();
            lineIndex.setFontFamily("Arial");
            lineIndex.setFontSize(10);
            lineIndex.setText(String.valueOf(i + 1) + ". ");

            XWPFRun lineCategoryTitle = paragraphCategory.createRun();
            lineCategoryTitle.setBold(true);
            lineCategoryTitle.setFontFamily("Arial");
            lineCategoryTitle.setFontSize(10);
            lineCategoryTitle.setText(categoryTitle + ": ");

            XWPFRun lineCategoryText = paragraphCategory.createRun();
            lineCategoryText.setFontFamily("Arial");
            lineCategoryText.setFontSize(10);
            lineCategoryText.setText(categoryText);
        }

        XWPFParagraph paragraphConclusion = xwpfdocument.createParagraph();
        paragraphConclusion.setSpacingBetween(1.39d);
        paragraphConclusion.setSpacingAfter(30);
        XWPFRun lineConclusion = paragraphConclusion.createRun();
        lineConclusion.setBold(true);
        lineConclusion.setFontFamily("Arial");
        lineConclusion.setFontSize(12);
        lineConclusion.addBreak();
        lineConclusion.setText("CONCLUSÃO:");
        
        Iterator<String> iteratorCategoryConclusion = reportCategoryConclusion.iterator();
        
        while(iteratorCategoryConclusion.hasNext()) {
            
            XWPFParagraph paragraphCategoryConclusion = xwpfdocument.createParagraph();
            paragraphCategoryConclusion.setSpacingBetween(1.39d);
            paragraphCategoryConclusion.setSpacingAfter(30);
            paragraphCategoryConclusion.setAlignment(ParagraphAlignment.BOTH);
            XWPFRun lineCategoryText = paragraphCategoryConclusion.createRun();
            lineCategoryText.setFontFamily("Arial");
            lineCategoryText.setFontSize(10);
            lineCategoryText.setText("- " + iteratorCategoryConclusion.next()); 
        }     
        
        xwpfdocument.write(ostream);
        ostream.close(); 
    }
    
    public void reportWriterPrint(String[] reportCategoryTitle, String[] reportCategoryText, ArrayList<String> reportCategoryConclusion) throws PrinterException, DocumentException, IOException {
        
        Document document = new Document();
        BaseFont base = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
        Font categoryFont = new Font(base, 10f, Font.BOLD);
        Font titleFont = new Font(base, 12f, Font.BOLD);
        Font categoryTextFont = new Font(base, 10f, Font.NORMAL);

        File pdfFile = File.createTempFile("laudo_temp_", ".pdf");
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile));

        document.setMargins(2 * 28.35f, 2 * 28.35f, 2 * 28.35f, 2 * 28.35f);
        document.open(); 
        Chunk chunckCommentary = new Chunk("COMENTÁRIOS:", titleFont);
        Phrase phraseCommentary = new Phrase(chunckCommentary);
        Paragraph paragraphCommentary = new Paragraph(phraseCommentary);
        paragraphCommentary.setSpacingAfter(1);
        document.add(paragraphCommentary);

        for (int i = 0; i < reportCategoryTitle.length; i++){

            Chunk chunkIndex = new Chunk(String.valueOf(i+1) + ". ", categoryTextFont);
            Chunk chunkCategoryTitle = new Chunk(reportCategoryTitle[i] + ": ", categoryFont);
            Chunk chunkCategoryText = new Chunk(reportCategoryText[i], categoryTextFont);
            Phrase phraseCategory = new Phrase();
            Paragraph paragraphCategory = new Paragraph();
            paragraphCategory.setAlignment(com.itextpdf.text.Element.ALIGN_JUSTIFIED);
            phraseCategory.add(chunkIndex);
            phraseCategory.add(chunkCategoryTitle);
            phraseCategory.add(chunkCategoryText);
            paragraphCategory.add(phraseCategory);
            document.add(paragraphCategory);
        }

        Chunk chunckConclusion = new Chunk("\nCONCLUSÃO:", titleFont);
        Phrase phraseConclusion = new Phrase(chunckConclusion);
        Paragraph paragraphConclusion = new Paragraph(phraseConclusion);
        paragraphConclusion.setSpacingAfter(1);
        document.add(paragraphConclusion);
        
        Iterator<String> iteratorCategoryConclusion = reportCategoryConclusion.iterator();
         
        while(iteratorCategoryConclusion.hasNext()) {
        
            Paragraph paragraphCategoryConclusion = new Paragraph();
            paragraphCategoryConclusion.setSpacingAfter(1);
            Chunk chunkCategoryConclusion = new Chunk("- " + iteratorCategoryConclusion.next(), categoryTextFont);
            Phrase phraseCategoryConclusion = new Phrase();
            phraseCategoryConclusion.add(chunkCategoryConclusion);
            paragraphCategoryConclusion.add(phraseCategoryConclusion);
            document.add(paragraphCategoryConclusion);
        }
        
        document.close();   
        
        try (PDDocument documentPDF = PDDocument.load(pdfFile)) {
            
           PrinterJob job = PrinterJob.getPrinterJob();
           job.setPageable(new PDFPageable(documentPDF));

           if (job.printDialog()) {
               job.print();
           }
        } catch (PrinterException ex) {
            
            Logger.getLogger(ReportWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pdfFile.deleteOnExit();
    }
}
