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
        array = new int[getRows()][getSpaces()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getSpaces(); j++) {
                for (int k = 0; k < getRows()+1; k++) {
                    array[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return array;
    }
}
