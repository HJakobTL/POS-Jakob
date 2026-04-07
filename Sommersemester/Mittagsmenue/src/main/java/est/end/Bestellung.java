package est.end;

import java.util.ArrayList;
import java.util.Iterator;

public class Bestellung implements Comparable<Menus> {

    private static long id;
    private long bestellNr;
    private int tischNr;
    private ArrayList<Menus> menues;
    private boolean abgeschlossen;


    public Bestellung(int tischNr, Menus menus) {
        this.menues = new ArrayList<>();
        setTischNr(tischNr);
    }

    public static long getId() {
        return id;
    }

    public int getTischNr() {
        return tischNr;
    }

    public long getBestellNr() {
        return bestellNr;
    }

    public boolean isAbgeschlossen() {
        return abgeschlossen;
    }

    private void setBestellNr(long bestellNr) {
        this.bestellNr = id;
        id++;
    }

    public void setTischNr(int tischNr) {
        if (tischNr < 1) throw new IllegalArgumentException("Fehler: muss größer 0 sein");
        this.tischNr = tischNr;
    }

    public ArrayList<Menus> getMenues() {
        return menues;
    }

    public void setMenues(ArrayList<Menus> menues) {
        this.menues = menues;
    }

    public boolean bestellen(Menus menu) {
        if (!this.isAbgeschlossen()) return false;
        if (menu == null) throw new IllegalArgumentException("Fehler");
        return menues.add(menu);
    }

    public int anzahlMenues() {
        return menues.size();
    }

    public double gesamtPreisBestellung() {
        if (menues.isEmpty() || !this.isAbgeschlossen()) {
            return -99.0;
        }
        double sumPreis = 0;
        for (Menus m : menues) {
            sumPreis += m.berechneGesamtPreis();
        }
        return sumPreis;
    }

    public double bestellungAbschliessen() {
        if (menues.isEmpty() || this.isAbgeschlossen()) {
            return -99.0;
        }
        this.abgeschlossen = true;
        return gesamtPreisBestellung();
    }

    public int entfernenAlleTeurerAls(double gesamtPreis) {
        if (menues.isEmpty() || this.isAbgeschlossen()) return -99;
        int count = 0;
        Iterator<Menus> iterator = menues.iterator();
        while (iterator.hasNext()) {
            Menus menu = iterator.next();
            if (menu.berechneGesamtPreis() > gesamtPreis) {
                iterator.remove();
                count++;

            }
        }
        return count;
    }

    @Override
    public int compareTo(Menus menus) {
        return menus.compareTo(null);
    }

    @Override
    public String toString() {
        return "Bestellung{" +
                "bestellNr=" + bestellNr +
                ", tischNr=" + tischNr +
                ", menues=" + menues +
                ", abgeschlossen=" + abgeschlossen +
                '}';
    }
}
