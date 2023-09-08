/**
 * @author Yskysoar
 * @createTime 2023-03-14 23:44
 * @description 1664. 生成平衡数组的方案数
 *给你一个整数数组  。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。nums
 *
 * 比方说，如果  ，那么：nums = [6,1,7,4,1]
 *
 * 选择删除下标 ，剩下的数组为  。1nums = [6,7,4,1]
 * 选择删除下标  ，剩下的数组为  。2nums = [6,1,4,1]
 * 选择删除下标  ，剩下的数组为  。4nums = [6,1,7,4]
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 *
 * 请你返回删除操作后，剩下的数组  是 平衡数组 的 方案数 。nums
 * 示例 1：
 *
 * 输入：nums = [2,1,6,4]
 * 输出：1
 * 解释：
 * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
 * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
 * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
 * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
 * 只有一种让剩余数组成为平衡数组的方案。
 * 示例 2：
 *
 * 输入：nums = [1,1,1]
 * 输出：3
 * 解释：你可以删除任意元素，剩余数组都是平衡数组。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：不管删除哪个元素，剩下数组都不是平衡数组。
 *
 */
public class Solution1664 {
    public static void main(String[] args) {
        Solution1664 solution1664 = new Solution1664();
        int ans = solution1664.waysToMakeFair2(new int[]{2,1,6,4});
        System.out.println(ans);
    }

    /**
     * 寻找平衡方案：类似暴力循环，且时间复杂度太高，会超时
     * @param nums 要查询平衡数的数组
     * @return 平衡方案数
     */
    public int waysToMakeFair1(int[] nums) {
        int ans = 0;//平衡方案数
        int[] num = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            int oddSum = 0;//奇数和
            int evenSum = 0;//偶数和
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
//                    System.arraycopy(nums, j, num, index, 1);
                    num[index] = nums[j];
                    if (index % 2 != 0) {
                        oddSum += num[index];
                    } else {
                        evenSum += num[index];
                    }
                    index++;
                }
            }//复制数组并计数
            if (oddSum == evenSum) ans++;
        }
        return ans;
    }

    /**
     * 设置常量来维护前后缀，不需要每次都计算前后缀，只需要消除掉需要删除的数据即可
     * @param nums 要查询平衡数的数组
     * @return 平衡方案数
     */
    public int waysToMakeFair2(int[] nums) {
        int ans = 0;//平衡方案数
        int oddSum = 0;//奇数后缀和
        int evenSum = 0;//偶数后缀和
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                oddSum += nums[i];
            } else {
                evenSum += nums[i];
            }
        }
        int oddFront = 0;//奇数前缀和
        int evenFront = 0;//偶数前缀和
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
                oddSum -= nums[i];
            } else {
                evenSum -= nums[i];
            }//当前位置被删除，对应和也要删除

            if (oddFront + evenSum == evenFront + oddSum) {
                ans++;
            }//当前位置删除后，后面位置的奇偶性就反转了

            if (i % 2 != 0) {
                oddFront += nums[i];
            } else {
                evenFront += nums[i];
            }//将当前位置记录前缀和，当前位置及其之前元素在下一次循环时奇偶性不变
        }
        return ans;
    }

    /**
     * 从start开始的隔项和
     * @param num 数据数组
     * @param start 起点
     * @return 隔项和
     */
    public int Sum(int[] num, int start) {
        int ans = 0;
        for (int i = start; i < num.length; i += 2) {
            ans += num[i];
        }
        return ans;
    }


}
