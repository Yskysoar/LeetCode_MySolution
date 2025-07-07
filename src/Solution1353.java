import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Yskysoar
 * @createTime 2025-07-07 12:51
 * @description 1353. 最多可以参加的会议数目
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。
 * 请你返回你可以参加的 最大 会议数目。
 * 示例 1：
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * 提示：
 * 1 <= events.length <= 10^5
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 10^5
 */
public class Solution1353 {
    public static void main(String[] args) {
        Solution1353 solution1353 = new Solution1353();
        int ans = solution1353.maxEvents(new int[][]{{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}});
        System.out.println(ans);
    }

    public int maxEventsWA(int[][] events) {//超时 O(n²)
        ArrayList<Integer> arrayList = new ArrayList<>();
        boolean isSorted = false;//标志是否完成排序
        for (int i = 1; i < events.length; i++) {//结束时间晚的会议向后放
            for (int j = 0; j < events.length - i; j++) {
                if (events[j][1] > events[j + 1][1]) {
                    isSorted = true;

                    events[j][0] ^= events[j + 1][0];
                    events[j + 1][0] ^= events[j][0];
                    events[j][0] ^= events[j + 1][0];

                    events[j][1] ^= events[j + 1][1];
                    events[j + 1][1] ^= events[j][1];
                    events[j][1] ^= events[j + 1][1];
                } else if (events[j][1] == events[j + 1][1]) {//结束时间相同则开始时间晚的向前放
                    if (events[j][0] < events[j + 1][0]) {
                        isSorted = true;
                        events[j][0] ^= events[j + 1][0];
                        events[j + 1][0] ^= events[j][0];
                        events[j][0] ^= events[j + 1][0];
                    }
                }
            }
            if (!isSorted) {//当存在
                break;
            } else {
                isSorted = false;
            }
        }
        for (int[] event : events) {
            if (!arrayList.contains(event[0])) {//如果当前会议的开始时间没有被占用则加入到日程中
                arrayList.add(event[0]);
            } else {
                for (int j = event[0] + 1; j <= event[1]; j++) {
                    if (!arrayList.contains(j)) {
                        arrayList.add(j);
                        break;
                    }
                }
            }
        }
        return arrayList.size();
    }

    /**
     * 排序 + 贪心（思路同上，写法优化）
     * @param events 会议的时间表
     * @return 可参与的最大会议数
     */
    public int maxEvents(int[][] events) {
        int ans = 0;
        TreeSet<Integer> availableDays = new TreeSet<>();
        // 按结束时间升序，结束时间相同则开始时间降序
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        // 提前准备所有可能的天数
        int maxDay = events[events.length - 1][1];
        for (int i = 1; i <= maxDay; i++) {
            availableDays.add(i);
        }

        for (int[] event : events) {
            Integer day = availableDays.ceiling(event[0]); // 找到 >= start 的最早可用天
            if (day != null && day <= event[1]) {
                ans++;
                availableDays.remove(day); // 占用该天
            }
        }
        return ans;
    }
}
