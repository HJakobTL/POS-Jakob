package est.end.Autobus;

import java.util.ArrayList;

class Autobus {

    private final ArrayList<Person> sitze;
    private final int sitzAnzahl;

    public Autobus(int sitze) {
        this.sitze = new ArrayList<>();
        this.sitzAnzahl = sitze;
    }

    // Anforderungen an die Methode:

    // 1) Exception werfen wenn
    // 1a) person is null
    // 2a) person ist bereits im Bus (caller über logikfehler informieren)

    // 2) die Person auf den ersten freien Sitz setzten und "true" zurückgeben
    // 3) wenn kein Platz mehr frei ist, nix machen und "false" zurückgeben
    public boolean einsteigen(Person person) {
        if (person == null){
            throw new IllegalArgumentException("Person ist null");
        }
        if (sitze.contains(person)){
            throw new IllegalArgumentException("Person schon im Bus");
        }
        if (sitze.size() < sitzAnzahl) {
             return sitze.add(person);
        }
        return false;
    }

    public boolean istDrin(Person person) {
        return sitze.contains(person);
    }

    public boolean istVoll(){
        return sitze.size() >= sitzAnzahl;
    }

    public boolean hatPlatz(){
        return istDrin(null);
    }
}
