import java.util.Arrays;
import java.util.HashSet;

public class Solution169 {
    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int res = solution169.majorityElement2(new int[]{3,3,3,2,2,1,1,1,2,2,2,2,3,3,3,3});
        System.out.println(res);
    }
    public int majorityElement1(int[] nums) {
        //数学思维法：符号要求的数字的长度一定超过数组长度的一半
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
        因为多数元素的数量一定会大于其他剩余元素之和，那么他们的数量相互抵消剩下的还是多数元素
     */
    public int majorityElement2(int[] nums) {
        int res = 0;//记录当前元素
        int count = 0;//记录当前元素出现的次数
        for (int i : nums) {
            if (count == 0) {//如果当前计数为0就重新开始计数
                res = i;
            }
            count += (res == i ? 1 : -1);
            //如果当前记录的元素不等于遍历的元素就计数减一，否则加一
        }
        return res;
    }
}
