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

    @Test
    void testAngestellter() {
        Mitarbeiter angestellter = new Angestellter("Jakob", Year.of(2004), Year.now());
        System.out.println(angestellter);
    }

     @Test
    void testPersonalbuero() {
        Angestellter angestellter = new Angestellter("Jakob", Year.of(2004), Year.now());
        System.out.println(angestellter);
        Personalbuero p1 = new Personalbuero();
        assertTrue(p1.aufnehmen(angestellter));
        IO.print(p1);
    }
    @Test
    void Freelancer() {
        Mitarbeiter f1 = new Freelancer("Anna", Year.of(2001), Year.now(), 100.0, 10);
        IO.println(f1);
    }
}
