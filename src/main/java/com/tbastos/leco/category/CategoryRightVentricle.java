/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.category;

import com.tbastos.leco.selectionui.JComboBoxSubcategory;
import com.tbastos.leco.selectionui.JEditButton;
import com.tbastos.leco.selectionui.JLabelCategory;
import com.tbastos.leco.selectionui.JLabelSubcategory;
import com.tbastos.leco.utility.Report;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Tibério
 */
public final class CategoryRightVentricle extends CategoryComponent {
    
    private String tapse = "XXX";
    private String s = "XXX";
    private String fac = "XXX";
    private String diamet = "XXX";
    private final JComboBoxSubcategory comboBoxSize;
    private final JComboBoxSubcategory comboBoxSys;
    private final JComboBoxSubcategory comboBoxTapse;
    private final JComboBoxSubcategory comboBoxS;
    private final JComboBoxSubcategory comboBoxFac;
    private final JComboBoxSubcategory comboBoxDiamet;
    private final JEditButton editButtonTapse;
    private final JEditButton editButtonS;
    private final JEditButton editButtonFac;
    private final JEditButton editButtonDiamet;
    
    public CategoryRightVentricle() {

        jLabelCategory = new JLabelCategory("Ventrículo direito");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Tamanho")); 
        comboBoxSize = new JComboBoxSubcategory(new String[]{"", "Normal", "Discreto", "Moderado", "Importante"});
        jComboBoxSubcategories.add(comboBoxSize);
        
        jLabelSubcategories.add(new JLabelSubcategory("Função sistólica")); 
        comboBoxSys = new JComboBoxSubcategory(new String[]{"", "Função normal", "Disfunção discreta", "Disfunção moderada", "Disfunção importante"});
        jComboBoxSubcategories.add(comboBoxSys);
        
        jLabelSubcategories.add(new JLabelSubcategory("TAPSE")); 
        comboBoxTapse = new JComboBoxSubcategory(new String[]{"", "<html>Com TAPSE - <b>DEFINIR</b></html>"});
        comboBoxTapse.setName("Tapse");
        jComboBoxSubcategories.add(comboBoxTapse);
        editButtonTapse = new JEditButton();
        editButtonTapse.setName("Tapse");
        arrayEditButton.add(editButtonTapse);
        
        jLabelSubcategories.add(new JLabelSubcategory("s'")); 
        comboBoxS = new JComboBoxSubcategory(new String[]{"", "<html>Com s' - <b>DEFINIR</b></html>"});
        comboBoxS.setName("S");
        jComboBoxSubcategories.add(comboBoxS);
        editButtonS = new JEditButton();
        editButtonS.setName("S");
        arrayEditButton.add(editButtonS);
        
        jLabelSubcategories.add(new JLabelSubcategory("FAC")); 
        comboBoxFac = new JComboBoxSubcategory(new String[]{"", "<html>Com FAC - <b>DEFINIR</b></html>"});
        comboBoxFac.setName("Fac");
        jComboBoxSubcategories.add(comboBoxFac);
        editButtonFac = new JEditButton();
        editButtonFac.setName("Fac");
        arrayEditButton.add(editButtonFac);
        
        jLabelSubcategories.add(new JLabelSubcategory("Diâmetro basal")); 
        comboBoxDiamet = new JComboBoxSubcategory(new String[]{"", "<html>Com DB - <b>DEFINIR</b></html>"});
        comboBoxDiamet.setName("Diamet");
        jComboBoxSubcategories.add(comboBoxDiamet);
        editButtonDiamet = new JEditButton();
        editButtonDiamet.setName("Diamet");
        arrayEditButton.add(editButtonDiamet);
        
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
        
        editButtonTapse.addActionListener((ActionEvent e) -> {
            
            fillFormTapse();
        });
        
        comboBoxTapse.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                tapse = "XXX";
                
                if(comboBoxTapse.getSelectedIndex() == 0) {
                    
                    editButtonTapse.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonTapse.setEnabled(true);
                    fillFormTapse();
                }
            }
        });
        
        editButtonS.addActionListener((ActionEvent e) -> {
            
            fillFormS();
        });
                
        comboBoxS.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                s = "XXX";
                
                if(comboBoxS.getSelectedIndex() == 0) {
                    
                    editButtonS.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonS.setEnabled(true);
                    fillFormS();
                }
            }
        });
        
        editButtonFac.addActionListener((ActionEvent e) -> {
            
            fillFormFac();
        });
                
        comboBoxFac.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                fac = "XXX";
                
                if(comboBoxFac.getSelectedIndex() == 0) {
                    
                    editButtonFac.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonFac.setEnabled(true);
                    fillFormFac();
                }
            }
        });
        
        editButtonDiamet.addActionListener((ActionEvent e) -> {
            
            fillFormDiamet();
        });
                
        comboBoxDiamet.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                diamet = "XXX";
                
                if(comboBoxDiamet.getSelectedIndex() == 0) {
                    
                    editButtonDiamet.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonDiamet.setEnabled(true);
                    fillFormDiamet();
                }
            }
        });
        
                        
        comboBoxSize.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxSys.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
    }
    
    private void fillFormS() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(s);

        Object[] input = new Object[2];
        input[0] = "s'(cm/s):";
        input[1] = field1;

        JOptionPane optionPane = new JOptionPane(
                input,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION
        );

        JDialog dialog = optionPane.createDialog("Defina os parâmetros");

        Timer timer = new Timer(100, (ActionEvent e) -> {
            field1.requestFocusInWindow();
        });
        
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
        
        Object selectedValue = optionPane.getValue();
        
        if (selectedValue instanceof Integer && (Integer) selectedValue == JOptionPane.OK_OPTION) {

            s = field1.getText();
        }  
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormFac() {
           
        JTextField field1 = new JTextField(10);
        field1.setText(fac);

        Object[] input = new Object[2];
        input[0] = "FAC(%):";
        input[1] = field1;

        JOptionPane optionPane = new JOptionPane(
                input,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION
        );

        JDialog dialog = optionPane.createDialog("Defina os parâmetros");

        Timer timer = new Timer(100, (ActionEvent e) -> {
            field1.requestFocusInWindow();
        });
        
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
        
        Object selectedValue = optionPane.getValue();
        
        if (selectedValue instanceof Integer && (Integer) selectedValue == JOptionPane.OK_OPTION) {

            fac = field1.getText();
        }  
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormTapse() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(tapse);

        Object[] input = new Object[2];
        input[0] = "TAPSE(cm):";
        input[1] = field1;

        JOptionPane optionPane = new JOptionPane(
                input,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION
        );

        JDialog dialog = optionPane.createDialog("Defina os parâmetros");

        Timer timer = new Timer(100, (ActionEvent e) -> {
            field1.requestFocusInWindow();
        });
        
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
        
        Object selectedValue = optionPane.getValue();
        
        if (selectedValue instanceof Integer && (Integer) selectedValue == JOptionPane.OK_OPTION) {

            tapse = field1.getText();
        }  
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormDiamet() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(diamet);

        Object[] input = new Object[2];
        input[0] = "Diâmetro basal(mm):";
        input[1] = field1;

        JOptionPane optionPane = new JOptionPane(
                input,
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.OK_CANCEL_OPTION
        );

        JDialog dialog = optionPane.createDialog("Defina os parâmetros");

        Timer timer = new Timer(100, (ActionEvent e) -> {
            field1.requestFocusInWindow();
        });
        
        timer.setRepeats(false);
        timer.start();

        dialog.setVisible(true);
        
        Object selectedValue = optionPane.getValue();
        
        if (selectedValue instanceof Integer && (Integer) selectedValue == JOptionPane.OK_OPTION) {

            diamet = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Com dimensões normais. ");
        hashCategoryReport.put("Discreto", "Aumento discreto do ventrículo direito. ");
        hashCategoryReport.put("Moderado", "Aumento moderado do ventrículo direito. ");
        hashCategoryReport.put("Importante", "Aumento importante do ventrículo direito. ");
        hashCategoryReport.put("Função normal", "Função sistólica normal. ");
        hashCategoryReport.put("Disfunção discreta", "Função sistólica reduzida em grau discreto. ");
        hashCategoryReport.put("Disfunção moderada", "Função sistólica reduzida em grau moderado. ");
        hashCategoryReport.put("Disfunção importante", "Função sistólica reduzida em grau importante. ");
        hashCategoryReport.put("<html>Com TAPSE - <b>DEFINIR</b></html>", "TAPSE: " + tapse + " cm (VR \u2265 1,7 cm). "); 
        hashCategoryReport.put("<html>Com s' - <b>DEFINIR</b></html>", "s': " + s + " cm/s (VR \u2265 9,5 cm/s). ");
        hashCategoryReport.put("<html>Com FAC - <b>DEFINIR</b></html>", "FAC: " + fac + "% (VR \u2265 35%). ");
        hashCategoryReport.put("<html>Com DB - <b>DEFINIR</b></html>", "Diâmetro basal: " + diamet + " mm (VR \u2264 41 mm). ");
    }         
    
    protected void setSubcategoryParameters() {
    

        JTextField field1 = new JTextField(10);
        field1.setText(tapse);
        JTextField field2 = new JTextField(10);
        field2.setText(s);
        JTextField field3 = new JTextField(10);
        field3.setText(fac);
        JTextField field4 = new JTextField(10);
        field4.setText(diamet);
        
        Object[] input = {
            
            "TAPSE(cm):", field1,
            "s'(cm/s):", field2,
            "FAC(%):", field3,
            "Diâmetro basal(mm):", field4,
        };
        
        int result = JOptionPane.showConfirmDialog(null, input, "Defina os parâmetros", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {

            tapse = field1.getText();
            s = field2.getText();
            fac = field3.getText();
            diamet = field4.getText();
            
            setHashCategoryReport();
            Report.getReport().getAndUpdateReportPane();
        }       
    }
    
    @Override
    public void setNormalComboBoxes() {
        
        editButtonTapse.setEnabled(false);
        editButtonS.setEnabled(false);
        editButtonFac.setEnabled(false);
        editButtonDiamet.setEnabled(false);
        comboBoxSize.setSelectedIndex(1);
        comboBoxSys.setSelectedIndex(1);
    }
}
