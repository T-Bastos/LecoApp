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
public final class CategoryAtrialSeptum extends CategoryComponent {

    private String oval = "XXX";
    private String qq = "XXX";
    private final JComboBoxSubcategory comboBoxModel;
    private final JComboBoxSubcategory comboBoxHypertrophy;
    private final JEditButton editButtonModel;
    
    public CategoryAtrialSeptum () {
           
        jLabelCategory = new JLabelCategory("Septo interatrial");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo")); 
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Normal", "Membrana aneurismática", "Membrana redundante", "FOP", "FOP + membrana aneurismática", "<html>CIA OS - <b>DEFINIR</b></html>"});
        comboBoxModel.setName("Model");
        jComboBoxSubcategories.add(comboBoxModel);
        editButtonModel = new JEditButton();
        editButtonModel.setName("Model");
        arrayEditButton.add(editButtonModel);
        setModelListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Hipertrofia lipomatosa")); 
        comboBoxHypertrophy = new JComboBoxSubcategory(new String[]{"", "Infiltração lipomatosa", "Hipertrofia lipomatosa"});
        jComboBoxSubcategories.add(comboBoxHypertrophy);
        setHypertrophyListeners();
        
        JLabelSubcategory notes = new JLabelSubcategory("Notas adicionais");
        notes.setName("Notes");
        jLabelSubcategories.add(notes);
        
        setHashCategoryReport();
    }
    
    private void setModelListeners() {
    
        editButtonModel.addActionListener((ActionEvent e) -> {
            
            fillFormModel();
        });
                
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                oval = "XXX";
                qq = "XXX";
                
                if(comboBoxModel.getSelectedIndex() == 0 || comboBoxModel.getSelectedIndex() == 1 || comboBoxModel.getSelectedIndex() == 2 || comboBoxModel.getSelectedIndex() == 3 || comboBoxModel.getSelectedIndex() == 4 || comboBoxModel.getSelectedIndex() == 5) {
                    
                    editButtonModel.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonModel.setEnabled(true);
                    fillFormModel();
                }
            }
        });
    }
    
    private void setHypertrophyListeners() {
            
        comboBoxHypertrophy.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });    
    }
    
    private void fillFormModel() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(oval);
        JTextField field2 = new JTextField(10);
        field2.setText(qq);

        Object[] input = new Object[4];
        input[0] = "Medida(mm):";
        input[1] = field1;
        input[2] = "Qp/Qs:";
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

            oval = field1.getText();
            qq = field2.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Sem fluxo transeptal ao Doppler. ");
        hashCategoryReport.put("Membrana aneurismática", "Membrana da fossa oval aneurismática, sem fluxo transeptal ao Doppler. ");
        hashCategoryReport.put("Membrana redundante", "Membrana da fossa oval redundante, sem fluxo transeptal ao Doppler. ");
        hashCategoryReport.put("FOP", "Presença de fluxo transeptal do átrio esquerdo para o direito em topografia anterossuperior. Achado sugestivo de forame oval patente. ");
        hashCategoryReport.put("FOP + membrana aneurismática", "Membrana da fossa oval aneurismática, com fluxo transeptal do átrio esquerdo para o direito em topografia anterossuperior. Achado sugestivo de forame oval patente. ");
        hashCategoryReport.put("<html>CIA OS - <b>DEFINIR</b></html>", "Presença de defeito da membrana da fossa oval medindo " + oval + " mm, com fluxo transeptal do átrio esquerdo para o direito. Achado compatível com Comunicação interatrial do tipo ostium secundum. Qp/Qs estimado em " + qq + " (sugestivo de repercussão se > 1,5). ");
        hashCategoryReport.put("Infiltração lipomatosa", "Infiltração lipomatosa do septo interatrial. ");
        hashCategoryReport.put("Hipertrofia lipomatosa", "Hipertrofia lipomatosa do septo interatrial. ");
    }      
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxModel.setSelectedIndex(1);
    }
}
