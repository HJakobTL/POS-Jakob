package at.spengergasse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main() throws VersicherungException {
        Haushaltspolizze h1 = new Haushaltspolizze(100000, 100); // Preis: 100.0
        System.out.println(h1.berechnePreis());
    }
}
