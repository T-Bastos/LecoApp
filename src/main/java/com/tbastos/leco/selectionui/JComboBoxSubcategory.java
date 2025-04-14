/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.selectionui;

import java.awt.Dimension;
import javax.swing.JComboBox;

/**
 *
 * @author Tibério
 */
public class JComboBoxSubcategory extends JComboBox {
    
    private final int X_COMBOBOX = 330;
    private final int Y_COMBOBOX = 20;
    
    public JComboBoxSubcategory(String[] options) {
    
        for(String option : options) {
        
            addItem(option);
        }
        
        setMaximumRowCount(7);
        setPreferredSize(new Dimension(X_COMBOBOX, Y_COMBOBOX));
    }
}
