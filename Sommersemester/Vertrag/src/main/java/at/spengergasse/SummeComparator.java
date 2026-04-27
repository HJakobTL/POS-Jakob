package at.spengergasse;

import java.util.Comparator;

public class SummeComparator implements Comparator<Vertrag> {
    @Override
    public int compare(Vertrag o1, Vertrag o2) {
        return Double.compare(o1.getSumme(), o2.getSumme());
    }
}
