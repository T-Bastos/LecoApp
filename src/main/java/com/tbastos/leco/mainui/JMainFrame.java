/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.mainui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Tibério
 */
public class JMainFrame extends JFrame {
    
    
    public JMainFrame() {
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width - 135, screenSize.height - 50);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        FlowLayout layoutFrame = new FlowLayout(FlowLayout.CENTER);
        setLayout(layoutFrame);
        setLocationRelativeTo(null);
    }
}
