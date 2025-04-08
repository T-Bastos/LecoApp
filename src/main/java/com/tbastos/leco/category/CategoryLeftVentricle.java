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
public final class CategoryLeftVentricle extends CategoryComponent {
    
    private String akinesia = "XXX";
    private String hypokinesia = "XXX";
    private String wallOrSegment = "XXX";
    private String strain = "XXX";
    private final JComboBoxSubcategory comboBoxSize;
    private final JComboBoxSubcategory comboBoxSys;
    private final JComboBoxSubcategory comboBoxDys;
    private final JComboBoxSubcategory comboBoxDysAneu;
    private final JComboBoxSubcategory comboBoxMov;
    private final JComboBoxSubcategory comboBoxStrain;
    private final JEditButton editButtonSys;
    private final JEditButton editButtonDysAneu;
    private final JEditButton editButtonStrain;
    
    public CategoryLeftVentricle() {
        
        jLabelCategory = new JLabelCategory("Ventrículo esquerdo");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        arrayEditButton = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Tamanho")); 
        comboBoxSize = new JComboBoxSubcategory(new String[]{"", "Normal", "Discreto", "Moderado", "Importante"});
        jComboBoxSubcategories.add(comboBoxSize);
        
        jLabelSubcategories.add(new JLabelSubcategory("Função sistólica")); 
        comboBoxSys = new JComboBoxSubcategory(new String[]{"", "Global normal", "Hipocinesia Difusa - Discreto", "Hipocinesia Difusa - Moderado", "Hipocinesia Difusa - Importante", "<html>Alteração contrátil segmentar - Preservada - <b>DEFINIR</b></html>", "<html>Alteração contrátil segmentar - Discreto - <b>DEFINIR</b></html>", "<html>Alteração contrátil segmentar - Moderado - <b>DEFINIR</b></html>", "<html>Alteração contrátil segmentar - Importante - <b>DEFINIR</b></html>"});
        comboBoxSys.setName("Sys");
        jComboBoxSubcategories.add(comboBoxSys);
        editButtonSys = new JEditButton();
        editButtonSys.setName("Sys");
        arrayEditButton.add(editButtonSys);
        
        jLabelSubcategories.add(new JLabelSubcategory("Discinesia/Aneurisma")); 
        comboBoxDysAneu = new JComboBoxSubcategory(new String[]{"", "Discinesia de toda a região apical", "<html>Discinesia do segmento - <b>DEFINIR</b></html>", "<html>Discinesia da parede - <b>DEFINIR</b></html>", "Aneurisma de toda a região apical", "<html>Aneurisma do segmento - <b>DEFINIR</b></html>", "<html>Aneurisma da parede - <b>DEFINIR</b></html>", "<html>Aneurisma em dedo de luva do segmento - <b>DEFINIR</b></html>"});
        comboBoxDysAneu.setName("DysAneu");
        jComboBoxSubcategories.add(comboBoxDysAneu);
        editButtonDysAneu = new JEditButton();
        editButtonDysAneu.setName("DysAneu");
        arrayEditButton.add(editButtonDysAneu);
        
        jLabelSubcategories.add(new JLabelSubcategory("Função distólica")); 
        comboBoxDys = new JComboBoxSubcategory(new String[]{"", "VE normal, ao DT", "Sem sinais de aumento - VE", "Padrão de alteração do relaxamento", "DD - VE grau I", "DD - VE grau II", "DD - VE grau III(restritivo)", "Sinais de aumento - VE", "VE não avaliada por arritmia", "VE não avaliada - Marcapasso"});
        jComboBoxSubcategories.add(comboBoxDys);
        
        jLabelSubcategories.add(new JLabelSubcategory("Movimento assincrônico SIV")); 
        comboBoxMov = new JComboBoxSubcategory(new String[]{"", "Presente"});
        jComboBoxSubcategories.add(comboBoxMov);
        
        jLabelSubcategories.add(new JLabelSubcategory("Strain")); 
        comboBoxStrain = new JComboBoxSubcategory(new String[]{"", "<html>Com Strain - <b>DEFINIR</b></html>"});
        comboBoxStrain.setName("Strain");
        jComboBoxSubcategories.add(comboBoxStrain);
        editButtonStrain = new JEditButton();
        editButtonStrain.setName("Strain");
        arrayEditButton.add(editButtonStrain);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
        
        editButtonSys.addActionListener((ActionEvent e) -> {
            
            fillFormSys();
        });
        
        comboBoxSys.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                akinesia = "XXX";
                hypokinesia = "XXX";
                
                if(comboBoxSys.getSelectedIndex() == 0 || comboBoxSys.getSelectedIndex() == 1 || comboBoxSys.getSelectedIndex() == 2 || comboBoxSys.getSelectedIndex() == 3 || comboBoxSys.getSelectedIndex() == 4) {
                    
                    editButtonSys.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonSys.setEnabled(true);
                    fillFormSys();
                }
            }
        });
        
        editButtonDysAneu.addActionListener((ActionEvent e) -> {
            
            fillFormDysAneu();
        });
                
        comboBoxDysAneu.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                wallOrSegment = "XXX";
                
                if(comboBoxDysAneu.getSelectedIndex() == 0 || comboBoxDysAneu.getSelectedIndex() == 1 || comboBoxDysAneu.getSelectedIndex() == 4) {
                    
                    editButtonDysAneu.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonDysAneu.setEnabled(true);
                    fillFormDysAneu();
                }
            }
        });
        
        editButtonStrain.addActionListener((ActionEvent e) -> {
            
            fillFormStrain();
        });
                
        comboBoxStrain.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                strain = "XXX";
                
                if(comboBoxStrain.getSelectedIndex() == 0) {
                    
                    editButtonStrain.setEnabled(false);
                    setHashCategoryReport();
                    Report.getReport().getAndUpdateReportPane();
                } else {
                    
                    editButtonStrain.setEnabled(true);
                    fillFormStrain();
                }
            }
        });
                       
        comboBoxSize.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxMov.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
        
        comboBoxDys.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().getAndUpdateReportPane();
            }
        });
    }
    
    private void fillFormStrain() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(strain);

        Object[] input = new Object[2];
        input[0] = "Valor absoluto do Strain:";
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

            strain = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormDysAneu() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(wallOrSegment);

        Object[] input = new Object[2];

        if(comboBoxDysAneu.getSelectedIndex() == 2) {

            input[0] = "Presença de discinesia do segmento:";
        } else if(comboBoxDysAneu.getSelectedIndex() == 3) {

            input[0] = "Presença de discinesia da parede:";
        } else if(comboBoxDysAneu.getSelectedIndex() == 5) {

            input[0] = "Presença de aunerisma do segmento:";
        } else if(comboBoxDysAneu.getSelectedIndex() == 6) {

            input[0] = "Presença de aunerisma da parede:";
        } else if(comboBoxDysAneu.getSelectedIndex() == 7) {
           
            input[0] = "Aneurisma em dedo de luva no segmento:";
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

            wallOrSegment = field1.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    private void fillFormSys() {
    
        JTextField field1 = new JTextField(10);
        field1.setText(akinesia);
        JTextField field2 = new JTextField(10);
        field2.setText(hypokinesia);

        Object[] input = new Object[4];
        input[0] = "Acinesia:";
        input[1] = field1;
        input[2] = "Hipocinesia:";
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

            akinesia = field1.getText();
            hypokinesia = field2.getText();
        }   
        
        setHashCategoryReport();
        Report.getReport().getAndUpdateReportPane();
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Normal", "Com dimensões normais. ");
        hashCategoryReport.put("Discreto", "Aumento discreto do ventrículo esquerdo. ");
        hashCategoryReport.put("Moderado", "Aumento moderado do ventrículo esquerdo. ");
        hashCategoryReport.put("Importante", "Aumento importante do ventrículo esquerdo. ");
        hashCategoryReport.put("Global normal", "Função sistólica global normal, sem alteração da contração segmentar. ");
        hashCategoryReport.put("Hipocinesia Difusa - Discreto", "Função sistólica reduzida em grau discreto, com hipocinesia miocárdica difusa. ");
        hashCategoryReport.put("Hipocinesia Difusa - Moderado", "Função sistólica reduzida em grau moderado, com hipocinesia miocárdica difusa. ");
        hashCategoryReport.put("Hipocinesia Difusa - Importante", "Função sistólica reduzida em grau importante, com hipocinesia miocárdica difusa. ");
        hashCategoryReport.put("<html>Alteração contrátil segmentar - Preservada - <b>DEFINIR</b></html>", "Função sistólica global preservada apesar de acinesia " + akinesia + "; hipocinesia " + hypokinesia + "; demais segmentos com contratilidade preservada. ");
        hashCategoryReport.put("<html>Alteração contrátil segmentar - Discreto - <b>DEFINIR</b></html>", "Com função sistólica reduzida em grau discreto, com acinesia " + akinesia + "; hipocinesia " + hypokinesia + "; demais segmentos miocárdicos com contratilidade preservada. ");
        hashCategoryReport.put("<html>Alteração contrátil segmentar - Moderado - <b>DEFINIR</b></html>", "Com função sistólica reduzida em grau moderado, com acinesia " + akinesia + "; hipocinesia " + hypokinesia + "; demais segmentos miocárdicos com contratilidade preservada.");
        hashCategoryReport.put("<html>Alteração contrátil segmentar - Importante - <b>DEFINIR</b></html>", "Com função sistólica reduzida em grau importante, com acinesia " + akinesia + "; hipocinesia " + hypokinesia + "; demais segmentos miocárdicos com contratilidade preservada. ");
        hashCategoryReport.put("Discinesia de toda a região apical", "Discinesia de toda a região apical do ventrículo esquerdo. ");
        hashCategoryReport.put("Aneurisma de toda a região apical", "Aneurisma de toda a região apical do ventrículo esquerdo. ");
        hashCategoryReport.put("<html>Aneurisma em dedo de luva do segmento - <b>DEFINIR</b></html>", "Aneurisma em dedo de luva no segmento " + wallOrSegment + ". ");
        hashCategoryReport.put("<html>Discinesia do segmento - <b>DEFINIR</b></html>", "Presença de discinesia do segmento " + wallOrSegment + ". ");
        hashCategoryReport.put("<html>Discinesia da parede - <b>DEFINIR</b></html>", "Presença de discinesia da parede " + wallOrSegment + ". ");
        hashCategoryReport.put("<html>Aneurisma do segmento - <b>DEFINIR</b></html>", "Presença de aneurisma do segmento " + wallOrSegment + ". ");
        hashCategoryReport.put("<html>Aneurisma da parede - <b>DEFINIR</b></html>", "Presença de aneurisma da parede " + wallOrSegment + ". ");
        hashCategoryReport.put("VE normal, ao DT", "Função diastólica do VE normal ao Doppler Tecidual. ");
        hashCategoryReport.put("Sem sinais de aumento - VE", "Não há sinais de aumento das pressões de enchimento do ventrículo esquerdo. ");
        hashCategoryReport.put("Padrão de alteração do relaxamento", "Padrão de alteração do relaxamento ventricular esquerdo. ");
        hashCategoryReport.put("DD - VE grau I", "Disfunção diastólica do VE de grau I. ");
        hashCategoryReport.put("DD - VE grau II", "Disfunção diastólica do VE de grau II. ");
        hashCategoryReport.put("DD - VE grau III(restritivo)", "Disfunção diastólica do VE de grau III (padrão restritivo). ");
        hashCategoryReport.put("Sinais de aumento - VE", "Há sinais de aumento das pressões de enchimento do ventrículo esquerdo. ");
        hashCategoryReport.put("VE não avaliada por arritmia", "Função diastólica do VE não avaliada por arritmia. ");
        hashCategoryReport.put("VE não avaliada - Marcapasso", "Função diastólica do VE não avaliada devido a ritmo de marcapasso. ");
        hashCategoryReport.put("VE não avaliada - Valvopatia mitral", "Função diastólica do VE não avaliada devido à presença de valvopatia mitral. ");
        hashCategoryReport.put("VE não avaliada - fusão das E e A", "Função diastólica do VE não avaliada devido à fusão das ondas E e A. ");
        hashCategoryReport.put("Presente", "Presença de movimento assincrônico do septo interventricular. ");
        hashCategoryReport.put("<html>Com Strain - <b>DEFINIR</b></html>", "Análise da deformação miocárdica do ventrículo esquerdo pela técnica do speckle tracking evidenciou strain global longitudinal com valor absoluto estimado em " + strain + "% (VR \u2265 18%). ");
    }         
    
    @Override
    public void setNormalComboBoxes() {
        
        editButtonSys.setEnabled(false);
        editButtonDysAneu.setEnabled(false);
        editButtonStrain.setEnabled(false);
        comboBoxSize.setSelectedIndex(1);
        comboBoxSys.setSelectedIndex(1);
        comboBoxDys.setSelectedIndex(1);
    }
}
