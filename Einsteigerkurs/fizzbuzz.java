
/**
 * Write a description of class fizzbuzz here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class fizzbuzz
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class fizzbuzz
     */
    public fizzbuzz()
    {
    }
    
    public static void fizzbuzz(){
        for (int i=1;i<=100;i++){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0){
                System.out.println("Fizz");
            }
            else if (i % 5 == 0){
                System.out.println("Buzz");
            }
            else if (i % 7 == 0){
                System.out.println("Whizz");
            }
            else System.out.println(i);
        }
    }
}
