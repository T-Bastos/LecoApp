
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
public final class CategoryPericardium extends CategoryComponent {

    private String effusion = "XXX";
    private String degreeEffusion = "XXX";
    private String restriction = "XXX";
    private String biggestBlade = "XXX";
    private final JComboBoxSubcategory comboBoxModel;
    private final JComboBoxSubcategory comboBoxEffusion;
    private final JComboBoxSubcategory comboBoxEffusionDegree;
    private final JComboBoxSubcategory comboBoxRestriction;
    private final JComboBoxSubcategory comboBoxBlade;
    private final JEditButton editButtonBlade;
    
    public CategoryPericardium() {
           
        jLabelCategory = new JLabelCategory("Pericárdio");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo")); 
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Normal", "Derrame pericárdico"});
        jComboBoxSubcategories.add(comboBoxModel);
        
        jLabelSubcategories.add(new JLabelSubcategory("Localização do derrame")); 
        comboBoxEffusion = new JComboBoxSubcategory(new String[]{"", "Anterior", "Posterior", "Difuso"});
        comboBoxEffusion.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxEffusion);
        
        jLabelSubcategories.add(new JLabelSubcategory("Grau do derrame")); 
        comboBoxEffusionDegree = new JComboBoxSubcategory(new String[]{"", "Mínimo", "Discreto", "Moderado", "Importante"});
        comboBoxEffusionDegree.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxEffusionDegree);
        
        jLabelSubcategories.add(new JLabelSubcategory("Sinais de restrição")); 
        comboBoxRestriction = new JComboBoxSubcategory(new String[]{"", "Ausência", "Presença"});
        comboBoxRestriction.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxRestriction);
        
        jLabelSubcategories.add(new JLabelSubcategory("Lâmina")); 
        comboBoxBlade = new JComboBoxSubcategory(new String[]{"", "<html>Lâmina - <b>DEFINIR</b></html>"});
        comboBoxBlade.setEnabled(false);
        comboBoxBlade.setName("Blade");
        jComboBoxSubcategories.add(comboBoxBlade);
        editButtonBlade = new JEditButton();
        editButtonBlade.setName("Blade");
        arrayEditButton.add(editButtonBlade);
        
        JLabelSubcategory notes = new JLabelSubcategory("Notas adicionais");
        notes.setName("Notes");
        jLabelSubcategories.add(notes);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    protected void setCategoryListeners() {
    
        editButtonBlade.addActionListener((ActionEvent e) -> {
            
            fillFormBlade();
        });
                
        comboBoxBlade.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                biggestBlade = "XXX";
                
                if(comboBoxBlade.getSelectedIndex() == 0) {
                    
                    editButtonBlade.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonBlade.setEnabled(true);
                    fillFormBlade();
                }
            }
        });
                
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                int selectedIndex = comboBoxModel.getSelectedIndex();
                
                if(selectedIndex == 0 || selectedIndex == 1) {
                    
                    comboBoxEffusion.setEnabled(false);
                    comboBoxEffusionDegree.setEnabled(false);
                    comboBoxRestriction.setEnabled(false);
                    comboBoxBlade.setEnabled(false);
                } else if(selectedIndex == 2){
                    
                    comboBoxEffusion.setEnabled(true);
                    comboBoxEffusionDegree.setEnabled(true);
                    comboBoxRestriction.setEnabled(true);
                    comboBoxBlade.setEnabled(true);
                }
                
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxRestriction.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxRestriction.getSelectedIndex() != 0) {
                    
                    restriction = comboBoxRestriction.getSelectedItem().toString().toLowerCase();
                } else {
                    
                    restriction = "XXX";
                }
                setHashCategoryReport();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxEffusionDegree.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxEffusionDegree.getSelectedIndex() != 0) {
                    
                    degreeEffusion = comboBoxEffusionDegree.getSelectedItem().toString().toLowerCase();
                } else {
                    
                    degreeEffusion = "XXX";
                }
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxEffusion.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxEffusion.getSelectedIndex() != 0) {
                    
                    effusion = comboBoxEffusion.getSelectedItem().toString().toLowerCase();
                } else {
                    
                    effusion = "XXX";
                }
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
    }
    
    private void fillFormBlade() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(biggestBlade);

        Object[] input = new Object[2];
        input[0] = "Maior lâmina do derrame(mm):";
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

            biggestBlade = field1.getText();
        }  
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Normal. ");
        hashCategoryReport.put("Derrame pericárdico", "Presença de derrame pericárdico " + effusion + " de grau " + degreeEffusion + ", " + restriction + " de sinais de restrição ao enchimento ventricular. ");
        hashCategoryReport.put("Difuso", "");
        hashCategoryReport.put("Anterior", "");
        hashCategoryReport.put("Posterior", "");
        hashCategoryReport.put("Mínimo", "");
        hashCategoryReport.put("Discreto", "");
        hashCategoryReport.put("Moderado", "");
        hashCategoryReport.put("Importante", "");
        hashCategoryReport.put("Ausência", "");
        hashCategoryReport.put("Presença", "");
        hashCategoryReport.put("<html>Lâmina - <b>DEFINIR</b></html>", "A maior lâmina do derrame mede " + biggestBlade + " mm. ");
    }      
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxModel.setSelectedIndex(1);
    }
}
