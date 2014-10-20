package swe2014.fm.fahrzeuge;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PKW extends Fahrzeug {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> ausstattung = new ArrayList<String>();

	public PKW(String marke, String modell, Date baujahr, float leistung,
			float kilometerstand, float grundpreis, int id, Date uedatum,
			int intervall) {
		super(marke, modell, baujahr, leistung, kilometerstand, grundpreis, id,
				uedatum, intervall);
		 this.ausstattung = ausstattung;
	}

	public List<String> getAusstattung() {
		return ausstattung;
	}

	public void setAusstattung(String ausstattunga) {
		this.ausstattung.add(ausstattunga);

	}

	public float getRabatt() {

		float rabatt;

		if (ausstattung.size() < 5)
			rabatt = (getAlter() * 10) + 1 * ausstattung.size();
		else
			rabatt = getAlter() * 10 + 5;

		if (rabatt < 95)
			return rabatt;
		else
			return 95;
	}

	public String toString() {

		return "[Marke: " + getMarke() + "\nModell: " + getModell()
				+ "\nBaujahr: " + getBaujahr() + "\nLeistung: " + getLeistung()
				+ "\nKilometerstand: " + getKilometerstand() + "\nGrundpreis: "
				+ getGrundpreis() + "\nID: " + getId()
				+ "\nUeberpruefungsdatum: " + getUedatum()
				+ "\nUeberpruefungsintervall: " + getIntervall()
				+ "\nAusstattungspakete: " + getAusstattung().toString() + " ]";
	}
}
