package est.end.RundfahrtTour;

public class MainRundfahrt {
    public Rundfahrt rf;
    public Etappe e1;
    public Etappe e2;
    public Etappe e3;

    void main (){
        e1 = new Etappe("Wien", 100,"Jakob",5,30);
        e2 = new Etappe("Krems", 300,"Alex",4,31);
        e3 = new Etappe("St.Bloedsinn", 500,"Jakob",3,0);
        rf = new Rundfahrt("Wien Rundfahrt");

        try {
            rf.hinzufuegen(e1);
            rf.hinzufuegen(e2);
            rf.hinzufuegen(e3);
            rf.annullieren(2);
            rf.hinzufuegen(e2);
            System.out.println("Test");
            System.out.println(rf.toString());
            System.out.println("Der Fahrer Jakob hat " + rf.anzGewonnen("Jakob") + " mal gewonnen!");

        } catch (IllegalArgumentException ex){
            System.out.println("Fehler5: " + ex.getMessage());
        }




        /* TODO Probleme hier fixen
        Das man genaue POS löschen kann
        Und mehr Errors oder so ich bin sad :(
        */
    }
}
