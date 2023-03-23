/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.util.List;
import otpremnastanica.model.Busotina;
import otpremnastanica.model.NaftnoPolje;

import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaBusotina extends Obrada<Busotina> {

    @Override
    public List<Busotina> read() {

        return session.createQuery("from Busotina", Busotina.class).list();
    }
      public List<Busotina> read(NaftnoPolje np) {

        return session.createQuery("from Busotina"
                + " where naftnoPolje=:naftnoPolje", Busotina.class)
                .setParameter("naftnoPolje", np).list();
        
    }

    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
        kontrolaNaziv();
            if(entitet.getNaftnoPolje().getSifra()==0){
            throw new OtpremnaStanicaException("Obavezan odabir naftnog polja");
        }
       
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
     //   if(entitet.getNaftnoPolje()!=null && !entitet.getNaftnoPolje().getNaziv().isEmpty()){
           
      //      throw new OtpremnaStanicaException("Bušotina se ne može obrisati"
        //            + " jer ima naftno polje");
      //  }
    }

    private void kontrolaNaziv() throws OtpremnaStanicaException {
        kontrolaNazivNull();
        kontrolaNazivNijeBroj();
        kontrolaNazivMinimalnaDuzina();
        kontrolaNazivMaksimalnaDuzina();
        kontrolaNazivDupliUBazi();
    }

    private void kontrolaNazivNull() throws OtpremnaStanicaException {
        if (entitet.getNaziv() == null) {
            throw new OtpremnaStanicaException("Naziv mora biti postavljen");
        }
    }

    private void kontrolaNazivNijeBroj() throws OtpremnaStanicaException {

        boolean broj = false;

        try {
            Double.parseDouble(entitet.getNaziv());
            broj = true;
        } catch (Exception e) {

        }

        if (broj) {
            throw new OtpremnaStanicaException("Naziv bušotine ne smije biti samo broj");
        }

    }

    private void kontrolaNazivMinimalnaDuzina() throws OtpremnaStanicaException {
        if (entitet.getNaziv().trim().length() < 3) {
            throw new OtpremnaStanicaException("Naziv bušotine mora imati minimalno 3 znaka");
        }
    }

    private void kontrolaNazivMaksimalnaDuzina() throws OtpremnaStanicaException {
        if (entitet.getNaziv().trim().length() > 10) {
            throw new OtpremnaStanicaException("Naziv bušotine može imati maksimalno 10 znakova");
        }
    }

    private void kontrolaNazivDupliUBazi() throws OtpremnaStanicaException {
        List<Busotina> busotine = null;
        try {
            busotine = session.createQuery("from Busotina b "
                    + " where b.naziv=:naziv",
                    Busotina.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if (busotine != null && !busotine.isEmpty()) {
            throw new OtpremnaStanicaException("Bušotina sa istim nazivom postoji u bazi");
        }
    }

    

}
