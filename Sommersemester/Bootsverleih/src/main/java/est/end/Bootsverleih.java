package est.end;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Bootsverleih {

    private String name;
    private final List<Boot> boote;

    public Bootsverleih(String name) throws BootException {
        setName(name);
        this.boote = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws BootException {
        if (name == null || name.isEmpty()) throw new BootException("Fehler: null oder leer");
        this.name = name;
    }

    public Boot getBoote(int index) throws BootException {
        if (index < 0) throw new BootException("Fehler: kleiner 0");
        return boote.get(index);
    }

    public boolean hinzufuegen(Boot boot) {
        if (boot == null || boote.contains(boot) || boote.size() > 20) return false;
        return boote.add(boot);
    }

    public boolean entfernen(Boot boot) {
        if (boot == null) return false;
        return boote.remove(boot);
    }

    public int entfernen(String bezeichnung) {
        if (bezeichnung == null || bezeichnung.isEmpty()) return -99;
        int count = 0;
        Iterator<Boot> iterator = boote.iterator();
        while (iterator.hasNext()) {
            Boot boot_it = iterator.next();
            if (Objects.equals(boot_it.getBezeichnungen(), bezeichnung)) {
                iterator.remove();
                count++;
            }
        }
        return count > 0 ? count : -99;
    }

    public int anzahlBooteMitLizenz() {
        int count = 0;
        for (Boot boot : boote) {
            if (boot instanceof SegelBoot && ((SegelBoot) boot).isLizenz()) {
                count++;
            }
        }
        return count > 0 ? count : -99;
    }

    public void sortieren() {
        boote.sort(null);
    }

    public void sortierenNachBezeichnung() {
        boote.sort(new BootComparableNachBezeichnung());
    }

    @Override
    public String toString() {
        return "Bootsverleih{" +
                "name='" + name + '\'' +
                ", boote=" + boote +
                '}';
    }
}
