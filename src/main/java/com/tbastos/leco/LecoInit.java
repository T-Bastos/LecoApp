/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco;

import com.tbastos.leco.mainui.LecoUI;
import java.text.DateFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Tibério
 */
public class LecoInit {
    
    public static void main(String[] args) {
           
        Locale.setDefault(new Locale("pt", "BR"));
        LecoUI ui = new LecoUI(); 
        ui.initUI();
    }    
}
