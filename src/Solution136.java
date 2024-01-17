import java.util.Arrays;

public class Solution136 {
    public static void main(String[] args) {
        Solution136 solution136 = new Solution136();
        int[] arr = new int[]{4, 1, 2, 1, 2, 5, 5};
        int res = solution136.singleNumber3(arr);
        System.out.println(res);
    }

    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int onlyNum = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                onlyNum = nums[i];
                break;
            }
        }
        return onlyNum;
    }

    public int singleNumber3(int[] nums) {
        int res = 0;
        int num = 0;
        for (int i : nums) {
            for (int k : nums) {
                if (k == i) {
                    num++;
                }
            }
            if (num == 1) {
                res = i;
                break;
            }
            num = 0;
        }
        return res;
    }
}
