package est.end;

import java.time.Year;
import java.util.Iterator;

public class Main {
    static void main() {
        Personalbuero p1 = new Personalbuero();
        Personalbuero p2 = new Personalbuero();
        Mitarbeiter m1 = new Mitarbeiter();
        IO.println(m1);
        //m1.print();
        Mitarbeiter m2 = new Mitarbeiter("Jakob", Year.of(2004), Year.of(2000));
        IO.println(m2);


        p1.aufnehmen(m1);
        p1.aufnehmen(m2);
        p1.aufnehmen(m1); // m1 wird nicht aufgenommen
        IO.println(p1.berechneDurchschnittsalter());
        IO.println(p1.berechneGehaltsumme());
        IO.println(p1.zaehleMitarbeiter());
        IO.println(p1);
        IO.println(p2);
    }
}
