
/**
 * Write a description of class Holiday here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Holiday
{
    // instance variables - replace the example below with your own
    String arr[] = {"first", "second", "third"};
    String arr1[] = {"","Two turtle doves and","Three french hens","Four calling birds"};
    public void normalText(){
        for (int i = 0;i<3;i++){
        System.out.println("On the " + arr[i] + " day of Christmas");
        for (int j = 0;j<=i;j++){
            System.out.println(arr1[j]);
        }
        System.out.println("My true love sent to me:");
        System.out.println("A partridge in a pear tree.");
    }
    }
    
    public static void Holiday(){
        
    }
}
