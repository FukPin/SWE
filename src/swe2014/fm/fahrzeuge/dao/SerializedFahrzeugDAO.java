package swe2014.fm.fahrzeuge.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import swe2014.fm.fahrzeuge.Fahrzeug;

public class SerializedFahrzeugDAO implements FahrzeugDAO {

	private String basePath;
	ArrayList<Fahrzeug> fahre = new ArrayList<Fahrzeug>();
	int n = 0;
	//ArrayList<Fahrzeug> Fahrzeuge = new ArrayList<Fahrzeug>();

	public SerializedFahrzeugDAO(String basePath) {
		this.basePath = basePath;

	}

	public ArrayList<Fahrzeug> getFahrzeugList() {

		InputStream fis = null;

		try {
			fis = new FileInputStream(basePath);
			ObjectInputStream o = new ObjectInputStream(fis);
			ArrayList<Fahrzeug> fahre = (ArrayList<Fahrzeug>) o.readObject();
			fis.close();
		}

		catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}

		return fahre;

	}

	public Fahrzeug getFahrzeugbyId(int id) {
		ObjectInputStream is;
		try {
			is = new ObjectInputStream(new FileInputStream(basePath + id));
			Fahrzeug newfahrzeug = (Fahrzeug) is.readObject();
			is.close();
			return newfahrzeug;
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("user datei existiert nicht");
		} catch (IOException e) {
			throw new IllegalArgumentException("eingabe fehler");
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(
					"Klasse kann nicht erreicht werden.");
		}

	}

	public void speichereFahrzeug(Fahrzeug speichern) {
		OutputStream fos = null;

		try {
			fos = new FileOutputStream(basePath);
			ObjectOutputStream o = new ObjectOutputStream(fos);
			fahre.add(speichern); 
			o.writeObject(fahre);
			o.close();

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

	public void loescheFahrzeug(Fahrzeug loeschen) {
		InputStream fis = null;

		try {
			fis = new FileInputStream(basePath);
			ObjectInputStream o = new ObjectInputStream(fis);
			ArrayList<Fahrzeug> fahre = (ArrayList<Fahrzeug>) o.readObject();

			for (int i = 0; i < fahre.size(); i++) {
				if (fahre.get(i).getId() != loeschen.getId()) {
					speichereFahrzeug(fahre.get(i));
				}
			}
			o.close();
		} catch (IOException e) {
			System.err.println();
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		} finally {
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
	}

	public void aktualisiereFahrzeug(Fahrzeug fahrID) {
		InputStream fis = null;

		try {
			fis = new FileInputStream(basePath);
			ObjectInputStream o = new ObjectInputStream(fis);
			ArrayList<Fahrzeug> fahre = (ArrayList<Fahrzeug>) o.readObject();

			Fahrzeug fa = null;

			for (int i = 0; i < fahre.size(); i++) {
				if (fahre.get(i).getId() == fahrID.getId()) {
					fa = fahre.get(i);
				}
			}

			loescheFahrzeug(fa);

			System.out.println("Was moechten Sie machen?!");
			Scanner sc = new Scanner(System.in);

			System.out.println("1.Marke aendern?");
			System.out.println("2.Modell aendern?");
			System.out.println("3.Leistung aendern?");
			System.out.println("4.Kilometerstand aendern?");
			System.out.println("5.Grundpreis aendern?");
			System.out.println("6.ID aendern?");

			if (sc.nextInt() == 1) {
				fa.setMarke(sc.nextLine());
			}

			if (sc.nextInt() == 2) {
				fa.setModell(sc.nextLine());
			}

			if (sc.nextInt() == 3) {
				fa.setLeistung(sc.nextFloat());
			}

			if (sc.nextInt() == 4) {
				fa.setKilometerstand(sc.nextFloat());
			}

			if (sc.nextInt() == 5) {
				fa.setGrundpreis(sc.nextFloat());
			}

			if (sc.nextInt() == 6) {
				fa.setId(sc.nextInt());
			}

			speichereFahrzeug(fa);
			o.close();
			sc.close();
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

}
