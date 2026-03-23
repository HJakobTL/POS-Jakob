package est.end;

public class Main {
    static void main() throws WerkstoffException {
        WerkstoffzentrumVerwaltung w1 = new WerkstoffzentrumVerwaltung();
        MetallProbe m1 = new MetallProbe("WZ-101", "Stahl S235", 7.85, 12.5,510,12);
        w1.addProbe(m1);
        w1.druckeStatistik();
    }
}
