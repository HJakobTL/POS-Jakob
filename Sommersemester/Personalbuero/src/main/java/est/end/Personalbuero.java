package est.end;

import java.util.ArrayList;

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
