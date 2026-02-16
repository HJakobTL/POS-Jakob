package est.end;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class PersonalbueroTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testMitarbeiter(){
        Mitarbeiter mitarbeiter = new Mitarbeiter("Anna", Year.of(2001), Year.now());
        IO.println(mitarbeiter);
    }

    @Test
    void kuendigeAlleTest(){
        Personalbuero p1 = new Personalbuero();
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Anna", Year.of(2001), Year.now());
        Mitarbeiter mitarbeiter2 = new Mitarbeiter("Herbert", Year.of(2001), Year.now());
        Mitarbeiter mitarbeiter3 = new Mitarbeiter("Hans", Year.of(2001), Year.now());

        p1.aufnehmen(mitarbeiter1);
        p1.aufnehmen(mitarbeiter2);
        p1.aufnehmen(mitarbeiter3);

        int gekundigt = p1.kuendigeAlle("Herbert");
        assertEquals(1,gekundigt);

        float moneygekundigt = p1.kuendigen(1400);
        assertEquals(3000,moneygekundigt);

    }
}