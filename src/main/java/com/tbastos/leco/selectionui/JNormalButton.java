/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.selectionui;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author INCOREL
 */
public class JNormalButton extends JButton {

    private final int X_JBUTTON = 30; 
    private final int Y_JBUTTON = 30; 
    
    public JNormalButton() {
        
        setPreferredSize(new Dimension(X_JBUTTON, Y_JBUTTON));
        setIcon(new ImageIcon(getClass().getResource("/newfile-normal.png")));
    }    
}
