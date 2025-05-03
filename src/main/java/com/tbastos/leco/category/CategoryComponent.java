/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.category;

import com.tbastos.leco.selectionui.JComboBoxSubcategory;
import com.tbastos.leco.selectionui.JEditButton;
import com.tbastos.leco.selectionui.JLabelCategory;
import com.tbastos.leco.selectionui.JLabelSubcategory;
import com.tbastos.leco.selectionui.JNormalButton;
import com.tbastos.leco.selectionui.JResetButton;
import com.tbastos.leco.utility.Report;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Tibério
 */
public abstract class CategoryComponent {
    
    protected JLabelCategory jLabelCategory = null;
    protected ArrayList<JLabelSubcategory> jLabelSubcategories = null;
    protected ArrayList<JComboBoxSubcategory> jComboBoxSubcategories = null;
    protected HashMap<String, String> hashCategoryReport = null;
    protected ArrayList<JEditButton> arrayEditButton = null;
    protected JResetButton resetButton = null;
    protected JNormalButton normalButton = null;
    protected JTextArea textArea = null;
    protected JScrollPane jScrollTextArea = null;
    
    public ArrayList<JLabelSubcategory> getJLabelSubcategories() {
        
        return this.jLabelSubcategories;
    }
    
    public ArrayList<JComboBoxSubcategory> getJComboBoxSubcategories() {
        
        return this.jComboBoxSubcategories;
    }
    
    public JLabelCategory getJLabelCategory() {
        
        return this.jLabelCategory;
    }
    
    public String getCategoryTitle() {
        
        String categoryTitle = jLabelCategory.getText();
        
        if(categoryTitle.contains("<html>")) {
        
            categoryTitle = categoryTitle.replaceAll("<html>", "");
            categoryTitle = categoryTitle.replaceAll("</html>", "");
            categoryTitle = categoryTitle.replaceAll("<br>", "");
            categoryTitle = categoryTitle.replaceAll("</br>", "");
        } else {
            
            return categoryTitle;
        }
        
        return categoryTitle;
    }
    
    public JResetButton getResetButton() {
        
        if(this.resetButton == null) { 
        
            this.resetButton = new JResetButton();
            this.resetButton.setEnabled(false);
            
            this.resetButton.addActionListener((ActionEvent e) -> {
                
                int choiceConfirm = JOptionPane.showConfirmDialog(null, "Ao reiniciar a categoria, todas as opções irão voltar para o padrão de não preenchidas" , "Confirmação de reinício de categoria", JOptionPane.YES_NO_OPTION);

                if (choiceConfirm == JOptionPane.OK_OPTION) {

                    setIndex0ComboBoxes();   
                    getCategoryTextArea().setText("");
                }
            });
        }
        
        return this.resetButton; 
    }
    
    public JNormalButton getNormalButton() {
        
        if(this.normalButton == null) { 
        
            this.normalButton = new JNormalButton();
            this.normalButton.setEnabled(true);
            
            getNormalButton().addActionListener((ActionEvent e) -> {
        
                int choiceConfirm = JOptionPane.showConfirmDialog(null, "Normalizar categoria?" , "Confirmação de normalização de categoria", JOptionPane.YES_NO_OPTION);

                if (choiceConfirm == JOptionPane.OK_OPTION) {

                    setIndex0ComboBoxes();
                    setNormalComboBoxes();   
                }
            });
        }
        
        return this.normalButton; 
    }
    
    public JScrollPane getCategoryTextAreaScrollPane() {
        
        if(this.jScrollTextArea == null) {
            
            getCategoryTextArea();
        }
        
        return jScrollTextArea;
    }
    
    public JTextArea getCategoryTextArea() {
        
        if(this.textArea == null) {
            
            textArea = new JTextArea();
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
            String placeholder = "Digite sua nota opcional aqui...";
            Color placeholderColor = Color.LIGHT_GRAY;
            Color textColor = Color.BLACK;
            Font italicFont = textArea.getFont().deriveFont(Font.ITALIC);
            Font normalFont = textArea.getFont().deriveFont(Font.PLAIN);
            textArea.setText(placeholder);
            textArea.setFont(italicFont);
            textArea.setForeground(placeholderColor);

            textArea.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textArea.getText().equals(placeholder)) {
                        
                        textArea.setText("");
                        textArea.setFont(normalFont);
                        textArea.setForeground(textColor);
                    } else if (textArea.getText().equals("")) {
                    
                        textArea.setFont(normalFont);
                        textArea.setForeground(textColor);
                    }
                }
            });
            textArea.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                
                    checkResetButton();
                    Report.getReport().updateReportPane();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    
                    checkResetButton();
                    Report.getReport().updateReportPane();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    
                    checkResetButton();
                    Report.getReport().updateReportPane();
                }
            });
            
            jScrollTextArea = new JScrollPane(textArea);
            jScrollTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            jScrollTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        }
        
        return textArea;
    }
    
    public String getCategoryText() {
        
        Iterator<JComboBoxSubcategory> iterator = this.jComboBoxSubcategories.iterator();
        String categoryText = "";
        
        while(iterator.hasNext()) {
            
            categoryText += this.hashCategoryReport.get(iterator.next().getSelectedItem().toString());
        }
        
        return categoryText;
    }
    
    public void setIndex0ComboBoxes() {
       
        Iterator<JComboBoxSubcategory> iterator = this.jComboBoxSubcategories.iterator();
        JComboBoxSubcategory comboBox;
        
        while(iterator.hasNext()) {
            
            comboBox = iterator.next();
            comboBox.setSelectedIndex(0); 
        }
    }
    
    public int checkResetButton() {
    
        Iterator<JComboBoxSubcategory> iterator = this.jComboBoxSubcategories.iterator();
        
        while(iterator.hasNext()) {
            
            if(iterator.next().getSelectedIndex() != 0 || (!getCategoryTextArea().getText().equals("") && !getCategoryTextArea().getText().equals("Digite sua nota opcional aqui..."))) {

                this.resetButton.setEnabled(true);
                return 1;
            }
        }
        
        this.resetButton.setEnabled(false);
        return 0;
    }
    
    public JEditButton getEditButtonByName(String buttonName) {
        
        Iterator<JEditButton> iterator = this.arrayEditButton.iterator();
        JEditButton jEditButton = null;
        
        while(iterator.hasNext()) {
            
            jEditButton = iterator.next();
            
            if(jEditButton.getName().equals(buttonName)) {
                
                break;
            }
        }
        
        return jEditButton;
    }
    
    public ArrayList<String> getCategoryTextArray() {
        
        ArrayList<String> categoryTextArray = new ArrayList<>();
        
        Iterator<JComboBoxSubcategory> iterator = this.jComboBoxSubcategories.iterator();
        String categoryTextPart;
        
        while(iterator.hasNext()){
        
            categoryTextPart = this.hashCategoryReport.get(iterator.next().getSelectedItem().toString());
            
            if(!categoryTextPart.equals("")) {
                
                categoryTextArray.add(categoryTextPart);
            }
        }
        
        return categoryTextArray;
    }
    
    public abstract void setNormalComboBoxes();
    protected abstract void setHashCategoryReport();
}
