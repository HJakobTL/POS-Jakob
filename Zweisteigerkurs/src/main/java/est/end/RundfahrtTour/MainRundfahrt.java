package est.end.RundfahrtTour;

public class MainRundfahrt {
    public Rundfahrt rf;
    public Etappe e1;
    public Etappe e2;
    public Etappe e3;
    public Etappe e49;

    void main (){
        System.out.println("Test Start");
        e1 = new Etappe(1,100,"Wien","Jakob",5,30);
        e2 = new Etappe(2,300,"Krems","Alex",5,51);
        e3 = new Etappe(3,500,"St.Bloedsinn","Jakob",5, 29);
        e49 = new Etappe(49,700,"Simmering","Tobias",3,18);
        rf = new Rundfahrt("Wien Rundfahrt",50);
        /*System.out.println(e1.toString());

        rf.hinzufuegen(e1);
        rf.hinzufuegen(e2);
        rf.hinzufuegen(e3);
        rf.annullieren(2);
        System.out.println(rf.etappenUebersich());
        System.out.println(rf.berechneGesamtlaenge());
        System.out.println(rf.berechneDurchschnittslaenge());
        System.out.println(e1.getSieger());
        System.out.println(rf.anzGewonnen("Jakob"));
        for (int i = 0; i < 50; i++) {
            System.out.println(rf.getEtappen()[i]);
        }
        System.out.println(rf.berechneGesDauer());*/

        for (int i = 0; i <= 20; i++) {
            if (i < 20) rf.hinzufuegen(e1);
        }
        for (int i = 0; i <= 20; i++) {
            if (i < 20) rf.hinzufuegen(e2);
        }
        for (int i = 0; i <= 10; i++) {
            if (i < 10) rf.hinzufuegen(e3);
        }

        // TODO Probleme hier fixen
        //rf.annullieren(49);
        //rf.hinzufuegen(e49);

        System.out.println(rf.toString());

    }
}
