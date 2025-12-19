package est.end.MatrixMulti;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix a = new Matrix(new Integer[][]{
                {0, 1, 1, 1, 0},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0}
        });
        for (int i = 0; i < a.getCols(); i++) {
            System.out.print(a.getKnotengrade()[i] + " "); // Beispiel: [3, 3, 2, 3, 1]
        }
        System.out.println();

        System.out.println("Matrix");
        System.out.println(a);
        System.out.println("DistanzMatrix");
        System.out.println(a.getDistanzeMatrix());
    }

    public static void mainAlt(String[] args) {
        Matrix a = new Matrix(new Integer[][]{
                {1, 2}, {3, 4}, {5, 6}, {7, 8}
        });
        Matrix b = new Matrix(new Integer[][]{
                {1, 2, 3},
                {4, 5, 6}
        });
        Matrix c = a.multiply(b);
        System.out.println(c);
    }
}
