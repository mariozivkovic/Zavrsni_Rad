/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package otpremnastanica.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.event.KeyEvent;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import otpremnastanica.controller.ObradaOdrzavanje;
import otpremnastanica.controller.ObradaZaposlenik;
import otpremnastanica.model.Odrzavanje;
import otpremnastanica.model.Zaposlenik;
import otpremnastanica.util.Aplikacija;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ProzorOdrzavanje extends javax.swing.JFrame {
    
    private ObradaOdrzavanje obrada;
    private ObradaZaposlenik obradaZaposlenik;

    /**
     * Creates new form ProzorOdrzavanje
     */
    public ProzorOdrzavanje() {
        initComponents();
        obrada = new ObradaOdrzavanje();
        obradaZaposlenik = new ObradaZaposlenik();
         setTitle(Aplikacija.NAZIV_APP + ": " + 
                Aplikacija.OPERATER.getImePrezime() + ": Održavanja");
         definirajDatum();
         ucitajZaposlenike();
         ucitaj();
    }
    private void napuniView(){
           var e = obrada.getEntitet();
             if(e.getDatum()!=null){
                 LocalDate ld = e.getDatum()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        dpDatum.setDate(ld);
        }else{
            dpDatum.setDate(null);
        }
        
       cmbZaposlenici.setSelectedItem(e.getZaposlenik());
        
    }
    private void ucitajZaposlenike(){
        
         DefaultComboBoxModel<Zaposlenik> m
                = new DefaultComboBoxModel<>();
        Zaposlenik z = new Zaposlenik();
        z.setSifra(0);
        z.setIme("Nije");
        z.setPrezime("odabrano");
        m.addElement(z);
        m.addAll(new ObradaZaposlenik().read());
        cmbZaposlenici.setModel(m);
        cmbZaposlenici.repaint();
    }
    
    private void definirajDatum(){
        DatePickerSettings dps = 
                new DatePickerSettings(new Locale("hr","HR"));
       dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
       dps.setTranslationClear("Očisti");
       dps.setTranslationToday("Danas");
       dpDatum.setSettings(dps);
    }
    
     private void ucitaj(){
           DefaultListModel<Odrzavanje> m = new DefaultListModel<>();
       
        m.addAll(obrada.read(txtUvjet.getText(), chbTraziOdPocetkaDatuma.isSelected()));
        lstPodaci.setModel(m);
           
        lstPodaci.repaint();
    }
     
     private void napuniModel(){
         var e = obrada.getEntitet();
         e.setDatum(dpDatum.getDate()!=null
                            ? 
                            Date.from(dpDatum.getDate()
                            .atStartOfDay()
                            .atZone(ZoneId.systemDefault())
                            .toInstant())
                            : null);
         e.setZaposlenik((Zaposlenik) cmbZaposlenici.getSelectedItem());
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        txtUvjet = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dpDatum = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbZaposlenici = new javax.swing.JComboBox<>();
        chbTraziOdPocetkaDatuma = new javax.swing.JCheckBox();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));

        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        txtUvjet.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));
        txtUvjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjetActionPerformed(evt);
            }
        });
        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
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
        jLabel1.setText("Datum:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Zaposlenik:");

        chbTraziOdPocetkaDatuma.setText("Traži od početka datuma");

        btnDodaj.setBackground(new java.awt.Color(37, 179, 213));
        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(102, 102, 102));
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(chbTraziOdPocetkaDatuma, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(dpDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbZaposlenici, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPromjeni))
                    .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chbTraziOdPocetkaDatuma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbZaposlenici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrisi)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void txtUvjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjetActionPerformed

    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            ucitaj();
        }
    }//GEN-LAST:event_txtUvjetKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ucitaj();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new Odrzavanje());
        napuniModel();
        try {
            obrada.create();
            ucitaj();
        } catch (OtpremnaStanicaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
        


    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite održavanje");

            return;
        }
        napuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (OtpremnaStanicaException ex) {
            JOptionPane.showMessageDialog(getRootPane(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(getRootPane(), "Prvo odaberite održavanje");

            return;
        }

        if(JOptionPane.showConfirmDialog(getRootPane(), "Sigurno obrisati "
            + obrada.getEntitet().getDatum() + "?", "Brisanje", JOptionPane.YES_NO_OPTION,
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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JCheckBox chbTraziOdPocetkaDatuma;
    private javax.swing.JComboBox<Zaposlenik> cmbZaposlenici;
    private com.github.lgooddatepicker.components.DatePicker dpDatum;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Odrzavanje> lstPodaci;
    private javax.swing.JTextField txtUvjet;
    // End of variables declaration//GEN-END:variables
}
