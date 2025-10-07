import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-10-08 1:09
 * @description 2300. 咒语和药水的成功对数
 * 给你两个正整数数组 spells 和 potions ，长度分别为 n 和 m ，其中 spells[i] 表示第 i 个咒语的能量强度，potions[j] 表示第 j 瓶药水的能量强度。
 * 同时给你一个整数 success 。一个咒语和药水的能量强度 相乘 如果 大于等于 success ，那么它们视为一对 成功 的组合。
 * 请你返回一个长度为 n 的整数数组 pairs，其中 pairs[i] 是能跟第 i 个咒语成功组合的 药水 数目。
 * 示例 1：
 * 输入：spells = [5,1,3], potions = [1,2,3,4,5], success = 7
 * 输出：[4,0,3]
 * 解释：
 * - 第 0 个咒语：5 * [1,2,3,4,5] = [5,10,15,20,25] 。总共 4 个成功组合。
 * - 第 1 个咒语：1 * [1,2,3,4,5] = [1,2,3,4,5] 。总共 0 个成功组合。
 * - 第 2 个咒语：3 * [1,2,3,4,5] = [3,6,9,12,15] 。总共 3 个成功组合。
 * 所以返回 [4,0,3] 。
 * 示例 2：
 * 输入：spells = [3,1,2], potions = [8,5,8], success = 16
 * 输出：[2,0,2]
 * 解释：
 * - 第 0 个咒语：3 * [8,5,8] = [24,15,24] 。总共 2 个成功组合。
 * - 第 1 个咒语：1 * [8,5,8] = [8,5,8] 。总共 0 个成功组合。
 * - 第 2 个咒语：2 * [8,5,8] = [16,10,16] 。总共 2 个成功组合。
 * 所以返回 [2,0,2] 。
 * 提示：
 * n == spells.length
 * m == potions.length
 * 1 <= n, m <= 10^5
 * 1 <= spells[i], potions[i] <= 10^5
 * 1 <= success <= 10^10
 */
public class Solution2300 {
    public static void main(String[] args) {
        Solution2300 solution2300 = new Solution2300();
        int[] ans = solution2300.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 排序 + 索引标记
     * 先给potions排序，spells也排序（题目有顺序要求，提前复制一个就行）
     * spells从大到小开始遍历，记录在points中从小到大开始遍历的第一个符合要求的索引（后面的因为排序过了，一定符合要求，数量就是长度减去当前索引值）
     * 下一轮循环从上一次符合要求的索引后继续即可（spells值减小，potions不变，那么索引之前的必定不合要求）
     * @param spells 咒语强度
     * @param potions 药水强度
     * @param success 最低强度
     * @return 符合的成功对数
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();//同样的spells值的结果一致，哈希表记录即可
        int[] nums = Arrays.copyOf(spells, spells.length);//题目有顺序要求，拷贝一份
        Arrays.sort(nums);
        Arrays.sort(potions);
        int index = 0;//记录上一轮的结尾
        for (int i = nums.length - 1; i >= 0; i--) {//从大的元素开始向前遍历
            for (int j = index; j < potions.length; j++) {//从小的元素开始向后遍历
                if ((long) nums[i] * potions[j] >= success) {//大元素 * 小分数符合要求，那么下一轮的较小元素在此小分数之前一定不符合
                    hashMap.put(nums[i], potions.length - j);
                    index = j;
                    break;
                }
            }
        }
        for (int i = 0; i < spells.length; i++) {
            ans[i] = hashMap.getOrDefault(spells[i], 0);//赋值答案
        }
        return ans;
    }
}
