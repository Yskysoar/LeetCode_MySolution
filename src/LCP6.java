/**
 * @author Yskysoar
 * @createTime 2023-09-20 9:00
 * @description LCP.06 拿硬币
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。
 * 我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * 示例 1：
 * 输入：[4,2,1]
 * 输出：4
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * 示例 2：
 * 输入：[2,3,10]
 * 输出：8
 */
public class LCP6 {
    public static void main(String[] args) {
        LCP6 lcp6 = new LCP6();
        int ans = lcp6.minCount(new int[]{2, 3, 10});
        System.out.println(ans);
    }

    /**
     * 模拟
     * @param coins 每堆硬币数量
     * @return 拿完硬币的最少次数
     */
    public int minCount(int[] coins) {
        int ans = 0;
        for (int coin : coins) {
            ans += (coin - 1) / 2 + 1;//等效于ans += (coin / 2) + (coin % 2);
        }
        return ans;
    }
}
