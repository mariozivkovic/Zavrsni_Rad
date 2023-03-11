/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import jakarta.persistence.NoResultException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import otpremnastanica.model.Operater;

import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaOperater extends Obrada<Operater> {

    @Override
    public List<Operater> read() {

        return session.createQuery("from Operater", Operater.class).list();
    }

    public void unosAdminOperatera() {

        Operater o = new Operater();
        o.setIme("Mario");
        o.setPrezime("Živković");
        o.setEmail("mario.zivkovic.znr@gmail.com");
        o.setLozinka(BCrypt.hashpw("otpremnastanica",
                BCrypt.gensalt()).toCharArray());

        entitet = o;
        try {
            create();
        } catch (OtpremnaStanicaException ex) {

        }
    }

    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaEmail();
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
    }

    @Override
    protected void kontrolaBrisanje() throws OtpremnaStanicaException {

    }

    public Operater autoriziraj(String email, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater o where o.email=:email",
                    Operater.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka),
                new String(o.getLozinka()))) {
            return o;
        }

        return null;
    }

    private void kontrolaEmail() throws OtpremnaStanicaException {
        kontrolaEmailNull();
        kontrolaEmailNijeBroj();
        kontrolaEmailMinimalnaDuzina();
        kontrolaEmailMaksimalnaDuzina();
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

        if (entitet.getEmail().trim().length() < 12) {
            throw new OtpremnaStanicaException("Email može imati minimalno 11 znakova");
        }
    }

    private void kontrolaEmailMaksimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getEmail().trim().length() > 50) {
            throw new OtpremnaStanicaException("Email može imati maksimalno 50 znakova");
        }
    }

    private void kontrolaIme() throws OtpremnaStanicaException {
        kontrolaImeNull();
        kontrolaImeNijeBroj();
        kontrolaImeMinimalnaDuzina();
        kontrolaImeMaksimalnaDuzina();

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

        if (entitet.getIme().trim().length() > 20) {
            throw new OtpremnaStanicaException("Ime Operatera može imati maksimalno 20 znakova");
        }
    }

    private void kontrolaPrezime() throws OtpremnaStanicaException {
        kontrolaPrezimeNull();
        kontrolaPrezimeNijeBroj();
        kontrolaPrezimeMinimalnaDuzina();
        kontrolaPrezimeMaksimalnaDuzina();

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
            throw new OtpremnaStanicaException("Prezime operatera ne smije biti broj");
        }
    }

    private void kontrolaPrezimeMinimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getPrezime().trim().length() < 3) {
            throw new OtpremnaStanicaException("Prezime operatera može imati minimalno tri znaka");
        }
    }

    private void kontrolaPrezimeMaksimalnaDuzina() throws OtpremnaStanicaException {

        if (entitet.getPrezime().trim().length() > 50) {
            throw new OtpremnaStanicaException("Prezime operatera može imati maksimalno 50 znakova");
        }
    }
}
