/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.selectionui;

import com.tbastos.leco.category.CategoryComponent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author Tibério
 */
public class JPanelSelection extends JPanel{

    private final int X_PANEL1 = 450;
    private final int Y_PANEL1 = 3550;
    
    public JPanelSelection() {
        
        setPreferredSize(new Dimension(X_PANEL1, Y_PANEL1));
        FlowLayout layoutPanel1 = new FlowLayout(FlowLayout.LEFT);
        setLayout(layoutPanel1);    
    }
    
    public void addCategory(CategoryComponent category) {
        
        add(category.getResetButton());
        add(category.getJLabelCategory());
        Iterator<JLabelSubcategory> iteratorL = category.getJLabelSubcategories().iterator();
        Iterator<JComboBoxSubcategory> iteratorCB = category.getJComboBoxSubcategories().iterator();
        JComboBoxSubcategory comboBox;
        
        while(iteratorL.hasNext()) {
            
            add(iteratorL.next());
            comboBox = iteratorCB.next();
            add(comboBox);      
            if(comboBox.getName() != null) {
            
                add(category.getEditButtonByName(comboBox.getName()));
            }
        }
    }
}
