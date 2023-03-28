package otpremnastanica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Busotina extends Entitet {
	
	private String naziv;
	private boolean aktivna;
        @ManyToOne
	private NaftnoPolje naftnoPolje;
        @OneToMany (mappedBy = "busotina")
         private List<PosaoBusotina> posloviBušotine = new ArrayList<>();
    
    public Busotina(){
        super();
    }

    public Busotina(int sifra,String naziv, boolean aktivna, NaftnoPolje naftnoPolje) {
        super(sifra);
        this.naziv = naziv;
        this.aktivna = aktivna;
        this.naftnoPolje = naftnoPolje;
    }
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isAktivna() {
        return aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    public NaftnoPolje getNaftnoPolje() {
        return naftnoPolje;
    }

    public void setNaftnoPolje(NaftnoPolje naftnoPolje) {
        this.naftnoPolje = naftnoPolje;
    }

    public List<PosaoBusotina> getPosloviBušotine() {
        return posloviBušotine;
    }

    public void setPosloviBušotine(List<PosaoBusotina> posloviBušotine) {
        this.posloviBušotine = posloviBušotine;
    }

    @Override
    public String toString() {
        return naziv ;
    }

	

	
}
