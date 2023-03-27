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
        private ObradaPosao obradaPosao;
        private DecimalFormat df;
        private ObradaOdrzavanje obradaOdrzavanje;
        private ObradaBusotina obradaBusotina;
    /**
     * Creates new form ProzorPodaci
     */
    public ProzorPodaci() {
        initComponents();
        obrada = new ObradaPosaoBusotina();
        obradaOdrzavanje = new ObradaOdrzavanje();
        obradaBusotina = new ObradaBusotina();
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("hr", "HR"));
        df = new DecimalFormat("###,##0.00",dfs);

         setTitle(Aplikacija.NAZIV_APP + ": " + 
                Aplikacija.OPERATER.getImePrezime() + ": Podaci");
         txtUvjet.requestFocus();
       
         ucitajPoslove();
         ucitaj();
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
             
        List<Odrzavanje> odrzavanja = new ArrayList<>();
           try {
            DefaultListModel<Odrzavanje> m = (DefaultListModel<Odrzavanje>) lstOdrzavanjaUPodacima1.getModel();
            for(int i=0;i<m.getSize();i++){
                odrzavanja.add(m.getElementAt(i));
            }
        } catch (Exception ex) {
            
        }
     //   e.setOdrzavanje(odrzavanja);
        
         List<Busotina> busotine = new ArrayList<>();
           try {
            DefaultListModel<Busotina> m = (DefaultListModel<Busotina>) lstBusotineUPodacima.getModel();
            for(int i=0;i<m.getSize();i++){
                busotine.add(m.getElementAt(i));
            }
        } catch (Exception ex) {
            
        }
     //   e.setBusotina(busotine);
    
       
     }
     private void napuniView(){
           var e = obrada.getEntitet();
         cmbPosao.setSelectedItem(e.getPosao());
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
            m.addElement(e.getOdrzavanje());
        }
        
         
      
         lstOdrzavanjaUPodacima1.setModel(m);
         lstOdrzavanjaUPodacima1.repaint();
         
         DefaultListModel<Busotina> b = new DefaultListModel<>();
        
        if(e.getBusotina()!=null){
            b.addElement(e.getBusotina());
        }
        
         
      
         lstBusotineUPodacima.setModel(b);
         lstBusotineUPodacima.repaint();
     
    } 

      private void ucitaj(){
        
          DefaultListModel<PosaoBusotina> m = new DefaultListModel<>();
        m.addAll(obrada.read(txtUvjet.getText(),chbTraziOdPocetkaDatuma.isSelected()));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        txtUvjet = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        chbTraziOdPocetkaDatuma = new javax.swing.JCheckBox();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        lstBusotineUPodacima = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstBusotineUBazi = new javax.swing.JList<>();
        txtUvjet1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnDodajOdrzavanje = new javax.swing.JButton();
        btnObrišiOdržavanje = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstOdrzavanjaUPodacima1 = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstOdrzavanjaUBazi1 = new javax.swing.JList<>();
        txtUvjet2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnDodajBusotine1 = new javax.swing.JButton();
        btnObrišiBusotine1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstPodaci.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(135, 135, 135)));
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

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

        btnTrazi.setBackground(new java.awt.Color(37, 179, 213));
        btnTrazi.setForeground(new java.awt.Color(102, 102, 102));
        btnTrazi.setText("🔍");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        chbTraziOdPocetkaDatuma.setText("Traži od početka datuma");
        chbTraziOdPocetkaDatuma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbTraziOdPocetkaDatumaActionPerformed(evt);
            }
        });

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

        jScrollPane2.setViewportView(lstBusotineUPodacima);

        jScrollPane3.setViewportView(lstBusotineUBazi);

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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Odrzavanja u podacima:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Odrzavanja u bazi:");

        btnDodajOdrzavanje.setText("<<");
        btnDodajOdrzavanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajOdrzavanjeActionPerformed(evt);
            }
        });

        btnObrišiOdržavanje.setText(">>");
        btnObrišiOdržavanje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrišiOdržavanjeActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(lstOdrzavanjaUPodacima1);

        jScrollPane5.setViewportView(lstOdrzavanjaUBazi1);

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

        btnDodajBusotine1.setText("<<");
        btnDodajBusotine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajBusotine1ActionPerformed(evt);
            }
        });

        btnObrišiBusotine1.setText(">>");
        btnObrišiBusotine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrišiBusotine1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Bušotine u podacima:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Bušotine u bazi:");

        btnDodaj.setBackground(new java.awt.Color(37, 179, 213));
        btnDodaj.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDodaj.setForeground(new java.awt.Color(102, 102, 102));
        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajBusotine1)
                                    .addComponent(btnObrišiBusotine1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chbTraziOdPocetkaDatuma, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnTrazi)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTlakCasinga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addComponent(txtTlakNaftovoda, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTlakTubinga, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(txtNapomena)
                            .addComponent(cmbPosao, 0, 197, Short.MAX_VALUE)
                            .addComponent(btnDodaj))))
                .addGap(18, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDodajOdrzavanje)
                            .addComponent(btnObrišiOdržavanje))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUvjet1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chbTraziOdPocetkaDatuma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbPosao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDodaj)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(216, 216, 216))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUvjet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDodajBusotine1)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnObrišiBusotine1)))
                                .addGap(19, 19, 19))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUvjet1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5)
                                .addGap(357, 357, 357))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodajOdrzavanje)
                                .addGap(27, 27, 27)
                                .addComponent(btnObrišiOdržavanje)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitaj();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void chbTraziOdPocetkaDatumaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbTraziOdPocetkaDatumaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbTraziOdPocetkaDatumaActionPerformed

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

    private void btnDodajOdrzavanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajOdrzavanjeActionPerformed
        if(lstOdrzavanjaUBazi1.getSelectedValuesList()==null
                || lstOdrzavanjaUBazi1.getSelectedValuesList().isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo pronađite održavanje");
            return;
        }
        
          if(lstOdrzavanjaUPodacima1.getModel()==null || 
                  !(lstOdrzavanjaUPodacima1.getModel() instanceof DefaultListModel<Odrzavanje>)){
            lstOdrzavanjaUPodacima1.setModel(new DefaultListModel<Odrzavanje>());
        }
        
        DefaultListModel<Odrzavanje> m = 
                (DefaultListModel<Odrzavanje>) lstOdrzavanjaUPodacima1.getModel();
        
        DefaultListModel<Odrzavanje> odrzavanja = 
                (DefaultListModel<Odrzavanje>) lstOdrzavanjaUPodacima1.getModel();
        boolean postoji;
        for(Odrzavanje oub : lstOdrzavanjaUBazi1.getSelectedValuesList()){
            postoji=false;
            for(int i=0;i<odrzavanja.getSize();i++){
                if(oub.getSifra()==odrzavanja.get(i).getSifra()){
                    postoji=true;
                    break;
                }
            }
            if(!postoji){
                 odrzavanja.addElement(oub);
            }
        }
        lstOdrzavanjaUPodacima1.repaint();
    }//GEN-LAST:event_btnDodajOdrzavanjeActionPerformed

    private void btnObrišiOdržavanjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrišiOdržavanjeActionPerformed
         if(lstOdrzavanjaUPodacima1.getSelectedValuesList()==null
                || lstOdrzavanjaUPodacima1.getSelectedValuesList().isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite odrzavanja u podacima");
            return;
        }
        
        DefaultListModel<Odrzavanje> m = 
                (DefaultListModel<Odrzavanje>) lstOdrzavanjaUPodacima1.getModel();
        
        for(Odrzavanje o : lstOdrzavanjaUPodacima1.getSelectedValuesList()){
            m.removeElement(o);
        }
        lstOdrzavanjaUPodacima1.repaint();
        
    
    }//GEN-LAST:event_btnObrišiOdržavanjeActionPerformed

    private void txtUvjet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjet2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjet2ActionPerformed

    private void txtUvjet2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjet2KeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             ucitajBusotine();
        }
    }//GEN-LAST:event_txtUvjet2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ucitajBusotine();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDodajBusotine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajBusotine1ActionPerformed
         if(lstBusotineUBazi.getSelectedValuesList()==null
                || lstBusotineUBazi.getSelectedValuesList().isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo pronađite bušotine");
            return;
        }
        
          if(lstBusotineUPodacima.getModel()==null || 
                  !(lstBusotineUPodacima.getModel() instanceof DefaultListModel<Busotina>)){
            lstBusotineUPodacima.setModel(new DefaultListModel<Busotina>());
        }
        
        DefaultListModel<Busotina> m = 
                (DefaultListModel<Busotina>) lstBusotineUPodacima.getModel();
        
        DefaultListModel<Busotina> busotine = 
                (DefaultListModel<Busotina>) lstBusotineUPodacima.getModel();
        boolean postoji;
        for(Busotina bub : lstBusotineUBazi.getSelectedValuesList()){
            postoji=false;
            for(int i=0;i<busotine.getSize();i++){
                if(bub.getSifra()==busotine.get(i).getSifra()){
                    postoji=true;
                    break;
                }
            }
            if(!postoji){
                 busotine.addElement(bub);
            }
        }
        lstBusotineUPodacima.repaint();
      
    }//GEN-LAST:event_btnDodajBusotine1ActionPerformed

    private void btnObrišiBusotine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrišiBusotine1ActionPerformed
       if(lstBusotineUPodacima.getSelectedValuesList()==null
                || lstBusotineUPodacima.getSelectedValuesList().isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(),
                    "Prvo odaberite bušotine u podacima");
            return;
        }
        
        DefaultListModel<Busotina> m = 
                (DefaultListModel<Busotina>) lstBusotineUPodacima.getModel();
        
        for(Busotina b : lstBusotineUPodacima.getSelectedValuesList()){
            m.removeElement(b);
        }
        lstBusotineUPodacima.repaint();
    }//GEN-LAST:event_btnObrišiBusotine1ActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
       obrada.setEntitet(new PosaoBusotina());
       napuniModel();
            try {
                obrada.create();
                ucitaj();
            } catch (OtpremnaStanicaException ex) {
                JOptionPane.showMessageDialog(getParent(), ex.getPoruka());
            }
    }//GEN-LAST:event_btnDodajActionPerformed
    
    private void ucitajBusotine(){
          DefaultListModel<Busotina> m= new DefaultListModel<>();
        m.addAll(obradaBusotina.read(txtUvjet2.getText().trim()));
        lstBusotineUBazi.setModel(m);
        lstBusotineUBazi.repaint();
    }
    private void ucitajOdrzavanja(){
        DefaultListModel<Odrzavanje> m = new DefaultListModel<>();
        m.addAll(obradaOdrzavanje.read(txtUvjet1.getText().trim()));
        lstOdrzavanjaUBazi1.setModel(m);
        lstOdrzavanjaUBazi1.repaint();
    
        
    }
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajBusotine1;
    private javax.swing.JButton btnDodajOdrzavanje;
    private javax.swing.JButton btnObrišiBusotine1;
    private javax.swing.JButton btnObrišiOdržavanje;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JCheckBox chbTraziOdPocetkaDatuma;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Busotina> lstBusotineUBazi;
    private javax.swing.JList<Busotina> lstBusotineUPodacima;
    private javax.swing.JList<Odrzavanje> lstOdrzavanjaUBazi1;
    private javax.swing.JList<Odrzavanje> lstOdrzavanjaUPodacima1;
    private javax.swing.JList<PosaoBusotina> lstPodaci;
    private javax.swing.JTextField txtNapomena;
    private javax.swing.JTextField txtTlakCasinga;
    private javax.swing.JTextField txtTlakNaftovoda;
    private javax.swing.JTextField txtTlakTubinga;
    private javax.swing.JTextField txtUvjet;
    private javax.swing.JTextField txtUvjet1;
    private javax.swing.JTextField txtUvjet2;
    // End of variables declaration//GEN-END:variables
}