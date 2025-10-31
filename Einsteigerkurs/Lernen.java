public class Lernen
{
    public static void Lernen()
    {
        // Aufgabe 1
        int[] Feld = new int[5];
        // Aufgabe 2
        String arr = "";
        for (int i = 0; i < Feld.length; i++){
            Feld[i] = i+1;
            arr += Feld[i];
        }
        System.out.println(arr);
        //Aufgabe 3
        System.out.println(Feld[2]);
        // Aufgabe 4 -> Feld[5] == OutOfBound error;
        
        // Aufgabe 5
        int[] Feld2 = new int[2];
        String arr2 = "";
        for (int j = 0; j < Feld2.length; j++){
            Feld2[j] = j+1;
            arr2 += Feld[j];
        }
        System.out.println(arr2);
    }
}