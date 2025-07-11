import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yskysoar
 * @createTime 2025-07-11 10:42
 * @description 3169. 无需开会的工作日
 * 给你一个正整数 days，表示员工可工作的总天数（从第 1 天开始）。另给你一个二维数组 meetings，长度为 n，其中 meetings[i] = [start_i, end_i] 表示第 i
 * 次会议的开始和结束天数（包含首尾）。
 * 返回员工可工作且没有安排会议的天数。
 * 注意：会议时间可能会有重叠。
 * 示例 1：
 * 输入：days = 10, meetings = [[5,7],[1,3],[9,10]]
 * 输出：2
 * 解释：
 * 第 4 天和第 8 天没有安排会议。
 * 示例 2：
 * 输入：days = 5, meetings = [[2,4],[1,3]]
 * 输出：1
 * 解释：
 * 第 5 天没有安排会议。
 * 示例 3：
 * 输入：days = 6, meetings = [[1,6]]
 * 输出：0
 * 解释：
 * 所有工作日都安排了会议。
 * 提示：
 * 1 <= days <= 10^9
 * 1 <= meetings.length <= 10^5
 * meetings[i].length == 2
 * 1 <= meetings[i][0] <= meetings[i][1] <= days
 */
public class Solution3169 {
    public static void main(String[] args) {
        Solution3169 solution3169 = new Solution3169();
        int ans = solution3169.countDays(14, new int[][]{{6, 11}, {7, 13}, {8, 9}, {5, 8}, {3, 13}, {11, 13}, {1, 3}, {5, 10}, {8, 13}, {3, 9}});
        System.out.println(ans);
    }

    /**
     * 合并区间
     * @param days     总天数
     * @param meetings 会议数据
     * @return 不开会的天数
     */
    public int countDays(int days, int[][] meetings) {
        // 按结束时间升序，结束时间相同则开始时间降序
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));
        ArrayList<int[]> arrayList = new ArrayList<>(Arrays.asList(meetings));
        int size = arrayList.size();
        while (true) {//合并完可能会出现仍可以合并的情况
            for (int i = 1; i < arrayList.size(); i++) {//开始合并前一个元素
                if (arrayList.get(i - 1)[1] >= arrayList.get(i)[0]) {
                    arrayList.get(i)[0] = Math.min(arrayList.get(i - 1)[0], arrayList.get(i)[0]);//选取更小的左边界，右边界一定是当前数组大
                    arrayList.remove(--i);
                }
            }
            if (size == arrayList.size()) break;
            size = arrayList.size();
        }
        int nums = 0;
        for (int[] meeting : arrayList) {
            nums += meeting[1] - meeting[0] + 1;
        }
        return days - nums;
    }
}
