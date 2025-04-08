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
public class JLabelCategory extends JLabel {
    
    private final int X_JLABEL = 485;
    private final int Y_JLABEL = 30;
    
    public JLabelCategory(String text) {
    
        setText(text);
        setFont(this.getFont().deriveFont(1, 18));
        setPreferredSize(new Dimension(X_JLABEL, Y_JLABEL));
    }
}
