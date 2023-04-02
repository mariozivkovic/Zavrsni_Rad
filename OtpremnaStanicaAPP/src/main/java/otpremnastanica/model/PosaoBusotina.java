package otpremnastanica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PosaoBusotina extends Entitet {

 
    @ManyToOne
    private Odrzavanje odrzavanje;
    @ManyToOne
    private Posao posao;
    @ManyToOne
    private Busotina busotina;

    private String napomena;
    private BigDecimal tlakTubinga;
    private BigDecimal tlakNaftovoda;
    private BigDecimal tlakCasinga;

    public PosaoBusotina() {
        super();
    }

    public PosaoBusotina(Odrzavanje odrzavanje, Posao posao, Busotina busotina, String napomena, BigDecimal tlakTubinga, BigDecimal tlakNaftovoda, BigDecimal tlakCasinga, int sifra) {
        super(sifra);
        this.odrzavanje = odrzavanje;
        this.posao = posao;
        this.busotina = busotina;
        this.napomena = napomena;
        this.tlakTubinga = tlakTubinga;
        this.tlakNaftovoda = tlakNaftovoda;
        this.tlakCasinga = tlakCasinga;
    }

   

    public Odrzavanje getOdrzavanje() {
        return odrzavanje;
    }

    public void setOdrzavanje(Odrzavanje odrzavanje) {
        this.odrzavanje = odrzavanje;
    }

  
    public Posao getPosao() {
        return posao;
    }

    public void setPosao(Posao posao) {
        this.posao = posao;
    }

    public Busotina getBusotina() {
        return busotina;
    }

    public void setBusotina(Busotina busotina) {
        this.busotina = busotina;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public BigDecimal getTlakTubinga() {
        return tlakTubinga;
    }

    public void setTlakTubinga(BigDecimal tlakTubinga) {
        this.tlakTubinga = tlakTubinga;
    }

    public BigDecimal getTlakNaftovoda() {
        return tlakNaftovoda;
    }

    public void setTlakNaftovoda(BigDecimal tlakNaftovoda) {
        this.tlakNaftovoda = tlakNaftovoda;
    }

    public BigDecimal getTlakCasinga() {
        return tlakCasinga;
    }

    public void setTlakCasinga(BigDecimal tlakCasinga) {
        this.tlakCasinga = tlakCasinga;
    }

    public String  getObrisi(){
        return getOdrzavanje() +" " + getPosao()+" " +getBusotina()+" " +getNapomena()+" " +
                getTlakTubinga()+" " +getTlakNaftovoda()+" " +getTlakCasinga();
    }
    @Override
    public String toString() {
        return odrzavanje + ",  " + busotina + ",  " + posao + ",  " + napomena + ",  "  + "P(t)-"+tlakTubinga + ", "  +"P(n)-"+ tlakNaftovoda + ",  " + 
             "P(c)-" + tlakCasinga;
    }
  
   

    
}
