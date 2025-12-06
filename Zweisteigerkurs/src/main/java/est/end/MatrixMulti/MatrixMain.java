package est.end.MatrixMulti;

public class MatrixMain {

    private Matrix test;

    public void main(String[] args) {

        int[][] e = new int[][]{{1,2,3},{4,5,6}};
        int[][] f = new int[][]{{7,8},{9,10},{11,12}};
        int[][] k = new int[2][2];
        test = new Matrix(k);

        for (int i = 0; i < test.getRows(); i++) {
            for (int j = 0; j < test.getSpaces(); j++) {
                System.out.println(test.mal(e,f)[i][j]);
            }
        }
    }
}
