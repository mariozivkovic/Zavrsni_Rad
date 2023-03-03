/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.util.List;
import otpremnastanica.model.Zaposlenik;
import otpremnastanica.util.Alati;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaZaposlenik extends Obrada<Zaposlenik> {

    @Override
    public List<Zaposlenik> read() {

        return session.createQuery("from Zaposlenik", Zaposlenik.class).list();
    }

    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaEmail();
        kontrolaRadnoMjesto();
    }

    @Override
    protected void kontrolaPromjena() throws OtpremnaStanicaException {
        kontrolaImeNull();
        kontrolaImeNijeBroj();
        kontrolaImeMinimalnaDuzina();
        kontrolaImeMaksimalnaDuzina();

        kontrolaPrezimeNull();
        kontrolaPrezimeNijeBroj();
        kontrolaPrezimeMinimalnaDuzina();
        kontrolaPrezimeMaksimalnaDuzina();

        kontrolaEmailNull();
        kontrolaEmailNijeBroj();
        kontrolaEmailMinimalnaDuzina();
        kontrolaEmailMaksimalnaDuzina();
        
        kontrolaRadnoMjestoNull();
        kontrolaRadnoMjestoNijeBroj();
        kontrolaRadnoMjestoMinimalnaDuzina();
        kontrolaRadnoMjestoMaksimalnaDuzina();
    }

    @Override
    protected void kontrolaBrisanje() throws OtpremnaStanicaException {

    }

    private void kontrolaIme() throws OtpremnaStanicaException {
        kontrolaImeNull();
        kontrolaImeNijeBroj();
        kontrolaImeMinimalnaDuzina();
        kontrolaImeMaksimalnaDuzina();
        kontrolaImeDuploUBazi();
    }

    private void kontrolaImeNijeBroj() throws OtpremnaStanicaException {
        boolean broj = false;
        try {
            Double.parseDouble(entitet.getIme());
            broj = true;
        } catch (Exception e) {
        }
        if (broj) {
            throw new OtpremnaStanicaException("Ime zaposlenika ne smije biti broj");
        }

    }

    private void kontrolaImeMinimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getIme().trim().length() < 3) {
            throw new OtpremnaStanicaException("Ime zaposlenika može imati minimalno tri znaka");
        }
    }

    private void kontrolaImeNull() throws OtpremnaStanicaException {

        if (entitet.getIme() == null) {
            throw new OtpremnaStanicaException("Ime mora biti upisano");
        }
    }

    private void kontrolaImeMaksimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getIme().trim().length() < 20) {
            throw new OtpremnaStanicaException("Ime zaposlenika može imati maksimalno 20 znakova");
        }
    }

    private void kontrolaImeDuploUBazi() throws OtpremnaStanicaException {

        List<Zaposlenik> zaposlenici = null;
        try {
            zaposlenici = session.createQuery("from Zaposlenik z "
                    + " where z.ime=:ime", Zaposlenik.class)
                    .setParameter(" ime", entitet.getIme()).list();
        } catch (Exception e) {
        }
        if (zaposlenici != null && !zaposlenici.isEmpty()) {
            throw new OtpremnaStanicaException("Zaposlenik sa istim imenom postoji u bazi");
        }
    }

    private void kontrolaPrezime() throws OtpremnaStanicaException {
        kontrolaPrezimeNull();
        kontrolaPrezimeNijeBroj();
        kontrolaPrezimeMinimalnaDuzina();
        kontrolaPrezimeMaksimalnaDuzina();
        kontrolaPrezimeDuploUBazi();
    }

    private void kontrolaPrezimeNull() throws OtpremnaStanicaException {

        if (entitet.getPrezime() == null) {
            throw new OtpremnaStanicaException("Prezime mora biti upisano");
        }
    }

    private void kontrolaPrezimeNijeBroj() throws OtpremnaStanicaException {

        boolean broj = false;
        try {
            Double.parseDouble(entitet.getPrezime());
            broj = true;
        } catch (Exception e) {
        }
        if (broj) {
            throw new OtpremnaStanicaException("Prezime zaposlenika ne smije biti broj");
        }
    }

    private void kontrolaPrezimeMinimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getPrezime().trim().length() < 3) {
            throw new OtpremnaStanicaException("Prezime zaposlenika može imati minimalno tri znaka");
        }
    }

    private void kontrolaPrezimeMaksimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getPrezime().trim().length() < 50) {
            throw new OtpremnaStanicaException("Prezime zaposlenika može imati maksimalno 50 znakova");
        }
    }

    private void kontrolaPrezimeDuploUBazi() throws OtpremnaStanicaException {

        List<Zaposlenik> zaposlenici = null;
        try {
            zaposlenici = session.createQuery("from Zaposlenik z "
                    + " where z.prezime=:prezime", Zaposlenik.class)
                    .setParameter(" prezime", entitet.getPrezime()).list();
        } catch (Exception e) {
        }
        if (zaposlenici != null && !zaposlenici.isEmpty()) {
            throw new OtpremnaStanicaException("Zaposlenik sa istim prezimenom postoji u bazi");
        }
    }

    private void kontrolaOib() throws OtpremnaStanicaException {

        if (Alati.kontrolaOIB(entitet.getOib())) {
            throw new OtpremnaStanicaException("OIB nije u dobrom formatu");
        }
    }

    private void kontrolaEmail() throws OtpremnaStanicaException {
        kontrolaEmailNull();
        kontrolaEmailNijeBroj();
        kontrolaEmailMinimalnaDuzina();
        kontrolaEmailMaksimalnaDuzina();
        kontrolaEmailDupliUBazi();

    }

    private void kontrolaEmailNull() throws OtpremnaStanicaException {

        if (entitet.getEmail() == null) {
            throw new OtpremnaStanicaException("Email mora biti upisan");
        }
    }

    private void kontrolaEmailNijeBroj() throws OtpremnaStanicaException {

        boolean broj = false;
        try {
            Double.parseDouble(entitet.getEmail());
            broj = true;
        } catch (Exception e) {
        }
        if (broj) {
            throw new OtpremnaStanicaException("Email ne smije biti broj");
        }
    }

    private void kontrolaEmailMinimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getEmail().trim().length() < 11) {
            throw new OtpremnaStanicaException("Email može imati minimalno 11 znakova");
        }
    }

    private void kontrolaEmailMaksimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getEmail().trim().length() < 50) {
            throw new OtpremnaStanicaException("Email može imati maksimalno 50 znakova");
        }
    }

    private void kontrolaEmailDupliUBazi() throws OtpremnaStanicaException {

        List<Zaposlenik> zaposlenici = null;
        try {
            zaposlenici = session.createQuery("from Zaposlenik z "
                    + " where z.email=:email", Zaposlenik.class)
                    .setParameter(" email", entitet.getEmail()).list();
        } catch (Exception e) {
        }
        if (zaposlenici != null && !zaposlenici.isEmpty()) {
            throw new OtpremnaStanicaException("Zaposlenik sa istim emailom postoji u bazi");
        }
    }

    private void kontrolaRadnoMjesto() throws OtpremnaStanicaException{
        kontrolaRadnoMjestoNull();
        kontrolaRadnoMjestoNijeBroj();
        kontrolaRadnoMjestoMinimalnaDuzina();
        kontrolaRadnoMjestoMaksimalnaDuzina();
        
        
    }

    private void kontrolaRadnoMjestoNull()throws OtpremnaStanicaException {
        
         if (entitet.getRadnoMjesto()== null) {
            throw new OtpremnaStanicaException("Radno mjesto mora biti upisano");
        }
    }

    private void kontrolaRadnoMjestoNijeBroj() throws OtpremnaStanicaException{
        
         boolean broj = false;
        try {
            Double.parseDouble(entitet.getRadnoMjesto());
            broj = true;
        } catch (Exception e) {
        }
        if (broj) {
            throw new OtpremnaStanicaException("Radno mjesto ne smije biti broj");
        }
    }

    private void kontrolaRadnoMjestoMinimalnaDuzina()throws OtpremnaStanicaException {
   
         if (entitet.getRadnoMjesto().trim().length() < 5) {
            throw new OtpremnaStanicaException("Radno mjesto može imati minimalno 5 znakova");
        }
    }

    private void kontrolaRadnoMjestoMaksimalnaDuzina() throws OtpremnaStanicaException{
        
         if (entitet.getRadnoMjesto().trim().length() < 150) {
            throw new OtpremnaStanicaException("Radno mjesto može imati maksimalno 150 znakova");
        }
    }

}
