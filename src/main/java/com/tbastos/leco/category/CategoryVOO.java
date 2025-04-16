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
public final class CategoryVOO extends CategoryComponent {
    
    private String vsve = "XXX";
    private String rest = "XXX";
    private String vals = "XXX";
    private final JComboBoxSubcategory comboBoxObstruction;
    private final JComboBoxSubcategory comboBoxDiamet;
    private final JEditButton editButtonObstruction;
    private final JEditButton editButtonDiamet;
    
    public CategoryVOO() {
        
        jLabelCategory = new JLabelCategory("<html>Via de saídas <br>dos ventrículos</br></html>");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Obstrução")); 
        comboBoxObstruction = new JComboBoxSubcategory(new String[]{"", "Sem obstruções", "<html>Obstrução dinâmica - <b>DEFINIR</b></html>"});
        comboBoxObstruction.setName("Obstruction");
        jComboBoxSubcategories.add(comboBoxObstruction);
        editButtonObstruction = new JEditButton();
        editButtonObstruction.setName("Obstruction");
        arrayEditButton.add(editButtonObstruction);
        
        jLabelSubcategories.add(new JLabelSubcategory("Diâmetro - Saída do VE")); 
        comboBoxDiamet = new JComboBoxSubcategory(new String[]{"", "<html>Diâmetro - <b>DEFINIR</b></html>"});
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
        
        editButtonObstruction.addActionListener((ActionEvent e) -> {
            
            fillFormObstruction();
        });
                
        comboBoxObstruction.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                rest = "XXX";
                vals = "XXX";
                
                if(comboBoxObstruction.getSelectedIndex() == 0 || comboBoxObstruction.getSelectedIndex() == 1) {
                    
                    editButtonObstruction.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonObstruction.setEnabled(true);
                    fillFormObstruction();
                }
            }
        });
        
        editButtonDiamet.addActionListener((ActionEvent e) -> {
            
            fillFormDiamet();
        });
                
        comboBoxDiamet.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                vsve = "XXX";
                
                if(comboBoxDiamet.getSelectedIndex() == 0) {
                    
                    editButtonDiamet.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonDiamet.setEnabled(true);
                    fillFormDiamet();
                }
            }
        });
    }
    
    private void fillFormObstruction() {
   
        JTextField field1 = new JTextField(10);
        field1.setText(rest);
        JTextField field2 = new JTextField(10);
        field2.setText(vals);

        Object[] input = new Object[4];
        input[0] = "Gradiente máximo estimado ao repouso(mmHg):";
        input[1] = field1;
        input[2] = "Gradiente máximo estimado após manobra de Valsava(mmHg):";
        input[3] = field2;

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

            rest = field1.getText();
            vals = field2.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    private void fillFormDiamet() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(vsve);

        Object[] input = new Object[2];
        input[0] = "Diâmetro da VSVE(cm):";
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

            vsve = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Sem obstruções", "Sem obstruções. ");
        hashCategoryReport.put("<html>Diâmetro - <b>DEFINIR</b></html>", "Diâmetro da VSVE: " + vsve + " cm. ");
        hashCategoryReport.put("<html>Obstrução dinâmica - <b>DEFINIR</b></html>", "Nota-se aceleração de fluxo sistólico na via de saída do ventrículo esquerdo relacionada à hipertrofia septal, com gradiente máximo estimado em " + rest + " mmHg ao repouso e " + vals + " mmHg após manobra de Valsalva (com pico telessistólico). Achados sugestivos de Cardiomiopatia Hipertrófica Septal Assimétrica Obstrutiva. ");
    }    
    
    @Override
    public void setNormalComboBoxes() {
        
        editButtonObstruction.setEnabled(false);
        editButtonDiamet.setEnabled(false);
        comboBoxObstruction.setSelectedIndex(1);
    }
}
