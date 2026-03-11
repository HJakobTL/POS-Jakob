package est.end;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;

public class UmweltBehoerde {

    private final ArrayList<Messstation> messstationen;

    public UmweltBehoerde() {
        messstationen = new ArrayList<>();
    }

    public boolean addMessstation(Messstation m) {
        if (m == null || messstationen.contains(m)) throw new IllegalArgumentException("Fehler: null oder schon vorhanden");
        return messstationen.add(m);
    }

    public double berechneDurchschnittMesswert() {
        return berechneDurchschnittLaermmessertstation() +
                berechneDurchschnittLuftmessstation() +
                berechneDurchschnittWetterstation();
    }

    private double berechneDurchschnittProStation(String stationsName) {
        double sumMesswerte = 0;
        int anzStationen = 0;
        for (Messstation messstation: messstationen) {
            if(messstation.getStationTyp().equals(stationsName)) {
                sumMesswerte += messstation.getMesswert();
                anzStationen++;
            }
        }
        return sumMesswerte / anzStationen;
    }

    public double berechneDurchschnittLuftmessstation() {
        return berechneDurchschnittProStation("Luftmessstation");
    }

    public double berechneDurchschnittLaermmessertstation() {
        return berechneDurchschnittProStation("Laermmessstation");
    }

    public double berechneDurchschnittWetterstation() {
        return berechneDurchschnittProStation("Wetterstation");
    }

    public void sortiereMessstaionen() {
        messstationen.sort(Messstation::compareTo);
    }

    public void zeigAlleStationen() {
        for (Messstation m : messstationen) {
            IO.println(m);
        }
    }

    private void zeigeStation(String stationsName) {
        for (Messstation m : messstationen) {
            if (m.getStationTyp().equals(stationsName)) IO.println(m);
        }
    }

    public void zeigeNurLuftmessstationen() {
        zeigeStation("Luftmessstation");
    }

    public void zeigeNurLaermmessstation() {
        zeigeStation("Laermmessstation");
    }

    public void zaehleStationstypen() {
        int anzLuft = 0;
        int anzLaerm = 0;
        int anzWetter = 0;
        for (Messstation m : messstationen){
            switch (m.getStationTyp()) {
                case "Luftmessstation": anzLuft++; break;
                case "Laermmessstation": anzLaerm++; break;
                case "Wetterstation": anzWetter++; break;
                default:
            }
        }
        IO.println("Luftmessstation: " + anzLuft);
        IO.println("Laermmessstation: " + anzLaerm);
        IO.println("Wetterstation" + anzWetter);
    }

    public int zaehleAlleSationenMitZuHohemWert(double grenzwerte) {
        int anzStationen = 0;
        for (Messstation m : messstationen){
            if (m.getMesswert() > grenzwerte) anzStationen++;
        }
        return anzStationen;
    }

    public boolean removeMessstation(Messstation m) {
        if (m == null || messstationen.isEmpty()) throw new IllegalArgumentException("Fehler: null");
        return messstationen.remove(m);
    }

    public boolean removeErsteStationNachStandort(String standort) {
        Iterator<Messstation> iterator = messstationen.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getStationTyp().equals(standort)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Messstation> removeAlleStationenAelterAls(int alterInJahren) {
        ArrayList<Messstation> delStationen = new ArrayList<Messstation>();
        Iterator<Messstation> iterator = messstationen.iterator();
        Messstation mess;
        while (iterator.hasNext()) {
            mess = iterator.next();
            if (Year.now().minusYears(alterInJahren).isBefore(mess.getInstallationsJahr())) {
                delStationen.add(mess);
                iterator.remove();
            }
        }
        return delStationen;
    }

    @Override
    public String toString() {
        return "UmweltBehoerde{" +
                "messstationen=" + messstationen +
                '}';
    }
}
