/**
 * @author Yskysoar
 * @createTime 2025-08-06 0:15
 * @description 3479. 水果成篮 III
 * 给你两个长度为 n 的整数数组，fruits 和 baskets，其中 fruits[i] 表示第 i 种水果的 数量，baskets[j] 表示第 j 个篮子的 容量。
 * 你需要对 fruits 数组从左到右按照以下规则放置水果：
 * 每种水果必须放入第一个 容量大于等于 该水果数量的 最左侧可用篮子 中。
 * 每个篮子只能装 一种 水果。
 * 如果一种水果 无法放入 任何篮子，它将保持 未放置。
 * 返回所有可能分配完成后，剩余未放置的水果种类的数量。
 * 示例 1
 * 输入： fruits = [4,2,5], baskets = [3,5,4]
 * 输出： 1
 * 解释：
 * fruits[0] = 4 放入 baskets[1] = 5。
 * fruits[1] = 2 放入 baskets[0] = 3。
 * fruits[2] = 5 无法放入 baskets[2] = 4。
 * 由于有一种水果未放置，我们返回 1。
 * 示例 2
 * 输入： fruits = [3,6,1], baskets = [6,4,7]
 * 输出： 0
 * 解释：
 * fruits[0] = 3 放入 baskets[0] = 6。
 * fruits[1] = 6 无法放入 baskets[1] = 4（容量不足），但可以放入下一个可用的篮子 baskets[2] = 7。
 * fruits[2] = 1 放入 baskets[1] = 4。
 * 由于所有水果都已成功放置，我们返回 0。
 * 提示：
 * n == fruits.length == baskets.length
 * 1 <= n <= 10^5
 * 1 <= fruits[i], baskets[i] <= 10^9
 */
public class Solution3479 {
    public static void main(String[] args) {
        Solution3479 solution3479 = new Solution3479();
        int ans = solution3479.numOfUnplacedFruits(new int[]{55, 100, 10, 88}, new int[]{34, 20, 10, 74});
        System.out.println(ans);
    }

    /**
     * 分治法
     * 将篮子分为块长度n^(1/2)的baskets.length/n^(1/2) + 1块并记录块内最大值
     * 对于每一个fruit，先找到合适的块，再从块内找到合适的位置并且更新块内最大值，否则没有合法的位置分配
     * @param fruits  每一种水果的数量
     * @param baskets 每一个篮子的容量
     * @return 无法分配的水果种类数量
     */
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = fruits.length;
        int length = (int) Math.sqrt(fruits.length);
        int[] blockMax = new int[baskets.length / length + 1];//double转int有减少
        for (int i = 0; i < fruits.length; i++) {
            blockMax[i / length] = Math.max(baskets[i], blockMax[i / length]);
        }//获取每块最大值
        for (int fruit : fruits) {
            int index = -1;
            for (int j = 0; j < blockMax.length; j++) {//找到合适的块
                if (blockMax[j] >= fruit) {
                    index = j;
                    break;
                }
            }
            if (index == -1) continue;//没有合适的块直接结束
            for (int k = 0; index * length + k < baskets.length && k < length; k++) {//查找块内合法位置
                if (baskets[index * length + k] >= fruit) {
                    ans--;//找到可分配的位置
                    baskets[index * length + k] = -1;//该位置不可再用
                    blockMax[index] = -1;//更新块内最大值（即使不是使用最大值更新，统一操作）
                    for (int m = 0; index * length + m < baskets.length && m < length; m++) {
                        blockMax[index] = Math.max(baskets[index * length + m], blockMax[index]);
                    }//重新记录当前块内的最大值
                    break;
                }
            }
        }
        return ans;
    }
}
