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
public final class CategoryInitialInfo extends CategoryComponent {
    
    private String afterOp = "XXX";
    private final JComboBoxSubcategory comboBoxRate;
    private final JComboBoxSubcategory comboBoxAcoustic;
    private final JComboBoxSubcategory comboBoxPosOp;
    private final JEditButton editButtonPosOp;
    
    public CategoryInitialInfo() {
    
        jLabelCategory = new JLabelCategory("Informações iniciais");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Ritmo")); 
        comboBoxRate = new JComboBoxSubcategory(new String []{"", "Regular", "Irregular", "Extrassístoles"});
        jComboBoxSubcategories.add(comboBoxRate);
        
        jLabelSubcategories.add(new JLabelSubcategory("Janela acústica")); 
        comboBoxAcoustic = new JComboBoxSubcategory(new String []{"", "Limitada", "Limitada - Prótese mamária", "Exame com imagem regular", "À beira do leito", "À beira do leito - Limitada"});
        jComboBoxSubcategories.add(comboBoxAcoustic);
        
        jLabelSubcategories.add(new JLabelSubcategory("Pós-operatório"));
        comboBoxPosOp = new JComboBoxSubcategory(new String []{"", "<html>Recente - <b>DEFINIR</b></html>", "<html>Tardio - <b>DEFINIR</b></html>"});
        comboBoxPosOp.setName("posOp");
        jComboBoxSubcategories.add(comboBoxPosOp);
        editButtonPosOp = new JEditButton();
        editButtonPosOp.setName("posOp");
        arrayEditButton.add(editButtonPosOp);
        
        setHashCategoryReport(); 
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
        
        editButtonPosOp.addActionListener((ActionEvent e) -> {
            
            fillFormPosOp();
        });
                
        comboBoxPosOp.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                afterOp = "XXX";
                
                if(comboBoxPosOp.getSelectedIndex() == 0) {
                    
                    editButtonPosOp.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonPosOp.setEnabled(true);
                    fillFormPosOp();
                }
            }
        });
      
        comboBoxRate.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxAcoustic.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
    }
    
    private void fillFormPosOp() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(afterOp);
        
        Object[] input = new Object[2];

        if(comboBoxPosOp.getSelectedIndex() == 1) {

            input[0] = "Pós-operatório recente de:";
            input[1] = field1;
        } else if (comboBoxPosOp.getSelectedIndex() == 2){

            input[0] = "Pós-operatório tardio de:";
            input[1] = field1;
        }
        
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

            afterOp = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Regular", "Paciente em ritmo regular. ");
        hashCategoryReport.put("Irregular", "Paciente em ritmo irregular. ");
        hashCategoryReport.put("Extrassístoles", "Paciente apresentando extrassístoles durante o exame. ");
        hashCategoryReport.put("Limitada", "Janela acústica limitada. ");
        hashCategoryReport.put("Limitada - Prótese mamária", "Janela acústica limitada (prótese mamária). ");
        hashCategoryReport.put("Exame com imagem regular", "Exame com regular qualidade de imagem. ");
        hashCategoryReport.put("À beira do leito", "Exame realizado à beira do leito. ");
        hashCategoryReport.put("À beira do leito - Limitada", "Exame realizado à beira do leito com janela acústica limitada. ");
        hashCategoryReport.put("<html>Recente - <b>DEFINIR</b></html>", "Pós-operatório recente de " + afterOp + ". ");
        hashCategoryReport.put("<html>Tardio - <b>DEFINIR</b></html>", "Pós-operatório tardio de " + afterOp + ". ");
    }

    @Override
    public void setNormalComboBoxes() {
        
        editButtonPosOp.setEnabled(false);
        comboBoxRate.setSelectedIndex(1);
    }
}
