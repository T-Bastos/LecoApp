/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.mainui;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.tbastos.leco.selectionui.JPanelSelection;
import com.tbastos.leco.category.CategoryComponent;
import com.tbastos.leco.selectionui.JScrollSelection;
import com.tbastos.leco.selectionui.JScrollTextPane;
import com.tbastos.leco.utility.Report;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Tibério Bastos
 */
public class LecoUI {
     
    public void initUI() {
             
        try {
            
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            
            Logger.getLogger(LecoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JMainFrame jMainFrame = new JMainFrame();
        
        JPanelSelection jPanelSelection = new JPanelSelection();
        JScrollSelection jScrollSelection = new JScrollSelection(jPanelSelection);
        jMainFrame.add(jScrollSelection);
        
        JScrollTextPane jScrollTextPane = new JScrollTextPane(Report.getReport().getAndUpdateReportPane());
        jMainFrame.add(jScrollTextPane);
        
        Iterator<CategoryComponent> iterator = Report.getReport().getReportCategories().iterator();
        
        while(iterator.hasNext()) {
            
            jPanelSelection.addCategory(iterator.next());
        }
        
        jMainFrame.setJMenuBar(new JMainMenu());
        jMainFrame.setVisible(true);
    }
    
}
