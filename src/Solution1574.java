/**
 * @author Yskysoar
 * @createTime 2023-03-25 18:55
 * @description 1574. 删除最短的子数组使剩余数组有序
 *给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * 一个子数组指的是原数组中连续的一个子序列。
 * 请你返回满足题目要求的最短子数组的长度。
 * 示例 1：
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * 示例 2：
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * 示例 3：
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * 示例 4：
 * 输入：arr = [1]
 * 输出：0
 *
 */
public class Solution1574 {
    public static void main(String[] args) {
        Solution1574 solution1574 = new Solution1574();
        int ans = solution1574.findLengthOfShortestSubarray(new int[]{1, 2, 3});
        System.out.println(ans);
    }

    public int findLengthOfShortestSubarray(int[] arr) {//前缀的最后一个元素小于等于后缀的第一个元素
        int head = 0;//头指针
        int tail = arr.length - 1;//尾指针
        //两边查询非递减数列的最长子数组
        while (head < arr.length - 2 && arr[head] <= arr[head + 1]) head++;
        while (tail > 0 && arr[tail - 1] <= arr[tail]) tail--;
        if (head >= tail) {
            return 0;
        } else if (arr[head] <= arr[tail]) {
            return tail - head - 1;
        } else {
            int  temp = arr.length - 1;
            int  min = arr.length - 1;//记录最小长度
            for (int i = head; i >= 0 && temp >= tail; i--) {
                while (temp >= tail && arr[temp] >= arr[i]) {
                    temp--;//寻找后缀元素小于前缀最后一个数的位置
                }//循环结束时，temp的位置后一位就是要后缀的第一个位置
                min = Math.min(min, temp - i);//比较删除的长度
            }
            return Math.min(min, tail);
        }
    }
}



























