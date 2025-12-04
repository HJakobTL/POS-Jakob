package est.end.MatrixMulti;

public class Matrix {

    private int[][] array;

    public Matrix(int[][] array) {
        this.array = array;
    }

    public int getRows() {
        return array.length;
    }

    public int getSpaces(){
        return array.length;
    }

    public int[][] mal(int[][] a, int[][] b){
        int[][] r = new int[2][2];
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r.length; j++) {
                for (int k = 0; k < r.length+1; k++) {
                    r[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return r;
    }
}
