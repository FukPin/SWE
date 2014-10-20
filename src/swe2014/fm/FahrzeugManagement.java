package swe2014.fm;

import swe2014.fm.fahrzeuge.Fahrzeug;
import swe2014.fm.fahrzeuge.LKW;
import swe2014.fm.fahrzeuge.PKW;
import swe2014.fm.fahrzeuge.dao.FahrzeugDAO;

public class FahrzeugManagement {

	private FahrzeugDAO fahrzeugDao;

	public FahrzeugDAO getFahrzeugDao() {
		return fahrzeugDao;
	}

	public void setFahrzeugDao(FahrzeugDAO fahrzeugDao) {
		this.fahrzeugDao = fahrzeugDao;
	}

	public void alleDaten() {
		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			fahrzeugDao.getFahrzeugList().get(i).toString();
		}
	}

	public void aendernDaten(Fahrzeug fahr) {
		fahrzeugDao.aktualisiereFahrzeug(fahr);

	}

	public void hinzufuegen(Fahrzeug fahr) {
		fahrzeugDao.speichereFahrzeug(fahr);
	}

	public void loeschen(Fahrzeug fahr) {
		fahrzeugDao.loescheFahrzeug(fahr);
	}

	public void gesamtZahl() {
		System.out.println("Gesamtzahl Fahrzeuge: "
				+ fahrzeugDao.getFahrzeugList().size());
	}

	public void gesamtPKW() {
		int j = 0;
		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i) instanceof PKW) {
				j++;

			}
		}
		System.out.println("Anzahl PKW's: " + j);
	}

	public void gesamtLKW() {
		int j = 0;
		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i) instanceof LKW) {
				j++;

			}
		}
		System.out.println("Anzahl LKW's: " + j);
	}

	public void durchschnittsAlter() {
		float gesamt = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			gesamt += fahrzeugDao.getFahrzeugList().get(i).getAlter();
		}
		System.out.println("Durchschnittsalter: " + (gesamt
				/ fahrzeugDao.getFahrzeugList().size()/2));
	}

	public void schnittAlterPKW() {
		float gesamt = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i) instanceof PKW) {
				gesamt += fahrzeugDao.getFahrzeugList().get(i).getAlter();
			}
		}
		System.out.println("Durchschnittsalter PKW: " + gesamt
				/ fahrzeugDao.getFahrzeugList().size());
	}

	public void schnittAlterLKW() {
		float gesamt = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i) instanceof LKW) {
				gesamt += fahrzeugDao.getFahrzeugList().get(i).getAlter();
			}
		}
		System.out.println("Durchschnittsalter LKW: " + gesamt
				/ fahrzeugDao.getFahrzeugList().size());
	}

	public void durchschnittsPreis() {
		float gesamt = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			gesamt += fahrzeugDao.getFahrzeugList().get(i).getPreis();
		}
		System.out.println("Durchschnittspreis: " + gesamt
				/ fahrzeugDao.getFahrzeugList().size());
	}

	public void schnittPreisPKW() {
		float gesamt = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i) instanceof PKW) {
				gesamt += fahrzeugDao.getFahrzeugList().get(i).getPreis();
			}
		}
		System.out.println("Durchschnittspreis PKW: " + gesamt
				/ fahrzeugDao.getFahrzeugList().size());
	}

	public void schnittPreisLKW() {
		float gesamt = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i) instanceof LKW) {
				gesamt += fahrzeugDao.getFahrzeugList().get(i).getPreis();
			}
		}
		System.out.println("Durchschnittspreis LKW: " + gesamt
				/ fahrzeugDao.getFahrzeugList().size());
	}

	public void aelteste() {
		float max = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i).getAlter() > max) {
				max = fahrzeugDao.getFahrzeugList().get(i).getAlter();
			}
		}
		System.out.println("Ältestes Fahrzeug: " + max);
	}

	public void aeltestePKW() {
		float max = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i).getAlter() > max
					&& fahrzeugDao.getFahrzeugList().get(i) instanceof PKW) {
				max = fahrzeugDao.getFahrzeugList().get(i).getAlter();
			}
		}
		System.out.println("Ältester PKW: " + max);
	}

	public void aeltesteLKW() {
		float max = 0;

		for (int i = 0; i < fahrzeugDao.getFahrzeugList().size(); i++) {
			if (fahrzeugDao.getFahrzeugList().get(i).getAlter() > max
					&& fahrzeugDao.getFahrzeugList().get(i) instanceof LKW) {
				max = fahrzeugDao.getFahrzeugList().get(i).getAlter();
			}
		}
		System.out.println("Ältester LKW: " + max);
	}

}
