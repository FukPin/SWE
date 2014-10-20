package swe2014.fm.fahrzeuge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Fahrzeug implements Serializable {

	private String marke;
	private String modell;
	private Date baujahr;
	private float leistung;
	private float kilometerstand;
	private float grundpreis;
	private int id;
	private Date uedatum;
	private int intervall;

	abstract float getRabatt();

	public Fahrzeug(String marke, String modell, Date baujahr, float leistung,
			float kilometerstand, float grundpreis, int id, Date uedatum,
			int intervall) {

		this.marke = marke;
		this.modell = modell;
		this.baujahr = baujahr;
		this.leistung = leistung;
		this.kilometerstand = kilometerstand;
		this.grundpreis = grundpreis;
		this.id = id;
		this.uedatum = uedatum;
		this.intervall = intervall;

	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public Date getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(Date baujahr) {
		Date dt = new Date();
		if (dt.getTime() <= baujahr.getTime()) {
			throw new IllegalArgumentException("Baujahr falsch!");
		}
		this.baujahr = baujahr;
	}

	public float getLeistung() {
		return leistung;
	}

	public void setLeistung(float leistung) {
		this.leistung = leistung;
	}

	public float getKilometerstand() {
		return kilometerstand;
	}

	public void setKilometerstand(float kilometerstand) {
		this.kilometerstand = kilometerstand;
	}

	public float getGrundpreis() {
		return grundpreis;
	}

	public void setGrundpreis(float grundpreis) {
		this.grundpreis = grundpreis;
	}

	public float getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUedatum() {
		return uedatum;
	}

	public void setUedatum(Date uedatum) {
		Date dt = new Date();
		if (dt.getTime() <= uedatum.getTime()) {
			throw new IllegalArgumentException("Datum falsch!");
		}
		this.uedatum = uedatum;
	}

	public float getIntervall() {
		return intervall;
	}

	public void setIntervall(int intervall) {
		this.intervall = intervall;
	}

	public float getAlter() {
		Date dt = new Date();
		float alter = dt.getYear() - baujahr.getYear();
		return alter;
	}

	@SuppressWarnings("static-access")
	public Date getNaechstePruefung() {
		GregorianCalendar gr = new GregorianCalendar();
		gr.setTime(this.uedatum);
		gr.add(gr.YEAR, this.intervall);
		return gr.getTime();
	}

	public float getPreis() {
		float r = grundpreis * (getRabatt() / 100);
		return grundpreis - r;
	}

}
