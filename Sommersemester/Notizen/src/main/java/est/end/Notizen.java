package est.end;

import java.util.ArrayList;
import java.util.List;

public class Notizen {

    private final List<String> notizen;

    public Notizen() {
        notizen = new ArrayList<>(); {
        }
    }

    public boolean notizHinzufuegen(String notiz) throws NotizException {
        if (checkNotiz(notiz)) throw new NotizException("Fehler: null oder leer");
        if (this.notizen.contains(notiz)) return false;
        return notizen.add(notiz);
    }

    public void ausgebenNotizen() {
        if (notizen.isEmpty()) IO.print("Keine Notizen vorhanden");
        IO.println("Meine Notizen: ");
        for (String notiz : notizen) {
            IO.println(notiz);
        }
    }

    public void sortierenAlphabetisch() {
        notizen.sort(null);
    }

    public void sortierenNachLaengeAbsteigend() {
        notizen.sort(new LaengeCompertator().reversed());
    }

    public void sortierenNachLaengeAufsteigend() {
        notizen.sort(new LaengeCompertator());
    }

    public boolean checkNotiz(String notiz) {
        return notiz != null && !notiz.isBlank();
    }

    public boolean notizEntfernen(String notiz) {
        if (!checkNotiz(notiz)) throw new IllegalArgumentException("Fehler: null oder leer");
        return notizen.remove(notiz);

    }
    public boolean notizEntfernenIndex(int index) {
        if (index < 0 || index > notizen.size()) throw new IllegalArgumentException("Fehler");
        notizen.remove(index);
        return true;
    }
}
