package est.end.Pegelstand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PegelstandTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @Test
    void testSetFluss_sollFunktionieren_pegelStandVoll_flussInn_innGesetzt(){
        // given
        Pegelstand pegelstand = new Pegelstand();
        assertEquals("Donau",pegelstand.getFluss());
        assertEquals(0,pegelstand.getAnzahl()); // Array ist noch Leer

        // when
        pegelstand.setFluss("Inn"); // Fluss soll Inn heißen
        pegelstand.fuellTestWerte(); // Füllt den Array mit Werten

        //then
        System.out.println(pegelstand.getFluss());
        assertEquals(7,pegelstand.getAnzahl());
        assertNotEquals(null, pegelstand.getFluss());
        assertNotEquals("Donau",pegelstand.getFluss());
        assertEquals("Inn",pegelstand.getFluss());
    }

    @Test
    void testAvgWertFluss_sollNichtFunktionieren_leeresArray_returnMinus99Komma0(){
        //given
        Pegelstand pegelstand = new Pegelstand(); // leer
        //when
        float actual = pegelstand.avgWwert();
        float expected = -99f;
        //then
        assertEquals(expected,actual);
        System.out.println(pegelstand);
    }

    @Test
    void testAvgWertFluss_sollFunktionieren_vollesArray_returnAvgWert294Komma28(){
        //given
        Pegelstand pegelstand = new Pegelstand();
        pegelstand.fuellTestWerte();
        //when
        float actual = pegelstand.avgWwert();
        float expected = 294.28f; // 294,2853...
        //then
        assertEquals(expected,actual, 0.009);
        System.out.println(pegelstand);
        System.out.println();
        pegelstand.printPegelStand();
    }

    @Test
    void testMinWert(){
        //given
        Pegelstand pegelstand = new Pegelstand();
        //when
        pegelstand.fuellTestWerte();
        float actual = pegelstand.kleinsterWert();
        float expected = 250;
        int actual2 = pegelstand.maxIndex();
        int expecteted2 = 2;
        //then
        assertEquals(expected,actual);
        assertEquals(expecteted2,actual2);
        System.out.println(pegelstand);
    }

    @Test
    void getIndexWert(){
        //given
        Pegelstand pegelstand = new Pegelstand();
        //when
        pegelstand.fuellTestWerte();
        int actual = pegelstand.getWert(1);
        int expected = 290;
        //then
        assertEquals(expected,actual);
    }

    @Test
    void testMessen_sollFunktionieren_leeresArray_messen7Werte_7xTrue_anzahl7(){
        //given
        Pegelstand pegelstand = new Pegelstand("Test");
        System.out.println(pegelstand);
        //when
        for (int i = 0; i < 7; i++) {
            assertTrue(pegelstand.messen(i));
        }
        //then
        System.out.println(pegelstand);
        assertEquals(7,pegelstand.getAnzahl());
    }

    @Test
    void printHohenpegel(){
        //given
        Pegelstand pegelstand = new Pegelstand();
        //when
        pegelstand.fuellTestWerte();
        pegelstand.printHoehenprofil();
    }

    @Test
    void tauschenTest(){
        //given
        Pegelstand pegelstand = new Pegelstand();
        //when
        for (int i = 0; i < 7; i++) {
            assertTrue(pegelstand.messen(i)); //0,1,2,3,4,5,6
        }
        assertTrue(pegelstand.tauschen(2,4)); //0,1,4,3,2,5,6
        pegelstand.printPegelStand();
        //then
    }

    @Test
    void hohenprofilToString(){
        //given
        Pegelstand pegelstand = new Pegelstand(); // leer
        //when
        pegelstand.messen(280);
        pegelstand.messen(300);
        pegelstand.messen(320);
        System.out.println(pegelstand.hohenprofilToString('+',20));
    }

    @Test
    void entfernenTest(){
        //given
        Pegelstand pegelstand = new Pegelstand();
        //when
        pegelstand.fuellTestWerte();
        pegelstand.printPegelStand();
        int expected = pegelstand.getWert(6); // i6 = 300
        pegelstand.entferneLetzenWert();
        int actual = pegelstand.getWert(6); // i6 = 0
        pegelstand.entferneLetzenWert(); // i5 = 0
        pegelstand.printPegelStand();
        //then
        assertNotEquals(expected,actual);
    }

    @Test
    void loeschenTest(){
        //given
        Pegelstand pegelstand = new Pegelstand("Test");
        System.out.println(pegelstand);
        //when
        for (int i = 0; i < 3; i++) {
            assertTrue(pegelstand.messen(i));
        }
        //then
        pegelstand.loeschen(0);
        assertEquals(2,pegelstand.getAnzahl());
        assertEquals(1,pegelstand.getWert(0));
        assertEquals(2, pegelstand.getWert(1));
        System.out.println(pegelstand);
        pegelstand.printPegelStand();
    }

    @Test
    void leerenTest(){
        //given
        Pegelstand pegelstand = new Pegelstand("Test");
        //when
        pegelstand.fuellTestWerte();
        pegelstand.loeschen(3);
        int expected = pegelstand.getAnzahl();
        System.out.println(pegelstand);
        int actual = pegelstand.leeren();
        System.out.println(pegelstand);
        //then
        assertEquals(expected,actual);
    }

    @Test
    void einfuegenTest(){
        //given
        Pegelstand pegelstand = new Pegelstand("Test");
        //when
        for (int i = 0; i < 4; i++) {
            assertTrue(pegelstand.messen(i)); // 0,1,2,3,4
        }
        pegelstand.einfuegen(2,500); // an Index 2 soll 500, rest wird nach rechts verschoben
        pegelstand.printPegelStand();
    }

    @Test
    void ueberschreibenAlle(){
        //given
        Pegelstand pegelstand = new Pegelstand("Test");
        for (int i = 0; i < 7; i++) {
            pegelstand.messen(500);
        }
        //when
        assertEquals(pegelstand.getWerte(),pegelstand.ueberschreibenAlle(500));// Alle Werte werden 500;
        System.out.println(pegelstand);
    }

    @Test
    void sortPegelstand(){
        //given
        Pegelstand pegelstand = new Pegelstand();
        int wert = 6;
        do {
            assertTrue(pegelstand.messen(wert));
            wert--;
        } while (wert >= 0);
        pegelstand.printPegelStand();
        System.out.println();
        //when
        pegelstand.sortiereWerte();
        //then
        pegelstand.printPegelStand();
        pegelstand.ausgebenWerte();
    }
}