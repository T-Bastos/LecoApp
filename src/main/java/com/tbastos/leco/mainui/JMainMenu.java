/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.mainui;

import com.itextpdf.text.DocumentException;
import com.tbastos.leco.utility.ReportWriter;
import com.tbastos.leco.category.CategoryComponent;
import com.tbastos.leco.utility.Report;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tibério
 */
public class JMainMenu extends JMenuBar{

    private final JMenu jMenuFile;
    private final JMenuItem jMenuItemSave;
    private final JMenuItem jMenuItemPrint;
    private final JMenu jMenuReport;
    private final JMenuItem jMenuItemNewReport;
    private final JMenuItem jMenuItemNewNormalReport;
    
    public JMainMenu() {
        
        jMenuFile = new JMenu("Arquivo");
        add(jMenuFile);
        jMenuItemSave = new JMenuItem("Salvar como...", new ImageIcon(getClass().getResource("/save.png")));
        jMenuFile.add(jMenuItemSave);
        jMenuItemPrint = new JMenuItem("Imprimir como...", new ImageIcon(getClass().getResource("/print.png")));
        jMenuFile.add(jMenuItemPrint);
        
        jMenuReport = new JMenu("Laudo");
        add(jMenuReport);
        jMenuItemNewReport = new JMenuItem("Laudo novo", new ImageIcon(getClass().getResource("/newfile.png")));
        jMenuReport.add(jMenuItemNewReport);
        jMenuItemNewNormalReport = new JMenuItem("Laudo novo - Normal", new ImageIcon(getClass().getResource("/newfile-normal.png")));
        jMenuReport.add(jMenuItemNewNormalReport);
        
        setMenuListeners();
    }

    private void printReport() {
        
        String[] reportCategoryTitle = new String[Report.getReport().getReportCategories().size() - 1];
        String[] reportCategoryText = new String[Report.getReport().getReportCategories().size() - 1];
                 
        Iterator<CategoryComponent> iteratorCategory = Report.getReport().getReportCategories().iterator();
        CategoryComponent category;
        int i = 0;
        
        while(iteratorCategory.hasNext() && i < Report.getReport().getReportCategories().size() - 1) {

            category = iteratorCategory.next();
            reportCategoryTitle[i] = category.getCategoryTitle();
            if(category.getCategoryTextArea().getText().equals("Digite sua nota opcional aqui...")) {
            
                reportCategoryText[i] = category.getCategoryText();
            } else {
            
                reportCategoryText[i] = category.getCategoryText() + category.getCategoryTextArea().getText();
            }
            i++;
        }
        
        category = iteratorCategory.next();
        ArrayList<String> categoryConclusionText = category.getCategoryTextArray();
        if(!category.getCategoryTextArea().getText().equals("Digite sua nota opcional aqui...") && !category.getCategoryTextArea().getText().equals("")) {
            
            categoryConclusionText.add(category.getCategoryTextArea().getText());
        }
        
        try {
            
            ReportWriter writer = new ReportWriter();
            writer.reportWriterPrint(reportCategoryTitle, reportCategoryText, categoryConclusionText);
        } catch (PrinterException | DocumentException | IOException ex) {
            
            JOptionPane.showMessageDialog(jMenuItemPrint, "Erro ao tentar imprimir, tente novamente", "Erro de impressão", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void createNewReport() {
        
        int choiceConfirm = JOptionPane.showConfirmDialog(jMenuItemNewReport, "Ao criar um novo laudo, todas as escolhas feitas serão apagadas" , "CONFIRMAÇÃO DO LAUDO NOVO", JOptionPane.YES_NO_OPTION);

        if(choiceConfirm == JOptionPane.YES_OPTION) { 
                
            Iterator<CategoryComponent> iterator = Report.getReport().getReportCategories().iterator();
            
            while(iterator.hasNext()) {
           
                CategoryComponent category = iterator.next();
                category.setIndex0ComboBoxes();
                category.getCategoryTextArea().setText("");
            }
        }
    }
    
    private void createNewNormalReport() {
                           
        int choiceConfirm = JOptionPane.showConfirmDialog(jMenuItemNewReport, "Ao criar um laudo novo normalizado, as opções anteriores serão apagadas e substituídas pelas opções Normalizadas" , "CONFIRMAÇÃO DO LAUDO NOVO NORMAL", JOptionPane.YES_NO_OPTION);

        if(choiceConfirm == JOptionPane.YES_OPTION) { 
            
            Iterator<CategoryComponent> iterator = Report.getReport().getReportCategories().iterator();
            CategoryComponent category;
            
            while(iterator.hasNext()) {
            
                category = iterator.next();
                category.setIndex0ComboBoxes();
                category.setNormalComboBoxes();
            }
            
            Report.getReport().updateReportPane();
        }
    }
    
    private void saveReport() {
        
        String[] reportCategoryTitle = new String[Report.getReport().getReportCategories().size() - 1];
        String[] reportCategoryText = new String[Report.getReport().getReportCategories().size() - 1];
                 
        Iterator<CategoryComponent> iteratorCategory = Report.getReport().getReportCategories().iterator();
        CategoryComponent category;
        int i = 0;
        
        while(iteratorCategory.hasNext() && i < Report.getReport().getReportCategories().size() - 1) {

            category = iteratorCategory.next();
            reportCategoryTitle[i] = category.getCategoryTitle();
            if(category.getCategoryTextArea().getText().equals("Digite sua nota opcional aqui...")) {
            
                reportCategoryText[i] = category.getCategoryText();
            } else {
            
                reportCategoryText[i] = category.getCategoryText() + category.getCategoryTextArea().getText();
            }
            i++;
        }
        
        category = iteratorCategory.next();
        ArrayList<String> categoryConclusionText = category.getCategoryTextArray();
        if(!category.getCategoryTextArea().getText().equals("Digite sua nota opcional aqui...") && !category.getCategoryTextArea().getText().equals("")) {
            
            categoryConclusionText.add(category.getCategoryTextArea().getText());
        }
        
        JFileChooser fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        fc.setDialogTitle("Exportar Relatório");
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Documento de texto (*.txt)", "txt"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("PDF (*.pdf)", "pdf"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Documento Word (*.docx)", "docx"));

        int returnVal = fc.showSaveDialog(jMenuItemSave);

        if (returnVal == JFileChooser.APPROVE_OPTION) { 

            try {
                ReportWriter writer = new ReportWriter(fc.getCurrentDirectory(), fc.getSelectedFile().getName());
                
                switch (fc.getFileFilter().getDescription()) {
                    
                    case "Documento de texto (*.txt)" -> writer.reportWriterTxt(reportCategoryTitle, reportCategoryText, categoryConclusionText);
                    case "PDF (*.pdf)" -> writer.reportWriterPdf(reportCategoryTitle, reportCategoryText, categoryConclusionText);
                    case "Documento Word (*.docx)" -> writer.reportWriterDocx(reportCategoryTitle, reportCategoryText, categoryConclusionText);
                }
            } catch (IOException | DocumentException ex) {
                
                JOptionPane.showMessageDialog(null, "Erro ao tentar salvar o laudo, tente novamente", "Erro ao salvar o laudo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void setMenuListeners() {
        
        jMenuItemPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                printReport();
            }
        });
        
        jMenuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                saveReport();
            }
        });
        
        jMenuItemNewReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                createNewReport();
            }
        });
        
        jMenuItemNewNormalReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                createNewNormalReport();
            }
        });
    }
}
