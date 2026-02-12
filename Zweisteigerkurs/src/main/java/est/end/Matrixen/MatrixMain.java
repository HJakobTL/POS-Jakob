package est.end.Matrixen;

public class MatrixMain {
    static void main() {

        // Wird in später in von einer csv datei eingelesen
        Matrix m1 = new Matrix(new Integer[][]{
                {0, 1, 1, 1, 0},
                {1, 0, 0, 1, 1},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0}
        });

        System.out.println("DistanzenMatrix");
        System.out.println(m1.getDistanzeMatrix());
    }
}
