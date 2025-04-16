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
public class JLabelCategory extends JLabel {
  
    public JLabelCategory(String text) {
    
        setText(text);
        setFont(this.getFont().deriveFont(1, 18));
    }
}
