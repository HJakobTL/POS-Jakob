package est.end;

import java.time.Year;

public class Angestellter extends Mitarbeiter{
    public Angestellter(String name, Year gebJahr, Year eintrJahr) throws PersonalException {
        super(name, gebJahr, eintrJahr);
    }

    public Angestellter(String line) throws PersonalException {
        super(line);
    }

    @Override
    public double berechneGehalt() {
        return 1500.0 + 50.0*berechneDienstalter();
    }

    @Override
    public String toString() {
        return "Angestellter: " + super.toString();
    }
}
