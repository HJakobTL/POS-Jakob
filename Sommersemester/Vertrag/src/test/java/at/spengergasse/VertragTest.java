package at.spengergasse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VertragTest {

    private Versicherungsmakler v1, vtest;
    private Haushaltspolizze h1, h2, h3, htest;

    @BeforeEach
    void setUp() throws VersicherungException {
        v1 = new Versicherungsmakler("Makler1");
        vtest = new Versicherungsmakler("TestMakler");

        h1 = new Haushaltspolizze(100000, 100); // Preis: 100.0
        h2 = new Haushaltspolizze(50000, 100);  // Preis: 50.0
        h3 = new Haushaltspolizze(400000, 100); // Preis: 400.0
        htest = new Haushaltspolizze(10000, 50);
    }

    private void addStandardVertraege() throws VersicherungException {
        v1.hinzufuegen(h1);
        v1.hinzufuegen(h2);
        v1.hinzufuegen(h3);
    }

    @Test
    void testHinzufuegen() {
        assertDoesNotThrow(() -> v1.hinzufuegen(h1));

        assertThrows(VersicherungException.class, () -> v1.hinzufuegen(h1));

        assertThrows(VersicherungException.class, () -> v1.hinzufuegen(null));
    }

    @Test
    void testAnzahlVertraege_und_remove() throws VersicherungException {
        addStandardVertraege();
        assertEquals(3, v1.anzahlVertraege());

        assertEquals(2, v1.removeVertrag(120));
        assertEquals(1, v1.anzahlVertraege());
    }

    @Test
    void testSortierenSumme() throws VersicherungException {
        addStandardVertraege();

        assertDoesNotThrow(() -> v1.sortiereSumme());

        System.out.println("Sortiert nach Summe:\n" + v1);
    }

    @Test
    void testSortierenPreis() throws VersicherungException {
        addStandardVertraege();

        assertDoesNotThrow(() -> v1.sortierePreis());
        System.out.println("Sortiert nach Preis (absteigend):\n" + v1);
    }

    @Test
    void testSummeQuadratmeter_und_BerechneGesamtPreis() throws VersicherungException {
        addStandardVertraege();

        assertEquals(300.0, v1.summeQuadratmeter(), 0.001);
        assertEquals(550.0, v1.berechneGesamtPreis(), 0.001);
    }

    @Test
    void testVertragberechnePreis() throws VersicherungException {
        assertEquals(100.0, h1.berechnePreis());
    }

    @Test
    void testKonstruktor_ungueltig() {
        assertThrows(VersicherungException.class, () -> new Haushaltspolizze(0.0, 100));
        assertThrows(VersicherungException.class, () -> new Haushaltspolizze(-100, 100));
        assertThrows(VersicherungException.class, () -> new Haushaltspolizze(50000, 0));
        assertThrows(VersicherungException.class, () -> new Haushaltspolizze(50000, -10));
    }

    @Test
    void testSetSumme() {
        // Ungültig
        assertThrows(VersicherungException.class, () -> htest.setSumme(0));
        assertThrows(VersicherungException.class, () -> htest.setSumme(-50));

        // Gültig
        assertDoesNotThrow(() -> htest.setSumme(200000));
        assertEquals(200000.0, htest.getSumme());
    }

    @Test
    void testSetName_Makler() {
        // Ungültig
        assertThrows(VersicherungException.class, () -> vtest.setName(null));
        assertThrows(VersicherungException.class, () -> vtest.setName(""));

        // Gültig
        assertDoesNotThrow(() -> vtest.setName("Makler Neu"));
    }
}