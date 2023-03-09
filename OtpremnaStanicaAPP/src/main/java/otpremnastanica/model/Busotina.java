package otpremnastanica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Busotina extends Entitet {
	
	private String naziv;
	private boolean aktivna;
        @ManyToOne
	private NaftnoPolje naftnoPolje;
    
    public Busotina(){
        super();
    }

    public Busotina(String naziv, boolean aktivna, NaftnoPolje naftnoPolje, int sifra) {
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

	

	
}
