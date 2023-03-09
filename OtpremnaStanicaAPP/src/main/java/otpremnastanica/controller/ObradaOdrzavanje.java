/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.util.List;

import otpremnastanica.model.Odrzavanje;
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

    @Override
    protected void kontrolaUnos() throws OtpremnaStanicaException {

    }

    @Override
    protected void kontrolaPromjena() throws OtpremnaStanicaException {

    }

    @Override
    protected void kontrolaBrisanje() throws OtpremnaStanicaException {

    }

}
