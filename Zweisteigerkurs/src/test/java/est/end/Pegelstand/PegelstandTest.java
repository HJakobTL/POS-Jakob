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
        //System.out.println(pegelstand.getFluss());
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
        //System.out.println(pegelstand.toString());
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
        System.out.println(pegelstand.toString());
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
        //System.out.println(pegelstand.toString());
    }
}