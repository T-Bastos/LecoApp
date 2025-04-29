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
public final class CategoryPulmonaryTrunkArteries extends CategoryComponent {
    
    private String diamet = "XXX";
    private String pressure = "XXX";
    private final JComboBoxSubcategory comboBoxDiamet;
    private final JComboBoxSubcategory comboBoxPressure;
    private final JComboBoxSubcategory comboBoxHypertension;
    private final JEditButton editButtonDiamet;
    private final JEditButton editButtonPressure;
    
    public CategoryPulmonaryTrunkArteries() {
        
        jLabelCategory = new JLabelCategory("<html>Tronco e artérias <br>pulmonares</br></html>");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Diâmetro")); 
        comboBoxDiamet = new JComboBoxSubcategory(new String[]{"", "Diâmetro e fluxos normais", "<html>Diâmetro aumentado - Tronco Pulmonar - <b>DEFINIR</b></html>"});
        comboBoxDiamet.setName("Diamet");
        jComboBoxSubcategories.add(comboBoxDiamet);
        editButtonDiamet = new JEditButton();
        editButtonDiamet.setName("Diamet");
        arrayEditButton.add(editButtonDiamet);
        
        jLabelSubcategories.add(new JLabelSubcategory("Pressão sistólica em artéria pulmonar")); 
        comboBoxPressure = new JComboBoxSubcategory(new String[]{"", "<html>Pressão - <b>DEFINIR</b></html>"});
        comboBoxPressure.setName("Pressure");
        jComboBoxSubcategories.add(comboBoxPressure);
        editButtonPressure = new JEditButton();
        editButtonPressure.setName("Pressure");
        arrayEditButton.add(editButtonPressure);
        
        jLabelSubcategories.add(new JLabelSubcategory("Sinais indiretos de hipertensão pulmonar")); 
        comboBoxHypertension = new JComboBoxSubcategory(new String[]{"", "Ausência de sinais - Pressão pulmonar", "Sistólica - D-shape", "Diastólica - D-shape"});
        jComboBoxSubcategories.add(comboBoxHypertension);
        
        JLabelSubcategory notes = new JLabelSubcategory("Notas adicionais");
        notes.setName("Notes");
        jLabelSubcategories.add(notes);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
                 
    protected void setCategoryListeners() {
     
        editButtonPressure.addActionListener((ActionEvent e) -> {
            
            fillFormPressure();
        });
                
        comboBoxPressure.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                pressure = "XXX";
                
                if(comboBoxPressure.getSelectedIndex() == 0) {
                    
                    editButtonPressure.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonPressure.setEnabled(true);
                    fillFormPressure();
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
                
                if(comboBoxDiamet.getSelectedIndex() == 0 || comboBoxDiamet.getSelectedIndex() == 1) {
                    
                    editButtonDiamet.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonDiamet.setEnabled(true);
                    fillFormDiamet();
                }
            }
        });
        
        comboBoxHypertension.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
    }
    
    private void fillFormDiamet() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(diamet);

        Object[] input = new Object[2];
        input[0] = "Diâmetro aumentado do tronco pulmonar(mm):";
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
        Report.getReport().updateReportPane();        
    }
    
    private void fillFormPressure() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(pressure);

        Object[] input = new Object[2];
        input[0] = "Pressão sistólica em artéria pulmonar:";
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

            pressure = field1.getText();                    
        }  
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Diâmetro e fluxos normais", "Com diâmetros e fluxo normais. ");
        hashCategoryReport.put("<html>Diâmetro aumentado - Tronco Pulmonar - <b>DEFINIR</b></html>", "Tronco pulmonar com diâmetro aumentado (" + diamet + " mm) e fluxo normal. ");
        hashCategoryReport.put("<html>Pressão - <b>DEFINIR</b></html>", "Pressão sistólica em artéria pulmonar estimada em " + pressure + " mmHg (anormal se > 35 mmHg). ");
        hashCategoryReport.put("Ausência de sinais - Pressão pulmonar", "Ausência de sinais indiretos de aumento da pressão pulmonar. ");
        hashCategoryReport.put("Sistólica - D-shape", "Presença de retificação sistólica do septo interventricular (“D-shape”). ");
        hashCategoryReport.put("Diastólica - D-shape", "Presença de retificação diastólica do septo interventricular (“D-shape”). ");
    }         
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxDiamet.setSelectedIndex(1);
        comboBoxHypertension.setSelectedIndex(1);
    }
}
