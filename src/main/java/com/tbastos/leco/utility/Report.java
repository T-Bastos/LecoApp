/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.utility;

import com.tbastos.leco.category.CategoryAdditionalFindings;
import com.tbastos.leco.category.CategoryAorticValve;
import com.tbastos.leco.category.CategoryAtrialSeptum;
import com.tbastos.leco.category.CategoryComponent;
import com.tbastos.leco.category.CategoryConclusion;
import com.tbastos.leco.category.CategoryIVC;
import com.tbastos.leco.category.CategoryInitialInfo;
import com.tbastos.leco.category.CategoryLeftAtrium;
import com.tbastos.leco.category.CategoryLeftVentricle;
import com.tbastos.leco.category.CategoryMitralValve;
import com.tbastos.leco.category.CategoryMyocardialThickness;
import com.tbastos.leco.category.CategoryPericardium;
import com.tbastos.leco.category.CategoryPulmonaryTrunkArteries;
import com.tbastos.leco.category.CategoryPulmonaryValve;
import com.tbastos.leco.category.CategoryRightAtrium;
import com.tbastos.leco.category.CategoryRightVentricle;
import com.tbastos.leco.category.CategoryThoracicAorta;
import com.tbastos.leco.category.CategoryTricuspidValve;
import com.tbastos.leco.category.CategoryVOO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Tibério
 */
public class Report {
    
    private final ArrayList<CategoryComponent> categories;
    private final JTextPane reportPane;
    private static Report report;
    
    private Report() {
        
        categories =  new ArrayList<>();
        categories.add(new CategoryInitialInfo());
        categories.add(new CategoryLeftAtrium());
        categories.add(new CategoryRightAtrium());
        categories.add(new CategoryMyocardialThickness());
        categories.add(new CategoryLeftVentricle());
        categories.add(new CategoryRightVentricle());
        categories.add(new CategoryVOO());
        categories.add(new CategoryMitralValve());
        categories.add(new CategoryAorticValve());
        categories.add(new CategoryTricuspidValve());
        categories.add(new CategoryPulmonaryValve());
        categories.add(new CategoryPulmonaryTrunkArteries());
        categories.add(new CategoryThoracicAorta());
        categories.add(new CategoryIVC());
        categories.add(new CategoryAtrialSeptum());
        categories.add(new CategoryPericardium());
        categories.add(new CategoryAdditionalFindings());
        categories.add(new CategoryConclusion());
        
        reportPane = new JTextPane();
        reportPane.setEditable(false);
        reportPane.setEnabled(false);
        reportPane.setDisabledTextColor(Color.BLACK);
    }
    
    public static Report getReport() {
        
        if(report == null) {
            
            report = new Report();
        }
        
        return report;
    }
    
    public ArrayList<CategoryComponent> getReportCategories() {
        
        return categories;
    }
    
    public JTextPane getReportPane() {
        
        return this.reportPane;
    }
    
    public JTextPane updateReportPane() {
        
        try {
            
            reportPane.setDocument(new DefaultStyledDocument());
            StyledDocument doc = reportPane.getStyledDocument();

            Style styleParagraph = doc.addStyle("Paragraph", null);
            StyleConstants.setAlignment(styleParagraph, StyleConstants.ALIGN_JUSTIFIED);
            StyleConstants.setSpaceAbove(styleParagraph, 1);
            doc.setLogicalStyle(0, styleParagraph);

            Style styleBold12 = doc.addStyle("BoldSize12", styleParagraph);
            StyleConstants.setBold(styleBold12, true);
            StyleConstants.setFontFamily(styleBold12, UIManager.getFont("Label.font").getFamily());
            StyleConstants.setFontSize(styleBold12, 12);

            Style style12 = doc.addStyle("Size12", styleParagraph);
            StyleConstants.setFontFamily(style12, UIManager.getFont("Label.font").getFamily());
            StyleConstants.setFontSize(style12, 12);

            Style styleBold18 = doc.addStyle("BoldSize18", styleParagraph);
            StyleConstants.setFontFamily(styleBold18, UIManager.getFont("Label.font").getFamily());
            StyleConstants.setBold(styleBold18, true);
            StyleConstants.setFontSize(styleBold18, 18);
            
            doc.insertString(doc.getLength(), "COMENTÁRIOS:\n", doc.getStyle("BoldSize18"));
            
            Iterator<CategoryComponent> iteratorCategory = report.getReportCategories().iterator();
            int i = 0;
            CategoryComponent category;
            
            while(iteratorCategory.hasNext() && i < Report.getReport().getReportCategories().size() - 1) {
                
                category = iteratorCategory.next();                  
                doc.insertString(doc.getLength(), Integer.toString(i + 1) + ". ", doc.getStyle("Size12"));
                doc.insertString(doc.getLength(), category.getCategoryTitle() + ": ", doc.getStyle("BoldSize12"));
                doc.insertString(doc.getLength(), category.getCategoryText(), doc.getStyle("Size12"));
                if(!category.getCategoryTextArea().getText().equals("Digite sua nota opcional aqui...")) {
                
                    doc.insertString(doc.getLength(), category.getCategoryTextArea().getText(), doc.getStyle("Size12"));
                }
                doc.insertString(doc.getLength(), "\n", null);
                i++;
            }
            
            category = iteratorCategory.next(); 
            
            doc.insertString(doc.getLength(), "\nCONCLUSÃO :\n", doc.getStyle("BoldSize18"));
            
            Iterator<String> iteratorCategoryConclusion = category.getCategoryTextArray().iterator();
            
            while(iteratorCategoryConclusion.hasNext()) {

                doc.insertString(doc.getLength(), "- " + iteratorCategoryConclusion.next() + "\n", doc.getStyle("Size12"));
            }
            
            if(!category.getCategoryTextArea().getText().equals("") && !category.getCategoryTextArea().getText().equals("Digite sua nota opcional aqui...")) {
                
                doc.insertString(doc.getLength(), "- " + category.getCategoryTextArea().getText(), doc.getStyle("Size12"));
            }
            
        } catch (BadLocationException ex) {
            
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reportPane;
    }
}
