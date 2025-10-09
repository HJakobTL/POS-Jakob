
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
        for (int i=0;i<=100;i++){
            if (i % 5 == 0 && i % 11 == 0 && i % 3 == 0 && i % 7 == 0){
                System.out.println("FizzBuzzWhizzBang");
            }
            else if (i % 3 == 0 && i % 5 == 0){
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0 && i % 7 == 0){
                System.out.println("FizzWhizz");
            }
            else if (i % 5 == 0 && i % 11 == 0){
                System.out.println("BuzzBang");
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
            else if (i % 11 == 0){
                System.out.println("Bang");
            }
            else System.out.println(i);
        }
    }
}
