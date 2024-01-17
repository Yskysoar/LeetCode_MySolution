import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-04-03 13:26
 * @description 1053. 交换一次的先前排列
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 * 如果无法这么操作，就请返回原数组。
 * 示例 1：
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 */
public class Solution1053 {
    public static void main(String[] args) {
        Solution1053 solution1053 = new Solution1053();
        int[] ans = solution1053.prevPermOpt1(new int[]{1, 9, 6, 7, 9, 6, 4, 4, 2, 2, 7, 7, 7, 6, 3, 5, 7, 7, 3, 8, 8, 4, 4, 1, 5, 4, 7, 4, 7, 3, 7, 5, 4, 1, 7, 4, 9, 6, 5, 9, 8, 9, 9, 4, 6, 6, 5, 5, 7, 7, 8, 1, 4, 6, 4, 5, 4, 4, 8, 9, 5, 7, 2, 4});
        System.out.println(Arrays.toString(ans));
    }


    /**
     * 寻找交换影响最小的值：
     * 1.因为要寻找交换后小于原数组，要交换的两个数必须左边的数大于右边的数，也就是降序
     * 2.要交换后还是最大值，就是交换后越接近原数组，也就是交换后影响最小
     * 3.数位越靠后的数交换影响越小，所以我们要从倒序开始查找；两个数越靠近，交换产生的影响越小
     * 4.从倒序寻找到第一个降序后，在这个数的右边寻找小于它的最大值，这个最大值越靠近它越好
     * @param arr 待处理数组
     * @return 处理后的数组
     */
    public int[] prevPermOpt1(int[] arr) {
        int start = -1;
        int end = arr.length - 1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] > arr[i]) {
                start = i - 1;
                break;
            }
        }
        if (start == -1) return arr;
        int maxIndex = 0;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[start] && arr[i] > maxIndex) {
                maxIndex = arr[i];
                end = i;
            }
        }
        arr[start] ^= arr[end];
        arr[end] ^= arr[start];
        arr[start] ^= arr[end];
        return arr;
    }
}
