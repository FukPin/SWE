package swe2014.fm.fahrzeuge.dao;

import java.util.ArrayList;

import swe2014.fm.fahrzeuge.Fahrzeug;

public interface FahrzeugDAO {

	public ArrayList<Fahrzeug> getFahrzeugList();

	public Fahrzeug getFahrzeugbyId(int id);

	public void speichereFahrzeug(Fahrzeug speichern);

	public void loescheFahrzeug(Fahrzeug loeschen);

	public void aktualisiereFahrzeug(Fahrzeug fahrID);

}
