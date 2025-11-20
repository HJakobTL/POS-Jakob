public static void main(String[] args){
    Torte.hochzeit(6);
}

public class Torte
{
    public static void hochzeit(int n){
        String line = "";
        n *= 2;
        for (int zeile = 0;  zeile < n/2; zeile++){
            for(int spalte = 0; spalte < n+1;spalte++){
                if(spalte == n/2-zeile){
                    line += "[";
                }
                if (spalte == n/2+zeile+1){
                    line += "]";
                }
                if ( zeile % 2 == 0 && spalte == n/2+zeile+1){
                    line += "¡";
                }
                else if ( zeile % 2 == 0 && spalte == n/2-zeile-1){
                    line += "¡";
                }
                else if(spalte <= n/2 && spalte >= n/2-zeile){
                    line += "*";
                }
                else if (spalte >= n/2 && spalte <= n/2+zeile){
                    line += "*";
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.print(line);
    }
}

