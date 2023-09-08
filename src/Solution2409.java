import java.util.Arrays;
import java.util.Map;
import java.util.UnknownFormatConversionException;

/**
 * @author Yskysoar
 * @createTime 2023-04-17 14:49
 * @description 2409. 统计共同度过的日子数
 * Alice 和 Bob 计划分别去罗马开会。
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），
 * 而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
 * 示例 1：
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 16、17 和 18 号。所以答案为 3 。
 * 示例 2：
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
 */
public class Solution2409 {
    public static void main(String[] args) {
        Solution2409 solution2409 = new Solution2409();
        int ans = solution2409.countDaysTogether("08-15", "08-18", "08-16", "08-19");
        System.out.println(ans);
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] MyCalenderPreSum = new int[] {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};//前缀和
        int[] days = new int[] {Integer.parseInt(arriveAlice.substring(0, 2)),  Integer.parseInt(arriveAlice.substring(3)),
                                Integer.parseInt(leaveAlice.substring(0, 2)),  Integer.parseInt(leaveAlice.substring(3)),
                                Integer.parseInt(arriveBob.substring(0, 2)), Integer.parseInt(arriveBob.substring(3)),
                                Integer.parseInt(leaveBob.substring(0, 2)), Integer.parseInt(leaveBob.substring(3))};
        int start = Math.max(MyCalenderPreSum[days[0] - 1] + days[1], MyCalenderPreSum[days[4] - 1] + days[5]);
        int end = Math.min(MyCalenderPreSum[days[2] - 1] + days[3], MyCalenderPreSum[days[6] - 1] + days[7]);
        return end >= start ? end - start + 1: 0;
    }
}
