package est.end;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class UmweltBehoerdeTest {

    private UmweltBehoerde u1;
    private Luftmessstation luft1;
    private Laermmessstation laerm1;
    private Wetterstation w1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.u1 = new UmweltBehoerde();
        this.luft1 = new Luftmessstation("Wien", Year.now().minusYears(2), 21.0, 55.5);
        this.laerm1 = new Laermmessstation("Eisenstadt", Year.now(), 50.0, 30);
        this.w1 = new Wetterstation("Graz", Year.now().minusYears(10), 21, 12);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void addMessstation() {
        assertTrue(u1.addMessstation(luft1));
        assertTrue(u1.addMessstation(laerm1));
        assertFalse(u1.addMessstation(luft1));
        assertTrue(u1.addMessstation(w1));
        //assertTrue(u1.addMessstation(w1));
    }

    @org.junit.jupiter.api.Test
    void berechneDurchschnittMesswert() {
        u1.addMessstation(luft1);
        u1.addMessstation(laerm1);
        u1.addMessstation(w1);

        assertEquals((double) 92/3,u1.berechneDurchschnittMesswert());
    }

    @org.junit.jupiter.api.Test
    void berechneDurchschnittLuftmessstation() {
        Luftmessstation luft2 = new Luftmessstation("Wien2", Year.now().minusYears(4), 67.0, 80.5);
        u1.addMessstation(luft1);
        u1.addMessstation(luft2);

        assertEquals(44,u1.berechneDurchschnittLuftmessstation());
        assertNotEquals(43,u1.berechneDurchschnittLuftmessstation());


    }

    @org.junit.jupiter.api.Test
    void berechneDurchschnittLaermmessertstation() {
        Laermmessstation laerm2 = new Laermmessstation("Wien2", Year.now().minusYears(4), 67.0, 80.5);
        u1.addMessstation(laerm1);
        u1.addMessstation(laerm2);

        assertEquals((double) 117/2,u1.berechneDurchschnittLaermmessertstation());
        assertNotEquals(58,u1.berechneDurchschnittLaermmessertstation());
    }

    @org.junit.jupiter.api.Test
    void berechneDurchschnittWetterstation() {
        Wetterstation w2 = new Wetterstation("Wien2", Year.now().minusYears(4), 67.0, 80.5);
        u1.addMessstation(w1);
        u1.addMessstation(w2);

        assertEquals(44,u1.berechneDurchschnittWetterstation());
        assertNotEquals(58,u1.berechneDurchschnittWetterstation());
    }

    @org.junit.jupiter.api.Test
    void sortiereMessstaionen() {
    }

    @org.junit.jupiter.api.Test
    void zeigAlleStationen() {
    }

    @org.junit.jupiter.api.Test
    void zeigeNurLuftmessstationen() {
    }

    @org.junit.jupiter.api.Test
    void zeigeNurLaermmessstation() {
    }

    @org.junit.jupiter.api.Test
    void zeigeStationenMitGrenzwertUeberschreitung() {
    }

    @org.junit.jupiter.api.Test
    void zaehleStationstypen() {
    }

    @org.junit.jupiter.api.Test
    void zaehleAlleSationenMitZuHohemWert() {
    }

    @org.junit.jupiter.api.Test
    void removeMessstation() {
    }

    @org.junit.jupiter.api.Test
    void removeErsteStationNachStandort() {
    }

    @org.junit.jupiter.api.Test
    void removeAlleStationenAelterAls() {
    }
}