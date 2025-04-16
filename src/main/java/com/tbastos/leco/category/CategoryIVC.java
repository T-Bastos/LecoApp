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
public final class CategoryIVC extends CategoryComponent {

    private String dilat = "XXX";
    private final JComboBoxSubcategory comboBoxModel;
    private final JComboBoxSubcategory comboBoxValv;
    private final JEditButton editButtonModel;
    
    public CategoryIVC() {
           
        jLabelCategory = new JLabelCategory("Veia cava inferior");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo")); 
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Normal", "Diâmetro normal + variação reduzida", "<html>Dilatada e variação normal - <b>DEFINIR</b></html>", "<html>Dilatada e sem variação - <b>DEFINIR</b></html>"});
        comboBoxModel.setName("Model");
        jComboBoxSubcategories.add(comboBoxModel);
        editButtonModel = new JEditButton();
        editButtonModel.setName("Model");
        arrayEditButton.add(editButtonModel);
        
        
        jLabelSubcategories.add(new JLabelSubcategory("Válvula de Eustáquio")); 
        comboBoxValv = new JComboBoxSubcategory(new String[]{"", "Presença de válvula de Eustáquio", "Presença de Rede de Chiari"});
        jComboBoxSubcategories.add(comboBoxValv);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
        
        editButtonModel.addActionListener((ActionEvent e) -> {
            
            fillFormModel();
        });
                
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                dilat = "XXX";
                
                if(comboBoxModel.getSelectedIndex() == 0 || comboBoxModel.getSelectedIndex() == 1 || comboBoxModel.getSelectedIndex() == 2) {
                    
                    editButtonModel.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonModel.setEnabled(true);
                    fillFormModel();
                }
            }
        });
        
        comboBoxValv.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
    }
    
    private void fillFormModel() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(dilat);

        Object[] input = new Object[2];
        input[0] = "Dilatação:";
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

            dilat = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Com diâmetro, variação respiratória e fluxo normais. ");
        hashCategoryReport.put("Diâmetro normal + variação reduzida", "Com diâmetro normal e variação respiratória reduzida. ");
        hashCategoryReport.put("<html>Dilatada e variação normal - <b>DEFINIR</b></html>", "Dilatada (" + dilat + " mm), com variação respiratória normal. ");
        hashCategoryReport.put("<html>Dilatada e sem variação - <b>DEFINIR</b></html>", "Dilatada (" + dilat + " mm), com variação respiratória reduzida. ");
        hashCategoryReport.put("Presença de válvula de Eustáquio", "Presença de válvula de Eustáquio na desembocadura da veia cava inferior. ");
        hashCategoryReport.put("Presença de Rede de Chiari", "Presença de Rede de Chiari na desembocadura da veia cava inferior. ");
    }  
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxModel.setSelectedIndex(1);
        editButtonModel.setEnabled(false);
    }
}
