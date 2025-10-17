public class quadrat {
    public static void quadrat(int x) {
        for (int zeile = 0; zeile < x; zeile++) {
            for (int spalte = 0; spalte < x; spalte++) {
                if (zeile == 0 || zeile == x - 1) {
                    System.out.print('#');
                } else if (zeile != spalte && spalte != 0 && spalte != x - 1) {
                    System.out.print(" ");
                } else System.out.print('#');
            }
            System.out.print("\n");
        }
    }

    public static void quadratArray(int x){
        String[] stars;
        stars = new String[x];
        String line = "";
        for (int i = 0; i < x; i++){
            for (int j = 0; j < x; j++){
                if (i == j || i == 0 || j == 0 || i == x-1 || j == x-1){
                    line += "* ";
                }
                else line += "  ";
            }
            line += "\n";
        }
        System.out.print(line);
    }
}