package est.end;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Year;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Personalbuero{
    private List<Mitarbeiter> employees;

    public Personalbuero() {
        employees = new LinkedList<>();
    }

    public boolean aufnehmen(Mitarbeiter mitarbeiter) {
        if (mitarbeiter == null ||
                mitarbeiter.berechneAlter() < 15 ||
                employees.contains(mitarbeiter)) {
            return false;
        }
        return employees.add(mitarbeiter);
    }

    public double berechneGehaltsumme() {
        double summe = 0.0;
        for (Mitarbeiter ma : employees) {
            summe += ma.berechneGehalt();
        }
        return summe;
    }

    public double berechneDurchschnittsalter() {
        if(employees.isEmpty()) {
            return -99.0;
        }
        double summe = 0.0;
        for (Mitarbeiter ma : employees) {
            summe += ma.berechneAlter();
        }
        return summe / employees.size();
    }

    public int zaehleMitarbeiter() {
        return employees.size();
    }

    // wenn keine MA vorhanden, dann return -99;
    public int kuendigeAlle(String name) throws PersonalException {
        if (name == null) {
            //throw new IllegalArgumentException("Fehler: null");
            throw new PersonalException("Fehler: null");
        }
        if (employees.isEmpty()) {
            return -99;
        }
        int count = 0;

        /* ConcurrentModification Exception - SO NICHT
        for(Mitarbeiter ma : employees) {  // SO NICHT
            if (ma.getName().equals(name)) {
                employees.remove(ma);
                count++;
            }
        }
         */
        Iterator<Mitarbeiter> iterator = employees.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().getName().equals(name)) {
                // employees.remove(iterator.next()); // FEHLER SO NICHT
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public double kuendigenGeld(double gehalt) throws PersonalException {
        if (gehalt <= 0.0) {
            //throw new IllegalArgumentException("Fehler: gehalt 0.0 oder kleiner");
            throw new PersonalException("Fehler: gehalt 0.0 oder kleiner");
        }
        Iterator<Mitarbeiter> iterator = employees.iterator();
        double gehaltSumme = 0.0;
        Mitarbeiter ma;
        while(iterator.hasNext()) {
            ma = iterator.next();
            if(ma.berechneGehalt() > gehalt) {
                gehaltSumme += ma.berechneGehalt();
                iterator.remove();
            }
        }
        return gehaltSumme;
    }

    public int kuendigenAlle(Year eintrJahr) {
        if(eintrJahr == null || eintrJahr.isAfter(Year.now()) || employees.isEmpty()) {
            return -99;
        }
        Iterator<Mitarbeiter> iterator = employees.iterator();
        int anzahlGekuendigt = 0;
        while(iterator.hasNext()) {
            if(iterator.next().getEintrJahr().equals(eintrJahr)) {
                iterator.remove();
                anzahlGekuendigt++;
            }
        }
        return anzahlGekuendigt;
    }

    public int zaehleAlter(int alter) throws PersonalException {
        if(alter < 15) {
            //throw new IllegalArgumentException("Fehler: zu jung");
            throw new PersonalException("Fehler: zu jung");
        }
        if(employees.isEmpty()) {
            return -99;
        }
        int count = 0;
        for (Mitarbeiter ma : employees) {
            if (ma.berechneAlter() == alter) {
                count++;
            }
        }
        return count;
    }

    public Mitarbeiter kuendigen (int pos) throws PersonalException { // pos entspricht dem index
        if (pos < 0 || pos >= employees.size()) {
            //throw new IllegalArgumentException("Fehler: index ungültig");
            throw new PersonalException("Fehler: index ungültig");
        }
        return employees.remove(pos);
    }

    public boolean kuendigen(String name) throws PersonalException {
        if (name == null || name.isBlank()) {
            //throw new IllegalArgumentException("Fehler: name ungültig");
            throw new PersonalException("Fehler: name ungültig");
        }
        for(Mitarbeiter ma : employees) {
            if (ma.getName().equals(name)) {
                //return employees.remove(ma);
                return kuendigen(ma);
            }
        }
        return false;
    }

    public boolean kuendigen(Mitarbeiter ma) throws PersonalException {
        if (ma == null) {
            //throw new IllegalArgumentException("Fehler: null");
            throw new PersonalException("Fehler: null");
        }
        return employees.remove(ma);
    }

    public void gehaltsListe() {
        System.out.println("Gehaltsliste:");
        if (!employees.isEmpty()) {
            for(Mitarbeiter ma : employees) {
                System.out.print("Name: " + ma.getName());
                System.out.println(", Gehalt: " + ma.berechneGehalt() + " EUR");
            }
            System.out.println("Gehaltsumme: " + berechneGehaltsumme() + " EUR");
        } else {
            System.out.println("Keine MitarbeiterInnen vorhanden");
        }
    }

    public boolean sortiereNachnamen() {
        employees.sort(null);
        return true;
    }

    public int summeFreelancerStunden() {
        if(employees.isEmpty()) {
            return -99;
        }
        int summeStunden = 0;
        for (Mitarbeiter ma : employees) {
            if(ma instanceof Freelancer) {
                summeStunden += ((Freelancer) ma).getStunden();
            }
        }
        return summeStunden;
    }

    public int anzAngestellte() {
        if (employees.isEmpty()) {
            return -99;
        }
        int anzahlAngestellte = 0;
        for (Mitarbeiter ma : employees) {
            if (ma instanceof Angestellter) {
                anzahlAngestellte++;
            }
        }

        return anzahlAngestellte;
    }

    public Mitarbeiter getMitarbeiter(int index) {
        if(index < 0 || index >= employees.size()) {
            return null;
        }
        return employees.get(index);
    }

    public void sortierenNachGehalt() { // double -> Double.compare()
        employees.sort((o1, o2) ->
                Double.compare(o1.berechneGehalt(), o2.berechneGehalt()));
    }

    public void sortierenNachDienstalter() {
        employees.sort(Comparator.comparingInt(Mitarbeiter::berechneDienstalter));
    }

//    public void sortierenNachDienstalter() {
//        employees.sort((o1, o2) ->
//                Integer.compare(o1.berechneDienstalter(), o2.berechneDienstalter()));
//    }

//    public void sortierenNachDienstalter() {
//        employees.sort(new Comparator<Mitarbeiter>() {
//            @Override
//            public int compare(Mitarbeiter o1, Mitarbeiter o2) {
//                return Integer.compare(o1.berechneDienstalter(), o2.berechneDienstalter());
//            }
//        });
//    }

    public void sortierenNachAlter() {
//        Comparator<Mitarbeiter> meinAlterComparator = new AlterComparator();
//        employees.sort(meinAlterComparator);
        employees.sort(new AlterComparator());
    }

    public void save() throws PersonalException {
        String filepath = "src/main/java/resources/person.ser";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {

            oos.writeObject(employees);

        } catch (FileNotFoundException e) {
            throw new PersonalException(e.getMessage());
        } catch (IOException e) {
            throw new PersonalException(e.getMessage());
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personalbüro:\n");
        if(!employees.isEmpty()) {
            for (Mitarbeiter ma : employees) {
                sb.append(ma).append("\n");
            }
        } else {
            sb.append("keine Mitarbeiter vorhanden");
        }
        return sb.toString();
    }
}
