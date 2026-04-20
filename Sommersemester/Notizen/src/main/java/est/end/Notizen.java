package est.end;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Notizen {

    private List<String> notizen;

    //"Brot einkaufen"
    //"Video über Java-Streams ansehen"
    //"Geschenk für Petra besorgen"

    public Notizen() {
        notizen = new ArrayList<>();
    }

    public boolean notizHinzufuegen(String notiz) throws NotizException {
        if (notiz == null || notiz.isBlank()) {
            throw new NotizException("Fehler: null oder leer");
        }
        if (this.notizen.contains(notiz)) {
            return false;
        }
        return notizen.add(notiz);
    }

    public void sortierenAlphabetisch() {
        notizen.sort(null);
    }

    public void sortierenNachLaengeAbsteigend() {
        //Comparator<String> nachLaengeAbsteigendComparator = new LaengeComparator().reversed();
        notizen.sort(new LaengeComparator().reversed());
    }

    public void sortierenNachDerLaengeAufsteigend() {
        notizen.sort(new LaengeComparator());
    }

    public boolean notizEntfernen(String notiz) throws NotizException {
        if (!checkNotiz(notiz)) {
            throw new NotizException("Fehler: notiz ungültig");
        }
        return notizen.remove(notiz);
    }

    private boolean checkNotiz(String notiz) {
        return notiz != null && !notiz.isBlank();
    }

    public void ausgebenNotizen() {
        if (notizen.isEmpty()) {
            System.out.println("Keine Notizen vorhanden");
        } else {
            System.out.println("Meine Notizen: ");
            for (String notiz : notizen) {
                System.out.println(notiz);
            }
        }
    }

    // files
    public void save() throws NotizException {
        String filepath = "src/main/java/resources/notizen.ser";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(notizen);
        } catch (FileNotFoundException e) {
            throw new NotizException("Datei " + filepath + " nicht gefunden " + e.getMessage());
        } catch (IOException e) {
            throw new NotizException("I/O-Problem mit Datei " + filepath + " " + e.getMessage());
        }
    }

    public void load() throws NotizException {
        String filepath = "src/main/java/resources/notizen.ser";

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {

            List<?> notizenLoad = (List<?>) ois.readObject();

            ArrayList<String> notizenBackUp = new ArrayList<>();
            Collections.copy(notizenBackUp, notizen);

            notizen.clear();
            for (Object o : notizenLoad) {
                if (o instanceof String) {
                    notizen.add((String) o);
                } else {
                    // Ausganszustand herstellen
                    notizen = notizenBackUp;
                    throw new NotizException("Fehler mit den Notizen in " + filepath + ", andere Informationen gefunden");
                }
            }

        } catch (FileNotFoundException e) {
            throw new NotizException("Datei " + filepath + " nicht gefunden " + e.getMessage());
        } catch (IOException e) {
            throw new NotizException("I/O-Problem mit Datei " + filepath + " " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new NotizException("Keine Notizen in der Datein " + filepath + " gefunden " + e.getMessage());
        }

    }

}
