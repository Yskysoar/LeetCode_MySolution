import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yskysoar
 * @createTime 2023-09-05 22:54
 * @description 2605.从数字数组里生成最小数字
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同
 * 请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * 示例 1：
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * 示例 2：
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 */
public class Solution2605 {
    public static void main(String[] args) {
        Solution2605 solution2605 = new Solution2605();
        int ans = solution2605.minNumber(new int[]{3,5,2,6}, new int[]{3,1,7});
        System.out.println(ans);
    }

    /**
     * 数学判断：找出两个数组各自最小的数字然后组成数字，然后和两个数字重叠的最小数字比大小即可
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 从数字数组里生成的最小数字
     */
    public int minNumber(int[] nums1, int[] nums2) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int minNums1 = Integer.MAX_VALUE;
        int minNums2 = Integer.MAX_VALUE;
        for (int num : nums1) {
            arrayList1.add(num);
            minNums1 = Math.min(minNums1, num);
        }
        for (int num : nums2) {
            if (arrayList1.contains(num)) arrayList2.add(num);
            minNums2 = Math.min(minNums2, num);
        }
        int minNum = arrayList2.isEmpty() ? Integer.MAX_VALUE : Collections.min(arrayList2);
        return Math.min((Math.min(minNums1, minNums2) * 10 + Math.max(minNums1, minNums2)), minNum);
    }
}
