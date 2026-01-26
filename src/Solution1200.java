import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2026-01-26 14:21
 * @description 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 每对元素对 [a,b] 如下：
 * a , b 均为数组 arr 中的元素
 * a < b
 * b - a 等于 arr 中任意两个元素的最小绝对差
 * 示例 1：
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * 示例 2：
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * 示例 3：
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 * 提示：
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
public class Solution1200 {
    /**
     * 暴力
     * @param arr 数据数组
     * @return 符合最小的绝对值的数据对数组
     */
    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        Arrays.sort(arr);//排序
        int minABS = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minABS = Math.min(minABS, arr[i] - arr[i - 1]);//记录最小的绝对值
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minABS) {
                ans.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return ans;
    }

    /**
     * 路径优化
     * 若出现的新的最小绝对值，清空保存的结果，从该基础继续即可（前面不可能有符合要求的数据对）
     * @param arr 数据数组
     * @return 符合最小的绝对值的数据对数组
     */
    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        Arrays.sort(arr);//排序
        int minABS = arr[1] - arr[0];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > minABS) {
                continue;
            } else if (arr[i] - arr[i - 1] < minABS) {
                minABS = arr[i] - arr[i - 1];
                ans.clear();
            }
            ans.add(List.of(arr[i - 1], arr[i]));
        }
        return ans;
    }
}
