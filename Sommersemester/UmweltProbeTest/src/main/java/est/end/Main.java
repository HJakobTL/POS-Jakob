package est.end;

public class Main {
    void main() {

        /*Betriebszertifikat (ID: Z-2026-001)
        Name: GreenCity Festival
        CO2/Jahr: 120.5 t, Recyclingquote: 78.0 %
        CO2 Effizienz (max erlaubter CO2 von 100): 50%
        Nachhaltigkeitsscore: 5.7
        10 Mitarbeiter

        Produktzertifikat (ID: Z-2026-001)
        Name: GreenCity Festival T-Shirt
        CO2/Jahr: 120.5 t, Recyclingquote: 78.0 %
        CO2 Effizienz (max erlaubter CO2 von 100): 50%
        Nachhaltigkeitsscore: 5.7
        Recycling Anteil ist 20%, Lebensdauer ist 35 Jahre
         */

        try {
            ZertifikatsVerwaltung z1 = new ZertifikatsVerwaltung();
            BetriebsZertifikat b1 = new BetriebsZertifikat("Z-2026-001","GreenCity Festival",20.5, 78,10);
            System.out.println(b1);
            System.out.println("-------------------");
            ProduktZertifikat p1 = new ProduktZertifikat("Z-2026-002"," GreenCity Festival T-Shirt",20.5,78,20,35);
            System.out.println(p1);
            System.out.println("--------------------");
            z1.addZertifikat(b1);
            z1.addZertifikat(p1);
            z1.druckeAlle();
            System.out.println("--------------------");
            //for (UmweltZertifikat u : z1.listeTopNachhaltigkeitsScore()) System.out.println(u);
            //System.out.println("--------------------");
            System.out.println("HALLO");
            UmweltZertifikat u2 = z1.findeMitId("Z-2026-002");
            System.out.println(u2);
            System.out.println("--------------------");
            z1.druckeScoreListe();
            z1.druckeCO2EffizienzListe(1);


        } catch (UmweltProjektException e) {
            System.out.print("Unerwarteter Fehler");
        }
    }
}
