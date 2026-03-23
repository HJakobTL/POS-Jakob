package est.end;

import static org.junit.jupiter.api.Assertions.*;

class WerkstoffzentrumVerwaltungTest {

    private WerkstoffzentrumVerwaltung wv;
    private MetallProbe m1;
    private PolymerProbe p1;
    private KeramikProbe k1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws WerkstoffException {
        wv = new WerkstoffzentrumVerwaltung();
        m1 = new MetallProbe("WZ-101", "Stahl S235", 7.85, 12.5,510,12);
        p1 = new PolymerProbe("WZ-305", "Polycarbonat", 1.2, 4.5, 145);
        k1 = new KeramikProbe("WZ-410", "Aluminiumoxid", 3.9, 6.2);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void addProbe() throws WerkstoffException {
        assertTrue(wv.addProbe(m1));
        assertFalse(wv.addProbe(m1));
        assertTrue(wv.addProbe(p1));
        assertTrue(wv.addProbe(k1));
    }

    @org.junit.jupiter.api.Test
    void removeProbeById() throws WerkstoffException {
        wv.addProbe(m1);
        wv.addProbe(p1);
        wv.addProbe(k1);
        assertTrue(wv.removeProbeById("WZ-305"));
        assertFalse(wv.removeProbeById("WZ-305"));
    }

    @org.junit.jupiter.api.Test
    void removeAllByTyp() throws WerkstoffException {
        MetallProbe m2 = new MetallProbe("WZ-102", "Stahl S267", 12.85, 20.81,510,12);
        wv.addProbe(m1);
        wv.addProbe(p1);
        wv.addProbe(k1);
        wv.addProbe(m2);
        assertEquals(2,wv.removeAllByTyp("MetallProbe"));
        assertNotEquals(2,wv.removeAllByTyp("KeramikProbe"));
    }

    @org.junit.jupiter.api.Test
    void removeAllMitIndexUnter() throws WerkstoffException {
        MetallProbe m2 = new MetallProbe("WZ-102", "Stahl S267", 12.85, 20.81,510,12);
        wv.addProbe(m1);
        wv.addProbe(p1);
        wv.addProbe(k1);
        wv.addProbe(m2);
    }

    @org.junit.jupiter.api.Test
    void findById() {
    }

    @org.junit.jupiter.api.Test
    void sortierenNachQualitaetsIndex() {
    }

    @org.junit.jupiter.api.Test
    void sortierenStandard() {
    }

    @org.junit.jupiter.api.Test
    void druckeStatistik() {
    }
}