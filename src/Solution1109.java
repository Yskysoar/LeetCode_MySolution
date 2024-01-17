import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-08-01 13:36
 * @description 1109.航班预定统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [first.i, last.i, seats.i]
 * 意味着在从 first.i 到 last.i （包含 first.i 和 last.i ）的 每个航班 上预订了 seats.i 个座位。
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * 示例 1：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 */
public class Solution1109 {
    public static void main(String[] args) {
        Solution1109 solution1109 = new Solution1109();
        int[] ans = solution1109.corpFlightBookings2(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 暴力遍历
     * @param bookings 预定信息
     * @param n        航班数量
     * @return 预定座位总数
     */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                ans[i - 1] += booking[2];
            }
        }
        return ans;
    }

    /**
     * 差分：公交车问题，有n个站，在i站上车k人，要坐j站，在j+1站下车，每个站点的总人数为 上一站人数+当前人数变化
     * @param bookings 预定信息
     * @param n        航班数量
     * @return 预定座位总数
     */
    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}
