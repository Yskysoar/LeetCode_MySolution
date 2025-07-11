import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yskysoar
 * @createTime 2023-08-27 22:36
 * @description 56.合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [start i, end i]
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] ans = solution56.merge(new int[][]{{1, 4}, {0, 1}});
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 标记排序(WA原因：[[1,4],[0,2],[3,5]])
     * @param intervals 数据数组
     * @return 合并区间
     */
    public int[][] mergeWA(int[][] intervals) {
        int max = Arrays.stream(intervals).flatMapToInt(Arrays::stream).max().orElse(Integer.MIN_VALUE);
        int[] nums = new int[max + 1];
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int start = intervals[i][0]; start <= intervals[i][1]; start++) {
                nums[start] = 1;
            }
            //标记非链接点
            if (i != 0 && intervals[i][0] == intervals[i - 1][1] + 1) {
                nums[intervals[i - 1][1]] = -1;
            }//防止[1,4][5,6]
            if (intervals[i][0] == intervals[i][1]) {//防止[0,0]
                nums[intervals[i][0]] = 0;
                arrayList.add(new int[]{intervals[i][0], intervals[i][0]});
            }
        }//将所有数据遍历并且进行标记
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            while (left < nums.length && nums[left] == 0) {//寻找下一个左边界
                left++;
            }
            right = left;
            while (right < nums.length && nums[right] != 0 && nums[right] != -1) {
                right++;
            }
            if (right == nums.length || nums[right] != -1) {
                arrayList.add(new int[]{left, right - 1});
                left = right;//移动到下一个位置
            } else if (nums[right] == -1) {
                arrayList.add(new int[]{left, right});
                left = right + 1;
            }
        }
        return arrayList.toArray(int[][]::new);
    }

    /**
     * 排序 + 有限次合并
     * @param intervals 数据数组
     * @return 合并后的数组
     */
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        // 按结束时间升序，结束时间相同则开始时间降序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        ArrayList<int[]> arrayList = new ArrayList<>(Arrays.asList(intervals));
        while (true) {//合并完可能会出现仍可以合并的情况
            for (int i = 1; i < arrayList.size(); i++) {//开始合并前一个元素
                if (arrayList.get(i - 1)[1] >= arrayList.get(i)[0]) {
                    arrayList.get(i)[0] = Math.min(arrayList.get(i - 1)[0], arrayList.get(i)[0]);//选取更小的左边界，右边界一定是当前数组大
                    arrayList.remove(--i);
                }
            }
            if (size == arrayList.size()) {
                break;
            } else {
                size = arrayList.size();
            }
        }
        return arrayList.toArray(new int[arrayList.size()][2]);
    }
}
