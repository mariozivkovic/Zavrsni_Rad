/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.util;

import com.github.javafaker.Faker;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import otpremnastanica.model.Busotina;
import otpremnastanica.model.NaftnoPolje;
import otpremnastanica.model.Posao;
import otpremnastanica.model.Zaposlenik;

import org.hibernate.Session;
import otpremnastanica.model.Busotina;
import otpremnastanica.model.NaftnoPolje;
import otpremnastanica.model.Odrzavanje;
import otpremnastanica.model.Posao;
import otpremnastanica.model.PosaoBusotina;
import otpremnastanica.model.Zaposlenik;


/**
 *
 * @author lovre
 */
public class PocetniInsert {
    
    
    private static final int BROJ_ZAPOSLENIKA =100;
    private static final int BROJ_POSLOVA =10;
    private static final int BROJ_NAFTNIH_POLJA = 10;
    private static final int BROJ_BUSOTINA =300;
    private static final int BROJ_ODRZAVANJA =16;
    private static final int BROJ_POSLOVA_BUSOTINA =10000;
    
    
    
    private Faker faker;
    private List<Zaposlenik> zaposlenici;
    private List<Posao> poslovi;
    private List<NaftnoPolje> naftnaPolja;
    private List<Busotina> busotine;
     private List<Odrzavanje> odrzavanja;
    private List<PosaoBusotina> posloviBusotine;
   
    
    private Session session;
    
    public PocetniInsert() {
        
        faker = new Faker();
        zaposlenici = new ArrayList<>();
        poslovi = new ArrayList<>();
        naftnaPolja = new ArrayList<>();
        busotine = new ArrayList<>();
         odrzavanja = new ArrayList<>();
        posloviBusotine  = new ArrayList<>();
       
       
        session = HibernateUtil.getSession();
        session.beginTransaction();
        kreirajZaposlenike();
        kreirajPoslove();
        kreirajNaftnaPolja();
        kreirajBusotine();
         kreirajOdrzavanja();
        kreirajPosloviBusotine();
       
        
        session.getTransaction().commit();
      
    }

    private void kreirajZaposlenike() {
        
        Zaposlenik z;
        for(int i= 0;i<BROJ_ZAPOSLENIKA;i++ ){
            z = new Zaposlenik();
            z.setIme(faker.name().firstName());
            z.setPrezime(faker.name().lastName());
            z.setOib(Alati.dovuciOib());
            z.setEmail(faker.internet().emailAddress());
            z.setRadnoMjesto(faker.job().position());
            
            session.persist(z);
            zaposlenici.add(z);
        }
    }

    private void kreirajPoslove() {
        
        Posao p;
        for(int i=0;i<BROJ_POSLOVA;i++){
            p = new Posao();
            p.setNaziv(faker.app().name());
            session.persist(p);
            poslovi.add(p);
        }
        
    }

    private void kreirajNaftnaPolja() {
        
        NaftnoPolje np;
        for(int i =0;i< BROJ_NAFTNIH_POLJA;i++){
            np = new NaftnoPolje();
            np.setNaziv(faker.country().name());
            session.persist(np);
            naftnaPolja.add(np);
        }
    }

    private void kreirajBusotine() {
        
        Busotina b;
        
        for(int i =0;i<BROJ_BUSOTINA;i++){
            b = new Busotina();
            b.setNaziv(faker.country().countryCode2());
            b.setAktivna(faker.bool().bool());
            b.setNaftnoPolje(naftnaPolja.get(sb(0, BROJ_NAFTNIH_POLJA-1)));
            
          
            session.persist(b);
            busotine.add(b);
        }
    }
    private void kreirajOdrzavanja() {
            
            Odrzavanje o;
            
            for(int i =0;i<BROJ_ODRZAVANJA;i++){
                o = new Odrzavanje();
                o.setDatum(faker.date().birthday());
                o.setZaposlenik(zaposlenici.get(sb(0, BROJ_ZAPOSLENIKA-1)));
                
               
                session.persist(o);
                odrzavanja.add(o);
                
            }
    }
    private void kreirajPosloviBusotine() {
             
             PosaoBusotina pb;
             for(int i =0;i<BROJ_POSLOVA_BUSOTINA;i++){
                 pb = new PosaoBusotina();
                 pb.setPosao(poslovi.get(sb(0, BROJ_POSLOVA-1)));
                 pb.setBusotina(busotine.get(sb(0, BROJ_BUSOTINA-1)));
                 pb.setOdrzavanje(odrzavanja.get(sb(0, BROJ_ODRZAVANJA-1)));
                 pb.setNapomena(faker.book().title());
                 pb.setTlakTubinga(new BigDecimal(faker.number().randomDouble(2, 8, 15)));
                 pb.setTlakNaftovoda(new BigDecimal(faker.number().randomDouble(2, 8, 15)));
                 pb.setTlakCasinga(new BigDecimal(faker.number().randomDouble(2, 10, 50)));
                 
                 session.persist(pb);
                 posloviBusotine.add(pb);
             }
    }
        
            
    
         
    
    
    
    private int sb(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }



    
            
    }
    

