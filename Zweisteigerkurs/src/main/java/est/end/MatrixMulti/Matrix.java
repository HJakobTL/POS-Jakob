package est.end.MatrixMulti;

import java.util.Arrays;

public class Matrix {
    private final Integer[][] array;

    public Matrix(Integer[][] array) {
        this.array = array;
    }

    public int getRows() {
        return array.length;
    }

    public int getCols() {
        return array[0].length;
    }

    private Integer[][] getArray(){
        return array;
    }

    public Matrix multiply(Matrix other) {
        if (this.getCols() != other.getRows()) {
            throw new IllegalArgumentException("Incompatible matrix sizes for multiplication.");
        }
        Integer[][] result = new Integer[this.getRows()][other.getCols()];
        for (Integer[] zeile: result){
            Arrays.fill(zeile, 0);
        }

        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < other.getCols(); j++) {
                for (int k = 0; k < this.getCols(); k++) {
                    result[i][j] += this.array[i][k] * other.array[k][j];
                }
            }
        }

        return new Matrix(result);
    }

    public Matrix p(int n) {
        if (n < 1) throw new IllegalArgumentException("sorry weiss nicht wie ich das tun soll");
        if (n == 1) return this;
        Matrix result = multiply(this); // dzt. result = this^2
        for (int i = 2; i < n; i++ ) {
            result = result.multiply(this);
        }
        return result;
    }

    public int[] getKnotengrade(){
        if (getCols() != getRows()) throw new IllegalStateException("Sorry ist nur für quadratische Matrizen definiert");
        int[] res = new int[this.getRows()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                res[i] += array[i][j];
            }
        }
        return res;
    }

    public Matrix getDistanzeMatrix (){
        Integer[][] distanzArray = new Integer[getRows()][getCols()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (i == j) {
                    distanzArray[i][j] = 0;
                    continue;
                }
                if (array[i][j] != 0) {
                    distanzArray[i][j] = 1;
                    continue;
                }
                distanzArray[i][j] = null;
            }
        }
        for (int k = 2; k < getRows(); k++) {
            if (noInfinityIn(distanzArray)) break;
            updateDistanzMatrixFrom(distanzArray,p(k).getArray(),k);
        }

        return new Matrix(distanzArray);
    }

    private boolean noInfinityIn(Integer[][] testArray){
        for(Integer[] zeile: testArray) {
            for (Integer spalte: zeile) {
                if (spalte == null) return false;
            }
        }
        return true;
    }

    private void updateDistanzMatrixFrom(Integer[][] distanzMatrix, Integer[][] potenzMatrix, int weglaenge){
        for (int i = 0; i < distanzMatrix.length; i++) {
            for (int j = 0; j < distanzMatrix[i].length; j++) {
                if (distanzMatrix[i][j] != null) continue;
                if (potenzMatrix[i][j] > 0) {
                    distanzMatrix[i][j] = weglaenge;
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Integer[] row : array) {
            sb.append("[");
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1); // Remove last space
            sb.append("]\n");
        }
        return sb.toString();
    }

}
