/**
 * @author Yskysoar
 * @createTime 2025-09-09 12:48
 * @description 2327. 知道秘密的人数
 * 在第 1 天，有一个人发现了一个秘密。
 * 给你一个整数 delay ，表示每个人会在发现秘密后的 delay 天之后，每天 给一个新的人 分享 秘密。同时给你一个整数 forget ，表示每个人在发现秘密 forget 天之后会 忘记 这个秘密。一个人 不能
 * 在忘记秘密那一天及之后的日子里分享秘密。
 * 给你一个整数 n ，请你返回在第 n 天结束时，知道秘密的人数。由于答案可能会很大，请你将结果对 10^9 + 7 取余 后返回。
 * 示例 1：
 * 输入：n = 6, delay = 2, forget = 4
 * 输出：5
 * 解释：
 * 第 1 天：假设第一个人叫 A 。（一个人知道秘密）
 * 第 2 天：A 是唯一一个知道秘密的人。（一个人知道秘密）
 * 第 3 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 4 天：A 把秘密分享给一个新的人 C 。（三个人知道秘密）
 * 第 5 天：A 忘记了秘密，B 把秘密分享给一个新的人 D 。（三个人知道秘密）
 * 第 6 天：B 把秘密分享给 E，C 把秘密分享给 F 。（五个人知道秘密）
 * 示例 2：
 * 输入：n = 4, delay = 1, forget = 3
 * 输出：6
 * 解释：
 * 第 1 天：第一个知道秘密的人为 A 。（一个人知道秘密）
 * 第 2 天：A 把秘密分享给 B 。（两个人知道秘密）
 * 第 3 天：A 和 B 把秘密分享给 2 个新的人 C 和 D 。（四个人知道秘密）
 * 第 4 天：A 忘记了秘密，B、C、D 分别分享给 3 个新的人。（六个人知道秘密）
 * 提示：
 * 2 <= n <= 1000
 * 1 <= delay < forget <= n
 */
public class Solution2327 {
    public static void main(String[] args) {
        Solution2327 solution2327 = new Solution2327();
        int ans = solution2327.peopleAwareOfSecret(6, 2, 4);
        System.out.println(ans);
    }

    /**
     * dp + 数学
     * sum[i]表示第i天知道秘密的所有人数：sum[i] = sum[i - 1] + add[i] - del[i]
     * add[i]表示第i天需要传播秘密的人数：add[i] = sum[i - delay]
     * del[i]表示第i天忘记秘密的人数：del[i] = sum[i - forget]
     * 最终实际知道秘密的人数为sum[i] - del[i]
     * @param n      天数
     * @param delay  传播间隔
     * @param forget 遗忘间隔
     * @return 实际知道秘密的人数
     */
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long MOD = 1000000007;
        long[] sum = new long[n + 1];//第i天知道秘密的所有人数
        long[] add = new long[n + 1];//第i天需要传播秘密的人数
        long[] del = new long[n + 1];//第i天忘记秘密的人数
        sum[1] = 1;//第一天只有一个人知道秘密，也不可能要传播和忘记
        for (int i = 2; i <= n; i++) {
            if (i - delay > 0) {
                add[i] = sum[i - delay];
            }
            if (i - forget > 0) {
                del[i] = sum[i - forget];
            }
            sum[i] = (sum[i - 1] - del[i] + add[i] + MOD) % MOD;
        }
        return (int) ((sum[n] - del[n] + MOD) % MOD);
    }
}
