/**
 * @author Yskysoar
 * @createTime 2025-07-31 0:26
 * @description 2683. 相邻值的按位异或
 * 下标从 0 开始、长度为 n 的数组 derived 是由同样长度为 n 的原始 二进制数组 original 通过计算相邻值的 按位异或（⊕）派生而来。
 * 特别地，对于范围 [0, n - 1] 内的每个下标 i ：
 * 如果 i = n - 1 ，那么 derived[i] = original[i] ⊕ original[0]
 * 否则 derived[i] = original[i] ⊕ original[i + 1]
 * 给你一个数组 derived ，请判断是否存在一个能够派生得到 derived 的 有效原始二进制数组 original 。
 * 如果存在满足要求的原始二进制数组，返回 true ；否则，返回 false 。
 * 二进制数组是仅由 0 和 1 组成的数组。
 * 示例 1：
 * 输入：derived = [1,1,0]
 * 输出：true
 * 解释：能够派生得到 [1,1,0] 的有效原始二进制数组是 [0,1,0] ：
 * derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1
 * derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1
 * derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0
 * 示例 2：
 * 输入：derived = [1,1]
 * 输出：true
 * 解释：能够派生得到 [1,1] 的有效原始二进制数组是 [0,1] ：
 * derived[0] = original[0] ⊕ original[1] = 1
 * derived[1] = original[1] ⊕ original[0] = 1
 * 示例 3：
 * 输入：derived = [1,0]
 * 输出：false
 * 解释：不存在能够派生得到 [1,0] 的有效原始二进制数组。
 * 提示：
 * n == derived.length
 * 1 <= n <= 10^5
 * derived 中的值不是 0 就是 1
 */
public class Solution2683 {

    /**
     * 模拟：题目表示的按位异或是原数组循环操作，尾元素使用（i + 1）% derived.length减少特殊处理即可
     * original[i] 与 original[i + 1]的值，根据derived[i]决定，为1则两者不同，为0两者则相同
     * @param derived 按位异或数组
     * @return 是否存在原数组
     */
    public boolean doesValidArrayExist1(int[] derived) {
        int[] original = new int[derived.length];
        for (int i = 0; i < derived.length; i++) {//假设original第一个元素为0，尾元素防止特殊处理使用（i + 1）% derived.length
            if (derived[i] == 1) {//original[i] 与 original[i + 1] 不同
                original[(i + 1) % original.length] = 1 - original[i];
            } else if (derived[i] == 0) {//original[i] 与 original[i + 1] 相同
                original[(i + 1) % original.length] = original[i];
            }
        }//循环一遍后，如果第一个元素不为0，则说明合法数组不存在
        return original[0] == 0;
    }

    /**
     * 每个元素original[i]都被使用了两次，因此把所有的方程original[i]^original[(i+1) % derived.length] = derived[i]异或起来
     * 等式两边会得到0，只要derived数组的异或和不为0，就说明异或方程组无解
     * @param derived 按位异或数组
     * @return 该按位异或数组是否合法
     */
    public boolean doesValidArrayExist2(int[] derived) {
        int xor = 0;
        for (int x : derived) {
            xor ^= x;
        }
        return xor == 0;
    }
}
