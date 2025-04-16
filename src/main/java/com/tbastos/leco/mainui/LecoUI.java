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
        
        initLang();
        
        JMainFrame jMainFrame = new JMainFrame();
        
        JPanelSelection jPanelSelection = new JPanelSelection();
        JScrollSelection jScrollSelection = new JScrollSelection(jPanelSelection);
        jMainFrame.add(jScrollSelection);
        Report.getReport().updateReportPane();
        JScrollTextPane jScrollTextPane = new JScrollTextPane(Report.getReport().getReportPane());
        jMainFrame.add(jScrollTextPane);
        
        Iterator<CategoryComponent> iterator = Report.getReport().getReportCategories().iterator();
        
        while(iterator.hasNext()) {
            
            jPanelSelection.addCategory(iterator.next());
        }
        
        jMainFrame.setJMenuBar(new JMainMenu());
        jMainFrame.setVisible(true);
    }
    
    public void initLang() {
        
        UIManager.put("OptionPane.noButtonText", "Não");
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.openDialogTitleText", "Abrir");
        UIManager.put("FileChooser.saveDialogTitleText", "Salvar");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.saveButtonText", "Salvar");
        UIManager.put("FileChooser.lookInLabelText", "Procurar em");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo de arquivo");
    }
}
