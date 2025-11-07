public class Namen
{   
    private static int standardgroesse = 5;
    
    private static String J(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (zeile == x-1 || spalte == x-1){
                row.append('#');
            }
            else if (spalte == 0 && zeile == x-2){
                row.append('#');
            }
            else row.append(" ");
        }

        return row.toString();
    }

    private static String A(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (zeile == 0 || spalte == 0 || spalte == x-1 || zeile == x-3){
                row.append('#');
            }
            else row.append(" ");
        }

        return row.toString();
    }

    private static String K(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            boolean printed = false;
            if (spalte == 0){
                row.append('#');
                printed = true;
            }
            for (int k=1; k < x; k++){
                if (zeile == (x-k)/2 && spalte == x-x+k){
                    row.append('#');
                    printed = true;
                }
                if (zeile == (x+k)/2 && spalte == x-x+k){
                    row.append('#');
                    printed = true;
                }
            }
            if (!printed){
                row.append(" ");
            }
        }

        return row.toString();
    }

    private static String O(int x, int zeile)
    {   
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (zeile == 0 || zeile == x-1){
                row.append('#');
            }
            else if (spalte != 0 && spalte != x-1){
                row.append(" ");
            }
            else row.append('#');
        }

        return row.toString();
    }

    private static String B(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (zeile == 0 || zeile == x-1){
                row.append('#');
            }
            else if (spalte == x-1 && zeile == (x-1)/2){
                row.append(" ");
            }
            else if (spalte != 0 && spalte != x-1 && zeile != (x-1)/2){
                row.append(" ");
            }
            else row.append('#');
        }

        return row.toString();
    }

    private static String L(int x, int zeile){
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == 0 || zeile == x-1){
                row.append('#');
            }
            else row.append(" ");
        }
        return row.toString();
    }

    private  static String E(int x, int zeile){
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == 0 || zeile == 0 || zeile == (x-1)/2 || zeile == x-1 ){
                row.append('#');
            }
            else row.append(" ");
        }
        return row.toString();
    }

    private static String X(int x, int zeile){
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == zeile || x - 1 == zeile + spalte){
                row.append('#');
            }
            else row.append(" ");
        }
        return row.toString();
    }

    private static String T(int x, int zeile){
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (zeile == 0){
                row.append('#');
            }
            else if (spalte == (x-1)/2){
                row.append('#');
            }
            else row.append(" ");
        }
        return row.toString();
    }

    private static String I(int x, int zeile){
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == (x-1)/2){
                row.append('#');
            }
            else row.append(" ");
        }
        return row.toString();
    }

    private static String G(int x, int zeile){
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (zeile == 0 && spalte < (x+1)/2 ){
                row.append('#');
            }
            else if (zeile == x-1){
                row.append('#');
            }
            else if (zeile == (x-1)/2 && spalte > (x-1)/2){
                row.append('#');
            }
            else if (spalte == x-1 && zeile > (x-1)/2){
                row.append('#');
            }
            else if (spalte == 0){
                row.append('#');
            }
            else row.append(" ");
        }
        return row.toString();
    }

    private  static String F(int x, int zeile){
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == 0 || zeile == 0 || zeile == (x-1)/2){
                row.append('#');
            }
            else row.append(" ");
        }
        return row.toString();
    }
    
    private static String P(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (zeile == 0 || spalte == 0 || zeile == (x-1)/2){
                row.append('#');
            }
            else if (spalte == x-1 && zeile < (x-1)/2 ){
                row.append('#');
            }
            else row.append(" ");
        }

        return row.toString();
    }

    private static String R(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            boolean printed = false;
            if (zeile == 0 || spalte == 0 || zeile == (x-1)/2){
                row.append('#');
                printed = true;
            }
            else if (spalte == x-1 && zeile < (x-1)/2 ){
                row.append('#');
                printed = true;
            }
            for (int k=2; k < x; k++){
                if (zeile == (x+k)/2 && spalte == x-x+k){
                    row.append('#');
                    printed = true;
                }
            }
            if (!printed){
                row.append(" ");
            }
        }
        return row.toString();
    }
    
    private static String U(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == 0 || zeile == x-1 || spalte == x-1){
                row.append('#');
            }
            else {
                row.append(" ");
            }
        }
        return row.toString();
    }
    
    // TODO better M
    private static String M(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == 0 || zeile == 0 || spalte == x-1 || spalte == (x-1)/2){
                row.append('#');
            }
            else {
                row.append(" ");
            }
        }
        return row.toString();
    }
    
    // TODO better W
    private static String W(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == 0 || zeile == x-1 || spalte == x-1 || spalte == (x-1)/2){
                row.append('#');
            }
            else {
                row.append(" ");
            }
        }
        return row.toString();
    }
    
    private static String N(int x, int zeile)
    {
        StringBuilder row = new StringBuilder();

        for (int spalte = 0; spalte < x; spalte++){
            if (spalte == 0 || spalte == x-1 || zeile == spalte){
                row.append('#');
            }
            else {
                row.append(" ");
            }
        }
        return row.toString();
    }
    
    public static void JakobHorizontal(int x)
    {
        int spacing = 1; 

        for (int zeile = 0; zeile < x; zeile++){

            // Rufe die get...Row-Methoden auf, um die Zeilen-Strings zu erhalten
            String jRow = J(x, zeile);
            String aRow = A(x, zeile);
            String kRow = K(x, zeile);
            String oRow = O(x, zeile);
            String bRow = B(x, zeile);

            // Setze die Zeile zusammen und drucke sie
            StringBuilder fullLine = new StringBuilder();

            fullLine.append(jRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(aRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(kRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(oRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(bRow);

            System.out.println(fullLine.toString());
        }
        System.out.println();
    }

    public static void AlexHorizontal(int x)
    {
        int spacing = 1; 

        for (int zeile = 0; zeile < x; zeile++){
            String aRow = A(x, zeile);
            String lRow = L(x, zeile);
            String eRow = E(x, zeile);
            String xRow = X(x, zeile);

            StringBuilder fullLine = new StringBuilder();

            fullLine.append(aRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(lRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(eRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(xRow);

            System.out.println(fullLine.toString());
        }
        System.out.println();
    }

    public static void JobHorizontal(int x){
        int spacing = 1;

        for (int zeile = 0; zeile < x; zeile++){
            String jRow = J(x, zeile);
            String oRow = O(x, zeile);
            String bRow = B(x, zeile);

            StringBuilder fullLine = new StringBuilder();

            fullLine.append(jRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(oRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(bRow);

            System.out.println(fullLine.toString());
        }
        System.out.println();
    }

    public static void TobiHorizontal(int x){
        int spacing = 1;

        for (int zeile = 0; zeile < x; zeile++){
            String tRow = T(x, zeile);
            String oRow = O(x, zeile);
            String bRow = B(x, zeile);
            String iRow = I(x, zeile);

            StringBuilder fullLine = new StringBuilder();

            fullLine.append(tRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(oRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(bRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(iRow);

            System.out.println(fullLine.toString());
        }
        System.out.println();
    }
    
     public static void GrafHorizontal(int x){
        int spacing = 1;

        for (int zeile = 0; zeile < x; zeile++){
            String gRow = G(x, zeile);
            String rRow = R(x, zeile);
            String aRow = A(x, zeile);
            String fRow = F(x, zeile);

            StringBuilder fullLine = new StringBuilder();

            fullLine.append(gRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(rRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(aRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(fRow);

            System.out.println(fullLine.toString());
        }
        System.out.println();
    }
    
    public static void PaulHorizontal(int x)
    {
        int spacing = 1; 

        for (int zeile = 0; zeile < x; zeile++){
            String pRow = P(x, zeile);
            String aRow = A(x, zeile);
            String uRow = U(x, zeile);
            String lRow = L(x, zeile);

            StringBuilder fullLine = new StringBuilder();

            fullLine.append(pRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(aRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(uRow);
            for (int i = 0; i < spacing; i++) fullLine.append(" ");

            fullLine.append(lRow);

            System.out.println(fullLine.toString());
        }
        System.out.println();
    }
    
    public static void Jakob(){
        JakobHorizontal(standardgroesse);
    }

    public static void Alex(){
        AlexHorizontal(standardgroesse);
    }

    public static void Job(){
        JobHorizontal(standardgroesse);
    }

    public static void Tobi(){
        TobiHorizontal(standardgroesse);
    }
    
    public static void Graf(){
        GrafHorizontal(standardgroesse);
    }
    
    public static void Paul(){
        PaulHorizontal(standardgroesse);
    }
    
    public static void alleName(){
        JakobHorizontal(standardgroesse);
        AlexHorizontal(standardgroesse);
        JobHorizontal(standardgroesse);
        TobiHorizontal(standardgroesse);
        GrafHorizontal(standardgroesse);
        PaulHorizontal(standardgroesse);
    }
}