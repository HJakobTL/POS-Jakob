
/**
 * Write a description of class Sort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sort
{
    public static void Sort()
    {
        int arr[] = {4,5,2,3,1};
        int l = arr.length;
        int z;
        for (int i = 0; i < l-1; i++){
            for (int j = 0; j < l-i-1; i++){
            if (arr[j+1] > arr[j]){
                z = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = z;
                z = 0;
                }
            }
        }
        /* for each loop
           for (Datentyp Variable : Sammlung)
           In dem fall "arr", weil der Array oben so heißt
        */
        for (int array : arr){
            System.out.print(array + " ");
        }
        System.out.println();
    }
}