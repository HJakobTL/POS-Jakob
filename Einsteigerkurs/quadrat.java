
/**
 * Write a description of class quadrat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class quadrat
{
    public static void quadrat(int x)
    {
        for (int zeile = 0; zeile < x; zeile++){
            for (int spalte = 0; spalte < x; spalte++){
                if (zeile == 0 || zeile == x-1){
                    System.out.print('#');
                }
                else if (zeile != spalte && spalte != 0 && spalte != x-1){
                    System.out.print(" ");
                }
                else System.out.print('#');
            }
            System.out.print("\n");
        }
    }
}