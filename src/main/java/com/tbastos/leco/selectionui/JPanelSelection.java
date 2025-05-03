/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.selectionui;

import com.tbastos.leco.category.CategoryComponent;
import java.awt.Dimension;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Tibério
 */
public class JPanelSelection extends JPanel{

    private final int X_PANEL1 = 450;
    private final int Y_PANEL1 = 5650;
    
    public JPanelSelection() {
        
        setPreferredSize(new Dimension(X_PANEL1, Y_PANEL1));
        MigLayout layoutPanel1 = new MigLayout("wrap 3", "[][][]", "");
        setLayout(layoutPanel1);    
    }
    
    public void addCategory(CategoryComponent category) {
        
        add(category.getJLabelCategory(), "split 3");
        add(category.getResetButton());
        add(category.getNormalButton());
        add(new JLabel(), "span 2");
        Iterator<JLabelSubcategory> iteratorL = category.getJLabelSubcategories().iterator();
        Iterator<JComboBoxSubcategory> iteratorCB = category.getJComboBoxSubcategories().iterator();
        JComboBoxSubcategory comboBox;
        
        while(iteratorL.hasNext() && iteratorCB.hasNext()) {
            
            JLabelSubcategory label = iteratorL.next();
            add(label);
            comboBox = iteratorCB.next();
            add(comboBox, "h pref!, w pref!");      
            if(comboBox.getName() != null) {
            
                add(category.getEditButtonByName(comboBox.getName()));
            } else {
                
                add(new JLabel());
            }
        }
        
        add(new JLabel());
        add(category.getCategoryTextAreaScrollPane(), "h 60!, growx");
        add(new JLabel());
    }
}
