import java.util.Arrays;

public class Solution561 {
    public static void main(String[] args) {
        int[] arr = new int[] {1,4,3,2};
        Solution561 solution561 = new Solution561();
        int res = solution561.arrayPairSum(arr);
        System.out.println(res);
    }
    //连续的两个数为一组求min，即所有的奇数项之和就是最大值
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int resNum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            resNum += nums[i];
        }
        return resNum;
    }
}
