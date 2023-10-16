import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author Yskysoar
 * @createTime 2023-10-16 16:06
 * @description 260.只出现一次的数字III
 * 给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。
 * 示例 1：
 * 输入：nums = [1,2,1,3,2,5]
 * 输出：[3,5]
 * 解释：[5, 3] 也是有效的答案。
 * 示例 2：
 * 输入：nums = [-1,0]
 * 输出：[-1,0]
 * 示例 3：
 * 输入：nums = [0,1]
 * 输出：[1,0]
 */
public class Solution260 {
    public static void main(String[] args) {
        Solution260 solution260 = new Solution260();
        int[] ans = solution260.singleNumber(new int[]{1, 2, 1, 3, 2, 5});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 哈希表：将数据全部加入表中并删除次数为2的元素
     * @param nums 数据数组
     * @return 恰好有两个元素只出现一次的结果集
     */
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            if (hashMap.get(num) == 2) hashMap.remove(num);
        }
        int[] ans = new int[2];
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            ans[i] = iterator.next();
        }
        return ans;
    }
}
