
/**
 * @author Yskysoar
 * @createTime 2023-03-05 15:43
 * @description 6307. 递枕头
 * n 个人站成一排，按从 1 到 n 编号。
 * 最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。
 *
 * 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
 * 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
 * 示例 1：
 *
 * 输入：n = 4, time = 5
 * 输出：2
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 -> 4 -> 3 -> 2 。
 * 5 秒后，枕头传递到第 2 个人手中。
 * 示例 2：
 *
 * 输入：n = 3, time = 2
 * 输出：3
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 。
 * 2 秒后，枕头传递到第 3 个人手中。
 */
public class Solution6307 {
    public static void main(String[] args) {
        Solution6307 solution6307 = new Solution6307();
        int ans = solution6307.passThePillow1(18, 38);
        int an = solution6307.passThePillow2(18, 38);
        System.out.println(ans);
        System.out.println(an);
    }

    /**
     * 标记法：记录此时传递方向是正序还是倒序即可
     * @param n 队伍总人数
     * @param time 传递次数
     * @return 最后一人的序号
     */
    public int passThePillow1(int n, int time) {
        int point = 1;//奇数正序，偶数逆序
        int ans = 1;
        for (int i = 0; i < time; i++) {
            if (point % 2 != 0) {
                ans++;
            } else {
                ans--;
            }
            if (ans == n || ans == 1) {
                point++;
            }
        }
        return ans;
    }

    /**
     * 数学分析法：计算循环轮次然后求解最后一组传递的方向
     * @param n 队伍总人数
     * @param time 传递次数
     * @return 最后一人的序号
     */
    public int passThePillow2(int n, int time) {
        if (time < n) return time + 1;
        int length = n - 1;//因为到了一端是直接返回，所以取n-1的长度为一次循环，每次循环可以刚好搭上上一次结尾
        int point = time / length;//循环圈数
        int reminder = time % length;//循环后剩下的次数
        if (point % 2 != 0) {//奇数次循环：此时为逆序
            if (reminder == 0) {
                return n;
            }
            return n - reminder;//从结尾开始减法将序号已经匹配好了
        } else {//偶数次循环：此时为正序
            if (reminder == 0) {
                return 1;
            }
            return reminder + 1;//轮数和序号差1需要手动匹配
        }
    }
}
