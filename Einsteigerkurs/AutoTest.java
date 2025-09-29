

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AutoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AutoTest
{
    /**
     * Default constructor for test class AutoTest
     */
    public AutoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        System.out.println("Executing SetUp()");
    }
    
    
    @Test
    public void Test_printAuto(){
        // Objekte
        Auto BMW = new Auto("BMW", 3000);
        Person ferdi = new Person("Ferdinand", true, 181, 200); //Fahrer
        BMW.einsteigen(ferdi);
        Person marie = new Person("Marie", false, 160, 200); //Beifahrerin
        BMW.einsteigen(marie);
        Person hans = new Person("Hans", true, 170, 200); //Rückbank
        BMW.einsteigen(hans);
        
        assertEquals("Auto hält das Gewicht aus", BMW.Auto_Aushalten(), "Auto Aushaltevermögen Wertung"); // Error, weil mehr als 3500kg Gesamtgewicht
    }
    
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        System.out.println("Executing tearUp()");
    }
}