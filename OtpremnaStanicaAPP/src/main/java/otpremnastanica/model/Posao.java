package otpremnastanica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Posao extends Entitet {

	private String naziv;
        @OneToMany(mappedBy = "posao")
        private List<PosaoBusotina> posloviBusotine = new ArrayList<>(); 

	public Posao() {
		super();
	}

	public Posao(int sifra, String naziv) {
		super(sifra);
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

    public List<PosaoBusotina> getPosloviBusotine() {
        return posloviBusotine;
    }

    public void setPosloviBusotine(List<PosaoBusotina> posloviBusotine) {
        this.posloviBusotine = posloviBusotine;
    }
        
        
	@Override
	public String toString() {
	
		return naziv;
	}

}
