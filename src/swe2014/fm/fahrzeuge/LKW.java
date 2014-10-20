package swe2014.fm.fahrzeuge;

import java.util.Date;

public class LKW extends Fahrzeug {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LKW(String marke, String modell, Date baujahr, float leistung,
			float kilometerstand, float grundpreis, int id, Date uedatum,
			int intervall) {
		super(marke, modell, baujahr, leistung, kilometerstand, grundpreis, id,
				uedatum, intervall);
	}

	public float getRabatt() {
		float rabatt = getAlter() * 0.05f;

		if (rabatt < 0.9f)
			return rabatt;
		else
			return 0.9f;
	}

	public String toString() {

		return "[Marke: " + getMarke() + "\nModell: " + getModell()
				+ "\nBaujahr: " + getBaujahr() + "\nLeistung: " + getLeistung()
				+ "\nKilometerstand: " + getKilometerstand() + "\nGrundpreis: "
				+ getGrundpreis() + "\nID: " + getId()
				+ "\nUeberpruefungsdatum: " + getUedatum()
				+ "\nUeberpruefungsintervall: " + getIntervall() + " ]";
	}
}
