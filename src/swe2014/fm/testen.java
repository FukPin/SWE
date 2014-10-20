package swe2014.fm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import swe2014.fm.fahrzeuge.Fahrzeug;
import swe2014.fm.fahrzeuge.PKW;
import swe2014.fm.fahrzeuge.LKW;

public class testen {
	public static ArrayList<Fahrzeug> Fahrzeuge = new ArrayList<Fahrzeug>();

	public static void speichereFahrzeug(Fahrzeug speichern) {

		OutputStream fos = null;

		try {
			fos = new FileOutputStream("C:\\Users\\FukPin\\Desktop\\hallo.txt");
			ObjectOutputStream o = new ObjectOutputStream(fos);
			Fahrzeuge.add(speichern);
			o.writeObject(Fahrzeuge);

		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void ladeFahrzeug() {
		InputStream fis = null;

		try {
			fis = new FileInputStream("C:\\Users\\FukPin\\Desktop\\hallo.txt");
			ObjectInputStream o = new ObjectInputStream(fis);
			ArrayList<Fahrzeug> fahre = (ArrayList<Fahrzeug>) o.readObject();

			System.out.println(fahre.get(0).getMarke());
			System.out.println(fahre.get(1).getMarke());

		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {

		GregorianCalendar gr = new GregorianCalendar(2008, 0, 2);
		GregorianCalendar gr1 = new GregorianCalendar(2009, 0, 2);

		Fahrzeug auto = new PKW("", "", new Date(), 0, 0, 0, 0, new Date(), 0);
		Fahrzeug auto2 = new PKW("", "", new Date(), 0, 0, 0, 0, new Date(), 0);

		auto.setMarke("VW");
		auto.setModell("Passat");
		auto.setBaujahr(gr.getTime());
		auto.setLeistung(150);
		auto.setKilometerstand(25000);
		auto.setGrundpreis(12000);
		auto.setId(123);
		auto.setUedatum(gr1.getTime());
		auto.setIntervall(2);
		auto2.setMarke("Audi");
		auto2.setModell("A4");
		// auto.setAusstattung("hallo");

		// System.out.println(auto.getAusstattung().get(0));

		System.out.println("[Marke: " + auto.getMarke() + "\nModell: "
				+ auto.getModell() + "\nBaujahr: " + auto.getBaujahr()
				+ "\nLeistung: " + auto.getLeistung() + "\nKilometerstand: "
				+ auto.getKilometerstand() + "\nGrundpreis: "
				+ auto.getGrundpreis() + "\nID: " + auto.getId()
				+ "\nUeberpruefungsdatum: " + auto.getUedatum()
				+ "\nUeberpruefungsintervall: " + auto.getIntervall()
				+ "\nPreis:" + auto.getAlter() + "\n" + auto.getPreis());

		float gesamt = 0;
		float[] zahlen = { 1, 2, 3 };

		for (int i = 0; i < zahlen.length; i++) {
			gesamt += zahlen[i];
		}
		System.out.println("Durchschnnittalter: " + gesamt / zahlen.length);
		// "\nAusstattungspakete: " + auto.getAusstattung().toString() +
		// " ]");*/

		speichereFahrzeug(auto);
		speichereFahrzeug(auto2);
		ladeFahrzeug();

	}

}
