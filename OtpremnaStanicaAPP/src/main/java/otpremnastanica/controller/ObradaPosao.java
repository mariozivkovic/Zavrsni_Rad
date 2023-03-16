/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.util.List;
import otpremnastanica.model.Posao;

import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaPosao extends Obrada<Posao>{

    @Override
    public List<Posao> read() {
      
         return session.createQuery("from Posao order by naziv", Posao.class).list();
    }
    public List<Posao> read(String uvjet) {
        uvjet=uvjet.trim();
        uvjet = "%" + uvjet + "%";
       return session.createQuery("from Posao "
               + " where concat(naziv) "
               + " like :uvjet "
               + " order by naziv ", 
               Posao.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
    }
    
     public List<Posao> read(String uvjet, 
            boolean traziOdPocetkaImena) {
        uvjet=uvjet.trim();
        if(traziOdPocetkaImena){
            uvjet = uvjet + "%";
        }else{
            uvjet = "%" + uvjet + "%";
        }
        
       return session.createQuery("from Posao "
               + " where concat(naziv) "
               + " like :uvjet "
               + " order by naziv", 
               Posao.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
    }

    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
         kontrolaNaziv();
    }

    @Override
    protected void kontrolaPromjena() throws OtpremnaStanicaException {
         kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
    }

    @Override
    protected void kontrolaBrisanje() throws OtpremnaStanicaException {
         if(entitet.getPosloviBusotine()!=null && !entitet.getPosloviBusotine().isEmpty()){
           
            throw new OtpremnaStanicaException("Posao se ne može obrisati"
                    + " jer ima podatke");
        }
    }
    
     private void kontrolaNaziv() throws OtpremnaStanicaException  {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
    }
     
     private void kontrolaNazivNull() throws OtpremnaStanicaException  {
        if(entitet.getNaziv()==null){
            throw new OtpremnaStanicaException("Naziv mora biti postavljen");
        }
    }
     
         private void kontrolaNazivNijeBroj() throws OtpremnaStanicaException  {
     
        boolean broj=false;
        
        try {
            Double.parseDouble(entitet.getNaziv());
            broj=true;
        } catch (Exception e) {
            
        }
        
        if(broj){
            throw new OtpremnaStanicaException("Naziv posla ne smije biti broj");
        }
        
    }
         private void kontrolaNazivMinimalnaDuzina() throws OtpremnaStanicaException  {
         if(entitet.getNaziv().trim().length()<3){
             throw new OtpremnaStanicaException("Naziv posla mora imati minimalno 3 znaka");
         } 
    }
          private void kontrolaNazivMaksimalnaDuzina() throws OtpremnaStanicaException  {
         if(entitet.getNaziv().trim().length()>100){
             throw new OtpremnaStanicaException("Naziv posla može imati maksimalno 50 znakova");
         } 
    }
          private void kontrolaNazivDupliUBazi() throws OtpremnaStanicaException  {
        List<Posao> poslovi=null;
        try {
            poslovi = session.createQuery("from Posao p "
                    + " where p.naziv=:naziv", 
                    Posao.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if(poslovi!=null && !poslovi.isEmpty()){
            throw new OtpremnaStanicaException("Posao sa istim nazivom postoji u bazi");
        }
    }
    
    
    
}
