public class Quadrat {
    // wir wollen eine Art "Sanduhr" zeichnen, z.B. so:
    /*
    # # # # # # #
    #       #
    #   #
    #
    #   #
    #       #
    # # # # # # #
     */
    public static void zeichne(int n) {
        String line = "";
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if ( i == 0 || i == n-1 || i == j || i == n-j-1){
                    line += "#";
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.print(line);
    }

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
                if(spalte <= n/2 && spalte >= n/2-zeile){
                    line += "#";
                }
                else if (spalte >= n/2 && spalte <= n/2+zeile){
                    line += "#";
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.print(line);
    }
    
    public static void main(String[] args) {
        zeichne(7);
        System.out.println();
        zeichne(14);
    }
}
