/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import jakarta.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;
import otpremnastanica.model.Operater;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public class ObradaOperater extends Obrada<Operater>{

    @Override
    public List<Operater> read() {
        
        return session.createQuery("from Operater", Operater.class).list();
    }
    
    public void unosAdminOperatera(){
    
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
        
    }

    @Override
    protected void kontrolaPromjena() throws OtpremnaStanicaException {
       
    }

    @Override
    protected void kontrolaBrisanje() throws OtpremnaStanicaException {
        
    }
    public Operater autoriziraj(String email, char[] lozinka){
        Operater o;
        try {
            o=session.createQuery("from Operater o where o.email=:email",
                    Operater.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        
        if(BCrypt.checkpw(new String(lozinka),
                new String(o.getLozinka()))){
            return o;
        }
        
        return null;
}
}


    
