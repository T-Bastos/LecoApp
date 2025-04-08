/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.selectionui;

import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Tibério
 */
public class JLabelSubcategory extends JLabel {
    
    private final int X_JLABEL = 240;
    private final int Y_JLABEL = 20;
    
    public JLabelSubcategory (String text) {
        
        setText(text);
        setFont(this.getFont().deriveFont(0, 12));
        setPreferredSize(new Dimension(X_JLABEL, Y_JLABEL));
    }
}
