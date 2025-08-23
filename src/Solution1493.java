import java.util.ArrayList;

/**
 * @author Yskysoar
 * @createTime 2025-08-24 0:11
 * @description 1493. 删掉一个元素以后全为 1 的最长子数组
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * 如果不存在这样的子数组，请返回 0 。
 * 提示 1：
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 要么是 0 要么是 1 。
 */
public class Solution1493 {
    public static void main(String[] args) {
        Solution1493 solution1493 = new Solution1493();
        int ans = solution1493.longestSubarray2(new int[]{1, 0, 0, 0, 0});
        System.out.println(ans);
    }

    /**
     * 计数 + 贪心
     * @param nums 0/1 数组
     * @return 求满足子数组至多有一个0的最长子数组的长度（减一）
     */
    public int longestSubarray1(int[] nums) {
        int ans = 0, num = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : nums) {
            if (i == 0) {
                if (num != 0) {
                    arrayList.add(num);
                    num = 0;
                }
                arrayList.add(0);
            } else {
                num++;
            }
        }
        if (num != 0) arrayList.add(num);//处理尾段
        //特判
        if (arrayList.size() == 1 && arrayList.get(0) > 0) return arrayList.get(0) - 1;
        if (arrayList.size() == 2) return Math.max(arrayList.get(0), arrayList.get(1));
        if (arrayList.size() == 3) return arrayList.get(0) + arrayList.get(1) + arrayList.get(2);
        //通判
        for (int i = 0; i < arrayList.size() - 2; i++) {
            if (arrayList.get(i) != 0 && arrayList.get(i + 1) == 0)//第三个元素若不是0才会增加子数组长度
                ans = Math.max(ans, arrayList.get(i) + arrayList.get(i + 2));
        }
        return ans;
    }

    /**
     * 滑动窗口 + 维护0的个数
     * @param nums 0/1 数组
     * @return 求满足子数组至多有一个0的最长子数组的长度（减一）
     */
    public int longestSubarray2(int[] nums) {
        int n = nums.length, ans = 0, count = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (nums[i] == 0) count++;
            while (count > 1) {
                if (nums[j++] == 0) count--;
            }
            ans = Math.max(ans, i - j);
        }
        return ans;
    }
}
