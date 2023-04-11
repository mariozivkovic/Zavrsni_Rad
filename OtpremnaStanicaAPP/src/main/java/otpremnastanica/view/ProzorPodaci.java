/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package otpremnastanica.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        private SimpleDateFormat sdf;
        private ObradaOdrzavanje obradaOd;
        
    /**
     * Creates new form ProzorPodaci
     */
    public ProzorPodaci() {
        initComponents();
        obrada = new ObradaPosaoBusotina();
        obradaOd = new ObradaOdrzavanje();
        sdf = new SimpleDateFormat("dd.MM.YYYY", new Locale("hr","HR"));
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("hr", "HR"));
        df = new DecimalFormat("###,##0.00",dfs);

         setTitle(Aplikacija.NAZIV_APP + ": " + 
                Aplikacija.OPERATER.getImePrezime() + ": Podaci");
         definirajDatumOd();
         definirajkrajnjiDatum();
         definirajpocetniDatum();
         ucitajOdrzavanja();
         ucitajBusotine();
         ucitajPoslove();
         ucitaj();
    }
    private void definirajDatumOd(){
        DatePickerSettings dps = 
                new DatePickerSettings(new Locale("hr","HR"));
       dps.setFormatForDatesCommonEra("dd.MM.yyyy");
       dps.setTranslationClear("Očisti");
       dps.setTranslationToday("Danas");
       dpPretraziDatum.setSettings(dps);
    }
     private void definirajkrajnjiDatum(){
        DatePickerSettings dps = 
                new DatePickerSettings(new Locale("hr","HR"));
       dps.setFormatForDatesCommonEra("dd.MM.yyyy");
       dps.setTranslationClear("Očisti");
       dps.setTranslationToday("Danas");
       dpKrajnjiDatum.setSettings(dps);
    }
     private void definirajpocetniDatum(){
        DatePickerSettings dps = 
                new DatePickerSettings(new Locale("hr","HR"));
       dps.setFormatForDatesCommonEra("dd.MM.yyyy");
       dps.setTranslationClear("Očisti");
       dps.setTranslationToday("Danas");
       dpPocetniDatum.setSettings(dps);
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
          
         m.addAll( obrada.read());
        
       
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
        jScrollPane5 = new javax.swing.JScrollPane();
        lstOdrzavanjaUBazi1 = new javax.swing.JList<>();
        btnDodaj = new javax.swing.JButton();
        cmbBusotine = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dpPocetniDatum = new com.github.lgooddatepicker.components.DatePicker();
        dpKrajnjiDatum = new com.github.lgooddatepicker.components.DatePicker();
        btnPretraži = new javax.swing.JButton();
        dpPretraziDatum = new com.github.lgooddatepicker.components.DatePicker();
        btnPretraziOd = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Odrzavanje:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Podaci:");

        btnPretraži.setText("Pretraži");
        btnPretraži.setBackground(new java.awt.Color(37, 179, 213));
        btnPretraži.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPretraži.setForeground(new java.awt.Color(102, 102, 102));
        btnPretraži.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretražiActionPerformed(evt);
            }
        });

        btnPretraziOd.setText("Pretraži");
        btnPretraziOd.setBackground(new java.awt.Color(37, 179, 213));
        btnPretraziOd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPretraziOd.setForeground(new java.awt.Color(102, 102, 102));
        btnPretraziOd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziOdActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Do:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Od:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dpPretraziDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPretraziOd)))
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
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(dpPocetniDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dpKrajnjiDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretraži)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jScrollPane5))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(dpPretraziDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPretraziOd))
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
                                .addComponent(btnObrisi))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dpKrajnjiDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPretraži)
                                    .addComponent(dpPocetniDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnPretražiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretražiActionPerformed
        if(dpPocetniDatum.getText().isEmpty() && dpKrajnjiDatum.getText().isEmpty()){
           JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite datum");

            return; 
       }
        
        
        DefaultListModel<PosaoBusotina> m = new DefaultListModel<>();
       m.addAll(obrada.read(dpPocetniDatum.getText(), dpKrajnjiDatum.getText()));
       
          
       lstPodaci.setModel(m);
       lstPodaci.repaint();
    }//GEN-LAST:event_btnPretražiActionPerformed

    private void btnPretraziOdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziOdActionPerformed
         if(dpPretraziDatum.getText().isEmpty()){
           JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite datum");

            return; 
       }
        
        
        DefaultListModel<Odrzavanje> m = new DefaultListModel<>();
       m.addAll(obrada.read(dpPretraziDatum.getText()));
       
          
       lstOdrzavanjaUBazi1.setModel(m);
       lstOdrzavanjaUBazi1.repaint();
    }//GEN-LAST:event_btnPretraziOdActionPerformed
    
 private void ucitajOdrzavanja(){
        DefaultListModel<Odrzavanje> m = new DefaultListModel<>();
       
     m.addAll( obradaOd.read());
        
      
        lstOdrzavanjaUBazi1.setModel(m);
        lstOdrzavanjaUBazi1.repaint();
    
        
    }
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretraziOd;
    private javax.swing.JButton btnPretraži;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Busotina> cmbBusotine;
    private javax.swing.JComboBox<Posao> cmbPosao;
    private com.github.lgooddatepicker.components.DatePicker dpKrajnjiDatum;
    private com.github.lgooddatepicker.components.DatePicker dpPocetniDatum;
    private com.github.lgooddatepicker.components.DatePicker dpPretraziDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Odrzavanje> lstOdrzavanjaUBazi1;
    private javax.swing.JList<PosaoBusotina> lstPodaci;
    private javax.swing.JTextField txtNapomena;
    private javax.swing.JTextField txtTlakCasinga;
    private javax.swing.JTextField txtTlakNaftovoda;
    private javax.swing.JTextField txtTlakTubinga;
    // End of variables declaration//GEN-END:variables
}
