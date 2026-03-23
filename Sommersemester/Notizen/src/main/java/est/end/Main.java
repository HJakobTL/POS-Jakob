package est.end;

public class Main {
    static void main() {

        Notizen n1 = new Notizen();

        //n1.ausgebenNotizen();
        try {
            IO.println(n1.notizHinzufuegen("Gym auslassen"));
            IO.println(n1.notizHinzufuegen("Alex einkaufen"));
            IO.println(n1.notizHinzufuegen("Alex einkaufen"));
            IO.println(n1.notizHinzufuegen("Glüklich sein"));
            IO.println(n1.notizHinzufuegen("Chips essen"));
        } catch (NotizException e) {
            IO.println("Fehler: unerwartete Exception: " +  e.getMessage());
        }


        n1.ausgebenNotizen();

        n1.sortierenAlphabetisch();
        n1.ausgebenNotizen();

        /*n1.notizEntfernenIndex(0);
        n1.notizEntfernen("Chips essen");
        n1.ausgebenNotizen();
         */

        n1.sortierenNachLaengeAbsteigend();
        n1.ausgebenNotizen();

        try {
            n1.notizHinzufuegen("Java verkaufen");
            n1.notizHinzufuegen("Perl verkaufen");
            n1.notizHinzufuegen("Curl verkaufen");
        } catch (NotizException e){
            IO.println("Fehler: unerwartete Exception: " +  e.getMessage());
        } finally {
            IO.println("Dieser Code wird immer ausgeführt");
        }

        n1.sortierenAlphabetisch();
        n1.ausgebenNotizen();

        n1.sortierenNachLaengeAufsteigend();
        n1.ausgebenNotizen();

    }
}
