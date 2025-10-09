

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 /** The test class PersonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PersonTest
{
    public Person ferdi;
    public Person mann_unter;
    public Person mann_normal;
    public Person frau_uber;
    public Person frau_unter;
    public Person frau_normal;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        // Männer
        ferdi = new Person("Ferdinand", true, 181, 100);
        mann_unter = new Person("MannUnter", true, 200, 65);
        mann_normal = new Person("MannNormal", true, 180, 80);
        
        // Frauen
        frau_uber = new Person("FrauUber", false, 160, 100);
        frau_unter = new Person("FrauUnter", false, 200, 65);
        frau_normal = new Person("FrauNormal", false, 160, 55);
        System.out.println("----");
        System.out.println("Setup complete");
        System.out.println("Beginnt zu Testen");
    }
    
        @Test
    public void Test_BMI(){
        // Mann
        assertEquals("Übergewicht", ferdi.bmiWerter(), "BMI Wertung"); //Korrekt
        //assertEquals("Übergewichtung", ferdi.bmiWerter(), "BMI Wertung"); //Error
        assertEquals("Untergewicht", mann_unter.bmiWerter(), "BMI Wertung");
        assertEquals("Normal", mann_normal.bmiWerter(), "BMI Wertung");
                
        // Frau
        assertEquals("Übergewicht", frau_uber.bmiWerter(), "BMI Wertung");
        assertEquals("Untergewicht", frau_unter.bmiWerter(), "BMI Wertung");
        assertEquals("Normal", frau_normal.bmiWerter(), "BMI Wertung");
    }
    
    @Test
    public void Test_BMI_annaherung(){
        // Test ist um 0.100...1 off
        Person test = new Person("Test", true, 180, 69.67); //69.66 für error
        assertEquals(21.6, test.bmiRechner(), 0.1, "Erwartet ist 21.6");
        
        Person test2 = new Person("Test2", false, 200, 73.6000001); //73.6 für error
        assertEquals(18.5, test2.bmiRechner(), 0.1, "Erwartet ist 18.5");
        
        Person test3 = new Person("Test3", false, 180, 86.8); //86.9 für error
        assertEquals(26.7, test3.bmiRechner(), 0.1, "Erwartet ist 26.7");
    }
    
    @Test 
    public void testFalscherNameThrows(){
        Person stud;
        try {
            stud = new Person("FE", true, 180, 80); // Excpetion erwartet
        }
        catch (Exception e) {
            System.out.println("Exception gefangen: " + e.getMessage());
        }
    }
    
     /** Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        System.out.println("Test Ende");
    }
}