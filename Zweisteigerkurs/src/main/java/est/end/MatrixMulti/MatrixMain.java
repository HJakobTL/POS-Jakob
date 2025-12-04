package est.end.MatrixMulti;

public class MatrixMain {
    public static void main(String[] args) {

        int[][] e = new int[][]{{1,2,3},{4,5,6}};
        int[][] f = new int[][]{{7,8},{9,10},{11,12}};
        int[][] k = new int[2][2];

        k = mal(e,f);
        for (int i = 0; i < k.length; i++) {
            for (int j = 0; j < k.length; j++) {
                System.out.println(k[i][j]);
            }
        }

    }
}
