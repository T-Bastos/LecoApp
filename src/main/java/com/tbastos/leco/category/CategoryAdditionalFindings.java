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
public final class CategoryAdditionalFindings extends CategoryComponent {

    private String localeVegetation = "XXX";
    private String measureVegetation = "XXX";
    private String localeIntracavitaryThrombus = "XXX";
    private String measureIntracavitaryThrombus = "XXX";
    private final JComboBoxSubcategory comboBoxNormal;
    private final JComboBoxSubcategory comboBoxIntracavitaryThrombus;
    private final JComboBoxSubcategory comboBoxVegetation;
    private final JComboBoxSubcategory comboBoxEffusion;
    private final JComboBoxSubcategory comboBoxCatheter;
    private final JComboBoxSubcategory comboBoxPacemaker;
    private final JComboBoxSubcategory comboBoxRac;
    private final JEditButton editButtonIntracavitaryThrombus;
    private final JEditButton editButtonVegetation;
    
    public CategoryAdditionalFindings () {
        
        jLabelCategory = new JLabelCategory("Achados Adicionais");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
         
        jLabelSubcategories.add(new JLabelSubcategory("Normal")); 
        comboBoxNormal = new JComboBoxSubcategory(new String[]{"", "Sim"});
        jComboBoxSubcategories.add(comboBoxNormal);
        
        jLabelSubcategories.add(new JLabelSubcategory("Trombo intracavitário"));
        comboBoxIntracavitaryThrombus = new JComboBoxSubcategory(new String[]{"", "<html>Presença de imagem hipocogênica - <b>DEFINIR</b></html>"});
        comboBoxIntracavitaryThrombus.setName("IntracavitaryThrombus");
        jComboBoxSubcategories.add(comboBoxIntracavitaryThrombus);
        editButtonIntracavitaryThrombus = new JEditButton();
        editButtonIntracavitaryThrombus.setName("IntracavitaryThrombus");
        arrayEditButton.add(editButtonIntracavitaryThrombus);
        
        jLabelSubcategories.add(new JLabelSubcategory("Vegetação")); 
        comboBoxVegetation = new JComboBoxSubcategory(new String[]{"", "<html>Presença de imagem ecogênica heterogênea - <b>DEFINIR</b></html>"});
        comboBoxVegetation.setName("Vegetation");
        jComboBoxSubcategories.add(comboBoxVegetation);
        editButtonVegetation = new JEditButton();
        editButtonVegetation.setName("Vegetation");
        arrayEditButton.add(editButtonVegetation);
        
        jLabelSubcategories.add(new JLabelSubcategory("Derrame pleural")); 
        comboBoxEffusion = new JComboBoxSubcategory(new String[]{"", "Derrame pleural"});
        jComboBoxSubcategories.add(comboBoxEffusion);
        
        jLabelSubcategories.add(new JLabelSubcategory("Cateter")); 
        comboBoxCatheter = new JComboBoxSubcategory(new String[]{"", "Cateter livre no átrio direito", "Cateter livre no ventrículo direito", "Cateter livre na veia cava superior"});
        jComboBoxSubcategories.add(comboBoxCatheter);
        
        jLabelSubcategories.add(new JLabelSubcategory("Marcapasso")); 
        comboBoxPacemaker = new JComboBoxSubcategory(new String[]{"", "Eletrodo de marcapasso"});
        jComboBoxSubcategories.add(comboBoxPacemaker);
        
        jLabelSubcategories.add(new JLabelSubcategory("RAC sign")); 
        comboBoxRac = new JComboBoxSubcategory(new String[]{"", "Presente"});
        jComboBoxSubcategories.add(comboBoxRac);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
        
        editButtonIntracavitaryThrombus.addActionListener((ActionEvent e) -> {
            
            fillFormIntracavitaryThrombus();
        });
                
        comboBoxIntracavitaryThrombus.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                localeIntracavitaryThrombus = "XXX";
                measureIntracavitaryThrombus = "XXX";
                
                if(comboBoxIntracavitaryThrombus.getSelectedIndex() == 0) {
                    
                    editButtonIntracavitaryThrombus.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonIntracavitaryThrombus.setEnabled(true);
                    fillFormIntracavitaryThrombus();
                }
            }
        });
        
        editButtonVegetation.addActionListener((ActionEvent e) -> {
            
            fillFormVegetation();
        });
                
        comboBoxVegetation.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                localeVegetation = "XXX";
                measureVegetation = "XXX";
                
                if(comboBoxVegetation.getSelectedIndex() == 0) {
                    
                    editButtonVegetation.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonVegetation.setEnabled(true);
                    fillFormVegetation();
                }
            }
        });
        
        comboBoxNormal.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxEffusion.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxCatheter.addItemListener((ItemEvent e) -> {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxPacemaker.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxRac.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
    }
    
    private void fillFormIntracavitaryThrombus() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(localeIntracavitaryThrombus);
        JTextField field2 = new JTextField(10);
        field2.setText(measureIntracavitaryThrombus);

        Object[] input = new Object[4];
        input[0] = "Localização:";
        input[1] = field1;
        input[2] = "Medida:";
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

            localeIntracavitaryThrombus = field1.getText();
            measureIntracavitaryThrombus = field2.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    private void fillFormVegetation() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(localeVegetation);
        JTextField field2 = new JTextField(10);
        field2.setText(measureVegetation);

        Object[] input = new Object[4];
        input[0] = "Aderida a:";
        input[1] = field1;
        input[2] = "Medida:";
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

            localeVegetation = field1.getText();
            measureVegetation = field2.getText();    
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Sim", "Ausência de imagens sugestivas de massa, trombo ou vegetação intracardíaca. ");
        hashCategoryReport.put("<html>Presença de imagem hipocogênica - <b>DEFINIR</b></html>", "Presença de imagem hipoecogênica, séssil, localizada " + localeIntracavitaryThrombus + ", medindo " + measureIntracavitaryThrombus + ", sugestiva de trombo intracavitário. ");
        hashCategoryReport.put("<html>Presença de imagem ecogênica heterogênea - <b>DEFINIR</b></html>", "Presença de imagem ecogênica heterogênea, móvel, aderida a " + localeVegetation + ", medindo " + measureVegetation + ", sugestiva de vegetação intracardíaca. ");
        hashCategoryReport.put("Derrame pleural", "Presença de derrame pleural à esquerda. ");
        hashCategoryReport.put("Cateter livre no átrio direito", "Presença de ponta de cateter livre no átrio direito com aspecto habitual. ");
        hashCategoryReport.put("Cateter livre no ventrículo direito", "Presença de ponta de cateter livre no ventrículo direito com aspecto habitual. ");
        hashCategoryReport.put("Cateter livre na veia cava superior", "Presença de ponta de cateter livre na veia cava superior com aspecto habitual. ");
        hashCategoryReport.put("Eletrodo de marcapasso", "Presença de eletrodo de marcapasso em câmaras direitas com ecotextura habitual. ");
        hashCategoryReport.put("Presente", "Observa-se imagem tubular vascular sugestiva de trajeto retroaórtico anômalo da artéria coronária circunflexa (RAC sign). ");
    }      
    
    @Override
    public void setNormalComboBoxes() {
        
        editButtonIntracavitaryThrombus.setEnabled(false);
        editButtonVegetation.setEnabled(false);
        comboBoxNormal.setSelectedIndex(1);
    }
}
