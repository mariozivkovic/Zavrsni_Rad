/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.math.BigDecimal;
import java.util.List;

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

    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {
        kontrolaNapomena();
        kontrolaTlakTubinga();
        kontrolaTlakNaftovoda();
        kontrolaTlakCasinga();
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
