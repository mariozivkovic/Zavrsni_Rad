/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import otpremnastanica.model.Zaposlenik;

/**
 *
 * @author lovre
 */
public class ZaposlenikRenderer extends JLabel implements ListCellRenderer<Zaposlenik>{

    public ZaposlenikRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Zaposlenik> list, Zaposlenik zaposlenik, int index, boolean isSelected, boolean cellHasFocus) {
       
        setText(zaposlenik.getIme() + " " + zaposlenik.getPrezime());

        boolean neMozeBrisati=zaposlenik.getOdrzavanja()!=null && !zaposlenik.getOdrzavanja().isEmpty();
        
        if (isSelected) {
            setBackground(new Color(37, 179, 213));
            if(neMozeBrisati){
                setForeground(Color.GRAY);
            }else{
                setForeground(Color.WHITE);
            }
            
        } else {
            setBackground(Color.WHITE);
            if(neMozeBrisati){
                setForeground(Color.GRAY);
            }else{
                setForeground(Color.BLACK);
            }
        }
        
       
        
        

        return this;
    }
    
    
    
    
    
    
}
