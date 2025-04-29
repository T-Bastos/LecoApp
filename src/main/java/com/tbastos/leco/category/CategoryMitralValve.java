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
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Tibério
 */
public final class CategoryMitralValve extends CategoryComponent {
    
    private String thickening = "XXX";
    private String mobility = "XXX";
    private String calcification = "XXX";
    private String reflux = "XXX";
    private String gradient = "XXX";
    private String pht = "XXX";
    private String valveArea = "XXX";
    private String orifice = "XXX";
    private String wilkins = "XXX";
    private String thickeningWilkins = "XXX";
    private String mobilityWilkins = "XXX";
    private String calcificationWilkins = "XXX";
    private String subvalveWilkins = "XXX";
    private String indexDoppler = "XXX";
    private String periprostheticReflux = "XXX";
    private final JComboBoxSubcategory comboBoxModel;
    private final JComboBoxSubcategory comboBoxThickening;
    private final JComboBoxSubcategory comboBoxCalcification;
    private final JComboBoxSubcategory comboBoxMobility;
    private final JComboBoxSubcategory comboBoxReflux;
    private final JComboBoxSubcategory comboBoxMitralRing;
    private final JComboBoxSubcategory comboBoxGradient;
    private final JComboBoxSubcategory comboBoxPht;
    private final JComboBoxSubcategory comboBoxValveArea;
    private final JComboBoxSubcategory comboBoxOrifice;
    private final JComboBoxSubcategory comboBoxWilkins;
    private final JComboBoxSubcategory comboBoxIndexDoppler;
    private final JComboBoxSubcategory comboBoxPeriprostheticReflux;
    private final JEditButton editButtonGradient;
    private final JEditButton editButtonPht;
    private final JEditButton editButtonValveArea;
    private final JEditButton editButtonOrifice;
    private final JEditButton editButtonWilkins;
    private final JEditButton editButtonIndexDoppler;
    private final JEditButton editButtonPeriprostheticReflux;
    
    public CategoryMitralValve() {
          
        jLabelCategory = new JLabelCategory("Valva mitral");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo")); 
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Valva nativa habitual", "Reumática", "Degenerativa", "Prolapso - Cúspide anterior", "Prolapso - Cúspide posterior", "Prolapso - Duas cúspides", "Corda rota - Cúspide anterior", "Corda rota - Cúspide posterior", "Prótese biológica - Mitral", "Prótese mecânica - Mitral", "Tracionamento - Cúspide anterior", "Tracionamento - Duas cúspides"});
        jComboBoxSubcategories.add(comboBoxModel);
        
        jLabelSubcategories.add(new JLabelSubcategory("Espessamento")); 
        comboBoxThickening = new JComboBoxSubcategory(new String[]{"", "Ecotextura normal", "Espessamento discreto", "Espessamento moderado", "Espessamento importante"});
        jComboBoxSubcategories.add(comboBoxThickening);
        
        jLabelSubcategories.add(new JLabelSubcategory("Calcificação")); 
        comboBoxCalcification = new JComboBoxSubcategory(new String[]{"", "Mínima", "Discreta", "Moderada", "Importante"});
        comboBoxCalcification.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxCalcification);
        
        jLabelSubcategories.add(new JLabelSubcategory("Abertura / Mobilidade prótese")); 
        comboBoxMobility = new JComboBoxSubcategory(new String[]{"", "Preservada", "Reduzida em grau discreto", "Reduzida em grau moderado", "Reduzida em grau importante", "Reduzida em grau não significativo", "Reduzida em grau significativo"});
        comboBoxMobility.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxMobility);
        
        jLabelSubcategories.add(new JLabelSubcategory("Refluxo")); 
        comboBoxReflux = new JComboBoxSubcategory(new String[]{"", "Ausente", "Mínimo", "Discreto", "Moderado", "Importante"});
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
        
        jLabelSubcategories.add(new JLabelSubcategory("Escore de Wilkins")); 
        comboBoxWilkins = new JComboBoxSubcategory(new String[]{"", "<html>Escore de Wilkins - <b>DEFINIR</b></html>"});
        comboBoxWilkins.setName("Wilkins");
        comboBoxWilkins.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxWilkins);
        editButtonWilkins = new JEditButton();
        editButtonWilkins.setName("Wilkins");
        arrayEditButton.add(editButtonWilkins);
        
        jLabelSubcategories.add(new JLabelSubcategory("Calcificação do anel mitral")); 
        comboBoxMitralRing = new JComboBoxSubcategory(new String[]{"", "Calcificação discreta do anel mitral", "Calcificação moderada do anel mitral", "Calcificação importante do anel mitral"});
        jComboBoxSubcategories.add(comboBoxMitralRing);
        
        jLabelSubcategories.add(new JLabelSubcategory("Gradiente médio")); 
        comboBoxGradient = new JComboBoxSubcategory(new String[]{"", "<html>Gradiente médio - <b>DEFINIR</b></html>"});
        comboBoxGradient.setName("Gradient");
        jComboBoxSubcategories.add(comboBoxGradient);
        editButtonGradient = new JEditButton();
        editButtonGradient.setName("Gradient");
        arrayEditButton.add(editButtonGradient);
        
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
        
        editButtonWilkins.addActionListener((ActionEvent e) -> {
            
            fillFormWilkins();
        });
        
        comboBoxWilkins.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                wilkins = "XXX";
                thickeningWilkins = "XXX";
                mobilityWilkins = "XXX";
                calcificationWilkins = "XXX";
                subvalveWilkins = "XXX";
                
                if(comboBoxWilkins.getSelectedIndex() == 0) { 
                    
                    editButtonWilkins.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonWilkins.setEnabled(true);
                    fillFormWilkins();
                }
            }
        });     
        
        editButtonGradient.addActionListener((ActionEvent e) -> {
            
            fillFormGradient();
        });
        
        comboBoxGradient.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                gradient = "XXX";
                
                if(comboBoxGradient.getSelectedIndex() == 0) {
                    
                    editButtonGradient.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonGradient.setEnabled(true);
                    fillFormGradient();
                }
            }
        });     
        
        editButtonPht.addActionListener((ActionEvent e) -> {
            
            fillFormPht();
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
            
            checkResetButton();
            valveArea = "XXX";
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
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
                if(comboBoxOrifice.getSelectedIndex() == 0) {
                    
                    orifice = "XXX";
                    editButtonOrifice.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    orifice = "XXX";
                    editButtonOrifice.setEnabled(true);
                    fillFormOrifice();
                }
            }
        });
        
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                int selectedIndex = comboBoxModel.getSelectedIndex();
                
                if(selectedIndex == 9) {
                    
                    jLabelCategory.setText("<html>Prótese biológica <br>em posição mitral</br></html>");
                    comboBoxReflux.removeAllItems();
                    comboBoxReflux.addItem("");
                    comboBoxReflux.addItem("Protético ausente");
                    comboBoxReflux.addItem("Protético mínimo(funcional)");
                    comboBoxReflux.addItem("Protético discreto");
                    comboBoxReflux.addItem("Protético moderado");
                    comboBoxReflux.addItem("Protético importante");
                } else if(selectedIndex == 10) {
                    
                    jLabelCategory.setText("<html>Prótese mecânica <br>em posição mitral</br></html>");
                    comboBoxReflux.removeAllItems();
                    comboBoxReflux.addItem("");
                    comboBoxReflux.addItem("Protético ausente");
                    comboBoxReflux.addItem("Protético mínimo(funcional)");
                    comboBoxReflux.addItem("Protético discreto");
                    comboBoxReflux.addItem("Protético moderado");
                    comboBoxReflux.addItem("Protético importante");
                } else {
                    
                    jLabelCategory.setText("Valva mitral");
                    if(comboBoxReflux.getItemCount() > 5) {
                        
                        comboBoxReflux.removeAllItems();
                        comboBoxReflux.addItem("");
                        comboBoxReflux.addItem("Ausente");
                        comboBoxReflux.addItem("Discreto");
                        comboBoxReflux.addItem("Moderado");
                        comboBoxReflux.addItem("Importante");
                    }
                }
                
                if(selectedIndex == 9 || selectedIndex == 10) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxWilkins.setEnabled(false);
                    comboBoxWilkins.setSelectedIndex(0);
                } else if(selectedIndex == 1 || selectedIndex == 11 ||
                        selectedIndex == 12) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxWilkins.setEnabled(false);
                    comboBoxWilkins.setSelectedIndex(0);
                } else if(selectedIndex == 3) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxWilkins.setEnabled(false);
                    comboBoxWilkins.setSelectedIndex(0);
                } else if (selectedIndex == 4 || selectedIndex == 5 ||
                        selectedIndex == 6) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(false);
                    comboBoxMobility.setSelectedIndex(0);
                    comboBoxWilkins.setEnabled(false);
                    comboBoxWilkins.setSelectedIndex(0);
                } else if(selectedIndex == 2) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxWilkins.setEnabled(true);
                } else if (selectedIndex == 7 || selectedIndex == 8) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(false);
                    comboBoxMobility.setSelectedIndex(0);
                    comboBoxWilkins.setEnabled(false);
                    comboBoxWilkins.setSelectedIndex(0);
                } else if(selectedIndex == 0) {
                
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(false);
                    comboBoxMobility.setSelectedIndex(0);
                    comboBoxWilkins.setEnabled(false);
                    comboBoxWilkins.setSelectedIndex(0);
                }
                
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
        
        comboBoxMitralRing.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
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
    
    private void fillFormGradient() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(gradient);

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

            gradient = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    private void fillFormWilkins() {
     
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel leftPanel = new JPanel(new FlowLayout());
        leftPanel.setPreferredSize(new Dimension(260, 150));
        
        JTextField field1 = new JTextField();
        field1.setPreferredSize(new Dimension(250, 20));
        field1.setText(wilkins);
        JTextField field2 = new JTextField();
        field2.setPreferredSize(new Dimension(250, 20));
        field2.setText(thickeningWilkins);
        JTextField field3 = new JTextField();
        field3.setPreferredSize(new Dimension(250, 20));
        field3.setText(mobilityWilkins);
        JTextField field4 = new JTextField();
        field4.setPreferredSize(new Dimension(250, 20));
        field4.setText(calcificationWilkins);
        JTextField field5 = new JTextField();
        field5.setPreferredSize(new Dimension(250, 20));
        field5.setText(subvalveWilkins);
        
        JLabel label1 = new JLabel("Escore de Wilkins(pontos)");
        label1.setPreferredSize(new Dimension(250, 20));
        JLabel label2 = new JLabel("Espessura de Wilkins(pontos)");
        label2.setPreferredSize(new Dimension(250, 20));
        JLabel label3 = new JLabel("Mobilidade de Wilkins(pontos)");
        label3.setPreferredSize(new Dimension(250, 20));
        JLabel label4 = new JLabel("Calcificação de Wilkins(pontos)");
        label4.setPreferredSize(new Dimension(250, 20));
        JLabel label5 = new JLabel("Subvalvar de Wilkins(pontos)");
        label5.setPreferredSize(new Dimension(250, 20));
        
        leftPanel.add(label1);
        leftPanel.add(field1);
        leftPanel.add(label2);
        leftPanel.add(field2);
        leftPanel.add(label3);
        leftPanel.add(field3);
        leftPanel.add(label4);
        leftPanel.add(field4);
        leftPanel.add(label5);
        leftPanel.add(field5);

        panel.add(leftPanel, BorderLayout.CENTER);
        JLabel labelImage = new JLabel();
        labelImage.setIcon(new ImageIcon(getClass().getResource("/wilkins.png")));
        
        panel.add(labelImage, BorderLayout.EAST);

        JOptionPane optionPane = new JOptionPane(
                panel,
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

            wilkins = field1.getText();
            try {
                
                wilkins = (Integer.parseInt(wilkins) == 1 ? "1 ponto" : wilkins + " pontos");
            } catch (NumberFormatException e) {
                
                wilkins += " pontos";    
            }
            thickeningWilkins = field2.getText();
            try {
                
                thickeningWilkins = (Integer.parseInt(thickeningWilkins) == 1 ? "1 ponto" : thickeningWilkins + " pontos");
            } catch (NumberFormatException e) {
                
                thickeningWilkins += " pontos";    
            }
            mobilityWilkins = field3.getText();
            try {
                
                mobilityWilkins = (Integer.parseInt(mobilityWilkins) == 1 ? "1 ponto" : mobilityWilkins + " pontos");
            } catch (NumberFormatException e) {
                
                mobilityWilkins += " pontos";    
            }
            calcificationWilkins = field4.getText();
            try {
                
                calcificationWilkins = (Integer.parseInt(calcificationWilkins) == 1 ? "1 ponto" : calcificationWilkins + " pontos");
            } catch (NumberFormatException e) {
                
                calcificationWilkins += " pontos";    
            }
            subvalveWilkins = field5.getText();  
            try {
                
                subvalveWilkins = (Integer.parseInt(subvalveWilkins) == 1 ? "1 ponto" : subvalveWilkins + " pontos");
            } catch (NumberFormatException e) {
                
                subvalveWilkins += " pontos";    
            }
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Valva nativa habitual", "Com " + thickening + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Reumática", "Com " + thickening + " de suas cúspides, calcificação " + calcification + ", abertura em cúpula " + mobility + " e fusão comissural. Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Degenerativa", "Com " + thickening + ", calcificação " + calcification + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Prolapso - Cúspide anterior", "Com " + thickening + ", abertura preservada e prolapso de sua cúspide anterior que ocasiona refluxo de grau " + reflux + " ao Doppler. ");
        hashCategoryReport.put("Prolapso - Cúspide posterior", "Com " + thickening + ", abertura preservada e prolapso de sua cúspide posterior que ocasiona refluxo de grau " + reflux + " ao Doppler. ");
        hashCategoryReport.put("Prolapso - Duas cúspides", "Com " + thickening + ", abertura preservada e prolapso de suas cúspides que ocasiona refluxo de grau " + reflux + " ao Doppler. ");
        hashCategoryReport.put("Corda rota - Cúspide anterior", "Com " + thickening + ", abertura preservada e eversão sistólica da cúspide anterior que ocasiona refluxo excêntrico e de grau " + reflux + " ao Doppler. Presença de imagem filiforme e móvel aderida à extremidade da cúspide anterior sugestiva de corda tendínea rota. ");
        hashCategoryReport.put("Corda rota - Cúspide posterior", "Com " + thickening + ", abertura preservada e eversão sistólica da cúspide posterior que ocasiona refluxo excêntrico e de grau " + reflux + " ao Doppler. Presença de imagem filiforme e móvel aderida à extremidade da cúspide posterior sugestiva de corda tendínea rota. ");
        hashCategoryReport.put("Prótese biológica - Mitral", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Prótese mecânica - Mitral", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Tracionamento - Cúspide anterior", "Com " + thickening + ", abertura " + mobility + " e tracionamento sistólico de sua cúspide posterior que ocasiona refluxo de grau " + reflux + " ao Doppler. ");
        hashCategoryReport.put("Tracionamento - Duas cúspides", "Com " + thickening + ", abertura " + mobility + " e tracionamento sistólico de suas cúspides que ocasiona refluxo de grau " + reflux + " ao Doppler. ");
        hashCategoryReport.put("Ecotextura normal", "");
        hashCategoryReport.put("Espessamento discreto", "");
        hashCategoryReport.put("Espessamento moderado", "");
        hashCategoryReport.put("Espessamento importante", "");
        hashCategoryReport.put("Normal", "");
        hashCategoryReport.put("Discreto", "");
        hashCategoryReport.put("Moderado", "");
        hashCategoryReport.put("Importante", "");
        hashCategoryReport.put("Mínima", "");
        hashCategoryReport.put("Mínimo", "");
        hashCategoryReport.put("Discreta", "");
        hashCategoryReport.put("Moderada", "");
        hashCategoryReport.put("Protético ausente", "");
        hashCategoryReport.put("Protético mínimo(funcional)", "");
        hashCategoryReport.put("Protético discreto", "");
        hashCategoryReport.put("Protético moderado", "");
        hashCategoryReport.put("Protético importante", "");
        hashCategoryReport.put("Cúspide anterior", "");
        hashCategoryReport.put("Cúspide posterior", "");
        hashCategoryReport.put("Calcificação discreta do anel mitral", "Calcificação discreta do anel mitral. ");
        hashCategoryReport.put("Calcificação moderada do anel mitral", "Calcificação moderada do anel mitral. ");
        hashCategoryReport.put("Calcificação importante do anel mitral", "Calcificação importante do anel mitral. ");
        hashCategoryReport.put("Preservada", "");
        hashCategoryReport.put("Ausente", "");
        hashCategoryReport.put("Reduzida em grau discreto", "");
        hashCategoryReport.put("Reduzida em grau moderado", "");
        hashCategoryReport.put("Reduzida em grau importante", "");
        hashCategoryReport.put("Reduzida em grau não significativo", "");
        hashCategoryReport.put("Reduzida em grau significativo", "");
        hashCategoryReport.put("<html>Gradiente médio - <b>DEFINIR</b></html>", "Gradiente médio: " + gradient + " mmHg. ");
        hashCategoryReport.put("<html>PHT - <b>DEFINIR</b></html>", "Tempo de meia pressão (PHT) estimado em " + pht + " ms. ");
        hashCategoryReport.put("<html>Equação de continuidade - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (equação de continuidade). ");
        hashCategoryReport.put("<html>Planimetria - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (planimetria). ");
        hashCategoryReport.put("<html>Orifício - <b>DEFINIR</b></html>", "Orifício efetivo regurgitante estimado em " + orifice + " cm². ");
        hashCategoryReport.put("<html>Escore de Wilkins - <b>DEFINIR</b></html>", "Escore de Wilkins: " + wilkins + " (espessura - " + thickeningWilkins + "; mobilidade - " + mobilityWilkins + "; calcificação - " + calcificationWilkins + "; subvalvar - " + subvalveWilkins +"). ");
        hashCategoryReport.put("<html>Índice Doppler - <b>DEFINIR</b></html>", "Índice Doppler: " + indexDoppler + " (sugestivo de obstrução significativa se < 2,5). ");
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
