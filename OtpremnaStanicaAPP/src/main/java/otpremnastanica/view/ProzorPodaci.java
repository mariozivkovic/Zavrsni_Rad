/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package otpremnastanica.view;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import otpremnastanica.controller.ObradaBusotina;
import otpremnastanica.controller.ObradaOdrzavanje;
import otpremnastanica.controller.ObradaPosao;
import otpremnastanica.controller.ObradaPosaoBusotina;
import otpremnastanica.model.Busotina;
import otpremnastanica.model.NaftnoPolje;
import otpremnastanica.model.Odrzavanje;
import otpremnastanica.model.Posao;
import otpremnastanica.model.PosaoBusotina;
import otpremnastanica.model.Zaposlenik;
import otpremnastanica.util.Aplikacija;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ProzorPodaci extends javax.swing.JFrame{

        private ObradaPosaoBusotina obrada;
       
        private DecimalFormat df;
        private ObradaOdrzavanje obradaOd;
        
    /**
     * Creates new form ProzorPodaci
     */
    public ProzorPodaci() {
        initComponents();
        obrada = new ObradaPosaoBusotina();
        obradaOd = new ObradaOdrzavanje();
       
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("hr", "HR"));
        df = new DecimalFormat("###,##0.00",dfs);

         setTitle(Aplikacija.NAZIV_APP + ": " + 
                Aplikacija.OPERATER.getImePrezime() + ": Podaci");
         ucitajOdrzavanja();
         ucitajBusotine();
         ucitajPoslove();
         ucitaj();
    }
    private void ucitajBusotine(){
        DefaultComboBoxModel<Busotina> m = new DefaultComboBoxModel<>();
        Busotina b = new Busotina();
        b.setSifra(0);
        b.setNaziv("Nije odabrano");
        m.addElement(b);
        m.addAll(new ObradaBusotina().read());
        cmbBusotine.setModel(m);
        cmbBusotine.repaint();
    }
   private void ucitajPoslove(){
         DefaultComboBoxModel<Posao> m
                = new DefaultComboBoxModel<>();
         Posao p = new Posao();
         p.setSifra(0);
         p.setNaziv("Nije odabrano");
         m.addElement(p);
         m.addAll(new ObradaPosao().read());
         cmbPosao.setModel(m);
         cmbPosao.repaint();
    }
 
    private void napuniModel(){
         var e = obrada.getEntitet();
         
        e.setPosao((Posao)cmbPosao.getSelectedItem());
        e.setBusotina((Busotina)cmbBusotine.getSelectedItem());
        e.setNapomena(txtNapomena.getText());
            try {
                e.setTlakTubinga(BigDecimal.valueOf(df.parse
        (txtTlakTubinga.getText()).doubleValue()));
            } catch (ParseException ex) {
                e.setTlakTubinga(BigDecimal.ZERO);
            }
            try {
                e.setTlakNaftovoda(BigDecimal.valueOf(df.parse
        (txtTlakNaftovoda.getText()).doubleValue()));
            } catch (ParseException ex) {
                e.setTlakNaftovoda(BigDecimal.ZERO);
            }
             try {
                e.setTlakCasinga(BigDecimal.valueOf(df.parse
        (txtTlakCasinga.getText()).doubleValue()));
            } catch (ParseException ex) {
                e.setTlakCasinga(BigDecimal.ZERO);
            }
           e.setOdrzavanje((Odrzavanje)lstOdrzavanjaUBazi1.getSelectedValue());
     
        
        
    
       
     }
     private void napuniView(){
           var e = obrada.getEntitet();
         cmbPosao.setSelectedItem(e.getPosao());
         cmbBusotine.setSelectedItem(e.getBusotina());
         txtNapomena.setText(e.getNapomena());
         try {
             txtTlakTubinga.setText(df.format(e.getTlakTubinga()));
         } catch (Exception ex) {
             txtTlakTubinga.setText("");
         }
          try {
             txtTlakNaftovoda.setText(df.format(e.getTlakNaftovoda()));
         } catch (Exception ex) {
             txtTlakNaftovoda.setText("");
         }
           try {
             txtTlakCasinga.setText(df.format(e.getTlakCasinga()));
         } catch (Exception ex) {
             txtTlakCasinga.setText("");
         }
          
        DefaultListModel<Odrzavanje> m = new DefaultListModel<>();
        
        if(e.getOdrzavanje()!=null){
            m.addElement( e.getOdrzavanje());
        }
        
         
      
         lstOdrzavanjaUBazi1.setModel(m);
       lstOdrzavanjaUBazi1.repaint();
         
        
     
    } 

      private void ucitaj(){
        
          DefaultListModel<PosaoBusotina> m = new DefaultListModel<>();
        m.addAll(obrada.read(txtUvjet2.getText()));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNapomena = new javax.swing.JTextField();
        txtTlakTubinga = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTlakNaftovoda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTlakCasinga = new javax.swing.JTextField();
        cmbPosao = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtUvjet1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstOdrzavanjaUBazi1 = new javax.swing.JList<>();
        btnDodaj = new javax.swing.JButton();
        cmbBusotine = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        txtUvjet2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        chbTraziOdPocetkaDatuma = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        txtTlakCasinga.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTlakCasinga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Posao:");

        txtUvjet1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));
        txtUvjet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjet1ActionPerformed(evt);
            }
        });
        txtUvjet1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjet1KeyPressed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(37, 179, 213));
        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("🔍");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lstOdrzavanjaUBazi1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOdrzavanjaUBazi1ValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lstOdrzavanjaUBazi1);

        btnDodaj.setBackground(new java.awt.Color(37, 179, 213));
        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(102, 102, 102));
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Busotina:");

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnPromjeni.setBackground(new java.awt.Color(37, 179, 213));
        btnPromjeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPromjeni.setForeground(new java.awt.Color(102, 102, 102));
        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setBackground(new java.awt.Color(37, 179, 213));
        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(102, 102, 102));
        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        txtUvjet2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));
        txtUvjet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjet2ActionPerformed(evt);
            }
        });
        txtUvjet2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjet2KeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(37, 179, 213));
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("🔍");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        chbTraziOdPocetkaDatuma.setText("Traži od početka datuma");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Odrzavanje:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Podaci:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(txtTlakCasinga)
                                .addComponent(txtTlakNaftovoda)
                                .addComponent(txtTlakTubinga)
                                .addComponent(txtNapomena)
                                .addComponent(cmbPosao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnDodaj)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnPromjeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(cmbBusotine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addComponent(jLabel6))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtUvjet2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(chbTraziOdPocetkaDatuma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chbTraziOdPocetkaDatuma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtUvjet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane5))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbPosao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbBusotine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDodaj)
                                .addComponent(btnPromjeni))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnObrisi))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUvjet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjet1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjet1ActionPerformed

    private void txtUvjet1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjet1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ucitajOdrzavanja();
        }
    }//GEN-LAST:event_txtUvjet1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ucitajOdrzavanja();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
       obrada.setEntitet(new PosaoBusotina());
       napuniModel();
        
            try {
                obrada.create();
                ucitajOdrzavanja();
                ucitaj();
               
            } catch (OtpremnaStanicaException ex) {
                JOptionPane.showMessageDialog(getParent(), ex.getPoruka());
            }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void lstOdrzavanjaUBazi1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOdrzavanjaUBazi1ValueChanged
          if(evt.getValueIsAdjusting()){
            return;
        }
        if(lstOdrzavanjaUBazi1.getSelectedValue()==null){
            return;
        }

        obradaOd.setEntitet(lstOdrzavanjaUBazi1.getSelectedValue());
        
    }//GEN-LAST:event_lstOdrzavanjaUBazi1ValueChanged

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
       if(evt.getValueIsAdjusting()){
            return;
        }
        if(lstPodaci.getSelectedValue()==null){
            return;
        }

        obrada.setEntitet(lstPodaci.getSelectedValue());

       napuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(getParent(), "Prvo odaberite podatke");

           return;
            
      
        }
      
    
        
        napuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (OtpremnaStanicaException ex) {
            JOptionPane.showMessageDialog(getParent(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(getParent(), "Prvo odaberite održavanje");

            return;
        }

        if(JOptionPane.showConfirmDialog(getParent(), "Sigurno obrisati "
            + obrada.getEntitet().getOdrzavanje() + obrada.getEntitet().getObrisi() + "?", "Brisanje", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE)== JOptionPane.NO_OPTION){
        return;
        }

        try {
            obrada.delete();
            ucitaj();
        } catch (OtpremnaStanicaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void txtUvjet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjet2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjet2ActionPerformed

    private void txtUvjet2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjet2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ucitaj();
        }
    }//GEN-LAST:event_txtUvjet2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ucitaj();
    }//GEN-LAST:event_jButton2ActionPerformed
    
 private void ucitajOdrzavanja(){
        DefaultListModel<Odrzavanje> m = new DefaultListModel<>();
        m.addAll(obradaOd.read(txtUvjet1.getText()));
        lstOdrzavanjaUBazi1.setModel(m);
        lstOdrzavanjaUBazi1.repaint();
    
        
    }
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JCheckBox chbTraziOdPocetkaDatuma;
    private javax.swing.JComboBox<Busotina> cmbBusotine;
    private javax.swing.JComboBox<Posao> cmbPosao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Odrzavanje> lstOdrzavanjaUBazi1;
    private javax.swing.JList<PosaoBusotina> lstPodaci;
    private javax.swing.JTextField txtNapomena;
    private javax.swing.JTextField txtTlakCasinga;
    private javax.swing.JTextField txtTlakNaftovoda;
    private javax.swing.JTextField txtTlakTubinga;
    private javax.swing.JTextField txtUvjet1;
    private javax.swing.JTextField txtUvjet2;
    // End of variables declaration//GEN-END:variables
}
