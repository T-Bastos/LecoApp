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
public final class CategoryPulmonaryValve extends CategoryComponent {

    private String thickening = "XXX";
    private String mobility = "XXX";
    private String calcification = "XXX";
    private String reflux = "XXX";
    private String midGradient = "XXX";
    private String maxGradient = "XXX";
    private String valveArea = "XXX";
    private final JComboBoxSubcategory comboBoxModel;
    private final JComboBoxSubcategory comboBoxThickening;
    private final JComboBoxSubcategory comboBoxMobility;
    private final JComboBoxSubcategory comboBoxReflux;
    private final JComboBoxSubcategory comboBoxCalcification;
    private final JComboBoxSubcategory comboBoxMaxGradient;
    private final JComboBoxSubcategory comboBoxMidGradient;
    private final JComboBoxSubcategory comboBoxValveArea;
    private final JEditButton editButtonMaxGradient;
    private final JEditButton editButtonMidGradient;
    private final JEditButton editButtonValveArea;
    
    public CategoryPulmonaryValve() {
        
        jLabelCategory = new JLabelCategory("Valva pulmonar");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo")); 
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Valva nativa habitual", "Degenerativa", "Prótese biológica - Pulmonar", "Prótese mecânica - Pulmonar"});
        jComboBoxSubcategories.add(comboBoxModel);
        
        jLabelSubcategories.add(new JLabelSubcategory("Espessamento")); 
        comboBoxThickening = new JComboBoxSubcategory(new String[]{"", "Ecotextura normal", "Espessamento discreto", "Espessamento moderado", "Espessamento importante"});
        comboBoxThickening.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxThickening);
        
        jLabelSubcategories.add(new JLabelSubcategory("Calcificação"));
        comboBoxCalcification = new JComboBoxSubcategory(new String[]{"", "Mínima", "Discreta", "Moderada", "Importante"});
        comboBoxCalcification.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxCalcification);
        
        jLabelSubcategories.add(new JLabelSubcategory("Abertura / Mobilidade prótese")); 
        comboBoxMobility = new JComboBoxSubcategory(new String[]{"", "Preservada", "Discreta", "Moderada", "Importante"});
        comboBoxMobility.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxMobility);
        
        jLabelSubcategories.add(new JLabelSubcategory("Refluxo")); 
        comboBoxReflux = new JComboBoxSubcategory(new String[]{"", "Ausente", "Discreto", "Moderado", "Importante"});
        comboBoxReflux.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxReflux);
        
        jLabelSubcategories.add(new JLabelSubcategory("Gradiente máximo")); 
        comboBoxMaxGradient = new JComboBoxSubcategory(new String[]{"", "<html>Gradiente máximo - <b>DEFINIR</b></html>"});
        comboBoxMaxGradient.setName("MaxGradient");
        jComboBoxSubcategories.add(comboBoxMaxGradient);
        editButtonMaxGradient = new JEditButton();
        editButtonMaxGradient.setName("MaxGradient");
        arrayEditButton.add(editButtonMaxGradient);
        
        jLabelSubcategories.add(new JLabelSubcategory("Gradiente médio")); 
        comboBoxMidGradient = new JComboBoxSubcategory(new String[]{"", "<html>Gradiente médio - <b>DEFINIR</b></html>"});
        comboBoxMidGradient.setName("MidGradient");
        jComboBoxSubcategories.add(comboBoxMidGradient);
        editButtonMidGradient = new JEditButton();
        editButtonMidGradient.setName("MidGradient");
        arrayEditButton.add(editButtonMidGradient);
        
        jLabelSubcategories.add(new JLabelSubcategory("Área valvar")); 
        comboBoxValveArea = new JComboBoxSubcategory(new String[]{"", "<html>Equação de continuidade - <b>DEFINIR</b></html>", "<html>Planimetria - <b>DEFINIR</b></html>"});
        comboBoxValveArea.setName("ValveArea");
        jComboBoxSubcategories.add(comboBoxValveArea);
        editButtonValveArea = new JEditButton();
        editButtonValveArea.setName("ValveArea");
        arrayEditButton.add(editButtonValveArea);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
    
        
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                int selectedIndex = comboBoxModel.getSelectedIndex();
                
                if(selectedIndex == 3) {
                    
                    jLabelCategory.setText("Prótese biológica em posição pulmonar");
                } else if(selectedIndex == 4) {
                    
                    jLabelCategory.setText("Prótese mecânica em posição pulmonar");
                } else {
                    
                    jLabelCategory.setText("Valva pulmonar");
                }
                
                if(selectedIndex == 1 || selectedIndex == 3 ||
                        selectedIndex == 4) {
                    
                    comboBoxThickening.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxReflux.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                } else if(selectedIndex == 2) {
                    
                    comboBoxThickening.setEnabled(true);
                    comboBoxCalcification.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxReflux.setEnabled(true);
                }
                
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxThickening.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxThickening.getSelectedIndex() != 0) {
                    
                    thickening = comboBoxThickening.getSelectedItem().toString().toLowerCase();
                } else {
                    
                    thickening = "XXX";
                }
                
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxCalcification.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxCalcification.getSelectedIndex() != 0) {

                    calcification = comboBoxCalcification.getSelectedItem().toString().toLowerCase();
                } else {

                    calcification = "XXX";
                }
                            
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxMobility.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxMobility.getSelectedIndex() != 0) {
                    
                    mobility = comboBoxMobility.getSelectedItem().toString().toLowerCase();
                } else {
                    
                    mobility = "XXX";
                }
                
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxReflux.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxReflux.getSelectedIndex() != 0) {
                    
                    reflux = comboBoxReflux.getSelectedItem().toString().toLowerCase();
                } else {
                    
                    reflux = "XXX";
                }
                
                setHashCategoryReport();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        editButtonMaxGradient.addActionListener((ActionEvent e) -> {
            
            fillFormMaxGradient();
        });
        
        comboBoxMaxGradient.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                maxGradient = "XXX";
                
                if(comboBoxMaxGradient.getSelectedIndex() == 0) {
                    
                    editButtonMaxGradient.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonMaxGradient.setEnabled(true);
                    fillFormMaxGradient();
                }
            }
        });  
        
        editButtonMidGradient.addActionListener((ActionEvent e) -> {
            
            fillFormMidGradient();
        });
        
        comboBoxMidGradient.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxMidGradient.getSelectedIndex() == 0) {
                    
                    midGradient = "XXX";
                    editButtonMidGradient.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    midGradient = "XXX";
                    editButtonMidGradient.setEnabled(true);
                    fillFormMidGradient();
                }
            }
        });  
    
        editButtonValveArea.addActionListener((ActionEvent e) -> {
            
            fillFormValveArea();
        });
        
        comboBoxValveArea.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                valveArea = "XXX";
                
                if(comboBoxValveArea.getSelectedIndex() == 0) {
                    
                    editButtonValveArea.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonValveArea.setEnabled(true);
                    fillFormValveArea();
                }
            }
        });
        
    };
    
    private void fillFormMaxGradient() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(maxGradient);

        Object[] input = new Object[2];
        input[0] = "Gradiente máximo(mmHg):";
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

            maxGradient = field1.getText();                   
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormMidGradient() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(midGradient);

        Object[] input = new Object[2];
        input[0] = "Gradiente médio(mmHg):";
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

            midGradient = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormValveArea() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(valveArea);

        Object[] input = new Object[2];

        if(comboBoxValveArea.getSelectedIndex() == 1) {

            input[0] = "Equação de continuidade - Área valvar(cm2):";
        } else {

            input[0] = "Planimetria - Área valvar(cm2):";
        }

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

            valveArea = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Valva nativa habitual", "Com " + thickening + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Degenerativa", "Com " + thickening + ", calcificação " + calcification + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Prótese biológica - Pulmonar", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Prótese mecânica - Pulmonar", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Ecotextura normal", "");
        hashCategoryReport.put("Espessamento discreto", "");
        hashCategoryReport.put("Espessamento moderado", "");
        hashCategoryReport.put("Espessamento importante", "");
        hashCategoryReport.put("Normal", "");
        hashCategoryReport.put("Discreto", "");
        hashCategoryReport.put("Moderado", "");
        hashCategoryReport.put("Importante", "");
        hashCategoryReport.put("Mínima", "");
        hashCategoryReport.put("Discreta", "");
        hashCategoryReport.put("Moderada", "");
        hashCategoryReport.put("Importante", "");
        hashCategoryReport.put("Preservada", "");
        hashCategoryReport.put("Ausente", "");
        hashCategoryReport.put("<html>Gradiente máximo - <b>DEFINIR</b></html>", "Gradiente máximo: " + maxGradient + " mmHg. ");
        hashCategoryReport.put("<html>Gradiente médio - <b>DEFINIR</b></html>", "Gradiente médio: " + midGradient + " mmHg. ");
        hashCategoryReport.put("<html>Equação de continuidade - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (equação de continuidade). ");
        hashCategoryReport.put("<html>Planimetria - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (planimetria). ");
    }           
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxModel.setSelectedIndex(1);
        comboBoxThickening.setSelectedIndex(1);
        comboBoxMobility.setSelectedIndex(1);
        comboBoxReflux.setSelectedIndex(1);
        editButtonMaxGradient.setEnabled(false);
        editButtonMidGradient.setEnabled(false);
        editButtonValveArea.setEnabled(false);
    }
}
