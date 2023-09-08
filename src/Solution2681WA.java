import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-08-01 10:34
 * @description 2681.英雄的力量
 * 给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为：
 * i0 ，i1 ，... ik 表示这组英雄在数组中的下标。
 * 那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])^2 * min(nums[i0],nums[i1] ... nums[ik]) 。
 * 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 10^9 + 7 取余。
 * 示例 1：
 * 输入：nums = [2,1,4]
 * 输出：141
 * 解释：
 * 第 1 组：[2] 的力量为 2^2 * 2 = 8 。
 * 第 2 组：[1] 的力量为 1^2 * 1 = 1 。
 * 第 3 组：[4] 的力量为 4^2 * 4 = 64 。
 * 第 4 组：[2,1] 的力量为 2^2 * 1 = 4 。
 * 第 5 组：[2,4] 的力量为 4^2 * 2 = 32 。
 * 第 6 组：[1,4] 的力量为 4^2 * 1 = 16 。
 * 第7 组：[2,1,4] 的力量为 4^2 * 1 = 16 。
 * 所有英雄组的力量之和为 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141 。
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：7
 * 解释：总共有 7 个英雄组，每一组的力量都是 1 。所以所有英雄组的力量之和为 7 。
 */
public class Solution2681WA {
    public static void main(String[] args) {
        Solution2681WA solution2681WA = new Solution2681WA();
        int ans = solution2681WA.sumOfPower(new int[]{658,489,777,2418,1893,130,2448,178,1128,2149,1059,1495,1166,608,2006,713,1906,2108,680,1348,860,1620,146,2447,1895,1083,1465,2351,1359,1187,906,533,1943,1814,1808,2065,1744,254,1988,1889,1206});
        System.out.println(ans);
    }


    /**
     * 遍历非空子集(取模精度有问题)
     * @param nums 英雄合集
     * @return 非空英雄组的力量之和
     */
    public int sumOfPower(int[] nums) {
        long ans = 0;
        int MOD = 1000000007;
        List<List<Integer>> allNoEmptySubsets = getAllNoEmptySubsets(nums);
        for (List<Integer> subset : allNoEmptySubsets) {
            int max = Collections.max(subset);
            int min = Collections.min(subset);
            long power = ((long) max * max % MOD) * min % MOD; // 计算力量，并确保不溢出
            ans = (ans + power) % MOD; // 对每个中间结果进行取模操作，确保不溢出
        }
        return (int) ans; // 最终结果转为 int 类型并返回
    }


    /**
     * 获取所有非空子集
     * @param nums 数据全集
     * @return 一个存放所有非空子集的集合
     */
    public List<List<Integer>> getAllNoEmptySubsets(int[] nums) {
        int totalSubsetsNum = (1 << nums.length) - 1;//2^n - 1是所有非空子集的数量
        List<List<Integer>> subsetsRes = new ArrayList<>();
        for (int i = 1; i <= totalSubsetsNum; i++) {//i=0时代表空集，本题不需要空集
            List<Integer> currentSubset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {//检查当前选中了哪些元素
                if ((i & (1 << j)) != 0) {//二进制判断是否选取，例如：110表示选取nums[2]和nums[1]
                    currentSubset.add(nums[j]);
                }
            }
            subsetsRes.add(currentSubset);
        }
        return subsetsRes;
    }
}
