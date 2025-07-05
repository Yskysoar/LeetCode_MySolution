import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author Yskysoar
 * @createTime 2025-07-05 11:17
 * @description 1394. 找出数组中的幸运数
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 * 示例 1：
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * 示例 2：
 * 输入：arr = [1,2,2,3,3,3]
 * 输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * 示例 3：
 * 输入：arr = [2,2,2,3,3]
 * 输出：-1
 * 解释：数组中不存在幸运数。
 * 示例 4：
 * 输入：arr = [5]
 * 输出：-1
 * 示例 5：
 * 输入：arr = [7,7,7,7,7,7,7]
 * 输出：7
 * 提示：
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 */
public class Solution1394 {
    /**
     * 哈希表统计频次
     * @param arr 数据数组
     * @return 最大的完美数
     */
    public int findLucky1(int[] arr) {
        int ans = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        for (Integer key : hashMap.keySet()) {
            if (Objects.equals(hashMap.get(key), key)) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }

    /**
     * 排序 + 倒遍历计数
     * @param arr 数据数组
     * @return 最大的完美数
     */
    public int findLucky2(int[] arr) {
        int ans = -1, count = 1;
        Arrays.sort(arr);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr.length) break;//大于长度的数不可能是完美数
            if (arr[i] == arr[i + 1]) {
                count++;
            } else if (count == arr[i + 1]){
                ans = count;
                break;
            } else {
                count = 1;
            }
        }
        return Math.max(ans, count == arr[0] ? count: -1);
    }
}
