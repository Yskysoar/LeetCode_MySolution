/**
 * @author Yskysoar
 * @createTime 2025-07-10 8:44
 * @description 3440. 重新安排会议得到最多空余时间 II
 * 给你一个整数 eventTime 表示一个活动的总时长，这个活动开始于 t = 0 ，结束于 t = eventTime 。
 * 同时给你两个长度为 n 的整数数组 startTime 和 endTime 。它们表示这次活动中 n 个时间 没有重叠 的会议，其中第 i 个会议的时间为 [startTime[i], endTime[i]] 。
 * 你可以重新安排 至多 一个会议，安排的规则是将会议时间平移，且保持原来的 会议时长 ，你的目的是移动会议后 最大化 相邻两个会议之间的 最长 连续空余时间。
 * 请你返回重新安排会议以后，可以得到的 最大 空余时间。
 * 注意，会议 不能 安排到整个活动的时间以外，且会议之间需要保持互不重叠。
 * 注意：重新安排会议以后，会议之间的顺序可以发生改变。
 * 示例 1：
 * 输入：eventTime = 5, startTime = [1,3], endTime = [2,5]
 * 输出：2
 * 解释：
 * 将 [1, 2] 的会议安排到 [2, 3] ，得到空余时间 [0, 2] 。
 * 示例 2：
 * 输入：eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]
 * 输出：7
 * 解释：
 * 将 [0, 1] 的会议安排到 [8, 9] ，得到空余时间 [0, 7] 。
 * 示例 3：
 * 输入：eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]
 * 输出：6
 * 解释：
 * 将 [3, 4] 的会议安排到 [8, 9] ，得到空余时间 [1, 7] 。
 * 示例 4：
 * 输入：eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]
 * 输出：0
 * 解释：
 * 活动中的所有时间都被会议安排满了。
 * 提示：
 * 1 <= eventTime <= 10^9
 * n == startTime.length == endTime.length
 * 2 <= n <= 10^5
 * 0 <= startTime[i] < endTime[i] <= eventTime
 * endTime[i] <= startTime[i + 1] 其中 i 在范围 [0, n - 2] 之间。
 */
public class Solution3440 {

    /**
     * 维护左右的最大gap
     * @param eventTime 右边界
     * @param startTime 会议开始时间
     * @param endTime   会议结束时间
     * @return 最大连续空闲时间
     */
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int ans = Integer.MIN_VALUE;
        int maxGap = 0;
        int[] lengths = new int[startTime.length];
        for (int i = 0; i < startTime.length; i++) {
            lengths[i] = (endTime[i] - startTime[i]);
        }//初始化记录会议区间
        for (int i = 1; i < lengths.length; i++) {
            lengths[i] += lengths[i - 1];
        }//前缀和
        for (int i = 0; i < startTime.length; i++) {
            int leftGap = startTime[i] - (i == 0 ? 0 : endTime[i - 1]);
            int count = (i + 1 >= startTime.length ? eventTime : startTime[i + 1]) - (i == 0 ? 0 : endTime[i - 1]);
            int len = lengths[i] - (i == 0 ? 0 : lengths[i - 1]);
            ans = Math.max(ans, count - (maxGap >= len ? 0 : len));
            maxGap = Math.max(maxGap, leftGap);
        }
        maxGap = 0;
        for (int i = startTime.length - 1; i >= 0; i--) {
            int rightGap = (i + 1 >= startTime.length ? eventTime : startTime[i + 1]) - endTime[i];
            int count = (i + 1 >= startTime.length ? eventTime : startTime[i + 1]) - (i == 0 ? 0 : endTime[i - 1]);
            int len = lengths[i] - (i == 0 ? 0 : lengths[i - 1]);
            ans = Math.max(ans, count - (maxGap >= len ? 0 : len));//之前记录的最大空隙放不下那就只能在左右平移（Solution3439）
            maxGap = Math.max(maxGap, rightGap);//更新空隙
        }
        return ans;
    }

}
