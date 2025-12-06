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
    void messenTest(){
        //given
        Pegelstand pegelstand = new Pegelstand("Test");
        //when
        pegelstand.messen(200);
        pegelstand.messen(310);
        pegelstand.messen(230);
        pegelstand.messen(340);
        pegelstand.messen(100);
        System.out.println(pegelstand);
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
        pegelstand.fuellTestWerte();
        int expected = pegelstand.getWert(5); // i2 = 310 ,i5 = 300
        pegelstand.printPegelStand();
        pegelstand.tauschen(2,5);
        int actual = pegelstand.getWert(2); // i2=300, i5 = 310
        pegelstand.printPegelStand();
        //then
        assertEquals(expected,actual);
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
        //when
        pegelstand.fuellTestWerte();
        pegelstand.loeschen(3); //rm 310
        pegelstand.loeschen(3); //rm 300
        pegelstand.printPegelStand();
        System.out.println(pegelstand);
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
        pegelstand.fuellTestWerte();
        pegelstand.loeschen(3);
        pegelstand.einfuegen(6,500); // statt 300 soll 500
        pegelstand.printPegelStand();
    }

    @Test
    void ueberschreibenAlle(){
        //given
        Pegelstand pegelstand = new Pegelstand("Test");
        //when
        pegelstand.fuellTestWerte();
        pegelstand.ueberschreibenAlle(500); // Alle Werte werden 500;
        System.out.println(pegelstand);
    }
}