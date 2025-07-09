/**
 * @author Yskysoar
 * @createTime 2025-07-09 12:42
 * @description 3439. 重新安排会议得到最多空余时间 I
 * 给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
 * 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
 * 你可以重新安排 至多 k 个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
 * 移动前后所有会议之间的 相对 顺序需要保持不变，而且会议时间也需要保持互不重叠。
 * 请你返回重新安排会议以后，可以得到的 最大 空余时间。
 * 注意，会议 不能 安排到整个活动的时间以外。
 * 示例 1：
 * 输入：eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]
 * 输出：2
 * 解释：
 * 将 [1, 2] 的会议安排到 [2, 3] ，得到空余时间 [0, 2] 。
 * 示例 2：
 * 输入：eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]
 * 输出：6
 * 解释：
 * 将 [2, 4] 的会议安排到 [1, 3] ，得到空余时间 [3, 9] 。
 * 示例 3：
 * 输入：eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
 * 输出：0
 * 解释：
 * 活动中的所有时间都被会议安排满了。
 * 提示：
 * 1 <= eventTime <= 10^9
 * n == startTime.length == endTime.length
 * 2 <= n <= 10^5
 * 1 <= k <= n
 * 0 <= startTime[i] < endTime[i] <= eventTime
 * endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。
 */
public class Solution3439 {
    public static void main(String[] args) {
        Solution3439 solution3439 = new Solution3439();
        int ans = solution3439.maxFreeTime(5, 2, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5});
        System.out.println(ans);
    }

    /**
     * 前缀和 + 滑动窗口
     * @param eventTime 右边界
     * @param k         可操作会议数
     * @param startTime 会议开始时间
     * @param endTime   会议结束时间
     * @return 最大连续空闲时间
     */
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int ans = Integer.MIN_VALUE;
        int[] lengths = new int[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            lengths[i] = (endTime[i] - startTime[i]);
        }//初始化记录会议区间
        for (int i = 1; i < lengths.length; i++) {
            lengths[i] += lengths[i - 1];
        }//前缀和
        for (int i = 0; i < startTime.length; i++) {//从左边开始，内部全部推到右边
            if (i <= k - 1) {//窗口长度不大于k
                int count = i + 1 >= startTime.length ? eventTime : startTime[i + 1];
                count -= lengths[i];
                ans = Math.max(ans, count);
            } else {//窗口长度大于k
                int count = (i + 1 >= startTime.length ? eventTime : startTime[i + 1]) - startTime[i - k + 1];
                count -= (lengths[i] - lengths[i - k]);
                ans = Math.max(ans, count + (startTime[i - k + 1] - endTime[i - k]));
            }
        }
        for (int i = startTime.length - 1; i >= 0; i--) {//从右边开始，内部全部推到左边
            if (startTime.length - 1 - i <= k - 1) {//窗口长度不大于k
                int count = endTime[startTime.length - 1] - (i - 1 < 0 ? 0 : endTime[i - 1]);
                count -= (lengths[startTime.length - 1] - (i - 1 < 0 ? 0 : lengths[i - 1]));
                ans = Math.max(ans, count);
            } else {//窗口长度大于k
                int count = endTime[i + k - 1] - (i - 1 < 0 ? 0 : endTime[i - 1]);
                count -= (lengths[i + k - 1] - (i - 1 < 0 ? 0 : lengths[i - 1]));
                ans = Math.max(ans, count + (startTime[i + k] - endTime[i + k - 1]));
            }
        }
        return ans;
    }
}
