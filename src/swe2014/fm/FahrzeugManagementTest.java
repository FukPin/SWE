package swe2014.fm;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.*;

import swe2014.fm.fahrzeuge.*;
import swe2014.fm.fahrzeuge.dao.SerializedFahrzeugDAO;


public class FahrzeugManagementTest {

	int id;
	
	private FahrzeugManagement fahr1;
	private FahrzeugManagement fahr2;

	private Fahrzeug fzg1;
	private Fahrzeug fzg2;
	private Fahrzeug fzg3;
	private Fahrzeug fzg4;
	private Fahrzeug fzg5;

	private PKW pkw1;
	private PKW pkw2;

	private LKW lkw1;
	private LKW lkw2;
	
	GregorianCalendar gr = new GregorianCalendar(2008, 0, 2);
	GregorianCalendar gr1 = new GregorianCalendar(2009, 0, 2);
	GregorianCalendar gr2 = new GregorianCalendar(2006, 0, 2);
	GregorianCalendar gr3 = new GregorianCalendar(2008, 0, 2);
	GregorianCalendar gr4 = new GregorianCalendar(2005, 0, 2);
	GregorianCalendar gr5 = new GregorianCalendar(2008, 0, 2);


	@Before
	public void initialisiere() throws Exception {
		fahr1 = new FahrzeugManagement();
		fahr2 = new FahrzeugManagement();
		
		fzg1 = new PKW("", "", new Date(), 0, 0, 0, 0, new Date(), 0);
		fzg2 = new PKW("", "", new Date(), 0, 0, 0, 0, new Date(), 0);
		
		pkw1 = new PKW("", "", new Date(), 0, 0, 0, 0, new Date(), 0);
		pkw2 = new PKW("", "", new Date(), 0, 0, 0, 0, new Date(), 0);
		
		lkw1 = new LKW(null, null, null, id, id, id, id, null, id);
		
		

	}

	@After
	public void schliessen() throws Exception {
		fahr1 = null;
		fahr2 = null;
		
		pkw1 = null;
		pkw2 = null;
		
		fzg1 = null;
		fzg2 = null;
		
		lkw1 = null;
	}
	
/*
	@Test
	public void testFahrzeugAsPKW() {
		System.out.println("success");
		pkw1.setMarke("Audi");
		System.out.println("success1");
		pkw1.setModell("A4");
		pkw1.setBaujahr(gr.getTime());
		pkw1.setLeistung(220);
		pkw1.setKilometerstand(12000);
		pkw1.setGrundpreis(50000);
		pkw1.setId(748);
		pkw1.setUedatum(gr1.getTime());
		pkw1.setIntervall(1);
		pkw1.setAusstattung("Klimaanlage");
		pkw1.setAusstattung("Spoiler");
		pkw1.setAusstattung("Fensterheber");
		pkw1.setAusstattung("Navigation");

		pkw2.setMarke("BMW");
		pkw2.setModell("M5");
		pkw2.setBaujahr(gr4.getTime());
		pkw2.setLeistung(242);
		pkw2.setKilometerstand(1148);
		pkw2.setGrundpreis(82599.5f);
		pkw2.setId(333);
		pkw2.setUedatum(gr5.getTime());
		pkw2.setIntervall(2);
		pkw2.setAusstattung("Klimaanlage");
		pkw2.setAusstattung("Navigation");
		
		assertEquals("Audi", pkw1.getMarke());
		assertEquals("A4", pkw1.getModell());
		assertEquals(220, pkw1.getLeistung(),0);
		assertEquals(12000, pkw1.getKilometerstand(),0);
		assertEquals(50000, pkw1.getGrundpreis(), 0);
		assertEquals(748, pkw1.getId(), 0);
		assertEquals(1, pkw1.getIntervall(), 0);
		assertEquals(4, pkw1.getAusstattung().size());
		assertEquals(64, pkw1.getRabatt(),0);
		
		assertEquals("BMW", pkw2.getMarke());
		assertEquals("M5", pkw2.getModell());
		//assertEquals(2008, pkw2.getBaujahr());
		assertEquals(242, pkw2.getLeistung(),0);
		assertEquals(1148, pkw2.getKilometerstand(),0);
		assertEquals(82599.5f, pkw2.getGrundpreis(), 0);
		assertEquals(333, pkw2.getId(), 0);
		assertEquals(2, pkw2.getIntervall(), 0);
		assertEquals(2, pkw2.getAusstattung().size());
		

	}*/

	@Test
	public void testFahrzeug() {
		fzg1.setMarke("VW");
		fzg1.setModell("Passat");
		fzg1.setBaujahr(gr.getTime());
		fzg1.setLeistung(150);
		fzg1.setKilometerstand(25000);
		fzg1.setGrundpreis(12000);
		fzg1.setId(123);
		fzg1.setUedatum(gr1.getTime());
		fzg1.setIntervall(2);

		fzg2.setMarke("Mitsubishi");
		fzg2.setModell("Lancer Evolution");
		fzg2.setBaujahr(gr2.getTime());
		fzg2.setLeistung(294);
		fzg2.setKilometerstand(51555);
		fzg2.setGrundpreis(99999);
		fzg2.setId(592);
		fzg2.setUedatum(gr3.getTime());
		fzg2.setIntervall(1);
		
		lkw1.setMarke("Mercedes");
		lkw1.setModell("Actros SLT");
		lkw1.setBaujahr(gr4.getTime());
		lkw1.setLeistung(625);
		lkw1.setKilometerstand(114789);
		lkw1.setGrundpreis(87990);
		lkw1.setId(657);
		lkw1.setUedatum(gr5.getTime());
		lkw1.setIntervall(2);
		
		pkw2.setMarke("BMW");
		pkw2.setModell("M5");
		pkw2.setBaujahr(gr2.getTime());
		pkw2.setLeistung(242);
		pkw2.setKilometerstand(1148);
		pkw2.setGrundpreis(82599.5f);
		pkw2.setId(333);
		pkw2.setUedatum(gr3.getTime());
		pkw2.setIntervall(2);
		pkw2.setAusstattung("Klimaanlage");
		pkw2.setAusstattung("Navigation");
		
		

		fahr1.setFahrzeugDao(new SerializedFahrzeugDAO(
				"C:\\Users\\FukPin\\Desktop\\fahrzeug1.txt"));
		fahr1.getFahrzeugDao().speichereFahrzeug(fzg1);
		fahr1.getFahrzeugDao().speichereFahrzeug(fzg2);
		fahr1.getFahrzeugDao().speichereFahrzeug(pkw2);
		fahr1.getFahrzeugDao().speichereFahrzeug(lkw1);


		assertEquals("VW", fzg1.getMarke());
		assertEquals("Passat", fzg1.getModell());
		assertEquals(150, fzg1.getLeistung(),0);
		assertEquals(25000, fzg1.getKilometerstand(),0);
		assertEquals(12000, fzg1.getGrundpreis(), 0);
		assertEquals(123, fzg1.getId(), 0);
		assertEquals(2, fzg1.getIntervall(), 0);
		
		assertEquals("Mitsubishi", fzg2.getMarke());
		assertEquals("Lancer Evolution", fzg2.getModell());
		assertEquals(294, fzg2.getLeistung(),0);
		assertEquals(51555, fzg2.getKilometerstand(),0);
		assertEquals(99999, fzg2.getGrundpreis(), 0);
		assertEquals(592, fzg2.getId(), 0);
		assertEquals(1, fzg2.getIntervall(), 0);
		assertEquals(82, pkw2.getRabatt(),0);
		
		fahr1.alleDaten();
		//fahr1.aendernDaten(fzg1);
		fahr1.hinzufuegen(fzg1);
		fahr1.loeschen(fzg1);
		fahr1.gesamtZahl();
		fahr1.gesamtPKW();
		fahr1.gesamtLKW();
		fahr1.durchschnittsAlter();
		fahr1.schnittAlterPKW();
		fahr1.schnittAlterLKW();
		fahr1.aelteste();
		fahr1.aeltestePKW();
		fahr1.aeltesteLKW();
		fahr1.getFahrzeugDao().getFahrzeugList();
		fahr1.toString();
	}
}
	
	
		
		
		
