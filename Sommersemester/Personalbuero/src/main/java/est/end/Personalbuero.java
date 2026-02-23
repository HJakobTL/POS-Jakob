package est.end;

import java.util.*;

public class Personalbuero {

    private final List<Mitarbeiter> employees;

    public Personalbuero() {
        employees = new LinkedList<>();
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

    public float kuendigenGeld(float gehalt){
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

   public int zaehleAlter(int alter) {
        int anz = 0;
        if (employees.isEmpty()) return -99;
        if (alter < 15) throw new IllegalArgumentException("Alter muss mind. 15 sein");
        for (Mitarbeiter ma : employees) {
            if (ma.berechneAlter() == alter) anz++;
        }
        return anz;
    }

    public Mitarbeiter kuendigen(int pos) {
        if (pos < 0 || pos >= employees.size()) throw new IllegalArgumentException("Fehler index ungültig");
        return employees.remove(pos);

    }

    public boolean kuendigen(String name) {
        if (employees.isEmpty() || name.isEmpty()) throw new IllegalArgumentException("Fehler null");
        for (Mitarbeiter ma : employees) {
            if (Objects.equals(ma.getName(), name)) {
                return kuendigen(ma);
            }
        }
        return true;
    }

    public boolean kuendigen(Mitarbeiter ma) {
        if(ma == null) throw new IllegalArgumentException("Fehler: null");
        return employees.remove(ma);
    }

    public void gehaltsListe() {
     IO.println("Gehaltsliste: \n");
     for (Mitarbeiter ma : employees) {
         if (!employees.isEmpty()) {
             IO.println(ma.getName());
             IO.println(ma.berechneGehalt());
         } else {
             IO.println("Keine Mitarbeiter vorhanden!");
         }
     }
        IO.println("Gehaltsumme: " + berechneGehaltsumme() + " EUR");

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
