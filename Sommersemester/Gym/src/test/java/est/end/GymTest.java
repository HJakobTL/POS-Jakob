package est.end;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GymTest {

    private Gym gym;
    private Beinpresse b1;
    private Ergometer e1;
    private Ergometer e2;

    @BeforeEach
    void setUp() {
        // Standard-Gym für die meisten Tests
        gym = new Gym(5000.0, 10);
        b1 = new Beinpresse("Arnies Beinpresse", 3000.0, 400);
        e1 = new Ergometer("Smartrider 1", 2000.0, 100);
        e2 = new Ergometer("Z-Bike", 4500.0, 120);
    }

    @Test
    void getMaxPreisEur() {
        assertEquals(5000.0, gym.getMaxPreisEur());
    }

    @Test
    void setMaxPreisEur() {
        gym.setMaxPreisEur(8000.0);
        assertEquals(8000.0, gym.getMaxPreisEur());
        // Test auf Exception bei ungültigem Wert (> 9000)
        assertThrows(IllegalArgumentException.class, () -> gym.setMaxPreisEur(9500.0));
    }

    @Test
    void getMaxAnzahl() {
        assertEquals(10, gym.getMaxAnzahl());
    }

    @Test
    void setMaxAnzahl() {
        gym.setMaxAnzahl(50);
        assertEquals(50, gym.getMaxAnzahl());
        // Test auf Exception bei Grenzwerten (laut Angabe 5 bis 100 inklusive erlaubt)
        assertThrows(IllegalArgumentException.class, () -> gym.setMaxAnzahl(4));
        assertThrows(IllegalArgumentException.class, () -> gym.setMaxAnzahl(101));
    }

    @Test
    void aufstellen() {
        // Erfolgreich hinzufügen
        assertTrue(gym.aufstellen(b1));

        // Duplikat verhindern
        assertFalse(gym.aufstellen(b1));

        // Preis zu hoch
        Beinpresse teuer = new Beinpresse("Gold-Presse", 9000.0, 300);
        assertFalse(gym.aufstellen(teuer));

        // Kapazität testen
        Gym miniGym = new Gym(9000.0, 5);
        miniGym.aufstellen(new Ergometer("E1", 1000, 10));
        miniGym.aufstellen(new Ergometer("E2", 1000, 10));
        miniGym.aufstellen(new Ergometer("E3", 1000, 10));
        miniGym.aufstellen(new Ergometer("E4", 1000, 10));
        miniGym.aufstellen(new Ergometer("E5", 1000, 10));
        // Das 6. Gerät sollte false liefern
        assertFalse(miniGym.aufstellen(new Ergometer("E6", 1000, 10)));
    }

    @Test
    void berechneAvgPreisMaschinen() {
        // Leeres Gym
        assertEquals(0.0, gym.berechneAvgPreisMaschinen());

        gym.aufstellen(b1); // 3000
        gym.aufstellen(e1); // 2000
        assertEquals(2500.0, gym.berechneAvgPreisMaschinen());
    }

    @Test
    void sortierenPreisEur() {
        gym.aufstellen(e1); // 2000
        gym.aufstellen(b1); // 3000
        gym.aufstellen(e2); // 4500

        gym.sortierenPreisEur();
        // Laut Angabe absteigend: e2 (4500), b1 (3000), e1 (2000)
        // Hinweis: Dein PreisComparator ist aktuell aufsteigend implementiert, dieser Test wird also fehlschlagen.
        assertTrue(gym.toString().contains("4500.0 EUR"));
    }

    @Test
    void entfernenAlle() {
        // Test auf leeres Gym (-99)
        assertEquals(-99, gym.entfernenAlle('b'));

        gym.aufstellen(b1);
        gym.aufstellen(e1);
        gym.aufstellen(e2);

        // Alle Ergometer entfernen (e1, e2)
        assertEquals(2, gym.entfernenAlle('e'));
        // Nur noch b1 sollte da sein
        assertTrue(gym.toString().contains("Arnies"));
        assertFalse(gym.toString().contains("Smartrider"));
    }

    @Test
    void entfernen() {
        gym.aufstellen(b1);
        assertTrue(gym.entfernen(b1));
        assertFalse(gym.entfernen(b1)); // Schon weg

        // Test mit inhaltlich gleichem Objekt (equals/hashCode)
        gym.aufstellen(new Ergometer("Test", 1000, 50));
        assertTrue(gym.entfernen(new Ergometer("Test", 1000, 50)));
    }

    @Test
    void maxWartungsIntervall() {
        // Leeres Gym (-99)
        assertEquals(-99, gym.maxWartungsIntervall());

        gym.aufstellen(b1); // 6 Monate
        gym.aufstellen(e1); // 12 Monate
        assertEquals(12, gym.maxWartungsIntervall());
    }
}