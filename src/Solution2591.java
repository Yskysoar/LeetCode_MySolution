/**
 * @author Yskysoar
 * @createTime 2023-09-22 22:06
 * @description 2591.将钱分给最多的儿童
 * 给你一个整数 money ，表示你总共有的钱数（单位为美元）和另一个整数 children ，表示你要将钱分配给多少个儿童。
 * 你需要按照如下规则分配：
 * 所有的钱都必须被分配。
 * 每个儿童至少获得 1 美元。
 * 没有人获得 4 美元。
 * 请你按照上述规则分配金钱，并返回 最多 有多少个儿童获得 恰好 8 美元。如果没有任何分配方案，返回 -1 。
 * 示例 1：
 * 输入：money = 20, children = 3
 * 输出：1
 * 解释：
 * 最多获得 8 美元的儿童数为 1 。一种分配方案为：
 * - 给第一个儿童分配 8 美元。
 * - 给第二个儿童分配 9 美元。
 * - 给第三个儿童分配 3 美元。
 * 没有分配方案能让获得 8 美元的儿童数超过 1 。
 * 示例 2：
 * 输入：money = 16, children = 2
 * 输出：2
 * 解释：每个儿童都可以获得 8 美元。
 */
public class Solution2591 {
    public static void main(String[] args) {
        Solution2591 solution2591 = new Solution2591();
        int ans = solution2591.distMoney(4, 1);
        System.out.println(ans);
    }

    /**
     * 贪心算法：先保证每个孩子都有至少一美元，然后不断分配7美元直到无法分配，考虑几种情况：
     * 1.最后一次钱不够7美元且还有孩子
     * 1.1钱数为3 且 只有一个孩子剩余，需要将借助一个已经8美元的孩子分配防止4美元出现
     * 1.2钱数不为3，直接把剩余的钱全部给一个孩子即可
     * 2.每个孩子都分配了但是还有钱，将钱全部给随机一个孩子即可
     * @param money    总钱数
     * @param children 儿童数量
     * @return 按照要求分配的最大儿童数量
     */
    public int distMoney(int money, int children) {
        if (money < children) return -1;//不够分配任何一个8美元
        int ans = 0;
        money -= children;//此时每一个孩子都有至少1美元
        while (children > 0 && money >= 7) {
            money -= 7;
            ans++;
            children--;
        }
        if ((children == 1 && money == 3) || (children == 0 && money > 0)) ans--;
        return ans;
    }
}
