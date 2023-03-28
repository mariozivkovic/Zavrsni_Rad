/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.math.BigDecimal;
import java.util.List;
import otpremnastanica.model.Busotina;
import otpremnastanica.model.Odrzavanje;
import otpremnastanica.model.Posao;

import otpremnastanica.model.PosaoBusotina;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaPosaoBusotina extends Obrada<PosaoBusotina> {

    @Override
    public List<PosaoBusotina> read() {

        return session.createQuery("from PosaoBusotina", PosaoBusotina.class).list();
    }
     public List<PosaoBusotina> read(Busotina b) {

        return session.createQuery("from PosaoBusotina"
                + " where busotina=:busotina", PosaoBusotina.class)
                .setParameter("busotina", b).list();
        
    }

    public List<PosaoBusotina> read(Odrzavanje o) {

        return session.createQuery("from PosaoBusotina"
                + " where odrzavanje=:odrzavanje", PosaoBusotina.class)
                .setParameter("odrzavanje", o).list();
        
    }
     public List<PosaoBusotina> read(Posao p) {

        return session.createQuery("from PosaoBusotina"
                + " where posao=:posao", PosaoBusotina.class)
                .setParameter("posao", p).list();
        
    }
     public List<PosaoBusotina> read(String uvjet) {
        uvjet=uvjet.trim();
        uvjet = "%" + uvjet + "%";
       return session.createQuery("from PosaoBusotina "
               + " where concat(odrzavanje,' ',posao) "
               + " like :uvjet "
               + " order by napomena ", 
               PosaoBusotina.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
    }
      public List<PosaoBusotina> read(String uvjet, 
            boolean traziOdPocetkaDatuma) {
        uvjet=uvjet.trim();
        if(traziOdPocetkaDatuma){
            uvjet = uvjet + "%";
        }else{
            uvjet = "%" + uvjet + "%";
        }
        
       return session.createQuery("from PosaoBusotina "
               + " where concat(odrzavanje) "
               + " like :uvjet "
               + " order by odrzavanje ", 
               PosaoBusotina.class)
               .setParameter("uvjet", uvjet)
               .setMaxResults(12)
               .list();
      }
  
    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
        kontrolaNapomena();
        kontrolaTlakTubinga();
        kontrolaTlakNaftovoda();
        kontrolaTlakCasinga();
        
         if(entitet.getPosao().getSifra()==0){
            throw new OtpremnaStanicaException("Obavezan odabir posla");
         }
    }

    @Override
    protected void kontrolaPromjena() throws OtpremnaStanicaException {
        kontrolaNapomena();
        kontrolaTlakTubinga();
        kontrolaTlakNaftovoda();
        kontrolaTlakCasinga();
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
