/**
 * @author Yskysoar
 * @createTime 2023-02-16 11:22
 * @description 1250. 检查「好数组」
 * 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
 * 假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 * 示例 1
 * 输入：nums = [12,5,7,23]
 * 输出：true
 * 解释：挑选数字 5 和 7。
 * 5*3 + 7*(-2) = 1
 * 示例 2：
 * 输入：nums = [29,6,10]
 * 输出：true
 * 解释：挑选数字 29, 6 和 10。
 * 29*1 + 6*(-3) + 10*(-1) = 1
 * 示例 3：
 * 输入：nums = [3,6]
 * 输出：false
 */
public class Solution1250 {
    public static void main(String[] args) {
        Solution1250 solution1250 = new Solution1250();
        boolean res = solution1250.isGoodArray(new int[]{12, 8, 5, 7, 23});
        System.out.println(res);
    }

    /**
     * 贝祖定理(ax+by=1，那么当且仅当a和b互质；推广可得：只要未知数的系数相互互质，那么等式等于1一定有解)
     * @param nums 整数数组
     * @return 是否存在好数组
     */
    public boolean isGoodArray(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = gcd(res, num);
            if (res == 1) return true;
        }
        return false;
    }

    /**
     * 求两个数的最大公因数
     * @param a 数a
     * @param b 数b
     * @return 最大公因数(如果是1 ， 那么两个数互质)
     */
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);//b等于0说明上一次递归调用的时候b是a的整数倍
    }
}
