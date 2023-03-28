package otpremnastanica.model;

import jakarta.persistence.Entity;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
public class Odrzavanje extends Entitet {

	private Date datum;
    @ManyToOne
	private Zaposlenik zaposlenik;
    
    @OneToMany(mappedBy = "odrzavanje")
    private List<PosaoBusotina> posloviBusotine = new ArrayList<>();
    
    public Odrzavanje(){
        super();
    }

    public Odrzavanje(Date datum, Zaposlenik zaposlenik, int sifra) {
        super(sifra);
        this.datum = datum;
        this.zaposlenik = zaposlenik;
    }
    
    

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Zaposlenik getZaposlenik() {
        return zaposlenik;
    }

    public void setZaposlenik(Zaposlenik zaposlenik) {
        this.zaposlenik = zaposlenik;
    }

    public List<PosaoBusotina> getPosloviBusotine() {
        return posloviBusotine;
    }

    public void setPosloviBusotine(List<PosaoBusotina> posloviBusotine) {
        this.posloviBusotine = posloviBusotine;
    }
    

    @Override
    public String toString() {
        return datum + ",  " + zaposlenik.getIme() + " " +  zaposlenik.getPrezime();
    }
	
	

}
