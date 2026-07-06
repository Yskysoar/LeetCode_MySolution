import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-07-06 08:43
 * @description 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 * 示例：
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 * 提示：
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 */
public class Solution1288 {
    public static void main(String[] args) {
        Solution1288 solution1288 = new Solution1288();
        int ans = solution1288.removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}});
        System.out.println(ans);
    }

    /**
     * 排序 + 遍历
     * 按照首元素升序和次元素降序的规则进行排序，然后遍历的同时记录最大右边界
     * 当前范围的有边界小于最大右边界则一定会被删除（左侧由于排序规则一定成立）
     * @param intervals 数据数组
     * @return 剩余的范围数量
     */
    public int removeCoveredIntervals(int[][] intervals) {
        int ans = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);  // 第一个元素升序
            } else {
                return Integer.compare(b[1], a[1]);  // 第二个元素降序
            }
        });
        int max = -1;
        for (int[] interval : intervals) {
            if (interval[1] <= max) ans--;//判断是否需要删除
            max = Math.max(max, interval[1]);//遍历的同时记录最大右边界
        }
        return ans;
    }
}
    