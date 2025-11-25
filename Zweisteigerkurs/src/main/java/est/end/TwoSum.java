package est.end;

public class TwoSum{

    public int[] twoSum(int[] nums, int target) {
        int[] arr2 = new int[2];
        for (int i = 0; i < nums.length;i++){
            for(int j = i+1; j < nums.length;j++){
                if (nums[i] + nums[j] == target){
                    arr2[0] = i;
                    arr2[1] = j;
                }
            }

        }
        return arr2;
    }

    public void main(String[] args) {
        int[] arr1 = {2, 7, 11, 15};
        int[] arr2 = {3, 2, 4};
        int[] arr3 = {3, 3};
        int[] arrL1 = {0,1};
        int[] arrL2 = {1,2};
        int[] arrL3 = {0,1};
        int[] Los1 = twoSum(arr1, 9);
        int[] Los2 = twoSum(arr2, 6);
        int[] Los3 = twoSum(arr3, 6);
        for(int i = 0; i < Los1.length; i++){
            System.out.println(Los1[i]);
        }
    }
}