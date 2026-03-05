package org.example;

public class BArray {
    int counterCurrent = 0;
    int counterMax = 0;
    private final boolean[][] arr;
    private final boolean[][] mask;

    public BArray(boolean[][] arr) {
        this.arr = arr;
        mask = new boolean[arr.length][arr[0].length];
    }

    public int GebieteFinder(){
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = 0; j <= arr[0].length - 1; j++) {
                if (arr[i][j] && !mask[i][j]) {
                    mask[i][j] = true;
                    counterCurrent++;
                    gebietScanner(i,j,true);
                }
            }
        }
        return counterMax;
    }

    public void gebietScanner(int i, int j, boolean r){
        if (i != arr.length -1 && arr[i+1][j] && !mask[i+1][j]) {
            mask[i+1][j] = true;
            counterCurrent++;
            gebietScanner(i+1,j,false);
        }
        if (i !=0 &&arr[i-1][j] && !mask[i-1][j]) {
            mask[i-1][j] = true;
            counterCurrent++;
            gebietScanner(i-1,j,false);
        }
        if (j != arr[0].length -1 && arr[i][j+1] && !mask[i][j+1]) {
            mask[i][j+1] = true;
            counterCurrent++;
            gebietScanner(i,j+1,false);
        }
        if (j != 0 && arr[i][j-1] && !mask[i][j-1]) {
            mask[i][j-1] = true;
            counterCurrent++;
            gebietScanner(i,j-1,false);
        }
        if (r) {
            if (counterCurrent > counterMax) counterMax = counterCurrent;
            counterCurrent = 0;
            GebieteFinder();
        }
    }
}
