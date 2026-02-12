package est.end.Autobus;

import java.util.HashSet;

class Autobus {

    private final HashSet<Person> sitze;
    private final int sitzAnzahl;

    public Autobus(int sitze) {
        this.sitze = new HashSet<>();
        this.sitzAnzahl = sitze;
    }

    public boolean einsteigen(Person person) {
        if (person == null){
            throw new IllegalArgumentException("Person ist null");
        }
        if (sitze.contains(person)){
            return false;
            //throw new IllegalArgumentException("Person schon im Bus");
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
