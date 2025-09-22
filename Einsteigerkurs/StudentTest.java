

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
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
    public void Test_BMI(){
        Student ferdi = new Student("Ferdinand", true, 181, 100);
        assertEquals("Übergewicht", ferdi.bmi_werter(), "BMI Wertung"); //Korrekt
        //assertEquals("Übergewichtung", ferdi.bmi_werter(), "BMI Wertung"); //Error
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        System.out.println("Executing TearDown()");
    }
}