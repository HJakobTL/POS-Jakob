package at.spengergasse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Versicherungsmakler {
    private String name;
    private List<Vertrag> vertraege;

    public Versicherungsmakler(String name) throws VersicherungException {
        setName(name);
        vertraege = new LinkedList<>();
    }

    public void setName(String name) throws VersicherungException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new VersicherungException("Fehler: name ist ungültig");
        }
//        if(name == null || name.isEmpty() ) {   // fail-fast
//            throw new VersicherungException("Fehler: name ist ungültig");
//        }
//        this.name = name;
    }

    public int anzahlVertraege() {
        return vertraege.size();
    }

    public boolean hinzufuegen(Vertrag vertrag) throws VersicherungException {
        if (vertrag != null && vertraege.contains(vertrag)) {
            vertraege.add(vertrag);
        } else {
            throw new VersicherungException("Fehler: Vertrag kann nicht hinzugefügt werden (ungültig oder schon vorhanden)");
        }
        return false;
    }

    public double berechneGesamtPreis() {
        double preisGesamt = 0.0;
        for (Vertrag vertrag : vertraege) {
            preisGesamt += vertrag.berechnePreis();
        }
        return preisGesamt;
    }

    public double summeQuadratmeter() {
        double summe = 0.0;
        for (Vertrag vertrag : vertraege) {
            if (vertrag instanceof Haushaltspolizze) {
                summe += ((Haushaltspolizze)vertrag).getQuadratmeter();
            }
        }
        return summe;
    }

    public void sortierePreis() throws VersicherungException {
        if(vertraege.isEmpty()) {
            throw new VersicherungException("Fehler: keine Verträge zum Sortieren vorhanden");
        }
        vertraege.sort(null);
    }

    public int removeVertrag(double preis) throws VersicherungException {
        int count = 0;
        if (vertraege.isEmpty() || preis <= 0.0) {
            throw new VersicherungException("Fehler: keine Veträge vorhanden oder preis ungültig");
        }
        Iterator<Vertrag> iterator = vertraege.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().berechnePreis() < preis) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public void sortiereSumme() {
        vertraege.sort(new SummeComparator());
        //vertraege.sort(Comparator.comparingDouble(Vertrag::getSumme));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Versicherungsmakler:\n");
        if (vertraege.isEmpty()) {
            sb.append("keine Verträge vorhanden");
        } else {
           for(Vertrag vertrag : vertraege) {
               sb.append(vertrag).append("\n");
           }
        }
        return sb.toString();
    }
}
