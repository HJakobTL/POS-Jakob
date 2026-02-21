package est.end.Pegelstand;


public class MainPegelstand {
    static void main() {
        Pegelstand p1 = new Pegelstand();

        p1.fuellTestWerte();
        IO.print(p1);
        p1.sortiereWerte();
        IO.println(p1);

    }
}

