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
public final class CategoryAorticValve extends CategoryComponent {
    
    private String thickening = "XXX";
    private String mobility = "XXX";
    private String calcification = "XXX";
    private String reflux = "XXX";
    private String midGradient = "XXX";
    private String maxGradient = "XXX";
    private String valveArea = "XXX";
    private String orifice = "XXX";
    private String tacte = "XXX";
    private String indexDoppler = "XXX";
    private String valv1 = "XXX";
    private String valv2 = "XXX";
    private String periprostheticReflux = "XXX";
    private final JComboBoxSubcategory comboBoxModel;
    private final JComboBoxSubcategory comboBoxThickening;
    private final JComboBoxSubcategory comboBoxMobility;
    private final JComboBoxSubcategory comboBoxReflux;
    private final JComboBoxSubcategory comboBoxCalcification;
    private final JComboBoxSubcategory comboBoxRaphe;
    private final JComboBoxSubcategory comboBoxMaxGradient;
    private final JComboBoxSubcategory comboBoxMidGradient;
    private final JComboBoxSubcategory comboBoxValveArea;
    private final JComboBoxSubcategory comboBoxIndexDoppler;
    private final JComboBoxSubcategory comboBoxTacTe;
    private final JComboBoxSubcategory comboBoxOrifice;
    private final JComboBoxSubcategory comboBoxPeriprostheticReflux;
    private final JEditButton editButtonMaxGradient;
    private final JEditButton editButtonMidGradient;
    private final JEditButton editButtonValveArea;
    private final JEditButton editButtonIndexDoppler;
    private final JEditButton editButtonTacTe;
    private final JEditButton editButtonOrifice;
    private final JEditButton editButtonRaphe;
    private final JEditButton editButtonPeriprostheticReflux;
    
    public CategoryAorticValve() {
        
        jLabelCategory = new JLabelCategory("Valva aórtica");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Modelo"));
        comboBoxModel = new JComboBoxSubcategory(new String[]{"", "Valva nativa habitual", "Degenerativa", "Bivalvular - Rafe", "Bivalvular - Purely bicuspid", "Prótese biológica - Aórtica", "Prótese mecânica - Aórtica"});
        jComboBoxSubcategories.add(comboBoxModel);
        setModelListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Espessamento")); 
        comboBoxThickening = new JComboBoxSubcategory(new String[]{"", "Ecotextura normal", "Espessamento discreto", "Espessamento moderado", "Espessamento importante"});
        comboBoxThickening.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxThickening);
        setThickeningListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Calcificação"));
        comboBoxCalcification = new JComboBoxSubcategory(new String[]{"", "Mínima", "Discreta", "Moderada", "Importante"});
        comboBoxCalcification.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxCalcification);
        setCalcificationListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Abertura / Mobilidade prótese")); 
        comboBoxMobility = new JComboBoxSubcategory(new String[]{"", "Preservada", "Reduzida em grau discreto", "Reduzida em grau moderado", "Reduzida em grau importante", "Reduzida em grau não significativo", "Reduzida em grau significativo"});
        comboBoxMobility.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxMobility);
        setMobilityListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Refluxo")); 
        comboBoxReflux = new JComboBoxSubcategory(new String[]{"", "Ausente", "Discreto", "Moderado", "Importante"});
        jComboBoxSubcategories.add(comboBoxReflux);
        setRefluxListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Refluxo periprotético")); 
        comboBoxPeriprostheticReflux = new JComboBoxSubcategory(new String[]{"", "Leak discreto", "Leak moderado", "Leak importante", "<html>Leak discreto - <b>DEFINIR</b></html>", "<html>Leak moderado - <b>DEFINIR</b></html>", "<html>Leak importante - <b>DEFINIR</b></html>"});
        comboBoxPeriprostheticReflux.setName("PeriprostheticReflux");
        comboBoxPeriprostheticReflux.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxPeriprostheticReflux);   
        editButtonPeriprostheticReflux = new JEditButton();
        editButtonPeriprostheticReflux.setName("PeriprostheticReflux");
        arrayEditButton.add(editButtonPeriprostheticReflux);
        setPeriprostheticRefluxListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Orifício efetivo regurgitante")); 
        comboBoxOrifice = new JComboBoxSubcategory(new String[]{"", "<html>Orifício - <b>DEFINIR</b></html>"});
        comboBoxOrifice.setName("Orifice");
        jComboBoxSubcategories.add(comboBoxOrifice);
        editButtonOrifice = new JEditButton();
        editButtonOrifice.setName("Orifice");
        arrayEditButton.add(editButtonOrifice);
        setOrificeListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Rafe")); 
        comboBoxRaphe = new JComboBoxSubcategory(new String[]{"", "<html>Rafe das Válvulas - <b>DEFINIR</b></html>"});
        comboBoxRaphe.setName("Raphe");
        comboBoxRaphe.setEnabled(false);
        jComboBoxSubcategories.add(comboBoxRaphe);
        editButtonRaphe = new JEditButton();
        editButtonRaphe.setName("Raphe");
        arrayEditButton.add(editButtonRaphe);
        setRapheListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Gradiente máximo")); 
        comboBoxMaxGradient = new JComboBoxSubcategory(new String[]{"", "<html>Gradiente máximo - <b>DEFINIR</b></html>"});
        comboBoxMaxGradient.setName("MaxGradient");
        jComboBoxSubcategories.add(comboBoxMaxGradient);
        editButtonMaxGradient = new JEditButton();
        editButtonMaxGradient.setName("MaxGradient");
        arrayEditButton.add(editButtonMaxGradient);
        setMaxGradientListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Gradiente médio")); 
        comboBoxMidGradient = new JComboBoxSubcategory(new String[]{"", "<html>Gradiente médio - <b>DEFINIR</b></html>"});
        comboBoxMidGradient.setName("MidGradient");
        jComboBoxSubcategories.add(comboBoxMidGradient);
        editButtonMidGradient = new JEditButton();
        editButtonMidGradient.setName("MidGradient");
        arrayEditButton.add(editButtonMidGradient);
        setMidGradientListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Área valvar")); 
        comboBoxValveArea = new JComboBoxSubcategory(new String[]{"", "<html>Equação de continuidade - <b>DEFINIR</b></html>", "<html>Planimetria - <b>DEFINIR</b><html>"});
        comboBoxValveArea.setName("ValveArea");
        jComboBoxSubcategories.add(comboBoxValveArea);
        editButtonValveArea = new JEditButton();
        editButtonValveArea.setName("ValveArea");
        arrayEditButton.add(editButtonValveArea);
        setValveAreaListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Índice Doppler")); 
        comboBoxIndexDoppler = new JComboBoxSubcategory(new String[]{"", "<html>Índice Doppler - <b>DEFINIR</b></html>"});
        comboBoxIndexDoppler.setName("IndexDoppler");
        jComboBoxSubcategories.add(comboBoxIndexDoppler);
        editButtonIndexDoppler = new JEditButton();
        editButtonIndexDoppler.setName("IndexDoppler");
        arrayEditButton.add(editButtonIndexDoppler);
        setIndexDopplerListeners();
        
        jLabelSubcategories.add(new JLabelSubcategory("Relação TAC/TE")); 
        comboBoxTacTe = new JComboBoxSubcategory(new String[]{"", "<html>Relação aceleração/tempo - <b>DEFINIR</b></html>"});
        comboBoxTacTe.setName("TacTe");
        jComboBoxSubcategories.add(comboBoxTacTe);
        editButtonTacTe = new JEditButton();
        editButtonTacTe.setName("TacTe");
        arrayEditButton.add(editButtonTacTe);
        setTacTeListeners();
        
        JLabelSubcategory notes = new JLabelSubcategory("Notas adicionais");
        notes.setName("Notes");
        jLabelSubcategories.add(notes);
        
        setHashCategoryReport();  
    }
    
    private void setMobilityListeners() {
        
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
    }
    
    private void setPeriprostheticRefluxListeners() {
    
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
    }
    
    private void setModelListeners() {
    
        comboBoxModel.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                int selectedIndex = comboBoxModel.getSelectedIndex();
                
                if(selectedIndex == 5) {
                    
                    jLabelCategory.setText("<html>Prótese biológica <br>em posição aórtica</br></html>");
                    comboBoxReflux.removeAllItems();
                    comboBoxReflux.addItem("");
                    comboBoxReflux.addItem("Protético ausente");
                    comboBoxReflux.addItem("Protético mínimo(funcional)");
                    comboBoxReflux.addItem("Protético discreto");
                    comboBoxReflux.addItem("Protético moderado");
                    comboBoxReflux.addItem("Protético importante");
                } else if(selectedIndex == 6) {
                    
                    jLabelCategory.setText("<html>Prótese mecânica <br>em posição aórtica</br></html>");
                    comboBoxReflux.removeAllItems();
                    comboBoxReflux.addItem("");
                    comboBoxReflux.addItem("Protético ausente");
                    comboBoxReflux.addItem("Protético mínimo(funcional)");
                    comboBoxReflux.addItem("Protético discreto");
                    comboBoxReflux.addItem("Protético moderado");
                    comboBoxReflux.addItem("Protético importante");
                } else {
                    
                    jLabelCategory.setText("Valva aórtica");
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
                    comboBoxThickening.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxRaphe.setEnabled(false);
                    comboBoxRaphe.setSelectedIndex(0);
                } else if(selectedIndex == 1) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxThickening.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxRaphe.setEnabled(false);
                    comboBoxRaphe.setSelectedIndex(0);
                } else if(selectedIndex == 2) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxThickening.setEnabled(true);
                    comboBoxCalcification.setEnabled(true);
                    comboBoxMobility.setEnabled(true);
                    comboBoxRaphe.setEnabled(false);
                    comboBoxRaphe.setSelectedIndex(0);
                } else if (selectedIndex == 4) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxThickening.setEnabled(false);
                    comboBoxThickening.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(true);
                    comboBoxRaphe.setEnabled(false);
                    comboBoxRaphe.setSelectedIndex(0);
                } else if(selectedIndex == 3) {
                    
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxThickening.setEnabled(true);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(true);
                    comboBoxRaphe.setEnabled(true);
                } else if(selectedIndex == 0) {
                
                    comboBoxPeriprostheticReflux.setEnabled(false);
                    comboBoxPeriprostheticReflux.setSelectedIndex(0);
                    comboBoxThickening.setEnabled(false);
                    comboBoxThickening.setSelectedIndex(0);
                    comboBoxCalcification.setEnabled(false);
                    comboBoxCalcification.setSelectedIndex(0);
                    comboBoxMobility.setEnabled(false);
                    comboBoxMobility.setSelectedIndex(0);
                    comboBoxRaphe.setEnabled(false);
                    comboBoxRaphe.setSelectedIndex(0);
                }
                
                setHashCategoryReport();
                Report.getReport().updateReportPane();
            }
        });
    }
   
    private void setCalcificationListeners() {
    
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
    }
    
    private void setIndexDopplerListeners() {
    
        editButtonIndexDoppler.addActionListener((ActionEvent e) -> {
            
            fillFormIndexDoppler();
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
    }
    
    private void setMaxGradientListeners() {
    
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
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonMaxGradient.setEnabled(true);
                    fillFormMaxGradient();
                }
            }
        });
    }
    
    private void setMidGradientListeners() {
    
        editButtonMidGradient.addActionListener((ActionEvent e) -> {
            
            fillFormMidGradient();
        });
        
        comboBoxMidGradient.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                midGradient = "XXX";
                
                if(comboBoxMidGradient.getSelectedIndex() == 0) {
                    
                    editButtonMidGradient.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonMidGradient.setEnabled(true);
                    fillFormMidGradient();
                }
            }
        }); 
    }
    
    private void setOrificeListeners() {
    
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
    }
    
    private void setRapheListeners() {
    
        editButtonRaphe.addActionListener((ActionEvent e) -> {
            
            fillFormRaphe();
        });
        
        comboBoxRaphe.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                valv1 = "XXX";
                valv2 = "XXX";
                
                if(comboBoxRaphe.getSelectedIndex() == 0) {
                    
                    editButtonRaphe.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonRaphe.setEnabled(true);
                    fillFormRaphe();
                }
            }
        });
    }
    
    private void setRefluxListeners() {
    
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
    
    private void setTacTeListeners() {
        
        editButtonTacTe.addActionListener((ActionEvent e) -> {
            
            fillFormTacTe();
        });
        
        comboBoxTacTe.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                tacte = "XXX";
                
                if(comboBoxTacTe.getSelectedIndex() == 0) {
                    
                    editButtonTacTe.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonTacTe.setEnabled(true);
                    fillFormTacTe();
                }
            }
        });
    }
    
    private void setValveAreaListeners() {
    
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
    }
    
    private void setThickeningListeners() {
        
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
    }
    
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
    
    private void fillFormRaphe() {
     
        JTextField field1 = new JTextField(10);
        field1.setText(valv1);
        JTextField field2 = new JTextField(10);
        field2.setText(valv2);

        Object[] input = new Object[4];

        input[0] = "Válvula 1:";
        input[1] = field1;
        input[2] = "Válvula 2:";
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

            valv1 = field1.getText();
            valv2 = field2.getText();
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
    
    private void fillFormTacTe() {
        
        JTextField field1 = new JTextField(10);
        field1.setText(tacte);

        Object[] input = new Object[2];
        input[0] = "Relação tempo de aceleração/tempo de ejeção:";
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

            tacte = field1.getText();
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
        hashCategoryReport.put("Valva nativa habitual", "Trivalvular, com " + thickening + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Degenerativa", "Com " + thickening + ", calficação " + calcification + " e abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Bivalvular - Rafe", "Com " + thickening + " e abertura bivalvular devido à presença de rafe entre as válvulas " + valv1 + " e " + valv2 + "; abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Bivalvular - Purely bicuspid", "Com ecotextura normal e abertura bivalvular do tipo \"purely bicuspid\"; abertura " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Prótese biológica - Aórtica", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Prótese mecânica - Aórtica", "Normoposicionada, com " + thickening + " e mobilidade de seus elementos móveis " + mobility + ". Ao Doppler, refluxo " + reflux + ". ");
        hashCategoryReport.put("Ecotextura normal", "");
        hashCategoryReport.put("Espessamento discreto", "");
        hashCategoryReport.put("Espessamento moderado", "");
        hashCategoryReport.put("Espessamento importante", "");
        hashCategoryReport.put("Normal", "");
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
        hashCategoryReport.put("<html>Rafe das Válvulas - <b>DEFINIR</b></html>", "");
        hashCategoryReport.put("<html>Gradiente máximo - <b>DEFINIR</b></html>", "Gradiente máximo: " + maxGradient + " mmHg. ");
        hashCategoryReport.put("<html>Gradiente médio - <b>DEFINIR</b></html>", "Gradiente médio: " + midGradient + " mmHg. ");
        hashCategoryReport.put("<html>Equação de continuidade - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (equação de continuidade). ");
        hashCategoryReport.put("<html>Planimetria - <b>DEFINIR</b></html>", "Área valvar: " + valveArea + " cm² (planimetria). ");
        hashCategoryReport.put("<html>Orifício - <b>DEFINIR</b></html>", "Orifício efetivo regurgitante estimado em " + orifice + " cm². ");
        hashCategoryReport.put("<html>Relação aceleração/tempo - <b>DEFINIR</b></html>", "Relação Tempo de aceleração/tempo de ejeção: " + tacte + " (sugestivo de obstrução significativa se > 0,37). ");
        hashCategoryReport.put("<html>Índice Doppler - <b>DEFINIR</b></html>", "Índice Doppler: " + indexDoppler + " (sugestivo de obstrução significativa se < 0,25). ");
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
