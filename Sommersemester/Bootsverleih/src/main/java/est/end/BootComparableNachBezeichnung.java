package est.end;

public class BootComparableNachBezeichnung implements java.util.Comparator<Boot> {

    @Override
    public int compare(Boot o1, Boot o2) {
        return o1.getBezeichnungen().compareTo(o2.getBezeichnungen());
    }
}
