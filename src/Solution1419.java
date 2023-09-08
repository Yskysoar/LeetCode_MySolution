import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-05-07 0:01
 * @description 1419. 数青蛙
 *
 * 给你一个字符串 ，它表示不同青蛙发出的蛙鸣声（字符串 ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以  中会混合多个 。croakOfFrogs"croak"croakOfFrogs“croak”
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * 要想发出蛙鸣 “croak”，青蛙必须 依序 输出 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 不是由若干有效的 “croak” 字符混合而成，请返回 。‘c’, ’r’, ’o’, ’a’, ’k’croakOfFrogs-1
 * 示例 1：
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * 示例 2：
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * 示例 3：
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 */
public class Solution1419 {
    public static void main(String[] args) {
        Solution1419 solution1419 = new Solution1419();
        int ans = solution1419.minNumberOfFrogs("croakcroak");
        System.out.println(ans);
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] nums = new int[5];
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            switch (croakOfFrogs.charAt(i)) {
                case 'c' -> {
                    if (nums[4] != 0) nums[4]--;
                    nums[0]++;
                }
                case 'r' -> {
                    if (nums[0] == 0) return -1;
                    nums[0]--;
                    nums[1]++;
                }
                case 'o' -> {
                    if (nums[1] == 0) return -1;
                    nums[1]--;
                    nums[2]++;
                }
                case 'a' -> {
                    if (nums[2] == 0) return -1;
                    nums[2]--;
                    nums[3]++;
                }
                case 'k' -> {
                    if (nums[3] == 0) return -1;
                    nums[3]--;
                    nums[4]++;
                }
            }
        }
        return (nums[0] == 0 && nums[1] == 0 && nums[2] == 0 && nums[3] == 0) ? nums[4] : -1;
    }
}
