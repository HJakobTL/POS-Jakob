package at.spengergasse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VertragTest {

    Versicherungsmakler v1, vtest;
    Haushaltspolizze h1, h2, h3, htest;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws VersicherungException {
        v1 = new Versicherungsmakler("Markler1");
        vtest = new Versicherungsmakler("TestMakler");
        h1 = new Haushaltspolizze(100000,100);
        h2 = new Haushaltspolizze(50000,100);
        h3 = new Haushaltspolizze(400000,100);
        htest = new Haushaltspolizze(10000, 50);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testHinzufuegen() throws VersicherungException {
        assertTrue(v1.hinzufuegen(h1));
        assertTrue(v1.hinzufuegen(h2));
        assertTrue(v1.hinzufuegen(h3));
        //assertThrows(v1.hinzufuegen(h3));
        //assertThrows(v1.hinzufuegen(null));
        //assertThrows(VersicherungException.class, () -> v1.hinzufuegen(h3));
        //assertThrows(VersicherungException.class, () -> v1.hinzufuegen(null));

        System.out.println(v1);
    }

    @Test
    void testAnzahlVertraege_und_remove() throws VersicherungException {
            assertTrue(v1.hinzufuegen(h1));
            assertTrue(v1.hinzufuegen(h2));
            assertTrue(v1.hinzufuegen(h3));

            assertEquals(v1.anzahlVertraege(), 3);
            System.out.println(v1);

            assertEquals(v1.removeVertrag(120),2); // h1 und h2

            assertEquals(v1.anzahlVertraege(), 1);
            System.out.println(v1);
    }

    @Test
    void testSortierenSumme() throws VersicherungException {
            assertTrue(v1.hinzufuegen(h1));
            assertTrue(v1.hinzufuegen(h2));
            assertTrue(v1.hinzufuegen(h3));

            System.out.println(v1);
            System.out.println("--------");
            v1.sortiereSumme();
            //assertTrue(v1[0].getSumme() > v1[1].getSumme());
            System.out.println(v1);
    }

    @Test
    void testSortierenPreis() throws VersicherungException{
            assertTrue(v1.hinzufuegen(h1));
            assertTrue(v1.hinzufuegen(h2));
            assertTrue(v1.hinzufuegen(h3));

            System.out.println(v1);
            System.out.println("--------");
            v1.sortierePreis();
            //assertTrue(v1[0].berechnePreis() > v1[1].berechnePreis());
            System.out.println(v1);
    }

    @Test
    void testSummeQuadratmeter_und_BerechneGesamtPreis() throws VersicherungException{
            assertTrue(v1.hinzufuegen(h1));
            assertTrue(v1.hinzufuegen(h2));
            assertTrue(v1.hinzufuegen(h3));


        assertEquals(v1.summeQuadratmeter(),300);
        assertEquals(v1.berechneGesamtPreis(),550.0);
    }

    @Test
    void testVertragberechnePreis() throws VersicherungException {
        assertEquals(h1.berechnePreis(),100);
    }

    @Test
    void testQuadratmeter_und_Summe() throws VersicherungException {
        double negativeNummer = -1.5;
        assertThrows(VersicherungException.class, () -> new Haushaltspolizze(0.0, 100));
        assertThrows(VersicherungException.class, () -> new Haushaltspolizze(negativeNummer, 100));
        assertThrows(VersicherungException.class, () -> new Haushaltspolizze(50000, negativeNummer));
    }

    @Test
    void testSetSumme_ungueltig() throws VersicherungException {
        assertThrows(VersicherungException.class, () -> htest.setSumme(0));
        assertThrows(VersicherungException.class, () -> htest.setSumme(-50));
    }

    @Test
    void testSetSumme_gueltig() throws VersicherungException {
        assertDoesNotThrow(() -> htest.setSumme(200000));
        assertEquals(htest.getSumme(), 200000);
    }

    /*
    @Test
    void testSetQuadratmeter_ungueltig() throws VersicherungException {
        try {
            assertThrows(VersicherungException.class, () -> htest.setQuadratmeter(-10));
            assertThrows(VersicherungException.class, () -> htest.setQuadratmeter(0));

        } catch (VersicherungException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }
    */

    @Test
    void testSetName_Markler_ungueltig() throws VersicherungException {
        assertThrows(VersicherungException.class, () -> vtest.setName(null));
        assertThrows(VersicherungException.class, () -> vtest.setName("    "));
    }

    @Test
    void testSetName_Markler_gueltig() throws VersicherungException {
        assertDoesNotThrow(() -> vtest.setName("Markler2"));
    }

}