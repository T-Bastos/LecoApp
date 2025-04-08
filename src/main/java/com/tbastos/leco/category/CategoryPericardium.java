
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
    private final JEditButton editButtonModel;
    private final JEditButton editButtonBlade;
    
    public CategoryPericardium() {
           
        jLabelCategory = new JLabelCategory("Pericárdio");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo")); 
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Normal", "<html>Derrame pericárdico - <b>DEFINIR</b></html>"});
        comboBoxModel.setName("Model");
        jComboBoxSubcategories.add(comboBoxModel);
        editButtonModel = new JEditButton();
        editButtonModel.setName("Model");
        arrayEditButton.add(editButtonModel);
        
        jLabelSubcategories.add(new JLabelSubcategory("Localização do derrame")); 
        comboBoxEffusion = new JComboBoxSubcategory(new String[]{"", "Difuso", "Topografia anterior", "Topografia posterior"});
        jComboBoxSubcategories.add(comboBoxEffusion);
        
        jLabelSubcategories.add(new JLabelSubcategory("Grau do derrame")); 
        comboBoxEffusionDegree = new JComboBoxSubcategory(new String[]{"", "Discreto", "Moderado", "Importante"});
        jComboBoxSubcategories.add(comboBoxEffusionDegree);
        
        jLabelSubcategories.add(new JLabelSubcategory("Sinais de restrição")); 
        comboBoxRestriction = new JComboBoxSubcategory(new String[]{"", "Sem sinais", "Com sinais"});
        jComboBoxSubcategories.add(comboBoxRestriction);
        
        jLabelSubcategories.add(new JLabelSubcategory("Lâmina")); 
        comboBoxBlade = new JComboBoxSubcategory(new String[]{"", "<html>Lâmina - <b>DEFINIR</b></html>"});
        comboBoxBlade.setName("Blade");
        jComboBoxSubcategories.add(comboBoxBlade);
        editButtonBlade = new JEditButton();
        editButtonBlade.setName("Blade");
        arrayEditButton.add(editButtonBlade);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
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
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonBlade.setEnabled(true);
                    fillFormBlade();
                }
            }
        });
        
        editButtonModel.addActionListener((ActionEvent e) -> {
            
            fillFormModel();
        });
                
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                effusion = "XXX";
                degreeEffusion = "XXX";
                restriction = "XXX";
                
                if(comboBoxModel.getSelectedIndex() == 0 || comboBoxModel.getSelectedIndex() == 1) {
                    
                    editButtonModel.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonModel.setEnabled(true);
                    fillFormModel();
                }
            }
        });
        
        comboBoxRestriction.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxEffusionDegree.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxEffusion.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
    }
    
    private void fillFormModel() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(effusion);
        JTextField field2 = new JTextField(10);
        field2.setText(degreeEffusion);
        JTextField field3 = new JTextField(10);
        field3.setText(restriction);

        Object[] input = new Object[6];
        input[0] = "Derrame pericárdico:";
        input[1] = field1;
        input[2] = "Grau do derrame:";
        input[3] = field2;
        input[4] = "Sinais de restrição:";
        input[5] = field3;

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

            effusion = field1.getText();
            degreeEffusion = field2.getText();
            restriction = field3.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
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
        Report.getReport().getAndUpdateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Normal. ");
        hashCategoryReport.put("<html>Derrame pericárdico - <b>DEFINIR</b></html>", "Presença de derrame pericárdico " + effusion + " de grau " + degreeEffusion + ", " + restriction + " sinais de restrição ao enchimento ventricular. ");
        hashCategoryReport.put("Difuso", "Difuso. ");
        hashCategoryReport.put("Topografia anterior", "Localização do derrame na topografia anterior. ");
        hashCategoryReport.put("Topografia posterior", "Localização do derrame na topografia posterior. ");
        hashCategoryReport.put("Discreto", "Grau do derrame discreto. ");
        hashCategoryReport.put("Moderado", "Grau do derrame moderado. ");
        hashCategoryReport.put("Importante", "Grau do derrame importante. ");
        hashCategoryReport.put("Sem sinais", "Sem sinais de restrição. ");
        hashCategoryReport.put("Com sinais", "Com sinais de restrição. ");
        hashCategoryReport.put("<html>Lâmina - <b>DEFINIR</b></html>", "A maior lâmina do derrame mede " + biggestBlade + " mm. ");
    }      
    
    @Override
    public void setNormalComboBoxes() {
        
        editButtonModel.setEnabled(false);
        editButtonBlade.setEnabled(false);
        comboBoxModel.setSelectedIndex(1);
    }
}
