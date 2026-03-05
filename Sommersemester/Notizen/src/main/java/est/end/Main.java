package est.end;

public class Main {
    static void main() {

        Notizen n1 = new Notizen();

        //n1.ausgebenNotizen();
        IO.println(n1.notizHinzufuegen("Gym auslassen"));
        IO.println(n1.notizHinzufuegen("Alex einkaufen"));
        IO.println(n1.notizHinzufuegen("Alex einkaufen"));
        IO.println(n1.notizHinzufuegen("Glüklich sein"));
        IO.println(n1.notizHinzufuegen("Chips essen"));

        n1.ausgebenNotizen();

        n1.sortierenAlphabetisch();
        n1.ausgebenNotizen();

        /*n1.notizEntfernenIndex(0);
        n1.notizEntfernen("Chips essen");
        n1.ausgebenNotizen();
         */

        n1.sortierenNachLaengeAbsteigend();
        n1.ausgebenNotizen();

        n1.notizHinzufuegen("Java verkaufen");
        n1.notizHinzufuegen("Perl verkaufen");
        n1.notizHinzufuegen("Curl verkaufen");
        n1.sortierenAlphabetisch();
        n1.ausgebenNotizen();

        n1.sortierenNachLaengeAufsteigend();
        n1.ausgebenNotizen();

    }
}
