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
import javax.swing.JOptionPane;

/**
 *
 * @author INCOREL
 */
public final class CategoryConclusion extends CategoryComponent {

    private String stenosisMitralValve = "XXX";
    private String insufficiencyMitralValve = "XXX";
    private String stenosisAorticValve = "XXX";
    private String insufficiencyAorticValve = "XXX";
    private String stenosisTricuspidValve = "XXX";
    private String insufficiencyTricuspidValve = "XXX";
    private String stenosisPulmonaryValve = "XXX";
    private String insufficiencyPulmonaryValve = "XXX";
    private final JComboBoxSubcategory comboBoxNormal;
    private final JComboBoxSubcategory comboBoxMyocardialThickness;
    private final JComboBoxSubcategory comboBoxLeftVentricle;
    private final JComboBoxSubcategory comboBoxDiastole;
    private final JComboBoxSubcategory comboBoxRightVentricle;
    private final JComboBoxSubcategory comboBoxMitralValve;
    private final JComboBoxSubcategory comboBoxAorticValve;
    private final JComboBoxSubcategory comboBoxTricuspidValve;
    private final JComboBoxSubcategory comboBoxPulmonaryValve;
    private final JComboBoxSubcategory comboBoxPulmonaryTrunkArteries;
    private final JComboBoxSubcategory comboBoxThoracicAorta;
    private final JComboBoxSubcategory comboBoxAtrialSeptum;
    private final JComboBoxSubcategory comboBoxPericardium;
    private final JComboBoxSubcategory comboBoxMiscellaneous;
    private final JEditButton editButtonMitralValve;
    private final JEditButton editButtonAorticValve;
    private final JEditButton editButtonTricuspidValve;
    private final JEditButton editButtonPulmonaryValve;
    private final JComboBoxSubcategory comboBoxStenosisMitralValve;
    private final JComboBoxSubcategory comboBoxInsufficiencyMitralValve;
    private final JComboBoxSubcategory comboBoxStenosisAorticValve;
    private final JComboBoxSubcategory comboBoxInsufficiencyAorticValve;
    private final JComboBoxSubcategory comboBoxStenosisTricuspidValve;
    private final JComboBoxSubcategory comboBoxInsufficiencyTricuspidValve;
    private final JComboBoxSubcategory comboBoxStenosisPulmonaryValve;
    private final JComboBoxSubcategory comboBoxInsufficiencyPulmonaryValve;
    
    public CategoryConclusion () {
        
        jLabelCategory = new JLabelCategory("Conclusão");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Normal")); 
        comboBoxNormal = new JComboBoxSubcategory(new String[]{"", "Ecocardiograma dentro dos limites da normalidade", "Ecocardiograma normal dentro do ponto de vista anatômico"});
        jComboBoxSubcategories.add(comboBoxNormal);
        
        jLabelSubcategories.add(new JLabelSubcategory("Espessura miocárdica")); 
        comboBoxMyocardialThickness = new JComboBoxSubcategory(new String[]{"", "Remodelamento concêntrico do ventrículo esquerdo", "Hipertrofia concêntrica do ventrículo esquerdo", "Hipertrofia excêntrica do ventrículo esquerdo", "Cardiomiopatia Hipertrófica", "Amiloidose cardíaca", "Cardiomiopatia com trabeculação excessiva", "Cardiomiopatia arritmogênica do ventrículo direito"});
        jComboBoxSubcategories.add(comboBoxMyocardialThickness);
        
        jLabelSubcategories.add(new JLabelSubcategory("Ventrículo esquerdo")); 
        comboBoxLeftVentricle = new JComboBoxSubcategory(new String[]{"", "Comprometimento miocárdico difuso do ventrículo esquerdo", "Comprometimento miocárdico segmentar do ventrículo esquerdo"});
        jComboBoxSubcategories.add(comboBoxLeftVentricle);
        
        jLabelSubcategories.add(new JLabelSubcategory("Diástole")); 
        comboBoxDiastole = new JComboBoxSubcategory(new String[]{"", "Alteração do relaxamento ventricular esquerdo", "Disfunção diastólica do ventrículo esquerdo de grau I", "Disfunção diastólica do ventrículo esquerdo de grau II", "Disfunção diastólica do ventrículo esquerdo de grau III (padrão restritivo)", "Sinais de aumento das pressões de enchimento do ventrículo esquerdo"});
        jComboBoxSubcategories.add(comboBoxDiastole);
        
        jLabelSubcategories.add(new JLabelSubcategory("Ventrículo direito")); 
        comboBoxRightVentricle = new JComboBoxSubcategory(new String[]{"", "Comprometimento sistólico do ventrículo direito"});
        jComboBoxSubcategories.add(comboBoxRightVentricle);
        
        jLabelSubcategories.add(new JLabelSubcategory("Valva mitral")); 
        comboBoxMitralValve = new JComboBoxSubcategory(new String[]{"", "Insuficiência mitral discreta", "Insuficiência mitral moderada", "Insuficiência mitral importante", "Estenose valvar mitral degenerativa de grau não significativo", "Estenose valvar mitral degenerativa de grau significativo", "Estenose valvar mitral reumática de grau discreto", "Estenose valvar mitral reumática de grau moderado", "Estenose valvar mitral reumática de grau importante", "<html>Dupla lesão valvar mitral degenerativa - <b>DEFINIR</b></html>", "<html>Dupla lesão valvar mitral reumática - <b>DEFINIR</b></html>"});
        comboBoxMitralValve.setName("MitralValve");
        jComboBoxSubcategories.add(comboBoxMitralValve);
        editButtonMitralValve = new JEditButton();
        editButtonMitralValve.setName("MitralValve");
        arrayEditButton.add(editButtonMitralValve);
        comboBoxStenosisMitralValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        comboBoxInsufficiencyMitralValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        
        jLabelSubcategories.add(new JLabelSubcategory("Valva aórtica")); 
        comboBoxAorticValve = new JComboBoxSubcategory(new String[]{"", "Insuficiência aórtica discreta", "Insuficiência aórtica moderada", "Insuficiência aórtica importante", "Estenose valvar aórtica degenerativa de grau discreto", "Estenose valvar aórtica degenerativa de grau moderado", "Estenose valvar aórtica degenerativa de grau importante", "Estenose valvar aórtica reumática de grau discreto", "Estenose valvar aórtica reumática de grau moderado", "Estenose valvar aórtica reumática de grau importante", "<html>Dupla lesão valvar aórtica degenerativa - <b>DEFINIR</b></html>", "<html>Dupla lesão valvar aórtica reumática - <b>DEFINIR</b></html>"});
        comboBoxAorticValve.setName("AorticValve");
        jComboBoxSubcategories.add(comboBoxAorticValve);
        editButtonAorticValve = new JEditButton();
        editButtonAorticValve.setName("AorticValve");
        arrayEditButton.add(editButtonAorticValve);
        comboBoxStenosisAorticValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        comboBoxInsufficiencyAorticValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        
        jLabelSubcategories.add(new JLabelSubcategory("Valva tricúspide")); 
        comboBoxTricuspidValve = new JComboBoxSubcategory(new String[]{"", "Insuficiência tricúspide discreta", "Insuficiência tricúspide moderada", "Insuficiência tricúspide importante", "Estenose valvar tricúspide de grau não significativo", "Estenose valvar tricúspide de grau significativo", "<html>Dupla lesão valvar tricúspide - <b>DEFINIR</b></html>"});
        comboBoxTricuspidValve.setName("TricuspidValve");
        jComboBoxSubcategories.add(comboBoxTricuspidValve);
        editButtonTricuspidValve = new JEditButton();
        editButtonTricuspidValve.setName("TricuspidValve");
        arrayEditButton.add(editButtonTricuspidValve);
        comboBoxStenosisTricuspidValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        comboBoxInsufficiencyTricuspidValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        
        jLabelSubcategories.add(new JLabelSubcategory("Valva pulmonar")); 
        comboBoxPulmonaryValve = new JComboBoxSubcategory(new String[]{"", "Insuficiência pulmonar discreta", "Insuficiência pulmonar moderada", "Insuficiência pulmonar importante", "Estenose valvar pulmonar de grau não significativo", "Estenose valvar pulmonar de grau significativo", "<html>Dupla lesão valvar pulmonar - <b>DEFINIR</b></html>"});
        comboBoxPulmonaryValve.setName("PulmonaryValve");
        jComboBoxSubcategories.add(comboBoxPulmonaryValve);
        editButtonPulmonaryValve = new JEditButton();
        editButtonPulmonaryValve.setName("PulmonaryValve");
        arrayEditButton.add(editButtonPulmonaryValve);
        comboBoxStenosisPulmonaryValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        comboBoxInsufficiencyPulmonaryValve = new JComboBoxSubcategory(new String[] {"", "Discreta", "Moderada", "Importante"});
        
        jLabelSubcategories.add(new JLabelSubcategory("Tronco e artérias pulmonares")); 
        comboBoxPulmonaryTrunkArteries = new JComboBoxSubcategory(new String[]{"", "Sinais ecocardiográficos de hipertensão pulmonar"});
        jComboBoxSubcategories.add(comboBoxPulmonaryTrunkArteries);
   
        jLabelSubcategories.add(new JLabelSubcategory("Aorta torácica")); 
        comboBoxThoracicAorta = new JComboBoxSubcategory(new String[]{"", "Ectasia aórtica", "Ectasia e ateromatose aórtica", "Dilatação aneurismática da raiz aórtica", "Dilatação aneurismática da aorta ascendente", "Dilatação aneurismática do arco aórtico", "Ateromatose aórtica"});
        jComboBoxSubcategories.add(comboBoxThoracicAorta);
        
        jLabelSubcategories.add(new JLabelSubcategory("Septo interatrial")); 
        comboBoxAtrialSeptum = new JComboBoxSubcategory(new String[]{"", "Membrana da fossa oval aneurismática", "Membrana da fossa redundante", "Forame oval patente", "Comunicação interatrial do tipo ostium secundum", "Comunicação interatrial do tipo seio venoso"});
        jComboBoxSubcategories.add(comboBoxAtrialSeptum);
        
        jLabelSubcategories.add(new JLabelSubcategory("Pericárdio")); 
        comboBoxPericardium = new JComboBoxSubcategory(new String[]{"", "Derrame pericárdico discreto", "Derrame pericárdico moderado", "Derrame pericárdico importante", "Derrame pericárdico importante com sinais de restrição ao enchimento ventricular"});
        jComboBoxSubcategories.add(comboBoxPericardium);
        
        jLabelSubcategories.add(new JLabelSubcategory("Miscelânea")); 
        comboBoxMiscellaneous = new JComboBoxSubcategory(new String[]{"", "Vide comentários", "Função sistólica biventricular preservada"});
        jComboBoxSubcategories.add(comboBoxMiscellaneous);
        
        setHashCategoryReport(); 
        setCategoryListeners();
    }
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxNormal.setSelectedIndex(1);
    }

    @Override
    protected void setCategoryListeners() {
        
        editButtonMitralValve.addActionListener((ActionEvent e) -> {
            
            fillFormMitralValve();
        });
        
        editButtonAorticValve.addActionListener((ActionEvent e) -> {
            
            fillFormAorticValve();
        });
                
        editButtonTricuspidValve.addActionListener((ActionEvent e) -> {
            
            fillFormTricuspidValve();
        });
                        
        editButtonPulmonaryValve.addActionListener((ActionEvent e) -> {
            
            fillFormPulmonaryValve();
        });
        
        comboBoxNormal.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxMyocardialThickness.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxLeftVentricle.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxRightVentricle.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxMitralValve.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                stenosisMitralValve = "XXX";
                insufficiencyMitralValve = "XXX";
                comboBoxInsufficiencyMitralValve.setSelectedIndex(0);
                comboBoxStenosisMitralValve.setSelectedIndex(0);
                
                if(comboBoxMitralValve.getSelectedIndex() < 9 && comboBoxMitralValve.getSelectedIndex() > -1 ) {
                    
                    editButtonMitralValve.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonMitralValve.setEnabled(true);
                    fillFormMitralValve();
                }
            }
        });
        
        comboBoxDiastole.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxAorticValve.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                stenosisAorticValve = "XXX";
                insufficiencyAorticValve = "XXX";
                comboBoxInsufficiencyAorticValve.setSelectedIndex(0);
                comboBoxStenosisAorticValve.setSelectedIndex(0);
                
                if(comboBoxAorticValve.getSelectedIndex() < 9 && comboBoxAorticValve.getSelectedIndex() > -1 ) {
                    
                    editButtonAorticValve.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonAorticValve.setEnabled(true);
                    fillFormAorticValve();
                }
            }
        });
        
        comboBoxTricuspidValve.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                stenosisTricuspidValve = "XXX";
                insufficiencyTricuspidValve = "XXX";
                comboBoxInsufficiencyTricuspidValve.setSelectedIndex(0);
                comboBoxStenosisTricuspidValve.setSelectedIndex(0);
                
                if(comboBoxTricuspidValve.getSelectedIndex() < 6 && comboBoxTricuspidValve.getSelectedIndex() > -1 ) {
                    
                    editButtonTricuspidValve.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonTricuspidValve.setEnabled(true);
                    fillFormTricuspidValve();
                }
            }
        });
        
        comboBoxPulmonaryValve.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                stenosisPulmonaryValve = "XXX";
                insufficiencyPulmonaryValve = "XXX";
                comboBoxInsufficiencyPulmonaryValve.setSelectedIndex(0);
                comboBoxStenosisPulmonaryValve.setSelectedIndex(0);
                
                if(comboBoxPulmonaryValve.getSelectedIndex() < 6 && comboBoxPulmonaryValve.getSelectedIndex() > -1 ) {
                    
                    editButtonPulmonaryValve.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().updateReportPane();
                } else {
                    
                    editButtonPulmonaryValve.setEnabled(true);
                    fillFormPulmonaryValve();
                }
            }
        });
        
        comboBoxPulmonaryTrunkArteries.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxThoracicAorta.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxAtrialSeptum.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxPericardium.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxMiscellaneous.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
    }

    protected void fillFormMitralValve() {
       
        Object[] input = new Object[4];

        input[0] = "Estenose:";
        input[1] = comboBoxStenosisMitralValve;
        input[2] = "Insuficência:";
        input[3] = comboBoxInsufficiencyMitralValve;

        int result = JOptionPane.showConfirmDialog(null, input, "Defina os parâmetros", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {

            if(comboBoxStenosisMitralValve.getSelectedIndex() != 0) {
            
                stenosisMitralValve = comboBoxStenosisMitralValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                stenosisMitralValve = "XXX";
            }
            if(comboBoxInsufficiencyMitralValve.getSelectedIndex() != 0) {
             
                insufficiencyMitralValve = comboBoxInsufficiencyMitralValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                insufficiencyMitralValve = "XXX";
            }
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    protected void fillFormAorticValve() {
    
        Object[] input = new Object[4];

        input[0] = "Estenose:";
        input[1] = comboBoxStenosisAorticValve;
        input[2] = "Insuficência:";
        input[3] = comboBoxInsufficiencyAorticValve;

        int result = JOptionPane.showConfirmDialog(null, input, "Defina os parâmetros", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {

            if(comboBoxStenosisAorticValve.getSelectedIndex() != 0) {
            
                stenosisAorticValve = comboBoxStenosisAorticValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                stenosisAorticValve = "XXX";
            }
            if(comboBoxInsufficiencyAorticValve.getSelectedIndex() != 0) {
             
                insufficiencyAorticValve = comboBoxInsufficiencyAorticValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                insufficiencyAorticValve = "XXX";
            }
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    protected void fillFormTricuspidValve() {
    
        Object[] input = new Object[4];

        input[0] = "Estenose:";
        input[1] = comboBoxStenosisTricuspidValve;
        input[2] = "Insuficência:";
        input[3] = comboBoxInsufficiencyTricuspidValve;

        int result = JOptionPane.showConfirmDialog(null, input, "Defina os parâmetros", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {

            if(comboBoxStenosisTricuspidValve.getSelectedIndex() != 0) {
            
                stenosisTricuspidValve = comboBoxStenosisTricuspidValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                stenosisTricuspidValve = "XXX";
            }
            if(comboBoxInsufficiencyTricuspidValve.getSelectedIndex() != 0) {
             
                insufficiencyTricuspidValve = comboBoxInsufficiencyTricuspidValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                insufficiencyTricuspidValve = "XXX";
            }
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    protected void fillFormPulmonaryValve() {
    
        Object[] input = new Object[4];

        input[0] = "Estenose:";
        input[1] = comboBoxStenosisPulmonaryValve;
        input[2] = "Insuficência:";
        input[3] = comboBoxInsufficiencyPulmonaryValve;

        int result = JOptionPane.showConfirmDialog(null, input, "Defina os parâmetros", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {

            if(comboBoxStenosisPulmonaryValve.getSelectedIndex() != 0) {
            
                stenosisPulmonaryValve = comboBoxStenosisPulmonaryValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                stenosisPulmonaryValve = "XXX";
            }
            if(comboBoxInsufficiencyPulmonaryValve.getSelectedIndex() != 0) {
             
                insufficiencyPulmonaryValve = comboBoxInsufficiencyPulmonaryValve.getSelectedItem().toString().toLowerCase();
            } else {
                
                insufficiencyPulmonaryValve = "XXX";
            }
        }   
        
        setHashCategoryReport();
        Report.getReport().updateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Ecocardiograma dentro dos limites da normalidade", "Ecocardiograma dentro dos limites da normalidade. ");
        hashCategoryReport.put("Ecocardiograma normal dentro do ponto de vista anatômico", "Ecocardiograma normal dentro do ponto de vista anatômico. ");
        hashCategoryReport.put("Remodelamento concêntrico do ventrículo esquerdo", "Remodelamento concêntrico do ventrículo esquerdo. ");
        hashCategoryReport.put("Hipertrofia concêntrica do ventrículo esquerdo", "Hipertrofia concêntrica do ventrículo esquerdo. ");
        hashCategoryReport.put("Hipertrofia excêntrica do ventrículo esquerdo", "Hipertrofia excêntrica do ventrículo esquerdo. ");
        hashCategoryReport.put("Cardiomiopatia Hipertrófica", "Cardiomiopatia Hipertrófica. ");
        hashCategoryReport.put("Amiloidose cardíaca", "Amiloidose cardíaca. ");
        hashCategoryReport.put("Cardiomiopatia com trabeculação excessiva", "Cardiomiopatia com trabeculação excessiva. ");
        hashCategoryReport.put("Cardiomiopatia arritmogênica do ventrículo direito", "Cardiomiopatia arritmogênica do ventrículo direito. ");
        hashCategoryReport.put("Comprometimento miocárdico difuso do ventrículo esquerdo", "Comprometimento miocárdico difuso do ventrículo esquerdo. ");
        hashCategoryReport.put("Comprometimento miocárdico segmentar do ventrículo esquerdo", "Comprometimento segmentar do ventrículo esquerdo. ");
        hashCategoryReport.put("Alteração do relaxamento ventricular esquerdo", "Alteração do relaxamento ventricular esquerdo. ");
        hashCategoryReport.put("Disfunção diastólica do ventrículo esquerdo de grau I", "Disfunção diastólica do ventrículo esquerdo de grau I. ");
        hashCategoryReport.put("Disfunção diastólica do ventrículo esquerdo de grau II", "Disfunção diastólica do ventrículo esquerdo de grau II. ");
        hashCategoryReport.put("Disfunção diastólica do ventrículo esquerdo de grau III (padrão restritivo)", "Disfunção diastólica do ventrículo esquerdo de grau III (padrão restritivo). ");
        hashCategoryReport.put("Sinais de aumento das pressões de enchimento do ventrículo esquerdo", "Sinais de aumento das pressões de enchimento do ventrículo esquerdo. ");
        hashCategoryReport.put("Comprometimento sistólico do ventrículo direito", "Disfunção sistólica do ventrículo direito. ");
        hashCategoryReport.put("Insuficiência mitral discreta", "Insuficiência mitral discreta. ");
        hashCategoryReport.put("Insuficiência mitral moderada", "Insuficiência mitral moderada. ");
        hashCategoryReport.put("Insuficiência mitral importante", "Insuficiência mitral importante. ");
        hashCategoryReport.put("Estenose valvar mitral degenerativa de grau não significativo", "Estenose valvar mitral degenerativa de grau não significativo. ");
        hashCategoryReport.put("Estenose valvar mitral degenerativa de grau significativo", "Estenose valvar mitral degenerativa de grau significativo. ");
        hashCategoryReport.put("Estenose valvar mitral reumática de grau discreto", "Estenose valvar mitral reumática de grau discreto. ");
        hashCategoryReport.put("Estenose valvar mitral reumática de grau moderado", "Estenose valvar mitral reumática de grau moderado. ");
        hashCategoryReport.put("Estenose valvar mitral reumática de grau importante", "Estenose valvar mitral reumática de grau importante. ");
        hashCategoryReport.put("<html>Dupla lesão valvar mitral degenerativa - <b>DEFINIR</b></html>", "Dupla lesão valvar mitral degenerativa (estenose " + stenosisMitralValve + " e insuficiência " + insufficiencyMitralValve + "). ");
        hashCategoryReport.put("<html>Dupla lesão valvar mitral reumática - <b>DEFINIR</b></html>", "Dupla lesão valvar mitral reumática (estenose " + stenosisMitralValve + " e insuficiência " + insufficiencyMitralValve + "). ");
        hashCategoryReport.put("Insuficiência aórtica discreta", "Insuficiência aórtica discreta. ");
        hashCategoryReport.put("Insuficiência aórtica moderada", "Insuficiência aórtica moderada. ");
        hashCategoryReport.put("Insuficiência aórtica importante", "Insuficiência aórtica importante. ");
        hashCategoryReport.put("Estenose valvar aórtica degenerativa de grau discreto", "Estenose valvar aórtica degenerativa de grau discreto. ");
        hashCategoryReport.put("Estenose valvar aórtica degenerativa de grau moderado", "Estenose valvar aórtica degenerativa de grau moderado. ");
        hashCategoryReport.put("Estenose valvar aórtica degenerativa de grau importante", "Estenose valvar aórtica degenerativa de grau importante. ");
        hashCategoryReport.put("Estenose valvar aórtica reumática de grau discreto", "Estenose valvar aórtica reumática de grau discreto. ");
        hashCategoryReport.put("Estenose valvar aórtica reumática de grau moderado", "Estenose valvar aórtica reumática de grau moderado. ");
        hashCategoryReport.put("Estenose valvar aórtica reumática de grau importante", "Estenose valvar aórtica reumática de grau importante. ");
        hashCategoryReport.put("<html>Dupla lesão valvar aórtica degenerativa - <b>DEFINIR</b></html>", "Dupla lesão valvar aórtica degenerativa (estenose " + stenosisAorticValve + " e insuficiência " + insufficiencyAorticValve + "). ");
        hashCategoryReport.put("<html>Dupla lesão valvar aórtica reumática - <b>DEFINIR</b></html>", "Dupla lesão valvar aórtica reumática (estenose " + stenosisAorticValve + " e insuficiência " + insufficiencyAorticValve + "). ");
        hashCategoryReport.put("Insuficiência tricúspide discreta", "Insuficiência tricúspide discreta. ");
        hashCategoryReport.put("Insuficiência tricúspide moderada", "Insuficiência tricúspide moderada. ");
        hashCategoryReport.put("Insuficiência tricúspide importante", "Insuficiência tricúspide importante. ");
        hashCategoryReport.put("Estenose valvar tricúspide de grau não significativo", "Estenose valvar tricúspide de grau não significativo. ");
        hashCategoryReport.put("Estenose valvar tricúspide de grau significativo", "Estenose valvar tricúspide de grau significativo. ");
        hashCategoryReport.put("<html>Dupla lesão valvar tricúspide - <b>DEFINIR</b></html>", "Dupla lesão valvar tricúspide (estenose " + stenosisTricuspidValve + " e insuficiência " + insufficiencyTricuspidValve + "). ");
        hashCategoryReport.put("Insuficiência pulmonar discreta", "Insuficiência pulmonar discreta. ");
        hashCategoryReport.put("Insuficiência pulmonar moderada", "Insuficiência pulmonar moderada. ");
        hashCategoryReport.put("Insuficiência pulmonar importante", "Insuficiência pulmonar importante. ");
        hashCategoryReport.put("Estenose valvar pulmonar de grau não significativo", "Estenose valvar pulmonar de grau não significativo. ");
        hashCategoryReport.put("Estenose valvar pulmonar de grau significativo", "Estenose valvar pulmonar de grau significativo. ");
        hashCategoryReport.put("<html>Dupla lesão valvar pulmonar - <b>DEFINIR</b></html>", "Dupla lesão valvar pulmonar (estenose " + stenosisPulmonaryValve + " e insuficiência " + insufficiencyPulmonaryValve + "). ");
        hashCategoryReport.put("Sinais ecocardiográficos de hipertensão pulmonar", "Sinais ecocardiográficos de hipertensão pulmonar. ");
        hashCategoryReport.put("Ectasia aórtica", "Ectasia aórtica. ");
        hashCategoryReport.put("Ectasia e ateromatose aórtica", "Ectasia e ateromatose aórtica. ");
        hashCategoryReport.put("Dilatação aneurismática da raiz aórtica", "Dilatação aneurismática da raiz aórtica. ");
        hashCategoryReport.put("Dilatação aneurismática da aorta ascendente", "Dilatação aneurismática da aorta ascendente. ");
        hashCategoryReport.put("Dilatação aneurismática do arco aórtico", "Dilatação aneurismática do arco aórtico. ");
        hashCategoryReport.put("Ateromatose aórtica", "Ateromatose aórtica. ");
        hashCategoryReport.put("Membrana da fossa oval aneurismática", "Membrana da fossa oval aneurismática. ");
        hashCategoryReport.put("Membrana da fossa redundante", "Membrana da fossa redundante. ");
        hashCategoryReport.put("Forame oval patente", "Forame oval patente. ");
        hashCategoryReport.put("Comunicação interatrial do tipo ostium secundum", "Comunicação interatrial do tipo ostium secundum. ");
        hashCategoryReport.put("Comunicação interatrial do tipo seio venoso", "Comunicação interatrial do tipo seio venoso. ");
        hashCategoryReport.put("Derrame pericárdico discreto", "Derrame pericárdico discreto. ");
        hashCategoryReport.put("Derrame pericárdico moderado", "Derrame pericárdico moderado. ");
        hashCategoryReport.put("Derrame pericárdico importante", "Derrame pericárdico importante. ");
        hashCategoryReport.put("Derrame pericárdico importante com sinais de restrição ao enchimento ventricular", "Derrame pericárdico importante com sinais de restrição ao enchimento ventricular. ");
        hashCategoryReport.put("Vide comentários", "Vide comentários. ");
        hashCategoryReport.put("Função sistólica biventricular preservada", "Função sistólica biventricular preservada. ");
    }
}