package otpremnastanica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class NaftnoPolje extends Entitet {

	private String naziv;
        @OneToMany(mappedBy = "naftnoPolje")
        private List<Busotina> busotine;

	public NaftnoPolje() {
		super();
	}

	public NaftnoPolje(int sifra, String naziv) {
		super(sifra);
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

    public List<Busotina> getBusotine() {
        return busotine;
    }

    public void setBusotine(List<Busotina> busotine) {
        this.busotine = busotine;
    }
        
	@Override
	public String toString() {
		
		return naziv;
	}

}
