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
public final class CategoryTricuspidValve extends CategoryComponent {
    
    private String thickening = "XXX";
    private String mobility = "XXX";
    private String calcification = "XXX";
    private String reflux = "XXX";
    private String midGradient = "XXX";
    private String pht = "XXX";
    private String valveArea = "XXX";
    private String orifice = "XXX";
    private String disp = "XXX";
    private String indexDoppler = "XXX";
    private String periprostheticReflux = "XXX";
    private final JComboBoxSubcategory comboBoxModel;
    private final JComboBoxSubcategory comboBoxThickening;
    private final JComboBoxSubcategory comboBoxCalcification;
    private final JComboBoxSubcategory comboBoxMobility;
    private final JComboBoxSubcategory comboBoxReflux;
    private final JComboBoxSubcategory comboMidBoxGradient;
    private final JComboBoxSubcategory comboBoxPht;
    private final JComboBoxSubcategory comboBoxValveArea;
    private final JComboBoxSubcategory comboBoxOrifice;
    private final JComboBoxSubcategory comboBoxDisp;
    private final JComboBoxSubcategory comboBoxIndexDoppler;
    private final JComboBoxSubcategory comboBoxPeriprostheticReflux;
    private final JEditButton editMidButtonGradient;
    private final JEditButton editButtonPht;
    private final JEditButton editButtonValveArea;
    private final JEditButton editButtonOrifice;
    private final JEditButton editButtonDisp;
    private final JEditButton editButtonIndexDoppler;
    private final JEditButton editButtonPeriprostheticReflux;
    
    public CategoryTricuspidValve() {
        
        jLabelCategory = new JLabelCategory("Valva tricúspide");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo")); 
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Valva nativa habitual", "Degenerativa", "Anomalia de Ebstein", "Síndrome carcinoide", "Prótese biológica - Tricúspide", "Prótese mecânica - Tricúspide"});
        jComboBoxSubcategories.add(comboBoxModel);
        
        jLabelSubcategories.add(new JLabelSubcategory("Espessamento")); 
        comboBoxThickening = new JComboBoxSubcategory(new String[]{"", "Ecotextura normal", "Espessamento discreto", "Espessamento moderado", "Espessamento importante"});
        jComboBoxSubcategories.add(comboBoxThickening);
        
        jLabelSubcategories.add(new JLabelSubcategory("Ebstein - medida"));
        comboBoxDisp = new JComboBoxSubcategory(new String[]{"", "<html>Deslocamento - <b>DEFINIR</b></html>"});
        comboBoxDisp.setName("Disp");
        comboBoxDisp.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxDisp);
        editButtonDisp = new JEditButton();
        editButtonDisp.setName("Disp");
        arrayEditButton.add(editButtonDisp);
        
        jLabelSubcategories.add(new JLabelSubcategory("Calcificação"));
        comboBoxCalcification = new JComboBoxSubcategory(new String[]{"", "Mínima", "Discreta", "Moderada", "Importante"});
        comboBoxCalcification.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxCalcification);
        
        jLabelSubcategories.add(new JLabelSubcategory("Abertura / Mobilidade prótese")); 
        comboBoxMobility = new JComboBoxSubcategory(new String[]{"", "Preservada", "Reduzida em grau discreto", "Reduzida em grau moderado", "Reduzida em grau importante", "Reduzida em grau não significativo", "Reduzida em grau significativo"});
        comboBoxMobility.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxMobility);
        
        jLabelSubcategories.add(new JLabelSubcategory("Refluxo")); 
        comboBoxReflux = new JComboBoxSubcategory(new String[]{"", "Ausente", "Discreto", "Moderado", "Importante"});
        jComboBoxSubcategories.add(comboBoxReflux);
        
        jLabelSubcategories.add(new JLabelSubcategory("Refluxo periprotético")); 
        comboBoxPeriprostheticReflux = new JComboBoxSubcategory(new String[]{"", "Leak discreto", "Leak moderado", "Leak importante", "<html>Leak discreto - <b>DEFINIR</b></html>", "<html>Leak moderado - <b>DEFINIR</b></html>", "<html>Leak importante - <b>DEFINIR</b></html>"});
        comboBoxPeriprostheticReflux.setName("PeriprostheticReflux");
        comboBoxPeriprostheticReflux.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxPeriprostheticReflux);   
        editButtonPeriprostheticReflux = new JEditButton();
        editButtonPeriprostheticReflux.setName("PeriprostheticReflux");
        arrayEditButton.add(editButtonPeriprostheticReflux);
        
        jLabelSubcategories.add(new JLabelSubcategory("Orifício efetivo regurgitante")); 
        comboBoxOrifice = new JComboBoxSubcategory(new String[]{"", "<html>Orifício - <b>DEFINIR</b></html>"});
        comboBoxOrifice.setName("Orifice");
        jComboBoxSubcategories.add(comboBoxOrifice);
        editButtonOrifice = new JEditButton();
        editButtonOrifice.setName("Orifice");
        arrayEditButton.add(editButtonOrifice);
        
        jLabelSubcategories.add(new JLabelSubcategory("Gradiente médio")); 
        comboMidBoxGradient = new JComboBoxSubcategory(new String[]{"", "<html>Gradiente médio - <b>DEFINIR</b></html>"});
        comboMidBoxGradient.setName("Gradient");
        jComboBoxSubcategories.add(comboMidBoxGradient);
        editMidButtonGradient = new JEditButton();
        editMidButtonGradient.setName("Gradient");
        arrayEditButton.add(editMidButtonGradient);
        
        jLabelSubcategories.add(new JLabelSubcategory("PHT")); 
        comboBoxPht = new JComboBoxSubcategory(new String[]{"", "<html>PHT - <b>DEFINIR</b></html>"});
        comboBoxPht.setName("Pht");
        jComboBoxSubcategories.add(comboBoxPht);
        editButtonPht = new JEditButton();
        editButtonPht.setName("Pht");
        arrayEditButton.add(editButtonPht);
        
        jLabelSubcategories.add(new JLabelSubcategory("Índice Doppler")); 
        comboBoxIndexDoppler = new JComboBoxSubcategory(new String[]{"", "<html>Índice Doppler - <b>DEFINIR</b></html>"});
        comboBoxIndexDoppler.setName("IndexDoppler");
        jComboBoxSubcategories.add(comboBoxIndexDoppler);
        editButtonIndexDoppler = new JEditButton();
        editButtonIndexDoppler.setName("IndexDoppler");
        arrayEditButton.add(editButtonIndexDoppler);
        
        jLabelSubcategories.add(new JLabelSubcategory("Área valvar")); 
        comboBoxValveArea = new JComboBoxSubcategory(new String[]{"", "<html>Equação de continuidade - <b>DEFINIR</b></html>", "<html>Planimetria - <b>DEFINIR</b></html>"});
        comboBoxValveArea.setName("ValveArea");
        jComboBoxSubcategories.add(comboBoxValveArea);
        editButtonValveArea = new JEditButton();
        editButtonValveArea.setName("ValveArea");
        arrayEditButton.add(editButtonValveArea);
        
        JLabelSubcategory notes = new JLabelSubcategory("Notas adicionais");
        notes.setName("Notes");
        jLabelSubcategories.add(notes);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    protected void setCategoryListeners() {
         
        editButtonPeriprostheticReflux.addActionListener((ActionEvent e) -> {
            
            fillFormPeriprostheticReflux();
        });
        
        comboBoxPeriprostheticReflux.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                if(comboBoxPeriprostheticReflux.getSelectedIndex() == 0 || comboBoxPeriprostheticReflux.getSelectedIndex() == 1
                        || comboBoxPeriprostheticReflux.getSelectedIndex() == 2 || comboBoxPeriprostheticReflux.getSelectedIndex() == 3) {
                    
                    periprostheticReflux = "XXX";
                    editButtonPeriprostheticReflux.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    periprostheticReflux = "XXX";
                    editButtonPeriprostheticReflux.setEnabled(true);
                    fillFormPeriprostheticReflux();
                }
            }
        });
        
        editButtonIndexDoppler.addActionListener((ActionEvent e) -> {
            
            fillFormIndexDoppler();
        });
        
        editButtonDisp.addActionListener((ActionEvent e) -> {
            
            fillFormDisp();
        });
        
        comboBoxDisp.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                disp = "XXX";
                
                if(comboBoxDisp.getSelectedIndex() == 0) {
                    
                    editButtonDisp.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonDisp.setEnabled(true);
                    fillFormDisp();
                }
            }
        });  
        
        comboBoxIndexDoppler.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                indexDoppler = "XXX";
                
                if(comboBoxIndexDoppler.getSelectedIndex() == 0) {
                    
                    editButtonIndexDoppler.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonIndexDoppler.setEnabled(true);
                    fillFormIndexDoppler();
                }
            }
        });
        
        editMidButtonGradient.addActionListener((ActionEvent e) -> {
            
            fillFormMidGradient();
        });
        
        comboMidBoxGradient.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                midGradient = "XXX";
                
                if(comboMidBoxGradient.getSelectedIndex() == 0) {
                    
                    editMidButtonGradient.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editMidButtonGradient.setEnabled(true);
                    fillFormMidGradient();
                }
            }
        });  
        
        editButtonPht.addActionListener((ActionEvent e) -> {
            
            fillFormPht();
        });
        
        comboBoxPht.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                pht = "XXX";
                
                if(comboBoxPht.getSelectedIndex() == 0) {
                    
                    editButtonPht.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonPht.setEnabled(true);
                    fillFormPht();
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
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonValveArea.setEnabled(true);
                    fillFormValveArea();
                }
            }
        });
        
        editButtonOrifice.addActionListener((ActionEvent e) -> {
            
            fillFormOrifice();
        });
        
        comboBoxOrifice.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                orifice = "XXX";
                
                if(comboBoxOrifice.getSelectedIndex() == 0) {
                    
                    editButtonOrifice.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonOrifice.setEnabled(true);
                    fillFormOrifice();
                }
            }
        });
        
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                int selectedIndex = comboBoxModel.getSelectedIndex();
                
                if(selectedIndex == 5) {
                    
                    jLabelCategory.setText("<html>Prótese biológica <br>em posição tricúspide</br></html>");
                    comboBoxReflux.removeAllItems();
                    comboBoxReflux.addItem("");
                    comboBoxReflux.addItem("Protético ausente");
                    comboBoxReflux.addItem("Protético mínimo(funcional)");
                    comboBoxReflux.addItem("Protético discreto");
                    comboBoxReflux.addItem("Protético moderado");
                    comboBoxReflux.addItem("Protético importante");
                } else if(selectedIndex == 6) {
                    
                    jLabelCategory.setText("<html>Prótese mecânica <br>em posição tricúspide</br></html>");
                    comboBoxReflux.removeAllItems();
                    comboBoxReflux.addItem("");
                    comboBoxReflux.addItem("Protético ausente");
                    comboBoxReflux.addItem("Protético mínimo(funcional)");
                    comboBoxReflux.addItem("Protético discreto");
                    comboBoxReflux.addItem("Protético moderado");
                    comboBoxReflux.addItem("Protético importante");
                } else {
                    
                    jLabelCategory.setText("Valva tricúspide");
                    if(comboBoxReflux.getItemCount() > 5) {
                        
                        comboBoxReflux.removeAllItems();
                        comboBoxReflux.addItem("");
                        comboBoxReflux.addItem("Ausente");
                        comboBoxReflux.addItem("Discreto");
                        comboBoxReflux.addItem("Moderado");
                        comboBoxReflux.addItem("Importante");
                    }
                }
                
                if(selectedIndex == 5 || selectedIndex == 6) {
                
                    comboBoxPeriprostheticReflux.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxDisp.setEnabled(false);
                    comboBoxDisp.setSelectedIndex(0);
                } else if(selectedIndex == 1 || selectedIndex == 4) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxDisp.setEnabled(false);
                    comboBoxDisp.setSelectedIndex(0);
                } else if(selectedIndex == 2) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxDisp.setEnabled(false);
                    comboBoxDisp.setSelectedIndex(0);
                } else if(selectedIndex == 3) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(false);
                    comboBoxMobility.setSelectedIndex(0);
                    comboBoxDisp.setEnabled(true);
                } else if(selectedIndex == 0) {
                
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(false);
                    comboBoxMobility.setSelectedIndex(0);
                    comboBoxDisp.setEnabled(false);
                    comboBoxDisp.setSelectedIndex(0);
                }
                
                setHashCategoryReport();
                Report.getReport().updateReportPane();
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
                Report.getReport().updateReportPane();
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
                Report.getReport().updateReportPane();
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
                Report.getReport().updateReportPane();
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
                Report.getReport().updateReportPane();
            }
        });
    }
    
    private void fillFormPeriprostheticReflux() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(periprostheticReflux);

        Object[] input = new Object[2];
        input[0] = "Topografia:";
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

            periprostheticReflux = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    private void fillFormDisp() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(disp);

        Object[] input = new Object[2];
        input[0] = "Deslocamento apical da cúspide septal(mm):";
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

            disp = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
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
        Report.getReport().updateReportPane();
    }
    
    private void fillFormPht() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(pht);

        Object[] input = new Object[2];
        input[0] = "Tempo de meia pressão estimado(ms):";
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

            pht = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    private void fillFormIndexDoppler() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(indexDoppler);

        Object[] input = new Object[2];
        input[0] = "Índice Doppler:";
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

            indexDoppler = field1.getText();
        }  
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
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
        Report.getReport().updateReportPane();
    }
    
    private void fillFormOrifice() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(orifice);

        Object[] input = new Object[2];
        input[0] = "Orifício efetivo regurgitante estimado(cm²):";
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

            orifice = field1.getText();
        }  
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
     
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Valva nativa habitual", "Com " + thickening + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Degenerativa", "Com " + thickening + ", calcificação " + calcification + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Anomalia de Ebstein", "Com " + thickening + " e deslocamento apical de cúspide septal da valva tricúspide de aproximadamente " + disp + " mm, associada a cúspide anterior alongada, gerando ocupação de parte do ventrículo direito pelo átrio direito. Achado compatível com Anomalia de Ebstein. Abertura valvar preservada e com refluxo de grau " + reflux + " ao Doppler. ");
        hashCategoryReport.put("Síndrome carcinoide", "Com " + thickening + ", abertura " + mobility + " e redução sistodiastólica da mobilidade de duas cúspides que ocasiona refluxo de grau " + reflux + " ao Doppler. Achados sugestivos de Síndrome Carcinoide. ");
        hashCategoryReport.put("Prótese biológica - Tricúspide", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Prótese mecânica - Tricúspide", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ".  ");
        hashCategoryReport.put("Ecotextura normal", "");
        hashCategoryReport.put("Espessamento discreto", "");
        hashCategoryReport.put("Espessamento moderado", "");
        hashCategoryReport.put("Espessamento importante", "");
        hashCategoryReport.put("Normal", "");
        hashCategoryReport.put("Importante", "");
        hashCategoryReport.put("Mínima", "");
        hashCategoryReport.put("Discreta", "");
        hashCategoryReport.put("Moderada", "");
        hashCategoryReport.put("Preservada", "");
        hashCategoryReport.put("Ausente", "");
        hashCategoryReport.put("Discreto", "");
        hashCategoryReport.put("Moderado", "");
        hashCategoryReport.put("Importante", "");
        hashCategoryReport.put("Protético ausente", "");
        hashCategoryReport.put("Protético mínimo(funcional)", "");
        hashCategoryReport.put("Protético discreto", "");
        hashCategoryReport.put("Protético moderado", "");
        hashCategoryReport.put("Protético importante", "");
        hashCategoryReport.put("Reduzida em grau discreto", "");
        hashCategoryReport.put("Reduzida em grau moderado", "");
        hashCategoryReport.put("Reduzida em grau importante", "");
        hashCategoryReport.put("Reduzida em grau não significativo", "");
        hashCategoryReport.put("Reduzida em grau significativo", "");
        hashCategoryReport.put("<html>Deslocamento - <b>DEFINIR</b></html>", "");
        hashCategoryReport.put("<html>Gradiente médio - <b>DEFINIR</b></html>", "Gradiente médio: " + midGradient + " mmHg. ");
        hashCategoryReport.put("<html>PHT - <b>DEFINIR</b></html>", "Tempo de meia pressão (PHT) estimado em " + pht + " ms. ");
        hashCategoryReport.put("<html>Equação de continuidade - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (equação de continuidade). ");
        hashCategoryReport.put("<html>Planimetria - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (planimetria). ");
        hashCategoryReport.put("<html>Orifício - <b>DEFINIR</b></html>", "Orifício efetivo regurgitante estimado em " + orifice + " cm². ");
        hashCategoryReport.put("<html>Índice Doppler - <b>DEFINIR</b></html>", "Índice Doppler: " + indexDoppler + " (sugestivo de obstrução significativa se < 2,0). ");
        hashCategoryReport.put("Leak discreto", "Presença de refluxo periprotético (leak) de grau discreto. ");
        hashCategoryReport.put("Leak moderado", "Presença de refluxo periprotético (leak) de grau moderado. ");
        hashCategoryReport.put("Leak importante", "Presença de refluxo periprotético (leak) de grau importante. ");
        hashCategoryReport.put("<html>Leak discreto - <b>DEFINIR</b></html>", "Presença de refluxo periprotético (leak) de grau discreto em topografia " + periprostheticReflux + ". ");
        hashCategoryReport.put("<html>Leak moderado - <b>DEFINIR</b></html>", "Presença de refluxo periprotético (leak) de grau moderado em topografia " + periprostheticReflux + ". ");
        hashCategoryReport.put("<html>Leak importante - <b>DEFINIR</b></html>", "Presença de refluxo periprotético (leak) de grau importante em topografia " + periprostheticReflux + ". ");
    }      
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxModel.setSelectedIndex(1);
        comboBoxThickening.setSelectedIndex(1);
        comboBoxMobility.setSelectedIndex(1);
        comboBoxReflux.setSelectedIndex(1);
    }
}
