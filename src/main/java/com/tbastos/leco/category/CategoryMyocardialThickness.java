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
public final class CategoryMyocardialThickness extends CategoryComponent {
 
    private String relativeThickness = "XXX";
    private String mass = "XXX";
    private String myocardialThickness = "XXX";
    private final JComboBoxSubcategory comboBoxSize;
    private final JComboBoxSubcategory comboBoxMassEsp;
    private final JComboBoxSubcategory comboBoxHypertrophy;
    private final JComboBoxSubcategory comboBoxDisease;
    private final JComboBoxSubcategory comboBoxInterventricularSeptum;
    private final JEditButton editButtonMassEsp;
    private final JEditButton editButtonDisease;
    
    public CategoryMyocardialThickness() {
      
        jLabelCategory = new JLabelCategory("Espessura miocárdica");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Tamanho")); 
        comboBoxSize = new JComboBoxSubcategory(new String[]{"", "Normal", "Discreto", "Moderado", "Importante"});
        jComboBoxSubcategories.add(comboBoxSize);
        
        jLabelSubcategories.add(new JLabelSubcategory("Massa e espessura relativa")); 
        comboBoxMassEsp = new JComboBoxSubcategory(new String[]{"", "<html>Massa e espessura - <b>DEFINIR</b></html>"});
        comboBoxMassEsp.setName("MassEsp");
        jComboBoxSubcategories.add(comboBoxMassEsp);
        editButtonMassEsp = new JEditButton();
        editButtonMassEsp.setName("MassEsp");
        arrayEditButton.add(editButtonMassEsp);
        
        jLabelSubcategories.add(new JLabelSubcategory("Hipertrofia")); 
        comboBoxHypertrophy = new JComboBoxSubcategory(new String[]{"", "Concêntrica", "Excêntrica", "Remodelamento concêntrico"});
        jComboBoxSubcategories.add(comboBoxHypertrophy);
        
        jLabelSubcategories.add(new JLabelSubcategory("Septo sigmoide")); 
        comboBoxInterventricularSeptum = new JComboBoxSubcategory(new String[]{"", "Sim"});
        jComboBoxSubcategories.add(comboBoxInterventricularSeptum);
        
        jLabelSubcategories.add(new JLabelSubcategory("Doenças miocárdicas")); 
        comboBoxDisease = new JComboBoxSubcategory(new String[]{"", "<html>Cardiomiopatia hipertrófica - <b>DEFINIR</b></html>", "Cardiomiopatia com trabeculação excessiva", "<html>Amiloidose - <b>DEFINIR</b></html>"});
        comboBoxDisease.setName("Disease");
        jComboBoxSubcategories.add(comboBoxDisease);
        editButtonDisease = new JEditButton();
        editButtonDisease.setName("Disease");
        arrayEditButton.add(editButtonDisease);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
        
        editButtonMassEsp.addActionListener((ActionEvent e) -> {
            
            fillFormMassEsp();
        });
        
        comboBoxMassEsp.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                relativeThickness = "XXX";
                mass = "XXX";
                
                if(comboBoxMassEsp.getSelectedIndex() == 0) {
                    
                    editButtonMassEsp.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonMassEsp.setEnabled(true);
                    fillFormMassEsp();
                }
            }
        });
        
        editButtonDisease.addActionListener((ActionEvent e) -> {
            
            fillFormDisease();
        });
                
        comboBoxDisease.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                myocardialThickness = "XXX";
                
                if(comboBoxDisease.getSelectedIndex() == 0 || comboBoxDisease.getSelectedIndex() == 2) {
                    
                    editButtonDisease.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonDisease.setEnabled(true);
                    fillFormDisease();
                }
            }
        });
        
                        
        comboBoxSize.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxInterventricularSeptum.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxHypertrophy.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
    }
    
    private void fillFormMassEsp() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(relativeThickness);
        JTextField field2 = new JTextField(10);
        field2.setText(mass);

        Object[] input = new Object[4];
        input[0] = "Espessura relativa:";
        input[1] = field1;
        input[2] = "Índice de massa(g/m²):";
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

            relativeThickness = field1.getText();
            mass = field2.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormDisease() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(myocardialThickness);

        Object[] input = new Object[2];
        
        if(comboBoxDisease.getSelectedIndex() == 3) {
        
            input[0] = "Espessura miocárdica do ventrículo direito(mm):";
            input[1] = field1;
        } else if(comboBoxDisease.getSelectedIndex() == 1) {
        
            input[0] = "Relação septo/parede posterior:";
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

            myocardialThickness = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Com tamanho normal. ");
        hashCategoryReport.put("Discreto", "Com aumento discreto. ");
        hashCategoryReport.put("Moderado", "Com aumento moderado. ");
        hashCategoryReport.put("Importante", "Com aumento importante. ");
        hashCategoryReport.put("Sim", "Septo interventricular com aspecto sigmoide. ");
        hashCategoryReport.put("<html>Massa e espessura - <b>DEFINIR</b></html>", "Espessura relativa: " + relativeThickness + " (VR < 0,42). Índice de massa: " + mass + " g/m² (VR \u2264 115 g/m² para homens e \u2264 95 g/m² para mulheres). ");
        hashCategoryReport.put("Concêntrica", "Hipertrofia concêntrica do ventrículo esquerdo. ");
        hashCategoryReport.put("Excêntrica", "Hipertrofia excêntrica do ventrículo esquerdo. ");
        hashCategoryReport.put("Remodelamento concêntrico", "Remodelamento concêntrico do ventrículo esquerdo. ");
        hashCategoryReport.put("<html>Cardiomiopatia hipertrófica - <b>DEFINIR</b></html>", "Aumento da espessura miocárdica com relação septo/parede posterior estimada em " + myocardialThickness + " (VR < 1,3 ou < 1,5 em pacientes hipertensos). Achado sugestivo de Cardiomiopatia Hipertrófica septal assimétrica. ");
        hashCategoryReport.put("Cardiomiopatia com trabeculação excessiva", "Aumento da espessura miocárdica associada a trabeculação excessiva do ventrículo esquerdo, principalmente em seus segmentos médio-apicais. Critérios de Jenni / Stollberger positivos para Cardiomiopatia com trabeculação excessiva (Cardiomiopatia não compactada). Observação: outras condições clínicas podem estar associadas a aumento da trabeculação do ventrículo esquerdo (ex: sobrecarga de volume); correlacionar caso com história clínica e outros métodos de imagem. ");
        hashCategoryReport.put("<html>Amiloidose - <b>DEFINIR</b></html>", "Aumento da espessura miocárdica do ventrículo esquerdo e do ventrículo direito (" + myocardialThickness + " mm), com aumento de sua ecogenicidade e “granular sparkling”. Achados podem corresponder a doença de depósito miocárdio (amiloidose cardíaca?). ");
    }        
    
    @Override
    public void setNormalComboBoxes() {
        
        editButtonMassEsp.setEnabled(false);
        editButtonDisease.setEnabled(false);
        comboBoxSize.setSelectedIndex(1);
    }
}
