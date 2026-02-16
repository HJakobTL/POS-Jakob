package est.end;

import java.util.ArrayList;
import java.util.Iterator;

public class Personalbuero {

    private final ArrayList<Mitarbeiter> employees;

    public Personalbuero() {
        employees = new ArrayList<>();
    }

    public boolean aufnehmen(Mitarbeiter ma) {
        if (ma == null || ma.berechneAlter() < 15 || employees.contains(ma)) return false;
        return employees.add(ma);
    }

    public double berechneGehaltsumme() {
        double summe = 0.0;
        for (Mitarbeiter ma: employees) {
            summe += ma.berechneGehalt();
        }
        return summe;
    }

    public double berechneDurchschnittsalter() {
        double sumAlter = 0.0;
        if (employees.isEmpty()) return -99.0;
        for (Mitarbeiter ma: employees) {
            sumAlter += ma.berechneAlter();
        }
        return sumAlter / employees.size();
    }

    public int zaehleMitarbeiter() {
        return employees.size();
    }

    public int kuendigeAlle(String name) {
        if (name == null) throw new IllegalArgumentException("Fehler: null");
        if (employees.isEmpty()) return -99;
        int count = 0;
        Iterator<Mitarbeiter> iterator = employees.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getName().equals(name)){
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public float kuendigen(float gehalt){
        if (employees.isEmpty()) throw new IllegalArgumentException("Error: Keine Employees");
        Iterator<Mitarbeiter> iterator = employees.iterator();
        double gehaltSumme = 0.0;
        while(iterator.hasNext()) {
            Mitarbeiter ma = iterator.next();
            if (ma.berechneGehalt() > (double) gehalt) {
                gehaltSumme += ma.berechneGehalt();
                iterator.remove();
            }
        }
        return (float) gehaltSumme;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personalbuero:\n");
        if (!employees.isEmpty()) {
            for (Mitarbeiter ma : employees) {
                sb.append(ma).append("\n");
            }
        }
        else sb.append("Keine Mitarbeiter vorhanden");
        return sb.toString();
    }
}
