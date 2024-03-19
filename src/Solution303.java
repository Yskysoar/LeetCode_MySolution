import java.util.Arrays;

public class Solution303 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

    }
}

class NumArray {//时间复杂度的优化，防止多次调用sumRange方法导致效率降低
    int[][] nums;

    public NumArray(int[] nums) {
        Arrays.sort(nums);
        this.nums = new int[2][nums.length];
        this.nums[0] = nums;
        this.nums[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.nums[1][i] = nums[i] + this.nums[1][i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return this.nums[1][right] - this.nums[1][left] + this.nums[0][left];
    }
}