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
public final class CategoryLeftAtrium extends CategoryComponent {
   
    private String vol = "XXX";
    private final JComboBoxSubcategory comboBoxSize;
    private final JEditButton editButtonSize;
    
    public CategoryLeftAtrium() {
    
        jLabelCategory = new JLabelCategory("Átrio esquerdo");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Tamanho")); 
        comboBoxSize = new JComboBoxSubcategory(new String[]{"", "Normal", "<html>Normal - <b>DEFINIR</b></html>", "Discreto", "<html>Discreto - <b>DEFINIR</b></html>", "Moderado", "<html>Moderado - <b>DEFINIR</b></html>", "Importante", "<html>Importante - <b>DEFINIR</b></html>"});
        comboBoxSize.setName("Size");
        jComboBoxSubcategories.add(comboBoxSize);
        editButtonSize = new JEditButton();
        editButtonSize.setName("Size");
        arrayEditButton.add(editButtonSize);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
        
        editButtonSize.addActionListener((ActionEvent e) -> {
            
            fillFormSize();
        });
                
        comboBoxSize.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                vol = "XXX";
                
                if(comboBoxSize.getSelectedIndex() == 0 || comboBoxSize.getSelectedIndex() == 1 || comboBoxSize.getSelectedIndex() == 3 || comboBoxSize.getSelectedIndex() == 5 || comboBoxSize.getSelectedIndex() == 7) {
                    
                    editButtonSize.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonSize.setEnabled(true);
                    fillFormSize();
                }
            }
        });
    }
    
    private void fillFormSize() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(vol);

        Object[] input = new Object[2];
        input[0] = "Volume estimado(mL/m²):";
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

            vol = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Com diâmetros normais. ");
        hashCategoryReport.put("Discreto", "Átrio esquerdo com aumento discreto. ");
        hashCategoryReport.put("Moderado", "Átrio esquerdo com aumento moderado. ");
        hashCategoryReport.put("Importante", "Átrio esquerdo com aumento importante. ");
        hashCategoryReport.put("<html>Normal - <b>DEFINIR</b></html>", "Com diâmetros normais; volume estimado em " + vol + " mL/m² (VR \u2264 34 mL/m²). ");
        hashCategoryReport.put("<html>Discreto - <b>DEFINIR</b></html>", "Átrio esquerdo com aumento discreto; volume estimado em " + vol + " mL/m² (VR \u2264 34 mL/m²). ");
        hashCategoryReport.put("<html>Moderado - <b>DEFINIR</b></html>", "Átrio esquerdo com aumento moderado; volume estimado em " + vol + " mL/m² (VR \u2264 34 mL/m²). ");
        hashCategoryReport.put("<html>Importante - <b>DEFINIR</b></html>", "Átrio esquerdo com aumento importante; volume estimado em " + vol + " mL/m² (VR \u2264 34 mL/m²). ");
    }
    
    @Override
    public void setNormalComboBoxes() {
        
        editButtonSize.setEnabled(false);
        comboBoxSize.setSelectedIndex(1);
    }
}
