import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Yskysoar
 * @createTime 2023-08-16 19:07
 * @description 2682.找出转圈游戏输家
 * n 个朋友在玩游戏。这些朋友坐成一个圈，按 顺时针方向 从 1 到 n 编号。
 * 从第 i 个朋友的位置开始顺时针移动 1步 会到达第 (i + 1) 个朋友的位置（1 <= i < n）
 * 而从第 n 个朋友的位置开始顺时针移动 1步 会回到第 1 个朋友的位置。
 * 游戏规则如下：
 * 第 1 个朋友接球。
 * 接着，第 1 个朋友将球传给距离他顺时针方向 k 步的朋友。
 * 然后，接球的朋友应该把球传给距离他顺时针方向 2 * k 步的朋友。
 * 接着，接球的朋友应该把球传给距离他顺时针方向 3 * k 步的朋友，以此类推。
 * 换句话说，在第 i 轮中持有球的那位朋友需要将球传递给距离他顺时针方向 i * k 步的朋友。
 * 当某个朋友第 2 次接到球时，游戏结束。
 * 在整场游戏中没有接到过球的朋友是 输家 。
 * 给你参与游戏的朋友数量 n 和一个整数 k ，请按升序排列返回包含所有输家编号的数组 answer 作为答案。
 * 示例 1：
 * 输入：n = 5, k = 2
 * 输出：[4,5]
 * 解释：以下为游戏进行情况：
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 2 步的玩家 —— 第 3 个朋友。
 * 2）第 3 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 2 个朋友。
 * 3）第 2 个朋友将球传给距离他顺时针方向 6 步的玩家 —— 第 3 个朋友。
 * 4）第 3 个朋友接到两次球，游戏结束。
 * 示例 2：
 * 输入：n = 4, k = 4
 * 输出：[2,3,4]
 * 解释：以下为游戏进行情况：
 * 1）第 1 个朋友接球，第 1 个朋友将球传给距离他顺时针方向 4 步的玩家 —— 第 1 个朋友。
 * 2）第 1 个朋友接到两次球，游戏结束。
 */
public class Solution2682 {
    public static void main(String[] args) {
        Solution2682 solution2682 = new Solution2682();
        int[] ans = solution2682.circularGameLosers(12, 1);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 模拟法
     * @param n 游戏人数
     * @param k 传递步数
     * @return 所有输家组成的数组
     */
    public int[] circularGameLosers(int n, int k) {
        int cycles = 1;//记录传递次数
        int index = 0;//记录传递位置
        int[] nums = new int[n];//记录接球次数
        while (++nums[index] != 2) {
            index = (index + k * cycles) % n;//成环传递
            cycles++;
        }
        List<Integer> indexList = new ArrayList<>();
        IntStream.range(0, nums.length).filter(i -> nums[i] == 0).forEach(i -> indexList.add(i + 1));//选取所有元素值为0的元素，将他们的索引+1添加到集合中
        return indexList.stream().mapToInt(Integer::intValue).toArray();
    }
}
