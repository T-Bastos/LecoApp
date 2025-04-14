/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.selectionui;

import javax.swing.JLabel;

/**
 *
 * @author Tibério
 */
public class JLabelSubcategory extends JLabel {
     
    public JLabelSubcategory (String text) {
        
        setText(text);
        setFont(this.getFont().deriveFont(0, 12));
    }
}
