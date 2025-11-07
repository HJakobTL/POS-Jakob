public class Figuren
{   
    public static void Kreuz(int n){
        String line = "";
        for (int zeile = 0; zeile < n; zeile++){
            for (int spalte = 0; spalte < n; spalte++){
                if (zeile == spalte || n - 1 - spalte == zeile){
                    line += "#";
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.println(line);
    }
    
    public static void Schach(int n){
        String line = "";
        for (int zeile = 0; zeile < n; zeile++){
            for (int spalte = 0; spalte < n; spalte++){
                if (zeile % 2 == 0 && spalte % 2 == 0){
                    line += "#";
                }
                else if (zeile % 2 == 1 && spalte % 2 == 1){
                    line += "#";
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.println(line);
    }
    
    public static void Sudoku(int n){
        String line = "";
        
        if (n % 3 != 0){
            throw new IllegalArgumentException("NEIN");
        }
        for (int zeile = 0; zeile < n; zeile++){
            for (int spalte = 0; spalte < n; spalte++){
                if ((zeile < n/3 || zeile > n/2+1) 
                    && (spalte > n/2+1 || spalte < n/3)
                    || ((spalte >= n/3 && zeile >= n/3 ) && (spalte <= n/2+1 && zeile <= n/2+1))){
                    line += "#";
                }
                else line += " ";
            }
            line += "\n";
        }
        System.out.println(line);
    }
    
    public static void SudokuSpaß(){
        String line = "";
        for (int i = 0; i < 3; i++){
            line += "###   ###\n";
        }
        for (int i = 0; i < 3; i++){
            line += "   ###   \n";
        }
        for (int i = 0; i < 3; i++){
            line += "###   ###\n";
        }
        System.out.println(line);
    }
}