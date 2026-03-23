package est.end;

import java.util.Comparator;

public class WerkstoffQualitaetsIndexComparator implements Comparator<Werkstoffprobe> {
    @Override
    public int compare(Werkstoffprobe o1, Werkstoffprobe o2) {
        return Double.compare(o1.berechneQualitaetsIndex(), o2.berechneQualitaetsIndex());
    }
}
