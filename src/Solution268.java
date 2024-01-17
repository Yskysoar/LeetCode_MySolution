import java.util.Arrays;

public class Solution268 {
    public static void main(String[] args) {
        Solution268 solution268 = new Solution268();
        int res = solution268.missingNumber4(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1});
        System.out.println(res);
    }

    public int missingNumber1(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return ((nums.length + 1) * nums.length) / 2 - sum;
    }

    public int missingNumber2(int[] nums) {
        int i, j;
        for (i = 0; i <= nums.length; i++) {
            for (j = 0; j < nums.length; j++) {
                if (i == nums[j]) {
                    break;
                }
            }
            if (j == nums.length) {
                break;
            }
        }
        return i;
    }

    public int missingNumber3(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                break;
            }
        }
        return i;
    }

    public int missingNumber4(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }
        for (int i = 0; i <= nums.length; i++) {
            sum ^= i;
        }
        return sum;
    }
}
