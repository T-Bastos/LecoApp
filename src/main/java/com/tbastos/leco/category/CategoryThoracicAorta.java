/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tbastos.leco.category;

import com.tbastos.leco.selectionui.JComboBoxSubcategory;
import com.tbastos.leco.selectionui.JLabelCategory;
import com.tbastos.leco.selectionui.JLabelSubcategory;
import com.tbastos.leco.utility.Report;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Tibério
 */
public final class CategoryThoracicAorta extends CategoryComponent {

    private final JComboBoxSubcategory comboBoxSize;
    private final JComboBoxSubcategory comboBoxAtheroma;
    
    public CategoryThoracicAorta() {
          
        jLabelCategory = new JLabelCategory("Aorta torácica");
        jLabelSubcategories = new ArrayList<>();
        jComboBoxSubcategories = new ArrayList<>();
        
        jLabelSubcategories.add(new JLabelSubcategory("Tamanho")); 
        comboBoxSize = new JComboBoxSubcategory(new String[]{"", "Diâmetros normais para superfície corpórea e idade", "Ectasia da raiz aórtica", "Ectasia da aorta ascendente", "Ectasia do arco aórtico", "Ectasia da raiz aórtica e da aorta ascendente"});
        jComboBoxSubcategories.add(comboBoxSize);
        
        jLabelSubcategories.add(new JLabelSubcategory("Placa de ateroma")); 
        comboBoxAtheroma = new JComboBoxSubcategory(new String[]{"", "Ateroma em aorta ascendente", "Ateroma em arco aórtico", "Ateroma em aorta descendente", "Irregularidades parietais em aorta descendente"});
        jComboBoxSubcategories.add(comboBoxAtheroma);
        
        JLabelSubcategory notes = new JLabelSubcategory("Notas adicionais");
        notes.setName("Notes");
        jLabelSubcategories.add(notes);
        
        setHashCategoryReport();
        setCategoryListeners();
    }
    
    @Override
    protected void setCategoryListeners() {
    
        comboBoxSize.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
        
        comboBoxAtheroma.addItemListener((ItemEvent e) -> {
            
            if(e.getStateChange() == ItemEvent.SELECTED) {
                
                checkResetButton();
                Report.getReport().updateReportPane();
            }
        });
    }
    
    @Override
    protected void setHashCategoryReport() {
        
        hashCategoryReport = new HashMap<>();
        hashCategoryReport.put("", "");
        hashCategoryReport.put("Diâmetros normais para superfície corpórea e idade", "Com diâmetros normais para superfície corpórea e idade. ");
        hashCategoryReport.put("Ectasia da raiz aórtica", "Ectasia da raiz aórtica. Demais segmentos da aorta torácica com diâmetros normais. ");
        hashCategoryReport.put("Ectasia da aorta ascendente", "Ectasia da aorta ascendente. Demais segmentos da aorta torácica com diâmetros normais para superfície corpórea e idade. ");
        hashCategoryReport.put("Ectasia do arco aórtico", "Ectasia do arco aórtico. Demais segmentos da aorta torácica com diâmetros normais para superfície corpórea e idade. ");
        hashCategoryReport.put("Ectasia da raiz aórtica e da aorta ascendente", "Ectasia da raiz aórtica e da aorta ascendente. Arco aórtico com diâmetros normais para superfície corpórea e idade. ");
        hashCategoryReport.put("Ateroma em aorta ascendente", "Presença de placa de ateroma em aorta ascendente. ");
        hashCategoryReport.put("Ateroma em arco aórtico", "Presença de placa de ateroma em arco aórtico. ");
        hashCategoryReport.put("Ateroma em aorta descendente", "Presença de placa de ateroma em aorta descendente. ");
        hashCategoryReport.put("Irregularidades parietais em aorta descendente", "Irregularidades parietais em aorta descendente. ");
    }  
    
    @Override
    public void setNormalComboBoxes() {
        
        comboBoxSize.setSelectedIndex(1);
    }
}
