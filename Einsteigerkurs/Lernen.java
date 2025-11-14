import java.util.Random;

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

        // Aufgabe 6
        int[] hundert = new int[100];
        String arr3 = "";
        for (int i = 0; i < hundert.length; i++){
            hundert[i] = i+1;
            arr3 += hundert[i];
        }
        System.out.println(arr3);
    }

    public static void einsBisHundert(int[] a){
        String arr3 = "";
        for (int i = 0; i < a.length; i++){
            a[i] = i+1;
            arr3 += a[i];
        }
        System.out.println(arr3);
    }

    public static int[] wunschArray(int laenge){
        int[] wunschArray = new int[laenge];
        String line = "";
        for(int i = 0; i < wunschArray.length; i++){
            wunschArray[i] = i+1;
            line += wunschArray[i];
        }
        System.out.println(line);
        return wunschArray;
    }

    public static void aufgabeIDK(){
        String arr1 = "";
        String arr2 = "";

        int[] eins = new int[5];
        eins[0] = 12;
        eins[1] = 4;
        eins[2] = 7;
        eins[3] = 5;
        eins[4] = 200;

        int[] Kopie = new int[5];
        for(int k = 0; k < Kopie.length; k++){
            Kopie[k] = eins[k];
            arr1 += Kopie[k] + "\n";
        }
        System.out.println(arr1);

        int[] reverse = new int[5];

        for (int i = 0; i < reverse.length; i++){
            reverse[i] = Kopie[Kopie.length-i-1];
            arr2 += reverse[i] + "\n";
        }
        System.out.println(arr2);
    }

    public static int wurfel(){
        Random rand = new Random();
        int x = rand.nextInt(1,6);
        return x;
    }

    public static String[] wurfelErgebnis(){
        String[] Namen = new String[2];
        Namen[0] = "Jakob " + wurfel();
        Namen[1] = "Alex " + wurfel();
        for(int i = 0; i < Namen.length; i++){
            System.out.println(Namen[i]);   
        }
        return Namen;
    }

    public static void Quadrat(int n){
        String line = "";
        for (int zeile = 0; zeile < n; zeile++){
            for (int spalte = 0; spalte < n; spalte++){
                if (zeile == 0 || spalte == 0 || zeile == n-1 || spalte == n-1 || zeile == spalte || zeile == n-spalte-1){
                    line += "# ";
                }
                // else if (zeile == n/2 && spalte == n/2){
                // line += "# ";
                // }
                else line += "  ";
            }
            line += "\n";
        }
        System.out.println(line);
    }

    public static void pyramid(int n){
        String line = "";
        n *= 2;
        for (int zeile = 0;  zeile < n/2; zeile++){
            for(int spalte = 0; spalte < n+1;spalte++){
                if(spalte <= n/2 && spalte >= n/2-zeile){
                    line += spalte;
                }
                else if (spalte >= n/2 && spalte <= n/2+zeile){
                    line += spalte;
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.print(line);
    }
    
     public static void diamand(int n){
        String line = "";
        n *= 2;
        for (int zeile = 0;  zeile < n; zeile++){
            for(int spalte = 0; spalte < n;spalte++){
                if(spalte == n/2 || spalte == n/2-zeile || spalte == n/2+zeile){
                    line += zeile;
                }
                else if (spalte == zeile-n/2){
                    line += zeile;
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.print(line);
    }
    
    public static void Rechteck(int n){
        String line = "";
        for (int zeile = 0;  zeile < n; zeile++){
            for(int spalte = 0; spalte < n;spalte++){
                if(zeile == 0 || zeile == n/2){
                    line += "# ";
                }
                else if((zeile < n/2 && spalte == 0) || (zeile < n/2 &&  spalte == n-1)){
                    line += "# ";
                }
                else line += "  ";
            }
            line += "\n";
        }
        System.out.print(line);
    }
}