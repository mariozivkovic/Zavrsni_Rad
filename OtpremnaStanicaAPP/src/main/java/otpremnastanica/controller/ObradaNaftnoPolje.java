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
public class ObradaNaftnoPolje extends Obrada<NaftnoPolje> {

    @Override
    public List<NaftnoPolje> read() {

        return session.createQuery("from NaftnoPolje order by naziv", NaftnoPolje.class).list();
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
        if(entitet.getBusotine()!=null && !entitet.getBusotine().isEmpty()){
           
            throw new OtpremnaStanicaException("Naftno polje se ne može obrisati"
                    + " jer ima bušotine");
        }
            
        
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
            throw new OtpremnaStanicaException("Naziv naftnog polja ne smije biti broj");
        }

    }

    private void kontrolaNazivMinimalnaDuzina() throws OtpremnaStanicaException {
        if (entitet.getNaziv().trim().length() < 3) {
            throw new OtpremnaStanicaException("Naziv naftnog polja mora imati minimalno 3 znaka");
        }
    }

    private void kontrolaNazivMaksimalnaDuzina() throws OtpremnaStanicaException {
        if (entitet.getNaziv().trim().length() > 50) {
            throw new OtpremnaStanicaException("Naziv naftnog polja može imati maksimalno 50 znakova");
        }
    }

    private void kontrolaNazivDupliUBazi() throws OtpremnaStanicaException {
        List<NaftnoPolje> naftnaPolja = null;
        try {
            naftnaPolja = session.createQuery("from NaftnoPolje np "
                    + " where np.naziv=:naziv",
                    NaftnoPolje.class)
                    .setParameter("naziv", entitet.getNaziv())
                    .list();
        } catch (Exception e) {
        }
        if (naftnaPolja != null && !naftnaPolja.isEmpty()) {
            throw new OtpremnaStanicaException("Naftno polje sa istim nazivom postoji u bazi");
        }
    }

}
