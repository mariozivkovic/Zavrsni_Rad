/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package otpremnastanica.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileOutputStream;
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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import otpremnastanica.controller.ObradaBusotina;
import otpremnastanica.controller.ObradaOdrzavanje;
import otpremnastanica.controller.ObradaPosao;
import otpremnastanica.controller.ObradaPosaoBusotina;
import otpremnastanica.model.Busotina;
import otpremnastanica.model.Entitet;
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
    private void dodajPodatke() {
    // Umetanje podataka u lstPodaci
    var e = obrada.getEntitet();
    String[] podaci = {
                       e.getNapomena() != null ? e.getNapomena() : "", 
                       e.getTlakTubinga() != null ? "P(t)-" + e.getTlakTubinga() : "",
                       e.getTlakNaftovoda() != null ? "P(n)-" + e.getTlakNaftovoda() : "", 
                       e.getTlakCasinga() != null ? "P(c)-" + e.getTlakCasinga() : ""};
  
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
      
           e.setOdrzavanje((Odrzavanje)lstOdrzavanjaUBazi1.getSelectedValue());
        if(obrada.getEntitet().getNapomena()==null){
            e.setNapomena("");
        }
        
          if(obrada.getEntitet().getTlakTubinga()==null){
            e.setTlakTubinga(BigDecimal.ZERO);
        }
          
          if(obrada.getEntitet().getTlakNaftovoda()==null){
            e.setTlakNaftovoda(BigDecimal.ZERO);
        }
           if(obrada.getEntitet().getTlakCasinga()==null){
            e.setTlakCasinga( BigDecimal.ZERO);
        }
    }
        


       
         

     private void napuniView(){
           var e = obrada.getEntitet();
         cmbPosao.setSelectedItem(e.getPosao());
         cmbBusotine.setSelectedItem(e.getBusotina());
         
     



          
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
        btnIpisiUExcel = new javax.swing.JButton();

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

        jLabel5.setText("Posao:");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));

        lstOdrzavanjaUBazi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstOdrzavanjaUBazi1MouseClicked(evt);
            }
        });
        lstOdrzavanjaUBazi1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOdrzavanjaUBazi1ValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(lstOdrzavanjaUBazi1);

        btnDodaj.setText("Dodaj");
        btnDodaj.setBackground(new java.awt.Color(37, 179, 213));
        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(102, 102, 102));
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel8.setText("Busotina:");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));

        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        btnPromjeni.setText("Promjeni");
        btnPromjeni.setBackground(new java.awt.Color(37, 179, 213));
        btnPromjeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPromjeni.setForeground(new java.awt.Color(102, 102, 102));
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.setBackground(new java.awt.Color(37, 179, 213));
        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(102, 102, 102));
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        jLabel6.setText("Odrzavanje:");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));

        jLabel7.setText("Podaci:");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));

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

        jLabel9.setText("Do:");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));

        jLabel10.setText("Od:");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));

        btnIpisiUExcel.setBackground(new java.awt.Color(37, 179, 213));
        btnIpisiUExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIpisiUExcel.setForeground(new java.awt.Color(102, 102, 102));
        btnIpisiUExcel.setText("Ipiši u Excel");
        btnIpisiUExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIpisiUExcelActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbPosao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPromjeni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cmbBusotine, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addComponent(btnObrisi, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(btnIpisiUExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDodaj)
                                    .addComponent(btnPromjeni))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnObrisi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIpisiUExcel)
                                .addGap(150, 150, 150))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dpPocetniDatum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dpKrajnjiDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnPretraži)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)))
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

    public Odrzavanje getOdabranoOdrzavanje(){
        return lstOdrzavanjaUBazi1.getSelectedValue();
    }
    
    public PosaoBusotina getPosaoBusotina(){
        return lstPodaci.getSelectedValue();
    }
    
    public Busotina getOdabranuBusotinu(){
        return (Busotina) cmbBusotine.getSelectedItem();
    }
    public ObradaPosaoBusotina getObradaPosaoBusotina(){
          return this.obrada;
    }
    
   
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

    private void lstOdrzavanjaUBazi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstOdrzavanjaUBazi1MouseClicked
   

       if(evt.getClickCount()==2 ){
           ProzorInformacijeNaOdrzavanju pin = new ProzorInformacijeNaOdrzavanju(this);
           pin.setVisible(true);
       }
    
    }//GEN-LAST:event_lstOdrzavanjaUBazi1MouseClicked

    private void btnIpisiUExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIpisiUExcelActionPerformed
           JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
        jfc.setSelectedFile(new File(System.getProperty("user.home")
                + File.separator + "podaci.xlsx"));
        if (jfc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        try {

            Workbook workbook = new XSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file

            /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
            CreationHelper createHelper = workbook.getCreationHelper();

            // Create a Sheet
            Sheet sheet = workbook.createSheet("Podaci održavanja");

            // Create a Font for styling header cells
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setColor(IndexedColors.RED.getIndex());

            // Create a CellStyle with the font
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Create a Row
            Row headerRow = sheet.createRow(0);

            // Create cells
            Cell cell = headerRow.createCell(0);
            cell.setCellValue("Održavanje");
            cell.setCellStyle(headerCellStyle);
            
            cell = headerRow.createCell(1);
            cell.setCellValue("Bušotina");
            cell.setCellStyle(headerCellStyle);

            cell = headerRow.createCell(2);
            cell.setCellValue("Posao");
            cell.setCellStyle(headerCellStyle);

            cell = headerRow.createCell(3);
            cell.setCellValue("Napomena");
            cell.setCellStyle(headerCellStyle);

            cell = headerRow.createCell(4);
            cell.setCellValue("P(t)");
            cell.setCellStyle(headerCellStyle);
            
            cell = headerRow.createCell(5);
            cell.setCellValue("P(n)");
            cell.setCellStyle(headerCellStyle);
            
            cell = headerRow.createCell(6);
            cell.setCellValue("P(c)");
            cell.setCellStyle(headerCellStyle);

            // Create Other rows and cells with employees data
            int rowNum = 1;
            Row row;
            for(PosaoBusotina pb: obrada.read()){
           
                    
                
                row = sheet.createRow(rowNum++);

                row.createCell(0)
                        .setCellValue(pb.getOdrzavanje().datumZaposlenikToStrig());

                row.createCell(1)
                        .setCellValue(pb.getBusotina().getNaziv());

                row.createCell(2)
                        .setCellValue(pb.getPosao().getNaziv());

                row.createCell(3)
                        .setCellValue(pb.getNapomena());
                if (pb.getTlakTubinga() != null) {
                 row.createCell(4)
                        
                        .setCellValue( pb.getTlakTubinga().doubleValue());
                }
                if (pb.getTlakNaftovoda()!= null) {
                   row.createCell(5)
                        .setCellValue( pb.getTlakNaftovoda().doubleValue());
                }
                if (pb.getTlakCasinga() != null) {
                     row.createCell(6)
                        .setCellValue( pb.getTlakCasinga().doubleValue());
                }

            
            }

            row = sheet.createRow(rowNum);
            cell = row.createCell(3);
            CellStyle style = workbook.createCellStyle();
            DataFormat format = workbook.createDataFormat();
            style.setDataFormat(format.getFormat("0.00"));
            cell.setCellStyle(style);
            cell.setCellFormula("sum(G2:G" + (rowNum) + ")");

            // Resize all columns to fit the content size
            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i);
            }

            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream(jfc.getSelectedFile());
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", jfc.getSelectedFile().getAbsolutePath());
            builder.redirectErrorStream(true);
            Process p = builder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnIpisiUExcelActionPerformed
    
 private void ucitajOdrzavanja(){
        DefaultListModel<Odrzavanje> m = new DefaultListModel<>();
       
     m.addAll( obradaOd.read());
        
      
        lstOdrzavanjaUBazi1.setModel(m);
        lstOdrzavanjaUBazi1.repaint();
    
        
    }
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIpisiUExcel;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPretraziOd;
    private javax.swing.JButton btnPretraži;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Busotina> cmbBusotine;
    private javax.swing.JComboBox<Posao> cmbPosao;
    private com.github.lgooddatepicker.components.DatePicker dpKrajnjiDatum;
    private com.github.lgooddatepicker.components.DatePicker dpPocetniDatum;
    private com.github.lgooddatepicker.components.DatePicker dpPretraziDatum;
    private javax.swing.JLabel jLabel10;
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
    // End of variables declaration//GEN-END:variables
}
