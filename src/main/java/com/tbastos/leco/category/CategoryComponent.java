/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.category;

import com.tbastos.leco.selectionui.JComboBoxSubcategory;
import com.tbastos.leco.selectionui.JEditButton;
import com.tbastos.leco.selectionui.JLabelCategory;
import com.tbastos.leco.selectionui.JLabelSubcategory;
import com.tbastos.leco.selectionui.JResetButton;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JOptionPane;

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
        
        return this.jLabelCategory.getText();
    }
    
    public JResetButton getResetButton() {
        
        if(this.resetButton == null) { 
        
            this.resetButton = new JResetButton();
            this.resetButton.setEnabled(false);
            
            this.resetButton.addActionListener((ActionEvent e) -> {
                
                int choiceConfirm = JOptionPane.showConfirmDialog(null, "Ao reiniciar a categoria, todas as opções irão voltar para o padrão de não preenchidas" , "CONFIRMAÇÃO DE REINÍCIO DE CATEGORIA", JOptionPane.YES_NO_OPTION);

                if (choiceConfirm == JOptionPane.OK_OPTION) {

                    setIndex0ComboBoxes();   
                }
            });
        }
        
        return this.resetButton;
        
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
            
            if(iterator.next().getSelectedIndex() != 0) {
            
                this.resetButton.setEnabled(true);
                return 1;
            }
        }
        
        this.resetButton.setEnabled(false);
        return 0;
    }
    
    public abstract void setNormalComboBoxes();
    protected abstract void setCategoryListeners();
    protected abstract void setHashCategoryReport();
    
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
}
