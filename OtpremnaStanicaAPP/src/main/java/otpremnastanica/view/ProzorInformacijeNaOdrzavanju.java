/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package otpremnastanica.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import otpremnastanica.controller.ObradaPosaoBusotina;
import otpremnastanica.model.PosaoBusotina;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ProzorInformacijeNaOdrzavanju extends javax.swing.JFrame {
    
    private ProzorPodaci prozorPodaci;
    private DecimalFormat df;
  
    
    public ProzorInformacijeNaOdrzavanju(ProzorPodaci prozorPodaci) {
        initComponents();
        this.prozorPodaci = prozorPodaci;
         DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("hr", "HR"));
        df = new DecimalFormat("###,##0.00",dfs);
        lblImeZaposlenika.setText(prozorPodaci.getOdabranoOdrzavanje().datumZaposlenikToStrig());
        lblNazivBusotine.setText(prozorPodaci.getOdabranuBusotinu().getNaziv());
        
        var pin = prozorPodaci.getPosaoBusotina();
        
        txtNapomena.setText(pin.getNapomena());
        
        try {
            txtTlakTubinga.setText(df.format(pin.getTlakTubinga()));
        } catch (Exception e) {
             pin.setTlakTubinga(BigDecimal.ZERO);
        }
         try {
            txtTlakNaftovoda.setText(df.format(pin.getTlakNaftovoda()));
        } catch (Exception e) {
             pin.setTlakNaftovoda(BigDecimal.ZERO);
        }
          try {
            txtTlakCasinga.setText(df.format(pin.getTlakCasinga()));
        } catch (Exception e) {
             pin.setTlakCasinga(BigDecimal.ZERO);
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTlakCasinga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNapomena = new javax.swing.JTextField();
        txtTlakTubinga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTlakNaftovoda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnPromjeni = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblNazivBusotine = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblImeZaposlenika = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtTlakCasinga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTlakCasinga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Napomena:");

        txtNapomena.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));

        txtTlakTubinga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTlakTubinga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Tlak tubinga:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Tlak naftovoda:");

        txtTlakNaftovoda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTlakNaftovoda.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Tlak casinga:");

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(37, 179, 213));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Bušotina:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Zaposlenik:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPromjeni, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(txtTlakCasinga)
                        .addComponent(txtTlakNaftovoda)
                        .addComponent(txtTlakTubinga, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNazivBusotine, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImeZaposlenika, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblImeZaposlenika, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNazivBusotine, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTlakTubinga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTlakNaftovoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTlakCasinga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPromjeni)
                .addGap(48, 48, 48))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
         if(prozorPodaci.getOdabranoOdrzavanje()==null){
        
         }
       
        var pin = prozorPodaci.getPosaoBusotina();
        pin.setNapomena(txtNapomena.getText());
           try {
                pin.setTlakTubinga(BigDecimal.valueOf(df.parse
        (txtTlakTubinga.getText()).doubleValue()));
            } catch (ParseException ex) {
                pin.setTlakTubinga(BigDecimal.ZERO);
            }
           
              try {
                pin.setTlakNaftovoda(BigDecimal.valueOf(df.parse
        (txtTlakNaftovoda.getText()).doubleValue()));
            } catch (ParseException ex) {
                pin.setTlakNaftovoda(BigDecimal.ZERO);
            }
              
                 try {
                pin.setTlakCasinga(BigDecimal.valueOf(df.parse
        (txtTlakCasinga.getText()).doubleValue()));
            } catch (ParseException ex) {
                pin.setTlakCasinga(BigDecimal.ZERO);
            }
                 try {
            prozorPodaci.getObradaPosaoBusotina().kontrolaZaposlenika();
                 dispose();
        } catch (OtpremnaStanicaException e) {
            JOptionPane.showMessageDialog(getRootPane(), "Zaposlenik" +
                    
                    " nema napomenu");
        }
               
        
    }//GEN-LAST:event_btnPromjeniActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblImeZaposlenika;
    private javax.swing.JLabel lblNazivBusotine;
    private javax.swing.JTextField txtNapomena;
    private javax.swing.JTextField txtTlakCasinga;
    private javax.swing.JTextField txtTlakNaftovoda;
    private javax.swing.JTextField txtTlakTubinga;
    // End of variables declaration//GEN-END:variables
}
