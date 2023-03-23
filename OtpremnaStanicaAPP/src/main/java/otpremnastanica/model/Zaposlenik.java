package otpremnastanica.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Zaposlenik extends Entitet {

	private String ime;
	private String prezime;
	private String oib;
	private String email;
	private String radnoMjesto;
        
        @OneToMany(mappedBy = "zaposlenik")
        private List<Odrzavanje> odrzavanja = new ArrayList<>();

	public Zaposlenik() {
		super();
	}

	public Zaposlenik(int sifra, String ime, String prezime, String oib, String email, String radnoMjesto) {
		super(sifra);
		this.ime = ime;
		this.prezime = prezime;
		this.oib = oib;
		this.email = email;
		this.radnoMjesto = radnoMjesto;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getOib() {
		return oib;
	}

	public void setOib(String oib) {
		this.oib = oib;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRadnoMjesto() {
		return radnoMjesto;
	}

	public void setRadnoMjesto(String radnoMjesto) {
		this.radnoMjesto = radnoMjesto;
	}

    public List<Odrzavanje> getOdrzavanja() {
        return odrzavanja;
    }

    public void setOdrzavanja(List<Odrzavanje> odrzavanja) {
        this.odrzavanja = odrzavanja;
    }
        
        
	@Override
	public String toString() {
		
		return ime + " " + prezime;
	}

        public String getImePrezime(){
            return ime + " " + prezime;
        }
        
         public String setImePrezime(){
        return ime + " " + prezime;
    }
}
