/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import otpremnastanica.model.Odrzavanje;
import otpremnastanica.model.Zaposlenik;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaOdrzavanje extends Obrada<Odrzavanje> {

    @Override
    public List<Odrzavanje> read() {

        return session.createQuery("from Odrzavanje", Odrzavanje.class).list();
    }
     public List<Odrzavanje> read(Zaposlenik z) {

        return session.createQuery("from Odrzavanje"
                + " where zaposlenik=:zaposlenik", Odrzavanje.class)
                .setParameter("zaposlenik", z).list();
        
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
       public List<Odrzavanje> read(String uvjet, 
            boolean traziOdPocetkaDatuma) {
        uvjet=uvjet.trim();
        if(traziOdPocetkaDatuma){
            uvjet = uvjet + "%";
        }else{
            uvjet = "%" + uvjet + "%";
        }
        
       return session.createQuery("from Odrzavanje "
               + " where concat(datum,' ', zaposlenik) "
               + " like :uvjet "
               + " order by datum desc ", 
               Odrzavanje.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
    }
    

    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
        
        if(entitet.getDatum()==null){
            throw new OtpremnaStanicaException("Niste unijeli datum");
        }
        
         if(entitet.getZaposlenik().getSifra()==0){
            throw new OtpremnaStanicaException("Obavezan odabir zaposlenika");
         }
    }

    @Override
    protected void kontrolaPromjena() throws OtpremnaStanicaException {

        if(entitet.getDatum()==null){
            throw new OtpremnaStanicaException("Niste unijeli datum");
        }
        
         if(entitet.getZaposlenik().getSifra()==0){
            throw new OtpremnaStanicaException("Obavezan odabir zaposlenika");
         }
    
    }

    @Override
    protected void kontrolaBrisanje() throws OtpremnaStanicaException {

    }

}
