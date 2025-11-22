package est.end;
public class Sort {

    public void sorter(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public void main(String[] args) {
        int[] arr1 = {5, 3, 4, 1, 2};
        System.out.print("Array zuerst: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+ " ");
        }
        System.out.print("\n");
        System.out.print("Array danach: ");
        sorter(arr1);
    }
}