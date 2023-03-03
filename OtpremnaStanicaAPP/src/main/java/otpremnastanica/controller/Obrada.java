/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.controller;

import java.util.List;
import org.hibernate.Session;
import otpremnastanica.model.Entitet;
import otpremnastanica.util.HibernateUtil;
import otpremnastanica.util.OtpremnaStanicaException;

/**
 *
 * @author lovre
 */
public abstract class Obrada<T extends Entitet>{
    
    protected T entitet;
    
    protected Session session;
    
    public abstract List<T> read();
    protected abstract void kontrolaUnos() throws OtpremnaStanicaException;
    protected abstract void kontrolaPromjena() throws OtpremnaStanicaException;
    protected abstract void kontrolaBrisanje() throws OtpremnaStanicaException;

    public Obrada() {
        
        this.session = HibernateUtil.getSession();
    }
    
    public void create() throws OtpremnaStanicaException{
        if(entitet==null){
            throw new OtpremnaStanicaException("Entitet je null");
        }
        kontrolaUnos();
        persist();
    }
    public void update() throws OtpremnaStanicaException{
        kontrolaPromjena();
        persist();
    }
    public void delete() throws OtpremnaStanicaException{
        kontrolaBrisanje();
         session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }
    
    private void persist(){
        session.beginTransaction();
        session.persist(entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }
    
    
    
}
