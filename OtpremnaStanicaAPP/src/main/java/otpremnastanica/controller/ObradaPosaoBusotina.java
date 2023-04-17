/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.crypto.interfaces.PBEKey;
import otpremnastanica.model.Busotina;
import otpremnastanica.model.Odrzavanje;
import otpremnastanica.model.Posao;

import otpremnastanica.model.PosaoBusotina;
import otpremnastanica.model.Zaposlenik;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaPosaoBusotina extends Obrada<PosaoBusotina> {
    
  

    @Override
    public List<PosaoBusotina> read() {

        return session.createQuery("from PosaoBusotina order by odrzavanje desc", PosaoBusotina.class).list();
    }

      
     
        public List<PosaoBusotina> read(Busotina b) {
        return session.createQuery("from PosaoBusotina"
                + " where busotina=:busotina", PosaoBusotina.class)
                .setParameter("busotina", b).list();
        
    }

    public List<PosaoBusotina> read(Odrzavanje o) {

        return session.createQuery("from PosaoBusotina order by odrzavanje desc"
                + " where odrzavanje=:odrzavanje", PosaoBusotina.class)
                .setParameter("odrzavanje", o).list();
        
    }
     public List<PosaoBusotina> read(Posao p) {

        return session.createQuery("from PosaoBusotina"
                + " where posao=:posao", PosaoBusotina.class)
                .setParameter("posao", p).list();
        
    }
     public List<Odrzavanje> read(String datumString) {
         System.out.println(datumString);
         LocalDate Date = LocalDate.parse(datumString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
       return session.createQuery("from Odrzavanje "
               + " where cast(datum as Date)=:uvjet  "
               
              , 
               Odrzavanje.class)
               .setParameter("uvjet", Date)
               .setMaxResults(12)
               .list();
    }
     public List<PosaoBusotina> read(String pocetniDatumString, String krajnjiDatumString) {
       System.out.println(pocetniDatumString);
         LocalDate pocetniDate = LocalDate.parse(pocetniDatumString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
          LocalDate krajnjiDate = LocalDate.parse(krajnjiDatumString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
       return session.createQuery(
  "SELECT pb FROM PosaoBusotina pb JOIN pb.odrzavanje o WHERE CAST(o.datum AS Date) BETWEEN :uvjet AND :uvjet2 " 
               +"ORDER BY o.datum desc"
              , 
               PosaoBusotina.class)
               .setParameter("uvjet", pocetniDate)
                .setParameter("uvjet2", krajnjiDate)
               
               .list();
      
       
    }
    
  
    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
       if(entitet.getOdrzavanje()==null){
             throw new OtpremnaStanicaException("Odaberite održavanje i unesite podatke da bi ih dodali");
        }
       
       
        
         if(entitet.getPosao().getSifra()==0){
            throw new OtpremnaStanicaException("Obavezan odabir posla");
         }
         
          if(entitet.getBusotina().getSifra()==0){
            throw new OtpremnaStanicaException("Obavezan odabir busotine");
         }
          
          
    }

    @Override
    protected void kontrolaPromjena() throws OtpremnaStanicaException {
        kontrolaNapomena();
        kontrolaTlakTubinga();
        kontrolaTlakNaftovoda();
        kontrolaTlakCasinga();
     
           kontrolaZaposlenika();
       
      
        
        if(entitet.getOdrzavanje()==null){
            throw new OtpremnaStanicaException("Odaberite odrzavanje i unesite promjene ");
        }
    }
public void kontrolaZaposlenika() throws OtpremnaStanicaException{
    
    
    if(entitet.getNapomena()==null || entitet.getNapomena().isBlank()){
         throw new OtpremnaStanicaException("Zaposlenik " + 
                 entitet.getOdrzavanje().getZaposlenik().getImePrezime() + " nema napomenu");
    }
   
}
    

    @Override
    protected void kontrolaBrisanje() throws OtpremnaStanicaException {

    }

    private void kontrolaTlakTubinga() throws OtpremnaStanicaException {

        if (entitet.getTlakTubinga() == null
                || entitet.getTlakTubinga().compareTo(BigDecimal.ZERO) <= 0
                || entitet.getTlakTubinga().compareTo(new BigDecimal(30)) == 1) {
            throw new OtpremnaStanicaException("Tlak tubinga mora biti upisan, "
                    + "veći od 0 i manji od 30 bara");
        }
    }

    private void kontrolaTlakNaftovoda() throws OtpremnaStanicaException {

        if (entitet.getTlakNaftovoda() == null
                || entitet.getTlakNaftovoda().compareTo(BigDecimal.ZERO) <= 0
                || entitet.getTlakNaftovoda().compareTo(new BigDecimal(30)) == 1) {
            throw new OtpremnaStanicaException("Tlak naftovoda mora biti upisan, "
                    + "veći od 0 i manji od 30 bara");
        }
    }

    private void kontrolaTlakCasinga() throws OtpremnaStanicaException {

        if (entitet.getTlakCasinga() == null
                || entitet.getTlakCasinga().compareTo(BigDecimal.ZERO) <= 0
                || entitet.getTlakCasinga().compareTo(new BigDecimal(50)) == 1) {
            throw new OtpremnaStanicaException("Tlak casinga mora biti upisan, "
                    + "veći od 0 i manji od 50 bara");
        }
    }

    private void kontrolaNapomena() throws OtpremnaStanicaException {
        kontrolaNapomenaNijeBroj();
    }

    private void kontrolaNapomenaNijeBroj() throws OtpremnaStanicaException {
        boolean broj = false;
        try {
            Double.parseDouble(entitet.getNapomena());
            broj = true;
        } catch (Exception e) {
        }
        if (broj) {
            throw new OtpremnaStanicaException("Napomena ne smije biti broj");
        }
    }

}
