package est.end;

import java.io.*;
import java.nio.Buffer;
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
            throw new NotizException("Fehler bei notizHinzufuegen: null oder leer");
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

    public int anzahlNotizen() {
        return notizen.size();
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

    public void exportNotizen() throws NotizException {
        String filepath = "src/main/java/resources/exportNotizen.txt";

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            bw.write(this.toString());
        } catch (IOException e) {
            throw new NotizException("Fehler beim Export " + e.getMessage());
        }
    }

    public String toCSVString() {
        String delimiter = ";";
        StringBuilder sb = new StringBuilder();
        for (String s : notizen) {
            sb.append(s).append(delimiter);
        }
        return sb.toString();
    }

    public void importNotizen() throws NotizException {
        String filepath = "src/main/java/resources/importNotizen.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line =  br.readLine();
            if (line != null) {
                line.trim();
                String[] lineSplit = line.split(";");
                if (lineSplit.length > 0) {
                    notizen.clear(); // risiko Variante -> notizen.bak (Kopie der Datei) bzw Notizen in ein .bak file geben
                    int linecount = 0;
                    for (String notiz : lineSplit) {
                        linecount++;
                        if (notiz != null && !notiz.isBlank()) {
                            notizHinzufuegen(notiz.trim());
                        } else {
                            // evtl. Logging
                            System.out.println("Die Notiz an der POS. " + linecount +  " ist leer");
                        }
                    }
                } else throw new NotizException("Datei " + filepath + " hat keine Infos für uns");

            } else throw new NotizException("File ist leer (" + filepath + ")");

        } catch (FileNotFoundException e) {
            throw new NotizException("Fehler beim lesen der Datei: " + filepath + " " + e.getMessage());
        } catch (IOException e) {
            throw new NotizException("I/O Fehler beim lesen der Datei: " + e.getMessage());
        }

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Notizen: ").append("\n");
        if (notizen.isEmpty()) sb.append("Keine Notizen vorhanden");
        for (String notiz : notizen) {
            sb.append(notiz).append("\n");
        }
        return sb.toString();
    }


}
