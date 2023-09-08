import java.util.Arrays;
import java.util.HashSet;

public class Solution414 {
    public static void main(String[] args) {
        Solution414 solution414 = new Solution414();
        int res = solution414.thirdMax4(new int[]{1,2,-2147483648,3});
        System.out.println(res);
    }
    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        //计算不重复元素个数
        int num = 1;
        int temp = nums[0];
        for (int i : nums) {
            if (temp != i) {
                temp = i;
                num++;
            }
        }
        //寻找第三大元素
        int res = nums[nums.length - 1];
        int index = 2;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (res != nums[i] && index > 0) {
                res = nums[i];
                index--;
            }
        }
        return num >= 3 ? res : nums[nums.length - 1];
    }

    public int thirdMax2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        Object[] array = set.toArray();
        Arrays.sort(array);
        return (int) (set.size() >= 3 ? array[set.size() - 3] : array[set.size() - 1]);
    }

    public int thirdMax3(int[] nums) {
        Arrays.sort(nums);
        int num = 1;
        int res = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (res != nums[i] && num < 3) {
                res = nums[i];
                num++;
            }
        }
        return num == 3 ? res : nums[nums.length - 1];
    }

    public int thirdMax4(int[] nums) {
        int[] num = new int[] {-2147483648,-2147483648,-2147483648};//min normal max
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
            if((i == num[2])||(i == num[1])||(i == num[0]))  {
                continue;
            }
            if (i > num[2]) {
                num[0] = num[1];
                num[1] = num[2];
                num[2] = i;
            } else if (i > num[1]) {
                num[0] = num[1];
                num[1] = i;
            } else if (i > num[0]) {
                num[0] = i;
            }
        }
        return set.size() >= 3 ? num[0] : num[2];
    }
}
